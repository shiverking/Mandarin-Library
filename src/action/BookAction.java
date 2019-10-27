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
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import util.ISBNgenerator;
import util.PageBean;

public class BookAction extends BaseAction<Book, BookService> {
	private static Book book;
	private List<Book> books;// 鍙兘琚玝ookPage鍙栦唬锛屽缓璁皯鐢紝濡傞渶浣跨敤璇锋敼娉ㄩ噴
	private List<Borrowrecord> borrowrecords;// 鍙兘琚垹闄�
	private List<CurrentRecord> currentRecords;// 鎸囬绾︿功绫嶇殑淇℃伅
	private PageBean<Borrowrecord> borrowPage;// 宸插綊杩樼殑涔︾睄淇℃伅
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	private String isbn1;
	private int bookID2;

	public ISBNgenerator getiSBNgenerator() {
		return iSBNgenerator;
	}

	public void setiSBNgenerator(ISBNgenerator iSBNgenerator) {
		this.iSBNgenerator = iSBNgenerator;
	}

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
	// 閿熸枻鎷烽敓鏂ゆ嫹閿熻鎾呮嫹閿熸枻鎷蜂娇閿熺煫鐨勭櫢鎷烽敓鏉扮尨鎷烽敓鏂ゆ嫹

	public String getIsbn1() {
		return isbn1;
	}

	public void setIsbn1(String isbn1) {
		this.isbn1 = isbn1;
	}

	private String categoryString;
	private Integer selectSearch;
	private Map<String, Integer> categoryMap;
	private Boolean displayStyle = true;
	// 浠ヤ笅鏄叿浣撲娇鐢ㄧ殑鍔熻兘鍑芥暟

