package co.orffosoft;

import java.util.Arrays;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.sql.DataSource;

import org.jasypt.digest.PooledStringDigester;
import org.jasypt.digest.StringDigester;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import co.orffosoft.core.util.TrackFilter;
import co.orffosoft.entity.UserMaster;
import co.orffosoft.rest.util.BasePermissionEvaluator;
import co.orffosoft.rest.util.UserAuditAware;
import lombok.extern.log4j.Log4j2;

/**
 * @author Pratap Kumar Sahu
 *
 */

@SpringBootApplication
@EntityScan
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@ImportResource("classpath:operation_security.xml")
@Log4j2
public class OrffosoftRestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		SpringApplication.run(OrffosoftRestApplication.class, args);
		stopwatch.stop();
		final double execuationTime = stopwatch.getTotalTimeSeconds();
		log.info("Application Successfully Deployed In Seconds "+execuationTime);

	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().getMatchingStrategy();
		return modelMapper;
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
	public AuditorAware<UserMaster> auditorAware() {
		UserAuditAware userAuditAware = new UserAuditAware();
		log.info("auditorAware >>>> " + userAuditAware.getCurrentAuditor());
		if (userAuditAware.getCurrentAuditor() != null) {
			log.info("current user >>>> " + userAuditAware.getCurrentAuditor());
		}
		return userAuditAware;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

	@Bean
	protected MethodSecurityExpressionHandler expressionHandler() {
		log.info("Inside expressionHandler()");
		DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new BasePermissionEvaluator());

		return expressionHandler;
	}

}