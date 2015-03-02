/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service;

import com.elexcode.emailservicelibrary.entity.EmailObject;
import com.elexcode.emailservicelibrary.service.Interface.EmailSenderService;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohi
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final HtmlEmail email = new HtmlEmail();
    private String host;
    private int port;
    private String username;
    private String password;

    public EmailSenderServiceImpl() {
    }

    @Override
    public void sendEmail(EmailObject emailObject) throws Exception {
        email.setHostName(host);
        email.setSmtpPort(port);
        email.setAuthentication(username, password);
        for (String recipient : emailObject.getRecipients()) {
            email.addTo(recipient);
        }
        email.setFrom(username);
        email.setSubject(emailObject.getSubject());
        if (checkStringNotNullNotEmpty(emailObject.getHtmlMsg())) {
            email.setHtmlMsg(emailObject.getHtmlMsg());
        } else {
            if (checkStringNotNullNotEmpty(emailObject.getMessage())) {
                email.setTextMsg(emailObject.getMessage());
            }
        }
        email.setDebug(false);
        email.setTLS(true);
        email.setSSL(true);
        email.send();
    }

   
    @Override
    public void setEmailConfiguration(String host, int port, String username, String password){
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        
    }
    
     private boolean checkStringNotNullNotEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }

}