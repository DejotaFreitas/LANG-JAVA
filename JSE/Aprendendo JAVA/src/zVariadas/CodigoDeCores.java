package zVariadas;

public class CodigoDeCores {

	public static void main(String[] args) {
		
		String [] hexadecimal = new String [] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		final String cerquilha = "#";
		String codigoCores = "#RedRedGreenGrennBlueBlue";
		
		for (int red01 = 0; red01 < hexadecimal.length; red01++) {
			for (int red02 = 0; red02 < hexadecimal.length; red02++) {
				for (int green01 = 0; green01 < hexadecimal.length; green01++) {
					for (int green02 = 0; green02 < hexadecimal.length; green02++) {
						for (int blue01 = 0; blue01 < hexadecimal.length; blue01++) {
							for (int blue02 = 0; blue02 < hexadecimal.length; blue02++) {
								
								codigoCores = cerquilha +
										hexadecimal[red01] + hexadecimal[red02] +
										hexadecimal[green01] + hexadecimal[green02] +
										hexadecimal[blue01] + hexadecimal[blue02];
								
								System.out.println(codigoCores);
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		//fim dos for
		
		
		
		

	}

}
