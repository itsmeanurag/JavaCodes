package sem3_codes;

import java.sql.Connection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1,"3");
        map.put("1","32");
        map.put(45,78.5);
        map.put(true,"d");
        map.put(56.7,"43");
        map.put(null,null);
        map.put(1,"3555");
        System.out.println(map);

        HashMap<String,Integer> kvmap = new HashMap<String,Integer>();
        kvmap.put("A",45);
        kvmap.put("A",452);
        kvmap.put("A",452);
        kvmap.put("A",45);
        kvmap.put("A",425);
        System.out.println(kvmap);
        System.out.println(kvmap.size());
        System.out.println(kvmap.containsValue(45));
        System.out.println(" ");

//        Set set = map.entrySet();
//        System.out.println(set);
//
//        Iterator lit = set.intertor();
//        while(lit.hasNext()){
//            Map.Entry me = (Map.Entry)lit.next();
//            System.out.println(me.getKey()+": "+me.getValue());
//        }
//
//        set<String> skey = kvmap.keySet();
//        System.out.println(skey);
//
//        Collection<Integer> vkey = kvmap.values();
//        System.out.println(vkey);

        HashMap<String,String> Smap = new HashMap<String,String>();

        Smap.put("23AI014","Anurag Tiwari");
        Smap.put("23AI013","Anurag Jaiswal");

        System.out.println(Smap);
        System.out.println(Smap.size());
        System.out.println(Smap.containsValue("Anurag Tiwari"));


    }
}
