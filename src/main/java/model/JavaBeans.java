package model;

public class JavaBeans {

	private int idcon;
	private String nome;
	private String fone;
	private String email;

	public JavaBeans() {
		super();
	}

	public JavaBeans(int idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public int getIdcon() {
		return idcon;
	}

	public void setIdcon(int idcon) {
		this.idcon = idcon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
