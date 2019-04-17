

public class UsaSequenciaDuplamenteEncadea {
	
	public static void main(String[] args) {
		SequenciaDuplamenteEncadeada seq = new SequenciaDuplamenteEncadeada();
		seq.insertFirst("A");
		seq.insertFirst("B");
		seq.insertFirst("C");
		seq.insertFirst("D");
		seq.insertFirst("E");
		seq.imprimir();
		System.out.println(seq.atRank(0).getElemento());
		System.out.println(seq.atRank(1).getElemento());
		System.out.println(seq.atRank(2).getElemento());
		System.out.println(seq.atRank(3).getElemento());
		System.out.println(seq.atRank(4).getElemento());

		System.out.println(seq.rankOf("A"));
		System.out.println(seq.rankOf("B"));
		System.out.println(seq.rankOf("C"));
		System.out.println(seq.rankOf("D"));
		System.out.println(seq.rankOf("E"));
		System.out.println(seq.rankOf("H"));
	}
	
}
