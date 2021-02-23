package br.com.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mudi.dto.NovoPedidoRequest;
import br.com.mudi.model.Pedido;
import br.com.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController
{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario() 
	{
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(NovoPedidoRequest novoPedidoResquet)
	{
		Pedido pedido = novoPedidoResquet.toPedido();
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
