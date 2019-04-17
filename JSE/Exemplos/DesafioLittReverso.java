

import javax.swing.JOptionPane;

public class DesafioLittReverso {
public static void main(String[] args) {
	
	
	
	
	int t = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamnho da matriz quadrada"));
	
	int pyr [][] = new int[t][t];
	

	int x = 0;
	int y = 1;
	int z = ((t+1)/2);
	
	while (pyr [(t-1)/2][(t-1)/2] == 0) {
		
		
		for (int i = 0; i < t; i++) {
		for (int j = 0; j < t; j++) {
			
			if (pyr [i][j] == 0) {			
			
			if(i == (0+x) || j == (0+x) || i == (t-y) || j == (t-y) ){
				
				pyr [i][j] = z;
				
			}
			
		}	
		

	}	

}


	x++;
	y++;
	z--;

	} 
	
	for (int i = 0; i < t; i++) {
	for (int j = 0; j < t; j++) {
	pyr [i][j] = pyr [i][j] -1;
	}
	}
	
	
	
	for (int i = 0; i < t; i++) {
	for (int j = 0; j < t; j++) {
	System.out.print(pyr [i][j] + " ");
	}
	System.out.println();
	}
	
	
	
}
}
