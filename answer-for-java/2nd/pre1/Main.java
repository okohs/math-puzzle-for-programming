public class Main {
    private static final int M = 10;
    private static final int N = 100;

    private static int[][] memo;

    public static void main(String[] args) {
        memo = new int[N+1][M+1];
        for(int i = 0;i<=N;i++){
            for(int j=0;j<=M;j++){
                memo[i][j] = -1;
            }
        }
        System.out.println(pattern(N, 2));
    }

    private static int pattern(int remain, int pre) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;

        if(memo[remain][pre] != -1){
            return memo[remain][pre];
        }

        int cnt = 0;
        for (int i = pre; i <= M; i++) {
            cnt += pattern(remain - i, i);
        }
        memo[remain][pre] = cnt;
        return cnt;
    }
}