package NChooseM;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//从n个数中选择m个数，有序
public class CombinationMchooseN1 {
	 private int all;  
	    public CombinationMchooseN1()  
	    {  
	        this.all=0;  
	    }  
	    public int getAll() {  
	        return all;  
	    }  
	    public void setAll(int all) {  
	        this.all = all;  
	    }  
	    public static void main(String[] args) {  
	        String[] n ={"1","2","3","4"};  
	        CombinationMchooseN1 m=new CombinationMchooseN1();  
	        List lst = Arrays.asList(n);  
	        m.take("",2,lst);  
	        System.out.println(m.getAll());  
	    }  
	  
	    public  void take(String s, int total, List lst) {  
	        for (int i = 0; i < lst.size(); i++) {  
	            //System.out.println("i="+i);  
	            List templst=new LinkedList(lst);  
	            String n =  (String) templst.remove(i);// 取出来的数字  
	            String str = s + n;  
	            if (total == 1) {  
	                System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可  
	                //total=all;  
	                all++;  
	              
	            } else {  
	                int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上  
	                take(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合  
	            }  
	        }  
	          
	    }  
}
