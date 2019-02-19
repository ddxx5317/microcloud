package com.ddxx.microcloud.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUplaodController {
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public @ResponseBody String fileUpload(@RequestParam(value="file",required=true) MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		
	    File fileToSave = new File(file.getOriginalFilename());
	    FileCopyUtils.copy(bytes, fileToSave);
		return file.getOriginalFilename();
	}
}
