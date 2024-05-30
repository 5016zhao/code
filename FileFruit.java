package FruitManagement;

import java.io.*;

public class FileFruit {
    static String filename="src\\FruitManagement\\水果剩余信息.txt";
    static File f=new File(filename);
    static FileReader fr=null;
    static FileWriter fw=null;
    static BufferedWriter bw=null;
    static BufferedReader br=null;
    //写文件
    public void WriterFruit(String[] s1,String[][] s2){
        try {
            fw=new FileWriter(f);//不追加每次都重写文件
            bw=new BufferedWriter(fw);
            for (String s : s1) {
                bw.write(s+",");
            }
            bw.newLine();
            for (String[] strings : s2) {
                for (String string : strings) {
                    bw.write(string + ",");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }
        }
    }
    public String[][] ReaderFruit(){
        String ss;
        int idx1=0,idx2=0;//idx1代表行idx2代表列
        StringBuilder str =new StringBuilder();
        try {
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            while((ss=br.readLine())!=null){//一行一行读取
                str.append(ss);
                idx1++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }
        }
        String[][] st=new String[idx1-1][4];
        idx1=0;
        int t=-1,a=0;
        while((t=str.indexOf(",",a))!=-1){
            String tmp=str.substring(a,t);
            if(idx1!=0)st[idx1-1][idx2]=tmp;
            idx2++;
            a=t+1;
            if(idx2==4){
                idx1++;
                idx2=0;
            }
        }
        return st;
    }
}
