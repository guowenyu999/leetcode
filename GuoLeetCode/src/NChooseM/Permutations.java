package NChooseM;

public class Permutations {
	// 全排列的递归实现方式1（必须要求字符串中没有相同的字符）
	public static void permutation1(String str, String result, int len) {
		/*
		 * 全排列 递归实现 递归树： str: a b c ab ac ba bc ca cb result: abc acb bac bca
		 * cab cba
		 */

		// 结果 开始传入"" 空字符进入 len 是这个数的长度
		if (result.length() == len) { // 表示遍历完了一个全排列结果
			System.out.println(result);
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (result.indexOf(str.charAt(i)) < 0) { // 返回指定字符在此字符串中第一次出现处的索引。
					// System.out.println("字母："+str.charAt(i));
					permutation1(str, result + str.charAt(i), len);
				}
			}
		}
	}

	// 全排列的递归实现方式2（有重复出现的结果可能，如果字符串中有相同的字符）
	public static void permutation(String[] str, int first, int end) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			for (int j = 0; j <= end; j++) {
				System.out.print(str[j]);
			}
			System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);
			permutation(str, first + 1, end); // 固定好当前一位，继续排列后面的
			swap(str, i, first);
		}
	}
	// 全排列的递归实现方式3（去除重复的结果，如果字符串中有相同的字符）去掉重复的全排列的递归实现
	public static void permutation2(String[] str, int first, int end) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			for (int j = 0; j <= end; j++) {
				System.out.print(str[j]);
			}
			System.out.println();
		}

		for (int i = first; i <= end; i++) {
			if (IsSwap(str, first, i)) {
				swap(str, i, first);
				permutation2(str, first + 1, end); // 固定好当前一位，继续排列后面的
				swap(str, i, first);
			}

		}
	}

	private static boolean IsSwap(String[] str, int nBegin, int nEnd) {
		for (int i = nBegin; i < nEnd; i++)
			if (str[i] == str[nEnd])
				return false;
		return true;
	}

	private static void swap(String[] str, int i, int first) {
		String tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	public static void main(String args[]) throws Exception {
		// String s = "abc";
		// String result = "";
		// permutation1(s, result, s.length());

//		String[] str = { "a", "a", "c" };
//		permutation(str, 0, 2);// 输出str[0..2]的所有排列方式
		
		String[] str = { "a", "a", "c" };
		permutation2(str, 0, 2);// 输出str[0..2]的所有排列方式
	}
}
