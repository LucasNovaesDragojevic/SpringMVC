package br.com.mudi.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mudi.interceptor.AcessosInterceptor;
import br.com.mudi.interceptor.AcessosInterceptor.Acesso;

@RestController
@RequestMapping("acessos")
public class AcessosRest 
{
	@GetMapping
	public ResponseEntity<List<Acesso>> list()
	{
		return new ResponseEntity<>(AcessosInterceptor.ACESSOS, HttpStatus.OK);
	}
}
