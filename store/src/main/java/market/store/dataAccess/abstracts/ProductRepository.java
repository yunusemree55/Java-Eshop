package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
}
