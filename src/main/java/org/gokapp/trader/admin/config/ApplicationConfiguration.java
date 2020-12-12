package org.gokapp.trader.admin.config;

import org.gokapp.trader.common.domain.AppInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gokulr
 *
 */
@Configuration
@EnableSwagger2
public class ApplicationConfiguration {

	@Bean
	public AppInfo appInfo() {
		return new AppInfo("trader-admin");
	}

	public Docket apiSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
}
