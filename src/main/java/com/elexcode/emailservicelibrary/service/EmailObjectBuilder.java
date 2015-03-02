/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service;

import com.elexcode.emailservicelibrary.entity.EmailObject;

/**
 *
 * @author mohi
 */
public class EmailObjectBuilder {
    
    EmailObject emailObject;
    
    public EmailObjectBuilder() {
        
        this.emailObject = new EmailObject();
               
    }
    
    public EmailObject createEmailObject(String[] recipients, String subject, String htmlMsg){
        
        emailObject.setRecipients(recipients);
        emailObject.setSubject(subject);
        emailObject.setHtmlMsg(htmlMsg);
        return emailObject;
    }
    
    
}