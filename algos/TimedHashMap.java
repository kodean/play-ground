/*
 * Create a data structure to store values based on keys and timestamps. 
 * While retrieving data, for the given key, if the timestamp doesn't exist, return
 * value corresponding to latest timestamp that is less than queried timestamp.
 *
 * Example: 
 * 
 * Add 
 * k1, t1 -> v1
 * k1, t3 -> v3
 * k2, t3 -> v4
 * k1, t4 -> v5
 *
 * Retrieve
 * k1, t1 => v1
 * k1, t2 => v1
 *
 */

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;

class TimedHashMap {
	public static void main(String[] args) {
		TimedMap timedMap = new TimedMap();
		timedMap.put("k1",1,"v1");
		timedMap.put("k1",3,"v3");
		timedMap.put("k2",3,"v4");
		timedMap.put("k1",4,"v5");
    
		System.out.println("Added: (k1,1 : v1), (k1,3 : v3), (k2,3 : v4) and (k1,4 : v5)");
		System.out.println("Retrieving:");

		System.out.println("k1, 1: "+timedMap.get("k1",1));
		System.out.println("k1, 2: "+timedMap.get("k1",2));
		System.out.println("k1, 3: "+timedMap.get("k1",3));
		System.out.println("k1, 4: "+timedMap.get("k1",4));
		System.out.println("k2, 2: "+timedMap.get("k2",2));
  }
  
  // Uses Java's TreeMap, which is Balanced BST (red-black tree)
  public static class TimedMap {
	  private HashMap<String,TreeMap<Integer,String>> timedMap;
	  
	  public TimedMap() {
		  timedMap = new HashMap<String,TreeMap<Integer,String>>();
	  }
	  
	  public void put(String key, int timeStamp, String value) {
		  if (!timedMap.containsKey(key)) {
			  timedMap.put(key, new TreeMap<Integer,String>());
		  }
		  timedMap.get(key).put(timeStamp, value);
	  }
	  
	  public String get(String key, int timeStamp) {
		  Entry<Integer,String> result;
		  if (timedMap.containsKey(key) && (result = timedMap.get(key).floorEntry(timeStamp)) != null) {
			  return result.getValue();
		  } else {
			  return null;
		  }
	  }
  }
}
