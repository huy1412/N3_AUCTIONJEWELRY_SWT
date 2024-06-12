package com.fpt.edu.main;

import com.fpt.edu.dto.AccountDTO;
import com.fpt.edu.entity.Account;
import com.fpt.edu.entity.Role;
import com.fpt.edu.repository.IAccountRepository;
import com.fpt.edu.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class JewelryAuctionSystemApplicationTests {

	@Mock
	private IAccountRepository accountRepository;

	@InjectMocks
	private AccountService accountService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testLogin_UsernameMustNotBeBlank() {
		String username = " ";
		String password = "password123";

		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			accountService.login(username, password);
		});

		assertEquals("Account not found", exception.getMessage());
	}

	@Test
	void testLogin_PasswordMustNotBeBlank() {
		String username = "username123";
		String password = "";

		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			accountService.login(username, password);
		});

		assertEquals("Account not found", exception.getMessage());
	}

	@Test
	void testLogin_AccountNotFound() {
		String username = "username123";
		String password = "password123";

		when(accountRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.empty());

		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			accountService.login(username, password);
		});

		assertEquals("Account not found", exception.getMessage());
	}

	@Test
	void testLogin_Success() {
		String username = "username123";
		String password = "password123";
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setRole(new Role());
		account.setCreateDate(LocalDateTime.now());

		when(accountRepository.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(account));

		AccountDTO accountDTO = accountService.login(username, password);

		assertNotNull(accountDTO);
		assertEquals(username, accountDTO.getUsername());
	}

}
