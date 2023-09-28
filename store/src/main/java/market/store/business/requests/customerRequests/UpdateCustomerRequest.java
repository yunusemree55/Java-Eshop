package market.store.business.requests.customerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
	
	private int id;
	private String firstName;
	private String lastName;
	private String accountEmail;
	private String accountAddress;
	private String accountPhoneNumber;
	private String accountPassword;
	private String accountConfirmPassword;

}
