package com.elexcode.emailservicelibrary.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.elexcode.emailservicelibrary.entity.EmailObject;
import com.elexcode.emailservicelibrary.service.EmailObjectBuilder;
import com.elexcode.emailservicelibrary.service.EmailTemplateBuilder;
import com.elexcode.emailservicelibrary.service.Interface.EmailSenderService;
import com.elexcode.emailservicelibrary.service.config.EmailConfiguration;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mohi
 */
public class emailServiceLibraryTest {


    @Autowired
    private EmailSenderService emailService;

    @Autowired
    private EmailConfiguration emailConfiguration;

    private EmailTemplateBuilder emailTemplateBuilder;

    private EmailObjectBuilder emailObjectBuilder;
    
    private String htmlMsg;
    
    private String host= "smtp.gmail.com";
    private int port = 587; 
    private String username = "elexcode@gmail.com";
    private String password = "elex2015";

    public emailServiceLibraryTest() {
        
    }

    @Before
    public void setUp() throws IOException {

        this.emailTemplateBuilder = new EmailTemplateBuilder("src/main/resources/com/elexcode/emailservicelibrary/service/temp.ftl");
        
        this.emailService = new EmailSenderServiceImpl();
        
        this.emailConfiguration = new EmailConfiguration();

        this.emailObjectBuilder = new EmailObjectBuilder();
        
             htmlMsg = "<html>\n"
                + "<body>\n"
                + "  <h1>This is a title in H1</h1>\n"
                + "\n"
                + "  <p>Hello Mr Elexcode</p>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Ignore
    public void testEmailCredentialsPropertiesWorks() {
        System.out.println("EmailCredentialsPropertiesWorksTest");
        assertEquals("smtp.gmail.com", emailConfiguration.getHost());
        assertEquals(587, emailConfiguration.getPort());

    }

    @Test
    public void testFreemarkerTemplateBuilder() throws IOException, TemplateException {
        System.out.println("Freemarker Template Builder Test");
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "mohi");
        data.put("title", "This is email!");
        assertTrue(emailTemplateBuilder.getHtmlTemplate(data).contains("Hello Mr mohi"));
    }
    
    @Test
    public void testEmailObjectBuilder(){
        System.out.println("Email Object Builder Test");
        String[] recipients = {"adr1", "adr2"};
        String subject = "This is a subject";
        EmailObject obj = emailObjectBuilder.createEmailObject(recipients, subject, htmlMsg);
        assertEquals("This is a subject", obj.getSubject());
        assertEquals(htmlMsg, obj.getHtmlMsg());
        assertEquals(2, obj.getRecipients().length);
    }

    @Test
    public void testEmailSenderService() throws Exception {
        System.out.println("Send One HTML Email Test");
        EmailObject emailObject = createDummyEmailObject();
        emailObject.setHtmlMsg(htmlMsg);
        emailObject.setSubject("HTML Test" + System.currentTimeMillis());
        emailService.setEmailConfiguration(host, port, username, password);
        emailService.sendEmail(emailObject);
    }

    @Test
    public void testSendEmailIntegrated() throws IOException, TemplateException, Exception {
        System.out.println("Send Email Integrated Test");
        Map<String, String> data2 = new HashMap<String, String>();
        data2.put("name", "mohi");
        data2.put("title", "Integrated test Title in H1 tag!");
        String html = emailTemplateBuilder.getHtmlTemplate(data2);
        String[] recipients = {"amargir666@gmail.com"};
        EmailObject obj = emailObjectBuilder.createEmailObject(recipients, "Integrated test at " + System.currentTimeMillis(), html);
        assertEquals(1, obj.getRecipients().length);
        assertEquals("amargir666@gmail.com", obj.getRecipients()[0]);
        emailService.setEmailConfiguration(host, port, username, password);
        emailService.sendEmail(obj);
    }

    public EmailObject createDummyEmailObject() {
        EmailObject emailObject = new EmailObject();
        emailObject.setFrom("elexcode@gmail.com");
        String[] recipients = {"mohammad.bakharzy@kone.com", "amargir666@gmail.com"};
        emailObject.setRecipients(recipients);
        emailObject.setMessage("Hi! \n This is a message");
        return emailObject;

    }
}


