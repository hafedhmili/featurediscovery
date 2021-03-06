/*FreeMind - A Program for creating and viewing Mindmaps
 *Copyright (C) 2000-2001  Joerg Mueller <joergmueller@bigfoot.com>
 *See COPYING for Details
 *
 *This program is free software; you can redistribute it and/or
 *modify it under the terms of the GNU General Public License
 *as published by the Free Software Foundation; either version 2
 *of the License, or (at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with this program; if not, write to the Free Software
 *Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
/*$Id: MapMouseMotionListener.java,v 1.7 2003/12/02 22:50:22 christianfoltin Exp $*/

package freemind.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPopupMenu;

import freemind.view.mindmapview.MapView;


/**
 * The MouseListener which belongs to MapView
 */
public class MapMouseMotionListener implements MouseMotionListener, MouseListener {

    private final Controller c;

    int originX = -1;
    int originY = -1;

    // |=   oldX >=0 iff we are in the drag

    public MapMouseMotionListener(Controller controller) {
       c = controller; }

    private void handlePopup( MouseEvent e) {
       if (e.isPopupTrigger()) {
           JPopupMenu popup = null;
           // detect collision with an element placed on the root pane of the window.
           java.lang.Object obj = c.getView().detectCollision(e.getPoint());
           if(obj != null) {
               // there is a collision with object obj.
               // call the modecontroller to give a popup menu for this object
               popup = c.getMode().getModeController().getPopupForModel(obj);
           } 
           if(popup == null) { // no context popup found:
               // normal popup:
               popup = c.getFrame().getFreeMindMenuBar().getMapsPopupMenu();
           }
           popup.show(e.getComponent(),e.getX(),e.getY()); 
       }
    }

    public void mouseMoved(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) {
       // Always try to get mouse to the original position in the Map.
       if (originX >=0) {
          ((MapView)e.getComponent()).scrollBy(originX - e.getX(), originY - e.getY());
       // } else { // do the init in the mouse press
       }
    } 

    public void mouseClicked(MouseEvent e) {
      c.getView().selectAsTheOnlyOneSelected(c.getView().getSelected()); // to loose the focus in edit
    }
    public void mouseEntered( MouseEvent e ) { }
    public void mouseExited( MouseEvent e ) { }
    public void mousePressed( MouseEvent e ) {
      if (e.isPopupTrigger()) { // start the move, when the user press the mouse (PN)
        handlePopup(e);
      }                         
      else if (!c.getMode().getModeController().isBlocked()
               && e.getButton() == MouseEvent.BUTTON1) {
        c.getView().setMoveCursor(true);
        originX = e.getX();
        originY = e.getY(); 
      }
      e.consume(); 
    }
    public void mouseReleased( MouseEvent e ) {
       originX = -1;
       originY = -1;
       handlePopup(e);
       e.consume(); 
       c.getView().setMoveCursor(false); // release the cursor to default (PN)
    }                                    
}
    
