package br.com.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.com.mudi.model.Oferta;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NovaOfertaRequest 
{
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Long pedidoId;
	@NotEmpty(message = "O valor não pode ser nulo.")
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "O valor somente deve ter números separadas por um ponto")
	private String valor;
	@NotEmpty(message = "A data não pode ser nula")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "A data deve serguir o padrão dd/mm/aaaa")
	private String dataEntrega;
	private String comentario;
	
	public Oferta toOferta() 
	{
		Oferta oferta = new Oferta();
		oferta.setComentario(comentario);
		oferta.setDataEntrega(LocalDate.parse(dataEntrega, formatter));
		oferta.setValor(new BigDecimal(valor));
		return oferta;
	}
}
