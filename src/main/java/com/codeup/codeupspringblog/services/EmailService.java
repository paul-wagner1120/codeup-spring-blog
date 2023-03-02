package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service("EmailService")
public class EmailService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Value("${CUSTOM_KEY}")
    private String customKey;


    public void preparedAndSendPost(Post post){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(post.getUser().getEmail());
        message.setSubject("Post created");
        message.setText(String.format("Post title: '%s'%nPost body: '%s'", post.getTitle(), post.getBody()));

        try{
            this.javaMailSender.send(message);
        } catch(MailException ex){
            System.out.println(ex.getMessage());
        }
    }
}

