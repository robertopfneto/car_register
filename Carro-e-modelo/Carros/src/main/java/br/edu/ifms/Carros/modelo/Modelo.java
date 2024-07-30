package br.edu.ifms.Carros.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message="Informe um nome para o modelo do carro")
	@Size(min = 3, max = 7,  message ="Informe um nome de pelo menos 3 caracteres")
	private String nome;
	
	@OneToMany(mappedBy = "modelo")
	private List<Carros> listaCarros;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carros> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(List<Carros> listaCarros) {
		this.listaCarros = listaCarros;
	}
  

	public Modelo(
		@NotEmpty(message = "Informe um nome para o modelo do carro") @Size(min = 3, message = "Informe um nome de pelo menos 3 caracteres") String nome) {
		super();
		this.nome = nome;
	}

	public Modelo(){}

	
	
}
