package com.digi.world.solution.digi.worldController;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digi.world.solution.blog.model.BlogPost;
import com.digi.world.solution.blog.repository.BlogRepository;
import com.digi.world.solution.blog.service.BlogService;
@RestController
public class BlogPostController {
	@Autowired
	BlogService blogService;
	
	@PostMapping("/createBlog")
public ResponseEntity<String> createBlog(@RequestBody BlogPost blog) {
	return blogService.createBlog(blog);
}
	
	@PostMapping("/updateBlogById")
	public ResponseEntity<String> updateBlogByID(@RequestParam("blogid") Long id, @RequestBody BlogPost updateBlog) {
		return blogService.updateBlogByID(id, updateBlog);
		
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<String> deleteBlogByID(@RequestParam("blogid") Long id) {
		return blogService.deleteBlogByID(id);
	}
	
	@GetMapping("/allbloglist")
	public List<BlogPost> getAllBlogList() {
		return blogService.getAllBlogList();
	}
	
	@GetMapping("/getBlogByID")
	public BlogPost getBlogByID(@RequestParam("blogid") Long id) {
		return blogService.getBlogByID(id);
	}
	

}
