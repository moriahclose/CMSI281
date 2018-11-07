/***********************************************************************
Authors: Tapiwa Tafa and Moriah Tolliver
Purpose: Demonstrates Huffman tree
*************************************************************************/

import java.io.*;
import java.util.*;


/**
* Internal class to create a HuffmanNode
*/
class HuffmanNode implements Comparable<Object>
{
	public String sData;
	public Integer iData;
	public HuffmanNode leftChild;
	public HuffmanNode rightChild;

	/**
	 * Display conents of a node and number of times it occurs
	 */
	public void displayNode()
	{
		System.out.print("{" + sData + ", " + iData + "}");
	}

	/**
	 * Compares the contents of the current node and an input node
	 * @param Object that is being compared to the current object
	 * @return int difference between data in two nodes
	 */
	public int compareTo(Object o)
	{
		HuffmanNode node = (HuffmanNode)o;
		return (this.iData - node.iData);
	}
}

class HuffmanTree
{
	private HuffmanNode root;
	private String[] codeTable;
	private String huffmanCode;

	/**
	 * Constructor
	 * @param String inital string of characters to be parsed into the tree
	 */
	public HuffmanTree(String initString)
		{
			huffmanCode = new String();
			codeTable = new String[128]; //going to keep it ASCII for simplicity
			System.out.print("Initializing Huffman tree...");

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			String s = initString;
			for(int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);
				Integer val = map.get(new Character(c));
				if(val != null)
					map.put(c, new Integer(val + 1));
				else
					map.put(c, 1);
			}

			PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue<HuffmanNode>();
			for(Map.Entry<Character, Integer> entry : map.entrySet())
			{
				String key = Character.toString(entry.getKey());
				Integer value = entry.getValue();
				HuffmanNode tempNode = new HuffmanNode();
				tempNode.sData = key;	//node contains character
				tempNode.iData = value; //and frequency of character
				nodeQueue.add(tempNode);
			}

			while(nodeQueue.size() > 1)
			{
				HuffmanNode temp1 = nodeQueue.remove();
				HuffmanNode temp2 = nodeQueue.remove();
				HuffmanNode newTree = new HuffmanNode();
				newTree.iData = temp1.iData + temp2.iData;
				newTree.leftChild = temp1;
				newTree.rightChild = temp2;
				nodeQueue.add(newTree);
			}

			root = nodeQueue.remove();

			System.out.println(" done");

			System.out.print("Creating code table...");
			createTable(root);
			System.out.println(" done");

		}

	/**
	 * Create code table
	 * @param HuffmanNode localRoot
	 */
	public void createTable(HuffmanNode localRoot)
	{
		if(localRoot.sData != null)
		{
			char temp = localRoot.sData.charAt(0);
			int index = (int)temp;
			codeTable[index] = huffmanCode;
			System.out.println("Generated (" + codeTable[index] + ") at index " + index);
			return;
		}
		else
		{
			huffmanCode += "0";
			createTable(localRoot.leftChild);
			huffmanCode = huffmanCode.substring(0, huffmanCode.length()-1);

			huffmanCode += "1";
			createTable(localRoot.rightChild);
			huffmanCode = huffmanCode.substring(0, huffmanCode.length()-1);
		}
	}

	/**
	 * Encode the string with binary
	 * @param String message to encode
	 * @return String binary string that represents the input string
	 */
	public String encode(String message)
	{
		String result = new String();
		for(int i = 0; i < message.length(); i++)
		{
			char temp = message.charAt(i);
			int index = (int)temp;
			result += codeTable[index];
		}
		return result;
	}

	/**
	 * Change the message from binary to its original form
	 * @param String message to decode
	 * @return String original form of the input coded message
	 */
	public String decode(String codedMessage)
	{
		String result = new String();
		HuffmanNode temp = root;
		int i = 0;
		while(i < codedMessage.length())
		{
			if(temp.sData == null)
			{
				if(codedMessage.charAt(i) == '0') {temp = temp.leftChild;}
				else if(codedMessage.charAt(i) == '1') {temp = temp.rightChild;}
				i++;
			}
			else
			{
				result += temp.sData;
				temp = root;
			}
		}
		result += temp.sData;	//parse the last character


		return result;
	}

	/**
	 * Traverse the tree
	 * @param int representing what type of traversal of do 1 is preorder, 2 is inorder, and 3 is postorder
	 */
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
		case 2: System.out.print("\nInorder traversal: ");
				inOrder(root);
				break;
		case 3: System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println("");
	}

	/**
	 * Perform and print preorder tree traversal
	 * @param HuffmanNode that represents the root of the tree
	 */
	private void preOrder(HuffmanNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.sData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * Perform and print inorder tree traversal
	 * @param HuffmanNode that represents the root of the tree
	 */
	private void inOrder(HuffmanNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print("(");
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.sData + " ");
			inOrder(localRoot.rightChild);
			System.out.print(")");
		}
	}

	/**
	 * Perform and print postorder tree traversal
	 * @param HuffmanNode that represents the root of the tree
	 */
	private void postOrder(HuffmanNode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.sData + " ");
		}
	}

	/**
	 * Display the contents of the tree
	 */
	public void displayTree()
	{
		Stack<HuffmanNode> globalStack = new Stack<HuffmanNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		".......................................................");
		while(isRowEmpty==false)
		{
			Stack<HuffmanNode> localStack = new Stack<HuffmanNode>();
			isRowEmpty = true;

			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");

			while(globalStack.isEmpty() == false)
			{
				HuffmanNode temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.sData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push( localStack.pop() );
		}
		System.out.println(
		"..................................");
	}
}

/**
* Class to test the HuffmanTree class
*/
class HuffmanTreeApp
{
	public static void main(String[] args) throws IOException
	{
		int value;
		String initString = "Alleluia, praise the LORD!!!";
		String encoded = new String();
		String decoded = new String();
		HuffmanTree theTree = new HuffmanTree(initString);

		while(true)
		{
			System.out.print("Enter first letter of decode, encode, show,"
					+ " or traverse: ");
			int choice = getChar();
			switch(choice)
			{
			case 'e':
				encoded = theTree.encode(initString);
				System.out.println(encoded);
				break;
			case 'd':
				decoded = theTree.decode(encoded);
				System.out.println(decoded);
				break;
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.print("Enter type 1, 2, or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry!\n");
			}
		}
	}

	/**
	 * Reads input string
	 * @return String that was input
	 */
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	/**
	 * Get first character of the string
	 * @return char first character of the string
	 */
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}

	/**
	 * Get integer representation of line
	 * @return int representation of string
	 */
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}
