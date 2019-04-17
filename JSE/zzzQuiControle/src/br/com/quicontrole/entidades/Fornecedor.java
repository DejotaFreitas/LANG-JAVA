package br.com.quicontrole.entidades;

public class Fornecedor {

	private Integer id_fornecedor;
	private String nome;
	private String razao_social;
	private String cnpj;
	private String cpf;
	private String inscricao_estadual;
	private String inscricao_municipal;
	private String telefone;
	private String email;
	private String endereco;
	private String descricao;
	private Boolean desativado;

	public Integer getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public String getInscricao_municipal() {
		return inscricao_municipal;
	}

	public void setInscricao_municipal(String inscricao_municipal) {
		this.inscricao_municipal = inscricao_municipal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.getNome();
	}

	public Boolean getDesativado() {
		return desativado;
	}

	public void setDesativado(Boolean desativado) {
		this.desativado = desativado;
	}

}
