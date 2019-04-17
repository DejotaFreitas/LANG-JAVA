import java.util.Random;


public class RandomS {
	public static void main(String[] args) {
		
		int zero = 0;
		int um = 0;
		int dois = 0;
		int tres = 0;
		int quatro = 0;
		int cinco = 0;
		int seis = 0;
		int sete = 0;
		int oito = 0;
		int nove = 0;
		
		
		for (byte i = 0; i < 100; i++) {
			//int num = (int) (Math.random()*10); // meio doido por causa do arrendontamento.
			int num = new Random().nextInt(6)+1; // muito melhor e equilibrado
			//System.out.println("Nº "+i+" = "+num);
			switch (num) {
			case 0:		zero++;	break;
			case 1:		um++;	break;
			case 2:		dois++;	break;
			case 3:		tres++;	break;
			case 4:		quatro++;	break;
			case 5:		cinco++;	break;
			case 6:		seis++;	break;
			case 7:		sete++;	break;
			case 8:		oito++;	break;
			case 9:		nove++;	break;

			default:
				break;
			}
		
		}
		
		System.out.println("Zeros = "+zero);
		System.out.println("Um = "+ um);
		System.out.println("Dois = "+dois);
		System.out.println("Três = "+tres);
		System.out.println("Quatro = "+quatro);
		System.out.println("Cinco = "+cinco);
		System.out.println("Seis = "+seis);
		System.out.println("Sete = "+sete);
		System.out.println("Oito = "+oito);
		System.out.println("Nove = "+nove);
		
	}

}
