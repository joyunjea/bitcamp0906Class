package main;

import java.beans.FeatureDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MainProcess {
	
	public static String upperCaseFirst(String val) {
	      char[] arr = val.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
	   }

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
		
		
		 Class AA = Class.forName("main.MemberVO");
		 Annotation[] aas = AA.getAnnotations();
		 for(Annotation aa : aas) {
			 System.out.println(aa.);
		 }
		 
		 
		 Field[] fields = AA.getDeclaredFields();
		 
		 
		 HashMap<String, String> maps = new HashMap<String, String>();
		 maps.put("name", "ejune");
		 maps.put("address", "seoul");
		 maps.put("nickName", "chi");
		 
		 
		 Object object = Class.forName("main.MemberVO").newInstance();
		 
		 for(Field field : fields) {
			 
			 Method method =  AA.getMethod("set"+  upperCaseFirst(field.getName()), String.class);
			 method.invoke(object, maps.get(field.getName()));
			 // rs.getName(field.getName())
			 		
		 }
		 /**
		  * field.getName()
		  * name,address,nickName
		  * 
		  *  Method method =  AA.getMethod("setName", String.class);
		  *  Method method =  AA.getMethod("setAddress", String.class);
		  *  Method method =  AA.getMethod("setNickName", String.class);
			
		  */
		 
		 System.out.println((MemberVO)object);
		 
		 
		



		 
		 /**
		 Method[] methods =  AA.getMethods();
		 
		 for(Method method : methods) {
			 System.out.println(method.getName());
		 }
		 **/
		 
		 
		
		/*
		 * MemberVO memberVO = new MemberVO(); memberVO.setAddress("aaaa");
		 * memberVO.setName("BBB"); memberVO.setNickName("BASDF");
		 * 
		 * 
		 * MemberVO memberVO2 = new MemberVO(); memberVO.setAddress("aaaa")
		 * .setName("BBB") .setNickName("BASDF");
		 */

	}

}
