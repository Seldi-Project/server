package seldi.seldi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 인증코드 발송
     */
    public String sendVerificationEmail(String email)
            throws UnsupportedEncodingException, MessagingException {
        StringBuffer fullEmail = new StringBuffer(email);

        String fromAddress = "seldi@gmail.com"; // 발신자 이메일
        String senderName = "Seldi"; // 발신자 이름
        String subject = "셀디 회원가입을 위한 인증코드입니다."; // 메일 제목
        String content = "[[name]]님에게,<br>"
                + "회원가입을 진행하기 위해 아래의 인증 코드를 입력하세요:<br>"
                + "<h3>Code = [[code]]</h3>"
                + "감사합니다. <br>"
                + "Seldi";

        // 메일 보내기위해 필요한 객체
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,"utf-8");

        // 메일 발신자 정보(주소,이름)와 수신자메일주소, 메일제목 담기
        helper.setFrom(fromAddress, senderName);
        helper.setTo(fullEmail.toString());
        helper.setSubject(subject);

        //랜덤코드
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < 6) {
            num = random.nextInt(10);
            buffer.append(num);
        }
        String randomCode = buffer.toString();

        // html 내용 replace
        content = content.replace("[[name]]", fullEmail.toString());
        content = content.replace("[[code]]", randomCode);

        //본문 담기, true는 html 형식으로 보내겠다는 의미
        helper.setText(content, true);

        //메일 발송
        javaMailSender.send(message);

        return randomCode;
    }

}
