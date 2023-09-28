package market.store.business.responses.customerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;
	private String url;
 
}
