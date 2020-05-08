import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.Iterator;

public class TestTwo {

    public static void main(String[] args) {

        if (StringUtils.isBlank(null)){
            System.out.println("aa");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("du1","zzz");
        jsonObject.put("du2","sss");
        jsonObject.put("du3","xxx");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("zi1","aaa");
        jsonObject1.put("zi2","a");
        jsonObject1.put("zi3","a");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("ni1","aaa");
        jsonObject2.put("ni2","a");
        jsonObject2.put("ni3","a");
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("a",jsonObject);
        jsonObject3.put("b",jsonObject1);
        jsonObject3.put("c",jsonObject2);
        System.out.println(jsonObject3);
        Iterator<String> it = jsonObject3.keys();
        while (it.hasNext()){
            String key = it.next();
            String value = jsonObject3.getString(key);
            JSONObject object = JSONObject.fromObject(value);
            System.out.println(key);
            System.out.println(value);
            System.out.println(object);
        }


    }
}
