package com.spring.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class UploadController {

	
	@GetMapping("/upload")
	public String getUploadForm(HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "Login";
		}
		return "UploadImage";
	}
	
//	@PostMapping("/upload")
//	public String saveImage(@RequestParam MultipartFile image, Model model) {
//		
//		if(!image.isEmpty()) {
//			try {
//				Files.copy(image.getInputStream(),Path.of("src/main/resources/static/images/"+ image.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
//			model.addAttribute("msg","upload success");
//			return "UploadImage";
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		model.addAttribute("msg","upload failed!!!");
//		return "UploadImage";
//	}
	
	@PostMapping("/upload")
	public String saveImage(@RequestParam MultipartFile image, Model model) {
	    if (!image.isEmpty()) {
	        try {
	            Path imagePath = Path.of("src/main/resources/static/images/" + image.getOriginalFilename());
	            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
	            
	            model.addAttribute("msg", "Upload success");
	            model.addAttribute("imagePath", "/images/" + image.getOriginalFilename()); // Add this line to pass the image path to the model
	            
	            return "UploadImage";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    model.addAttribute("msg", "Upload failed!!!");
	    return "UploadImage";
	}
	
}
