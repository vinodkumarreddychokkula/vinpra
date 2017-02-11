package CacheController;

import java.util.HashMap;

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
