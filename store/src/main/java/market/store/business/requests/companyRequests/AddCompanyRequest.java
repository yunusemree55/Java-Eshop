package market.store.business.requests.companyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyRequest {
	
	private String companyName;
	private String accountEmail;
	private String accountAddress;
	private String accountPhoneNumber;
	private String accountPassword;
	private String confirmPassword;

}
