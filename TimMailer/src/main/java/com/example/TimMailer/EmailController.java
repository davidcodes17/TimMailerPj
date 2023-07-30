package com.example.TimMailer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

//    private final EmailService emailService;
//
//    @Autowired
//    public EmailController(EmailService emailService) {
//        this.emailService = emailService;
//    }

//    @PostMapping(path = "/sendEmail")
//    public void sendEmailWithAttachment(@RequestBody EmailRequest emailRequest) {
//        // Your logic to handle the request, extract the email data, and the file.
//        // For simplicity, I assume you have the necessary details here.
//
//        List<String> to = emailRequest.getTo();
//        List<String> cc = emailRequest.getCc();
//        List<String> bcc = emailRequest.getBcc();
//        String subject = emailRequest.getSubject();
//        String body = emailRequest.getBody();
//        String file = emailRequest.getFile();
//        emailService.sendEmailWithAttachement(emailRequest);
//
//        // Delete the temporary file after sending the email
//    }



    @PostMapping("/sendemail")
    public void sendEmailWithAttachment(@RequestBody EmailRequest emailRequest) throws MessagingException, MessagingException {
        List<String> to = emailRequest.getTo();
        List<String> cc = emailRequest.getCc();
        List<String> bcc = emailRequest.getBcc();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();
        String file = emailRequest.getFile();

        // Create a new MimeMessage
        MimeMessage message = javaMailSender.createMimeMessage();

        // Use the MimeMessageHelper to set up the email
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message

        // Set the basic email details
        helper.setTo(to.toArray(new String[0])); // Convert List to array
        helper.setCc(cc.toArray(new String[0])); // Convert List to array
        helper.setBcc(bcc.toArray(new String[0])); // Convert List to array
        helper.setSubject(subject);
        helper.setText(body);

        FileSystemResource fileSystemResource =  new FileSystemResource(new File(emailRequest.getFile()));
        helper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        // Add attachment if file path is provided

        // Send the email
        javaMailSender.send(message);
    }
    }
