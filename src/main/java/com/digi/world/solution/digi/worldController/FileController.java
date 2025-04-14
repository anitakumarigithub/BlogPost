package com.digi.world.solution.digi.worldController;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digi.world.solution.blog.service.FileService;
import com.digi.world.solution.digi.playload.FileResponse;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@Value("${file.upload-dir}")
	private String path;

	@PostMapping("/upload")
	public ResponseEntity<String> fileUpload(@RequestParam("image") MultipartFile file) {
		String fileName = null;
		try {

			fileName = fileService.uploadImage(path, file);
			return ResponseEntity.ok("Image uploaded successfully: " + path);

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");

		}

	}
	@GetMapping("/images/{filename}")
	public ResponseEntity<?> getImage(@PathVariable String filename) {
	    try {
	        Path filePath = Paths.get(path).resolve(filename);
	        Resource resource = new UrlResource(filePath.toUri());
	        
	        if (resource.exists()) {
	            return ResponseEntity.ok()
	                    .contentType(MediaType.IMAGE_JPEG)
	                    .body(resource);
	        } else {
	            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Image Doen't Exist");
	        }
	    } catch (MalformedURLException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@DeleteMapping("/images/{filename}")
	public ResponseEntity<String> deleteImage(@PathVariable String filename) {
	    try {
	        Path filePath = Paths.get(path).resolve(filename);
	        Resource resource = new UrlResource(filePath.toUri());
	        File f = new File(filePath.toString());
	        
	        if (f.exists()) {
	        	f.delete();
	        	
	            return ResponseEntity.ok("Image is Deleted successfully!!");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (MalformedURLException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


}
