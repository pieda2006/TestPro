package com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmSDM.common.api.SmfSelectionSubscriptionData.SmfSelectionSubscriptionDataAccess;
import com.nec.corestudy.udm.NudmSDM.common.model.SmfSelectionSubscriptionDataDB;

import com.nec.corestudy.udm.NudmSDM.model.SmfSelectionSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.SnssaiInfo;
import com.nec.corestudy.udm.NudmSDM.model.Snssai;
import com.nec.corestudy.udm.NudmSDM.model.DnnInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


@Service
public class SmfSelectDataCtl{

    private static final Logger log = LoggerFactory.getLogger(SmfSelectDataCtl.class);

    @Autowired
    private SmfSelectionSubscriptionDataAccess SmfDataAccess;

    // Nudm_SDM
//    private SmfSelectionSubscriptionData retSmfData = new SmfSelectionSubscriptionData();

    // method
    public SmfSelectionSubscriptionData getData(String InputSupi) {
        log.debug( "getData is Called" );
        log.debug( "InputSupi : " + InputSupi );

        // getData API
        SmfSelectionSubscriptionDataDB SmfData = SmfDataAccess.getData( InputSupi );

        log.debug("getData : " + SmfData.toString() );

        SmfSelectionSubscriptionData retSmfData = new SmfSelectionSubscriptionData();

        // DB SmfData -> ret SmfData
        // SupportedFeatures
        retSmfData.supportedFeatures(new String() );
        retSmfData.setSupportedFeatures( SmfData.getSupportedFeatures() );

        // subscribedSnssaiInfo
        List<SnssaiInfo> subscribedSnssaiInfo = new ArrayList<SnssaiInfo>();

        for(int i = 0; i < SmfData.getSubscribedSnssaiInfo().size() ; i++ )
        {

            subscribedSnssaiInfo.add(new SnssaiInfo() );

            //   singleNssai
            Snssai singleNssais = new Snssai();
            singleNssais.setSst( SmfData.getSubscribedSnssaiInfo().get(i).getSingleNssai().getSst() );
            singleNssais.setSd ( SmfData.getSubscribedSnssaiInfo().get(i).getSingleNssai().getSd() );

            //   dnnInfos
            List<DnnInfo> dnnInfoList = new ArrayList<DnnInfo>();

            for(int j = 0; j < SmfData.getSubscribedSnssaiInfo().get(i).getDnnInfos().size() ; j++)
            {
                dnnInfoList.add( new DnnInfo() );
                dnnInfoList.get(j).setDnn( new String( SmfData.getSubscribedSnssaiInfo().get(i).getDnnInfos().get(j).getDnn() ) );
                dnnInfoList.get(j).setDefaultDnnIndicator( new Boolean( SmfData.getSubscribedSnssaiInfo().get(i).getDnnInfos().get(j).isDefaultDnnIndicator()) );
                dnnInfoList.get(j).setLboRoamingAllowed( new Boolean( SmfData.getSubscribedSnssaiInfo().get(i).getDnnInfos().get(j).isLboRoamingAllowed()) );
            }

            subscribedSnssaiInfo.get(i).setSingleNssai( singleNssais );
            subscribedSnssaiInfo.get(i).setDnnInfos( dnnInfoList );

        }
        retSmfData.setSubscribedSnssaiInfo( subscribedSnssaiInfo );

        log.debug("return SmfData : " + retSmfData.toString() );

        return retSmfData;

    }

    public void setData(String InputAmData){
        log.debug("setData is Called");
        log.debug("InputAmData : " + InputAmData);

        // ffs

    }

}


