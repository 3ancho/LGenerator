

import java.util.*;
public class PStar {
	public static void main(String [] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("range of steps n is from 0 to: ");
		int input_n=scan.nextInt();
		System.out.println("range of e is from 0 to: ");
		int input_e=scan.nextInt();
		long sb;
		boolean done;

		SBN sb1=new SBN(input_n,input_e);
		sb1.calculate_combination();

		int a;//SB increment 
		long left;
		long right;
		long test;

		for(int i=0;i<=input_e;i++)
		{
			for(int j=1;j<=input_n;j++)
			{
                                if(j<=2*i)
				    System.out.print("1\t");	
                                else
				{
				    done=false;
				    sb=sb1.sbk(j-i, i);   // SB is returning SB value for specific e and n value
				    a=0;
				    while(!done)
				    {
					    test=sb-2+(long)Math.pow(2.0,a+1); // test=sb, test=sb+3, test=sb+7, test=sb+15.....
					    if(obj2(test,j-i,i))
					    {
						right=test;     //right=SB-2+2^(i+1)
						left=sb-1+(long)Math.pow(2.0,a);    //Left=SB-1+2^i
						System.out.print(search(left,right,j-i,i)+"\t");
						done=true;
					    }
					    else
					    {
						a++;
					    }
				    }
				}
			}
			System.out.println(); // generate new line after a row is completed.
		}
	}

	public static long search(long left,long right,int n,int e)
	{
		long mid=(long)Math.floor((left+right)/2.0);
		if(left==right)
			return left;
		else if(obj2(mid,n,e))
			return search(left,mid,n,e);
		else
			return search(mid+1,right,n,e);
			
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

