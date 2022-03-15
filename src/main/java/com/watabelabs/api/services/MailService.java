package com.watabelabs.api.services;

import com.watabelabs.api.exceptions.SpringApiException;
import com.watabelabs.api.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/** MailService */
@Service
@AllArgsConstructor
@Slf4j
public class MailService {
  private final JavaMailSender mailSender;
  private final MailContentBuilder mailContentBuilder;

  void sendMail(NotificationEmail notificationEmail) {
    MimeMessagePreparator messagePreparator = mimeMessage -> {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
      messageHelper.setFrom("zachariahn@gmail.com");
      messageHelper.setTo(notificationEmail.getRecipient());
      messageHelper.setSubject(notificationEmail.getSubject());
      messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
    };
    try {
      mailSender.send(messagePreparator);
      log.info("Activation Mail sent!");
    } catch (MailException e) {
      log.error("Exception occurred while sending mail", e);
      throw new SpringApiException(
          "Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
    }
  }
}
