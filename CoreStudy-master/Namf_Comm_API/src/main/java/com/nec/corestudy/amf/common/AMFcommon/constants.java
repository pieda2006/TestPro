package com.nec.corestudy.amf.common.AMFcommon;

public final class constants {
    private constants(){}

    /* result Code */
    public static final int Jamf_OK = 0;
    public static final int Jamf_NG = -1;


    /* Request Type */
    public static final String Jamf_REGISTRATION            = "0";
    public static final String Jamf_PDUSESSIONESTABLISHMENT = "1";

    /* N1N2message transfer reqType */
    public static final int Jamf_PDUSESESTABLISHMENT = 0;
    public static final int Jamf_PDUSESRELEASE       = 1;


    /* Communication Type */
    public static final String Jamf_COMM_N1N2TRANSFER       = "0";

}