	// reader閿熸枻鎷疯浣块敓鐭殑鐚存嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	public String searchBook() {
		// TODO:鍒嗛〉鎼滅储
		if (categoryString!=null&&categoryString.isEmpty()) {
			categoryString = null;
		}
		if (selectSearch != null) {
			switch (selectSearch) {
			case 1:
				bookPage = this.getService().getPageBean(searchContent, categoryString, pageNum);
				break;
			case 2:
				bookPage = this.getService().getPageBeanbyISBN(searchContent, categoryString, pageNum);
				break;
			case 3:
				bookPage = this.getService().getPageBeanbyTitle(searchContent, categoryString, pageNum);
				break;
			case 4:
				bookPage = this.getService().getPageBeanbyAuthor(searchContent, categoryString, pageNum);
				break;
			default:
				bookPage = this.getService().getPageBean(searchContent, categoryString, pageNum);
			}
		} else {
			bookPage = this.getService().getPageBean(searchContent, categoryString, pageNum);
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
				if (!tsStrings[i].isEmpty()) {
					if (tempMap.containsKey(tsStrings[i])) {
						tempMap.put(tsStrings[i], tempMap.get(tsStrings[i]) + 1);
					} else
						tempMap.put(tsStrings[i], 1);
				}
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
		if (this.books.size() >= 2 && this.books.get(1) != null) {
			if (!this.books.get(1).getIsBorrowed()) {

			} else {
				this.setErrorMessage("BookCannotBorrowedError:this Book has been Borrowed--Book id:"
						+ this.books.get(1).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		if (this.books.size() >= 3 && this.books.get(2) != null) {
			if (!this.books.get(2).getIsBorrowed()) {

			} else {
				this.setErrorMessage("BookCannotBorrowedError:this Book has been Borrowed--Book id:"
						+ this.books.get(2).getBookID());
				System.out.println(this.getErrorMessage());
				return ERROR;
			}
		}
		return SUCCESS;
	}

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
		if (this.books.size() >= 2 && !this.books.get(1).getIsBorrowed()) {
			this.books.get(1).setIsBorrowed(true);
			this.getService().mergeBook(this.books.get(1));
		}

		if (this.books.size() >= 3 && !this.books.get(2).getIsBorrowed()) {
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
		if (id == 0 && id2 == 0 && id3 == 0) {
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
		// TODO:閿熸枻鎷烽敓鏉伴潻鎷烽敓鏂ゆ嫹pagabean瀹為敓鏂ゆ嫹
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}

	// reader閿熸枻鎷疯浣块敓鐭殑鐚存嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹

	public String addBook() throws Exception {
		HttpServletRequest NumRequest = ServletActionContext.getRequest();
		String BookName = this.getModel().getBookName();

		String Location = this.getModel().getLocation();
		String Category = this.getModel().getCategory();
		int Number = Integer.parseInt(NumRequest.getParameter("Num"));
		String isbn = this.getModel().getISBN();
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

	// 閺嶈宓両SBN閸旂姳鍔�
	static String BookName=null;//书名
	static String ISBN=null;
	static String Price=null;//价格
	static String Author=null;//作者
	static String Description=null;//书籍简介
	static String Category=null;//种类
	static String isbn;
	static String ImageAddress=null;//图片地址
	public static String getUrl(String isbn) {//构造URL
		StringBuilder builder= new StringBuilder();
		builder.append("https://api.douban.com/v2/book/isbn/");
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
		String pattern[] = new String[6];
		Pattern patterncompile[] = new Pattern[6];
		Matcher matcher[] =new Matcher[6];
		String group[] = new String[6];
		pattern[0]="<title>(.*)</title>";//匹配书籍名称
		pattern[1]="<db:attribute name=\"price\">(.*?)</db:attribute>";//匹配价格
		pattern[2]="<db:attribute name=\"author\">(.*?)</db:attribute>";//匹配作者
		pattern[3]="<summary>(.*)</summary>";//匹配简介
		pattern[4]="<db:rating(.*?)/>(.*)<gd:rating";//匹配书籍种类
		pattern[5]="rel=\"alternate\"/>	<link href=\"(.*?)\" rel=\"image\"/>";//匹配图片
		for(int i=0;i<6;i++) {
			patterncompile[i]=Pattern.compile(pattern[i]);
			matcher[i]=patterncompile[i].matcher(result);
			if(matcher[i].find()) {
				if(i<=3||i==5) {
				group[i]=matcher[i].group(1);
				}
				else {
				group[i]=matcher[i].group(2);//进行二次匹配
				String[] splitStr = group[i].split("\"");
				String res="";
				for(String str:splitStr) {
					if(Pattern.matches("[\\u4E00-\\u9FA5]+", str))
						res+=str+",";
					
				}
				group[i]=res;
				}
			}
		}
		BookName=group[0];Price=group[1];Author=group[2];Description=group[3];Category=group[4];ImageAddress=group[5];
		if(BookName==null||BookName.isEmpty())BookName="Default Book";
		if(Category==null||Category.isEmpty())Category="Default Category,";
	}
	public static  void parseJSON(String content) {//解析从网页中获取的json格式的数据
	    try
	    {
	            JSONObject jsonObject = new JSONObject(content);
	            BookName = jsonObject.getString("title"); //获取图书名
	            Price = jsonObject.getString("price"); //获取价格
	           String description = "<p>"+jsonObject.getString("summary")+"</p>"; //获取图书简介
	           Description=description.replaceAll("\n", "</p><p>");
	            ISBN = jsonObject.getString("isbn13");//获取ISBN
	            JSONArray AuthorArray = jsonObject.getJSONArray("author");
	            Author="";Category="";
	            for(int i=0;i<AuthorArray.length();i++) {//应对多作者的情况
	            	if(i==AuthorArray.length()-1){
	            		Author+=AuthorArray.get(i);
	            	}else{
	            		Author+=AuthorArray.get(i)+"/";
	            	}
	            }
	            JSONObject ImageAddressObject=jsonObject.getJSONObject("images");
	            ImageAddress = ImageAddressObject.getString("large");//获取图片链接地址
	            JSONArray tagsArray = jsonObject.getJSONArray("tags");
	            for(int i=0;i<tagsArray.length();i++) {
	            	JSONObject tmpObject =new JSONObject(tagsArray.get(i).toString());
	            	Category += tmpObject.getString("name")+",";
	            }
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}	
	

	public String addBookISBN() throws Exception {
		String isbn = this.getModel().getISBN();
		HttpServletRequest NumRequest = ServletActionContext.getRequest();
		String Location = this.getModel().getLocation();
		int Number = Integer.parseInt(NumRequest.getParameter("Number"));
		parseJSON(getContent(getUrl(isbn.strip())));

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
			this.getModel().setImageAddress(ImageAddress);
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
		if (this.getModel().getPrice() != null) {
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

//浠ヤ笅鏄痝et鍜宻et鍑芥暟
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

	public List<Borrowrecord> getBorrowrecords() {
		return borrowrecords;
	}

	public void setBorrowrecords(List<Borrowrecord> borrowrecords) {
		this.borrowrecords = borrowrecords;
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

//admin娣囶喗鏁奸柅鐐埂缂冩岸鍣鹃崪灞界秺鏉╂ɑ婀￠梽锟�
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
