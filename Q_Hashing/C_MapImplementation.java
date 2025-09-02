package Q_Hashing;

import java.util.*;

// implementing hashmap using linkedlist
// step1: the key is hashed to get the index
// step2: create a array of linkedlist
// step3: we should have a node class to store key and value
// step4: we should have a linkedlist to store the nodes
// step5: we will put the new node(key , value ) in the linkedlist at the corresponding index of array
// step6: operations are put, get, containsKey, remove, keySet, isEmpty, size, clear will go accordingly
// step7: we will rehash the array if linkedlist becomes bigger (it is verified by lambda = n/N)
public class C_MapImplementation {

    static class HashMap<K, V> {//
        // node class to store key and value
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // n is the total nodes( key value pairs + N empty nodes that we create
        // initially)
        private int n;// n
        private LinkedList<Node> buckets[];// N = buckets.length

        @SuppressWarnings("unchecked")
        HashMap() {
            this.n = 0;
            // this throws warning because there is no type safety
            // some one can do buckets[0] = new LinkedList<String>(); after it so it gives
            // warning
            // to suppress this warning we use @SuppressWarnings("unchecked")
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunc(K key) {
            // hashcode returns integer value after hashing the key
            // hashcode converts any datatype of to integer
            int hc = key.hashCode();
            // hashcode can be negative so we take absolute value
            int absHashCode = Math.abs(hc);
            int idx = absHashCode % buckets.length;
            return idx;
        }

        // instead of iterating over all the bucket and linkedlist
        // first get the index which hashfunc returns if the key is present in the
        // linkedlist
        // then search in that corresponding linkedlist
        // if found return the index of the node in the linkedlist
        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        // creating a new bucket of bigger size
        // iterating over all the elements in the old bucket and putting them in the new
        // bucket
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[oldBuck.length * 2];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    put(ll.get(j).key, ll.get(j).value);
                    ll.remove(j);
                }
            }
        }

        // check if the node is already present in the linkedlist
        // if it is present then update the value
        // else add the node in the linkedlist
        V put(K key, V value) {
            int bi = hashFunc(key);
            int idx = SearchInLL(key, bi);
            if (idx != -1) {
                Node node = buckets[bi].get(idx);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = n / buckets.length;
            if (lambda > 2) {
                rehash();
            }
            return null;
        }

        boolean containsKey(K key) {
            int bi = hashFunc(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                return true;
            }
            return false;
        }

        V remove(K key) {
            int bi = hashFunc(key);
            int idx = SearchInLL(key, bi);
            if (idx != -1) {
                Node node = buckets[bi].remove(idx);
                n--;
                return node.value;
            }
            return null;
        }

        V get(K key) {
            int bi = hashFunc(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                LinkedList<Node> ll = buckets[bi];
                return ll.get(di).value;
            }
            return null;
        }

        ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
        }

        boolean isEmpty() {
            return n == 0;
        }

        int size() {
            return n;
        }

        @SuppressWarnings("unchecked")
        void clear() {
            n = 0;
            buckets = new LinkedList[4];
            for (int i = 0; i < n; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // put method
        map.put("def", 20);
        map.put("abc", 10);
        map.put("ghi", 30);
        System.out.println(map.put("jkl", 40));// null
        // get method
        System.out.println(map.get("abc"));// 10
        System.out.println(map.get("xyz"));// null
        // containsKey method
        System.out.println(map.containsKey("abc"));// true
        System.out.println(map.containsKey("xyz"));// false
        // remove method
        System.out.println(map.remove("abc"));// 10
        System.out.println(map.remove("xyz"));// null
        // keySet method
        System.out.println(map.keySet());// [ghi,def,jkl]
        // size method
        System.out.println(map.size());// 3
        // clear method (clears the map)
        map.clear();
        System.out.println(map.size());// 0
    }
}
