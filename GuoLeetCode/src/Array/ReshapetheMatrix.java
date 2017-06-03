package Array;

/**
 * Created by guowenyu on 2017/6/3.
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m =nums.length;
        int n =nums[0].length;
        if(m * n == r*c){
            int [][]temp=new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    int sum = i*c+j+1;
                    int x=sum/n;
                    int y=sum-x*n;
                    if(y==0){
                        temp[i][j]=nums[x-1][n-1];
                    }
                    else {
                        temp[i][j]=nums[x][y-1];
                    }
                }
            }

            return temp;
        }else {
            return nums;
        }
    }
    public static void main(String[] args) {
        int[][] a={{1,2},{3,4}};
        int result[][]=matrixReshape(a,1,4);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println();
            }

    }
}
