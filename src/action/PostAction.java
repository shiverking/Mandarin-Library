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
	private static Post post;
	private List<Post> posts;
	public String PostNews() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		post.setLibrarian((Librarian) session.get("librarain")); 
		int PostID=this.getModel().getPostID();
		String Title=this.getModel().getTitle();
		String Content=this.getModel().getContent();
		//Librarian librarian=this.getModel().getLibrarian();
		this.getModel().setContent(Content);;
		this.getModel().setLibrarian(new Librarian (2,"123"));
		this.getModel().setTitle(Title);
		this.getModel().setPostID(PostID);;
		this.getService().savePost(this.getModel());
		return SUCCESS;
	}
	public static Post getPost() {
		return post;
	}
	public static void setPost(Post post) {
		PostAction.post = post;
	
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
