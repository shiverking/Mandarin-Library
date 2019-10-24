package service;
import model.*;
import java.util.List;
public class PostServiceImpl extends BaseService<Post>implements PostService{

	
	public List<Post> getAllPosts() {
			List<Post> posts = this.getDao().findAll();
			return posts;
		}
	public void savePost(Post post) {
		// TODO Auto-generated method stub
		this.getDao().save(post);
	}
	}
	

