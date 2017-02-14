package parallelCache;


import java.util.HashMap;
import java.util.Set;



public class L2Data {
	
	
	//Memory m = new Memory();

	
	public static HashMap<String, HashMap<String, String>> l2douterMap = new HashMap<String, HashMap<String, String>>();
	public static HashMap<String, String> l2dinnerMap = new HashMap<String, String>();    
	//innerMap.put("innerKey", new Value());
	
	void customPut(String A,String d){
		
		if(l2dinnerMap.size()>=2){
			Set<String>temp= l2dinnerMap.keySet();
			String t="";
			for(String t1:temp){
				t=t1;
			}
			l2dinnerMap.remove(t);
			l2dinnerMap.put(A.substring(5, 7), d);
			l2douterMap.put(A.substring(0, 5),l2dinnerMap);
			
		}
	}
	
	

}
	
	
	
	
