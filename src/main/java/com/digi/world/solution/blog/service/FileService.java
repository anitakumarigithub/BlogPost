package com.digi.world.solution.blog.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
String uploadImage(String path,MultipartFile file) throws IOException;
}
