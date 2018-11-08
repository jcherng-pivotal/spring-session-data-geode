/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerConfigurer;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

// tag::class[]
@CacheServerApplication(name = "SpringSessionSampleJavaConfigGemFireClientServer", logLevel = "error") // <1>
@EnableGemFireHttpSession(maxInactiveIntervalInSeconds = 30) // <2>
@EnableManager(start = true) // <3>
public class ServerConfig {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		new AnnotationConfigApplicationContext(ServerConfig.class).registerShutdownHook();
	}

	// Required to resolve property placeholders in Spring @Value annotations.
	@Bean
	static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	CacheServerConfigurer cacheServerPortConfigurer(
			@Value("${spring.session.data.geode.cache.server.port:40404}") int port) { // <4>

		return (beanName, cacheServerFactoryBean) -> {
			cacheServerFactoryBean.setPort(port);
		};
	}
}
// end::class[]
