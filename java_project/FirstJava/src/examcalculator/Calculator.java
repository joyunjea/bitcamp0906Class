package examcalculator;
//아래 코드는 계산기 클래스를 정의할 때 가이드 역할을 하도록 정의해놓은 인터페이스입니다.
//interface Calulator { 
//    long add(long n1, long n2); 
//    long substract(long n1, long n2 ); 
//    long multiply(long n1, long n2 ); 
//    double divide(double n1, double n2 ); 
//}
//1.Calulator 인터페이스를 상속하는 추상 클래스를 정의해봅시다.
//2.Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다.
//3.다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해 봅시다.
public interface Calculator {
	
	long add(long n1, long n2); 
    long substract(long n1, long n2 ); 
    long multiply(long n1, long n2 ); 
    double divide(double n1, double n2 );
}
