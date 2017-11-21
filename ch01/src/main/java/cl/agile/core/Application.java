package cl.agile.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
    }

    /**
     * An opinionated WebApplicationInitializer to run a SpringApplication from a traditional WAR deployment.
     * Binds Servlet, Filter and ServletContextInitializer beans from the application context to the servlet container.
     *
     * @link http://docs.spring.io/spring-boot/docs/current/api/index.html?org/springframework/boot/context/web/SpringBootServletInitializer.html
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }  

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")           
                    .authorizeRequests().anyRequest().permitAll()
            ;
        }
    }
    
    @EnableWebMvc
    @Configuration
    @ComponentScan("cl.agile.core.controller")
    public static class CustomConfigurerAdapter extends WebMvcConfigurerAdapter {
    	
    	@Bean
    	public CommonsMultipartResolver getMultipartResolver(){
    		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    		resolver.setMaxUploadSize(1000000);
    		return resolver;
    	}    	
    	
    	@Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setViewClass(JstlView.class);
            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");
            registry.viewResolver(resolver);
        }
    	
    	@Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    	}
    }
}
