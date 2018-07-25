package com.nec.corestudy.smf.Service.IP_Mng;

import com.nec.corestudy.smf.Repository.phpipam_API_client.*;
import com.nec.corestudy.smf.Repository.phpipam_API_client.auth.*;
import com.nec.corestudy.smf.Repository.phpipam_API_client.model.*;
import com.nec.corestudy.smf.Repository.phpipam_API_client.api.AddressesApi;
import com.nec.corestudy.smf.Repository.phpipam_API_client.api.AuthenticationApi;
import com.nec.corestudy.smf.Repository.phpipam_API_client.api.SectionsApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class Phpipam_Send extends Phpipam_IF{

  private static Phpipam_Send instance = new Phpipam_Send();

  private String username;
  private String password;
  private String token;
  private String baseurl;

  private List<SectionsDataData> section_list = new ArrayList<SectionsDataData>();

  private ApiClient defaultClient = Configuration.getDefaultApiClient();

  /*--------------------------------------*/
  /* [subnet_map]                         */
  /*   key:SubnetName                     */
  /*   value:SubnetID,(SubnetName)        */
  /*--------------------------------------*/
  private Map<String, SubnetsDataData> subnet_map = new HashMap<String, SubnetsDataData>();


  private Phpipam_Send(){

    // Configure HTTP basic authorization: id_pass
    HttpBasicAuth id_pass = (HttpBasicAuth) defaultClient.getAuthentication("id_pass");
    username = System.getenv("PHPIPAM_USERNAME");
    System.out.println("PHPIPAM_USERNAME" + username);
    password = System.getenv("PHPIPAM_PASSWORD");
    System.out.println("PHPIPAM_PASSWORD" + password);
    id_pass.setUsername(username);
    id_pass.setPassword(password);

    baseurl = System.getenv("PHPIPAM_BASEURL");
    System.out.println("PHPIPAM_BASEURL" + baseurl);

    // Authentication Start(Token Get)
    AuthenticationTokenGet();

    // SectionIDList Get
    SectionsApi section_api = new SectionsApi();
    section_api.getApiClient().setBasePath(baseurl);
    try {
      SectionsData sec_data = section_api.sections();
      section_list = sec_data.getData();
    } catch (ApiException e) {
      System.err.println("Exception when calling #sections()");
      e.printStackTrace();
    }

    // SubnetIDList Get
    int i=0;
    int j=0;

    try {
      for(i=0;i<section_list.size();i++){
        SubnetsData subnet_data = section_api.subnetsInSection(section_list.get(i).getId());
        for(j=0;j<subnet_data.getData().size();j++){
          subnet_map.put(subnet_data.getData().get(j).getDescription(),
                         subnet_data.getData().get(j));
        }
      }

    } catch (ApiException e) {
      System.err.println("Exception when calling #subnetsInSection()");
      e.printStackTrace();
    }

  }

  @Override
  public AllocateIPinfo SubnetFirstfreePost(String subnet_name, String Supi, int PDUSessionID) {

    // createsNewAddressInSubnets()
    AddressesApi addresses_api = new AddressesApi();
    addresses_api.getApiClient().setBasePath(baseurl);

    CreateNewAddressData body = new CreateNewAddressData();
    Phpipam_AddrNote note = new Phpipam_AddrNote();

    body.setOwner(Supi);
    note.PDUSessionID = PDUSessionID;

    // Java Obj -> JSON String
    try {
      ObjectMapper mapper = new ObjectMapper();
      String json = mapper.writeValueAsString(note);
      body.setNote(json);
    } catch (JsonProcessingException je) {
      System.err.println("Exception when calling jackson#mapper.writeValueAsString()");
      je.printStackTrace();
    }

    Integer subnetID = subnet_map.get(subnet_name).getId();

    int retry_flg = 1;
    for(;;)
    {
      try {
        SubnetsAddressData addr_data = addresses_api.createsNewAddressInSubnets(subnetID, body);

        AllocateIPinfo ipinfo = new AllocateIPinfo();
        ipinfo.ipaddr = addr_data.getData();
        ipinfo.teid = addr_data.getId();
        ipinfo.mask = subnet_map.get(subnet_name).getMask();
        ipinfo.subnet_name = subnet_name;

        return ipinfo;
      }
      catch (ApiException e) {
        System.err.println("Exception when calling #SubnetFirstfreePost()");
        if( 401 == e.getCode() && 1 == retry_flg ){
          retry_flg = 0;
          AuthenticationTokenGet();
        }
        else{
          e.printStackTrace();
          return null;
        }
      }
    }
  }

  @Override
  public void DeleteAddress(AllocateIPinfo ip_info) {

    // createsNewAddressInSubnets()
    AddressesApi addresses_api = new AddressesApi();
    addresses_api.getApiClient().setBasePath(baseurl);

    int retry_flg = 1;
    for(;;)
    {
      try {
        DeleteAddressData result = addresses_api.deletesAddress(ip_info.teid);
        return;
      }
      catch (ApiException e) {
        System.err.println("Exception when calling #SubnetFirstfreePost()");
        if( 401 == e.getCode() && 1 == retry_flg ){
          retry_flg = 0;
          AuthenticationTokenGet();
        }
        else{
          e.printStackTrace();
          return;
        }
      }
    }

  }

  private void AuthenticationTokenGet()
  {
    AuthenticationApi auth_api = new AuthenticationApi();
    auth_api.getApiClient().setBasePath(baseurl);
    try {
      AuthenticationToken Tokendata = auth_api.authentication();

      token = Tokendata.getData().getToken();
      ApiKeyAuth api_token = (ApiKeyAuth) defaultClient.getAuthentication("api_token");
      api_token.setApiKey(token);
    } catch (ApiException e) {
      System.err.println("Exception when calling #AuthenticationTokenGet()");
      e.printStackTrace();
    }
  }


  public static Phpipam_Send getInstance(){
    return instance;
  }

}
