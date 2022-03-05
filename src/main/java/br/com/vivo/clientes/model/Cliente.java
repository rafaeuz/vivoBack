package br.com.vivo.clientes.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id @Length(min=11, max=11, message = "CPF inválido") @NotNull(message = "CPF obrigatório") @NotEmpty(message =  "CPF obrigatório")
    private String cpf;
    @NotNull(message = "Nome obrigatório") @NotEmpty(message =  "Nome obrigatório")
    private String nome;
    private String telefone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}