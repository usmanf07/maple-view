/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tools;

import EditorMain.DrawArea;
import static EditorMain.EditorMain.count;
import static EditorMain.EditorMain.jTabbedPane1;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class Camera extends JFrame {
       
        public static Image img;
        
	private class SnapMeAction extends AbstractAction {

		public SnapMeAction() {
			super("Snapshot");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
				for (int i = 0; i < webcams.size(); i++) {
					Webcam webcam = webcams.get(i);
                                        img = webcam.getImage();
                                        break;
				}
                                for (WebcamPanel panel : panels) 
                                    panel.stop();
                                dispose();
                                JPanel panel = new JPanel();
                                panel.setLayout(new java.awt.GridBagLayout());
                                DrawArea drawArea = new DrawArea(120, 928) ;

                                Image temp = img;

                                drawArea.Drawer(temp);
                                panel.add(drawArea, new java.awt.GridBagConstraints());
                                JScrollPane j1=new JScrollPane(panel);
                                String name="Untitled " + count;
                                
                                jTabbedPane1.addTab(name,j1);
                                jTabbedPane1.setSelectedIndex(count - 1);
                                count++;
                                
		}
	}

	private class StartAction extends AbstractAction implements Runnable {

		public StartAction() {
			super("Start");
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			btStart.setEnabled(false);
			btSnapMe.setEnabled(true);

			// remember to start panel asynchronously - otherwise GUI will be
			// blocked while OS is opening webcam HW (will have to wait for
			// webcam to be ready) and this causes GUI to hang, stop responding
			// and repainting

			executor.execute(this);
		}

		@Override
		public void run() {

			btStop.setEnabled(true);

			for (WebcamPanel panel : panels) {
				panel.start();
			}
		}
	}

	private class StopAction extends AbstractAction {

		public StopAction() {
			super("Stop");
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			btStart.setEnabled(true);
			btSnapMe.setEnabled(false);
			btStop.setEnabled(false);

			for (WebcamPanel panel : panels) {
				panel.stop();
			}
                        
		}
	}

	private Executor executor = Executors.newSingleThreadExecutor();

	private Dimension size = WebcamResolution.QQVGA.getSize();

	private List<Webcam> webcams = Webcam.getWebcams();
	private List<WebcamPanel> panels = new ArrayList<WebcamPanel>();

	private JButton btSnapMe = new JButton(new SnapMeAction());
	private JButton btStart = new JButton(new StartAction());
	private JButton btStop = new JButton(new StopAction());

	public Camera() {

		super("MapleView Camera");
              
		for (Webcam webcam : webcams) {
			webcam.setViewSize(new Dimension(640, 480));
			WebcamPanel panel = new WebcamPanel(webcam, size, false);
			panel.setFPSDisplayed(true);
			panel.setFillArea(true);
			panels.add(panel);
		}

		// start application with disable snapshot button - we enable it when
		// webcam is started

		btSnapMe.setEnabled(false);
		btStop.setEnabled(false);

		setLayout(new FlowLayout());

		for (WebcamPanel panel : panels) {
			add(panel);
		}

		add(btSnapMe);
		add(btStart);
		add(btStop);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
