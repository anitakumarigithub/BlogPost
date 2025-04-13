package com.digi.world.solution.blog.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digi.world.solution.blog.model.BlogPost;

public interface BlogService {
	
	public ResponseEntity<String> createBlog(BlogPost blog) ;
	
	public ResponseEntity<String> updateBlogByID(Long id, BlogPost updateBlog) ;
	
	public ResponseEntity<String> deleteBlogByID(Long id) ;
	
	public List<BlogPost> getAllBlogList();
	
	public BlogPost getBlogByID(Long id);
	
	

}
