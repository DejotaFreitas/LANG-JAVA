package Data.MetodoToString;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data (int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}
	
	public String toString(){
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}
	
}
