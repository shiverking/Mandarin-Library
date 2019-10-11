package action;

import java.util.ArrayList;
import java.util.List;

import model.Librarian;
import model.Post;
import service.PostService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class PostAction extends BaseAction<Post,PostService> {

	private static final long serialVersionUID = 1L;
	private static Post post;
	private List<Post> posts;
	public String postNews() {
		String PostID=this.getModel().getPostID();
		String Title=this.getModel().getTitle();
		String Content=this.getModel().getContent();
		Librarian librarian=this.getModel().getLibrarian();
		this.getModel().setContent(Content);;
		this.getModel().setLibrarian(librarian);
		this.getModel().setTitle(Title);
		this.getModel().setPostID(PostID);
		return SUCCESS;
	}

	
}
