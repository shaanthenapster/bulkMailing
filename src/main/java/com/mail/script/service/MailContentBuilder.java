package com.mail.script.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }


    public String build() {
        Context context = new Context();
        context.setVariable("bulk mail", "bulk mail");
        //System.out.println(confirmationurl);
        context.setVariable("username", "shaan");
        //System.out.println(username);
        return templateEngine.process("email", context);
    }

}
