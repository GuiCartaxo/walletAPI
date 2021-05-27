package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wallet.entity.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Test");
		u.setPassword("123456");
		u.setEmail("test@test.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
	}
}
