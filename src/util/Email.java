<<<<<<< Updated upstream
//package util;
//import java.io.ObjectInputStream.GetField;
//import java.util.Date;
//import java.util.Properties;
// 
////import javax.mail.Address;
////import javax.mail.Message;
////import javax.mail.MessagingException;
////import javax.mail.Session;
////import javax.mail.Transport;
////import javax.mail.internet.AddressException;
////import javax.mail.internet.InternetAddress;
////import javax.mail.internet.MimeMessage;
//import javax.swing.text.html.MinimalHTMLWriter;
// 
//public class Email {
//    //鍙戜欢浜哄湴鍧�
//    public static String senderAddress = "chap_xwang314@163.com";
//    //鏀朵欢浜哄湴鍧�
//    public static String recipientAddress;
//    //鍙戜欢浜鸿处鎴峰悕
//    public static String senderAccount = "chap_xwang314@163.com";
//    //鍙戜欢浜鸿处鎴峰瘑鐮�
//    public static String senderPassword = "abc123";
//    
//    public Email(String email) {
//    	recipientAddress = email;
//    }
//    public void sendEmail(String LibrarianName, String LibrarianPassword) throws Exception{
//        //1銆佽繛鎺ラ偖浠舵湇鍔″櫒鐨勫弬鏁伴厤缃�
//        Properties props = new Properties();
//        //璁剧疆鐢ㄦ埛鐨勮璇佹柟寮�
//        props.setProperty("mail.smtp.auth", "true");
//        //璁剧疆浼犺緭鍗忚
//        props.setProperty("mail.transport.protocol", "smtp");
//        //璁剧疆鍙戜欢浜虹殑SMTP鏈嶅姟鍣ㄥ湴鍧�
//        props.setProperty("mail.smtp.host", "smtp.163.com");
//        //2銆佸垱寤哄畾涔夋暣涓簲鐢ㄧ▼搴忔墍闇�鐨勭幆澧冧俊鎭殑 Session 瀵硅薄
//        Session session = Session.getInstance(props);
//        //璁剧疆璋冭瘯淇℃伅鍦ㄦ帶鍒跺彴鎵撳嵃鍑烘潵
//        session.setDebug(true);
//        //3銆佸垱寤洪偖浠剁殑瀹炰緥瀵硅薄
//        Message msg = getMimeMessage(session, LibrarianName, LibrarianPassword);
//        //4銆佹牴鎹畇ession瀵硅薄鑾峰彇閭欢浼犺緭瀵硅薄Transport
//        Transport transport = session.getTransport();
//        //璁剧疆鍙戜欢浜虹殑璐︽埛鍚嶅拰瀵嗙爜
//        transport.connect(senderAccount, senderPassword);
//        //鍙戦�侀偖浠讹紝骞跺彂閫佸埌鎵�鏈夋敹浠朵汉鍦板潃锛宮essage.getAllRecipients() 鑾峰彇鍒扮殑鏄湪鍒涘缓閭欢瀵硅薄鏃舵坊鍔犵殑鎵�鏈夋敹浠朵汉, 鎶勯�佷汉, 瀵嗛�佷汉
//        transport.sendMessage(msg,msg.getAllRecipients());
//        
//        //濡傛灉鍙兂鍙戦�佺粰鎸囧畾鐨勪汉锛屽彲浠ュ涓嬪啓娉�
//        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
//         
//        //5銆佸叧闂偖浠惰繛鎺�
//        transport.close();
//    }
//     
//    /**
//     * 鑾峰緱鍒涘缓涓�灏侀偖浠剁殑瀹炰緥瀵硅薄
//     * @param session
//     * @return
//     * @throws MessagingException
//     * @throws AddressException
//     */
//    public static MimeMessage getMimeMessage(Session session, String LibrarianName, String LibrarianPassword) throws Exception{
//        //鍒涘缓涓�灏侀偖浠剁殑瀹炰緥瀵硅薄
//        MimeMessage msg = new MimeMessage(session);
//        //璁剧疆鍙戜欢浜哄湴鍧�
//        msg.setFrom(new InternetAddress(senderAddress));
//        /**
//         * 璁剧疆鏀朵欢浜哄湴鍧�锛堝彲浠ュ鍔犲涓敹浠朵汉銆佹妱閫併�佸瘑閫侊級锛屽嵆涓嬮潰杩欎竴琛屼唬鐮佷功鍐欏琛�
//         * MimeMessage.RecipientType.TO:鍙戦��
//         * MimeMessage.RecipientType.CC锛氭妱閫�
//         * MimeMessage.RecipientType.BCC锛氬瘑閫�
//         */
//        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
//        //璁剧疆閭欢涓婚
//        msg.setSubject("閭欢涓婚","UTF-8");
//        //璁剧疆閭欢姝ｆ枃
//        msg.setContent("灏婃暚鐨�"+LibrarianName+"鎮ㄧ殑瀵嗙爜鏄�"+LibrarianPassword, "text/html;charset=UTF-8");
//        //璁剧疆閭欢鐨勫彂閫佹椂闂�,榛樿绔嬪嵆鍙戦��
//        msg.setSentDate(new Date());
//         
//        return msg;
//    }
// 
//}
=======
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
 
public class Email {
    //发件人地址
    public static String senderAddress = "chap_xwang314@163.com";
    //收件人地址
    public static String recipientAddress;
    //发件人账户名
    public static String senderAccount = "chap_xwang314@163.com";
    //发件人账户密码
    public static String senderPassword = "abc123";
    
    public Email(String email) {
    	recipientAddress = email;
    }
    public void sendEmail(String LibrarianName, String LibrarianPassword) throws Exception{
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        //设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        //设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        //设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.163.com");
        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        //3、创建邮件的实例对象
        Message msg = getMimeMessage(session, LibrarianName, LibrarianPassword);
        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(senderAccount, senderPassword);
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(msg,msg.getAllRecipients());
        
        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
         
        //5、关闭邮件连接
        transport.close();
    }
     
    /**
     * 获得创建一封邮件的实例对象
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public static MimeMessage getMimeMessage(Session session, String LibrarianName, String LibrarianPassword) throws Exception{
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(senderAddress));
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipientAddress));
        //设置邮件主题
        msg.setSubject("Retrieve password message","GBK");
        //设置邮件正文
        msg.setContent("Dear "+LibrarianName+", your password is "+LibrarianPassword, "text/html;charset=GBK");
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());
         
        return msg;
    }
 
}
>>>>>>> Stashed changes
