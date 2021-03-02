/*
 * @(#)ReverseFigureEnumerator.java 5.2
 *
 */

package CH.ifa.draw.standard;

import java.util.*;
import CH.ifa.draw.util.ReverseVectorEnumerator;
import CH.ifa.draw.framework.*;

/**
 * An Enumeration that enumerates a vector of figures back (size-1) to front (0).
 */
public final class ReverseFigureEnumerator implements FigureEnumeration {
    ReverseVectorEnumerator fEnumeration;

    public ReverseFigureEnumerator(Vector v) {
	    fEnumeration = new ReverseVectorEnumerator(v);
    }

    /**
     * Returns true if the enumeration contains more elements; false
     * if its empty.
     */
    public boolean hasNext() {
	    return fEnumeration.hasNext();
    }

    /**
     * Returns the next element of the enumeration. Calls to this
     * method will enumerate successive elements.
     * @exception NoSuchElementException If no more elements exist.
     */
    public Object next() {
        return fEnumeration.next();
    }

    /**
     * Returns the next element casted as a figure of the enumeration. Calls to this
     * method will enumerate successive elements.
     * @exception NoSuchElementException If no more elements exist.
     */
    public Figure nextFigure() {
        return (Figure)fEnumeration.next();
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
