/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service;

import com.elexcode.emailservicelibrary.service.Interface.EmailValidatorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohi
 */
@Service
public class EmailValidatorServiceImpl implements EmailValidatorService{
    
//    The regrex is based on RFC2822
//    http://tools.ietf.org/html/rfc2822#section-3.4.1
//    Different regex patterns could be used depending on the needs.
    private final String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean validateEmail(String emailAddress) {
        pattern = pattern.compile(regex);
        matcher = pattern.matcher(emailAddress);
        return matcher.matches();
        
    }
    
}