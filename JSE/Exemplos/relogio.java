

public class relogio {
	
	int hora;
	int minuto;
	int segundo;
	
	public void setHora(int h, int m, int s){
		
		hora = ((h>=0 && h<24 ? h : 0));
		minuto = ((m>=0 && m<60 ? m : 0));
		segundo = ((s>=0 && s<60 ? s : 0));
		
	}
	
	public String horario(){
		return String.format("%02d:%02d:%02d", hora, minuto, segundo);
	}
	
	public static void main(String[] args) {
		
		
		relogio relogio = new relogio();
		relogio.setHora(12, 3, 36);
		System.out.println(relogio.horario());
		

	}

}
