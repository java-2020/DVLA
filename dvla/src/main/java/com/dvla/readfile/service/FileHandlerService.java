package com.dvla.readfile.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dvla.readfile.model.FileInfo;
@Service
public interface FileHandlerService {
	
	  public List<FileInfo> getFileNames();

}
