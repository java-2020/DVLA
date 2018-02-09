package com.dvla.readfile.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PropertiesWithJavaConfig.class}, loader = AnnotationConfigContextLoader.class)
public class FileHandlerServiceImplTest {

	@Value("${filepath}" )
	private String path;
    @Autowired
	private FileHandlerServiceImpl readfiles;

	@Test
	public void test() {
		//System.out.print("llllablllablaaaaa" + env.getProperty("filepath"));
		System.out.print("llllablllablaaaaa" + readfiles.getFileNames());
	}

}
