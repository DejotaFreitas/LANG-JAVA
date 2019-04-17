package ToStringMetodo;

public class ToStringMetodo {
	int d;
	int h;
	int m;
	int s;
	
	public void hora (int h, int m, int s){
		
		while (h>23||m>59||s>59) {
					
			if (s>59) {
				s=Math.abs(s-60);
				m+=1;
			}
			if (m>59) {
				m=Math.abs(m-60);
				h+=1;
			}
			if (h>23) {
				h=Math.abs(h-24);
				d+=1;
			}			
		}
		
		this.h = h;
		this.m = m;
		this.s = s;
		
		System.out.println(this);
	}
	
	public String toString(){
		return String.format("%02d Dias %02d:%02d:%02d Horas", d, h, m, s);
	}

}
