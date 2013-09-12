package Classwork;

class BinaryTreeNode {

	/*private int Value; private myNode Left; private myNode Right;*/
		
    int nodevalue;
    Boolean isLeaf;
	
	BinaryTreeNode(){
		
	}		
	
	// 
	/**
	 * Constructor #2 - This store the node value
	 * 
	 * @param nodevalue The value for the node
	 * @param isLeaf if node is a leaf
	 */
	BinaryTreeNode(int nodevalue, boolean isLeaf){
		this.nodevalue = nodevalue;  // "this" uses local object w/in same class
		this.isLeaf = isLeaf;
	}
				
	// Set Value
	public void setValue(int nodevalue){
		this.nodevalue = nodevalue;  // this uses local object w/in same class
	}
	
	// Get Value
	public int getValue(){
		return nodevalue;
	}
	
	// Set Leaf value
	public void setLeaf(boolean leaf){
		this.isLeaf = leaf;
	}
	
	public boolean isLeaf(){
        return isLeaf;
    }

	public void setIsRoot(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
	
}

