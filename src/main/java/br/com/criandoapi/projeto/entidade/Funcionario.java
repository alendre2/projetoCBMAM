package br.com.criandoapi.projeto.entidade;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table (name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "telefone", length = 100, nullable = false)
    private String telefone;

    @Column(name = "salario",precision = 10, scale = 2, nullable = false)
    private Double salario;

    @Column (name = "dataAdmissao",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "cargo", length = 100, nullable = false)
    private String cargo;

    @Column(name = "departamento", length = 100, nullable = false)
    private String departamento;

    @Column(name = "endereco", length = 100, nullable = false)
    private String endereco;

    public Funcionario() {
    }
    public Funcionario( String nome, String email, String telefone, Double salario, Date dataAdmissao, String cargo, String departamento, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.departamento = departamento;
        this.endereco = endereco;
    }

    public Funcionario(Long id, String nome, String email, String telefone, Double salario, Date dataAdmissao, String cargo, String departamento, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.departamento = departamento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
