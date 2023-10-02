package market.store.business.requests.companyRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyRequest {
	
	@NotBlank(message = "Şirket adı alanı boş bırakılamaz")
	@Size(min = 3, message = "Şirket adı alanı en az 3 karakter içermelidir")
	private String companyName;
	
	@NotBlank(message = "Email alanı boş bırakılamaz")
	private String accountEmail;
	
	@NotBlank(message = "Adres alanı boş bırakılamaz")
	private String accountAddress;
	
	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
	@Size(min = 11,max = 11,message = "Telefon adı alanı 11 haneli olmalıdır")
	private String accountPhoneNumber;
	
	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	@Size(min = 5,message = "Şifre alanı en az 5 karakter içermelidir")
	private String accountPassword;
	
	@NotBlank(message = "Şifre doğrulama alanı boş bırakılamaz")
	private String confirmPassword;

}
