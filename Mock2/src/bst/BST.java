package bst;

import create.CreateNode;
import node.Node;

public class BST {

	public Node insert(Node node,int val) {
		
		CreateNode temp=new CreateNode();
		
		if(node==null)
		{
			return temp.createNewNode(val);
		}
		
		if(val < node.data)
		{
			node.left=insert(node.left,val);
		}
		
		if(val > node.data)
		{
			node.right=insert(node.right,val);
		}
		
		return node;
	}
	
	public Node getChild(Node node,int val)
	{
		if(node==null)
		{
			return null;
		}
		
		if(val < node.data)
		{
			node.left=getChild(node.left,val);
		}
		
		if(val > node.data)
		{
			node.right=getChild(node.right,val);
		}
		
		else
		{
			if(node.left==null || node.right==null)
			{
				Node temp=null;
				
				temp=node.left==null? node.right:node.left;
				
				if(temp==null)
				{
					return null;
				}
				else
				{
					Node result1=helper(node);
				}
			}
		}
		return node;
	}
	
	public Node helper(Node node)
	{
		if(node==null)
		{
			return null;
		}
		Node temp=null;
		
		helper(node.left);
		
		temp=node.data;
		
		helper(node.right);
	
		return temp;
	}
}
