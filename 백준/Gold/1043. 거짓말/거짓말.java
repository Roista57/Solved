import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Party[] party = new Party[M];

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        boolean[] iSeeYou = new boolean[N + 1];

        for (int i = 0; i < T; i++) {
            iSeeYou[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < M; i++) {
            party[i] = new Party(new ArrayList<>(), false);
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            for (int j = 0; j < C; j++) {
                party[i].users.add(Integer.parseInt(st.nextToken()));
            }
        }

        while (true) {
            int cnt = 0;
            for (int i = 0; i < party.length; i++) {
                if (!party[i].honest) {
                    boolean check = false;
                    for (int j = 0; j < iSeeYou.length; j++) {
                        if (iSeeYou[j] && !check) {
                            for (int k = 0; k < party[i].users.size(); k++) {
                                if (j == party[i].users.get(k)) {
                                    check = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (check) {
                        for (int k = 0; k < party[i].users.size(); k++) {
                            iSeeYou[party[i].users.get(k)] = true;
                        }
                        party[i].honest = true;
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < party.length; i++) {
            if (!party[i].honest) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    static class Party {
        ArrayList<Integer> users;
        boolean honest;

        public Party(ArrayList<Integer> users, boolean honest) {
            this.users = users;
            this.honest = honest;
        }
    }
}