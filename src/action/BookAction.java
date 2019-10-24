package action;
import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
<<<<<<< HEAD
	private List<Book> books;
	private List<CurrentRecord> currentRecords;// ָ�ڽ��鼮��ԤԼ�鼮����Ϣ
	private PageBean<Borrowrecord> borrowPage;// ���ļ�¼��Ϣ
=======
	private List<Book> books;// 可能被bookPage取代，建议少用，如需使用请改注释
	private List<Borrowrecord> borrowrecords;// 可能被删除
	private List<CurrentRecord> currentRecords;// 指预约书籍的信息
	private PageBean<Borrowrecord> borrowPage;// 已归还的书籍信息
>>>>>>> wjy
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
<<<<<<< HEAD
	private List<Borrowrecord> borrowrecords;
=======
>>>>>>> wjy
	private String isbn1;
	private int bookID2;
	public ISBNgenerator getiSBNgenerator() {
		return iSBNgenerator;
	}

	public void setiSBNgenerator(ISBNgenerator iSBNgenerator) {
		this.iSBNgenerator = iSBNgenerator;
	}

<<<<<<< HEAD
	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
	}
=======
	
>>>>>>> wjy

	public int getBookID2() {
		return bookID2;
	}

	public void setBookID2(int bookID2) {
		this.bookID2 = bookID2;
	}

	public int getBookID3() {
		return bookID3;
	}

	public void setBookID3(int bookID3) {
		this.bookID3 = bookID3;
	}

	public static String getBookName() {
		return BookName;
	}

	public static void setBookName(String bookName) {
		BookName = bookName;
	}

	public static String getISBN() {
		return ISBN;
	}

	public static void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public static String getPrice() {
		return Price;
	}

	public static void setPrice(String price) {
		Price = price;
	}

	public static String getAuthor() {
		return Author;
	}

	public static void setAuthor(String author) {
		Author = author;
	}

	public static String getDescription() {
		return Description;
	}
<<<<<<< HEAD

	public static void setDescription(String description) {
		Description = description;
	}

	public static String getCategory() {
		return Category;
	}

	public static void setCategory(String category) {
		Category = category;
	}

	public static String getIsbn() {
		return isbn;
	}

	public static void setIsbn(String isbn) {
		BookAction.isbn = isbn;
	}
	private int bookID3;
	// �����Ǿ���ʹ�õĹ��ܺ���

	public String getIsbn1() {
		return isbn1;
	}

	public void setIsbn1(String isbn1) {
		this.isbn1 = isbn1;
	}

	// reader��Ҫʹ�õĺ�����������������
=======

	public static void setDescription(String description) {
		Description = description;
	}


	public static void setCategory(String category) {
		Category = category;
	}

	public static String getIsbn() {
		return isbn;
	}

	public static void setIsbn(String isbn) {
		BookAction.isbn = isbn;
	}
	private int bookID3;
	// 锟斤拷锟斤拷锟角撅拷锟斤拷使锟矫的癸拷锟杰猴拷锟斤拷

	public String getIsbn1() {
		return isbn1;
	}

	public void setIsbn1(String isbn1) {
		this.isbn1 = isbn1;
	}
	private String categoryString;
	private Integer selectSearch;
	private Map<String, Integer> categoryMap;
	private Boolean	displayStyle=true;
	// 以下是具体使用的功能函数

	// reader锟斤拷要使锟矫的猴拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
