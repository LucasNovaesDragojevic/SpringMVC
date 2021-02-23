package br.com.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mudi.model.Pedido;

@Controller
public class HomeController 
{
	@GetMapping("/home")
	public String home(Model model)
	{
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Kindle Oasis");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61SVKnucPtL._AC_SL1001_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Novo-Kindle-Oasis-8Gb-temperatura-de-luz-ajust%C3%A1vel/dp/B07L57H5X4");
		pedido.setDescricao("E-Reader");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
}
