package market.store;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import market.store.core.utitilies.exceptions.BusinessException;
import market.store.core.utitilies.exceptions.ProblemDetail;
import market.store.core.utitilies.exceptions.ValidationProblemDetail;

@SpringBootApplication
@RestControllerAdvice
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper;
	}
	
	@Bean
	public ProblemDetail problemDetail() {
		return new ProblemDetail();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetail validationProblemDetail = new  ValidationProblemDetail();
		
		validationProblemDetail.setMessage("Validasyon hatası meydana geldi");
		validationProblemDetail.setErrorDetails(new HashMap<String, String>());
		
		for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors()) {
			
			validationProblemDetail.getErrorDetails().put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		return validationProblemDetail;
		
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleBusinessException(BusinessException businessException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(businessException.getMessage());
		
		return problemDetail;
		
		
	}
	
	
	
}
