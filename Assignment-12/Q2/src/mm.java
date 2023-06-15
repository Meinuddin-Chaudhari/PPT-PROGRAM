import java.util.HashSet;
import java.util.List;
import java.util.Set;

class mm{
	public boolean hasLoop(List head) {
	    Set<List> hashSet = new HashSet<>();
	    while (head != null) {
	        if (hashSet.contains(head)) {
	            return true;
	        }
	        hashSet.add(head);
	        head = head.next;
	    }
	    return false;
	}	
}

