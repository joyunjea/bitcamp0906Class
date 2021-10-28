package chapter11;

public class Person implements Comparable<Person>{
	
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		if(this.age > o.age) {
			return 1;	//양수
		}else if(this.age < o.age) {
			return-1;
		}else {
		return this.name.compareTo(o.name);	//나이가같으면 이름순으로 정렬
		}
		//return -(this.age-o.age);
	}
	
	
	
	
}