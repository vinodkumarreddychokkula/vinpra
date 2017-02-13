import java.util.HashMap;

public class L2Data {
public HashMap<String,String> l2ddata= new HashMap<String,String>();
	
public L2Data(){
		
		
		//l2ddata.put("00000000000000000", "Advance Computer" );
	
}

	
	
	
	public String getdata(String A){
		//HashMap<String, String> memoryMapping;
		if(l2ddata.containsKey(A)){
		return l2ddata.get(A);
		}
		else
			return null;
	}
}



	
