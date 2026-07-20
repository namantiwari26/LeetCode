class Pair {
    int row;
    int col;
    int tm;

    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int tm = 0;
        int cnt = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;
            int t = curr.tm;

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1) {

                    q.offer(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh)
            return -1;

        return tm;
    }
}