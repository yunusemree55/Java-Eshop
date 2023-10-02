package market.store.entities.concretes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import market.store.entities.concretes.photos.ProductPhoto;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="unitPrice")
	private double unitPrice;
	
	@Column(name="unitsInStock")
	private int unitsInStock;
	
	@ManyToOne()
	@JoinColumn(name="companyId")
	private Company company;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<ProductPhoto> productPhotos;
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
}