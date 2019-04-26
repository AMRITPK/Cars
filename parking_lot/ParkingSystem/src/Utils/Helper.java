package Utils;

public class Helper {
	public static String fixedLengthString(String string, int length) {
		
		  return String.format("%1$-" + length + "s", string);
	    
	}
}
