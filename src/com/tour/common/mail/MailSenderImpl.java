package com.tour.common.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.tour.model.bulletin.domain.BulletinMember;

@Component
public class MailSenderImpl {

	public void mailSending(BulletinMember member, JavaMailSenderImpl mailSender, int passKey) {
		System.out.println("MailSender1==" + mailSender);

		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			System.out.println("messageHelper2==" + messageHelper);

			messageHelper.setFrom("phh_92@naver.com"); // �����»�� �����ϰų� �ϸ� �����۵��� ����
			messageHelper.setTo(member.getEmail()); // �޴»�� �̸���
			messageHelper.setSubject("<Travel>������ȣ�� Ȯ�����ּ���."); // ���������� ������ �����ϴ�
			messageHelper.setText("������ȣ : "+passKey); // ���� ����

			System.out.println("RestMailController3==" + mailSender);
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
