package zVariadas;

public class Variaveis02 {
	// textos //iniciamente null
	static String str;

	// caracteres // 2 Byte de Memoria // char c = ' ';
	static char c;

	// condicional true ou false.//inicialmente falsa
	static boolean bl;
	// decimais
	// -128 a 127 // 1 Byte de Memoria.
	static byte b;
	// +-32,768 // 2 Byte de Memoria.
	static short s;
	// +-2147483648 //4 Byte de Memoria.
	static int i;
	// +-922372036854775808 //8 Byte de Memoria.
	static long l;
	// flotuante
	// 4 Byte de Memoria.
	static float f;
	// 8 Byte de Memoria.
	static double d;

	public static void main(String[] args) {

		System.out.println("String = " + str);
		System.out.println("char = " + c);
		System.out.println("boolean = " + bl);
		System.out.println("byte = " + b);
		System.out.println("short = " + s);
		System.out.println("int = " + i);
		System.out.println("long = " + l);
		System.out.println("float = " + f);
		System.out.println("double = " + d);

	}

}
