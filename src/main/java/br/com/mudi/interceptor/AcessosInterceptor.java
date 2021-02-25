package br.com.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.Getter;
import lombok.Setter;

public class AcessosInterceptor implements HandlerInterceptor
{
	public static List<Acesso> ACESSOS = new ArrayList<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		Acesso acesso = new Acesso();
		acesso.setPath(request.getRequestURI());
		acesso.setData(LocalDateTime.now());
		request.setAttribute("acesso", acesso);
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception 
	{
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao(Duration.between(acesso.getData(), LocalDateTime.now()));
		ACESSOS.add(acesso);
	}
	
	@Getter @Setter
	public static class Acesso 
	{
		private String path;
		private LocalDateTime data;
		private Duration duracao;
	}
}
