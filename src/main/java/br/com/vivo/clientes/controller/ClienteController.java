package br.com.vivo.clientes.controller;

import br.com.vivo.clientes.model.Cliente;
import br.com.vivo.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> lista(String nome){
        if (nome == null)
            return clienteRepository.findAll();
        else
            return clienteRepository.findByNome(nome);
    }

    @GetMapping("/cpf")
    public List<Cliente> cliente(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
