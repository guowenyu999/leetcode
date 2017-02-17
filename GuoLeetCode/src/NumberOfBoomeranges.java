import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomeranges {
	public static int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				int dis = getdistance(points[i], points[j]);
				if (map.containsKey(dis)) {
					map.put(dis, map.get(dis) + 1);
				} else {
					map.put(dis, 1);
				}

			}
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > 1) {
					sum += entry.getValue() * (entry.getValue() - 1);
				}
			}
			map.clear();
		}

		return sum;
	}

	public static int getdistance(int a[], int b[]) {
		int x = a[0] - b[0];
		int y = a[1] - b[1];
		int sum = x * x + y * y;
		return sum;
	}

	public static void main(String[] args) {
		int[][] num = new int[3][2];
		num[0][0] = 0;
		num[0][1] = 0;
		num[1][0] = 1;
		num[1][1] = 0;
		num[2][0] = 2;
		num[2][1] = 0;
		System.out.println(numberOfBoomerangs(num));
	}
}
