
import java.util.HashMap;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/


public class LRUCache {
    // we use linkedlist to store the sorted key list
    // least used key is put to the head
    KeyNode head, tail;
    // for a quick access the linkedlist
    HashMap<Integer, KeyNode> table;
    // we use hashmap to map key to value
    HashMap<Integer, Integer> cache;
    
    int size; 
    int capacity; 
    
    public LRUCache(int c) {
        size=0;
        head=null;
        tail=null;
        table=new HashMap<>();
        cache=new HashMap<>();
        capacity = c;
    }
    
    public int get(int key) {
        if (cache.containsKey(key))
        {
            accessKey(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key))
        {
            // update existing
            accessKey(key);
            cache.put(key, value);
        }
        // add a new one
        else 
        {
            // remove the existing key
            if (size>=capacity)
            {
                table.remove(head.val);
                cache.remove(head.val);
                if (head==tail)
                {
                	tail=null;
                }
                head=head.next;
                if (head!=null)
                {
                    head.prev=null;
                }
                size--;
            }
            size++;
            cache.put(key, value);
            // add the new key to the tail
            KeyNode node=new KeyNode(key);
            if (tail!=null)
            {
                tail.next=node;
            }
            node.prev=tail;
            tail=node;
            table.put(key, node);
            if (head==null)
            {
                head=tail;
            }
        }
    }
    
    // update the key list--the accessed key is put to the tail
    private void accessKey(int key)
    {
        KeyNode entry=table.get(key);
        if (entry !=null)
        {
            entry.prev.next = entry.next;
            entry.next.prev = entry.prev;
            
            if(entry == head)
        {
            head = entry.next;
        }
              
        if(entry == tail)
        {
            tail = entry.prev;
        }
        }
      
        
        
    }
}

class KeyNode
{
    KeyNode prev, next;
    int val;
    public KeyNode(int k)
    {
        val=k;
        prev=null;
        next=null;
    }
}
