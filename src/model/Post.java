package model;

public class Post {
	private int PostID;
	private String Title;
	private String Content;

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(Integer id, String title, String content) {
		// super();
		this.PostID = id;
		Title = title;
		Content = content;
	}

	public void setPostID(int id) {
		this.PostID = id;
	}

	public int getPostID() {
		return this.PostID;
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

}
