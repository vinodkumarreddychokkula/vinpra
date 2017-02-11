import java.util.HashMap;

public class Memory {
	
	public HashMap <String, String> memoryMapping =new HashMap<String, String>();
	
	public   Memory(){
		
		memoryMapping.put("00000000000000000","Advance Computer");
		memoryMapping.put("10000000000000000","Virat Kohli");
		
	}
	public String getdata(String A){
		if(memoryMapping.containsKey(A)){
		return memoryMapping.get(A);
		}
		else
			return null;
	}

}