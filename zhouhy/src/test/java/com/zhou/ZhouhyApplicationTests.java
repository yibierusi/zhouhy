package com.zhou;

import com.zhou.index.config.MyAspectTestClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhouhyApplicationTests {

	@Test
	public void contextLoads() {
		MyAspectTestClass matc = new MyAspectTestClass();
		matc.aspectTestFunc();
	}


}
