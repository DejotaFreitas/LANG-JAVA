package zDejotaSistemaGame;


import java.util.Random;

public class SistemaGame02 {
	
public static void main(String[] args) {
	
	
	Random gerador = new Random();
	
	int ValorLV = 1;
	int nhp = 1;
	int nmana = 1;
	int nstr = 5;
	int ndex = 5;
	int nint = 5;
	int nagi = 5;
	int nvit = 5;
	int ncon = 5;
	int nluk = 5;
	

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
	//==============INT==================\\
	int vetorint[] = new int[nint];	
	for(int i=0;i<nint;i++)
	vetorint[i] =(gerador.nextInt(6) +1);	
	int somaint = 0;
	for (int i=0; i<nint; i++)
	somaint += vetorint[i];	
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
	//================CON================\\
	int vetorcon[] = new int[ncon];	
	for(int i=0;i<ncon;i++)
	vetorcon[i] =(gerador.nextInt(6) +1);	
	int somacon = 0;
	for (int i=0; i<ncon; i++)
	somacon += vetorcon[i];
	//================LUK================\\
	int vetorluk[] = new int[nluk];	
	for(int i=0;i<nluk;i++)
	vetorluk[i] =(gerador.nextInt(6) +1);	
	int somaluk = 0;
	for (int i=0; i<nluk; i++)
	somaluk += vetorluk[i];
	//================HP================\\
	int vetorhp[] = new int[nhp];	
	for(int i=0;i<nhp;i++)
	vetorhp[i] =(gerador.nextInt(6) +1);	
	int somahp = 0;
	for (int i=0; i<nhp; i++)
	somahp += vetorhp[i];
	//================MANA================\\
	int vetormana[] = new int[nmana];	
	for(int i=0;i<nmana;i++)
	vetormana[i] =(gerador.nextInt(6) +1);	
	int somamana = 0;
	for (int i=0; i<nmana; i++)
	somamana += vetormana[i];
	//================================================================================================\\
	
	 int ValorSTR = (somastr);
	 int ValorDEX = (somadex);
	 int ValorINT = (somaint);
	 int ValorAGI = (somaagi);
	 int ValorVIT = (somavit);
	 int ValorCON = (somacon);
	 int ValorLUK = (somaluk);
	 

	 int ModSTR = (ValorSTR/4) - 3;
	 int ModDEX = (ValorDEX/4) - 3;
	 int ModINT = (ValorINT/4) - 3;
	 int ModAGI = (ValorAGI/4) - 3;
	 int ModVIT = (ValorVIT/4) - 3;
	 int ModCON = (ValorCON/4) - 3;
	 int ModLUK = (ValorLUK/4) - 3;
	 
	 
	 System.out.println(
			 " STR =" + ValorSTR + " MOD=" + ModSTR +
			 "\n DEX =" + ValorDEX + " MOD=" + ModDEX +
			 "\n INT =" + ValorINT + " MOD=" + ModINT +
			 "\n AGI =" + ValorAGI + " MOD=" + ModAGI +
			 "\n VIT =" + ValorVIT + " MOD=" + ModVIT +
			 "\n CON =" + ValorCON + " MOD=" + ModCON +
			 "\n LUK =" + ValorLUK + " MOD=" + ModLUK +
 			 
			 "\n\n HP =" + (somahp+(nhp*ModVIT)) +
			 "\n MANA =" + (somamana+(nmana*ModCON)) +
			 "\n DEFCAC =" + (8+ModAGI+(ModVIT/2)+(ModLUK/3)+(ValorLV/4)) +
			 "\n DEFADS =" + (8+ModAGI+(ModCON/2)+(ModLUK/3)+(ValorLV/4)) +
			 "\n ATKACAC =" + (ModDEX+(ModSTR/2)+(ModLUK/3)+(ValorLV/4)) +
			 "\n ATKADS =" + (ModDEX+(ModINT/2)+(ModLUK/3)+(ValorLV/4)) +
			 "\n CONJURAÇÃO =" + (ModDEX+ModINT+ModCON+(ModLUK/3)) +
			 "\n EXECUÇÃO =" + (ModDEX+ModSTR+ModCON+(ModLUK/3)) +
			 "\n INI CAC=" + ((ModINT+ModAGI)/2) +
			 "\n INI ADS=" + ((4+ModINT+ModAGI)/2) +
			 "\n VEL. ATK =" + ((10+ModAGI+ModVIT/2+(ValorLV/4))/10) +
			 "\n DESL. COMBATE =" + (1+(ModAGI+ModVIT)/2)
			  );

	}

	
}
