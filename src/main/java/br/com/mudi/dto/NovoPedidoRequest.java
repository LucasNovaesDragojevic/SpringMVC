package br.com.mudi.dto;

import br.com.mudi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NovoPedidoRequest 
{
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	
	public Pedido toPedido() 
	{
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		return pedido;
	}
}
