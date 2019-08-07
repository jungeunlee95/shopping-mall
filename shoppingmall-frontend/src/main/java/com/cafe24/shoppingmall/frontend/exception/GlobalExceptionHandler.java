package com.cafe24.shoppingmall.frontend.exception;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cafe24.shoppingmall.frontend.dto.JSONResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Log LOGGER = LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler( Exception.class )
	public void handlerException( HttpServletRequest request, 
									HttpServletResponse response,
									Exception e) throws Exception {
		// 1. 로깅
		e.printStackTrace(); 
		StringWriter errors = new StringWriter(); // 버퍼 
		e.printStackTrace(new PrintWriter(errors));
		LOGGER.error(errors.toString());
		System.out.println(errors.toString());
		 
		// json 응답 처리
		String accept = request.getHeader("accept");
		// accept=text/html; image/jpeg; application/json 헤더의 내용을 뽑아서 확인
		if(accept.matches(".*application/json.*")) {
			// json 응답해주기
			response.setStatus(HttpServletResponse.SC_OK);
			
			JSONResult jsonResult = JSONResult().fail(errors.toString());
			String result = new ObjectMapper().writeValueAsString(jsonResult);
			
			OutputStream os = response.getOutputStream();
			os.write(result.getBytes("UTF-8")); 
			os.flush();
			os.close();
			
		} else {
			// 2. 안내 페이지 가기 + 정상종료(response)
			request.setAttribute("uri", request.getRequestURI());
			request.setAttribute("exception", errors.toString());
			
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		}
	}

	private JSONResult JSONResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
