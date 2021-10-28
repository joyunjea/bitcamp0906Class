package testInfterfaceorg;

public interface Clerk {
	
	
	/**
	 * 가지고 있는 차트들을 모두 출력한다.
	 */
	public void printAll();
	
	/**
	 * 차트를 넣어준다.
	 */
	public int addChartVO(ChartVO chartVO);
	
	/**
	 * 차트를 수정한다.
	 */
	public int modifyChartVO(int iIndex, ChartVO chartVO);
	
	/**
	 * 차트를 삭제한다.
	 */
	public int deleteChartVO(int iIndex);

}
