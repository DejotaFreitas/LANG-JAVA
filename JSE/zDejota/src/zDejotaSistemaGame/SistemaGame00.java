package zDejotaSistemaGame;


import java.util.Random;

public class SistemaGame00 {
	public static void main(String[] args) {
		
		
		Random gerador = new Random();
		
		int nivel = 1; //NIVEL
		int nlife = 1;	 //LIFE
		
		int nstr = 1;	 //FORÇA
		int ndex = 1;	 //DESTREZA
		int ncon = 1;	 //CONCENTRÇÃO
		int nagi = 1;	 //AGILIDADE
		int nvit = 1;	 //VITALIDADE
		int nluk = 1;	 //SORTE
		

		//================STR================\\
		int vetorstr[] = new int[nstr];	
		for(int i=0;i<nstr;i++)
		vetorstr[i] =(gerador.nextInt(6) +1);	
		int somastr = 0;
		for (int i=0; i<nstr; i++)
		somastr += vetorstr[i];
		//================DEX================\\
		int vetordex[] = new int[ndex];	
		for(int i=0;i<ndex;i++)
		vetordex[i] =(gerador.nextInt(6) +1);	
		int somadex = 0;
		for (int i=0; i<ndex; i++)
		somadex += vetordex[i];
		//================CON================\\
		int vetorcon[] = new int[ncon];	
		for(int i=0;i<ncon;i++)
		vetorcon[i] =(gerador.nextInt(6) +1);	
		int somacon = 0;
		for (int i=0; i<ncon; i++)
		somacon += vetorcon[i];
		//================AGI================\\
		int vetoragi[] = new int[nagi];	
		for(int i=0;i<nagi;i++)
		vetoragi[i] =(gerador.nextInt(6) +1);	
		int somaagi = 0;
		for (int i=0; i<nagi; i++)
		somaagi += vetoragi[i];
		//================VIT================\\
		int vetorvit[] = new int[nvit];	
		for(int i=0;i<nvit;i++)
		vetorvit[i] =(gerador.nextInt(6) +1);	
		int somavit = 0;
		for (int i=0; i<nvit; i++)
		somavit += vetorvit[i];
		//================LUK================\\
		int vetorluk[] = new int[nluk];	
		for(int i=0;i<nluk;i++)
		vetorluk[i] =(gerador.nextInt(6) +1);	
		int somaluk = 0;
		for (int i=0; i<nluk; i++)
		somaluk += vetorluk[i];
		//================HP================\\
		int vetorlife[] = new int[nlife];	
		for(int i=0;i<nlife;i++)
		vetorlife[i] =(gerador.nextInt(6) +1);	
		int somalife = 0;
		for (int i=0; i<nlife; i++)
		somalife += vetorlife[i];
		//================================================================================================\\

		int forca = somastr;
		int destreza = somadex;
		int concentracao = somacon;
		int agilidade = somaagi;
		int vitalidade = somavit;
		int sorte = somaluk;
		 
		int life = (somalife+(nlife*vitalidade));
		int defcac = (agilidade+vitalidade+sorte/2+nivel/2);
		int defads = (agilidade+sorte/2+nivel/2);	
		int atkcac = (destreza+forca+sorte/2+nivel/2);					
		int atkads = (destreza+concentracao+sorte/2+nivel/2);
		int critico = (sorte);
		int velatk =((agilidade+vitalidade)/(10+(nivel/10)));
		 
			
			 
	
}
}
//MOBA GAME
//PERSONAGEM PERSONALIZADO SO SEU.
//MOBA = PERSONAGEM NAO PERDE LEVEL, ATRIBUTOS OU ABILIDADES.
//JOGAR CONTRA PERSONAGENS DO MESMO LEVEL. X1 ~ X5
//MOBA COM MISSOES
//AS TORRES E CREEPS TEM NIVEL EQUIVALENTE AO SEU.
//COMPRA ARMA E QUIPS COM PONTOS (HONRA,GLORIA,BRAVURA) GANHOS NO GAME
//PONTOS DE REPUTAÇÃO = PERSONALIZAR SPRITE DO PERSONAGEM
//DIA E NOITE
//PERIODO DE REAGRUPAMENTO = NAO ENVIA CREEPS
//DUNGEONS E RAIDS ALEATORIOS
//
/////////REGRAS////////////////////////
//MAGIA E HABILIDADES GASTAM LIFE
//DEXTREZA DIMINUI A VARIAÇÃO DE DANO E ACERTO.???
////////STATUS//////////////////////////////////////////
//DEFCAC = VARIA DE 1 AO MAX. ARMOR NAO VARIA.
//DEFADS = VARIA DE 1 AO MAX. ARMOR NAO VARIA.
//ATKCAC = VARIA DE 1 AO MAX. BONUS DA ARMA NAO VARIA.
//ATKADS = VARIA DE 1 AO MAX. BONUS DA ARMA NAO VARIA.
//CRITICO = VARIA DE 1 AO MAX, SE SORTE MAIOR Q DEFESA = CRITICO = DANO MAXIMO!.
//VELATK = MINIMO 1


