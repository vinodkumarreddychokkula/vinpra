package parallelCache;

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
	public void getdata(int i,String instruction){
		if(CPU.L2toMemq.containsKey(i)){
		String[] vals = instruction.split(" ");
		String command = vals[0];
		String address=vals[1];
		String byteEnables= vals[2];
		System.out.println("searching in main memory");
		
		if(memoryMapping.containsKey(address)){
			//System.out.println("Checking in main");
			String t=memoryMapping.get(address)+";"+instruction;
			CPU.MemtoL2q.put(i+1, t);
			CPU.L2toMemq.remove(i);
		}
		
	}}

}