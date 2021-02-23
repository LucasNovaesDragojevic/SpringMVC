package br.com.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>
{

}
