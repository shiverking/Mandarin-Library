package action;

import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.*;

import model.Book;
import model.Borrowrecord;
import model.CurrentRecord;
import model.Librarian;
import service.BookService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import util.ISBNgenerator;
import util.PageBean;

public class BookAction extends BaseAction<Book, BookService> {
	private Book book;
	private List<Book> books;// 閸欘垵鍏樼悮鐜漮okPage閸欐牔鍞敍灞界紦鐠侇喖鐨悽顭掔礉婵″倿娓舵担璺ㄦ暏鐠囬攱鏁煎▔銊╁櫞
	private List<Borrowrecord> borrowrecords;// 閸欘垵鍏樼悮顐㈠灩闂勶拷
	private List<CurrentRecord> currentRecords;// 閹稿洭顣╃痪锔垮姛缁秶娈戞穱鈩冧紖
	private PageBean<Borrowrecord> borrowPage;// 瀹告彃缍婃潻妯兼畱娑旓妇鐫勬穱鈩冧紖
	private PageBean<Book> bookPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	private String isbn1;
	private int bookID2;

	public ISBNgenerator getiSBNgenerator() {
		return iSBNgenerator;
	}
	private String FineValues;
	private String ReturnPeriods;

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

	
	private int bookID3;
	// 闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔活潡閹惧懏瀚归柨鐔告灮閹疯渹濞囬柨鐔虹叓閻ㄥ嫮娅㈤幏鐑芥晸閺夋壆灏ㄩ幏鐑芥晸閺傘倖瀚�

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
	// 娴犮儰绗呴弰顖氬徔娴ｆ挷濞囬悽銊ф畱閸旂喕鍏橀崙鑺ユ殶

	// reader闁跨喐鏋婚幏鐤洣娴ｅ潡鏁撻惌顐ゆ畱閻氬瓨瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
	public String getFineValues() {
		return FineValues;
	}

	public void setFineValues(String fineValues) {
		FineValues = fineValues;
	}

	public String getReturnPeriods() {
		return ReturnPeriods;
	}

	public void setReturnPeriods(String returnPeriods) {
		ReturnPeriods = returnPeriods;
	}

	// 
	public String searchBook() {
		// TODO:閸掑棝銆夐幖婊呭偍
		if (categoryString != null && categoryString.isEmpty()) {
			categoryString = null;
		}
		if (searchContent == null || searchContent.isEmpty()) {
			searchContent = "";
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
			selectSearch = 1;
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
		// TODO:闁跨喐鏋婚幏鐑芥晸閺変即娼婚幏鐑芥晸閺傘倖瀚筽agabean鐎圭偤鏁撻弬銈嗗
		books = new ArrayList<Book>();
		for (CurrentRecord currentRecord : currentRecords) {
			books.add(this.getService().getBookById(currentRecord.getBookID()));
		}
		return SUCCESS;
	}

	public String returnBookByCurrentRecords() {
		this.getBooksbycurrentRecords();
		for (Iterator iterator = books.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			book.setIsBorrowed(false);
			this.getService().mergeBook(book);
		}
		return SUCCESS;
	}
	// reader闁跨喐鏋婚幏鐤洣娴ｅ潡鏁撻惌顐ゆ畱閻氬瓨瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�

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
	// 闁哄秷顫夊畵涓BN闁告梻濮抽崝锟�

	public  String getUrl(String isbn) {// 鏋勯�燯RL
		StringBuilder builder = new StringBuilder();
		builder.append("https://api.douban.com/v2/book/isbn/");
		builder.append(isbn);
		builder.append("?apikey=0b2bdeda43b5688921839c8ecb20399b");
		return builder.toString();
	}

	public String getContent(String urlName) throws IOException {// 鑾峰彇缃戦〉鏄剧ず鐨勫唴瀹�
		String result = "";
		BufferedReader reader = null;
	
			URL url = new URL(urlName);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.connect();// 寤虹珛杩炴帴
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));// 瀹氫箟杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
			String line;
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			if (reader != null)
				try {
					reader.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	
		return result;
	}

