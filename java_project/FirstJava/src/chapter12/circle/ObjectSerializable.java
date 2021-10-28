package chapter12.circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));
		out.writeObject(new String("문자열"));
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("one");
		arr.add("two");
		arr.add("three");
		
		out.writeObject(arr);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
		
		Circle c1 = (Circle)in.readObject();
		Circle c2 = (Circle)in.readObject();
		String str = (String)in.readObject();
		ArrayList<String> arr1 = (ArrayList)in.readObject();
		
		for(String s : arr1) {
			System.out.println(s);
		}
		in.close();
		
		c1.showCircleInfo();
		c1.showCircleInfo();
		System.out.println(str);
	}

}
