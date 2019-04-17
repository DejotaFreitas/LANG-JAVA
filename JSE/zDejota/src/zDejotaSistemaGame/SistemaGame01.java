package zDejotaSistemaGame;



import java.util.Random;

public class SistemaGame01 {
	
	

public static void main(String[] args) {
	
	Random gerador = new Random();
	
	int ValorLV = 1;

	
	int nhp = 1+10;
	int nmana = 1;

	int equi   = 0; //4
	int bruto  = 0; //2
	int Ranger = 0; //2
 int brutomago = 0; //3
	int mago   = 0; //3
	int tank   = 0; //2
	
 int DefEquips = 0;
 int DefMagica = 0;
 int DefEscudo = 0;
 
	
	int AS = 5;	
	int nstr = AS+bruto+equi+brutomago;
	int ndex = AS+Ranger+mago+equi;
	int nint = AS+mago+brutomago;
	int nagi = AS+Ranger+tank+equi;
	int nvit = AS+bruto+tank+equi+brutomago;
	int ncon = AS+mago;
	int nluk = AS;
	
	
	//================STR================\\
	long vetorstr[] = new long[nstr];	
	for(int i=0;i<nstr;i++)
	vetorstr[i] =(gerador.nextInt(6) +1);	
	int somastr = 0;
	for (int i=0; i<nstr; i++)
	somastr += vetorstr[i];
	//================DEX================\\
	long vetordex[] = new long[ndex];	
	for(int i=0;i<ndex;i++)
	vetordex[i] =(gerador.nextInt(6) +1);	
	int somadex = 0;
	for (int i=0; i<ndex; i++)
	somadex += vetordex[i];
	//==============INT==================\\
	long vetorint[] = new long[nint];	
	for(int i=0;i<nint;i++)
	vetorint[i] =(gerador.nextInt(6) +1);	
	int somaint = 0;
	for (int i=0; i<nint; i++)
	somaint += vetorint[i];	
	//================AGI================\\
	long vetoragi[] = new long[nagi];	
	for(int i=0;i<nagi;i++)
	vetoragi[i] =(gerador.nextInt(6) +1);	
	int somaagi = 0;
	for (int i=0; i<nagi; i++)
	somaagi += vetoragi[i];
	//================VIT================\\
	long vetorvit[] = new long[nvit];	
	for(int i=0;i<nvit;i++)
	vetorvit[i] =(gerador.nextInt(6) +1);	
	int somavit = 0;
	for (int i=0; i<nvit; i++)
	somavit += vetorvit[i];
	//================CON================\\
	long vetorcon[] = new long[ncon];	
	for(int i=0;i<ncon;i++)
	vetorcon[i] =(gerador.nextInt(6) +1);	
	int somacon = 0;
	for (int i=0; i<ncon; i++)
	somacon += vetorcon[i];
	//================LUK================\\
	long vetorluk[] = new long[nluk];	
	for(int i=0;i<nluk;i++)
	vetorluk[i] =(gerador.nextInt(6) +1);	
	int somaluk = 0;
	for (int i=0; i<nluk; i++)
	somaluk += vetorluk[i];
	//================HP================\\
	long vetorhp[] = new long[nhp];	
	for(int i=0;i<nhp;i++)
	vetorhp[i] =(gerador.nextInt(6) +1);	
	int somahp = 0;
	for (int i=0; i<nhp; i++)
	somahp += vetorhp[i];
	//================MANA================\\
	long vetormana[] = new long[nmana];	
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
	 
	 
//		int ArmaCurtaCAC = ModSTR/3;
//		int ArmaCurtaADS = ModDEX/3;

	 
	 
	 
	 System.out.println(
	
	  "HP=" + (somahp+(nhp*ModVIT)) +
	"\nMANA=" + (somamana+(nmana*ModCON)) +
	"\nATKACAC=" + (ModDEX+(ModSTR/2)+(ModLUK/3)+(ValorLV/4)) +
	"\nATKADS=" + (ModDEX+(ModINT/2)+(ModLUK/3)+(ValorLV/4)) +
	"\nDEFCAC=" + (8+ModAGI+(ModLUK/3)+(ValorLV/4)+DefEquips+DefMagica+DefEscudo) +
	"\nDEFADS=" + (8+ModAGI+(ModLUK/3)+(ValorLV/4)+DefEquips+DefMagica+DefEscudo+DefEscudo/2) +
	"\nR.D.F.=" + (ModVIT+DefMagica/2+DefEquips/3) +
	"\nR.D.M.=" + (ModCON+DefMagica/2+DefEquips/3) +
	"\nCONJ=" + (ModCON+ModDEX/2+ModINT/2+(ModLUK/3)) +
	"\nEXEC=" + (ModCON+ModDEX/2+ModSTR/2+(ModLUK/3)) +
	"\nINI.CAC=" + ((ModINT+ModAGI)/2) +
	"\nINI.ADS=" + ((ModINT+ModAGI)/2+3) +
	"\nVEL.ATK=" + ((10+ModAGI+ModVIT/2+(ValorLV/4))/10) +
	"\nDESL=" + (1+(ModAGI+ModVIT)/2) +
	
	"\n\nSTR=" + ValorSTR + "/" + ModSTR +
	"\nDEX=" + ValorDEX + "/" + ModDEX +
	"\nINT=" + ValorINT + "/" + ModINT +
	"\nAGI=" + ValorAGI + "/" + ModAGI +
	"\nVIT=" + ValorVIT + "/" + ModVIT +
	"\nCON=" + ValorCON + "/" + ModCON +
	"\nLUK=" + ValorLUK + "/" + ModLUK
	 );

}
}
