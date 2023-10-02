package market.store.business.responses.categoryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponse {

	private int id;
	private String name;
	
}
