package examHashMap;
//1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 
//생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
//입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//3.TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
//같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FootballPlayer implements Comparable<FootballPlayer> {

	String name;
	int number;
	String team;
	int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return this.age % 10;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof FootballPlayer) {
			FootballPlayer player = (FootballPlayer) obj;
			if (this.team.equals(player.team) && this.name.equals(player.name) && this.age == player.age) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int compareTo(FootballPlayer o) {
		// 팀 이름순으로 정렬하고,
		// 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		int result = this.team.compareTo(o.team); // 음수 / 양수 / 0
		if (result == 0) {
			result = this.name.compareTo(o.name);
			if (result == 0) {
				result = this.number - o.number;
			}
		}

		return result;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

	public static void main(String[] args) {

		// 1.축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서
		// 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		// List<FootballPlayer> players = new ArrayList<>();

		// 데이터 저장
		// players.add(new FootballPlayer("Son1", 7, "Tot", 27));
		// players.add(new FootballPlayer("Park1", 7, "Man", 37));
		// players.add(new FootballPlayer("Son1", 9, "Tot", 27));
		// players.add(new FootballPlayer("Son2", 20, "Tot", 17));
		// players.add(new FootballPlayer("Park2", 20, "Man", 31));
		// players.add(new FootballPlayer("Park2", 21, "Man", 31));

		// 2.축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
		// 입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		Set<FootballPlayer> players = new HashSet<FootballPlayer>();

		// 데이터 저장
		players.add(new FootballPlayer("Son1", 7, "Tot", 27));
		players.add(new FootballPlayer("Park1", 7, "Man", 37));
		players.add(new FootballPlayer("Son1", 9, "Tot", 27));
		players.add(new FootballPlayer("Son2", 20, "Tot", 17));
		players.add(new FootballPlayer("Park2", 20, "Man", 31));
		players.add(new FootballPlayer("Park2", 21, "Man", 31));

		// 3. TreeSet<E>을 이용해서
		// 팀 이름순으로 정렬하고,
		// 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		//TreeSet<FootballPlayer> players = new TreeSet<>();

		// 데이터 저장
//		players.add(new FootballPlayer("Son1", 7, "Tot", 27));
//		players.add(new FootballPlayer("Park1", 7, "Man", 37));
//		players.add(new FootballPlayer("Son1", 9, "Tot", 27));
//		players.add(new FootballPlayer("Son2", 20, "Tot", 17));
//		players.add(new FootballPlayer("Park2", 20, "Man", 31));
//		players.add(new FootballPlayer("Park2", 21, "Man", 31));
		
		

		Iterator<FootballPlayer> itr = players.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("--------------------------------------------");
		
		
		Map<Integer, FootballPlayer> players2 = new HashMap<Integer, FootballPlayer>();
		
		players2.put(7, new FootballPlayer("Son", 7, "Tot", 27));
		players2.put(10, new FootballPlayer("Kane", 10, "Tot", 26));
		players2.put(20, new FootballPlayer("Kane2", 20, "Tot", 16));
		
		for(Integer i : players2.keySet()) {
			System.out.println(players2.get(i));
		}

	}
}