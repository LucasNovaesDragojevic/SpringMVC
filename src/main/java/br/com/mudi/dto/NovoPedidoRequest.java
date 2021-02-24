package br.com.mudi.dto;

import javax.validation.constraints.NotEmpty;

import br.com.mudi.model.Pedido;
import br.com.mudi.model.StatusPedido;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NovoPedidoRequest 
{
	@NotEmpty
	private String nomeProduto;
	@NotEmpty
	private String urlProduto;
	@NotEmpty
	private String urlImagem;
	private String descricao;
	
	public Pedido toPedido() 
	{
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatusPedido(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
