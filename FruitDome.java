package fruitwindow;

import java.util.HashMap;
import java.util.Set;

public class FruitDome {
    FruitFile fruitFile=new FruitFile();
    Fruit fruit=new Fruit();
    static HashMap<String,Fruit>fruits=new HashMap<>();//�������ˮ��
    public FruitDome() {
        fruits=fruitFile.ReaderFruit();
    }
    public static String[][] GetFruits(){
        Fruit fruit1;
        String[][] str=new String[fruits.size()][4];
        Set<String>Keys=fruits.keySet();
        int idx=0;
        for(String key:Keys){
            fruit1=fruits.get(key);
            str[idx][0]=fruit1.id;
            str[idx][1]=fruit1.name;
            str[idx][2]=fruit1.price;
            str[idx][3]=fruit1.unit;
            idx++;
        }
        return str;
    }
    public void AddFrulit(Fruit fruit){//���
        fruits.put(fruit.id,fruit);
    }
    public void AmendFrulit(Fruit fruit){//�޸�
        fruits.put(fruit.id,fruit);
    }
    public void EraseFrulit(String id){//ɾ��
        fruits.remove(id);
    }
    public boolean check(String id){//����
        return fruits.containsKey(id);
    }
    public Fruit getfruit(String id){
        return fruits.get(id);
    }
}