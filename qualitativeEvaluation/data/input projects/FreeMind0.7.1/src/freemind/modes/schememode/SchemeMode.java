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
/*$Id: SchemeMode.java,v 1.8 2003/11/03 11:00:22 sviles Exp $*/

package freemind.modes.schememode;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import freemind.controller.Controller;
import freemind.main.FreeMindMain;
import freemind.modes.Mode;
import freemind.modes.ModeController;

public class SchemeMode implements Mode {

    private Controller c;
    private SchemeController modecontroller;
    private JToolBar toolbar;
    private static final String MODENAME = "Scheme";
    private static boolean isRunning = false;

    public SchemeMode() {
    }

    public void init(Controller c) {
	this.c = c;
	modecontroller = new SchemeController(this);
	toolbar = new SchemeToolBar(modecontroller);
    }

    public String toString() {
	return MODENAME;
    }

    /**
     * Called whenever this mode is chosen in the program.
     * (updates Actions etc.)
     */
    public void activate() {
	if (!isRunning) {
	    getModeController().newMap();
	    isRunning = true;
	} else {
            c.getMapModuleManager().changeToMapOfMode(this);
	}
    }

    public void restore(String restoreable) {
    }

    public Controller getController() {
	return c;
    }

    public ModeController getModeController() {
	return modecontroller;
    }

    public JMenu getModeFileMenu() {
	JMenu filemenu = new JMenu();
	filemenu.add(((SchemeController)getModeController()).newMap);
	filemenu.add(((SchemeController)getModeController()).open);
	filemenu.add(((SchemeController)getModeController()).save);
	filemenu.add(((SchemeController)getModeController()).saveAs);

	return filemenu;
    }

    public JMenu getModeEditMenu() {
	JMenu editmenu = new JMenu();
	JMenuItem editItem = editmenu.add(((SchemeController)getModeController()).edit);
 	editItem.setAccelerator(KeyStroke.getKeyStroke(getFrame().getProperty("keystroke_edit")));
 	JMenuItem addNewItem = editmenu.add(((SchemeController)getModeController()).addNew);
 	addNewItem.setAccelerator(KeyStroke.getKeyStroke(getFrame().getProperty("keystroke_add")));
 	JMenuItem removeItem = editmenu.add(((SchemeController)getModeController()).remove);
 	removeItem.setAccelerator(KeyStroke.getKeyStroke(getFrame().getProperty("keystroke_remove")));
	editmenu.add(((SchemeController)getModeController()).evaluate);
	editmenu.add(((SchemeController)getModeController()).toggleFolded);

	return editmenu;
    }

    public JToolBar getModeToolBar() {
	return toolbar;
    }

    public JToolBar getLeftToolBar() {
	return null;
    }

    public FreeMindMain getFrame() {
	return c.getFrame();
    }
}
