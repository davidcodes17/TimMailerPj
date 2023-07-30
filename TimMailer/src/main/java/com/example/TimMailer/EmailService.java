//package com.example.TimMailer;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.io.File;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.sql.Array;
//import java.util.List;
//
//@Service
//public class EmailService {
//
//    private final JavaMailSender javaMailSender;
//
//    @Autowired
//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void  sendEmailWithAttachement(@RequestBody EmailRequest emailRequest) throws MessagingException{
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setTo(emailRequest.getTo().toArray(new String[0]));
//        mimeMessageHelper.setText(emailRequest.getBody());
//        mimeMessageHelper.setSubject(emailRequest.getSubject());
//
//        if (emailRequest.getCc() != null && !emailRequest.getCc().isEmpty()) {
//            mimeMessageHelper.setCc(emailRequest.getCc().toArray(new String[0])); // Convert List to array
//        }
//
//        if (emailRequest.getBcc() != null && !emailRequest.getBcc().isEmpty()) {
//            mimeMessageHelper.setBcc(emailRequest.getBcc().toArray(new String[0])); // Convert List to array
//        }
//
//        FileSystemResource fileSystemResource =  new FileSystemResource(new File(emailRequest.getFile()));
//        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
//        javaMailSender.send(mimeMessage);
//        System.out.println("Mail Sent");
//    }
//}
