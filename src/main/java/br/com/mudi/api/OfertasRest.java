package br.com.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mudi.dto.NovaOfertaRequest;
import br.com.mudi.model.Oferta;
import br.com.mudi.model.Pedido;
import br.com.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("api/ofertas")
public class OfertasRest
{
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody NovaOfertaRequest novaOfertaRequest)
	{
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(novaOfertaRequest.getPedidoId().intValue());
		if (!pedidoOptional.isPresent())
		{
			return null;
		}
		Pedido pedido = pedidoOptional.get();
		Oferta oferta = novaOfertaRequest.toOferta();
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);
		return oferta;
	}
}
