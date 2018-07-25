package com.nec.corestudy.smf.Service.IP_Mng;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class IPMngTable {

    /*--------------------------------------*/
    /* [NSSAI_SUBNET_TABLE]                 */
    /*  key:sNssai->sst  value:Subnet Name  */
    /*--------------------------------------*/
    public static final Map<Integer, String> NSSAI_SUBNET_TABLE;
    static {
        Map<Integer, String> map = new HashMap<Integer, String>();

        /*-[Table Start]-------------------------*/
        /*                                       */
        map.put(1, "for_vpp");
        /*                                       */
        /*-[Table End  ]-------------------------*/

        NSSAI_SUBNET_TABLE = Collections.unmodifiableMap(map);
    }

}
