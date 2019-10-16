package service;
import model.*;
import util.PageBean;

import java.util.List;
public class PostServiceImpl extends BaseService<Post>implements PostService{

	
	public List<Post> getAllPosts() {
			List<Post> posts = this.getDao().findAll("PostID desc");
			return posts;
		}
	public void savePost(Post post) {
		this.getDao().save(post);
	}
	public PageBean<Post> getPageBean(String cond, Integer pageNum) {
		int current = 1;
		if (pageNum != null) {
			current=pageNum;
		}
		int totalRecords = this.getDao().findTotalNumbyTwoSubstring("Title", "Content", cond);
		PageBean<Post> postPageBean = new PageBean<Post>(totalRecords, current);
		postPageBean.setDataList(this.getDao().findPageByTwoSubstring("Title", "Content", cond,cond,
				postPageBean.getStartIndex(), postPageBean.getPageSize()));
		return postPageBean;
	}
	
	public List<Post> getAllPosts(String cond) {
		List<Post> posts = this.getDao().findAll(cond);
		return posts;
	}
	
	public Post getPostById(int id) {
		Post post = this.getDao().get(id);
		return post;
	}
	
	public List<Post> getPostByTitle(String cond) {
		return this.getDao().findBySubString("Title", cond);
	}
	
	public List<Post> getPostsByContent(String cond) {
		return this.getDao().findBySubString("Content", cond);
	}
	
	public void deletePostById(int id) {
		this.getDao().delete(id);
	}
	
	public List<Post> getBookByTitleorContent(String cond1) {
		return this.getDao().findByTwoProperty("Title", "Content", cond1);
	}
	}
	

