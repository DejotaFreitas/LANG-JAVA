package zDejotaSistemaGame;
import java.util.Random;


public class Pokemon {
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 5; i >= 1 ; i--) {
		System.out.println("A Batalha dará início em "+i+" segundos");
		Thread.sleep(1000);
		}
		
		while (hpCharizard > 0 && hpPikachu > 0) {			
		switch (new Random().nextInt(2)) {	
		
		case 0:			
			rodadaCharizard();			
				if (hpCharizard <= 0 || hpPikachu <= 0) {	break;  }			
			rodadaPikachu();			
		break;
		
		case 1:			
			rodadaPikachu();			
				if (hpCharizard <= 0 || hpPikachu <= 0) {	break;  }			
			rodadaCharizard();			
		break;
		}			
	}
		
		
		if (hpCharizard>0) {
			System.out.println("Charizard é O Grande Vencedor!!!");
		}else{
			System.out.println("Pikachu é O Grande Vencedor!!!.");
		}
		
	}
	
	//==========Metodos==========\\
	
	static int hpCharizard = 100;
	static int hpPikachu = 100;

	static int dano;

	static int dano() {
		int dano2 = (new Random().nextInt(11) + 10);
		return dano = dano2;
	}

	static int tipodano() {
		int dano3 = 0;
		switch (new Random().nextInt(9)) {

		case 0:
			dano3 = dano / 2;	System.out.println("Ataque Fraco");	break;
		case 1:
			dano3 = dano;	System.out.println("Ataque Normal");	break;
		case 2:
			dano3 = dano * 2;	System.out.println("Ataque Forte");	break;
		case 3:
			dano3 = dano;	System.out.println("Ataque Normal");	break;
		case 4:
			dano3 = dano * 3;	System.out.println("Ataque Crítico");	break;
		case 5:
			dano3 = dano;	System.out.println("Ataque Normal");	break;
		case 6:
			dano3 = dano * 0;	System.out.println("Errou o Ataque!");	break;
		case 7:
			dano3 = dano;	System.out.println("Ataque Normal");	break;
		case 8:
			dano3 = dano / 3;	System.out.println("Ataque Muito Fraco");	break;

		}
		return dano = dano3;
	}

	static int danohpCharizard() {
		return hpCharizard = hpCharizard - dano;
	}

	static int danohpPikachu() {
		return hpPikachu = hpPikachu - dano;
	}

	
	static void Pikachu() {
		switch (new Random().nextInt(4)) {
		case 0:
			System.out.println("Pikachu usou Ataque Rápido");
			break;
		case 1:
			System.out.println("Pikachu usou Relâmpago");
			break;
		case 2:
			System.out.println("Pikachu usou Cauda de Ferro");
			break;
		case 3:
			System.out.println("Pikachu usou Ataque do Trovão");
			break;
		}
	}

	static void Charizard() {
		switch (new Random().nextInt(4)) {
		case 0:
			System.out.println("Charizard usou Lança Chamas");
			break;
		case 1:
			System.out.println("Charizard usou Asa de Aço");
			break;
		case 2:
			System.out.println("Charizard usou Investida");
			break;
		case 3:
			System.out.println("Charizard usou Abalo Sísmico");
			break;
		}
	}

	static void rodadaPikachu() throws InterruptedException{
		Pikachu();
		dano();
		Thread.sleep(2000);
		tipodano();
		danohpCharizard();
		Thread.sleep(2000);
		System.out.println("Pikachu causou "+dano+" de dano");
		Thread.sleep(2000);
		System.out.println("Charizard HP: "+hpCharizard+" X "+hpPikachu+" :HP Pikachu");
		Thread.sleep(2000);
	}
	
	static void rodadaCharizard() throws InterruptedException{
		Charizard();
		dano();
		Thread.sleep(2000);
		tipodano();
		danohpPikachu();
		Thread.sleep(2000);
		System.out.println("Charizard causou "+dano+" de dano");
		Thread.sleep(2000);
		System.out.println("Charizard HP: "+hpCharizard+" X "+hpPikachu+" :HP Pikachu");
		Thread.sleep(2000);
	}
	
}
