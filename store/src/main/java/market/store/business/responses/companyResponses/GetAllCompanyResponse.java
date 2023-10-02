package market.store.business.responses.companyResponses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import market.store.business.responses.productResponses.GetProductResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCompanyResponse {
	
	private int id;
	private String companyName;
	private String description;
	private String email;
	private String address;
	private String phoneNumber;
	private String url;
	private List<GetProductResponse> products;

}
