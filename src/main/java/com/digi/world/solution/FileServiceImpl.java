package com.digi.world.solution;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digi.world.solution.blog.service.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub\
		String name=file.getOriginalFilename();
		String filePath=path+File.separator+name;
		
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdirs();
		}
		
		Files.copy(file.getInputStream(),Paths.get(filePath ),StandardCopyOption.REPLACE_EXISTING);

		return filePath;
		
	}
		
		
	}



	

