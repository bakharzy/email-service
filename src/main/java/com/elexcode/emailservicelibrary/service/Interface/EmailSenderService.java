/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service.Interface;

import com.elexcode.emailservicelibrary.entity.EmailObject;

/**
 *
 * @author mohi
 */


public interface EmailSenderService {

    public void sendEmail(EmailObject emailObject, String host, int port, String username, String password) throws Exception;

}
