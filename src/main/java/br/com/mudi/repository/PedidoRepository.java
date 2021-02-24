package br.com.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mudi.model.Pedido;
import br.com.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>
{
	List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
