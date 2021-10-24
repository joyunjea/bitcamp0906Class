
public class ListStringName implements ListName {

	private String[] nameList;

	public ListStringName() {
	// TODO Auto-generanted constructor stub
		this.nameList = new String[10];
	}	
	
	@Override
	public int add(String name) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int delete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int index, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
