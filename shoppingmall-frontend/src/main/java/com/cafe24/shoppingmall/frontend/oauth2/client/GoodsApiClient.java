package com.cafe24.shoppingmall.frontend.oauth2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

@Component
public class GoodsApiClient {
	
	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;

	
//	private final String API_URL = "http://localhost:8888/v1/hello";
//	
//	private String accessToken;
//	private RestTemplate apiRestTemplate;
//	
//	
//	// 최초에 AccessToken 발급이 성공하고, SuccessHandler를 통해서 이 메소드가 호출 된다.
//	public void init(OAuth2AccessToken accessToken) {
//		this.accessToken = accessToken.getValue();
//	}
//	
//	
//	// 원하는 Api의 객체를 얻기 위한 메소드 파라미터로 입력한 class 타입으로 Api객체를 생성하여 반환
//	public <T> T getOperation(Class<T> operation) 
//			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//
//		// 공통으로 사용될 restTemplate 생성.
//		
//		apiRestTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
//		apiRestTemplate.setInterceptors(Arrays.asList( new ClientHttpRequestInterceptor() {
//			@Override
//			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//					throws IOException {
//				HttpRequest protectedResourceRequest = new HttpRequestWrapper(request);
//				protectedResourceRequest.getHeaders().set("Authorization", "Bearer " + accessToken);
//				protectedResourceRequest.getHeaders().set("Content-Type", "application/json");
//				
//				return execution.execute(protectedResourceRequest, body);
//			}
//		}));
//		
//		Constructor<T> constructor = operation.getConstructor(RestTemplate.class, String.class);
//		T returnObject = constructor.newInstance(apiRestTemplate, API_URL);
//		
//		return returnObject;
//	}
}
