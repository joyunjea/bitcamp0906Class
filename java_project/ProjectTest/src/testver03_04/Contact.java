package testver03_04;
//이름,전화,메일,주소,생일,그룹
public abstract class Contact implements ShowData {
  //변수 저장
  protected String name;
  protected  String phoneNumber;
  protected  String email;
  protected  String address;
  protected  String birthday;
  protected  String group;
  
  //생성자(모든 변수)
  public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.address = address;
      this.birthday = birthday;
      this.group = group;
  }
  //생성자(이름,전화,생일만)
  public Contact(String name, String phoneNumber, String birthday) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.birthday = birthday;
  }
  //기본생성자
  public Contact() {
      
  }
  //데이터 출력메소드
      public void showList() {
          System.out.println("이름 : " + name);
//        System.out.println("전화 : " + phoneNumber);
//        System.out.println("메일 : " + email);
//        System.out.println("주소 : " + address);
//        System.out.println("생일 : " + birthday);
//        System.out.println("그룹 : " + group);
      }

  //getset
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getPhoneNumber() {
      return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
  }
  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getAddress() {
      return address;
  }

  public void setAddress(String address) {
      this.address = address;
  }

  public String getBirthday() {
      return birthday;
  }

  public void setBirthday(String birthday) {
      this.birthday = birthday;
  }

  public String getGroup() {
      return group;
  }

  public void setGroup(String group) {
      this.group = group;
  }

  
  @Override
  public String toString() {
      return "이름= " + name + "\n전화= " + phoneNumber + "\n메일= " + email + "\n주소= " + address
              + "\n생일 = " + birthday + "\n그룹 = " + group;
  }
  
  // 정보를 출력하는 메소드
  // Contact 클래스는 ShowData 인터페이스를 구현하고 있기 때문에
  // 반드시 그 인터페이스의 메소드를 가지고 있어야함.
  // 다만 Contact 는 추상클래스로 만들었기 때문에 그 메소드를 "완성" 시키지 않아도 됨.
  public abstract void showData();
  

  
}