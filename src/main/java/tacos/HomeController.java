 package tacos;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	//@Controller            // <1>
	//public class HomeController {

	 // @GetMapping("/")     // <2>
	//  public String home() {
	  //  return "home";     // <3>
	//  }

	//}
//WebConfig
	
	@Configuration
	public class HomeController implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("home"); }
	}

