package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	

}
