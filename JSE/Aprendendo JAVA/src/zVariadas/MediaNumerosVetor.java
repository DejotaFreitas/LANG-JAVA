package zVariadas;

public class MediaNumerosVetor {
	public static void main(String[] args) {
		
		int media = new MediaNumerosVetor().mediaVetor(1,5,3,8,9,8,5,1,8,9,10,5,1);
		
		System.out.println(media);
	}
	
	int mediaVetor(int...vetor){
		int total = 0;
		for(int x:vetor)
		total += x;
		
		return	total/vetor.length;	
	}

}
