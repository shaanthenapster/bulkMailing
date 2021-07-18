package com.mail.script.api;


import com.mail.script.service.MailDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {

@Autowired
    MailDispatcherService mailDispatcherService;


    @GetMapping(value = "api/sendmail")
    ResponseEntity<Object> verifyEmail() throws Exception {
        mailDispatcherService.sendEmail();
        return ResponseEntity.ok().body("Mail triggered");
    }

}
