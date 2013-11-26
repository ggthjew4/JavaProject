//package tw.com.bluetechnology.SpringDeferredResult.config;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@ComponentScan(basePackages = "tw.com.bluetechnology.SpringDeferredResult")
//@EnableScheduling
//public class MvcConfiguration extends WebMvcConfigurationSupport {
//	@Bean
//	public ViewResolver getViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
//
//	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//		configurer.setDefaultTimeout(30 * 1000L);
//	}
//
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new MappingJacksonHttpMessageConverter());
//	}
//}
