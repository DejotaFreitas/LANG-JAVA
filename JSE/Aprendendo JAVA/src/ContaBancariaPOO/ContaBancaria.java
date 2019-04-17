package ContaBancariaPOO;

public abstract class ContaBancaria {
	
	ContaBancaria (String client, String usuario, String senha, double saldo, boolean tipoConta){
		this.client = client;
		this.usuario = usuario;
		this.senha = senha;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
	}
	
	private String usuario;
	private String senha;
	private String client;
	private double saldo;
	private boolean tipoConta;
	
	abstract void extrato(ContaBancaria client);
	abstract void sacar(ContaBancaria client, double sacar);
	abstract void deposito(ContaBancaria client, double deposito);
	abstract void tranferencia(ContaBancaria client, ContaBancaria destino, double valor);
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(boolean tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
	
}
