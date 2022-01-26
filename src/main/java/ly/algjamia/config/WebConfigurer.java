package ly.algjamia.config;

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
		   registry.addResourceHandler(
	                "/webjars/**",
	                "/img/**",
	                "/css/**",
	                "/js/**",
	                "/assets/**")
	                .addResourceLocations(
	                        "classpath:/META-INF/resources/webjars/",
	                        "classpath:/static/img/",
	                        "classpath:/static/css/",
	                        "classpath:/static/js/",
	                        "classpath:/static/assets/");
	  }

}
