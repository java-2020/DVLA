package com.dvla.readfile.service;

import static java.util.Arrays.asList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dvla.readfile.model.FileInfo;

@Service
public class FileHandlerServiceImpl implements FileHandlerService {
	
	
	@Value("${filepath}" )
	private String path;
	
    public List<FileInfo> getFileNames() {
        List<FileInfo> fileInfos = new ArrayList<>();
        List<String> supportedTypes = asList(".xlsx", ".xls", ".csv");
        File dir = new File(path);
        File[] files = dir.listFiles((d, name) -> supportedTypes.stream().anyMatch(ext -> name.endsWith(ext)));
        MimetypesFileTypeMap fileMap = new MimetypesFileTypeMap();
        for (File f : files) {
            fileInfos.add(new FileInfo(f.getName(), FilenameUtils.getExtension(f.getName()), FileUtils
                    .byteCountToDisplaySize
                    (FileUtils.sizeOf(f)), fileMap.getContentType(f)));
        }
        return fileInfos;
    }
}
