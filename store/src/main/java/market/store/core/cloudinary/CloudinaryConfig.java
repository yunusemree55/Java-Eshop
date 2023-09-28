package market.store.core.cloudinary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

	private String CLOUD_NAME = "dsuxjcwe1";
	private String API_KEY = "138879455648579";
	private String API_SECRET = "4tGY6hj9yvH9pELX3j6EEXJH9lA";
	
	@Bean
	public Cloudinary cloudinary() {
		
		Map<String, String> config = new HashMap<String, String>();
		
		config.put("cloud_name", CLOUD_NAME);
		config.put("api_key", API_KEY);
		config.put("api_secret", API_SECRET);
		
		return new Cloudinary(config);
		
		
		
	}
	
	
	
}
