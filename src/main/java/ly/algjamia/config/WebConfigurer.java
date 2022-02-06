package ly.algjamia.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
	@Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path productUploadDir = Paths.get("./product_images/");
		String productUploadPath = productUploadDir.toFile().getAbsolutePath();
		Path profileUploadDir = Paths.get("./profiles_images/");
		String profileUploadPath = profileUploadDir.toFile().getAbsolutePath();

		registry.addResourceHandler(
	                "/webjars/**",
	                "/img/**",
	                "/css/**",
	                "/js/**",
	                "/assets/**",
	                "/product_images/**",
	                "/profiles_images/**")
	                .addResourceLocations(
	                        "classpath:/META-INF/resources/webjars/",
	                        "classpath:/static/img/",
	                        "classpath:/static/css/",
	                        "classpath:/static/js/",
	                        "classpath:/static/assets/",
	                        "file:/"+productUploadPath+"/",
	                        "file:/"+profileUploadPath+"/");
	  }

}
