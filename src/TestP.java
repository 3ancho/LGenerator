import java.io.*;
import java.util.Scanner;
class TestP
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
		Tree t=new Tree(0,0);
		
		
		try
		{
			FileWriter fstream = new FileWriter("out_P.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			State_Vector [] leaves_array=new State_Vector[6000];
			for(int j=1;j<=n;j++)
			{
				t=new Tree(m,n);
				t.add(t.root,j);
				leaves_array=t.getLeaves();
			
					out.write("************ step: "+j+"\n");
					for(int i=0;i<(int)Math.pow(2,j);i++)
					{
						out.write(leaves_array[i].toString());
						out.write("\t"+leaves_array[i].posi2()+" > e=1?"+(leaves_array[i].posi2()>e)+"\n");
					}
					out.write("************ end step: "+j+"\n");
				leaves_array=null;
			}
			out.write("\nthe final result is "+obj1(m,n,e));
			out.close();
			System.out.println("\n The result is "+obj1(m,n,e));
		}
		catch (Exception ex)
		{//Catch exception if any
		System.err.println("Error: " + ex.getMessage());
		}
		
	}

	
	public static boolean obj1(long m,int n,int e)// return true when paul wins
        {
                if(m==1)
                        return true;
                Tree t=new Tree(m,n);
                t.add(t.root,n);
                State_Vector [] leaves_array=t.getLeaves();

                for(int i=0;i<(int)Math.pow(2,n);i++)
                {
                        if(leaves_array[i].posi2()<=e) // if 2nd chip survives-> paul loses
                                return false;
                }
                return true;
        }
	
	
}
