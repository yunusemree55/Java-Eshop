package market.store.business.requests.customerRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
	
	private int id;
	
	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@Size(min = 3)
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılamaz")
	@Size(min = 3)
	private String lastName;
	
	@NotBlank(message = "Email alanı boş bırakılamaz")
	private String accountEmail;
	
	@NotBlank(message = "Adres alanı boş bırakılamaz")
	private String accountAddress;
	
	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
	private String accountPhoneNumber;
	
	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	private String accountPassword;
	
	@NotBlank(message = "Şifre doğrulama alanı boş bırakılamaz")
	private String accountConfirmPassword;
	
	

}
