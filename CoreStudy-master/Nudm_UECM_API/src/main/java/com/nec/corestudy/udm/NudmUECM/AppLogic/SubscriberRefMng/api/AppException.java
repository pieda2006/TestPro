package com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api;

public class AppException extends Exception{
    private int code;
    public AppException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}


