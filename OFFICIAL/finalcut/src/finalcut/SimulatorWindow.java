package finalcut;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Simulator.Constant;
import Simulator.DrawSim;
import Simulator.Buildingframe;
import Simulator.Save;
import Simulator.liveupdate;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
/**
 * 
 * @author Sim Hong Xun
 *
 */
@SuppressWarnings("serial")
public class SimulatorWindow extends JFrame {
	private static final Constant constant = Constant.getInstance();

	private JPanel contentPane;
	int sscount;

	/**
	 * Create the frame.
	 */
	public SimulatorWindow() {
		setTitle("Bulim Industrial Simulator");
		setFont(new Font("Arial", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartUI.class.getResource("/misc/Icon.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 727);
		setMinimumSize(new Dimension(1280, 720));
		Toolkit t = Toolkit.getDefaultToolkit();
        int x = (int)((t.getScreenSize().getWidth() - getWidth()) / 2);
        int y = (int)((t.getScreenSize().getHeight() - getHeight()) / 2);
        setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//ADDING IN SIMULATOR THREAD
		JPanel panel = new JPanel();
		DrawSim Simu = new DrawSim();
		Simu.setPreferredSize(new Dimension(962, 650));
		Simu.start();
		
		//ADDING IN REAL TIME THREAD
		JPanel realtimepanel = new JPanel();
		liveupdate realtime = new liveupdate();
		realtime.setPreferredSize(new Dimension(276, 650));
		realtime.start();
		
		JButton btnPause = new JButton("Pause");
		
		
		JButton btnExit = new JButton("Exit");
		
		
		JButton btnScreenshot = new JButton("Screenshot");
		btnScreenshot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("src/Screen Capture");
				if (!file.exists()) {
					if (file.mkdir()) {
						System.out.println("Directory is created!");
					} else {
						System.out.println("Failed to create directory!");
					}
				}
				// capture the whole screen
				BufferedImage image;
				File file1 = new File("src/Screen Capture/screencapture" + sscount + ".jpg");
				try {
					image = new Robot().createScreenCapture( 
							new Rectangle( getX(), getY(), getWidth(), getHeight() ) );
					ImageIO.write(image, "jpg", file1);
				} catch (AWTException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sscount++;
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save frame = new Save();
				frame.setVisible(true);
				
			}
		});
		
		JLabel lblScale = new JLabel("Scale - 1 pixel : 2.31 metres");
		lblScale.setHorizontalAlignment(SwingConstants.CENTER);
		lblScale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JSlider simuspeedbar = new JSlider();
		simuspeedbar.setMinimum(1);
		simuspeedbar.setValue(2);
		simuspeedbar.setMaximum(4);
		
		
		
		JLabel lblSimulatorSpeed = new JLabel("Simulator Speed:");
		lblSimulatorSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblSimulatorSpeed, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(simuspeedbar, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblScale, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnScreenshot)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 962, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(realtimepanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
						.addComponent(realtimepanel, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPause)
							.addComponent(btnScreenshot))
						.addComponent(simuspeedbar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit)
								.addComponent(btnSave))
							.addComponent(lblSimulatorSpeed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblScale, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnf01 = new JButton("");
		btnf01.setContentAreaFilled(false);
		btnf01.setBorderPainted(false);
		btnf01.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf01.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf01.setHorizontalTextPosition(JButton.CENTER);
		btnf01.setVerticalTextPosition(JButton.CENTER);
		btnf01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(1, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf02 = new JButton("");
		btnf02.setContentAreaFilled(false);
		btnf02.setBorderPainted(false);
		btnf02.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf02.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(2, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf03 = new JButton("");
		btnf03.setContentAreaFilled(false);
		btnf03.setBorderPainted(false);
		btnf03.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf03.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(3, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf04 = new JButton("");
		btnf04.setContentAreaFilled(false);
		btnf04.setBorderPainted(false);
		btnf04.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf04.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(4, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf05 = new JButton("");
		btnf05.setContentAreaFilled(false);
		btnf05.setBorderPainted(false);
		btnf05.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf05.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(5, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf06 = new JButton("");
		btnf06.setContentAreaFilled(false);
		btnf06.setBorderPainted(false);
		btnf06.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf06.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(6, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf07 = new JButton("");
		btnf07.setContentAreaFilled(false);
		btnf07.setBorderPainted(false);
		btnf07.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf07.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(7, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf08 = new JButton("");
		btnf08.setContentAreaFilled(false);
		btnf08.setBorderPainted(false);
		btnf08.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf08.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(8, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf09 = new JButton("");
		btnf09.setContentAreaFilled(false);
		btnf09.setBorderPainted(false);
		btnf09.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf09.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(9, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf10 = new JButton("");
		btnf10.setContentAreaFilled(false);
		btnf10.setBorderPainted(false);
		btnf10.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf10.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(10, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf11 = new JButton("");
		btnf11.setContentAreaFilled(false);
		btnf11.setBorderPainted(false);
		btnf11.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf11.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(11, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf12 = new JButton("");
		btnf12.setContentAreaFilled(false);
		btnf12.setBorderPainted(false);
		btnf12.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf12.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(12, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf13 = new JButton("");
		btnf13.setContentAreaFilled(false);
		btnf13.setBorderPainted(false);
		btnf13.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf13.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(13, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf14 = new JButton("");
		btnf14.setContentAreaFilled(false);
		btnf14.setBorderPainted(false);
		btnf14.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf14.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(14, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf15 = new JButton("");
		btnf15.setContentAreaFilled(false);
		btnf15.setBorderPainted(false);
		btnf15.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf15.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(15, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf30 = new JButton("");
		btnf30.setContentAreaFilled(false);
		btnf30.setBorderPainted(false);
		btnf30.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf30.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(30, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf29 = new JButton("");
		btnf29.setContentAreaFilled(false);
		btnf29.setBorderPainted(false);
		btnf29.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf29.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(29, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf28 = new JButton("");
		btnf28.setContentAreaFilled(false);
		btnf28.setBorderPainted(false);
		btnf28.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf28.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(28, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf27 = new JButton("");
		btnf27.setContentAreaFilled(false);
		btnf27.setBorderPainted(false);
		btnf27.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf27.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(27, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf26 = new JButton("");
		btnf26.setContentAreaFilled(false);
		btnf26.setBorderPainted(false);
		btnf26.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf26.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(26, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf25 = new JButton("");
		btnf25.setContentAreaFilled(false);
		btnf25.setBorderPainted(false);
		btnf25.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf25.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(25, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf24 = new JButton("");
		btnf24.setContentAreaFilled(false);
		btnf24.setBorderPainted(false);
		btnf24.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf24.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(24, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf23 = new JButton("");
		btnf23.setContentAreaFilled(false);
		btnf23.setBorderPainted(false);
		btnf23.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf23.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(23, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf22 = new JButton("");
		btnf22.setContentAreaFilled(false);
		btnf22.setBorderPainted(false);
		btnf22.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf22.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(22, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf21 = new JButton("");
		btnf21.setContentAreaFilled(false);
		btnf21.setBorderPainted(false);
		btnf21.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf21.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(21, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf20 = new JButton("");
		btnf20.setContentAreaFilled(false);
		btnf20.setBorderPainted(false);
		btnf20.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf20.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(20, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf19 = new JButton("");
		btnf19.setContentAreaFilled(false);
		btnf19.setBorderPainted(false);
		btnf19.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf19.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(19, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf18 = new JButton("");
		btnf18.setContentAreaFilled(false);
		btnf18.setBorderPainted(false);
		btnf18.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf18.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(18, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf17 = new JButton("");
		btnf17.setContentAreaFilled(false);
		btnf17.setBorderPainted(false);
		btnf17.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf17.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(17, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnf16 = new JButton("");
		btnf16.setContentAreaFilled(false);
		btnf16.setBorderPainted(false);
		btnf16.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/fact.gif")));
		btnf16.setRolloverIcon(new ImageIcon("src/misc/factover.gif"));
		btnf16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(16, 'F');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JButton btnCDC = new JButton("");
		btnCDC.setContentAreaFilled(false);
		btnCDC.setBorderPainted(false);
		btnCDC.setIcon(new ImageIcon(SimulatorWindow.class.getResource("/misc/cdc.gif")));
		btnCDC.setRolloverIcon(new ImageIcon("src/misc/cdcover.gif"));
		btnCDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buildingframe frame = new Buildingframe(101, 'C');
				frame.start();
				frame.setVisible(true);
			}
		});
		
		JLabel label_1 = new JLabel("30");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_2 = new JLabel("29");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_3 = new JLabel("28");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_4 = new JLabel("27");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_5 = new JLabel("26");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_6 = new JLabel("25");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("24");
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_8 = new JLabel("23");
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_9 = new JLabel("22");
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_10 = new JLabel("21");
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_11 = new JLabel("20");
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_12 = new JLabel("19");
		label_12.setForeground(Color.WHITE);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_13 = new JLabel("18");
		label_13.setForeground(Color.WHITE);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_14 = new JLabel("17");
		label_14.setForeground(Color.WHITE);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_15 = new JLabel("16");
		label_15.setForeground(Color.WHITE);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		
		JLabel label_16 = new JLabel("2");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		
		JLabel label_17 = new JLabel("3");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		
		JLabel label_18 = new JLabel("4");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		
		JLabel label_19 = new JLabel("5");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		
		JLabel label_20 = new JLabel("6");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		
		JLabel label_21 = new JLabel("7");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		
		JLabel label_22 = new JLabel("8");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		
		JLabel label_23 = new JLabel("9");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		
		JLabel label_24 = new JLabel("10");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.WHITE);
		
		JLabel label_25 = new JLabel("11");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.WHITE);
		
		JLabel label_26 = new JLabel("12");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.WHITE);
		
		JLabel label_27 = new JLabel("13");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(Color.WHITE);
		
		JLabel label_28 = new JLabel("14");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setForeground(Color.WHITE);
		
		JLabel label_29 = new JLabel("15");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(Color.WHITE);
		
		JLabel lblCdc = new JLabel("CDC");
		lblCdc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCdc.setForeground(new Color(0, 0, 0));
		lblCdc.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		GroupLayout gl_Simu = new GroupLayout(Simu);
		gl_Simu.setHorizontalGroup(
			gl_Simu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Simu.createSequentialGroup()
					.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Simu.createSequentialGroup()
							.addGap(200)
							.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCDC, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Simu.createSequentialGroup()
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf30, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnf16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_Simu.createSequentialGroup()
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf01, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf02, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf03, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf04, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf05, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf06, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf07, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf08, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf09, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnf14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
										.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnf15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_Simu.createSequentialGroup()
							.addGap(288)
							.addComponent(lblCdc)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_Simu.setVerticalGroup(
			gl_Simu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Simu.createSequentialGroup()
					.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
						.addComponent(btnf03, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf04, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf05, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf06, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf07, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf08, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf09, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf01, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf02, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_16)
						.addComponent(label_17)
						.addComponent(label_18)
						.addComponent(label_19)
						.addComponent(label_20)
						.addComponent(label_21)
						.addComponent(label_22)
						.addComponent(label_23)
						.addComponent(label_24)
						.addComponent(label_25)
						.addGroup(gl_Simu.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_26)
							.addComponent(label_27)
							.addComponent(label_28))
						.addComponent(label_29))
					.addGap(63)
					.addGroup(gl_Simu.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(label_8)
						.addComponent(label_9)
						.addComponent(label_10)
						.addComponent(label_11)
						.addComponent(label_12)
						.addComponent(label_13)
						.addComponent(label_14)
						.addComponent(label_15))
					.addGap(5)
					.addGroup(gl_Simu.createParallelGroup(Alignment.LEADING)
						.addComponent(btnf26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf30, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnf16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(btnCDC)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCdc)
					.addGap(103))
		);
		Simu.setLayout(gl_Simu);
		panel.add(Simu);
		realtimepanel.setLayout(new GridLayout(0, 1, 0, 0));
		realtimepanel.add(realtime);
		contentPane.setLayout(gl_contentPane);
		
		simuspeedbar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int temp = simuspeedbar.getValue();
				if(temp == 1){
					temp = 200;
				}
				if(temp == 2){
					temp = 20;
				}
				if(temp == 3){
					temp = 1;
				}
				if(temp == 4){
					temp = 0;
				}
				constant.tsleep_ms = temp;
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (btnPause.getText() == "Pause"){
					btnPause.setText("Resume");
					
					//PROCEED TO PAUSE THE SIMULATOR
					Simu.suspend();
				}
				else{
					btnPause.setText("Pause");
					
					//PROCEED TO RESUME THE SIMULATOR
					Simu.resume();
					realtime.resume();
				}
				
			}
		});
		
		//EXIT BUTTON ACTION
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
					    null,
					    "Are you sure you want to quit the Simulation?",
					    "Wenya Industrial Simulator",
					    JOptionPane.YES_NO_OPTION);
				
				if(n == JOptionPane.YES_OPTION){
					
					File file = new File("src/Datafiles");
					if (!file.exists()) {
						if (file.mkdir()) {
							System.out.println("Directory is created!");
						} else {
							System.out.println("Failed to create directory!");
						}
					}
					
							
					
					//PROCEED TO SAVE ALL THE DATA INTO A NOTE FILE
					
					
					
					
					
					
					
					
					
					Simu.stop();
					realtime.stop();
					dispose();
					System.exit(1);
				}	
			}
		});
	}
}
