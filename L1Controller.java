package parallelCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L1Controller {
	public Map<String, Map<String, Block>> l1cOuterMap = new HashMap<String, Map<String, Block>>();
	public Map<String, Block> l1cinnerMap = new HashMap<String, Block>();
	static boolean froml1=true;
	L1Controller(){
		Block b = new Block();
		b.validBit = true;
		b.tag = "00000";
		l1cinnerMap.put("00000", b);
		l1cOuterMap.put("0000000", l1cinnerMap);
		L1Data.l1dinnerMap.put("00000","ADV");
		L1Data.l1douterMap.put("0000000",L1Data.l1dinnerMap);
	}
	public void L1Cexec(int i,String instruction){
		//CPU c1=c;
		System.out.println("L1c");
		System.out.println(CPU.Ctol1Q);
		if(CPU.Ctol1Q.containsKey(i)){
			System.out.println("l222");
			/*String[] vals = instruction.split(" ");
			String command = vals[0];
			String address=vals[1];
			String byteEnables= vals[2];*/
			String Temp[]=SplitInstruction.split(instruction);
			String address=Temp[1];
			String State="";
			System.out.println(address);
			/*if (l1cOuterMap.containsKey(address.substring(5, 12)) && l1cinnerMap.containsKey(address.substring(0, 5))) {*/
			if(!l1cOuterMap.containsKey(address.substring(5, 12))){
				State="MISS";
			}
				else if(l1cOuterMap.containsKey(address.substring(5, 12))){
					if(l1cinnerMap.containsKey(address.substring(0, 5))){
						State="HIT";
					}
					else if(!l1cinnerMap.containsKey(address.substring(0, 5))){
						int size=l1cinnerMap.size();
						if(size<2){
							State="MISSC";
						}
						else{
							State="MISSI";
							 
									
					}
				}
				
			switch(State)
			{
			case "HIT":			
			{
				System.out.println("in switch");
				System.out.println(CPU.Ctol1Q);
				
				//CPU.fromCPU=false;
				String t=L1Data.l1dinnerMap.get(address.substring(0, 5))+";"+instruction;
				CPU.L1toCq.put(i+1,t);
				CPU.Ctol1Q.remove(i);
				System.out.println(CPU.Ctol1Q);
				break;
			}
			
			case "MISSC" :{
				System.out.println("in Missc");
				CPU.L1toL2q.put(i+1, instruction);
				CPU.Ctol1Q.remove(i);
				break;
			}
			
			case "MISSI":{
				//CPU.L1VictimCache.put(i+1,);
			}
			case "MISS":{
				CPU.L1toL2q.put(i+1, instruction);
				CPU.Ctol1Q.remove(i);
				break;
			}
				
			}
	}}
		
}
	public void L1CRexec(int i){
		if(CPU.L2toL1q.containsKey(i)){
			
			String Temp[]=CPU.L2toL1q.get(i).split(";");
			String[] vals = Temp[1].split(" ");
			String command = vals[0];
			String address=vals[1];
			String byteEnables= vals[2];
			
			String k=Temp[0];
			Block b = new Block();
			b.validBit = true;
			b.tag = address.substring(5, 7);
			l1cinnerMap.containsKey(address.substring(0, 5));
			l1cinnerMap.put(address.substring(0, 5), b);
			l1cOuterMap.put(address.substring(5, 12), l1cinnerMap);
			L1Data.l1dinnerMap.put(address.substring(0, 5), k);
			L1Data.l1douterMap.put(address.substring(5, 12), L1Data.l1dinnerMap);
			System.out.println(L1Data.l1douterMap);
			System.out.println("Data inserted in l1d from L2toL1Q "+CPU.L2toL1q.get(i));
			
			CPU.L1toCq.put(i+1,CPU.L2toL1q.get(i));
			CPU.L2toL1q.remove(i);
			return;
	}}
}
