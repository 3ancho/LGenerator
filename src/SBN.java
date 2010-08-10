public class SBN
{
	int n;
	int r;
	long [][] combination;

	public SBN(int n_in,int r_in)
	{
		n=n_in;
		r=r_in;
		combination=new long[n_in+2][r_in+2];
	}
	
	public void calculate_combination()
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<=r;j++)
			{
				if((i==j&&i>=0)||(j==0&&i>0))
			 		combination[i][j]=1;
				else if(r==1)
					combination[i][j]=i;
				else
					combination[i][j]=combination[i-1][j]+combination[i-1][j-1];
			}
		}	
	}

	public void display_combination()
	{
		for(int j=0;j<=n;j++)
		{
			for(int i=1;i<=r;i++)
			{
				System.out.print(combination[i][j]+"\t");
			}
			System.out.println();
		}	
		
	}
	
	public long sbp(int n,int e)
	{
		long bottom=0;
		for(int i=0;i<=e;i++)
		{
			if(i<=n)
				bottom+=combination[n][i];
		}	
		return (long)Math.floor(Math.pow(2.0,n)/bottom);
	}
	
	public long sbk(int n,int e)
	{
		long bottom=0;
		for(int i=0;i<=e;i++)
		{
			if(i<=n)
				bottom+=combination[n][i];
		}
		return (long)Math.ceil(Math.pow(2.0,n)/bottom);
	}
}
