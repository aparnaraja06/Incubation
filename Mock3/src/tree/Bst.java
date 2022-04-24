package tree;

import create.CreateNewNode;
import node.Node;

public class Bst {

	public Node insert(Node node,int val)
	{
		CreateNewNode temp=new CreateNewNode();

		if(node==null)
		{
			return temp.createNewNode(val);
		}
		
		if(val< node.data)
		{
			node.left=insert(node.left,val);
		}
		
		if(val>node.data)
		{
			node.right=insert(node.right,val);
		}
		
		return node;
	}
	
	public Node trimLeaf(Node node,int low,int high)
	{
		if(node==null)
		{
			return null;
		}
		 if(node.data < low)
	     {
	            return trimLeaf(node.right,low,high);
	     }
	     else if(node.data >  high)
	     {
	            return trimLeaf(node.left,low,high);
	     }
	        
	   node.left=trimLeaf(node.left,low,high);
	   node.right=trimLeaf(node.right,low,high);
	        
	  return node;	
	 }
}
