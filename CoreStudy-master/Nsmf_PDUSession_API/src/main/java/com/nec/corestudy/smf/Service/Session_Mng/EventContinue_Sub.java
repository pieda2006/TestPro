package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;


public class EventContinue_Sub implements Runnable {

    private int event_type;
    private SMContext_Internal context_in;

    public EventContinue_Sub(int event_type, SMContext_Internal context_in) {
        this.event_type = event_type;
        this.context_in = context_in;
    }

    public void run() {
//        System.out.println("EventContinue スレッド処理");

        switch (event_type) {
            case 1: /* N4 Session Establishment(kari) */
                UPFSession_Initial upfses_ini = new UPFSession_Initial();
                upfses_ini.execute(context_in);
                break;
            default:
                break;
        }
    }
}