>>>>>>> wjy
	public String searchBook() {
		// TODO:分页搜索
	
		if (selectSearch != null) {
			switch (selectSearch) {
			case 1:
				bookPage = this.getService().getPageBean(searchContent,categoryString, pageNum);
				break;
			case 2:
				bookPage = this.getService().getPageBeanbyISBN(searchContent,categoryString, pageNum);
				break;
			case 3:
				bookPage = this.getService().getPageBeanbyTitle(searchContent,categoryString, pageNum);
				break;
			case 4:
				bookPage = this.getService().getPageBeanbyAuthor(searchContent,categoryString, pageNum);
				break;
			default:
				bookPage = this.getService().getPageBean(searchContent,categoryString,pageNum);
			}
		} else {
			bookPage = this.getService().getPageBean(searchContent,categoryString, pageNum);
		}
		this.getsCategory();
		return SUCCESS;
	}

	public String getsCategory() {
		List<String> cStrings = this.getService().getCategory(searchContent, selectSearch);
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for (Iterator iterator = cStrings.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String[] tsStrings = string.split(",");
			for (int i = 0; i < tsStrings.length; i++) {
				if (tempMap.containsKey(tsStrings[i])) {
					tempMap.put(tsStrings[i],tempMap.get(tsStrings[i])+1);
				}else tempMap.put(tsStrings[i],1);
			}
		}
		categoryMap = tempMap;
		return SUCCESS;
	}


	public String getBooksbyborrowPage() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPage.getDataList()) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}
