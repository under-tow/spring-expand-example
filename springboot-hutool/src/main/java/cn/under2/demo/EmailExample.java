package cn.under2.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

public class EmailExample {

    static String USER_B = "xxxx@qq.com";
    static String USER_A = "xxxx@qq.com";
    static String USER_A_PASS = "xxx";


    public static void main4(String[] args) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.exmail.qq.com");
        account.setAuth(true);
        account.setFrom(USER_A);
        account.setPass(USER_A_PASS);

        MailUtil.send(account, CollUtil.newArrayList(USER_B), "测试", "邮件来自Hutool测试", false);


    }

    public static void main3(String[] args) throws MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.exmail.qq.com");
        sender.setUsername(USER_A);
        sender.setPassword(USER_A_PASS);
        sender.setPort(25);
        MimeMessage message = sender.createMimeMessage();

// use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(USER_B);
        helper.setFrom(USER_A);
        helper.setSubject("subject");
        helper.setText("Check out this image!");

//        sender.setHost("smtp.qq.com");
//        sender.setUsername(RECEIVER);
//        sender.setPassword("hukpcjnqpijabfhe");
//        MimeMessage message = sender.createMimeMessage();
//
//// use the true flag to indicate you need a multipart message
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo(USER_B);
//        helper.setFrom(RECEIVER);
//        helper.setSubject("subject");
//        helper.setText("Check out this image!");

// let's attach the infamous windows Sample file (this time copied to c:/)
        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\yueshuo\\Pictures\\34637320.jpg"));
        helper.addAttachment("CoolImage.jpg", file);

        sender.send(message);


    }

    public static void main(String[] args) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.exmail.qq.com");
        account.setAuth(true);
        account.setFrom(USER_A);
        account.setUser(USER_A);
        account.setPass(USER_A_PASS);
        account.setSslEnable(true);

        MailAccount account2 = new MailAccount();
        account2.setHost("smtp.qq.com");
        account2.setAuth(true);
        account2.setFrom(USER_B);
        account2.setUser(USER_B);
        account2.setPass("hukpcjnqpijabfhe");
        account2.setSslEnable(true);

        MailUtil.send(account, CollUtil.newArrayList(USER_B), "这是邮件标题", "这是邮件内容", false);

    }
}
