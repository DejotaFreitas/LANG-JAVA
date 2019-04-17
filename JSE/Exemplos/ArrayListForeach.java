

import java.util.ArrayList;

public class ArrayListForeach {
public static void main(String[] args) {
	
	ArrayList<Integer> n = new ArrayList<Integer>();
	int total = 0;
	for (int i = 1; i <= 10; i++) {
			n.add(i);
	}	
	for (Integer num : n) {
		total +=num;
	}
	
	System.out.println(total);
}
}
