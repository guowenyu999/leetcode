package filesort;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

 class MyFilenameFilter implements FilenameFilter {
	  
    /**
     * @param args
     *
     *            ʵ�ֹ���; ʵ��FilenameFilter�ӿ�,�����ָ�����ļ�ɸѡ��
     *
     */
  
      
    @Override
    //��дaccept����,����ָ���ļ��Ƿ�Ӧ�ð�����ĳһ�ļ��б���
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        // ��������ֵ
        boolean flag = true;
        // ����ɸѡ����
        //endWith(String str);�ж��Ƿ�����ָ����ʽ��β��
        if (name.toLowerCase().endsWith(".txt")) {
  
        } else {
            flag = false;
        }
        // ���ض���ķ���ֵ
          
        //������trueʱ,��ʾ������ļ���������
        return flag;
    }
  
}
public class FileSort {
public static void main(String[] args) {
	 File file = new File("D:\\guo\\file");
//	 File files[] = file.listFiles();
	 File files[] = file.listFiles(new MyFilenameFilter());
	 for (File f : files) {
         System.out.println(f.toString());
     }
	 
	 String filenames[] = file.list(new MyFilenameFilter());
	 for (String fn : filenames) {
         System.out.println(fn);
     }
	 Arrays.sort(filenames);
	 for (String fn : filenames) {
         System.out.println(fn);
     }
	 
}
}
