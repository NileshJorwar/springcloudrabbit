package com.nilesh.retryableannotation.services;

import org.springframework.stereotype.Service;

@Service
public class RetryService {

    public void tryRetryMethod()
    {
        System.out.println("No exception hence called once");
    }

    public void tryRetryMethodforNFE(String number)
    {
        Integer.parseInt(number);
        System.out.println("In tryRetryMethodforNFE");
    }
    public void tryRetryMethodforNPE(String st)
    {
        st.length();
        System.out.println("tryRetryMethodforNPE");

    }
    public String recoverNFE(NumberFormatException ex){
        System.out.println("Recover method-- Number format exception");
        return "Recover method-- Number format exception";
    }
    public String recoverNPE(NullPointerException ex){
        System.out.println("Recover method-- NullPointer exception");
        return "Recover method-- Null Pointer exception";
    }
}
