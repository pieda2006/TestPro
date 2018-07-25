package com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmSDM.common.api.AccessAndMobilitySubscriptionData.AccessAndMobilitySubscriptionDataAccess;
import com.nec.corestudy.udm.NudmSDM.common.model.AccessAndMobilitySubscriptionDataDB;

import com.nec.corestudy.udm.NudmSDM.model.AccessAndMobilitySubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.Ambr;
import com.nec.corestudy.udm.NudmSDM.model.Nssai;
import com.nec.corestudy.udm.NudmSDM.model.Snssai;
import com.nec.corestudy.udm.NudmSDM.model.RatType;
import com.nec.corestudy.udm.NudmSDM.model.AreaRestriction;
import com.nec.corestudy.udm.NudmSDM.model.AreaInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class AmDataCtl {

    private static final Logger log = LoggerFactory.getLogger(AmDataCtl.class);

    ObjectMapper mapper = new ObjectMapper();
    String LineSep = System.getProperty("line.separator");

    // common Access data
    @Autowired
    private AccessAndMobilitySubscriptionDataAccess AmDataAccess;

    // Nudm_SDM
//    private AccessAndMobilitySubscriptionData retAmData = null;

    private String myData;

    // method
    public AccessAndMobilitySubscriptionData getData(String InputSupi){
        log.debug( "getData is Called" );
        log.debug( "InputSupi : " + InputSupi );

        AccessAndMobilitySubscriptionData retAmData = null;

        retAmData = new AccessAndMobilitySubscriptionData();

        // getData api
        AccessAndMobilitySubscriptionDataDB AmData = AmDataAccess.getData( InputSupi );

        log.debug("getData : " + AmData.toString() );

        // DB AmData -> ret Amdata

        // SupportedFeatures
        retAmData.supportedFeatures(new String() );
        retAmData.setSupportedFeatures( AmData.getSupportedFeatures() );

        // Gpsi
        retAmData.gpsi(new ArrayList<String>() );
        retAmData.setGpsi( AmData.getGpsi() );

        // InternalGroupId
        retAmData.setInternalGroupId( new ArrayList<String>() );
        retAmData.setInternalGroupId( AmData.getInternalGroupId() );

        // subscribedUeAmbr
        Ambr tmpSubUeAmbr = new Ambr();
        tmpSubUeAmbr.setUplink( AmData.getSubscribedUeAmbr().getUplink() );
        tmpSubUeAmbr.setDownlink( AmData.getSubscribedUeAmbr().getDownlink() );

        retAmData.subscribedUeAmbr(new Ambr());
        retAmData.setSubscribedUeAmbr(tmpSubUeAmbr);

        // Nssai
        //   SupportedFeatures
        Nssai tmpNssai= new Nssai();
        tmpNssai.setSupportedFeatures( AmData.getNssai().getSupportedFeatures() );

        //   defaultSingleNssais
        List<Snssai> defaultSingleNssais = new ArrayList<Snssai>();

        for(int i = 0; i < AmData.getNssai().getDefaultSingleNssais().size() ; i++ )
        {
            defaultSingleNssais.add( new Snssai()  );
            defaultSingleNssais.get(i).setSst( AmData.getNssai().getDefaultSingleNssais().get(i).getSst() );
            defaultSingleNssais.get(i).setSd ( AmData.getNssai().getDefaultSingleNssais().get(i).getSd() );

        }
        log.debug("defaultSingleNssais.toString : " + defaultSingleNssais.toString());

        tmpNssai.setDefaultSingleNssais( defaultSingleNssais );

        //   singleNssais
        List<Snssai> singleNssais = new ArrayList<Snssai>();

        for(int i = 0; i < AmData.getNssai().getSingleNssais().size() ; i++ )
        {
            singleNssais.add( new Snssai()  );
            singleNssais.get(i).setSst( AmData.getNssai().getSingleNssais().get(i).getSst() );
            singleNssais.get(i).setSd ( AmData.getNssai().getSingleNssais().get(i).getSd() );

        }
        log.debug("singleNssais.toString : " + singleNssais.toString());

        tmpNssai.setSingleNssais( singleNssais );
        retAmData.setNssai( tmpNssai );

        // ratRestriction

        for(int i = 0; i < AmData.getRatRestriction().size(); i++)
        {
            retAmData.addRatRestrictionItem( 
                AccessAndMobilitySubscriptionData.RatRestrictionEnum.fromValue(
                    AmData.getRatRestriction().get(i).toString()) );
        }
/*
        for( Iterator aIte = AmData.getRatRestriction().iterator();
             aIte.hasNext() ;){

            RatType aObj = (RatType)aIte.next();
            retAmData.addRatRestrictionItem( retAmData.getRatRestriction().fromValue(
                aObj.toString() )  );
        }
*/

        // AreaRestriction
        List<AreaRestriction> areaRestriction = new ArrayList<AreaRestriction>();
//        com.nec.corestudy.udm.NudmSDM.model.AreaRestriction tmpAR = new com.nec.corestudy.udm.NudmSDM.model.AreaRestriction();
//        com.nec.corestudy.udm.NudmSDM.model.AreaInformation tmpAI = new com.nec.corestudy.udm.NudmSDM.model.AreaInformation();


        for(int i = 0; i < AmData.getAreaRestriction().size() ; i++ )
        {
            areaRestriction.add( new AreaRestriction()  );

            // RestrictType
            areaRestriction.get(i).setRestrictionType(
                AreaRestriction.RestrictionTypeEnum.fromValue(
                    AmData.getAreaRestriction().get(i).getRestrictionType().toString() ));

            // RatType
            List<AreaRestriction.RatTypeEnum> ratTypeList = new ArrayList<AreaRestriction.RatTypeEnum>();
            for( int j =0; j < AmData.getAreaRestriction().get(i).getRatType().size(); j++ )
            {
                ratTypeList.add( AreaRestriction.RatTypeEnum.fromValue(
                     AmData.getAreaRestriction().get(i).getRatType().get(j).toString() ) );

            }
            areaRestriction.get(i).setRatType( ratTypeList );

            // AreaInformation
            //   tac
            AreaInformation areaInfo = new AreaInformation();
            for( int j=0; j < AmData.getAreaRestriction().get(i).getAreaInformation().getTac().size(); j++)
            {
                areaInfo.addTacItem( AmData.getAreaRestriction().get(i).getAreaInformation().getTac().get(j)  );
            }

            //   areaCode
            for( int j=0; j < AmData.getAreaRestriction().get(i).getAreaInformation().getTac().size(); j++)
            {
                areaInfo.addAreaCodeItem( AmData.getAreaRestriction().get(i).getAreaInformation().getAreaCode().get(j)  );
            }

            //   maxNumberTAs
            for( int j=0; j < AmData.getAreaRestriction().get(i).getAreaInformation().getTac().size(); j++)
            {
                areaInfo.addMaxNumberTAsItem( AmData.getAreaRestriction().get(i).getAreaInformation().getMaxNumberTAs().get(j)  );
            }

            areaRestriction.get(i).setAreaInformation( areaInfo );

        }
        log.debug("areaRestriction.toString : " +  areaRestriction.toString());
        retAmData.setAreaRestriction( areaRestriction );

        // coreNetworkTypeRestriction
        retAmData.setCoreNetworkTypeRestriction( AmData.getCoreNetworkTypeRestriction() );

        // rfspIndex
        retAmData.setRfspIndex( AmData.getRfspIndex() );

        // subsRegTimer
        retAmData.setSubsRegTimer( AmData.getSubsRegTimer() );

        // ueUsageType
        retAmData.setUeUsageType( AmData.getUeUsageType() );

        // ladnInformation
        retAmData.setLadnInformation( AmData.getLadnInformation() );

        // mpsPriority
        retAmData.setMpsPriority( AmData.isMpsPriority() );

        log.debug("retData : " + LineSep + retAmData.toString() );

        return retAmData;

    }

    public void setData(String InputAmData){
        log.debug("setData is Called");
        log.debug("InputAmData : " + InputAmData);

        // ffs

    }

}


