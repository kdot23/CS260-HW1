import java.util.Scanner;
import java.util.*;
/**
 * This class is a driver for the Singly or one way linked list
 * 
 * @author Kelsey Lieberman
 * September 6, 2017
 *
 */
public class LinkedListDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedList */
		CustomLinkedList list = new CustomLinkedList();
		System.out.println("My Linked List");
		
		/* Perform list operations */
		while (true)
		{
			System.out.println("\nSingly Linked List Options\n");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. delete at position");
			System.out.println("5. check empty");
			System.out.println("6. get size");
			System.out.println("7. find the first occurrence of a value");
			System.out.println("8. find all the occurrences of a value");
			System.out.println("9. update a value");
			System.out.println("10. update all occurrences of a value");
			System.out.println("11. update a value at a position");			
			System.out.println("12. exit\n");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1 : //Insert at beginning
				System.out.println("Enter integer element to insert");
				list.insertAtStart(scan.nextInt());
				break;
			case 2 : //Insert at end
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(scan.nextInt());
				break;
			case 3 : //Insert at position
				System.out.println("Enter integer element to insert");
				int num = scan.nextInt();
				System.out.println("Enter position");
				int pos = scan.nextInt();
				if (pos <= 1 || pos > list.getSize())
					System.out.println("Invalid position \n");
				else
					list.insertAtPos(num, pos);
				break;
			case 4 : //delete at position
				System.out.println("Enter position");
				int p = scan.nextInt();
				if (p < 1 || p > list.getSize())
					System.out.println("Invalid Position\n");
				else
					list.deleteAtPos(p);
				break;
			case 5 : //check empty
				System.out.println("Empty status = " + list.isEmpty());
				break;
			case 6 : //get size
				System.out.println("Size = " + list.getSize() + "\n");
				break;
			case 7: //find data
				System.out.println("Enter the value to find");				
				System.out.print(" at position " + list.findData(scan.nextInt()));
				break;
			case 8: //find all
				System.out.println("Enter the value to find");
				ArrayList<Integer> positions = list.findAll(scan.nextInt());
				System.out.println ("That value is at the following positions: " + positions.toString());
				break;
			case 9: //update
				System.out.println("Enter the initial value");
				int iv = scan.nextInt();
				System.out.println("Enter the new value");
				int nv = scan.nextInt();
				list.update(iv, nv);
				break;
			case 10: //update all
				System.out.println("Enter the initial value");
				int iva = scan.nextInt();
				System.out.println("Enter the new value");
				int nva = scan.nextInt();
				list.updateAll(iva, nva);
				break;
			case 11: //update at position
				System.out.println("Enter the position to update");
				int posi = scan.nextInt();
				System.out.println("Enter the new value");
				int nval = scan.nextInt();
				list.updateAtPos(posi,nval);
				break;
			case 12: //terminate
				scan.close();
				System.exit(0);
			default :
				System.out.println("Wrong Entry \n");
				break;
			}
		/* Display list */
			LinkedListDriver.display(list);
		}
	}

	/* Function to display elements */
	public static void display(CustomLinkedList list){
		Node start = list.getStart();
		System.out.print("\nLinked List = ");
		if (list.getSize() == 0){
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == null){
			System.out.println(start.getData());
			return;
		}
		Node aNode = start;
		System.out.print(start.getData() + "->");
		aNode = start.getNext();
		while (aNode.getNext() != null){
			System.out.print(aNode.getData() + "->");
			aNode = aNode.getNext();
		}
		System.out.print(aNode.getData() + "\n");
	}
}
