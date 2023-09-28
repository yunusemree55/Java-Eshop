package market.store.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import market.store.entities.concretes.Company;
import market.store.entities.concretes.Customer;
import market.store.entities.concretes.ProfilePhoto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	@OneToOne(mappedBy = "account")
	private Company company;
	
	@OneToOne(mappedBy = "account")
	private ProfilePhoto photo;

}
