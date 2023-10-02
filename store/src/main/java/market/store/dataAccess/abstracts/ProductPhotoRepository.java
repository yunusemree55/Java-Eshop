package market.store.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.photos.ProductPhoto;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Integer> {
	
	List<ProductPhoto> getProductPhotosByProductId(int id);

}
