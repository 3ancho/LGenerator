import java.io.*;
import java.util.Scanner;
class TestK 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("This program will print out the state of each node of a tree of depth n:");
		System.out.println("Initial number of chips M=:");
		long m=(long)scan.nextInt();
		System.out.println("number of steps N=:");
		int n=scan.nextInt();
		System.out.println("eliminator e=:");
		int e=scan.nextInt();
		Tree t=new Tree(m,n);
		
		
		try
		{
			FileWriter fstream = new FileWriter("out_K.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for(int j=1;j<=n;j++)
			{
				t.root.value.move1();	
				out.write("************ step: "+j+"\n");
				out.write(t.root.value.toString());
				out.write("positon of 1st chip is "+t.root.value.posi1()+" <= "+e);		
				out.write("\n************ end step: "+j+"\n");

				
				
			}
			out.write("the final result is "+obj2(m,n,e));
			out.close();
		}
		catch (Exception ex)
		{//Catch exception if any
		System.err.println("Error: " + ex.getMessage());
		}
		
		System.out.println("the final result is "+obj2(m,n,e));
	}

	// maxM paul wins  Pstar
	public static boolean obj1(long m,int n,int e)// return true when paul wins
	{
		Tree t=new Tree(m,n);
		t.add(t.root,n);
		boolean done=false;
		State_Vector [] leaves_array=t.getLeaves();
		
		for(int i=0;i<(int)Math.pow(2,n);i++)
		{
			if(leaves_array[i].posi2()<=e) // if 2nd chip survives-> paul loses
				return false;
		}
		return true;
	}
	
	// minM paul wins  KStar
	public static boolean obj2(long m,int n,int e)// return true when paul wins
	{
		State_Vector object=new State_Vector(m,n);
		for(int i=0;i<n;i++)
		{
			object.move1();
		}
		if(object.posi1()<=e)  // if 1st chip survives-> paul wins
			return true;
		else
			return false;
	}
}
