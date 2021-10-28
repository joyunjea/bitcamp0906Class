package testInfterfaceorg;

public class AmaClerk implements Clerk {

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		System.out.println("PRINTALL++AMA");
	}

	@Override
	public int addChartVO(ChartVO chartVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyChartVO(int iIndex, ChartVO chartVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteChartVO(int iIndex) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int readBook() {
		return -1;
	}
	
	public int drinkCoffee() {
		return -1;
	}

}
