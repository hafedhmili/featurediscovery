/**
 * @(#)JAwtFrame.java
 *
 * JReversePro - Java Decompiler / Disassembler.
 * Copyright (C) 2000 2001 Karthik Kumar.
 * EMail: akkumar@users.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or modify
 * it , under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.If not, write to
 *  The Free Software Foundation, Inc.,
 *  59 Temple Place - Suite 330,
 *  Boston, MA 02111-1307, USA.
 **/
package jreversepro;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import jreversepro.awtui.JClassEditPanel;
import jreversepro.awtui.JCustomFileChooser;
import jreversepro.awtui.JDlgAbout;
import jreversepro.awtui.JDlgFont;
import jreversepro.awtui.JErrorDlg;
import jreversepro.awtui.MainMenu;
import jreversepro.common.AppConstants;
import jreversepro.common.KeyWords;
import jreversepro.parser.ClassParserException;
import jreversepro.reflect.JClassInfo;
import jreversepro.revengine.JSerializer;
import jreversepro.revengine.RevEngineException;



/**
 * Entry point class for AWT based UI for the decompiler.
 * @author  Karthik Kumar
 */
public class JAwtFrame
        extends Frame
        implements ActionListener , KeyWords ,
                WindowListener, AppConstants {
    /**
     * Represents the MenuBar.
     **/
    private MainMenu mMbrGen;

    /**
     * Panel containing the Reverse engineered code.
     **/
    private JClassEditPanel mPnlEditor;

    /**
     * ConstantPool Information of the class.
     **/
    private JSerializer mSerializer;

    /**
     * Path to class currently reverse engineered.
     **/
    private String mCurrentClass;

    /**
     * Name of the property file.
     **/
    private String mPropertyFile;

    /**
     * Default Directory of a file open/save dialog.
     **/
    private String mCurDir;

    /**
     * No-argument constructor.
     **/
    public JAwtFrame() {
        super(TITLE);

        mPropertyFile = System.getProperty("user.home")
                 + System.getProperty("file.separator") 
                 + PROP_FILE;

        mPnlEditor = new JClassEditPanel();
        mSerializer =  new JSerializer();

        setLayout(new GridLayout(1, 1));
        add(mPnlEditor);

        mMbrGen = new MainMenu(this);
        setMenuBar(mMbrGen);

        mCurDir = ".";

        mMbrGen.OnViewCPool.setEnabled(false);

        initAppState();
        addListeners();
    }

    /**
     * Driver method for GUI application.
     * @param aArgs This argument is insignificant.
     **/
    public static void main(String aArgs[]) {
        (new JAwtFrame()).setVisible(true);
    }

    /**
     * Method containing handlers for events generated by
     * MenuItems.
     * @param aEvent Event generated by GUI.
     **/
    public void actionPerformed(ActionEvent aEvent) {
        if (aEvent.getSource() == mMbrGen.OnFileOpen) {
            openFile();
        } else if (aEvent.getSource() == mMbrGen.OnFileSave) {
            saveFile(); 
        } else if (aEvent.getSource() == mMbrGen.OnFileExit) {
            appClose(); 
        } else if (aEvent.getSource() ==  mMbrGen.OnViewCPool) {
            viewPool();
        } else if (aEvent.getSource() == mMbrGen.OnOptFont) {
            showFontDialog();
        } else if (aEvent.getSource() == mMbrGen.OnHelpAbout) {
            showAbout();
        } else if (aEvent.getSource() == mMbrGen.OnEditCut) {
            cutText();
        } else if (aEvent.getSource() == mMbrGen.OnEditCopy) {
            copyText();
        }
    }

    /**
     * Method to open a file.
     **/
    public synchronized void openFile() {
        JCustomFileChooser chooser =
            new JCustomFileChooser(this,
                    "Open File",
                     ".class" ,
                    mCurDir,
                    FileDialog.LOAD);

        chooser.setVisible(true);

        String f =  chooser.getFile();
        if (f != null) {
            mCurDir = chooser.getDirectory();
            try {
                reverseEngineer(
                        new File(mCurDir + f));
            } catch (Exception _ex) {
                (new JErrorDlg(this, f.toString(), _ex)).setVisible(true);
            }
        }
    }

    /**
     * Method to reverse engineer a file.
     * @param aFile Class file to be reverse engineered.
     * @throws ClassParserException Thrown if class file not in proper format.
     * @throws IOException Thrown if error occured in reading class file.
     * @throws RevEngineException Thrown if error occured in reverse
     * engineering file.
     **/
    private synchronized void reverseEngineer(File aFile)
                        throws ClassParserException,
                                IOException,
                                RevEngineException {
      JClassInfo classInfo = mSerializer.loadClass(aFile);
      classInfo.reverseEngineer(
                       !mMbrGen.OnDisAssembler.getState());
      mPnlEditor.writeCode(
                 classInfo.getStringifiedClass(
                         !mMbrGen.OnDisAssembler.getState()));
      mMbrGen.OnViewCPool.setEnabled(true);
   }

    /**
     * Method invoked while saving to a file.
     **/
    public void saveFile() {
        JCustomFileChooser chooser =
            new JCustomFileChooser(this,
                    "Open File",
                     ".class",
                    mCurDir,
                    FileDialog.SAVE);
        chooser.setVisible(true);
        String f  = chooser.getFile();
        if (f != null) {
            mPnlEditor.writeToFile(this, new File(f));
        }
    }

    /**
     * Method invoked while closing a file.
     **/
    public void appClose() {
//        if ( ConfirmCloseDialog.confirmExit(this) ) {
            saveProperties();
            System.exit(0);
//        }
    }

    /**
     * Method invoked while text is cut.
     **/
    public void cutText() {
      //  System.out.println("Text Cut");
    }

    /**
     * Method invoked while text is copied.
     **/
    public void copyText() {
      //  System.out.println("Text Copied");
    }

    /**
     * Method invoked while ConstantPool is viewed.
     **/
    public void viewPool() {
        //Kept on hold for now .
    }


    /**
     * Method invoked while System Font is being viewed.
     **/
    public void showFontDialog() {
        JDlgFont dlg = new JDlgFont(this, "System Fonts");
        if (dlg.showFontDialog() == JDlgFont.SELECTED) {
            mPnlEditor.setEditorFont(dlg.getChosenFont());
        }
    }

    /**
     * Method invoked to show the About dialog box.
     **/
    public void showAbout() {
        JDlgAbout about = new JDlgAbout(this , "About");
    }

    /**
     * Method invoked to initialize the GUI parameters.
     **/
    private void initAppState() {
        //Set Default Theme.
        try {
            Properties pp = new Properties();
            FileInputStream fis = new FileInputStream(mPropertyFile);
            pp.load(fis);
            fis.close();
            int x = Integer.parseInt(pp.getProperty(XPOS));
            int y = Integer.parseInt(pp.getProperty(YPOS));
            int width = Integer.parseInt(pp.getProperty(XSIZE));
            int height = Integer.parseInt(pp.getProperty(YSIZE));

            mMbrGen.setFlag(pp.getProperty(DECOMPILE_FLAG));
            mPnlEditor.setEditorFont(
                        new Font(pp.getProperty(FONT),
                        Font.PLAIN,
                        JDlgFont.OPTIMUM_SIZE));

            setLocation(x, y);
            setSize(width, height);
        } catch (FileNotFoundException fnfe) {
            setLocation(0, 0);
            setSize(800, 550);
            mPnlEditor.setEditorFont(
                        new Font(mPnlEditor.DEFAULT_FONT,
                        Font.PLAIN,
                        JDlgFont.OPTIMUM_SIZE));
            System.err.println("Failed to load property file");
        } catch (IOException ioe) {
            System.err.println("Exception while closing a property file ");
        }
    }


    /**
     * Method to add property listeners to MenuItems and the MainFrame.
     **/
    private void addListeners() {
        mMbrGen.OnFileOpen.addActionListener(this);
        mMbrGen.OnFileSave.addActionListener(this);
        mMbrGen.OnFileExit.addActionListener(this);

        mMbrGen.OnEditCut.addActionListener(this);
        mMbrGen.OnEditCopy.addActionListener(this);
        mMbrGen.OnViewCPool.addActionListener(this);
        mMbrGen.OnOptFont.addActionListener(this);

        mMbrGen.OnHelpAbout.addActionListener(this);
        addWindowListener(this);
    }

    /**
     * Formats the title from the string Rhs and sets the title of the Frame.
     * @param aFileName Full Path name to the class being reverse engineered.
     *
     **/
    private void formatTitle(String aFileName) {
        int dotIndex = aFileName.indexOf(".");
        if (dotIndex != -1) {
            String className = aFileName.substring(0, dotIndex);
            setTitle(TITLE + " - " + className);
        }
    }


    /**
     * Save the state of the GUI as a properties file.
     *
     **/
    private void saveProperties() {
        try {
            Properties pp = new Properties();
            pp.setProperty(DECOMPILE_FLAG,
                String.valueOf(!mMbrGen.OnDisAssembler.getState()));
            pp.setProperty(XPOS,
                new Integer(getLocation().x).toString());
            pp.setProperty(YPOS,
                new Integer(getLocation().y).toString());
            pp.setProperty(XSIZE,
                new Integer(getSize().width).toString());
            pp.setProperty(YSIZE,
                new Integer(getSize().height).toString());
            pp.setProperty(FONT,
                mPnlEditor.getEditorFont().getFamily());

            FileOutputStream fos = new FileOutputStream(mPropertyFile);
            pp.store(fos, PROP_HEADING);
            fos.close();
        } catch (Exception _ex) {
            System.err.println("Failed to write Properties" + mPropertyFile);
            System.err.println(_ex);
        }
    }


    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowClosing(WindowEvent aEvent) {
        appClose();
    }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowClosed(WindowEvent aEvent) { }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowActivated(WindowEvent aEvent) { }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowDeactivated(WindowEvent aEvent) { }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowIconified(WindowEvent aEvent) { }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowDeiconified(WindowEvent aEvent) { }

    /**
     * WindowClosing event handler.
     * @param aEvent Event generated.
     **/
    public void windowOpened(WindowEvent aEvent) { }
}
