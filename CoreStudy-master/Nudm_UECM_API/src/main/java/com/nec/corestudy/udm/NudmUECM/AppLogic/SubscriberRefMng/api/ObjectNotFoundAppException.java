package com.nec.corestudy.udm.NudmUECM.AppLogic.SubscriberRefMng.api;

public class ObjectNotFoundAppException extends AppException{
    private int code;
    public ObjectNotFoundAppException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}

