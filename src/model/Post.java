package model;

public class Post {
	private String PostID;
	private String Title;
	private String Content;
	private Librarian librarian;//图书馆馆员，此记录用于图书馆管理员向主页post
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	public Post(String title, String content) {
		// super();
		Title = title;
		Content = content;
	}
	
	public String getPostID() {
		return PostID;
	}
	
	public void setPostID(String postID) {
		PostID = postID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

}
