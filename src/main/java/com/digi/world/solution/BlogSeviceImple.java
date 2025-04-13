package com.digi.world.solution;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digi.world.solution.blog.model.BlogPost;
import com.digi.world.solution.blog.repository.BlogRepository;
import com.digi.world.solution.blog.service.BlogService;
@Service
public class BlogSeviceImple implements BlogService {
@Autowired
BlogRepository blogRepository;
	@Override
	public ResponseEntity<String> createBlog(BlogPost blog) {
		// TODO Auto-generated method stub
		blogRepository.save(blog);
		ResponseEntity<String> res = new ResponseEntity<String>("SUCESS",HttpStatusCode.valueOf(201));
		return res;
	}

	@Override
	public ResponseEntity<String> updateBlogByID(Long id, BlogPost updateBlog) {
		BlogPost p=getBlogByID(id);
		if(p != null) {
		p.setBlogCategory(updateBlog.getBlogCategory());
		p.setDescription(updateBlog.getDescription());
		blogRepository.save(p);
		ResponseEntity<String> res = new ResponseEntity<String>("Updated Successfully",HttpStatusCode.valueOf(200));
		return res;

	}
	
	
		// TODO Auto-generated method stub
	
	
	ResponseEntity<String> res = new ResponseEntity<String>("Doen't Exist",HttpStatusCode.valueOf(404));
	return res;

	
	}

	@Override
	public ResponseEntity<String> deleteBlogByID(Long id) {
		// TODO Auto-generated method stub
		
		if(getBlogByID(id)!= null) {
			blogRepository.deleteById(id);
			ResponseEntity<String> res = new ResponseEntity<String>("Successfully Deleted",HttpStatusCode.valueOf(200));
			return res;
		}
		ResponseEntity<String> res = new ResponseEntity<String>("Blog post doesn't exist ",HttpStatusCode.valueOf(200));
		return res;

	}

	@Override
	public List<BlogPost> getAllBlogList() {
		// TODO Auto-generated method stub
		return blogRepository.findAll();
	}

	@Override
	public BlogPost getBlogByID(Long id) {
		Optional<BlogPost> existEntity=blogRepository.findById(id);
	if(existEntity.isPresent()) {
		return existEntity.get();
	}
		
		return null;
	}

}
