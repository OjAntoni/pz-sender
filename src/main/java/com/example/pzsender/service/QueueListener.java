package com.example.pzsender.service;


import com.example.pzsender.model.UserMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueueListener {
    private ObjectMapper objectMapper;
    private EmailService emailService;

    @SneakyThrows
    @JmsListener(destination = "MessagesMB")
    @Async("jmsListenerTaskExecutor")
    public void receiveMessage(String json) {
        UserMessage userMessage = objectMapper.readValue(json, UserMessage.class);
        emailService.sendEmail(userMessage.getEmail(),"New Article Notification", userMessage);
    }
}
