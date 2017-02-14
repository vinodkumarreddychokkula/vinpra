package parallelCache;

import java.util.HashMap;
import java.util.Map;

public class L2Controller {
	Map<String, Map<String, Block>> l2cOuterMap = new HashMap<String, Map<String, Block>>();
	Map<String, Block> l2cinnerMap = new HashMap<String, Block>();
	L2Controller(){
		Block b = new Block();
		b.validBit = true;
		b.tag = "11111";
		l2cinnerMap.put("11111", b);
		l2cOuterMap.put("000000011", l2cinnerMap);
		L2Data.l2dinnerMap.put("11111","Kohli");
		L2Data.l2douterMap.put("000000011",L2Data.l2dinnerMap);
	}
	
	public void L2Cexec(int i,String instruction){
		System.out.println("L2C");
		if(CPU.L1toL2q.containsKey(i)){
			System.out.println("in L2Controller method"+CPU.L1toL2q);
			String[] vals = instruction.split(" ");
			String command = vals[0];
			String address=vals[1];
			String byteEnables= vals[2];
			String State="";
			System.out.println(address);
			
			if (l2cOuterMap.containsKey(address.substring(5, 14))){
				if(l2cinnerMap.containsKey(address.substring(0, 5))){
				Block a = l2cinnerMap.get(address.substring(0, 5));
				if (a.validBit) {
					//System.out.println("HIT IN L1");
					State= "HIT";
					System.out.println(State);
				}
					}
				}
			else if(!CPU.L1toL2q.containsKey(address.substring(5, 14))){
				System.out.println("miss case");
				State="MISSC";
			}
			
			switch(State)
			{	
		case "HIT":			
		{
			System.out.println("in switch L2");
			//System.out.println(CPU.Ctol1Q);
			//CPU.L2toL1q.put(i+1,L2Data.l2douterMap.get(address.substring(5, 14),L2Data.l2dinnerMap.get(address.substring(0, 5)).toString()));
			CPU.L2toL1q.put(i+1,L2Data.l2dinnerMap.get(address.substring(0, 5)));
			//CPU.fromCPU=false;
			CPU.L1toL2q.remove(i);
			//System.out.println(CPU.Ctol1Q);
			break;
		}
		
		case "MISSC" :{
			System.out.println("in Missc");
			CPU.L2toMemq.put(i+1, instruction);
			CPU.L1toL2q.remove(i);
			break;
		}
			}
		

}
}
	public void L2CRexec(int i){
		if(CPU.MemtoL2q.containsKey(i)){
		String[] temp=CPU.MemtoL2q.get(i).split(";");
		String[] vals = temp[1].split(" ");
		String command = vals[0];
		String address=vals[1];
		String byteEnables= vals[2];
		System.out.println("Inserting in l2d");
		
		/*String[] temp=CPU.MemtoL2q.get(i).split(";");*/
		String k=temp[0];
		Block b = new Block();
		b.validBit = true;
		b.tag = address.substring(0, 5);
		//l2cinnerMap.containsKey(address.substring(0, 5));
		l2cinnerMap.put(address.substring(0, 5), b);
		l2cOuterMap.put(address.substring(5, 14), l2cinnerMap);
		L2Data.l2dinnerMap.put(address.substring(0, 5), k);
		L2Data.l2douterMap.put(address.substring(5, 12), L2Data.l2dinnerMap);
			
			CPU.L2toL1q.put(i+1, CPU.MemtoL2q.get(i));
			CPU.MemtoL2q.remove(i);
			
		}
		
	}
	}