/**
 * 
 */
package co.orffosoft;

import java.util.Arrays;
import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.jasypt.digest.PooledStringDigester;
import org.jasypt.digest.StringDigester;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import co.orffosoft.core.util.TrackFilter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Pratap Kumar Sahu
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@Log4j2
public class OrffosoftClientApplication extends SpringBootServletInitializer {

//	@Autowired
//	AppPreference appPreference;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" =====>> bean yet to create   ===>>> ");
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		ApplicationContext applicationContext = 
				SpringApplication.run(OrffosoftClientApplication.class, args);
		for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(" bean created classes   "+name);
        }
		stopwatch.stop();
		final double execuationTime = stopwatch.getTotalTimeSeconds();
		log.info("Application Successfully Deployed In Seconds "+execuationTime);

	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.xhtml");

	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;

	}

	@Bean
	public FilterRegistrationBean trackFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new TrackFilter());
		filterRegBean.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		filterRegBean.setOrder(1);
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegBean;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// resolver.setPrefix("/view/");
		resolver.setPrefix("/");
		resolver.setSuffix(".xhtml");
		return resolver;
	}

	@Bean
	public ServletContextInitializer initializer() {
		return new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {

				// for development
				servletContext.setInitParameter("primefaces.UPLOADER", "commons");
				// for release
				// servletContext.setInitParameter("primefaces.UPLOADER",
				// "native");

			}
		};
	}

	@Bean
	public FilterRegistrationBean FileUploadFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new org.primefaces.webapp.filter.FileUploadFilter());
		registration.setName("PrimeFaces FileUpload Filter");
		// registration.setDispatcherTypes(DispatcherType.FORWARD);
		return registration;
	}

	@Bean
	StringDigester PasswordHash() {
		final PooledStringDigester stringDigester = new PooledStringDigester();
		stringDigester.setAlgorithm("SHA-256");
		stringDigester.setIterations(1000);
		stringDigester.setSaltSizeBytes(10);
		stringDigester.setPoolSize(16);
		stringDigester.initialize();
		return stringDigester;

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
