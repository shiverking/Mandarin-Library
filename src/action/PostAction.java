package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Book;
import model.Borrowrecord;
import model.CurrentRecord;
import model.Librarian;
import model.Post;
import service.*;
import util.ISBNgenerator;
import util.PageBean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

public class PostAction extends BaseAction<Post,PostService> {

	private static final long serialVersionUID = 1L;
	private Post post;
	private List<Post> posts;
	private PageBean<Post> postPage;
	private Integer pageNum;
	private ISBNgenerator iSBNgenerator;
	private String searchContent;
	public String PostNews() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.getModel().setLibrarian((Librarian) session.get("librarian")); 
		//Librarian librarian=this.getModel().getLibrarian();
		this.getService().savePost(this.getModel());
		return SUCCESS;
		
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String displayPosts() {
		this.posts = this.getService().getAllPosts();
		return SUCCESS;
	}
	public String searchPost() {
		// TODO:��ҳ����
		postPage = this.getService().getPageBean(searchContent, pageNum);
		return SUCCESS;
	}
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public PageBean<Post> getPostPage() {
		return postPage;
	}

	public void setBookPage(PageBean<Post> postPage) {
		this.postPage = postPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
}
