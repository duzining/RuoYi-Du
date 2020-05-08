import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShuJuJieGuo {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        map.put(3,11);
        map.put(1,12);
        map.put(5,23);
        map.put(2,22);

        for(Map.Entry e : map.entrySet()){
            System.out.println(e.getKey());
        }

        }
    }

