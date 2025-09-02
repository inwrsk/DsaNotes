package Q_Hashing;

import java.util.HashMap;
import java.util.Set;

public class B_IterateOnMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("tata", 5);
        map.put("suzuki", 1);
        map.put("honda", 3);
        map.put("bmw", 5);
        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println("key: " + k + ", value: " + map.get(k));
            // key: honda, value: 3
            // key: tata, value: 5
            // key: suzuki, value: 1
            // key: bmw, value: 5
        }

    }
}
