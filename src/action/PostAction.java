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

public class PostAction extends BaseAction<Post, PostService> {

	private static final long serialVersionUID = 1L;
	private static Post post;
	private List<Post> posts;

	public String PostNews() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.getModel().setLibrarian((Librarian) session.get("librarian"));
		if (this.getModel().getLibrarian()==null) {
			return INPUT;
		}
		System.out.println(this.getModel().getLibrarian().getLibrarianID());
		// Librarian librarian=this.getModel().getLibrarian();
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

	public String deletePost() {// É¾³ýÊé¼®
		this.getService().deletePostByID(post.getPostID());
		return SUCCESS;
	}

	public String editPost() {
		Post tmpPost = this.getService().getPostByID(post.getPostID());
		tmpPost.setContent(this.getModel().getContent());
		tmpPost.setTitle(this.getModel().getTitle());
		this.getService().editPostByID(tmpPost);
		return SUCCESS;
	}
	public String displaySingleNews() {
		post=this.getService().getPostByID(post.getPostID());
		return SUCCESS;
	}
}
