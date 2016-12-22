package com.stripcode.core.util.emailUtil;


import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.email.model.TSysMailSendInfo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;


public class MailUtil {
	/**
	 * 创建Session对象，此时需要配置传输的协议，是否身份认证
	 */
	public static Session createSession(String protocol) {
		Properties property = new Properties();
		property.setProperty("mail.transport.protocol", protocol);
		property.setProperty("mail.smtp.auth", "true");

		Session session = Session.getInstance(property);

		// 启动JavaMail调试功能，可以返回与SMTP服务器交互的命令信息
		// 可以从控制台中看一下服务器的响应信息
		session.setDebug(true);
		return session;
	}

	/**
	 * 传入Session、MimeMessage对象，创建 Transport 对象发送邮件
	 */
	public static void sendMail(Session session, MimeMessage msg) throws Exception {

		// 设置发件人使用的SMTP服务器、用户名、密码
		String smtpServer = "smtp.163.com";
		String user = "zhiyin369love@163.com";
		String pwd = "wssyrpx";

		// 由 Session 对象获得 Transport 对象
		Transport transport = session.getTransport();
		// 发送用户名、密码连接到指定的 smtp 服务器
		transport.connect(smtpServer, user, pwd);

		transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	/**************************************** CommonMail ****************************************/

	public static void sendSimpleMail() throws Exception {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.163.com"); // 发送服务器
		email.setAuthentication("zhiyin369love@163.com", "wssyrpx"); // 发送邮件的用户名和密码
		email.addTo("2326701940@qq.com"); // 接收邮箱
		email.addCc("289589844@qq.com");  //抄送
		email.setFrom("zhiyin369love@163.com"); // 发送邮箱
		email.setSubject("邮件发送");// 主题
		email.setMsg("嗨！瑶彬，你好！抄送给你"); // 内容
		email.setSmtpPort(25); // 端口
		email.setSSL(false); // gmail需要设置SSL安全设置
		email.setCharset("UTF-8"); // 编码
		email.send();
		System.out.println ( "Send email successful!" );
	}
	//简单发送，抄送
    public static  boolean sendSimpleMail(String to,String copyto,String subject,String body) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.163.com"); // 发送服务器
		email.setAuthentication("zhiyin369love@163.com", "wssyrpx"); // 发送邮件的用户名和密码
		email.addTo(to);// 接收邮箱
		if (copyto != null && !copyto.isEmpty()) {
			email.addCc(copyto);//抄送
		}
		email.setFrom("zhiyin369love@163.com"); // 发送邮箱
		email.setSubject(subject);// 设置主题
		email.setMsg(body); // 内容
		email.setSmtpPort(25); // 端口
		email.setSSL(false); // gmail需要设置SSL安全设置
		email.setCharset("UTF-8"); // 编码
		try {
			    email.send();
			    System.out.println ( "Send email successful!" );
				return true;
		} catch (Exception e) {
			return false;
		}
    }

	//带文件发送、抄送
	public static boolean SendFileEmail(TSysMailSendInfo msg, ArrayList<TSysCommonattached> attached) throws Exception {
		Properties properties = new Properties();
		properties.load(MailUtil.class.getResourceAsStream("/config/mail.properties"));
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");
		String ssl = properties.getProperty("mail.smtp.ssl.enable");
		String username = properties.getProperty("mail.smtp.username");
		String password = properties.getProperty("mail.smtp.password");
		String fdfsUrl = properties.getProperty("fast.dfs.url");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(host);//smtp host
		email.setAuthentication(username, password);//登陆邮件服务器的用户名和密码
		email.setSmtpPort(Integer.parseInt(port));
		email.setSSL(Boolean.parseBoolean(ssl));
		email.setFrom(username);//发送人
		email.addTo(msg.getAccepetAddress());//接收人
		if (msg.getCcAddress() != null &&  msg.getCcAddress().length > 0 ) {
			email.addCc(msg.getCcAddress());//抄送
		}
		email.setSubject(msg.getSubject());//标题
		email.setMsg(msg.getContent());//邮件内容
		if(attached != null){
			for (int i = 0 ; i < attached.size() ; i++){
				String remoteFileUrl = fdfsUrl + attached.get(i).getFilePath();
				email.attach(new URL(remoteFileUrl),attached.get(i).getDocName(),"attachment");
			}
		}
		// send it!
		try{
			email.send();
			System.out.println ( "Send email successful!" );
			return true;
		}catch (EmailException e){
			e.printStackTrace();
			return false;
		}
	}
	// 发送html格式的mail
	public static boolean htmlEmail(ArrayList<String> emailAddress, ArrayList<String> emailCopyAddress, ArrayList<String> addPath, ArrayList<String> fileName, String title, String content)throws Exception {
		Properties properties = new Properties();
		properties.load(MailUtil.class.getResourceAsStream("/mail.properties"));
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");
		String ssl = properties.getProperty("mail.smtp.ssl.enable");
		String username = properties.getProperty("mail.smtp.username");
		String password = properties.getProperty("mail.smtp.password");
		String fdfsUrl = properties.getProperty("fast.dfs.url");
		HtmlEmail email = new HtmlEmail();
		email.setHostName(host);//smtp host
		email.setAuthentication(username, password);//登陆邮件服务器的用户名和密码
		email.setSmtpPort(Integer.parseInt(port));
		email.setSSL(Boolean.parseBoolean(ssl));
		email.setFrom(username);//发送人
		email.addTo(emailAddress.toArray(new String[]{}));//接收人
		if (emailCopyAddress != null && !emailCopyAddress.isEmpty()) {
			email.addCc(emailCopyAddress.toArray(new String[]{}));//抄送
		}
		email.setSubject(title);//标题
		email.setMsg(content);//邮件内容
		if(addPath != null){
			for (int i = 0 ; i < addPath.size() ; i++){
				String remoteFileUrl = fdfsUrl + addPath.get(i);

				email.attach(new URL(remoteFileUrl),fileName.get(i),"attachment");
			}
		}
		// send it!
		try{
			email.send();
			System.out.println ( "Send email successful!" );
			return true;
		}catch (EmailException e){
			e.printStackTrace();
			return false;
		}
	}
}
