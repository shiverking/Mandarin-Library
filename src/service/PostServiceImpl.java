package service;
import model.Post;
import java.util.List;
public class PostServiceImpl extends BaseService<Post>implements PostService{

	
	public List<Post> display(String LibrarainID, String Title, String Content) {
		
		
			
			List<Post> posts = this.getDao().findAll();
			return posts;
		}
	}
	

