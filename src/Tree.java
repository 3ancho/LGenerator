public class Tree
{
   private int size;  // size for the tree! # of nodes.
   public Node root;  // root of the tree
   State_Vector [] arr;
   int counter=0;
   State_Vector copy1,copy2;
   
   public class Node // inner class describes Node
   {
      Node left;
      Node right;
      State_Vector value;
      // array value describe # of chips and their position

      public Node()
      {
         value=null;
         left=null;
         right=null;
      }
      public Node(State_Vector a_value)
      {
         value=a_value;
         left=null;
         right=null;
      }
      
      
   }// End of The Node Class

   // following are Tree constructor and other methods

	public Tree(long ini_m,int step)
	{
		arr=new State_Vector[(int)Math.pow(2.0,step)];
		size=0;
		root=new Node(new State_Vector(ini_m,step));
		root.left=null;
		root.right=null;
	}


   public int size()
   {
      return size;
   }

   public void add(Node node, int n)    // this will generate a tree of specific depth.
   {
	   if(n==0)
	   {
		   arr[counter++]=node.value;return;   // when we reached the leaves we store them into an array.For later use.
	   }
	   copy1=node.value.clone();
	   copy2=node.value.clone();	
	   node.right=new Node(copy1.move2());
	   node.left=new Node(copy2.move1());
	   add(node.right,n-1);
	   add(node.left,n-1);
   }
   
   //*** important methods ***//
   public State_Vector[] getLeaves()
   {
	   return arr; 
   }
   
   
     
}
