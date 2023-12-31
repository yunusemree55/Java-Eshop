package market.store.business.requests.companyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {
	
	private int id;
	private String companyName;
	private String description;
	private String accountEmail;
	private String accountAddress;
	private String accountPhoneNumber;

}
