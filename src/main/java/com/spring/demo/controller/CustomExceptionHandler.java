package com.spring.demo.controller;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	 @ExceptionHandler(FileSizeLimitExceededException.class)
	    public String handleFileSizeLimitExceeded(FileSizeLimitExceededException ex, Model model) {
	        model.addAttribute("message", "File size exceeds the maximum limit of 1MB");
	        return "UploadImage";
	    }

}
