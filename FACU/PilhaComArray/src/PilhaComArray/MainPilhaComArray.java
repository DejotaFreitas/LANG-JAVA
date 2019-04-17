package PilhaComArray;

public class MainPilhaComArray {
	public static void main(String[] args) {
		
		PilhaComArray p = new PilhaComArray(6);
		p.push("a");
		p.push("b");
		p.push("c");
		p.push("d");
		p.push("e");
		p.push("f");
		p.push("g");
		p.showAll();
		System.out.println("-------------");
		p.invetPile();
		p.showAll();
		
		
		
	}
}
