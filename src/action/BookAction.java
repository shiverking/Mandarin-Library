package action;
import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Borrowrecord;
import model.CurrentRecord;
import service.BookService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import util.ISBNgenerator;
import util.PageBean;
public class BookAction extends BaseAction<Book, BookService> {
	private static Book book;
	private List<Book> books;
	private List<CurrentRecord> currentRecords;// ָ�ڽ��鼮��ԤԼ�鼮����Ϣ
	private PageBean<Borrowrecord> borrowPage;// ���ļ�¼��Ϣ
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;

	// �����Ǿ���ʹ�õĹ��ܺ���

	// reader��Ҫʹ�õĺ�����������������
	public String searchBook() {
		// TODO:��ҳ����
		bookPage = this.getService().getPageBean(searchContent, pageNum);
		return SUCCESS;
	}

	public String getBooksbyBorrowPage() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPage.getDataList()) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getBooksbycurrentRecords() {
		// TODO:���ܸ���pagabeanʵ��
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}
	// reader��Ҫʹ�õĺ�����������������

	public String addBook() throws Exception {
		HttpServletRequest NumRequest = ServletActionContext.getRequest();
		String BookName = this.getModel().getBookName();
		
		String Location = this.getModel().getLocation();
		String Category = this.getModel().getCategory();
		int Number = Integer.parseInt(NumRequest.getParameter("Num"));
		String isbn=iSBNgenerator.generateISBN();
		for (int i = 0; i < Number; i++) {
			this.getModel().setBookName(BookName);
			this.getModel().setLocation(Location);
			this.getModel().setReturnPeriod(30);
			this.getModel().setFineValue(1);
			this.getModel().setIsBorrowed(false);
			this.getModel().setCategory(Category);
			this.getModel().setISBN(isbn);
			this.getService().saveBook(this.getModel());
		}
		return SUCCESS;
	}
	//根据ISBN加书
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
		pattern[1]="<db:attribute name=\"price\">(.*?)</db:attribute>";//匹配价格
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
	public String addBookISBN() throws Exception {
		String isbn = this.getModel().getISBN();
		HttpServletRequest NumRequest = ServletActionContext.getRequest();
		String Location = this.getModel().getLocation();
		int Number = Integer.parseInt(NumRequest.getParameter("Number"));
		seprarate(getContent(getUrl(isbn.strip())));
	
		for (int i = 0; i < Number; i++) {
			this.getModel().setBookName(BookName);
			this.getModel().setAuthor(Author);
			this.getModel().setIntroduction(Description);
			this.getModel().setCategory(Category);
			this.getModel().setISBN(isbn);
			this.getModel().setPrice(Price);
			this.getModel().setLocation(Location);
			this.getModel().setReturnPeriod(30);
			this.getModel().setFineValue(1);
			this.getModel().setIsBorrowed(false);
			this.getModel().setCategory(Category);
			this.getService().saveBook(this.getModel());
		}
		return SUCCESS;
	}
	public String addBookPage() {
		return SUCCESS;
	}

	public String display() {
		this.books = this.getService().getAllBooks();
		return SUCCESS;
	}

	public String deleteBook() {
		this.getService().deleteBookById(book.getBookID());
		return SUCCESS;
	}

	public String editBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if (this.getModel().getBookName() != null) {
			book.setBookName(this.getModel().getBookName());
		}
		if (this.getModel().getPrice()!=null) {
			book.setPrice(this.getModel().getPrice());
			;
		}
		if (this.getModel().getLocation() != null) {
			book.setLocation(this.getModel().getLocation());
		}
		book.setIsBorrowed(this.getModel().getIsBorrowed());
		if (this.getModel().getCategory() != null) {
			book.setCategory(this.getModel().getCategory());
		}
		this.getService().mergeBook(book);
		return SUCCESS;
	}

//������get��set����
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public PageBean<Borrowrecord> getBorrowPage() {
		return borrowPage;
	}

	public void setBorrowPage(PageBean<Borrowrecord> borrowPage) {
		this.borrowPage = borrowPage;
	}

	public PageBean<Book> getBookPage() {
		return bookPage;
	}

	public void setBookPage(PageBean<Book> bookPage) {
		this.bookPage = bookPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<CurrentRecord> getCurrentRecords() {
		return currentRecords;
	}

	public void setCurrentRecords(List<CurrentRecord> currentRecords) {
		this.currentRecords = currentRecords;
	}
	
//admin修改逾期罚金和归还期限
	public String adminEditBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if (this.getModel().getReturnPeriod() > 0) {
			book.setReturnPeriod(this.getModel().getReturnPeriod());
		}
		if (this.getModel().getFineValue() > 0) {
			book.setFineValue(this.getModel().getFineValue());
			;
		}
		this.getService().mergeBook(book);
		return SUCCESS;
	}

}
