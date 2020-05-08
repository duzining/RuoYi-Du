import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestThree {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("du");
        list.add("boa");
        String[] s = new String[list.size()];
        s = list.toArray(s);
    }

}
