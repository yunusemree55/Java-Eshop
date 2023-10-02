package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
