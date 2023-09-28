package market.store.business.abstracts;

import java.util.List;

import market.store.business.requests.companyRequests.AddCompanyRequest;
import market.store.business.requests.companyRequests.UpdateCompanyRequest;
import market.store.business.responses.companyResponses.GetAllCompanyResponse;
import market.store.business.responses.companyResponses.GetCompanyResponse;

public interface CompanyService {
	
	List<GetAllCompanyResponse> getAll();
	GetCompanyResponse getCompanyById(int id);
	void add(AddCompanyRequest addCompanyRequest);
	void update(UpdateCompanyRequest updateCompanyRequest);
	void delete(int id);

}
