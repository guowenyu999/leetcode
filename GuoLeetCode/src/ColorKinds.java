import java.util.Scanner;


public class ColorKinds {
public static int arr[];  
public static int kinds=0;  
public static void main(String[] args) {
//	int n=3;
//	int m=2;
	Scanner sc=new Scanner(System.in); //实例化参数
	System.out.print("请输入数字n m :"); 
	int n = sc.nextInt(); 
	int m = sc.nextInt(); 
	System.out.println(n+" "+m);
	arr=new int [n];
	Color(0,m,0,n);
	System.out.println("kinds "+kinds);
}
public static void Color(int sum,int nsum,int count,int ncount){

	if(count>=ncount){
		if(sum==nsum){
			for(int i=0;i<ncount;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			kinds++;
		}
//		count=0;
		return;
	}
	
	for(int i=0;i<=4;i++){
		sum=sum+i;
		if(sum<=nsum){
			arr[count]=i;
			Color(sum,nsum,++count,ncount); 
			count--;
		}else {
			break;
		}
		arr[count]=0;
			sum=sum-i;
			
		
	}
}
}
