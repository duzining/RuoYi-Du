import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.sasl.AuthenticationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


public class Test {



    public static void main(String[] args) {

        Student student = new Student();
        student.setName("du");
        student.setName(" admin\",\"role\":\"admin");
        Map<String,Object> map = new HashMap<>();
        map.put("1",student);

        JsonStringEncoder encoder = JsonStringEncoder.getInstance();


        JSONObject object = JSONObject.fromObject(map);
        System.out.println(object.toString());

    }

    public static void t(BinarySearchTree b){
        String className = b.getClass().getName();
        if (b.getClass()==BinarySearchTree.class){
            System.out.println("yes");
        }
    }

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }
}


