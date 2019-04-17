package Pessoas.Enumeracoes.EnumSetRamger;


// Substitui class por enum
//public class Pessoas {
public enum Pessoas {
	
	Dejota("Pala","Tank","26"),
	Litt("Mago", "DPS", "22"),
	Jasher("Pikachu", "Noob", "21"),
	Karol("Heal", "Supot", "19"),
	Nat("Beserk", "DPS", "19"),
	kapristando("Kapristando", "Kapristando", "???");
	
	private final String classe;
	private final String tipo;
	private final String nivel;
	
	Pessoas(String c,String t,String n){
		classe = c;
		tipo = t;
		nivel = n;
	}
	
	public String getClasse(){
		return classe;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String getNivel(){
		return nivel;
	}


}
