import java.util.HashMap;

public class Memory {
	
	public HashMap <String, String> memoryMapping =new HashMap<String, String>();
	
	public   Memory(){
		System.out.println("In Main Memory con");
		memoryMapping.put("00000100000000000","Advance Computer");
		memoryMapping.put("00000010000000000","Advance operating");
		memoryMapping.put("00000000000000000","sachin tendulkar");
		memoryMapping.put("01000000000000000","sehwag");
		memoryMapping.put("01100000000000000","dravid");
		memoryMapping.put("10000000000000000","ganguly");
		memoryMapping.put("10100000000000000","pointing");
		memoryMapping.put("11000100000000000","flintoff");
		memoryMapping.put("11000100000000001","Virat Kohli");
		//memoryMapping.put("10000000000000000","Virat Kohli");
		
	}
	public String getdata(String A){
		if(memoryMapping.containsKey(A)){
			System.out.println("Checking in main");
		return memoryMapping.get(A);
		}
		else
			return null;
	}

}