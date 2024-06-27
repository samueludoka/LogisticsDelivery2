package org.applicationsmart.services;

import lombok.AllArgsConstructor;
import org.applicationsmart.dtos.request.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@AllArgsConstructor
//@Service
//public class EmailServiceImpl implements EmailService{

//    private final JavaMailSender emailSender;
//    @Override
//    public void sendSimpleMessage(SendMessageRequest request) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(request.getFrom());
//        message.setTo(request.getTo());
//        message.setSubject(request.getSubject());
//        message.setText(request.getText());
//        emailSender.send(message);
//
//    }
//}
