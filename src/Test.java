public class Test
{
	public static void main(String [] args)
	{
		Tree t= new Tree(1,2);
		t.add(t.root,1);

		System.out.println(obj1(1,1,1));
		t.root.value.display();
		t.root.left.value.display();
		t.root.right.value.display();
	}
	
	public static boolean obj1(long m,int n,int e)// return true when paul wins
        {
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
