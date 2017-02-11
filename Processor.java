package CacheController;

import java.io.File;
//import java.io.FileNotFoundException;
import java.util.*;
public class Processor {

	public static void main(String[] args) throws Exception {
		
		File inputFile = new File("C:/Users/Vinod Chokkula/workspace1/rg.eclipse.examples.helloworld/src/CacheController/Input.txt");
		CPUtoL1Queue cl1=new CPUtoL1Queue();
		Scanner sc;
		sc = new Scanner(inputFile);
		L1Controller l1c=new L1Controller();
		
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			l1c.instructionSplit(line);
			cl1.Queue.add(line);
		}
		cl1.CheckL1C();
			sc.close();
		
	} 
	}
	