package parallelCache;
import java.util.HashMap;
import java.util.Set;



public class L1Data {
	
	
	//Memory m = new Memory();

	
	public static HashMap<String, HashMap<String, String>> l1douterMap = new HashMap<String, HashMap<String, String>>();
	public static HashMap<String, String> l1dinnerMap = new HashMap<String, String>();    
	//innerMap.put("innerKey", new Value());
	
	void customPut(String A,String d){
		
		if(l1dinnerMap.size()>=2){
			Set<String>temp= l1dinnerMap.keySet();
			String t="";
			for(String t1:temp){
				t=t1;
			}
			l1dinnerMap.remove(t);
			l1dinnerMap.put(A.substring(5, 7), d);
			l1douterMap.put(A.substring(0, 5),l1dinnerMap);
			
		}
	}
	
	

}
	
	
	
	
