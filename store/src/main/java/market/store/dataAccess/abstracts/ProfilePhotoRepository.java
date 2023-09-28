package market.store.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import market.store.entities.concretes.ProfilePhoto;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Integer> {

}
