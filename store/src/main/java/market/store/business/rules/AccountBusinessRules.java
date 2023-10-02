package market.store.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.core.utitilies.exceptions.BusinessException;
import market.store.dataAccess.abstracts.AccountRepository;

@Service
@AllArgsConstructor
public class AccountBusinessRules { 
	
	private AccountRepository accountRepository;
	
	
	public void existsAccountByEmail(String email) {
		
		if(accountRepository.existsAccountByEmail(email) == true) {
		
			 throw new BusinessException("Böyle bir email sisteme kayıtlı");
		}
		
	}
	
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			
			throw new BusinessException("Şifreler uyuşmuyor");
		}
		
	}

}
