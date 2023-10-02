package market.store.business.requests.productRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	
	private int id;
	private int companyId;
	
	@NotBlank(message = "Ürün adı alanı boş bırakılamaz")
	private String name;
	
	@NotNull(message = "Kategori alanı boş bırakılamaz")
	private int categoryId;
	
	@NotNull(message = "Birim fiyat alanı boş bırakılamaz")
	private double unitPrice;
	
	@NotNull(message = "Ürün sayısı alanı boş bırakılamaz")
	private int unitsInStock;

}
