import java.util.HashMap;
import java.util.Set;

public class L1Data {
	
	public String [][] l1Array= new String [128][2];
	Memory m = new Memory();
	
   /*String index;
   public Block[] blocks = new Block[256] ; //declaring array 
  
	L1Data(){
		for(int i=0;i<256;i++){
		   blocks[i] = new Block();  //initializing the array with block object
		}
	}*/
	
	public HashMap<String, HashMap<String, String>> l1douterMap = new HashMap<String, HashMap<String, String>>();
	public HashMap<String, String> l1dinnerMap = new HashMap<String, String>();    
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
	
	public HashMap<String,String> l1ddata= new HashMap<String,String>();
	
public void AddCacheData(int size,String Address){
	if(size%2==1 ){
		size/=2;
		l1Array [size][0]=l1ddata.get(m.getdata(Address)); 
	}
	else{
		size/=2;
		l1Array [size][1]=l1ddata.get(m.getdata(Address));
	}
	

}
	
	
	
	
}