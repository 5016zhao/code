package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import model.User;
/*
 * 管理和维护用户数据，包括注册登录修改密码，实现用户数据与文件之间的交互
*/
public class UserDao {

	UserFileDao userFileDao=new UserFileDao();
	ArrayList<User>users=new ArrayList<User>();
	//注册
	public String reg(User user) {

		if(checkEmpty(user)) {//判断用户名是是否为空
			return "用户名、电话、密码均不能为空";
		}
		if(check(user.getName())) {//判断用户名是否重复
			return "用户名重复";
		}
		int t=checkTel(user.getTel());
		if(t==1)return "该号码已注册过不能重复注册";
		if(t==2)return "号码格式错误";
		t=checkPass(user.getPassword());
		if(t==1)return "密码格式错误，需同时含有大小写字母和数字";
		addUser(user);
		userFileDao.weiterUsers(users);
		return "注册成功";
	}
	//登录
	public String signIn(String name,char[] pass) {
		users=userFileDao.getUser();
		for(User user:users) {
			char[] password=user.getPassword();
			if(user.getName().equals(name)&&password.length==pass.length) {			
				for(int i=0;i<password.length;i++) {
					if(password[i]!=pass[i])
						return "用户名或密码不正确";
				}
				return "登录成功";
			}
		}
		return "用户名或密码不正确";
	}
	//找回密码
	public String UserRetrieve(String name,char[] tel){
		users=userFileDao.getUser();
		if(name==null||name.isEmpty()||tel.length==0)return "用户名或电话不能为空";
		for(User user:users) {
			char[] ch=user.getTel();
			if(user.getName().equals(name)&&11==tel.length) {
				for(int i=0;i<11;i++) {
					if(ch[i]!=tel[i])
						return "用户名或电话不正确";
				}
				char[] s=user.getPassword();
                return new String(s);
			}
		}
		return "用户名或电话不正确";
	}
	public void addUser(User user) {//添加用户
		users.add(user);
		userFileDao.weiterUsers(users);
	}
	
	public boolean check(String s) {//判断重复
		users=userFileDao.getUser();
		for(User user:users) {
			if(user.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}
	//改密码
	public String changePassword(String name,String pass1,String pass2,String pass3) {
//		System.out.println(pass2);
		if(pass1.isEmpty()||pass2.isEmpty()||pass3.isEmpty())return "原密码或新密码不能为空";
		users=userFileDao.getUser();
		System.out.println(pass1);
		boolean ok=false;
		char[]pass22=pass2.toCharArray();
		for(int i=0;i<users.size();i++) {
			String pass=new String(users.get(i).getPassword());
			if(users.get(i).getName().equals(name)&&pass.equals(pass1)) {
				if(!pass2.equals(pass3)) {
					return "两次输入密码不同";
				}
				else if(checkPass(pass22)==1) {
					return "密码格式错误，需同时含有大小写字母和数字";
				}
				else {
					
					System.out.println(pass2+000);
					users.get(i).setPassword(pass22);
					userFileDao.weiterUsers(users);
					return "修改成功";
				}
				
			}
		}
		return "原密码错误";
		
	}
	//注销账号
	public String logoutUser(String name) {
		GoodsDao goodsDao=new GoodsDao();
		if(goodsDao.getMyShear(name).length!=0) {
			return "您还有分享的物品，请全部取消分享后再注销";
		}
		users=userFileDao.getUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getName().equals(name)) {
				users.remove(i);
				break;
			}
		}
		userFileDao.weiterUsers(users);
		return "注销完成";
	}
	//判断密码的合法性
	public int checkPass(char[] pass) {
		users=userFileDao.getUser();
		String s=new String(pass);
//		if(pass.length<6)return 1;
		String ss=new String(pass);
		if(!ss.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$")) {
			return 1;
		}
		return 0;
	}
	//判断电话的合法性
	public int checkTel(char[] tel) {//一个电话只能注册一次,且电话满足由11位数字组成
		users=userFileDao.getUser();
		String s=new String(tel);
		for(User user:users) {
			String st=new String(user.getTel());
			if(st.equals(s)) {
				return 1;
			}
		}
		if(tel.length!=11)return 2;
		String ss=new String(tel);
		if(!ss.matches("^([1-9][0-9]*)$")) {
			return 2;
		}
		return 0;
	}
	//判断是否为空
	public boolean checkEmpty(User user) {
        return user.getName() == null || user.getName().isEmpty()
                || user.getPassword() == null || user.getPassword().length == 0
                || user.getTel() == null || user.getName().isEmpty();
    }
}
