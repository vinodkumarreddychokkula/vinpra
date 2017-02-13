package parallelCache;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class CPU {
	CPU(){
		
	}
	public ArrayList<String> l1toCpuQ =new ArrayList<String>();
	public ArrayList<String> Cputol1Q =new ArrayList<String>();
	public ArrayList<String> ftocpuq =new ArrayList<String>();
	
	public static HashMap<Integer,String> ftol1q=new HashMap<Integer,String>();
	public static HashMap<Integer,String> Ctol1Q =new HashMap<Integer,String>();
	public static HashMap<Integer,String> L1toCq =new HashMap<Integer,String>();
	static Boolean fromCPU;
	
	public void customPut(String[] args) throws Exception {
		ArrayList<String> instuctions =new ArrayList<String>();
		HashMap<Integer,String> instructionsMap =new HashMap<Integer,String>();
		//ArrayList<String> CPUtoL1cQ =new ArrayList<String>();
		File inputFile = new File("C:/Users/Vinod Chokkula/ACAProj/Cache/src/Input.txt");
		
		Scanner sc;
		sc = new Scanner(inputFile);
		int i=1;
		int currentTime=1;
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			instructionsMap.put(i, line);
		i++;
			}
		
		String cline=(instructionsMap.get(currentTime));
		CPU c=new CPU();
		ftol1q=instructionsMap;
		System.out.println("ftol1q "+ftol1q);
		
		c.Scheduler(ftol1q);
		sc.close();
	}
	
	public void Scheduler(HashMap<Integer,String> ftol1Q){
		
		int count=1;
		fromCPU=true;
		CPU c1=new CPU();
		for(int i=1;i<4;i++ )
		{
		System.out.println("Cycle "+i);
		//CPU
		
		c1.CpuExec(i,ftol1Q.get(i));
		
		//L1
		L1Controller l1=new L1Controller();
		l1.L1Cexec(i,Ctol1Q.get(i));
		//L2
		//memory
		count++;
	}}
	/*public void CputoL1c(String S){
		L1Controller l1c=new L1Controller();
		l1c.L1Cexec(S);
	}
*/	public void CpuExec(int n,String S){
	
	if(fromCPU && S!=null){
		
		System.out.println("first"+S);
		
		Ctol1Q.put(n+1, S);
		ftol1q.remove(n);
		System.out.println("after adding to Ctol1Q, ftol1q is "+ftol1q+n);
		/*Cputol1Q.add(a);
		ftocpuq.clear();*/
		return;
	}
	else if(!fromCPU) {
		System.out.println("Value is "+L1toCq);
		return;
		
	}
	else return;
	}
}
