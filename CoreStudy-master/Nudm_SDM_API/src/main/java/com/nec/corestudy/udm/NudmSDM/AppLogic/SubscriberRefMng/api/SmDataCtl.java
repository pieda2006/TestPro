package com.nec.corestudy.udm.NudmSDM.AppLogic.SubscriberRefMng.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.nec.corestudy.udm.NudmSDM.common.api.SessionManagementSubscriptionData.SessionManagementSubscriptionDataAccess;
import com.nec.corestudy.udm.NudmSDM.common.model.SessionManagementSubscriptionDataDB;

import com.nec.corestudy.udm.NudmSDM.model.SessionManagementSubscriptionData;
import com.nec.corestudy.udm.NudmSDM.model.Snssai;
import com.nec.corestudy.udm.NudmSDM.model.DnnConfiguration;
import com.nec.corestudy.udm.NudmSDM.model.PduSessionTypes;
import com.nec.corestudy.udm.NudmSDM.model.SscModes;
import com.nec.corestudy.udm.NudmSDM.model.Model5GQosProfile;
import com.nec.corestudy.udm.NudmSDM.model.Arp;
import com.nec.corestudy.udm.NudmSDM.model.Ambr;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

@Service
public class SmDataCtl{

    private static final Logger log = LoggerFactory.getLogger(SmDataCtl.class);

    @Autowired
    private SessionManagementSubscriptionDataAccess SmDataAccess;

    // Nudm_SDM
//    private List<SessionManagementSubscriptionData> retSmData = null;

    // method
    public List<SessionManagementSubscriptionData> getData(String InputSupi){
        log.debug( "getData is Called" );
        log.debug( "InputSupi : " + InputSupi );

        List<SessionManagementSubscriptionData> retSmData = null;

        retSmData = new ArrayList<SessionManagementSubscriptionData>();

        // getData API
        List<SessionManagementSubscriptionDataDB> SmData = SmDataAccess.getData( InputSupi );

//        for ( Iterator it = SmData.iterator() ; it.hasNext() ;){
//            log.debug("getData : " + it.next() );
//        }

        for(int i = 0; i < SmData.size(); i++)
        {

            retSmData.add(new SessionManagementSubscriptionData());

            // singleNssai
            retSmData.get(i).setSingleNssai(new Snssai());
            retSmData.get(i).getSingleNssai().setSst( SmData.get(i).getSingleNssai().getSst() );
            retSmData.get(i).getSingleNssai().setSd ( SmData.get(i).getSingleNssai().getSd() );

            // dnnConfiguration
            for(int j = 0; j < SmData.get(i).getDnnConfiguration().size(); j++)
            {
                retSmData.get(i).addDnnConfigurationItem(new DnnConfiguration() );

                // dnn
                if(null == SmData.get(i).getDnnConfiguration().get(j).getDnn() )
                {
                    log.debug("##### SmData.get(i).getDnnConfiguration().get(j).getDnn()) is null" + "i :" + i + "j :" + j );
                    log.debug("retSmData" + retSmData.toString() );
                    log.debug("SmData" + SmData.toString() );
                }
                retSmData.get(i).getDnnConfiguration().get(j).setDnn( new String(SmData.get(i).getDnnConfiguration().get(j).getDnn()) );

                // pduSessionTypes
                retSmData.get(i).getDnnConfiguration().get(j).setPduSessionTypes( new PduSessionTypes() );

                //   DefaultSessionType
                retSmData.get(i).getDnnConfiguration().get(j).getPduSessionTypes().setDefaultSessionType(
                        PduSessionTypes.DefaultSessionTypeEnum.fromValue(
                            SmData.get(i).getDnnConfiguration().get(j).getPduSessionTypes().getDefaultSessionType().toString() ));

                //   allowedSessionType
                for(int k = 0; k < SmData.get(i).getDnnConfiguration().get(j).getPduSessionTypes().getAllowedSessionType().size(); k++)
                {
                    retSmData.get(i).getDnnConfiguration().get(j).getPduSessionTypes().addAllowedSessionTypeItem(
                        PduSessionTypes.AllowedSessionTypeEnum.fromValue(
                            SmData.get(i).getDnnConfiguration().get(j).getPduSessionTypes().getAllowedSessionType().get(k).toString() ));
                }

                // sscModes
                retSmData.get(i).getDnnConfiguration().get(j).setSscModes( new SscModes() );

                //   defaultSscMode
                retSmData.get(i).getDnnConfiguration().get(j).getSscModes().setDefaultSscMode(
                        SscModes.DefaultSscModeEnum.fromValue(
                             SmData.get(i).getDnnConfiguration().get(j).getSscModes().getDefaultSscMode().toString() ));

                //   allowedSscMode
                for(int k = 0; k < SmData.get(i).getDnnConfiguration().get(j).getSscModes().getAllowedSscMode().size(); k++)
                {
                    retSmData.get(i).getDnnConfiguration().get(j).getSscModes().addAllowedSscModeItem(
                        SscModes.AllowedSscModeEnum.fromValue(
                            SmData.get(i).getDnnConfiguration().get(j).getSscModes().getAllowedSscMode().get(k).toString() ));
                }

                // ladnIndicator
                retSmData.get(i).getDnnConfiguration().get(j).setLadnIndicator( SmData.get(i).getDnnConfiguration().get(j).isLadnIndicator() );

                // 5gQosProfile
                retSmData.get(i).getDnnConfiguration().get(j).set5gQosProfile( new Model5GQosProfile());

                //    5qi
                retSmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().set5qi(SmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().get5qi() );

                //    Arp
                retSmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().setArp(new Arp());
                //      priorityLevel
                retSmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().setPriorityLevel(
                        SmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().getPriorityLevel() );

                //      PreemptCap
                retSmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().setPreemptCap(
                    Arp.PreemptCapEnum.fromValue(
                        SmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().getPreemptCap().toString() ));

                //      PreemptVuln
                retSmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().setPreemptVuln(
                    Arp.PreemptVulnEnum.fromValue(
                        SmData.get(i).getDnnConfiguration().get(j).get5gQosProfile().getArp().getPreemptVuln().toString() ));

                //    sessionAMBR
                retSmData.get(i).getDnnConfiguration().get(j).setSessionAMBR(new Ambr());
                retSmData.get(i).getDnnConfiguration().get(j).getSessionAMBR().setUplink(
                        new String(SmData.get(i).getDnnConfiguration().get(j).getSessionAMBR().getUplink() ));
                retSmData.get(i).getDnnConfiguration().get(j).getSessionAMBR().setDownlink(
                        new String(SmData.get(i).getDnnConfiguration().get(j).getSessionAMBR().getDownlink() ));


            }

        }


//        for ( Iterator it2 = retSmData.iterator() ; it2.hasNext() ;){
//            log.debug("getData : " + it2.next() );
//        }
        if (null == retSmData) {
            log.debug("retSmData is Null");
        }
        return retSmData;

    }

    public void setData(String InputAmData){
        log.debug("setData is Called");
        log.debug("InputAmData : " + InputAmData);

        // ffs

    }

}


