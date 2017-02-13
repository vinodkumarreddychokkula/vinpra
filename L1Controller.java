import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class L1Controller {
	public List<String> instruction = new ArrayList<String>();
	public List<String> variable = new ArrayList<String>();
	public List<String> address = new ArrayList<String>();
	public String index;
	public String tag;
	public String offset;
	public Map<String, Block> l1cMap = new HashMap<String, Block>();
	public Map<String, Map<String, Block>> l1cOuterMap = new HashMap<String, Map<String, Block>>();
	public Map<String, Block> l1cinnerMap = new HashMap<String, Block>();
	L1Data lid = new L1Data();
	L1Data l = new L1Data();
	String S;

	// Memory m= new Memory();
	public L1Controller() {

	}

	public void instructionSplit(String S) {
		this.S = S;
		String[] vals = S.split(" ");
		instruction.add(vals[0]);
		variable.add(vals[2]);
		address.add(vals[1]);
	}

	L2Controller l2 = new L2Controller();

	public void ProcessData() {
		System.out.println("in Process Data"+address);
		Memory m = new Memory();
		for (String i : address) {
			System.out.println(i);
			if (l1cOuterMap.containsKey(i.substring(5, 12)) && l1cinnerMap.containsKey(i.substring(0, 5))) {
				Block a = l1cinnerMap.get(i.substring(0, 5));
				if (a.validBit) {
					System.out.println("HIT IN L1");
				}
			}
				else if (l1cOuterMap.isEmpty()) {
					System.out.println("Miss in L1 "+i);
					String k = l2.ProcessData(i);
					// System.out.println("");
					Block b = new Block();
					b.validBit = true;
					b.tag = i.substring(5, 7);
					l.l1ddata.put(i.substring(0, 5), k);
					l1cMap.put(i.substring(0, 5), b);

					l1cinnerMap.put(i.substring(0, 5), b);
					l1cOuterMap.put(i.substring(5, 12), l1cinnerMap);
					l.l1dinnerMap.put(i.substring(0, 5), k);
					l.l1douterMap.put(i.substring(5, 12), l.l1dinnerMap);
						System.out.println("!st val"+k);
				}

				else if ( !l1cOuterMap.containsKey(i.substring(5, 12))) {
					
					System.out.println("Second");
					String value = l2.ProcessData(i);;
					// System.out.println(value);
					Block b = new Block();
					b.validBit = true;
					b.tag = i.substring(5, 7);
					// int arraySize=l1cMap.size();
					l.l1ddata.put(i.substring(5, 12), value);
					l1cMap.put(i.substring(5, 12), b);
					l1cinnerMap.put(i.substring(0, 5), b);
					l1cOuterMap.put(i.substring(5, 12), l1cinnerMap);
					l.l1dinnerMap.put(i.substring(0, 5), value);
					l.l1douterMap.put(i.substring(5, 12), l.l1dinnerMap);
					System.out.println("Miss in L1, Checking in L2 " + value);
				}

				else if (l1cOuterMap.containsKey(i.substring(5, 12))) {
					System.out.println("Third");
					String value = l2.ProcessData(i);;
					Block b = new Block();
					b.validBit = true;
					b.tag = i.substring(0, 5);
					if (l1cinnerMap.size() >= 2) {
						Set<String> temp = l1cinnerMap.keySet();
						String t = "";
						for (String t1 : temp) {
							t = t1;
						}
						l1cinnerMap.remove(t);
						l1cinnerMap.put(i.substring(0, 5), b);
						l1cOuterMap.put(i.substring(5, 12), l1cinnerMap);
						l.customPut(i, value);

					}

					else {
						l1cinnerMap.put(i.substring(0, 5), b);
						l1cOuterMap.put(i.substring(5, 12), l1cinnerMap);
						l.l1dinnerMap.put(i.substring(0, 5), value);
						l.l1douterMap.put(i.substring(5, 12), l.l1dinnerMap);
					}
				}
			
				else{
					System.out.println("Fourth");
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
		L2Data l2 = new L2Data();
		System.out.println("+++++=====" + l.l1ddata);
		// System.out.println("&&&&&%%%%%"+l2.l.l2ddata);
	}
}
