package market.store.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import market.store.business.abstracts.CompanyService;
import market.store.business.requests.companyRequests.AddCompanyRequest;
import market.store.business.requests.companyRequests.UpdateCompanyRequest;
import market.store.business.responses.companyResponses.GetAllCompanyResponse;
import market.store.business.responses.companyResponses.GetCompanyResponse;
import market.store.core.utitilies.mappers.ModelMapperService;
import market.store.dataAccess.abstracts.CompanyRepository;
import market.store.entities.concretes.Company;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {

	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCompanyResponse> getAll() {
		
		List<GetAllCompanyResponse> companyResponseList = companyRepository.findAll().stream().map(company ->
		modelMapperService.forResponse().map(company, GetAllCompanyResponse.class)).collect(Collectors.toList());
		
		return companyResponseList;
	}
	
	@Override
	public GetCompanyResponse getCompanyById(int id) {
		
		Company target = companyRepository.findById(id).orElse(null);
		
		if(target != null) {
			
			GetCompanyResponse companyResponse = modelMapperService.forResponse()
					.map(target, GetCompanyResponse.class);
			
			return companyResponse;
		}
		
		return null;
	}

	@Override
	public void add(AddCompanyRequest addCompanyRequest) {
		
		Company company = modelMapperService.forRequest().map(addCompanyRequest, Company.class);
		
		companyRepository.save(company);

	}
	
	@Override
	public void update(UpdateCompanyRequest updateCompanyRequest) {
		
		Company target = companyRepository.findById(updateCompanyRequest.getId()).orElse(null);
		int accountId = target.getAccount().getId();
		
		target = modelMapperService.forRequest().map(updateCompanyRequest, Company.class);
		target.getAccount().setId(accountId);
		
		
		companyRepository.save(target);
		
		
		
	}
	

	@Override
	public void delete(int id) {
		
		companyRepository.deleteById(id);
		
	}

	

	

}
