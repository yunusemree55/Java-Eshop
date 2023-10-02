package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.abstracts.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	boolean existsAccountByEmail(String email);
	

}
