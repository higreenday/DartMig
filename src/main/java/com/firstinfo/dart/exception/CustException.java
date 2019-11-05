package com.firstinfo.dart.exception;

public class CustException extends Exception {
    
    public CustException(String msg){ 
        super(msg); 
    }
    
    public CustException(Exception ex) {
        super(ex);
    }
 
}
