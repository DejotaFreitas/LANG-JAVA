package BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalMain {

	public static void main(String[] args) {

		System.out.println("");
		System.out.println("Soma");
		System.out.println(new BigDecimal("2.00").add(new BigDecimal("1.2")));

		System.out.println("");
		System.out.println("Subtrai");
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));

		System.out.println("");
		System.out.println("Multiplica");
		BigDecimal b = new BigDecimal("2.00").multiply(new BigDecimal("1.8"));
		System.out.println(b);

		System.out.println("");
		System.out.println("Divide");
		System.out.println(new BigDecimal("2.00").divide(new BigDecimal("2.00")));

		System.out.println("");
		System.out.println("Pot�ncia");
		System.out.println(new BigDecimal("2.00").pow(2));

		System.out.println("");
		System.out.println("Compara -1 <=, 0 ==, 1 >=");
		System.out.println(new BigDecimal("2.00").compareTo(new BigDecimal("2.0")));

		System.out.println("");
		System.out.println("M�ximo");
		System.out.println(new BigDecimal("2.00").max(new BigDecimal("1.5")));

		System.out.println("");
		System.out.println("M�nimo");
		System.out.println(new BigDecimal("2.00").min(new BigDecimal("1.6")));

		System.out.println("");
		System.out.println("Divide");
		System.out.println(new BigDecimal("1.00").divide(new BigDecimal("1.3"), 2, RoundingMode.UP));

		System.out.println("");		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		System.out.println(df.format(new BigDecimal("0.")));
		System.out.println(df.format(new BigDecimal("123456.00")));
		System.out.println(df.format(new BigDecimal("12345612345.678")));
		

	}
}
