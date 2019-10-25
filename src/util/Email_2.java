package util;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.MinimalHTMLWriter;

public class Email_2 {
	// �����˵�ַ
	public static String senderAddress = "chap_xwang314@163.com";
	// �ռ��˵�ַ
	public static String recipientAddress;
	// �������˻���
	public static String senderAccount = "chap_xwang314@163.com";
	// �������˻�����
	public static String senderPassword = "abc123";

	public Email_2(String email) {
		recipientAddress = email;
	}

	public void sendEmail(String password) throws Exception {
		// 1�������ʼ��������Ĳ�������
		Properties props = new Properties();
		// �����û�����֤��ʽ
		props.setProperty("mail.smtp.auth", "true");
		// ���ô���Э��
		props.setProperty("mail.transport.protocol", "smtp");
		// ���÷����˵�SMTP��������ַ
		props.setProperty("mail.smtp.host", "smtp.163.com");
		props.setProperty("mail.smtp.port", "25");// ����Э��
		// 2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
		Session session = Session.getInstance(props);
		// ���õ�����Ϣ�ڿ���̨��ӡ����
		session.setDebug(true);
		// 3�������ʼ���ʵ������
		Message msg = getMimeMessage(session, password);
		// 4������session�����ȡ�ʼ��������Transport
		Transport transport = session.getTransport();
		// ���÷����˵��˻���������
		transport.connect(senderAccount, senderPassword);
		// �����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ���ӵ������ռ���, ������, ������
		transport.sendMessage(msg, msg.getAllRecipients());

		// ���ֻ�뷢�͸�ָ�����ˣ���������д��
		// transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});

		// 5���ر��ʼ�����
		transport.close();
	}

	/**
	 * ��ô���һ���ʼ���ʵ������
	 * 
	 * @param session
	 * @return
	 * @throws MessagingException
	 * @throws AddressException
	 */
	public static MimeMessage getMimeMessage(Session session, String password) throws Exception {
		// ����һ���ʼ���ʵ������
		MimeMessage msg = new MimeMessage(session);
		// ���÷����˵�ַ
		msg.setFrom(new InternetAddress(senderAddress));
		/**
		 * �����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д���� MimeMessage.RecipientType.TO:����
		 * MimeMessage.RecipientType.CC������ MimeMessage.RecipientType.BCC������
		 */
		msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
		// �����ʼ�����
		msg.setSubject("Mandarin Library", "UTF-8");
		// �����ʼ�����
		msg.setContent(
				"Dear User��" + "<br/>" + "<pre>	<strong >Your Password is</strong> <i>" + password + "</i></pre>"
						+ "<p style='text-align: right;'>����Mandarin Librarian</p>",
				"text/html;charset=UTF-8");
		// �����ʼ��ķ���ʱ��,Ĭ����������
		msg.setSentDate(new Date());

		return msg;
	}

}