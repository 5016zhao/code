package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import model.User;
/*
 * �����ά���û����ݣ�����ע���¼�޸����룬ʵ���û��������ļ�֮��Ľ���
*/
public class UserDao {

	UserFileDao userFileDao=new UserFileDao();
	ArrayList<User>users=new ArrayList<User>();
	//ע��
	public String reg(User user) {

		if(checkEmpty(user)) {//�ж��û������Ƿ�Ϊ��
			return "�û������绰�����������Ϊ��";
		}
		if(check(user.getName())) {//�ж��û����Ƿ��ظ�
			return "�û����ظ�";
		}
		int t=checkTel(user.getTel());
		if(t==1)return "�ú�����ע��������ظ�ע��";
		if(t==2)return "�����ʽ����";
		t=checkPass(user.getPassword());
		if(t==1)return "�����ʽ������ͬʱ���д�Сд��ĸ������";
		addUser(user);
		userFileDao.weiterUsers(users);
		return "ע��ɹ�";
	}
	//��¼
	public String signIn(String name,char[] pass) {
		users=userFileDao.getUser();
		for(User user:users) {
			char[] password=user.getPassword();
			if(user.getName().equals(name)&&password.length==pass.length) {			
				for(int i=0;i<password.length;i++) {
					if(password[i]!=pass[i])
						return "�û��������벻��ȷ";
				}
				return "��¼�ɹ�";
			}
		}
		return "�û��������벻��ȷ";
	}
	//�һ�����
	public String UserRetrieve(String name,char[] tel){
		users=userFileDao.getUser();
		if(name==null||name.isEmpty()||tel.length==0)return "�û�����绰����Ϊ��";
		for(User user:users) {
			char[] ch=user.getTel();
			if(user.getName().equals(name)&&11==tel.length) {
				for(int i=0;i<11;i++) {
					if(ch[i]!=tel[i])
						return "�û�����绰����ȷ";
				}
				char[] s=user.getPassword();
                return new String(s);
			}
		}
		return "�û�����绰����ȷ";
	}
	public void addUser(User user) {//����û�
		users.add(user);
		userFileDao.weiterUsers(users);
	}
	
	public boolean check(String s) {//�ж��ظ�
		users=userFileDao.getUser();
		for(User user:users) {
			if(user.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}
	//������
	public String changePassword(String name,String pass1,String pass2,String pass3) {
//		System.out.println(pass2);
		if(pass1.isEmpty()||pass2.isEmpty()||pass3.isEmpty())return "ԭ����������벻��Ϊ��";
		users=userFileDao.getUser();
		System.out.println(pass1);
		boolean ok=false;
		char[]pass22=pass2.toCharArray();
		for(int i=0;i<users.size();i++) {
			String pass=new String(users.get(i).getPassword());
			if(users.get(i).getName().equals(name)&&pass.equals(pass1)) {
				if(!pass2.equals(pass3)) {
					return "�����������벻ͬ";
				}
				else if(checkPass(pass22)==1) {
					return "�����ʽ������ͬʱ���д�Сд��ĸ������";
				}
				else {
					
					System.out.println(pass2+000);
					users.get(i).setPassword(pass22);
					userFileDao.weiterUsers(users);
					return "�޸ĳɹ�";
				}
				
			}
		}
		return "ԭ�������";
		
	}
	//ע���˺�
	public String logoutUser(String name) {
		GoodsDao goodsDao=new GoodsDao();
		if(goodsDao.getMyShear(name).length!=0) {
			return "�����з������Ʒ����ȫ��ȡ���������ע��";
		}
		users=userFileDao.getUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getName().equals(name)) {
				users.remove(i);
				break;
			}
		}
		userFileDao.weiterUsers(users);
		return "ע�����";
	}
	//�ж�����ĺϷ���
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
	//�жϵ绰�ĺϷ���
	public int checkTel(char[] tel) {//һ���绰ֻ��ע��һ��,�ҵ绰������11λ�������
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
	//�ж��Ƿ�Ϊ��
	public boolean checkEmpty(User user) {
        return user.getName() == null || user.getName().isEmpty()
                || user.getPassword() == null || user.getPassword().length == 0
                || user.getTel() == null || user.getName().isEmpty();
    }
}