//ls
	public String findBookIsBorrowed() {
		if (!this.books.get(0).getIsBorrowed()) {
			
		} else {
			this.setErrorMessage(
					"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(0).getBookID());
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		if (this.books.size()>=2&&this.books.get(1) != null) {
			if (!this.books.get(1).getIsBorrowed()) {
				
			} else {
				this.setErrorMessage(
						"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(1).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		if (this.books.size()>=3&&this.books.get(2) != null) {
			if (!this.books.get(2).getIsBorrowed()) {
				
			} else {
				this.setErrorMessage(
						"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(2).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		return SUCCESS;
	}

<<<<<<< HEAD
	public String getBooksbyBorrowPage() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowPage.getDataList()) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}
//ls
	public String findBookIsBorrowed() {
		if (!this.books.get(0).getIsBorrowed()) {
			
		} else {
			this.setErrorMessage(
					"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(0).getBookID());
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		if (this.books.size()>=2&&this.books.get(1) != null) {
			if (!this.books.get(1).getIsBorrowed()) {
				
			} else {
				this.setErrorMessage(
						"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(1).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		if (this.books.size()>=3&&this.books.get(2) != null) {
			if (!this.books.get(2).getIsBorrowed()) {
				
			} else {
				this.setErrorMessage(
						"BookCannotBorrowedError:this Book has been Borrowed--Book id:" + this.books.get(2).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		return SUCCESS;
	}

=======
>>>>>>> wjy
	public String borrowBook() {
		if (!this.books.get(0).getIsBorrowed()) {
			this.books.get(0).setIsBorrowed(true);
			this.getService().mergeBook(this.books.get(0));
		} else {
			this.setErrorMessage(
					"BookCannotBorrowError:this Book has been Borrowed--Book id:" + this.books.get(0).getBookID());
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		if (this.books.size()>=2&&!this.books.get(1).getIsBorrowed()) {
			this.books.get(1).setIsBorrowed(true);
			this.getService().mergeBook(this.books.get(1));
		}
		
		if (this.books.size()>=3&&!this.books.get(2).getIsBorrowed()) {
			this.books.get(2).setIsBorrowed(true);
			this.getService().mergeBook(this.books.get(2));
		} 
		return SUCCESS;
	}

	public String returnBook() {
		if (this.books.get(0).getIsBorrowed()) {
			this.books.get(0).setIsBorrowed(false);
			this.getService().mergeBook(this.books.get(0));
			return SUCCESS;
		} else {
			this.setErrorMessage(
					"BookCannotReturnError:this Book has been Returned--Book id:" + this.books.get(0).getBookID());
			System.out.println(this.getErrorMessage());
			return ERROR;
		}

	}

	public String getBookById() {
		this.books = new ArrayList<Book>();
		int id = this.getModel().getBookID();
		int id2 = this.bookID2;
		int id3 = this.bookID3;
		if ((id != 0 && id2 != 0) || (id != 0 && id3 != 0) || (id2 != 0 && id3 != 0)) {
			if (id == id2 || id == id3 || id2 == id3) {
				this.setErrorMessage("Some Bookid is same: id1:" + id + "id2:" + id2 + "id3:" + id3);
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		if(id==0&&id2==0&&id3==0){
			this.setErrorMessage("Please Input the book id!");
			System.out.println(this.getErrorMessage());
			return ERROR;
		}
		if (id != 0) {
			this.books.add(this.getService().getBookById(id));
			if (this.books.get(0) == null) {
				this.setErrorMessage("BookNotFoundError: Can't Find Book by id1:" + id);
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
			if (id2 != 0) {
				this.books.add(this.getService().getBookById(id2));
				if (this.books.get(1) == null) {
					this.setErrorMessage("BookNotFoundError: Can't Find Book by id2:" + id2);
					System.out.println(this.getErrorMessage());
					return ERROR;
				}
				if (id3 != 0) {
					this.books.add(this.getService().getBookById(id3));
					if (this.books.get(2) == null) {
						this.setErrorMessage("BookNotFoundError: Can't Find Book by id3:" + id3);
						System.out.println(this.getErrorMessage());
						return ERROR;
					}
				}
			} else if (id3 != 0) {
				this.books.add(this.getService().getBookById(id3));
				if (this.books.get(1) == null) {
					this.setErrorMessage("BookNotFoundError: Can't Find Book by id3:" + id3);
					System.out.println(this.getErrorMessage());
					return ERROR;
				}
			}
		} else if (id2 != 0) {
			this.books.add(this.getService().getBookById(id2));
			if (this.books.get(0) == null) {
				this.setErrorMessage("BookNotFoundError: Can't Find Book by id2:" + id2);
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
			if (id3 != 0) {
				this.books.add(this.getService().getBookById(id3));
				if (this.books.get(1) == null) {
					this.setErrorMessage("BookNotFoundError: Can't Find Book by id3:" + id3);
					System.out.println(this.getErrorMessage());
					return ERROR;
				}
			}
		} else if (id3 != 0) {
			this.books.add(this.getService().getBookById(id3));
			if (this.books.get(0) == null) {
				this.setErrorMessage("BookNotFoundError: Can't Find Book by id3:" + id3);
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}

		return SUCCESS;
	}
	public String getBooksbyBorrwrecords() {
		books = new ArrayList<Book>();
		for (Borrowrecord borrowrecord : borrowrecords) {
			books.add(this.getService().getBookByBorrowrecord(borrowrecord));
		}
		return SUCCESS;
	}

	public String getBooksbycurrentRecords() {
<<<<<<< HEAD
		// TODO:���ܸ���pagabeanʵ��
=======
		// TODO:锟斤拷锟杰革拷锟斤拷pagabean实锟斤拷
>>>>>>> wjy
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}
	
<<<<<<< HEAD
	// reader��Ҫʹ�õĺ�����������������
=======
	// reader锟斤拷要使锟矫的猴拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
>>>>>>> wjy

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
<<<<<<< HEAD
	//根据ISBN加书
	static String BookName=null;//书名
	static String ISBN=null;
	static String Price=null;//价格
	static String Author=null;//作者
	static String Description=null;//书籍简介
	static String Category=null;//种类
	static String isbn;
	public static String getUrl(String isbn) {//构造URL
=======
	//鏍规嵁ISBN鍔犱功
	static String BookName=null;//涔﹀悕
	static String ISBN=null;
	static String Price=null;//浠锋牸
	static String Author=null;//浣滆 �
	static String Description=null;//涔︾睄绠�浠�
	static String Category=null;//绉嶇被
	static String isbn;
	public static String getUrl(String isbn) {//鏋勯�燯RL
>>>>>>> wjy
		StringBuilder builder= new StringBuilder();
		builder.append("http://api.douban.com/book/subject/isbn/");
		builder.append(isbn);
		builder.append("?apikey=0b2bdeda43b5688921839c8ecb20399b");
		return builder.toString();
	}
<<<<<<< HEAD
	public static String getContent(String urlName) {//获取网页显示的内容
=======
	public static String getContent(String urlName) {//鑾峰彇缃戦〉鏄剧ず鐨勫唴瀹�
>>>>>>> wjy
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
<<<<<<< HEAD
            conn.connect();//建立连接
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//定义输入流来读取URL的响应
=======
            conn.connect();//寤虹珛杩炴帴
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//瀹氫箟杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
>>>>>>> wjy
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
<<<<<<< HEAD
	public static void seprarate(String result) {//对获取到的网页内容进行分割，获取感兴趣的数据部分,用正则表达式进行匹配
=======
	public static void seprarate(String result) {//瀵硅幏鍙栧埌鐨勭綉椤靛唴瀹硅繘琛屽垎鍓诧紝鑾峰彇鎰熷叴瓒ｇ殑鏁版嵁閮ㄥ垎,鐢ㄦ鍒欒〃杈惧紡杩涜鍖归厤
>>>>>>> wjy
		String pattern[] = new String[5];
		Pattern patterncompile[] = new Pattern[5];
		Matcher matcher[] =new Matcher[5];
		String group[] = new String[5];
<<<<<<< HEAD
		pattern[0]="<title>(.*)</title>";//匹配书籍名称
		pattern[1]="<db:attribute name=\"price\">(.*?)</db:attribute>";//匹配价格
		pattern[2]="<db:attribute name=\"author\">(.*?)</db:attribute>";//匹配作者
		pattern[3]="<summary>(.*)</summary>";//匹配简介
		pattern[4]="<db:rating(.*?)/>(.*)<gd:rating";//匹配书籍种类
=======
		pattern[0]="<title>(.*)</title>";//鍖归厤涔︾睄鍚嶇О
		pattern[1]="<db:attribute name=\"price\">(.*?)</db:attribute>";//鍖归厤浠锋牸
		pattern[2]="<db:attribute name=\"author\">(.*?)</db:attribute>";//鍖归厤浣滆��
		pattern[3]="<summary>(.*)</summary>";//鍖归厤绠�浠�
		pattern[4]="<db:rating(.*?)/>(.*)<gd:rating";//鍖归厤涔︾睄绉嶇被
>>>>>>> wjy
		for(int i=0;i<5;i++) {
			patterncompile[i]=Pattern.compile(pattern[i]);
			matcher[i]=patterncompile[i].matcher(result);
			if(matcher[i].find()) {
				if(i<=3) {
				group[i]=matcher[i].group(1);
				}
				else {
<<<<<<< HEAD
				group[i]=matcher[i].group(2);//进行二次匹配
=======
				group[i]=matcher[i].group(2);//杩涜浜屾鍖归厤
>>>>>>> wjy
				String[] splitStr = group[i].split("\"");
				String res="";
				for(String str:splitStr) {
					if(Pattern.matches("[\\u4E00-\\u9FA5]+", str)) {
						res+=str;
						res+=",";
						}		
				}
<<<<<<< HEAD
				res = res.substring(0,res.length() - 1);
=======
>>>>>>> wjy
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
		isbn1 = this.getService().getBookById(book.getBookID()).getISBN();
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

<<<<<<< HEAD

	

//������get��set����
=======
	public String reserveBook() {
		this.book = this.getService().getBookById(book.getBookID());
		if (book.getIsBorrowed() != false) {
			return ERROR;
		} else {
			book.setIsBorrowed(true);
			this.getService().mergeBook(book);
			return SUCCESS;
		}
	}

//以下是get和set函数
>>>>>>> wjy
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
	
//admin淇敼閫炬湡缃氶噾鍜屽綊杩樻湡闄�
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

	public Integer getSelectSearch() {
		return selectSearch;
	}

	public void setSelectSearch(Integer selectSearch) {
		this.selectSearch = selectSearch;
	}

	public Map<String, Integer> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, Integer> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public String getCategoryString() {
		return categoryString;
	}

	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}

	public Boolean getDisplayStyle() {
		return displayStyle;
	}

	public void setDisplayStyle(Boolean displayStyle) {
		this.displayStyle = displayStyle;
	}

}
