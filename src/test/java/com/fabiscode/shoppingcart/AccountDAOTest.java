package com.fabiscode.shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import com.fabiscode.entity.Account;


//import entity.Account;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.AUTO_CONFIGURED)
@Rollback(false)
public class AccountDAOTest {

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
    private AccountDAOTest accountDAO;
	
	//@Autowired
	//private TestEntityManager entityManager;
	
	
	
	@Test
	public void testCreateAccount() {
		
		Account user = new Account();
		user.setUserName("manager3");
		user.setActive(true);
		user.setEncrytedPassword("fabian123");
		user.setUserRole("Role_MANAGER");
		
		
		Account savedAccount = accountDAO.save(user);
		Account existAccount = ((TestEntityManager) sessionFactory).find(Account.class, savedAccount.getEncrytedPassword());   //getId());
		
	//	assertThat(existAccount.getUserName().isEqualTo(user.getUserName()));
		
		

	}

	private Account save(Account user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
