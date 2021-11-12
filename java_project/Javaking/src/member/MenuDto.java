package member;

public class MenuDto {

	public int mid;
	public String mname;
	public int mprice;
	public int mtype;

	public MenuDto(int mid, String mname, int mprice, int mtype) {
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.mtype = mtype;
	}

	public MenuDto() {

	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
		this.mprice = mprice;
	}

	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	@Override
	public String toString() {
		return "==================================================" + "\n메뉴번호 = " + mid + "\n메뉴명 = " + mname + "\n금액 = "
				+ mprice;
	}

}
