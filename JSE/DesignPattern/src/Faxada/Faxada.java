package Faxada;

public class Faxada {
	public static void main(String[] args) {
		meto s = new meto();
		s.metodo("kkkkkk", "sdasdsa");
		
	}
	

}
//metodo composto de metodos emcapsulados
class meto{
	
	void metodo (String dizer, String responder){
		System.out.println("vc falou:"+dizer(dizer)+"vc respondeu+"+ responder(responder));
	}
	
	private String dizer(String fala){
		return fala;
	}
	private String responder (String resp){
		return resp;
	}
}