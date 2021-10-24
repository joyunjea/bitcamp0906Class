public class Main {

	public static void main(String[] args) {
		// TODO -generated method stub
		ListChild listChild = new ListChild();
		
		
		if(listChild instanceof ListParent) {
			ListParent lp = listChild;
			lp.printAA();
		}
		
		AbstractParent abstractParent = new ListChildA();
		
		abstractParent.printAA();
		
	}

}
