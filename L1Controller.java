import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1Controller {
	public List<String> instruction = new ArrayList<String>();
	public List<String> variable = new ArrayList<String>();
	public List<String> address = new ArrayList<String>();
	public String index;
	public String tag;
	public String offset;
	public Map<String, Block> l1cMap = new HashMap<String, Block>();
	L1Data lid = new L1Data();
	L1Data l = new L1Data();
	String S;
	// Memory m= new Memory();
	public L1Controller() {

	}

	public void instructionSplit(String S) {
		this.S= S;
		String[] vals = S.split(" ");
		instruction.add(vals[0]);
		variable.add(vals[2]);
		address.add(vals[1]);
	}

	public void ProcessData() {
		for (String i : address) {
			//int calindex = Integer.parseInt(i.substring(0, 1));
			if (l1cMap.isEmpty() ) {
				System.out.println("Miss in L1, Hit in L2, data from L2 " );
				
				L2Controller l2 = new L2Controller();
				
			String k=l2.instructionSplit(S);
				l.l1ddata.put(i.substring(0, 1), k);
				
				
				
			}
			
			else if (! l1cMap.isEmpty() && ! l1cMap.containsKey(i.substring(0, 1)) ) {
				Memory m = new Memory();
				String value = m.getdata(i);
				// System.out.println(value);
				Block b = new Block();
				b.validBit = true;
				//int arraySize=l1cMap.size();
				l.l1ddata.put(i.substring(0, 1), value);
				l1cMap.put(i.substring(0, 1), b);
				System.out.println("Miss in L1, Miss in L2, Data from L2 "+ value);
			}
			else if (l1cMap.containsKey(i.substring(0, 1))){
				
				Block a=l1cMap.get(i.substring(0, 1));
				if(a.validBit){
					
					System.out.println("Hit Data from L1 "+ l.l1ddata.get(i.substring(0, 1)));
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
			 *///
}

	}
}

