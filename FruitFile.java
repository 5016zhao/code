package fruitwindow;

import java.io.*;
import java.util.HashMap;

public class FruitFile {
    String filename="剩余水果信息.txt";
    File f=new File(filename);
    FileWriter fileWriter;
    HashMap<String,Fruit>fruits;
    FileReader fileReader;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    public void WriterFile(String[][] strings){
        try {
            fileWriter=new FileWriter(f);
            bufferedWriter=new BufferedWriter(fileWriter);
            for(String[] strings1:strings){
                for(String string:strings1){
                    bufferedWriter.write(string);
                    bufferedWriter.write(',');
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (bufferedWriter != null)bufferedWriter.close();
                if(fileWriter!=null)fileWriter.close();
            }catch (IOException e) {
                    //throw new RuntimeException(e);
            }
        }
    }
    public HashMap<String,Fruit> ReaderFruit(){
        fruits=new HashMap<>();
        String[] strings=new String[4];
        String string= "";

        try {
            fileReader=new FileReader(filename);
            bufferedReader=new BufferedReader(fileReader);

            while((string=bufferedReader.readLine())!=null){
               int idx=0,t=-1,a=0;
               while((t=string.indexOf(',',a))!=-1){
                   strings[idx]=string.substring(a,t);
                   idx++;
                   a=t+1;
               }
               Fruit fruit=new Fruit(strings[0],strings[1],strings[2],strings[3]);
               fruits.put(strings[0],fruit);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(bufferedReader!=null)bufferedReader.close();
                if(fileReader!=null)fileReader.close();
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }
        }
        return fruits;
    }
}