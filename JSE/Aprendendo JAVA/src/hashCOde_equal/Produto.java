package hashCOde_equal;

public class Produto {
    int idProduto;
    String nomeProduto;

    public Produto(int idProduto, String nomeProduto) {
        super();
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    //getters and setters aqui!
    

    @Override
    public int hashCode() {
        //deve ser o mesmo resultado para um mesmo objeto, não pode ser aleatório
        return this.idProduto;
    }

    public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if(!(obj instanceof Produto)) return false; 

        //se forem o mesmo objeto, retorna true
        if(obj == this) return true;

        // aqui o cast é seguro por causa do teste feito acima
        Produto produto = (Produto) obj; 

        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.idProduto == produto.getIdProduto() &&
                this.nomeProduto.equals(produto.getNomeProduto());
    }   
}