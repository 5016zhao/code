package dao;

import java.io.File;
import java.util.ArrayList;

import model.Goods;
import model.User;
/*
 * 
 */

public class GoodsDao {
	String fileName="data//GoodsText.txt";
	File file=new File(fileName);
	GoodsFile goodsFile=new GoodsFile();
	UserFileDao userFileDao=new UserFileDao();
	ArrayList<Goods>goods=new ArrayList<>();
	public GoodsDao() {

		if(!file.exists()){
			goods.add(new Goods("28150001","ͼ��","����Ʒ","����","zzc","Java2ʵ�ý̳̣���5�棩",""));
			goods.add(new Goods("31170002","��߳�","����Ʒ","����","zzc","�ʺ�1-2���ͯ",""));
			goods.add(new Goods("10150003","��ľ","����Ʒ","����","zzc","�ʺ�1-2���ͯ�Ļ�ľ",""));
			goods.add(new Goods("28150004","Ƥ��","����Ʒ","����","zzc","��ɫƤ��ֱ��20cm����",""));
			goods.add(new Goods("28150005","��籦","����Ʒ","����","zzc","С�׳�籦10400mAh",""));
			goods.add(new Goods("28150006","����","����Ʒ","����","zzc","��3�׵Ŀ��۵����ӣ�����100KG��",""));
			goods.add(new Goods("28150007","5�ŵ��","����Ʒ","����","zzc","���ڵ�أ�2�ڡ�",""));
			goods.add(new Goods("28150107","����","����Ʒ","����","zzc","һ����ҽ����ƿ���",""));
			goodsFile.writerGoods(goods);
		}
	
	}
	//����һ����ά����  ��goods�е���Ϣ�ĳɶ�ά����
	public String[][] getGoods(){
		goods=goodsFile.readerGoods();
		String[][] str=new String[goods.size()][7];
		int idx=0;
		for(Goods good:goods){
			str[idx][0]=good.getId();
			str[idx][1]=good.getName();
			str[idx][2]=good.getKind();
			str[idx][3]=good.getMode();
			str[idx][4]=good.getPublisher();
			str[idx][5]=good.getSynopsis();
			str[idx][6]=good.getBorrower();
			idx++;
		}
		return str;
	}
	//��ȡ�ҽ��
	public String[][] getMyGoods(String ss){
		goods=goodsFile.readerGoods();
		int idx=0;
		for(Goods good:goods){
			if(good.getBorrower().equals(ss)){
				idx++;
			}
		}
		System.out.println(idx);
		String[][] str=new String[idx][7];
		idx=0;
		for(Goods good:goods){
			if(good.getBorrower().equals(ss)){
				str[idx][0]=good.getId();
				str[idx][1]=good.getName();
				str[idx][2]=good.getKind();
				str[idx][3]=good.getMode();
				str[idx][4]=good.getPublisher();
				str[idx][5]=good.getSynopsis();
				str[idx][6]=good.getBorrower();
				idx++;
			}
		}
		return str;
	}
	//ȡ������
	public void abolishShear(String id) {
		goods=goodsFile.readerGoods();
		for(int i=0;i<goods.size();i++){
			if(goods.get(i).getId().equals(id)){
				goods.remove(i);
				goodsFile.writerGoods(goods);
				break;
			}
		}
	}
	
	//�ҷ����
	public String[][] getMyShear(String ss){
		goods=goodsFile.readerGoods();
		int idx=0;
		for(Goods good:goods){
			if(good.getPublisher().equals(ss)){
				idx++;
			}
		}
//		System.out.println(idx);
		String[][] str=new String[idx][7];
		idx=0;
		for(Goods good:goods){
			if(good.getPublisher().equals(ss)){
				str[idx][0]=good.getId();
				str[idx][1]=good.getName();
				str[idx][2]=good.getKind();
				str[idx][3]=good.getMode();
				str[idx][4]=good.getPublisher();
				str[idx][5]=good.getSynopsis();
				str[idx][6]=good.getBorrower();
				idx++;
			}
		}
		return str;
	}

