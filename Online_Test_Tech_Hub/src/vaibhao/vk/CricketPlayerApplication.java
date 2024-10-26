package vaibhao.vk;

import java.util.*;

class Player {
	private int id;
	private String name;
	private int runs;

	public Player(int id, String name, int runs) {
		this.id = id;
		this.name = name;
		this.runs = runs;
	}

	public String toString() {
		return "Id:" + id + ", Name:" + name + "Runs:" + runs;
	}
}

public class CricketPlayerApplication {

	public static void main(String[] args) {
		LinkedHashMap<String, LinkedHashMap<String, Player>> cricketData = new LinkedHashMap<>();

	
		LinkedHashMap<String, Player> indiaTeam = new LinkedHashMap<>();
		indiaTeam.put("1001", new Player(1, "Shyam", 10000));
		indiaTeam.put("1002", new Player(2, "Ram", 20000));


		LinkedHashMap<String, Player> ausTeam = new LinkedHashMap<>();
		ausTeam.put("A001", new Player(1, "Steve", 10000));
		ausTeam.put("A002", new Player(2, "David", 20000));

		cricketData.put("India", indiaTeam);
		cricketData.put("Aus", ausTeam);

		for (Map.Entry<String, LinkedHashMap<String, Player>> countryEntry : cricketData.entrySet()) {
			System.out.println("" + countryEntry.getKey());
			LinkedHashMap<String, Player> team = countryEntry.getValue();
			for (Map.Entry<String, Player> playerEntry : team.entrySet()) {
				System.out.println("" + playerEntry.getKey() + "\t" + playerEntry.getValue());
			}
			System.out.println();
		}
	}
}
