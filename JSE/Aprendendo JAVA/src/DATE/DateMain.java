package DATE;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateMain {

	public static void main(String[] args) {
		
		
		Date hoje  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println( sdf.format(hoje));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println( sdf2.format(hoje));
		
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
		System.out.println( sdf3.format(hoje));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("E dd ",new Locale("pt","br"));
		System.out.println( sdf4.format(hoje));
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,new Locale("pt","br"));
		System.out.println( df.format(hoje));
		
		//covertermos uma String em um objeto Date
		Date d  = new Date();
		SimpleDateFormat dfs = new SimpleDateFormat("dd/MM/yyyy");
		try {
		    d = dfs.parse("25/03/2010");
		} catch (ParseException ex) { }
		System.out.println( dfs.format(d));
		
	}

}
