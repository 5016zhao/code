package dao;
/*
 *       文件的读写
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.User;

public class UserFileDao {
	String fileName="data//UserText.dat";
	File file=new File(fileName);
	FileReader fileReader;
	FileWriter fileWriter;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	//读文件  读出用户名密码电话
	public ArrayList<User> getUser(){
		ArrayList<User>users=new ArrayList<User>();
		try {
			fileReader=new FileReader(file);
			bufferedReader=new BufferedReader(fileReader);
			String ss=null;
			try {
				//读出来3个名字，电话，密码
				while((ss=bufferedReader.readLine())!=null) {
					int t=-1,a=0,idx=0;
					String []st=new String[3];
					while((t=ss.indexOf(',',a))!=-1) {
						st[idx]=ss.substring(a,t);
//						System.out.println(st[idx++]);
						a=t+1;
						idx++;
					}
					User user=new User(st[0],st[1].toCharArray(),st[2].toCharArray());
					users.add(user);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bufferedReader!=null)bufferedReader.close();
				if(fileReader!=null)fileReader.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
		
		return users;
	}
	//需要写用户名，电话，密码
	public void weiterUsers(ArrayList<User> users) {//写文件
		try {
			fileWriter=new FileWriter(file);
			bufferedWriter=new BufferedWriter(fileWriter);
			for(User user:users) {
				String tel=new String(user.getTel());
				String pass=new String(user.getPassword());
				String str=user.getName()+','+pass+','+tel+',';
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
				//e.printStackTrace();
			}
		}
	}
	
}