	//���
	public String Lending(Goods good){
		goods=goodsFile.readerGoods();
		if(good.getKind().equals("����Ʒ")){
			return "����Ʒ������Ʒ���ܽ�";
		}
		if(good.getMode().equals("����")){
			for (Goods value : goods) {
				if (good.getId().equals(value.getId())) {
					value.setMode("���");
					value.setBorrower(good.getBorrower());
					break;
				}
			}
			goodsFile.writerGoods(goods);
			return "�ɹ����";

		}else return "����Ʒ�޷�����";

	}
	public void revert(String id){
		goods=goodsFile.readerGoods();
		for (Goods value : goods) {
			if (id.equals(value.getId())) {
				value.setMode("����");
				value.setBorrower("");
				break;
			}
		}
		goodsFile.writerGoods(goods);
	}
	//���
	public void addGood(Goods good){
		goods=goodsFile.readerGoods();
		goods.add(good);
		goodsFile.writerGoods(goods);
	}
	public boolean checkID(String id){
		goods=goodsFile.readerGoods();
		for(Goods goods1:goods){
			if(goods1.getId().equals(id))return false;
		}
		return true;
	}
	//һ������������ö��ڲ�ͬ��Ҫ�󷵻ز�ͬ�Ķ�ά����
	//t=1��ʾȫ����t=2��ʾ����ˣ�t=3��ʾ���ͨ��,t=4��ʾ���ʧ�ܵ�
	public String[][] managerGetText(int t) {
		String[][]str=getGoods();
		String[][] s = {{""},{""},{"�����"},{"����","���","ͨ��"},{"δͨ��"}};
		if(t==1)return str;
		else return checkText(str,s[t]);
	}
	public String[][] checkText(String[][] str,String[] s){
		int idx=0;
		
		for(String[] strings:str) {
			boolean  ok=false;
			for(String ss:s) {
                if (ss.equals(strings[3])) {
                    ok = true;
                    break;
                }
			}
			if(ok) {
				//st[idx]=strings;
				idx++;
			}
		}
		String[][] st=new String[idx][7];
		idx=0;
		for(String[] strings:str) {
			boolean ok=false;
			for(String ss:s) {
                if (ss.equals(strings[3])) {
                    ok = true;
                    break;
                }
			}
			if(ok) {
				st[idx]=strings;
				idx++;
			}
		}
		return st;
	}
	//����״̬  ͨ����δͨ����
	public void audits(String str,String id) {
		goods=goodsFile.readerGoods();
		if(str.equals("ͨ��")) {
			for(int i=0;i<goods.size();i++){
				if(goods.get(i).getId().equals(id)){
					goods.get(i).setMode("����");
					goodsFile.writerGoods(goods);
					break;
				}
			}
		}
		else if(str.equals("�����")) {
			for(int i=0;i<goods.size();i++){
				if(goods.get(i).getId().equals(id)){
					goods.get(i).setMode(str);
					goodsFile.writerGoods(goods);
					break;
				}
			}
		}
		else {
			for(int i=0;i<goods.size();i++){
				if(goods.get(i).getId().equals(id)){
					goods.get(i).setMode(str);
					goodsFile.writerGoods(goods);
					break;
				}
			}
		}
	}
}

/*
	goods.add(new Good("200328150001","ͼ��",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"Java2ʵ�ý̳̣���5�棩"));
	goods.add(new Good("200331170002","��߳�",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"�ʺ�1-2���ͯ"));
	goods.add(new Good("200410150003","��ľ",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"�ʺ�1-2���ͯ�Ļ�ľ"));
	goods.add(new Good("200328150004","Ƥ��",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"��ɫƤ��ֱ��20cm����"));
	goods.add(new Good("200328150005","��籦",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"С�׳�籦10400mAh"));
	goods.add(new Good("200328150006","����",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"��3�׵Ŀ��۵����ӣ�����100KG��"));
	goods.add(new Good("200528150007","5�ŵ��",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"���ڵ�أ�2�ڡ�"));
	goods.add(new Good("200528150107","����",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"һ����ҽ����ƿ���"));
	goods.add(new Good("200528150206","84����Һ",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"500mlװ��1ƿ��"));
	goods.add(new Good("200528150305","�ƾ�ʪ��",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"50Ƭװ��1����"));
*/