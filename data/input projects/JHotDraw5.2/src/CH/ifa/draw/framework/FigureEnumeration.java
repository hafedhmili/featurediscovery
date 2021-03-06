/*
 * @(#)FigureEnumeration.java 5.2
 *
 */

package CH.ifa.draw.framework;

import java.util.*;

/**
 * Interface for Enumerations that access Figures.
 * It provides a method nextFigure, that hides the down casting
 * from client code.
 */
public interface FigureEnumeration extends Iterator {
    /**
     * Returns the next element of the enumeration. Calls to this
     * method will enumerate successive elements.
     * @exception NoSuchElementException If no more elements exist.
     */
    public Figure nextFigure();
}
