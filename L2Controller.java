

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
	
	/*public String  instructionSplit(String S) {
		String[] vals = S.split(" ");
		instruction.add(vals[0]);
		variable.add(vals[2]);
		address.add(vals[1]);
		System.out.println("Checking in L2");
		String k=ProcessData();	
		System.out.println("Value returning from L2 to L1"+k);
	return k;
	}*/

	public String ProcessData(String i) {
		//System.out.println("i am process data of L2");
		
			System.out.println(i);
			if (l2cMap.isEmpty()) {
				System.out.println("first");
				System.out.println("Not in L2"+i);
				Memory m = new Memory();
				String value = m.getdata(i);
				//System.out.println(value);
				Block b = new Block();
				b.validBit = true;
				b.tag = i.substring(0,5);
				l.l2ddata.put(i.substring(5, 14), value);
				l2cMap.put(i.substring(5, 14), b);
				//System.out.println("appended");
			System.out.println("miss in l2, data from main "+l.l2ddata);
				
			return value;
			}
			else if(! l2cMap.isEmpty() && ! l2cMap.containsKey(i.substring(5, 12)))
			{
				System.out.println("second l2");
				Memory m = new Memory();
				String value = m.getdata(i);
				//System.out.println(value);
				Block b = new Block();
				b.validBit = true;
				b.tag = i.substring(0,5);
				l.l2ddata.put(i.substring(5, 14), value);
				l2cMap.put(i.substring(5, 14), b);
				System.out.println("data from main "+ value + l2cMap.toString());
				return value;
				
			}
			else if (l2cMap.containsKey(i.substring(5, 14)) ){
				System.out.println("third l2");
				Block a=l2cMap.get(i.substring(5, 14));
				if(a.validBit && a.tag.equals(i.substring(0,5))){
					System.out.println("Hit Data from L2 "+ l.l2ddata.get(i.substring(5, 14)));
					return null;
				}
				else {
					Memory m = new Memory();
					String value = m.getdata(i);
					//System.out.println(value);
					Block b = new Block();
					b.validBit = true;
					b.tag = i.substring(0,5);
					l.l2ddata.put(i.substring(5, 14), value);
					l2cMap.put(i.substring(5, 14), b);
					return value;
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
			
		
		else{
			
			System.out.println("L2 final");
			return null;
		}

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