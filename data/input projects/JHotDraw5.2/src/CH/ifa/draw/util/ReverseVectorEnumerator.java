/*
 * @(#)ReverseVectorEnumerator.java 5.2
 *
 */

package CH.ifa.draw.util;

import java.util.*;

/**
 * An Enumeration that enumerates a vector back (size-1) to front (0).
 */
public class ReverseVectorEnumerator
implements Iterator {

    Vector vector;
    int count;

    public ReverseVectorEnumerator(Vector v) {
	    vector = v;
	    count = vector.size() - 1;
    }

    public boolean hasNext() {
	    return count >= 0;
    }

    public Object next() {
	    if (count >= 0) {
		    return vector.elementAt(count--);
	    }
	    throw new NoSuchElementException("ReverseVectorEnumerator");
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
