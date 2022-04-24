package create;

import node.Node;

public class CreateNode {

	public Node createNewNode(int num)
	{
		Node temp=new Node();
		
		temp.data=num;
		temp.left=null;
		temp.right=null;
		
		return temp;
	}
}
