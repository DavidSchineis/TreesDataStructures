import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class assign3 {

	public static void main(String[] args) {
		try {
		
			File file = new File("tree.txt");
			Scanner sc = new Scanner(file);
			Scanner input = new Scanner(System.in);
			ArrayList<String> lines = new ArrayList<>();
			ArrayList<String> preOrderList = new ArrayList<>();
			ArrayList<String> postOrderList = new ArrayList<>();
			ArrayList<String> inOrderList = new ArrayList<>();
			ArrayList<String> BFSList = new ArrayList<>();
		
			Node<String> node = null;
			Node<String> root = null;
			String first = null;
			String[] firstElements = null;
			String[] elements = null;
			
			while(sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			System.out.println("Is this a binary tree? (Yes/No)");
			String response = input.next();
			
			
			first = lines.get(0);
			firstElements = first.split(" ");
		
			
			for(int i = 1; i<firstElements.length;i++) {
				if(root == null) {
					root = new Node<String>(null, firstElements[0]);
				}
				root.addChild(firstElements[i]);			
			}			
			
			
			for(int i = 1; i<lines.size(); i++) {
				elements = lines.get(i).split(" ");	
				ArrayList<String> rootChildren = new ArrayList<String>();
				root.Tree(root, elements[0], rootChildren, root, node, elements);
			}				

			preOrderList = preOrder(root, preOrderList);
			postOrderList = postOrder(root, postOrderList);
			BFSList.add(root.element);
			BFSList = BFS(root, BFSList);
			
			System.out.println("Pre-order: " + preOrderList.toString());
			System.out.println("Post-order: " + postOrderList.toString());
			if(response.equalsIgnoreCase("Yes")){
				inOrderList = inOrder(root, inOrderList);
				System.out.println("In-order: " + inOrderList.toString());
			}
			System.out.println("BFS: " + BFSList.toString());
			
			input.close();
			sc.close();
			
		}
		catch (FileNotFoundException FNFException){
			System.out.println("File not found");
		}

	}
	
	public static class Node<E> {
		public ArrayList<Node<E>> children;
		public Node<E> parent;
		public E element;
		
		public Node(Node<E> parent, E element) {
			this.parent = parent;
			this.element = element;
			this.children = new ArrayList<Node<E>>();
		}
		
		public void addChild(E element) {
			
			if(this.children != null) {
				this.children.add(new Node<E>(this,element));
			}
		}
		
		public Node<E> getChildAt(int position){
			
			if(position < this.children.size()) {
				return this.children.get(position);
			}
			else {
				return null;
			}
		}
		
		public boolean hasChildren() {
			
			if(this.children != null) {
				return (this.children.size() != 0);
			}
			
			return false;
			
		}
		
		public ArrayList<E> getChildren(){
			
			ArrayList<E> list = new ArrayList<>();
			
			for(int i = 0; i < children.size(); i++) {
				E child = children.get(i).element;
				list.add(child);
			}
			
			return list;
			
		}
		
		
		
		public Node<E> Tree(Node<E> node, E element, ArrayList<E> children, Node<E> root, Node<E> current, E[] elements){
			
			if(node.getChildren().contains(element) || node.element == element) {		
				children = node.getChildren();	
				for(int j = 1; j<elements.length;j++) {	
					if(children.contains(elements[0])) {
						int index = children.indexOf(elements[0]);
						current = node.getChildAt(index);
						current.addChild(elements[j]);					
					} 
					
				}			
			return root;
			}

			for(Node<E> child : node.children) {				
				Tree(child, element, children, root, current, elements);				
				
			}					
			
			return root;
		}		
		
	
		
		
	}
	
	public static ArrayList<String> preOrder(Node<String> node, ArrayList<String> list){
		
		list.add(node.element);
		
		if(node.hasChildren()) {
			for(Node<String> child : node.children) {
				preOrder(child, list);
			}
		}
		return list;
		
	}
	
	public static ArrayList<String> postOrder(Node<String> node, ArrayList<String> list){
		
		if(node.hasChildren()) {
			for(Node<String> child : node.children) {
				postOrder(child, list);
			}
		}
		list.add(node.element);
		return list;
	}
	
	public static ArrayList<String> inOrder(Node<String> node, ArrayList<String> list){
		
		list.add(node.element);
		
		if(node.getChildAt(0) != null){
			inOrder(node.getChildAt(0), list);
		}
		if(node.getChildAt(1) != null) {
			inOrder(node.getChildAt(1), list);
		}
		return list;
	} 
	
	public static ArrayList<String> BFS(Node<String> node, ArrayList<String> list){
		
		if(node.hasChildren()) {
			for(int i = 0; i < node.getChildren().size(); i ++){
				list.add(node.getChildAt(i).element);
			}
			for(int j = 0; j < node.getChildren().size(); j++) {
				BFS(node.getChildAt(j), list);
			}
		}
		return list;
		
	}

}
