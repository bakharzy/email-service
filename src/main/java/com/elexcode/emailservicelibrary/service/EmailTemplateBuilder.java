/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 *
 * @author mohi
 */
public class EmailTemplateBuilder {

    Configuration config;

    Template template;

    String PREFIX_PATH = "src/main/resources/com/elexcode/emailservicelibrary/service/";
    
    Version VERSION_1 = new Version("1");

    public EmailTemplateBuilder(String htmlTemplate) throws IOException {

        this.config = new Configuration(VERSION_1);
        
        this.template = config.getTemplate(htmlTemplate);

    }

    public String getHtmlTemplate(Map data) throws IOException, TemplateException {

        Writer writer = new StringWriter();
        template.process(data, writer);
        String htmlContent = writer.toString();
        writer.flush();
        writer.close();
        return htmlContent;

    }

}
