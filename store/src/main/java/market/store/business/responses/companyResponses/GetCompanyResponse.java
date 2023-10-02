package market.store.business.responses.companyResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import market.store.business.responses.productResponses.GetProductResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyResponse {
	
	private int id;
	private String companyName;
	private String description;
	private String accountEmail;
	private String accountAddress;
	private String accountPhoneNumber;
	private List<GetProductResponse> products;

}
