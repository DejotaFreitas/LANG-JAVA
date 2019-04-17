package Pessoas.Enumeracoes.EnumSetRamger;

import java.util.EnumSet;


public class PessoasMain {
	public static void main(String[] args) {
		
		
		for (Pessoas p : Pessoas.values())
			System.out.printf("%s\t%s\t%s\t%s\n", p, p.getClasse(), p.getTipo(), p.getNivel());

		System.out.println();
		System.out.println("Metodo Ranger:");
		for (Pessoas p : EnumSet.range(Pessoas.Litt, Pessoas.Karol))
			System.out.printf("%s\t%s\t%s\t%s\n", p, p.getClasse(), p.getTipo(), p.getNivel());
		
		
		
		
		
	}

}
