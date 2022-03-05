package br.com.vivo.clientes.repository;

import br.com.vivo.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCpf(String cpf);
}