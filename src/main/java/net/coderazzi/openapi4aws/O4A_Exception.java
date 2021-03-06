package net.coderazzi.openapi4aws;

public class O4A_Exception extends RuntimeException {
    public O4A_Exception(String msg) {
        super(msg);
    }

    public static O4A_Exception invalidType(String location) {
        return new O4A_Exception("unexpected openapi type on " + location);
    }

}
