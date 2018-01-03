package com.modules;

import com.zhou.index.config.MyAspectTestClass;
import com.zhou.index.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhouhyApplicationTests {

	@Test
	public void contextLoads() {
		MyAspectTestClass matc = new MyAspectTestClass();
		matc.aspectTestFunc();
	}


}
