package com.produtoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

// Fazer essa anotação abaixo, explica pro SpringBoot algo como ' Olha, essa classe é um Model ' então cada instância nessa classe, será uma linha no banco de dados.
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Informe um nome.")
	private String nome;
	private int quantidade;
	private String status;
	private double preco;

	public Produto(){
		//Construtor vazio.
	}

	public Produto (String nome, int quantidade, double preco, String status){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.status = status;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public int getQuantidade(){
		return quantidade;
	}

	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}

	public double getPreco(){
		return preco;
	}

	public void setPreco(double preco){
		this.preco = preco;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}
}