	@SuppressWarnings("finally")
	public  String findByISBNinWeb() {// 瑙ｆ瀽浠庣綉椤典腑鑾峰彇鐨刯son鏍煎紡鐨勬暟鎹�
		try {
			JSONObject jsonObject = new JSONObject(this.getContent(this.getUrl(this.getModel().getISBN().strip())));
			this.getModel().setBookName(jsonObject.getString("title")); // 获取书名
			this.getModel().setPrice(jsonObject.getString("price")); // 获取价格
			String description = "<p>" + jsonObject.getString("summary") + "</p>"; // 获取描述
			this.getModel().setIntroduction(description.replaceAll("\n", "</p><p>"));
			this.getModel().setISBN(jsonObject.getString("isbn13"));// 获取isbn
			JSONArray AuthorArray = jsonObject.getJSONArray("author");
			String Author = "";
			for (int i = 0; i < AuthorArray.length(); i++) {// 
				if (i == AuthorArray.length() - 1) {
					Author += AuthorArray.get(i);
				} else {
					Author += AuthorArray.get(i) + "/";
				}
			}
			this.getModel().setAuthor(Author);//获取作者
			JSONObject ImageAddressObject = jsonObject.getJSONObject("images");
			this.getModel().setImageAddress( ImageAddressObject.getString("large"));// 鑾峰彇鍥剧墖閾炬帴鍦板潃
		} catch (Exception e) {
			this.errorMessage="Unable to find this book";
		}finally {
			return SUCCESS;
		}
	}

	public String addBookPage() {
		return SUCCESS;
	}

	public String display() {
		books=new ArrayList<Book>();
		 List<Book> B= this.getService().getAllBooks();
		 Iterator<Book> BI=B.iterator();
		 if(BI.hasNext()) {
			 Book b=BI.next();
			 books.add(b);
		 }
		 while(BI.hasNext())
		 {
			 Book b=BI.next();
			 int length=books.size();
			 if(b.getISBN().equals(books.get(length-1).getISBN())==false)
			 {
				 books.add(b);
			 }
			 
		 }
		return SUCCESS;
	}

	public String deleteBook() {
		Map<String, Object> session = ActionContext.getContext().getSession();//
		Librarian librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
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
		if (this.getModel().getISBN() != null) {
			book.setISBN(this.getModel().getISBN());
		}
		if (this.getModel().getAuthor() != null) {
			book.setAuthor(this.getModel().getAuthor());
		}
		if (this.getModel().getIntroduction() != null) {
			book.setIntroduction(this.getModel().getIntroduction());
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

//娴犮儰绗呴弰鐥漞t閸滃et閸戣姤鏆�
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

//admin濞ｅ浂鍠楅弫濂告焻閻愵剚鍩傜紓鍐╁哺閸ｉ箖宕仦鐣岀Ш閺夆晜蓱濠�锟犳⒔閿燂拷
	public String adminEditBook() {

		String i = this.getModel().getISBN();
		String f = this.FineValues;
		String rp =this.ReturnPeriods;
		if(f.isEmpty())
		{
			this.errorMessage="Please enter number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		if(rp.isEmpty())
		{
			this.errorMessage="Please enter number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		else 
		try {
		int f1 =Integer.parseInt(f);
		int rp1=Integer.parseInt(rp);
		if(f1>=0&rp1>=0)
		{
        List<Book> temBook = this.getService().getAllBooks();
        Iterator<Book> iBook = temBook.iterator();
        while(iBook.hasNext())
        {
        	Book b=iBook.next();
        	if((b.getISBN().equals(i))==true)
        	{
        		b.setFineValue(f1);
        		b.setReturnPeriod(rp1);
        		this.getService().mergeBook(b);
        	}
        }
		return this.display();
		}
		else
		{
			this.errorMessage="Please enter the correct number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
		
		}catch(Exception e)
		{
			this.errorMessage="Please enter the correct number";
			this.display();
			System.out.println(this.errorMessage);
			return INPUT;
		}
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

