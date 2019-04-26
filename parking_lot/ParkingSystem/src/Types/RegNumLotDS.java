package Types;

import java.util.HashMap;

public class RegNumLotDS {
	
	private static HashMap<String,Integer>  regNumberMap;

	public static HashMap<String, Integer> getRegNumLotDS(){
		if (regNumberMap!=null) {
			return regNumberMap;
		}else {
			regNumberMap=new HashMap();
		}
		return regNumberMap;
	}

}
