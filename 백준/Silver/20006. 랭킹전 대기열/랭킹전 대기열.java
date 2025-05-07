import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Room[] rooms = new Room[P];
		for (int i = 0; i < P; i++) {
			rooms[i] = new Room(i, 0, 0);
		}
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int lv = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			for (int j = 0; j < P; j++) {
				if (rooms[j].total == 0) {
					rooms[j].LV = lv;
					rooms[j].total++;
					rooms[j].players.add(new Player(lv, name));
					break;
				} else if (rooms[j].total < M) {
					if (rooms[j].LV + 10 >= lv && rooms[j].LV - 10 <= lv) {
						rooms[j].total++;
						rooms[j].players.add(new Player(lv, name));
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < P; i++) {
			if (rooms[i].total != 0) {
				if (rooms[i].total == M) {
					sb.append("Started!\n");
					Collections.sort(rooms[i].players);
					for (Player player : rooms[i].players) {
						sb.append(player.lv + " " + player.name + "\n");
					}
				} else {
					sb.append("Waiting!\n");
					Collections.sort(rooms[i].players);
					for (Player player : rooms[i].players) {
						sb.append(player.lv + " " + player.name + "\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

	static class Room {
		int n;
		int LV;
		List<Player> players;
		int total;

		public Room(int n, int lV, int total) {
			this.n = n;
			this.LV = lV;
			this.players = new ArrayList<>();
			this.total = total;
		}
	}

	static class Player implements Comparable<Player> {
		int lv;
		String name;

		public Player(int lv, String name) {
			this.lv = lv;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return name.compareTo(o.name);
		}
	}

}