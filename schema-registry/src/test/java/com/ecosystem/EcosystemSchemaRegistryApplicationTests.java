package com.ecosystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.netflix.discovery.shared.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EcosystemSchemaRegistryApplicationTests {

	@Test
	public void contextLoads() {
	}

}
