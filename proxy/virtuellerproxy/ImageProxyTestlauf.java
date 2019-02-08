package headfirst.proxy.virtuellerproxy;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ImageProxyTestlauf {
	ImageComponent imageComponent;
	JFrame frame = new JFrame("CD-Cover-Viewer");
    JMenuBar menuBar;
    JMenu menu;
	Hashtable cds = new Hashtable();
 
	public static void main (String[] args) throws Exception {
		ImageProxyTestlauf testlauf = new ImageProxyTestlauf();
	}
 
	public ImageProxyTestlauf() throws Exception{
		cds.put("Ambient: Music for Airports","http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
        cds.put("Buddha Bar","http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        cds.put("Ima","http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        cds.put("Karma","http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        cds.put("MCMXC A.D.","http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        cds.put("Northern Exposure","http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2","http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
        cds.put("Queen: Greatest Hits II","http://images-eu.amazon.com/images/P/B000025XX0.03.LZZZZZZZ.jpg");
        cds.put("Moondog: The German Years","http://images-eu.amazon.com/images/P/B0002MRE00.03.LZZZZZZZ.jpg");
        
		URL initialURL = new URL((String)cds.get("Selected Ambient Works, Vol. 2"));
		menuBar = new JMenuBar();
		menu = new JMenu("Lieblings-CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

		for(Enumeration e = cds.keys(); e.hasMoreElements();) {
			String name = (String)e.nextElement();
        	JMenuItem menuItem = new JMenuItem(name);
        	menu.add(menuItem); 
        	menuItem.addActionListener(new ActionListener() {
          		  public void actionPerformed(ActionEvent event) {
           		     imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
           		     frame.repaint();
           	      }
        	});
		}
 		
		// Frame- und Men�-Erstellung
 
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);

	}

	URL getCDUrl(String name) {
		try {
			return new URL((String)cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
