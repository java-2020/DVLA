package com.dvla.readfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dvla.readfile.model.FileInfo;
import com.dvla.readfile.service.FileHandlerService;;

@SpringBootApplication
public class ReadFileApplication {
	@Autowired
	private FileHandlerService readfiles;

	public static void main(String[] args) {
		SpringApplication.run(ReadFileApplication.class, args);
	}
//	@Override
//	public void run(String... arg0) throws Exception {
//		// clear all record if existed before do the tutorial with new data 
//		List<FileInfo> files = readfiles.getFileNames();
//		files.forEach((e)-> System.out.println(e));
//		
//	}
}
