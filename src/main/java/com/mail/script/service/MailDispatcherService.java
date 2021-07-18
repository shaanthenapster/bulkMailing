package com.mail.script.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailDispatcherService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(MailDispatcherService.class);


    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MailContentBuilder mailContentBuilder;


    public void sendEmail() {

        final String subject = "Bulk mail trigger";
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("MeAlpha <shaanthenapster@gmail.com>");
            messageHelper.setTo("banerjeeritika60@gmail.com");
            messageHelper.setSubject(subject);
            String verification = mailContentBuilder.build();
            messageHelper.setText(verification, true);
        };
        try {
            javaMailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            logger.error("Can Not Send Update Email - Email");
            e.printStackTrace();
            throw new MailSendException("");
        }
    }


}


