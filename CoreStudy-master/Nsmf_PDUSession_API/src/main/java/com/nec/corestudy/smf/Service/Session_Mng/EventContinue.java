package com.nec.corestudy.smf.Service.Session_Mng;

import com.nec.corestudy.smf.Service.Session_Mng.SMContext_Internal;


public class EventContinue{

    public void exec(int event_type, SMContext_Internal context_in) {

        EventContinue_Sub sub = new EventContinue_Sub(event_type, context_in);
        Thread thread = new Thread(sub);
        thread.start();
    }
}


