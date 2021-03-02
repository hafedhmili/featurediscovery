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
/*$Id: MindMapEdgeModel.java,v 1.9 2003/11/03 11:00:20 sviles Exp $*/

package freemind.modes.mindmapmode;

import freemind.main.FreeMindMain;
import freemind.modes.MindMapNode;
import freemind.modes.EdgeAdapter;
import freemind.main.Tools;
import java.awt.Color;

import freemind.main.XMLElement;

public class MindMapEdgeModel extends EdgeAdapter {

    public MindMapEdgeModel(MindMapNode node,FreeMindMain frame) {
	super(node,frame);
    }

    public XMLElement save() {
	if (style!=null || color!=null || width!=WIDTH_PARENT) {
	    XMLElement edge = new XMLElement();
	    edge.setName("edge");

	    if (style != null) {
		edge.setAttribute("style",style);
	    }
	    if (color != null) {
		edge.setAttribute("color",Tools.colorToXml(color));
	    }
	    if (width != WIDTH_PARENT) {
		    if (width == WIDTH_THIN)
				edge.setAttribute("width","thin");
			else
				edge.setAttribute("width",Integer.toString(width));
	    }
	    return edge;
	}
	return null;
    }

    public void setColor(Color color) {
	super.setColor(color);
    }

    public void setWidth(int width) {
	super.setWidth(width);
    }

    public void setStyle(String style) {
	super.setStyle(style);
    }
}
