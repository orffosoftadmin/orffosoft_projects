package co.orffosoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@ComponentScan
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/login.xhtml?faces-redirect=true");
		super.addViewControllers(registry);
	}

	/**
	 * Initialise Tiles on application startup and identify the location of the
	 * tiles configuration file, tiles.xml.
	 * 
	 * @return tiles configurer
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		//configurer.setDefinitions(new String[] { "WEB-INF/tiles/tilesJSP.xml", "WEB-INF/tiles/tilesThymeleaf.xml" });
		configurer.setDefinitions(new String[] { "WEB-INF/tiles/tilesJSP.xml" });
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	// https://stackoverflow.com/questions/27583278/spring-boot-spring-mvc-thymeleaf-apache-tiles
	// https://github.com/songwie/springboot--thymeleaf-tiles-demo/blob/master/src/main/webapp/WEB-INF/thymeleaf/common/baseLayout.html
	// https://www.concretepage.com/spring-4/spring-4-mvc-thymeleaf-annotation-integration-tutorial-with-internationalization-example-using-springtemplateengine-and-thymeleafviewresolver
	// https://github.com/momokan/spring-boot-sample/blob/master/spring-boot/src/main/java/hello/config/ThymeleafConfig.java
	// https://github.com/mintster/nixmash-spring
	// https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/
	// https://stackoverflow.com/questions/27583278/spring-boot-spring-mvc-thymeleaf-apache-tiles
	// https://www.programcreek.com/java-api-examples/index.php?source_dir=gs-spring-security-3.2-master/src/main/java/sample/mvc/config/WebMvcConfiguration.java
	
	// http://www.oodlestechnologies.com/blogs/Use-Thymeleaf-And-JSP-Simultaneously-In-Spring-Boot-App
	// https://memorynotfound.com/spring-boot-thymeleaf-configuration-example/

	/**
	 * Introduce a Tiles view resolver, this is a convenience implementation
	 * that extends URLBasedViewResolver.
	 * 
	 * @return tiles view resolver
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	// @Bean
	// public ThymeleafViewResolver thymeleafViewResolver() {
	// ServletContextTemplateResolver servletContextTemplateResolver = new
	// ServletContextTemplateResolver();
	//
	// servletContextTemplateResolver.setPrefix("/WEB-INF/tiles/view/thymeleaf/");
	// servletContextTemplateResolver.setSuffix(".html");
	// servletContextTemplateResolver.setTemplateMode("HTML5");
	// servletContextTemplateResolver.setCharacterEncoding("UTF-8");
	// servletContextTemplateResolver.setCacheable(true);
	//
	// SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
	// springTemplateEngine.setTemplateResolver(servletContextTemplateResolver);
	//
	// ThymeleafViewResolver thymeleafViewResolver = new
	// ThymeleafViewResolver();
	// thymeleafViewResolver.setCharacterEncoding("UTF-8");
	// thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
	//
	// return thymeleafViewResolver;
	// }
}
