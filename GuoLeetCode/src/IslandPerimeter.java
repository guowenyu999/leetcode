import java.util.Scanner;

public class IslandPerimeter {
	public static int islandPerimeter(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			int[] grid2 = grid[i];
			for (int j = 0; j < grid2.length; j++) {
				if (grid2[j] == 1) {
					sum += 4;
					if (j + 1 < grid2.length) {
						if (grid2[j + 1] == 1) {
							sum -= 2;
						}
					}
					if (i + 1 < grid.length) {
						if (grid[i + 1][j] == 1) {
							sum -= 2;
						}
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = s.nextInt();
			}
		}
		System.out.println(islandPerimeter(grid));
	}
}
