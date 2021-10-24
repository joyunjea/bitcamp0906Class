package chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//데이터저장 : put(e)
		map.put(new Integer(1), "손흥민");
		map.put(3, "이강인");
		map.put(4, "황희찬");
		
		//데이터참조 : get(key)
		System.out.println(map.get(1));
		System.out.println(map.get(new Integer(4)));
		System.out.println(map.get(3));
		
		//데이터삭제 : remove(key)
		map.remove(3);
		System.out.println("key 3 을 삭제----------------");
		System.out.println(map.get(3));
		
		map.put(5, "박지성");
		//데이터 일괄 처리
//		Set<Integer> set = map.keySet();		
//		Iterator<Integer> itr = set.iterator();
		
		Iterator<Integer> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));
		}
		System.out.println("-----------------");
		
		for(Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println("("+e.getKey()+" , "+e.getValue()+")");
		}
	}

}
