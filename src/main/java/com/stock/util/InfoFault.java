package com.stock.util;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	
    private Date errorDate;
    private String message;

    public InfoFault(String message, Date errorDate) {
        this.message = message;
        this.errorDate = errorDate;
    }

    //JAX-B precisa
    public InfoFault() {
    
    }

}