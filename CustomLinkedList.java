/**
 * This class implements a Singly or One way linked list
 * @author Kelsey Lieberman
 * September 6, 2017
 *
 */
public class CustomLinkedList {
	private Node start;
	private Node end;
	private int size;
	
	/* Constructor */
	public CustomLinkedList(){
		start = null;
		end = null;
		size = 0;
	}
	
	/*Function to check if the list is empty */
	/**
	 * 
	 * @return true: if the list is empty, false: otherwise
	 */
	public Boolean isEmpty(){
		if (start == null)
			return true;
		else
			return false;
	}
	
	/* Function to get size of list */
	/**
	 * @return size of the list (# nodes)
	 */
	public int getSize(){
		return size;
	}
	
	/* Function to insert an element at the beginning */
	/**
	 * 
	 * @param val value to be inserted at the first node of the list
	 */
	public void insertAtStart(int val){
		Node node = new Node(val, null);
		size++;
		if (start == null){
			start = node;
			end = start;
		}
		else{
			node.setNext(start);
			start = node;
		}	
	}
	
	/* Function to insert an element at the end */
	/**
	 * 
	 * @param val value to be inserted at the last node of the list
	 */	
	public void insertAtEnd(int val){
		Node node = new Node(val,null);
		size++;
		if (start == null){
			start = node;
			end = start;
		}
		else{
			end.setNext(node);
			end = node;
		}
				
	}
	/*Function to insert an element at a given position*/
	/**
	 * 
	 * @param val value to be inserted in the list
	 * @param pos position of the value in the list
	 */
	public void insertAtPos(int val, int pos){
		if (pos == 1 || pos == size - 1){
			System.out.println("Error: This method does not accept starting or ending positions.");
			return;
		}
		
		Node node = new Node(val, null);
		Node aNode = start;
		pos = pos - 1;
		for (int i =1; i < size; i++){
			if (i == pos){
				Node tmp = aNode.getNext();
				aNode.setNext(node);
				node.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size++;
	}
	
	/* Function to delete an element at a given position */
	/**
	 * 
	 * @param pos position from which the item needs to be deleted (node position)
	 */
	public void deleteAtPos(int pos){
		if (pos == 1){
			start = start.getNext();
			size--;
			return;
				
		}
		if (pos == size){
			Node s = start;
			Node t = start;
			while (s != end){
				t=s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size--;
			return;
		}
		Node aNode = start;
		pos = pos -1;
		for (int i =1; i < size - 1; i++){
			if ( i == pos){
				Node tmp = aNode.getNext();
				tmp = tmp.getNext();
				aNode.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size--;
	}
	
	/**
	 * 
	 * @param val accepts an int argument for the value to be searched
	 * @return the first position of the data (node) or -1 if not found
	 */
	public int findData(int val){
		Node aNode = start;
		int position = 1;
		while (!aNode.getNext().equals(null)){
			if (aNode.getData() == val){
				System.out.println("Found in LinkedList");
				return position;
				
			}
			aNode = aNode.getNext();
			position++;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param val accepts an int argument for the value to be searched
	 * @return an int array with all the positions of the val in the 
	 * linkedlist, -1 if not found
	 */
	
	public int[] findAll(int val){
		int [] positions = null;
		Node aNode = start;
		int position = 1;
		int occurrences = 0;
		while (!aNode.getNext().equals(null)){
			if (aNode.getData() == val){
				positions[occurrences] = position;
				occurrences++;
			}
			aNode = aNode.getNext();
			position++;
		}
		if (occurrences != 0){
			positions[0] = -1;
		}
		
		return positions;
		
	}

	/**
	 * updates the first occurrence of initialVal to newVal
	 * @param initialVal old value to be updated
	 * @param newVal new value with which old value is replaced
	 */
	public void update(int initialVal, int newVal){
		Node aNode = start;
		while (!aNode.getNext().equals(null)){
			if (aNode.getData() == initialVal){
				aNode.setData(newVal);
				return;
			}
			else{
				aNode = aNode.getNext();
			}
		}		
	}
	
	/**
	 * updates all the occurrences of initialVal to newVal
	 * @param initialVal old value to be updated
	 * @param newVal new value with which the old value is replaced 
	 */
	public void updateAll(int initialVal, int newVal){
		Node aNode = start;
		while (!aNode.getNext().equals(null)){
			if (aNode.getData() == initialVal){
				aNode.setData(newVal);
			}
			aNode = aNode.getNext();
		}
	}
	
	/**
	 * 
	 * @param pos position of the node to be updated
	 * @param newVal new value that needs to be updated at the position
	 */
	public void updateAtPos(int pos, int newVal){
		Node aNode = start;
		for (int i=0; i < pos - 1; i++){
			aNode = aNode.getNext();
		}
		aNode.setData(newVal);
	}
	
	/**
	 * 
	 * @return the start reference of the linkedlist
	 */
	public Node getStart(){
		return start;
	}
	
	/**
	 * 
	 * @return the end reference of the linkedlist
	 */
	public Node getEnd(){
		return end;
	}
		
}

	
