package chapter07;

public class HybridWaterCar {

}
//상속관계에서 상위 클래스에 생성자가 존재하면 생성자 호출 해주어야한다.
//상위 클래스의 변수를 초기화 해야하기 때문에 초기화할 값을 받아서 상위 클래스의 생성자를 호출!
class HybridCar extends Car{

	
		int electronicGauge;
		HybridCar(int gasolinegauge, int electronicGauge){
			super(gasolinegauge);
		}

	
}

class Car{
	int gasolinegauge;
	
	//Car 클래스의 변수를 초기화하는 생성자
	Car(int gasolinegauge){
		this.gasolinegauge = gasolinegauge;
	}
}