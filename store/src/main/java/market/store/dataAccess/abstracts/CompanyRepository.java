package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
