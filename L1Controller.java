package parallelCache;

import java.util.HashMap;
import java.util.Map;

public class L1Controller {
	Map<String, Map<String, Block>> l1cOuterMap = new HashMap<String, Map<String, Block>>();
	Map<String, Block> l1cinnerMap = new HashMap<String, Block>();
	L1Controller(){
		Block b = new Block();
		b.validBit = true;
		b.tag = "00000";
		l1cinnerMap.put("00000", b);
		l1cOuterMap.put("0000000", l1cinnerMap);
	}
	public void L1Cexec(int i,String instruction){
		//CPU c1=c;
		System.out.println("l111");
		System.out.println(CPU.Ctol1Q);
		if(CPU.Ctol1Q.containsKey(i)){
			System.out.println("l222");
			String[] vals = instruction.split(" ");
			String command = vals[0];
			String address=vals[1];
			String byteEnables= vals[2];
			String State="";
			System.out.println(address);
			/*if (l1cOuterMap.containsKey(address.substring(5, 12)) && l1cinnerMap.containsKey(address.substring(0, 5))) {*/
			if (l1cOuterMap.containsKey(address.substring(5, 12)) && l1cinnerMap.containsKey(address.substring(0, 5))){
				Block a = l1cinnerMap.get(address.substring(0, 5));
				if (a.validBit) {
					//System.out.println("HIT IN L1");
					State= "HIT";
					System.out.println(State);
				}
			}
			
			switch(State)
			{
			case "HIT":			
				
				System.out.println("in switch");
				System.out.println(CPU.Ctol1Q);
				CPU.L1toCq.put(i+1,instruction);
				CPU.fromCPU=false;
				CPU.Ctol1Q.remove(i);
				System.out.println(CPU.Ctol1Q);
				break;
			}
			
	}
}
}
