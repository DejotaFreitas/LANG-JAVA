package model;

public class Telefone {
    private Integer id;
    private String numero;
    private String tipo;
    private int idPessoa;

    //gerar os metodos getters and setters

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", idPessoa=" + idPessoa +
                '}';
    }

    public enum TipoFone {
        CEL(0,"Celular"), 
		RES(1,"Residencial"), 
		COM(2,"Comercial");

        private int indice;
        private String descricao;

        TipoFone(int indice, String descricao) {
            this.indice = indice;
            this.descricao = descricao;
        }

        public int getIndice() {
            return indice;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}