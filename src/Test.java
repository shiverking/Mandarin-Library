import java.io.*;
import java.net.*;
import java.util.regex.*;
public class Test {
	static String BookName=null;//书名
	static String ISBN=null;
	static String Price=null;//价格
	static String Author=null;//作者
	static String Description=null;//书籍简介
	static String Category=null;//种类
	static String isbn;
	public static String getUrl(String isbn) {//构造URL
		StringBuilder builder= new StringBuilder();
		builder.append("http://api.douban.com/book/subject/isbn/");
		builder.append(isbn);
		builder.append("?apikey=0b2bdeda43b5688921839c8ecb20399b");
		return builder.toString();
	}
	public static String getContent(String urlName) {//获取网页显示的内容
		String result="";
		BufferedReader reader= null;
		try {
			URL url = new URL(urlName);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.connect();//建立连接
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//定义输入流来读取URL的响应
            String line;
            while((line= reader.readLine())!=null) {
            	result+=line;
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null)
			try {
				reader.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result;
	}
	public static void seprarate(String result) {//对获取到的网页内容进行分割，获取感兴趣的数据部分,用正则表达式进行匹配
		String pattern[] = new String[5];
		Pattern patterncompile[] = new Pattern[5];
		Matcher matcher[] =new Matcher[5];
		String group[] = new String[5];
		pattern[0]="<title>(.*)</title>";//匹配书籍名称
		pattern[1]="<db:attribute name=\"price\">(.*)元</db:attribute>";//匹配价格
		pattern[2]="<db:attribute name=\"author\">(.*?)</db:attribute>";//匹配作者
		pattern[3]="<summary>(.*)</summary>";//匹配简介
		pattern[4]="<db:rating(.*?)/>(.*)<gd:rating";//匹配书籍种类
		for(int i=0;i<5;i++) {
			patterncompile[i]=Pattern.compile(pattern[i]);
			matcher[i]=patterncompile[i].matcher(result);
			if(matcher[i].find()) {
				if(i<=3) {
				group[i]=matcher[i].group(1);
				}
				else {
				group[i]=matcher[i].group(2);//进行二次匹配
				String[] splitStr = group[i].split("\"");
				String res="";
				for(String str:splitStr) {
					if(Pattern.matches("[\\u4E00-\\u9FA5]+", str)) {
						res+=str;
						res+=",";
						}		
				}
				res = res.substring(0,res.length() - 1);
				group[i]=res;
				}
				}
			}
		BookName=group[0];Price=group[1];Author=group[2];Description=group[3];Category=group[4];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isbn="9780321776402";
		seprarate(getContent(getUrl(isbn.strip())));
		System.out.println("BookName: "+BookName+"\n"
		+"ISBN: "+isbn+"\n"
		+"Price: "+Price+"\n"
		+"Author: "+Author+"\n"
		+"Description: "+Description+"\n"
		+"Category: "+Category);
	}

}
