package CacheController;

import java.util.PriorityQueue;

public class CPUtoL1Queue {
	PriorityQueue<String> Queue=new PriorityQueue<String>();
	L1Controller l1c=new L1Controller();
	
	public void CheckL1C(){
	l1c.ProcessData();
	}
}
