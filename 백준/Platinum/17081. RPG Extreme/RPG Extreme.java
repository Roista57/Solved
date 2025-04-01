import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static Monster[][] mapMonster;
	static ItemBox[][] mapItemBox;
	static char[] move;
	static int monsterCnt;
	static int boxCnt;
	static int[] startPoint;
	static Person person;
	static int[] di = { -1, 0, +1, 0 };
	static int[] dj = { 0, +1, 0, -1 };
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		mapMonster = new Monster[N][M];
		mapItemBox = new ItemBox[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '&') { // 몬스터
					monsterCnt++;
				}
				if (map[i][j] == 'B') { // 아이템 상자
					boxCnt++;
				}
				if (map[i][j] == '@') { // 주인공 시작 위치
					person = new Person(i, j);
					startPoint = new int[] { i, j };
					map[i][j] = '.';
				}
				if (map[i][j] == 'M') { // 보스 몬스터
					monsterCnt++;
				}
			}
		}
		move = br.readLine().toCharArray();

		for (int m = 0; m < monsterCnt; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			String name = st.nextToken();
			int atk = Integer.parseInt(st.nextToken());
			int def = Integer.parseInt(st.nextToken());
			int hp = Integer.parseInt(st.nextToken());
			int xp = Integer.parseInt(st.nextToken());
			boolean boss = false;
			if (map[i][j] == 'B')
				boss = true;
			mapMonster[i][j] = new Monster(i, j, name, hp, atk, def, xp, boss);
		}

		for (int b = 0; b < boxCnt; b++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			char T = st.nextToken().charAt(0);

			mapItemBox[i][j] = new ItemBox(i, j, T);

			if (T == 'W') {
				mapItemBox[i][j].atk = Integer.parseInt(st.nextToken());
			}
			if (T == 'A') {
				mapItemBox[i][j].def = Integer.parseInt(st.nextToken());
			}
			if (T == 'O') {
				String acc = st.nextToken();
				if (acc.equals("HR")) {
					mapItemBox[i][j].acc = 0;
				} else if (acc.equals("RE")) {
					mapItemBox[i][j].acc = 1;
				} else if (acc.equals("CO")) {
					mapItemBox[i][j].acc = 2;
				} else if (acc.equals("EX")) {
					mapItemBox[i][j].acc = 3;
				} else if (acc.equals("DX")) {
					mapItemBox[i][j].acc = 4;
				} else if (acc.equals("HU")) {
					mapItemBox[i][j].acc = 5;
				} else if (acc.equals("CU")) {
					mapItemBox[i][j].acc = 6;
				}
			}
		}

		// 게임 시작
		for (time = 0; time < move.length; time++) {
			int d = 0;
			if (move[time] == 'U') {
				d = 0;
			} else if (move[time] == 'R') {
				d = 1;
			} else if (move[time] == 'D') {
				d = 2;
			} else if (move[time] == 'L') {
				d = 3;
			}

			int ni = person.i + di[d];
			int nj = person.j + dj[d];

			if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != '#') {
				person.i = ni;
				person.j = nj;
			} else {
				ni = person.i;
				nj = person.j;
			}

			if (map[ni][nj] == 'B') {
				if (mapItemBox[ni][nj].T == 'W') {
					person.weapon = mapItemBox[ni][nj].atk;
				}
				if (mapItemBox[ni][nj].T == 'A') {
					person.armor = mapItemBox[ni][nj].def;
				}
				if (mapItemBox[ni][nj].T == 'O') {
					if (person.accCnt < 4 && person.acc[mapItemBox[ni][nj].acc] == 0) {
						person.acc[mapItemBox[ni][nj].acc] = 1;
						if (mapItemBox[ni][nj].acc == 5) {
							person.hunter = true;
						}
						person.accCnt++;
					}
				}
				map[ni][nj] = '.';
			} else if (map[ni][nj] == '^') {
				if (person.acc[4] == 1) {
					// Dexterity(DX) : 가시 함정에 입는 데미지가 1로 고정되며, Courage 장신구와 함께 착용할 경우
					// Courage의 공격력 효과가 두 배로 적용되는 대신 세 배로 적용된다.
					person.hp -= 1;
				} else {
					person.hp -= 5;
				}
				if (person.hp <= 0) {
					person.die();
				}
			} else if (map[ni][nj] == '&') {
				mapMonster[ni][nj].hp -= person.firstAttack();

				while (person.hp > 0 && mapMonster[ni][nj].hp > 0) {
					// 맞음
					person.hp -= Math.max(1, mapMonster[ni][nj].atk - (person.def + person.armor));
					if (person.hp <= 0) {
						break;
					}
					// 때림
					mapMonster[ni][nj].hp -= Math.max(1, (person.atk + person.weapon) - mapMonster[ni][nj].def);
					if (mapMonster[ni][nj].hp <= 0) {
						break;
					}
				}
				if (person.hp <= 0) {
					person.hp = 0;
					person.die();
				} else {
					person.win();
					map[ni][nj] = '.';
				}
			} else if (map[ni][nj] == 'M') {
				if (person.hunter) {
					person.hp = person.maxHp;
				}
				mapMonster[ni][nj].hp -= person.firstAttack();

				while (person.hp > 0 && mapMonster[ni][nj].hp > 0) {
					// 맞음
					if (person.hunter) {
						person.hunter = false;
					} else {
						person.hp -= Math.max(1, mapMonster[ni][nj].atk - (person.def + person.armor));
						if (person.hp <= 0) {
							break;
						}
					}

					// 때림
					mapMonster[ni][nj].hp -= Math.max(1, (person.atk + person.weapon) - mapMonster[ni][nj].def);
					if (mapMonster[ni][nj].hp <= 0) {
						break;
					}
				}
				if (person.hp <= 0) {
					person.hp = 0;
					person.die();
				} else {
					person.win();
					person.clear = true;
					person.end();
					break;
				}
			}
			if(person.dead) {
				person.end();
				break;
			}
		}
		if(!person.dead && !person.finish) {
			time--;
			person.end();
		}
	}

	static class Person {
		int i;
		int j;
		int hp;
		int maxHp;
		int atk;
		int def;
		int lvl;
		int xp;
		int weapon;
		int armor;
		int[] acc; // HR, RE, CO, EX, DX, HU, CU
		int accCnt;
		boolean hunter;
		boolean clear;
		boolean finish;
		boolean dead;

		public Person(int i, int j) {
			this.i = i;
			this.j = j;
			this.hp = 20;
			this.maxHp = 20;
			this.atk = 2;
			this.def = 2;
			this.lvl = 1;
			this.xp = 0;
			this.weapon = 0;
			this.armor = 0;
			this.acc = new int[7];
			this.hunter = false;
			this.accCnt = 0;
			this.clear = false;
			this.dead = false;
		}

		public void levelUpCheck() {
			if (lvl * 5 <= xp) {
				lvl++;
				maxHp += 5;
				atk += 2;
				def += 2;
				hp = maxHp;
				xp = 0;
			}
		}

		public int firstAttack() {
			// Courage(CO) : 모든 전투에서, 첫 번째 공격에서 주인공의 공격력(무기 합산)이 두 배로 적용된다.
			// 즉, 모든 첫 공격에서 몬스터에게 max(1, 공격력×2 – 몬스터의 방어력)만큼의 데미지를 입힌다.
			if (acc[2] == 1) {
				if (acc[4] == 1) {
					return Math.max(1, (atk + weapon) * 3 - mapMonster[i][j].def);
				}
				return Math.max(1, (atk + weapon) * 2 - mapMonster[i][j].def);
			}
			return Math.max(1, (atk + weapon) - mapMonster[i][j].def);
		}

		public void win() {
			if (acc[0] == 1) { // HP Regeneration(HR) : 전투에서 승리할 때마다 체력을 3 회복한다. 체력은 최대 체력 수치까지만 회복된다.
				hp += 3;
				if (hp > maxHp)
					hp = maxHp;
			}
			if (acc[3] == 1) {
				// Experience(EX) : 얻는 경험치가 1.2배가 된다. 소수점 아래는 버린다.
				xp += (int) (mapMonster[i][j].xp * 1.2);
			} else {
				xp += mapMonster[i][j].xp;
			}
			levelUpCheck();
		}

		public void die() {
			if (acc[1] == 1) {
				// Reincarnation(RE) : 주인공이 사망했을 때 소멸하며, 주인공을 최대 체력으로 부활시켜 준 뒤
				// 주인공을 첫 시작 위치로 돌려보낸다.
				// 레벨이나 장비 등의 다른 정보는 변함이 없다.
				// 전투 중이던 몬스터가 있다면 해당 몬스터의 체력도 최대치로 회복된다.
				// 소멸한 뒤에 다시 이 장신구를 얻는다면 또 착용한다.
				acc[1] = 0;
				hp = maxHp;
				if (mapMonster[i][j] != null) {
					mapMonster[i][j].rollback();
				}
				this.i = startPoint[0];
				this.j = startPoint[1];
				acc[1] = 0;
				accCnt--;
			} else {
				dead = true;
			}
		}

		public void end() {
			for (int q = 0; q < N; q++) {
				for (int w = 0; w < M; w++) {
					if (i == q && j == w && hp > 0)
						System.out.print("@");
					else
						System.out.print(map[q][w]);
				}
				System.out.println();
			}
			System.out.println("Passed Turns : " + (time + 1));
			System.out.println(person.toString());
			if (person.hp == 0) {
				if (map[i][j] == '^') {
					System.out.println("YOU HAVE BEEN KILLED BY SPIKE TRAP..");
				} else if (map[i][j] == '&') {
					System.out.println("YOU HAVE BEEN KILLED BY " + mapMonster[i][j].name + "..");
				} else if (map[i][j] == 'M') {
					System.out.println("YOU HAVE BEEN KILLED BY " + mapMonster[i][j].name + "..");
				} else {

				}
			} else {
				if (clear) {
					System.out.println("YOU WIN!");
				} else {
					System.out.println("Press any key to continue.");
				}
			}
			finish = true;
		}

		@Override
		public String toString() {
			return "LV : " + lvl + "\n" + "HP : " + hp + "/" + maxHp + "\n" + "ATT : " + atk + "+" + weapon + "\n"
					+ "DEF : " + def + "+" + armor + "\n" + "EXP : " + xp + "/" + (lvl * 5);
		}
	}

	static class Monster {
		int i;
		int j;
		String name;
		int hp;
		int maxHp;
		int atk;
		int def;
		int xp;
		boolean boss;

		public Monster(int i, int j, String name, int hp, int atk, int def, int xp, boolean boss) {
			this.i = i;
			this.j = j;
			this.name = name;
			this.maxHp = hp;
			this.hp = hp;
			this.atk = atk;
			this.def = def;
			this.xp = xp;
			this.boss = boss;
		}

		public void rollback() {
			this.hp = maxHp;
		}

		@Override
		public String toString() {
			return "[Monster] i: " + i + ", j: " + j + ", name: " + name;
		}
	}

	static class ItemBox {
		int i;
		int j;
		char T; // W, A, O
		int atk;
		int def;
		int acc; // HR, RE, CO, EX, DX, HU, CU

		public ItemBox(int i, int j, char t) {
			this.i = i;
			this.j = j;
			this.T = t;
		}
	}
}