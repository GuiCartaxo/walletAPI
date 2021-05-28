package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wallet.entity.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@Before(value = "")
	public void setUp() {
		User u = new User();
		u.setName("Set up User");
		u.setPassword("Senha 123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	@After(value = "")
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Test");
		u.setPassword("123456");
		u.setEmail("test@test.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
	}
	
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		
		assertEquals(response.get().getEmail(), EMAIL);
	}
}
