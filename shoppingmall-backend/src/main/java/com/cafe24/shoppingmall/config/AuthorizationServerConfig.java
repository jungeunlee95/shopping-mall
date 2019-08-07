package com.cafe24.shoppingmall.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
    @Autowired
    private AuthenticationManager authenticationManager;
    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		// password or authorization code
//		clients.inMemory() 
//			.withClient("pjmall")
//			.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//			.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//			.scopes("read", "write", "trust")
//			.resourceIds("sparklr")
//			.accessTokenValiditySeconds(60);

		
		// client credentials - 메모리(DB에 클라이언트 데이터 없는 경우)
//		clients.inMemory() 
//			.withClient("jemall")
//			.authorizedGrantTypes("password", "client_credentials")
//			.authorities("ROLE_CLIENT")
//			.scopes("read", "write", "trust")
//			.resourceIds("jemall_api")
//			.secret("1234");
//			.accessTokenValiditySeconds(60);
		
		
		
		clients
			.jdbc(dataSource());
//			.and()
//			.withClient("my-client-with-registered-redirect")
//			.authorizedGrantTypes("authorization_code") 
//			.authorities("ROLE_CLIENT") 
//			.scopes("read", "trust") 
//			.resourceIds("sparklr") 
//			.redirectUris("http://localhost:8080") 
//			.and() 
//			.withClient("my-client-with-secret") 
//			.authorizedGrantTypes("client_credentials", "password") 
//			.authorities("ROLE_CLIENT") 
//			.scopes("read") 
//			.resourceIds("sparklr") 
//			.secret("secret");
	}
	
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	// OAuth2 서버가 작동하기 위한 Endpoint에 대한 정보를 설정
        endpoints
        	.tokenStore( new JdbcTokenStore(dataSource()) )
        		.authenticationManager(authenticationManager);
    }
    
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        return new BasicDataSource();
    }
    
}
