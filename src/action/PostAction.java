package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Librarian;
import model.Post;
import service.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

public class PostAction extends BaseAction<Post,PostService> {

	private static final long serialVersionUID = 1L;
	private Post post;
	private List<Post> posts;
	public String PostNews() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.getModel().setLibrarian((Librarian) session.get("librarian")); 
		System.out.println(this.getModel().getLibrarian().getLibrarianID());
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

}
