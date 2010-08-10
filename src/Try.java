// this will generate SB for P and K
public class Try
{
	public static void main(String [] args)
	{
		int n=18,e=18;
		SBN sb1=new SBN(n,e);   // this first argument is n:steps, the second is e.
		sb1.calculate_combination();

		for(int j=0;j<=e;j++)
		{
			for(int i=1;i<=n;i++)
			{	
				System.out.print(" "+sb1.combination[i][j]);
			}
			
			System.out.println();
		}				

		System.out.println("\nsb p\n" );// first n, second e/	
		for(int j=0;j<=e;j++)  // first loop e
		{
			for(int i=1;i<=n;i++) // second loop n
			{
				System.out.print(" "+sb1.sbp(i,j)+"\t");// 1st n, 2nd e
			}
			System.out.println();		
		}// Until now The SB for P is OK. 
		System.out.println("\n com(2,1) "+sb1.combination[1][0]);

		System.out.println("\n sb(2,1) "+sb1.sbp(2,1));
		
		System.out.println("\nsb K\n" );// first n, second e/	
		for(int j=0;j<=e;j++)  // first loop e
		{
			for(int i=1;i<=n;i++) // second loop n
			{
				System.out.print(" "+sb1.sbk(i,j)+"\t");// 1st n, 2nd e
			}
			System.out.println();		
		}// Until now The SB for K is OK. 
	}
}
