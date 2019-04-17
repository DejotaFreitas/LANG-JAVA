package zVariadas;

public class Hora {
	public static void main(String[] args) {
		hora();
	}
	public static void hora(){
		//quando foi comessado a ser contado a hora
		long totalMilisegundos = System.currentTimeMillis();
		
		long totalSegundos = totalMilisegundos/1000;
		long segundosAtuais = totalSegundos % 60;
		
		long totalMinutos = totalSegundos / 60;
		long minutosAtual = totalMinutos % 60;
		
		long totalHoras = totalMinutos / 60;
		long horaAtual = totalHoras % 24;
		//horario brasil é -3.
		long horaBrazil = (horaAtual - 3 < 0? horaAtual - 3 + 24 : horaAtual - 3 ); 	
		System.out.printf("%02d:%02d:%02d",horaBrazil,minutosAtual,segundosAtuais);
		
		System.out.println();
		
		long totalDias = totalHoras / 24;
		long totalAnos = totalDias / 365;
		long diasRestantes = totalDias % 365;
		System.out.println(totalAnos);
		System.out.println(diasRestantes);
	}

}
