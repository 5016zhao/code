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
			goods.add(new Goods("28150001","图书","耐用品","正常","zzc","Java2实用教程（第5版）",""));
			goods.add(new Goods("31170002","玩具车","耐用品","正常","zzc","适合1-2岁儿童",""));
			goods.add(new Goods("10150003","积木","耐用品","正常","zzc","适合1-2岁儿童的积木",""));
			goods.add(new Goods("28150004","皮球","耐用品","正常","zzc","红色皮球，直径20cm左右",""));
			goods.add(new Goods("28150005","充电宝","耐用品","正常","zzc","小米充电宝10400mAh",""));
			goods.add(new Goods("28150006","梯子","耐用品","正常","zzc","高3米的可折叠梯子，承重100KG。",""));
			goods.add(new Goods("28150007","5号电池","耐用品","正常","zzc","南孚电池，2节。",""));
			goods.add(new Goods("28150107","口罩","耐用品","正常","zzc","一次性医用外科口罩",""));
			goodsFile.writerGoods(goods);
		}
	
	}
	//返回一个二维数组  将goods中的信息改成二维数组
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
	//获取我借的
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
	//取消分享
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
	
	//我分享的
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

	//借出
	public String Lending(Goods good){
		goods=goodsFile.readerGoods();
		if(good.getKind().equals("消耗品")){
			return "该物品是消耗品不能借";
		}
		if(good.getMode().equals("正常")){
			for (Goods value : goods) {
				if (good.getId().equals(value.getId())) {
					value.setMode("借出");
					value.setBorrower(good.getBorrower());
					break;
				}
			}
			goodsFile.writerGoods(goods);
			return "成功借出";

		}else return "该物品无法共享";

	}
	public void revert(String id){
		goods=goodsFile.readerGoods();
		for (Goods value : goods) {
			if (id.equals(value.getId())) {
				value.setMode("正常");
				value.setBorrower("");
				break;
			}
		}
		goodsFile.writerGoods(goods);
	}
	//添加
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
	//一个方法用来获得对于不同的要求返回不同的二维数组
	//t=1显示全部，t=2显示待审核，t=3显示审核通过,t=4显示审核失败的
	public String[][] managerGetText(int t) {
		String[][]str=getGoods();
		String[][] s = {{""},{""},{"待审核"},{"正常","借出","通过"},{"未通过"}};
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
	//更改状态  通过，未通过，
	public void audits(String str,String id) {
		goods=goodsFile.readerGoods();
		if(str.equals("通过")) {
			for(int i=0;i<goods.size();i++){
				if(goods.get(i).getId().equals(id)){
					goods.get(i).setMode("正常");
					goodsFile.writerGoods(goods);
					break;
				}
			}
		}
		else if(str.equals("待审核")) {
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
	goods.add(new Good("200328150001","图书",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"Java2实用教程（第5版）"));
	goods.add(new Good("200331170002","玩具车",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"适合1-2岁儿童"));
	goods.add(new Good("200410150003","积木",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"适合1-2岁儿童的积木"));
	goods.add(new Good("200328150004","皮球",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"红色皮球，直径20cm左右"));
	goods.add(new Good("200328150005","充电宝",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"小米充电宝10400mAh"));
	goods.add(new Good("200328150006","梯子",Good.TYPE_DURABLE,"zs",Good.STATUS_NORMAL,"高3米的可折叠梯子，承重100KG。"));
	goods.add(new Good("200528150007","5号电池",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"南孚电池，2节。"));
	goods.add(new Good("200528150107","口罩",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"一次性医用外科口罩"));
	goods.add(new Good("200528150206","84消毒液",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"500ml装，1瓶。"));
	goods.add(new Good("200528150305","酒精湿巾",Good.TYPE_CONSUM,"zs",Good.STATUS_NORMAL,"50片装，1袋。"));
*/