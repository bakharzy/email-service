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
    
    
    
    public EmailObjectBuilder() {
        
    }
    
    public EmailObject createEmailObject(String[] recipients, String subject, String htmlMsg){
        EmailObject emailObject = new EmailObject();
        emailObject.setRecipients(recipients);
        emailObject.setSubject(subject);
        emailObject.setHtmlMsg(htmlMsg);
        return emailObject;
    }
    
    
}