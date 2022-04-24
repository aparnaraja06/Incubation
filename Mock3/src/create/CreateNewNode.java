package create;

import node.Node;

public class CreateNewNode {

	public Node createNewNode(int val)
	{
		Node temp=new Node();
		
		temp.data=val;
		temp.left=null;
		temp.right=null;
		
		return temp;
	}
}
