import java.util.Scanner;
public class Path
{
	public static void main(String [] args)
	{
		Scanner scan=new Scanner (System.in);
		System.out.println("M: ");
		int m=scan.nextInt();
		System.out.println("N: ");
		int n=scan.nextInt();
		System.out.println("E: ");
		int e=scan.nextInt();
		System.out.println("path<="+n+" is: ");
		String p=scan.next();
		String [] pa=new String [p.length()];
		for(int i=0;i<p.length();i++)
		{
			pa=p.split(",");
		}
		int [] path=new int [pa.length];
		for(int i=0;i<pa.length;i++)
		{
			path[i]=Integer.parseInt(pa[i]);
		}

  		State_Vector state=new State_Vector(m,n);
		
		for(int i=0;i<path.length;i++)
		{
			if(path[i]==1)
			{
				state.move1();
			}
			else if(path[i]==2)
			{
				state.move2();
			}
			else
				System.out.println("error");
		}
		state.display();
		System.out.println("position of 2nd chip:"+state.posi2()+" > "+e+" ? "+(state.posi2()>e));	
	}
}
