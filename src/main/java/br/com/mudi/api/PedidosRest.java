package br.com.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mudi.model.Pedido;
import br.com.mudi.model.StatusPedido;
import br.com.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidosRest
{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidoAguardandoOfertas()
	{
		Sort sort = Sort.by("id").descending();
		PageRequest pageRequest = PageRequest.of(0, 3, sort);
		List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, pageRequest);
		pedidos.forEach(System.out::println);
		return pedidos;
	}
}
