

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2Controller {
	public List<String> instruction = new ArrayList<String>();
	public List<String> variable = new ArrayList<String>();
	public List<String> address = new ArrayList<String>();
	public String index;
	public String tag;
	public String offset;
	public Map<String, Block> l2cMap = new HashMap<String, Block>();
	L2Data lid = new L2Data();
	L2Data l = new L2Data();
	// Memory m= new Memory();
	public L2Controller() {
		

	}
	
	public String  instructionSplit(String S) {
		String[] vals = S.split(" ");
		instruction.add(vals[0]);
		variable.add(vals[2]);
		address.add(vals[1]);
		String k=ProcessData();
	return k;
	}

	public String ProcessData() {
		System.out.println("i am process data of L2");
		for (String i : address) {
			//int calindex = Integer.parseInt(i.substring(0, 1));
			if (l2cMap.isEmpty()) {
				System.out.println("i am process data of L2 to main");
				Memory m = new Memory();
				String value = m.getdata(i);
				//System.out.println(value);
				Block b = new Block();
				b.validBit = true;
			
				l.l2ddata.put(i.substring(0, 1), value);
				l2cMap.put(i.substring(0, 1), b);
				System.out.println("data from main "+ value);
				
			return value;
			}
			else if(! l2cMap.isEmpty() && ! l2cMap.containsKey(i.substring(0, 1)))
			{
				
				Memory m = new Memory();
				String value = m.getdata(i);
				//System.out.println(value);
				Block b = new Block();
				b.validBit = true;
			
				l.l2ddata.put(i.substring(0, 1), value);
				l2cMap.put(i.substring(0, 1), b);
				System.out.println("data from main "+ value);
				
				
				
				
			}
			else if (l2cMap.containsKey(i.substring(0, 1))){
				Block a=l2cMap.get(i.substring(0, 1));
				if(a.validBit){
					System.out.println("Hit Data from L2 "+ l.l2ddata.get(i.substring(0, 1)));
				}
				
				
			}
			/*
			 * m.LoadMemory();
			 * 
			 * Block b=new Block(); b=m.memoryMapping.get("0000000000000000");
			 * System.out.println(b);
			 */
			/*
			 * b.validBit=true; lid.blocks[calindex]=b;
			 * System.out.println("Fetched from main"+
			 * m.memoryMapping.get(address).toString());
			 */
			}
return "0";
	}
}
	/*public String getdata(address : i){
		if(l2cMap.containsKey(i.substring(0, 1))){
		return l2cMap.get(i.substring(0, 1));
		}
		else
			return null;
	}
}}*/