package com.project.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.cache.model.Users;

@EnableMongoRepositories(basePackages = "com.project.cache.repository")
//@EnableCaching
@Configuration
public class EhCacheConfiguration {
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(cacheManagerFactory().getObject());
	}
	
	@Bean
    public Users getUsers() {
        return new Users();
    }
 
	@Bean
	public EhCacheManagerFactoryBean cacheManagerFactory() {
		EhCacheManagerFactoryBean bean= new EhCacheManagerFactoryBean();
		 bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		 bean.setShared(true);
		return bean;
	}
}
