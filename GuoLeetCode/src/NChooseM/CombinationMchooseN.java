package NChooseM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//从n个数中选择m个数，无序
/*
 求(1...m)中,n个数的组合
本程序的思路是开一个数组，其下标表示1到m个数，数组元素的值为1表示其下标代表的数被选中，为0则没选中。     
   首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。     
   然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为“01”组合，
   同时将其左边的所有“1”全部移动到数组的最左端。     
   当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得到了最后一个组合。   
   
   例如求5中选3的组合：     
   1    1    1    0    0    //1,2,3  
   1    1    0    1    0    //1,2,4 
   1    0    1    1    0    //1,3,4 
   0    1    1    1    0    //2,3,4  
   1    1    0    0    1    //1,2,5    
   1    0    1    0    1    //1,3,5     
   0    1    1    0    1    //2,3,5    
   1    0    0    1    1    //1,4,5     
   0    1    0    1    1    //2,4,5     
   0    0    1    1    1    //3,4,5   
 */
public class CombinationMchooseN {
	 public static String combine(char[] dans, int m, int tel) throws Exception {

	        if (tel == 0)

	            return combine(dans, m);

	        int n = dans.length;

	        if (m - tel > n) {

	            throw new Exception("错误！数组a中只有" + n + "个元素。" + m + "大于" + n + "!!!");

	        }

	        StringBuffer result = new StringBuffer();

	        if (m < 2) {

	            for (int i = 0; i < dans.length; i++) {

	                result.append(dans[i]).append(" ");

	            }

	            return result.toString();

	        }

	        result.append(combine(dans, m - tel));

	        StringBuffer sb = new StringBuffer();

	        String[] rs = result.toString().split(" ");

	        for (int i = 0; i < rs.length; i++) {

	            String r = rs[i];

	            char[] cf = r.toCharArray();

	            char[] tmp = new char[cf.length + tel];

	            for (int j = 0; j < cf.length; j++) {

	                for (int k = 0; k < tel; k++) {

	                    tmp[k] = cf[(k + j) % cf.length];

	                }

	                for (int k = 0; k < cf.length; k ++) {

	                    tmp[tel + k] = cf[k];

	                }

	                Arrays.sort(tmp);

	                for (int k = 0; k < tmp.length; k++) {

	                    sb.append(tmp[k]);

	                }

	                sb.append(" ");

	            }

	        }

	        rs = sb.toString().split(" ");

	        Arrays.sort(rs);

	        sb = new StringBuffer();

	        for (int i = 0; i < rs.length; i++) {

	            sb.append(rs[i]).append(" ");

	        }

	        return sb.toString();

	    }

	    /**

	     * 从胆码数组中提取对应组合数组标识为1的有效数据

	     * @param bs 组合标识数组

	     * @param dans 胆码数组

	     * @param m

	     * @return

	     */

	    private static String extract(int[] bs, char[] dans, int m) {

	        StringBuffer sb = new StringBuffer();

	        int pos = 0;

	        for (int i = 0; i < bs.length; i++) {

	            if (bs[i] == 1) {

	                sb.append(dans[i]);

	                pos++;

	            }

	        }

	        return sb.toString();

	    }

	
	  public static String combine(char[] dans, int m) throws Exception {

	        int n = dans.length;

	        if (m > n) {

	            throw new Exception("错误！数组a中只有" + n + "个元素。" + m + "大于" + n + "!!!");

	        }

	        StringBuffer result = new StringBuffer();

	        if (m < 2) {

	            for (int i = 0; i < dans.length; i++) {

	                result.append(dans[i]).append(" ");

	            }

	            return result.toString();

	        }

	        List<String> rList = new ArrayList<String>();

	        int[] bs = new int[n];

	        // 初始化

	        for (int i = 0; i < m; i++) {

	            bs[i] = 1;

	        }

	        boolean flag = true;

	        boolean tempFlag = false;

	        int pos = 0;

	        int sum = 0;

	        // 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边

	        do {

	            sum = 0;

	            pos = 0;

	            tempFlag = true;

	            rList.add(extract(bs, dans, m));

	            for (int i = 0; i < n - 1; i++) {

	                if (bs[i] == 1 && bs[i + 1] == 0) {

	                    bs[i] = 0;

	                    bs[i + 1] = 1;

	                    pos = i;

	                    break;

	                }

	            }

	            // 将左边的1全部移动到数组的最左边

	            for (int i = 0; i < pos; i++) {

	                if (bs[i] == 1) {

	                    sum++;

	                }

	            }

	            for (int i = 0; i < pos; i++) {

	                if (i < sum) {

	                    bs[i] = 1;

	                } else {

	                    bs[i] = 0;

	                }

	            }

	            // 检查是否所有的1都移动到了最右边

	            for (int i = n - m; i < n; i++) {

	                if (bs[i] == 0) {

	                    tempFlag = false;

	                    break;

	                }

	            }

	            if (tempFlag == false) {

	                flag = true;

	            } else {

	                flag = false;

	            }

	        } while (flag);

	        rList.add(extract(bs, dans, m));

	        String[] rr = new String[rList.size()];

	        for (int i = 0; i < rList.size(); i++) {

	            rr[i] = rList.get(i);

	        }

	        Arrays.sort(rr);

	        for (int i = 0; i < rr.length; i++) {

	            result.append(rr[i]).append(" ");

	        }

	        return result.toString();

	    }
    public static void main(String[] args) {

        char[] dans = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        try {

            String hy5 = CombinationMchooseN.combine(dans, 5);

            System.out.println(hy5);

            System.out.println(hy5.split(" ").length);

        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }
}
