package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Goods;

public class GoodsFile {
	String fileName="data//GoodsText.txt";
	File file=new File(fileName);
	FileReader fileReader;
	FileWriter fileWriter;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public ArrayList<Goods> readerGoods(){
		ArrayList<Goods> goods=new ArrayList<Goods>();
		try {
			fileReader=new FileReader(file);
			bufferedReader=new BufferedReader(fileReader);
			String ss;
			while((ss=bufferedReader.readLine())!=null) {
				int t=-1,a=0,idx=0;
				String[] s=new String[7];
				while((t=ss.indexOf(',', a))!=-1) {
					s[idx++]=ss.substring(a,t);
					a=t+1;
				}
				Goods good=new Goods(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
				goods.add(good);
			}
		} catch (IOException e)  {
			e.printStackTrace();
		}finally {
			try {
				if(bufferedReader!=null)bufferedReader.close();
				if(fileReader!=null)fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		return goods;
	}
	
	public void writerGoods(ArrayList<Goods> goods) {
		try {
			fileWriter=new FileWriter(file);
			bufferedWriter=new BufferedWriter(fileWriter);
			for(Goods good:goods) {
				String str=good.getId()+','+good.getName()+','
						+good.getKind()+','+good.getMode()+','+good.getPublisher()
						+','+good.getSynopsis()+','+good.getBorrower()+',';
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufferedWriter!=null)bufferedWriter.close();
				if(fileWriter!=null)fileWriter.close();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}
	
}
