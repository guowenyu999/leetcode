import java.util.Arrays;
import java.util.Scanner;

/*Assume you are an awesome parent and want to give your children some cookies. 
But, you should give each child at most one cookie. Each child i has a greed factor gi,
which is the minimum size of a cookie that the child will be content with;
and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, 
and the child i will be content. Your goal is to maximize the number of your
content children and output the maximum number.*/

public class AssignCookies {
	public static int findContentChildren(int[] g, int[] s){
		Arrays.sort(g);
		Arrays.sort(s);
		int j=0;
		int i=0;
		for (j = 0;i<g.length&&j < s.length;) {
			
			if (g[i]<=s[j]) {
				i++;
			}else {
				j++;
			}
		}
		return i;
	}
	public static int findContentChildren1(int[] g, int[] s){
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for(int j=0;i<g.length && j<s.length;j++) {
			if(g[i]<=s[j]) i++;
		}
		return i;
	}
public static void main(String[] args) {
	
	Scanner ss = new Scanner(System.in);
	int n = ss.nextInt();
	int[] g=new int[n];
	for (int i = 0; i < n; i++) {
		g[i]=ss.nextInt();
	}
	int m = ss.nextInt();
	int[] s=new int[m];
	for (int i = 0; i < m; i++) {
		s[i]=ss.nextInt();
	}
	System.out.println(findContentChildren1(g,s));
	
}
}
