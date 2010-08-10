public class State_Vector{
	
	public static int LEN;
	public long [] array;
	
	public State_Vector(long ini_number_chips,int steps)  //constructor
	{
		LEN=steps+1;
		array=new long[LEN];
		array[0]=ini_number_chips;
	}
	
	public State_Vector(long [] a)
	{
		array=a;
	}

	//*default methods*//

	public void setArray(long [] a)
	{
		array=a;
	}

	public long [] getArray()
	{
		return array;
	}
	//above are default methods.
	
	//*** Important Methods ***//

	public State_Vector clone()
	{
		long [] copy_array=new long[this.array.length];
		for(int i=0;i<array.length;i++)
			copy_array[i]=array[i];
		State_Vector one=new State_Vector(copy_array);
		return one;
	}
	
	public void display()
	{
		for(int i=0;i<LEN;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	public String toString()
	{
		String a="";
		for(int i=0;i<LEN;i++)
		{
			a=a+array[i]+" ";
		}
		return a;
	}
	
	// move1 is moving more to right //
	public State_Vector move1()
	{
		long copy_array []= new long[array.length];
		for(int i=0;i<LEN;i++)
		{
			copy_array[i]=array[i];
			array[i]=0;
		}
		// copy data to copy_array	
		
		//from Professor Ellis ***  now working.
		int parity=1;
		for(int i=0;i<LEN-1;i++)
		{
			if(copy_array[i]%2==1)
			{
				array[i+parity]=1+array[i+parity];
				parity=1-parity;
			}
			array[i]+=(long)Math.floor(copy_array[i]/2.0);
			array[i+1]+=(long)Math.floor(copy_array[i]/2.0);
			
		}
		return this;
	}
		
	// move2 is moving less to right //
	public State_Vector move2()
	{
		long copy_array []= new long[array.length];
		for(int i=0;i<LEN;i++)
		{
			copy_array[i]=array[i];
			array[i]=0;
		}
		// copy data to copy_array	
		
		int parity=0;
		for(int i=0;i<LEN-1;i++)
		{
			if(copy_array[i]%2==1)
			{
				array[i+parity]=1+array[i+parity];
				parity=1-parity;
			}
			array[i]+=(long)Math.floor(copy_array[i]/2.0);
			array[i+1]+=(long)Math.floor(copy_array[i]/2.0);
			
		}
		return this;
	}
	
	public int posi1()
	{
		int result=0;
		for(int i=0;i<LEN;i++)
		{
			if(array[i]!=0)
				{result=i;break;}
		}
		return result;
	}
	
	public int posi2()
	{
		int count=0;
		int result=0;
		for(int i=0;i<LEN-1;i++)
		{
			count+=array[i];
			if(count>=2)
				{result=i;break;}
			if(count==1&&array[i+1]!=0)
				{result=i+1 ;break;}
		}
		return result;
	}

}// end of class
