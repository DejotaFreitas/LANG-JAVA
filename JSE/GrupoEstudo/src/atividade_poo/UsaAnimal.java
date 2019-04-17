package atividade_poo;

public class UsaAnimal {

	public static void main(String[] args) {
		
		Cachorro c = new Cachorro();
		c.setNome("Sheldom");
		c.setIdade(5);
		
		Cavalo cv = new Cavalo();
		cv.setNome("Fuscão Preto");
		cv.setIdade(14);
		
		Preguica p = new Preguica();
		p.setNome("Sonic");
		p.setIdade(7);
		
		System.out.println("======= Cachorro =======");
		c.emitirSom();
		c.correr();
		System.out.println("========================");
		System.out.println();
		
		System.out.println("======== Cavalo ========");
		cv.emitirSom();
		cv.correr();
		System.out.println("========================");
		System.out.println();
		
		System.out.println("======= Preguiça =======");
		p.emitirSom();
		p.subirArvore();
		System.out.println("========================");
		System.out.println();
		
		Veterinario v = new Veterinario();
		v.examinar(c);
		v.examinar(cv);
		v.examinar(p);
		
		Zoologico z = new Zoologico();
		z.enjaular(c);
		z.enjaular(cv);
		z.enjaular(p);
		System.out.println();
		System.out.println("==== Percorrendo as Jaulas ====");
		z.percorrerJaula();
		System.out.println("===============================");
	}

}
