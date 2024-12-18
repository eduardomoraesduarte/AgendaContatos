package model;

public class Contatos {

	private Integer id;
	private String nome;
	private String email;
	private String fone;
	
	public Contatos() {
	}
	
	
	public Contatos(Integer id, String nome, String email, String fone) {
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}

	
	
}
