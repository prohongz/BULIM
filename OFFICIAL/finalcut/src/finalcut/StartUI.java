package finalcut;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.util.Hashtable;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSlider;

import Simulator.Constant;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Sim Hong Xun
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" , "serial"})
public class StartUI extends JFrame{
	private static final Constant constant = Constant.getInstance();

	private JPanel contentPane;
	
	int cdctotal = 0;
	int facttotal = 0;
	int cdccargode;
	int factcargode;


	
	

	/**
	 * Create the frame.
	 */
	
	public StartUI() {
		setTitle("Bulim Industrial Simulator");
		setFont(new Font("Arial", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartUI.class.getResource("/misc/Icon.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setMinimumSize(new Dimension(640, 480));
		Toolkit t = Toolkit.getDefaultToolkit();
        int x = (int)((t.getScreenSize().getWidth() - getWidth()) / 2);
        int y = (int)((t.getScreenSize().getHeight() - getHeight()) / 2);
        setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", tabbedPane.getFont().getStyle(), tabbedPane.getFont().getSize()));
		
		//RUN BUTTON;
		JButton btnRun = new JButton("Run");
		
		
		//RESET BUTTON
		JButton btnReset = new JButton("Reset");
		
		
		JLabel lblDevelopedByNanyang = new JLabel("<html>\u00A9 2015 Nanyang Technological University<br>By School of Electrical And Electronic Engineering<html>");
		lblDevelopedByNanyang.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton btnExit = new JButton("Exit");
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblDevelopedByNanyang, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 401, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDevelopedByNanyang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRun, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnExit))
					.addContainerGap())
		);
		
		JPanel Preferences = new JPanel();
		tabbedPane.addTab("Preferences", null, Preferences, null );
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		GroupLayout gl_Preferences = new GroupLayout(Preferences);
		gl_Preferences.setHorizontalGroup(
			gl_Preferences.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Preferences.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Preferences.setVerticalGroup(
			gl_Preferences.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Preferences.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_2, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel General = new JPanel();
		tabbedPane_2.addTab("General", null, General, null);
		
		JPanel timepanel = new JPanel();
		
		JPanel costpanel = new JPanel();
		GroupLayout gl_General = new GroupLayout(General);
		gl_General.setHorizontalGroup(
			gl_General.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_General.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_General.createParallelGroup(Alignment.LEADING)
						.addComponent(costpanel, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
						.addComponent(timepanel, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_General.setVerticalGroup(
			gl_General.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_General.createSequentialGroup()
					.addContainerGap()
					.addComponent(timepanel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(costpanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Time");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        timepanel.setBorder(titledBorder);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Cost");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        costpanel.setBorder(titledBorder1);
        
        JLabel lblFuel = new JLabel("Fuel:");
        
        JTextField fuelcost = new JTextField();
        fuelcost.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		char c = arg0.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) || c=='.')){
        			arg0.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for Fuel Cost.");  
        		}
        	}
        });
        fuelcost.setText("1.300");
        fuelcost.setColumns(10);
        
        JLabel label_5 = new JLabel("$");
        
        JLabel lblPerLitres = new JLabel("per litres");
        GroupLayout gl_costpanel = new GroupLayout(costpanel);
        gl_costpanel.setHorizontalGroup(
        	gl_costpanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_costpanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblFuel)
        			.addGap(51)
        			.addComponent(label_5)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(fuelcost, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblPerLitres)
        			.addContainerGap(290, Short.MAX_VALUE))
        );
        gl_costpanel.setVerticalGroup(
        	gl_costpanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_costpanel.createSequentialGroup()
        			.addGroup(gl_costpanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblFuel)
        				.addComponent(fuelcost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label_5)
        				.addComponent(lblPerLitres))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        costpanel.setLayout(gl_costpanel);
        
        
        JLabel lblStartTime = new JLabel("Start Time:");
        
        JLabel lblEndDay = new JLabel("End Day:");
        
        JComboBox SimuStarttime = new JComboBox();
        
        SimuStarttime.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00 ", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
        SimuStarttime.setSelectedIndex(6);
        
        JTextField SimuEndday = new JTextField();
        
        SimuEndday.setText("100");
        
        SimuEndday.setColumns(10);
        
        JLabel lblEndTime = new JLabel("End Time:");
        
        JComboBox SimuEndtime = new JComboBox();
        SimuEndtime.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
        
        JLabel lblDay = new JLabel("Day");
        
        JCheckBox chckbxSameAsStart = new JCheckBox("Same as Start Time");
        chckbxSameAsStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if(chckbxSameAsStart.isEnabled()== true){
        			SimuEndtime.setSelectedIndex(SimuStarttime.getSelectedIndex());

        			SimuEndtime.setEnabled(false);
				}
				else if(chckbxSameAsStart.isEnabled()== false){
					SimuEndtime.setEnabled(true);
					SimuEndtime.setEnabled(true);
				}
        		
        	}
        });
        
        JLabel lblHr = new JLabel("HR");
        
        JLabel lblHr_1 = new JLabel("HR");
        GroupLayout gl_timepanel = new GroupLayout(timepanel);
        gl_timepanel.setHorizontalGroup(
        	gl_timepanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_timepanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblStartTime)
        				.addComponent(lblEndDay)
        				.addComponent(lblEndTime))
        			.addGap(30)
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_timepanel.createSequentialGroup()
        					.addComponent(lblDay)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(SimuEndday, 0, 0, Short.MAX_VALUE))
        				.addComponent(SimuStarttime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(SimuEndtime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_timepanel.createSequentialGroup()
        					.addComponent(lblHr_1)
        					.addPreferredGap(ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
        					.addComponent(chckbxSameAsStart))
        				.addComponent(lblHr))
        			.addContainerGap())
        );
        gl_timepanel.setVerticalGroup(
        	gl_timepanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_timepanel.createSequentialGroup()
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblStartTime)
        				.addComponent(SimuStarttime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblHr))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEndDay, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(SimuEndday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDay))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_timepanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(SimuEndtime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblEndTime)
        				.addComponent(chckbxSameAsStart)
        				.addComponent(lblHr_1))
        			.addGap(52))
        );
        timepanel.setLayout(gl_timepanel);
		General.setLayout(gl_General);
		Preferences.setLayout(gl_Preferences);
		
		JPanel CDC = new JPanel();
		
		tabbedPane.addTab("CDC", null, CDC, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		GroupLayout gl_CDC = new GroupLayout(CDC);
		gl_CDC.setHorizontalGroup(
			gl_CDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CDC.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_3, GroupLayout.PREFERRED_SIZE, 589, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_CDC.setVerticalGroup(
			gl_CDC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CDC.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_3, GroupLayout.PREFERRED_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel cdcoperation = new JPanel();
		tabbedPane_3.addTab("Operation", null, cdcoperation, null);
		
		JLabel lblOperationHours = new JLabel("Operation Hours: ");
		
		JComboBox CDCStart = new JComboBox();
		
		
		CDCStart.setModel(new DefaultComboBoxModel(new String[] {"06:00", "07:00", "08:00", "09:00", "10:00"}));
		
		JLabel label_1 = new JLabel("-");
		
		JComboBox CDCEnd = new JComboBox();
		
		CDCEnd.setModel(new DefaultComboBoxModel(new String[] {"17:00", "18:00", "19:00", "20:00", "21:00"}));
		
		JLabel lblCargoProcessingTime = new JLabel("Cargo Processing Time: ");
		
		JComboBox CDCTurnover = new JComboBox();
		CDCTurnover.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30", "35", "40", "45"}));
		
		JLabel lblMin = new JLabel("min");
		
		JLabel lblHr_2 = new JLabel("HR");
		
		JLabel lblNumberOfBays = new JLabel("Number of Bays:");
		
		JComboBox CDCBay = new JComboBox();
		CDCBay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JLabel lblMaximumCargoLimit = new JLabel("Maximum Cargo Limit:");
		
		JComboBox cdccargolimit = new JComboBox();
		cdccargolimit.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20"}));
		GroupLayout gl_cdcoperation = new GroupLayout(cdcoperation);
		gl_cdcoperation.setHorizontalGroup(
			gl_cdcoperation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdcoperation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cdcoperation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cdcoperation.createSequentialGroup()
							.addComponent(lblCargoProcessingTime)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CDCTurnover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin))
						.addGroup(gl_cdcoperation.createSequentialGroup()
							.addComponent(lblOperationHours)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CDCStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CDCEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHr_2))
						.addGroup(gl_cdcoperation.createSequentialGroup()
							.addComponent(lblMaximumCargoLimit)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cdccargolimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cdcoperation.createSequentialGroup()
							.addComponent(lblNumberOfBays)
							.addGap(7)
							.addComponent(CDCBay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(284, Short.MAX_VALUE))
		);
		gl_cdcoperation.setVerticalGroup(
			gl_cdcoperation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdcoperation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cdcoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOperationHours)
						.addComponent(CDCStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(CDCEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHr_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cdcoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargoProcessingTime)
						.addComponent(CDCTurnover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cdcoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumCargoLimit)
						.addComponent(cdccargolimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cdcoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfBays)
						.addComponent(CDCBay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		cdcoperation.setLayout(gl_cdcoperation);
		
		JPanel cdcdemand = new JPanel();
		tabbedPane_3.addTab("Demand", null, cdcdemand, null);
		
		JLabel lblCargoDemandPer = new JLabel("Cargo Demand Per Day: ");
		
		JTextField cdccargo = new JTextField();
		cdccargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
        			tabbedPane.setSelectedIndex(1);
        			tabbedPane_3.setSelectedIndex(1);
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the number of CDC cargo per day.");  
        		}
			}
		});
		cdccargo.setText("0");
		cdccargo.setColumns(10);
		
		JLabel lblDemandCurve = new JLabel("Demand:");
		
		JSlider slider = new JSlider();
		JSlider slider_1 = new JSlider();
		JSlider slider_2 = new JSlider();
		JSlider slider_3 = new JSlider();
		JSlider slider_4 = new JSlider();
		JSlider slider_5 = new JSlider();
		JSlider slider_6 = new JSlider();
		JSlider slider_7 = new JSlider();
		JSlider slider_8 = new JSlider();
		JSlider slider_9 = new JSlider();
		JSlider slider_10 = new JSlider();
		JSlider slider_11 = new JSlider();
		slider_11.setEnabled(false);
		JSlider slider_12 = new JSlider();
		slider_12.setEnabled(false);
		JSlider slider_13 = new JSlider();
		slider_13.setEnabled(false);
		JSlider slider_14 = new JSlider();
		slider_14.setEnabled(false);
		
		slider.setValue(0);
		slider.setOrientation(SwingConstants.VERTICAL);
		
		slider_1.setValue(0);
		slider_1.setOrientation(SwingConstants.VERTICAL);
		
		slider_2.setOrientation(SwingConstants.VERTICAL);
		slider_2.setValue(0);
		
		slider_3.setValue(0);
		slider_3.setOrientation(SwingConstants.VERTICAL);
		
		slider_4.setOrientation(SwingConstants.VERTICAL);
		slider_4.setValue(0);
		
		slider_5.setValue(0);
		slider_5.setOrientation(SwingConstants.VERTICAL);
		
		slider_6.setValue(0);
		slider_6.setOrientation(SwingConstants.VERTICAL);
		
		slider_7.setValue(0);
		slider_7.setOrientation(SwingConstants.VERTICAL);
		
		slider_8.setOrientation(SwingConstants.VERTICAL);
		slider_8.setValue(0);
		
		slider_9.setValue(0);
		slider_9.setOrientation(SwingConstants.VERTICAL);
		
		slider_10.setValue(0);
		slider_10.setOrientation(SwingConstants.VERTICAL);
		
		slider_11.setValue(0);
		slider_11.setOrientation(SwingConstants.VERTICAL);
		
		slider_12.setValue(0);
		slider_12.setOrientation(SwingConstants.VERTICAL);
		
		slider_13.setOrientation(SwingConstants.VERTICAL);
		slider_13.setValue(0);
		
		slider_14.setValue(0);
		slider_14.setOrientation(SwingConstants.VERTICAL);
		
		JLabel label_2 = new JLabel("0600");
		
		JLabel label_3 = new JLabel("1200");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_4 = new JLabel("1800");
		GroupLayout groupLayout = new GroupLayout(cdcdemand);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCargoDemandPer)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_2)
										.addComponent(slider, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(19)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cdccargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(slider_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(slider_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(slider_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
											.addGap(30)))
									.addComponent(slider_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(42))))
						.addComponent(lblDemandCurve))
					.addContainerGap(27, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargoDemandPer)
						.addComponent(cdccargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDemandCurve)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		cdcdemand.setLayout(groupLayout);
		CDC.setLayout(gl_CDC);
		
		JPanel Factory = new JPanel();
		tabbedPane.addTab("Factory", null, Factory, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		GroupLayout gl_Factory = new GroupLayout(Factory);
		gl_Factory.setHorizontalGroup(
			gl_Factory.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Factory.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Factory.setVerticalGroup(
			gl_Factory.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Factory.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel agvoperation = new JPanel();
		tabbedPane_1.addTab("Operation", null, agvoperation, null);
		
		JLabel lblOperationHours_1 = new JLabel("Operation Hours: ");
		
		JComboBox FactoryStart = new JComboBox();
		
		FactoryStart.setModel(new DefaultComboBoxModel(new String[] {"06:00", "07:00", "08:00", "09:00", "10:00"}));
		
		JLabel label = new JLabel("-");
		
		JComboBox FactoryEnd = new JComboBox();
		FactoryEnd.setModel(new DefaultComboBoxModel(new String[] {"17:00", "18:00", "19:00", "20:00", "21:00"}));
		
		JCheckBox chckbxSameAsCdc = new JCheckBox("Same as CDC");
		chckbxSameAsCdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(FactoryStart.isEnabled()== true){
					FactoryStart.setSelectedIndex(CDCStart.getSelectedIndex());
					FactoryEnd.setSelectedIndex(CDCEnd.getSelectedIndex());
					FactoryStart.setEnabled(false);
					FactoryEnd.setEnabled(false);
				}
				else if(FactoryStart.isEnabled()== false){
					FactoryStart.setEnabled(true);
					FactoryEnd.setEnabled(true);
				}
			}
		});
		
		JLabel lblCargoProcessingTime_1 = new JLabel("Cargo Processing Time: ");
		
		JComboBox FactTurnover = new JComboBox();
		FactTurnover.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));
		
		JLabel lblMin_1 = new JLabel("min");
		
		JLabel lblHr_3 = new JLabel("HR");
		
		JLabel lblNumberOfBays_1 = new JLabel("Number of Bays: ");
		
		JComboBox FactBay = new JComboBox();
		FactBay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JLabel lblMaximumCargoLimit_1 = new JLabel("Maximum Cargo Limit:");
		
		JComboBox factcargolimit = new JComboBox();
		factcargolimit.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GroupLayout gl_agvoperation = new GroupLayout(agvoperation);
		gl_agvoperation.setHorizontalGroup(
			gl_agvoperation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_agvoperation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_agvoperation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_agvoperation.createSequentialGroup()
							.addComponent(lblOperationHours_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FactoryStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FactoryEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHr_3)
							.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
							.addComponent(chckbxSameAsCdc)
							.addGap(28))
						.addGroup(gl_agvoperation.createSequentialGroup()
							.addComponent(lblCargoProcessingTime_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FactTurnover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin_1)
							.addContainerGap(334, Short.MAX_VALUE))
						.addGroup(gl_agvoperation.createSequentialGroup()
							.addComponent(lblMaximumCargoLimit_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(factcargolimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_agvoperation.createSequentialGroup()
							.addComponent(lblNumberOfBays_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FactBay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_agvoperation.setVerticalGroup(
			gl_agvoperation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_agvoperation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_agvoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOperationHours_1)
						.addComponent(FactoryStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(FactoryEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxSameAsCdc)
						.addComponent(lblHr_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_agvoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargoProcessingTime_1)
						.addComponent(FactTurnover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_agvoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumCargoLimit_1)
						.addComponent(factcargolimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_agvoperation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfBays_1)
						.addComponent(FactBay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		agvoperation.setLayout(gl_agvoperation);
		
		JPanel agvdemand = new JPanel();
		tabbedPane_1.addTab("Demand", null, agvdemand, null);
		
		JLabel lblCargoDemandPer_1 = new JLabel("Cargo Demand Per Day: ");
		
		JTextField factcargo = new JTextField();
		factcargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
        			tabbedPane.setSelectedIndex(2);
        			tabbedPane_1.setSelectedIndex(1);
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the number of factory cargo per day.");  
        		}
			}
		});
		factcargo.setText("5");
		factcargo.setColumns(10);
		
		JLabel lblDemand = new JLabel("Demand:");
		
		JSlider slider_16 = new JSlider();
		slider_16.setMinorTickSpacing(1);
		slider_16.setValue(0);
		slider_16.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_17 = new JSlider();
		slider_17.setValue(0);
		slider_17.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_18 = new JSlider();
		slider_18.setValue(0);
		slider_18.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_19 = new JSlider();
		slider_19.setValue(0);
		slider_19.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_20 = new JSlider();
		slider_20.setValue(0);
		slider_20.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_21 = new JSlider();
		slider_21.setValue(0);
		slider_21.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_22 = new JSlider();
		slider_22.setValue(0);
		slider_22.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_23 = new JSlider();
		slider_23.setValue(0);
		slider_23.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_24 = new JSlider();
		slider_24.setValue(0);
		slider_24.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_25 = new JSlider();
		slider_25.setValue(0);
		slider_25.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_26 = new JSlider();
		slider_26.setOrientation(SwingConstants.VERTICAL);
		slider_26.setValue(0);
		
		JSlider slider_27 = new JSlider();
		slider_27.setEnabled(false);
		slider_27.setValue(0);
		slider_27.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_28 = new JSlider();
		slider_28.setEnabled(false);
		slider_28.setOrientation(SwingConstants.VERTICAL);
		slider_28.setValue(0);
		
		JSlider slider_29 = new JSlider();
		slider_29.setEnabled(false);
		slider_29.setValue(0);
		slider_29.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_30 = new JSlider();
		slider_30.setEnabled(false);
		slider_30.setValue(0);
		slider_30.setOrientation(SwingConstants.VERTICAL);
		
		JLabel label_6 = new JLabel("0600");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("1200");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_8 = new JLabel("1800");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_agvdemand = new GroupLayout(agvdemand);
		gl_agvdemand.setHorizontalGroup(
			gl_agvdemand.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_agvdemand.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDemand)
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addComponent(lblCargoDemandPer_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(factcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(301, Short.MAX_VALUE))
				.addGroup(gl_agvdemand.createSequentialGroup()
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addContainerGap(49, Short.MAX_VALUE)
							.addComponent(slider_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addGap(29)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(116)))
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addComponent(slider_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addGap(10)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addComponent(slider_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(slider_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_agvdemand.createSequentialGroup()
							.addGap(10)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(slider_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(slider_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		gl_agvdemand.setVerticalGroup(
			gl_agvdemand.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_agvdemand.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargoDemandPer_1)
						.addComponent(factcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDemand)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_agvdemand.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8)
						.addComponent(label_6)
						.addComponent(label_7))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		agvdemand.setLayout(gl_agvdemand);
		Factory.setLayout(gl_Factory);
		
		JPanel Truck = new JPanel();
		tabbedPane.addTab("Truck", null, Truck, null);
		
		JCheckBox chckbxEnableTruckOperation = new JCheckBox("Enable Truck Operation");
		
		JPanel Subtruck = new JPanel();
		GroupLayout gl_Truck = new GroupLayout(Truck);
		gl_Truck.setHorizontalGroup(
			gl_Truck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Truck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Truck.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxEnableTruckOperation)
						.addComponent(Subtruck, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_Truck.setVerticalGroup(
			gl_Truck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Truck.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxEnableTruckOperation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Subtruck, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setEnabled(false);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblMaximumSpeed = new JLabel("Maximum Speed:");
		lblMaximumSpeed.setEnabled(false);
		
		JLabel lblPresetMode = new JLabel("Preset Mode:");
		lblPresetMode.setEnabled(false);
		
		JLabel lblMaximumAcceleration = new JLabel("Maximum Acceleration:");
		lblMaximumAcceleration.setEnabled(false);

		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 0 ), new JLabel("0") );
		labelTable.put( new Integer( 5 ), new JLabel("0.5") );
		labelTable.put( new Integer( 10 ), new JLabel("1.0") );
		
		JLabel lblMaximumDeceleration = new JLabel("Maximum Deceleration:");
		lblMaximumDeceleration.setEnabled(false);
		
		JLabel lblTimeGap = new JLabel("Time Gap:");
		lblTimeGap.setEnabled(false);
		
		JLabel lblMinimumDistanceGap = new JLabel("Minimum Distance Gap:");
		lblMinimumDistanceGap.setEnabled(false);
		
		JComboBox TruckQty = new JComboBox();
		TruckQty.setEnabled(false);
		TruckQty.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		
		JComboBox TruckMode = new JComboBox();
		TruckMode.setEnabled(false);
		TruckMode.setModel(new DefaultComboBoxModel(new String[] {"Custom", "Patient", "Normal", "Aggressive"}));

		
		JComboBox TruckSpd = new JComboBox();
		TruckSpd.setEnabled(false);
		TruckSpd.setModel(new DefaultComboBoxModel(new String[] {"12", "24", "36", "48", "60", "72", "84", "96", "108"}));
		
		JComboBox TruckAccSpd = new JComboBox();
		TruckAccSpd.setEnabled(false);
		TruckAccSpd.setModel(new DefaultComboBoxModel(new String[] {"0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5"}));
		
		JComboBox TruckDecSpd = new JComboBox();
		TruckDecSpd.setEnabled(false);
		TruckDecSpd.setModel(new DefaultComboBoxModel(new String[] {"0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0"}));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblPolitenessFactor = new JLabel("Politeness Factor:");
		lblPolitenessFactor.setEnabled(false);
		
		JLabel lblChangingThreshold = new JLabel("Changing Threshold:");
		lblChangingThreshold.setEnabled(false);
		
		JComboBox TruckTimeGap = new JComboBox();
		TruckTimeGap.setEnabled(false);
		TruckTimeGap.setModel(new DefaultComboBoxModel(new String[] {"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0"}));
		
		JComboBox TruckDistGap = new JComboBox();
		TruckDistGap.setEnabled(false);
		TruckDistGap.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		
		JComboBox TruckPolite = new JComboBox();
		TruckPolite.setEnabled(false);
		TruckPolite.setModel(new DefaultComboBoxModel(new String[] {"0.0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0"}));
		
		JComboBox TruckChanging = new JComboBox();
		TruckChanging.setEnabled(false);
		TruckChanging.setModel(new DefaultComboBoxModel(new String[] {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0"}));
		
		JLabel lblKmh_1 = new JLabel("km/h");
		lblKmh_1.setEnabled(false);
		
		JLabel lblMs_2 = new JLabel("m/s\u00B2");
		lblMs_2.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("m/s\u00B2");
		lblNewLabel_1.setEnabled(false);
		
		JLabel lblS_1 = new JLabel("s");
		lblS_1.setEnabled(false);
		
		JLabel lblM_1 = new JLabel("m");
		lblM_1.setEnabled(false);
		
		JLabel lblMs_3 = new JLabel("m/s\u00B2");
		lblMs_3.setEnabled(false);
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblFuelefficiencyWith = new JLabel("Fuel Consumption with Cargo:");
		lblFuelefficiencyWith.setEnabled(false);
		
		JLabel lblFuelConsumptionWithout = new JLabel("Fuel Consumption without Cargo:");
		lblFuelConsumptionWithout.setEnabled(false);
		
		JTextField Truckfewcargo = new JTextField();
		Truckfewcargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the fuel efficiency.");  
        		}
			}
		});
		Truckfewcargo.setText("27");
		Truckfewcargo.setEnabled(false);
		Truckfewcargo.setColumns(10);
		
		JTextField Truckfewocargo = new JTextField();
		Truckfewocargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the fuel efficiency.");  
        		}
			}
		});
		Truckfewocargo.setText("17");
		Truckfewocargo.setEnabled(false);
		Truckfewocargo.setColumns(10);
		
		JLabel lblLitreskm = new JLabel("Litres/Km");
		lblLitreskm.setEnabled(false);
		
		JLabel lblLitreskm_1 = new JLabel("Litres/Km");
		lblLitreskm_1.setEnabled(false);
		
		JCheckBox chckbxPriorityOverAgv = new JCheckBox("Priority over AGV");
		chckbxPriorityOverAgv.setEnabled(false);
		
		GroupLayout gl_Subtruck = new GroupLayout(Subtruck);
		gl_Subtruck.setHorizontalGroup(
			gl_Subtruck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Subtruck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(lblQuantity)
							.addGap(18)
							.addComponent(TruckQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(163)
							.addComponent(chckbxPriorityOverAgv)
							.addContainerGap())
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(lblPresetMode)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TruckMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
									.addComponent(lblMaximumAcceleration)
									.addComponent(lblMaximumDeceleration, Alignment.TRAILING))
								.addComponent(lblTimeGap)
								.addComponent(lblMaximumSpeed))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Subtruck.createSequentialGroup()
									.addComponent(TruckTimeGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblS_1))
								.addGroup(gl_Subtruck.createSequentialGroup()
									.addComponent(TruckDecSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_Subtruck.createSequentialGroup()
									.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
										.addComponent(TruckAccSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(TruckSpd, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
										.addComponent(lblKmh_1)
										.addComponent(lblMs_2))))
							.addGap(394))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(lblMinimumDistanceGap)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TruckDistGap, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblM_1)
							.addGap(422))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(lblPolitenessFactor)
							.addGap(18)
							.addComponent(TruckPolite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(434, Short.MAX_VALUE))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(lblChangingThreshold)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TruckChanging, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMs_3)
							.addContainerGap(409, Short.MAX_VALUE))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(gl_Subtruck.createSequentialGroup()
							.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFuelefficiencyWith)
								.addComponent(lblFuelConsumptionWithout))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Truckfewocargo, 0, 0, Short.MAX_VALUE)
								.addComponent(Truckfewcargo, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Subtruck.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLitreskm)
								.addComponent(lblLitreskm_1))
							.addGap(299))))
		);
		gl_Subtruck.setVerticalGroup(
			gl_Subtruck.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Subtruck.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(TruckQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxPriorityOverAgv))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPresetMode)
						.addComponent(TruckMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumSpeed)
						.addComponent(TruckSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKmh_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumAcceleration)
						.addComponent(TruckAccSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMs_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumDeceleration)
						.addComponent(TruckDecSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimeGap)
						.addComponent(TruckTimeGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblS_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinimumDistanceGap)
						.addComponent(TruckDistGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblM_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPolitenessFactor)
						.addComponent(TruckPolite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChangingThreshold)
						.addComponent(TruckChanging, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMs_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuelefficiencyWith)
						.addComponent(Truckfewcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLitreskm))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Subtruck.createParallelGroup(Alignment.BASELINE)
						.addComponent(Truckfewocargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFuelConsumptionWithout)
						.addComponent(lblLitreskm_1))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		Subtruck.setLayout(gl_Subtruck);
		Truck.setLayout(gl_Truck);
			
		JPanel AGV = new JPanel();
		tabbedPane.addTab("AGV", null, AGV, null);
		
		JCheckBox chckbxEnableAgvOperation = new JCheckBox("Enable AGV Operation");
		
		JPanel SubAGV = new JPanel();
		GroupLayout gl_AGV = new GroupLayout(AGV);
		gl_AGV.setHorizontalGroup(
			gl_AGV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AGV.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AGV.createParallelGroup(Alignment.LEADING)
						.addComponent(SubAGV, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
						.addComponent(chckbxEnableAgvOperation))
					.addContainerGap())
		);
		gl_AGV.setVerticalGroup(
			gl_AGV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AGV.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxEnableAgvOperation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SubAGV, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblQuantity_1 = new JLabel("Quantity:");
		lblQuantity_1.setEnabled(false);
		
		JLabel lblAgvMode = new JLabel("Preset Mode:");
		lblAgvMode.setEnabled(false);
		
		JSeparator separator_3 = new JSeparator();
		
		JComboBox AgvQty = new JComboBox();
		AgvQty.setEnabled(false);
		AgvQty.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		
		JComboBox AgvMode = new JComboBox();
		AgvMode.setEnabled(false);
		AgvMode.setModel(new DefaultComboBoxModel(new String[] {"Custom", "Slow", "Normal", "Fast"}));
		
		JLabel lblMaximumSpeed_1 = new JLabel("Maximum Speed:");
		lblMaximumSpeed_1.setEnabled(false);
		
		JLabel lblMaximumAcceleration_1 = new JLabel("Maximum Acceleration:");
		lblMaximumAcceleration_1.setEnabled(false);
		
		JLabel lblMaximumDeceleration_1 = new JLabel("Maximum Deceleration:");
		lblMaximumDeceleration_1.setEnabled(false);
		
		JLabel lblTimeGap_1 = new JLabel("Time Gap:");
		lblTimeGap_1.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Minimum Distance Gap:");
		lblNewLabel.setEnabled(false);
		
		JComboBox AgvSpd = new JComboBox();
		AgvSpd.setEnabled(false);
		AgvSpd.setModel(new DefaultComboBoxModel(new String[] {"12", "24", "36", "48", "60", "72"}));
		
		JComboBox AgvAccSpd = new JComboBox();
		AgvAccSpd.setEnabled(false);
		AgvAccSpd.setModel(new DefaultComboBoxModel(new String[] {"0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5"}));
		
		JComboBox AgvDecSpd = new JComboBox();
		AgvDecSpd.setEnabled(false);
		AgvDecSpd.setModel(new DefaultComboBoxModel(new String[] {"0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0"}));
		
		JComboBox AgvTimeGap = new JComboBox();
		AgvTimeGap.setEnabled(false);
		AgvTimeGap.setModel(new DefaultComboBoxModel(new String[] {"0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0"}));
		
		JComboBox AgvDistGap = new JComboBox();
		AgvDistGap.setEnabled(false);
		AgvDistGap.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JLabel lblKmh = new JLabel("km/h");
		lblKmh.setEnabled(false);
		
		JLabel lblMs = new JLabel("m/s\u00B2");
		lblMs.setEnabled(false);
		
		JLabel lblMs_1 = new JLabel("m/s\u00B2");
		lblMs_1.setEnabled(false);
		
		JLabel lblS = new JLabel("s");
		lblS.setEnabled(false);
		
		JLabel lblM = new JLabel("m");
		lblM.setEnabled(false);
		
		JSeparator separator_5 = new JSeparator();
		
		JLabel lblFuelefficiencyWith_1 = new JLabel("Fuel efficiency with Cargo:");
		lblFuelefficiencyWith_1.setEnabled(false);
		
		JLabel lblFuelefficiencyWithout = new JLabel("Fuel efficiency without Cargo:");
		lblFuelefficiencyWithout.setEnabled(false);
		
		JTextField Agvfewcargo = new JTextField();
		Agvfewcargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the fuel efficiency.");  
        		}
			}
		});
		Agvfewcargo.setText("21");
		Agvfewcargo.setEnabled(false);
		Agvfewcargo.setColumns(10);
		
		JTextField Agvfewocargo = new JTextField();
		Agvfewocargo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			e.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for the fuel efficiency.");  
        		}
			}
		});
		Agvfewocargo.setText("10");
		Agvfewocargo.setEnabled(false);
		Agvfewocargo.setColumns(10);
		
		JLabel lblLitreskm_2 = new JLabel("Litres/Km");
		lblLitreskm_2.setEnabled(false);
		
		JLabel lblLitreskm_3 = new JLabel("Litres/Km");
		lblLitreskm_3.setEnabled(false);
		
		JCheckBox chckbxPriorityOverTruck = new JCheckBox("Priority over Truck");
		chckbxPriorityOverTruck.setEnabled(false);
		

		GroupLayout gl_SubAGV = new GroupLayout(SubAGV);
		gl_SubAGV.setHorizontalGroup(
			gl_SubAGV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SubAGV.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_3, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addGroup(gl_SubAGV.createSequentialGroup()
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantity_1)
								.addComponent(lblAgvMode))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_SubAGV.createSequentialGroup()
									.addComponent(AgvQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(169)
									.addComponent(chckbxPriorityOverTruck))
								.addComponent(AgvMode, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_SubAGV.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AgvDistGap, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblM))
						.addGroup(gl_SubAGV.createSequentialGroup()
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaximumAcceleration_1)
								.addComponent(lblMaximumSpeed_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING, false)
								.addComponent(AgvSpd, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(AgvAccSpd, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMs)
								.addComponent(lblKmh)))
						.addGroup(gl_SubAGV.createSequentialGroup()
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaximumDeceleration_1)
								.addComponent(lblTimeGap_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_SubAGV.createSequentialGroup()
									.addComponent(AgvTimeGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblS))
								.addGroup(gl_SubAGV.createSequentialGroup()
									.addComponent(AgvDecSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMs_1))))
						.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_SubAGV.createSequentialGroup()
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFuelefficiencyWithout)
								.addComponent(lblFuelefficiencyWith_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(Agvfewcargo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(Agvfewocargo, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SubAGV.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLitreskm_3)
								.addComponent(lblLitreskm_2))))
					.addContainerGap())
		);
		gl_SubAGV.setVerticalGroup(
			gl_SubAGV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SubAGV.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity_1)
						.addComponent(AgvQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxPriorityOverTruck))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAgvMode)
						.addComponent(AgvMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumSpeed_1)
						.addComponent(AgvSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKmh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumAcceleration_1)
						.addComponent(AgvAccSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMs))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaximumDeceleration_1)
						.addComponent(AgvDecSpd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMs_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimeGap_1)
						.addComponent(AgvTimeGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblS))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(AgvDistGap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblM))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuelefficiencyWith_1)
						.addComponent(Agvfewcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLitreskm_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SubAGV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuelefficiencyWithout)
						.addComponent(Agvfewocargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLitreskm_3))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		SubAGV.setLayout(gl_SubAGV);
		AGV.setLayout(gl_AGV);
		contentPane.setLayout(gl_contentPane);
		
		
		
		//
		SimuStarttime.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(chckbxSameAsStart.isSelected()==true){
					SimuEndtime.setSelectedIndex(SimuStarttime.getSelectedIndex());
				}
        	}
        });
		
		//CDC Set Factory Operation Hour if "Same as CDC" is enabled;
		CDCStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSameAsCdc.isSelected()==true){
					FactoryStart.setSelectedIndex(CDCStart.getSelectedIndex());
				}
				if(CDCStart.getSelectedIndex()==0){
					slider.setValue(0);
					slider.setEnabled(true);
					slider_1.setValue(0);
					slider_1.setEnabled(true);
					slider_2.setValue(0);
					slider_2.setEnabled(true);
					slider_3.setValue(0);
					slider_3.setEnabled(true);
				}
				if(CDCStart.getSelectedIndex()==1){
					slider.setValue(0);
					slider.setEnabled(false);
					slider_1.setValue(0);
					slider_1.setEnabled(true);
					slider_2.setValue(0);
					slider_2.setEnabled(true);
					slider_3.setValue(0);
					slider_3.setEnabled(true);
				}
				if(CDCStart.getSelectedIndex()==2){
					slider.setValue(0);
					slider.setEnabled(false);
					slider_1.setValue(0);
					slider_1.setEnabled(false);
					slider_2.setValue(0);
					slider_2.setEnabled(true);	
					slider_3.setValue(0);
					slider_3.setEnabled(true);
				}
				if(CDCStart.getSelectedIndex()==3){
					slider.setValue(0);
					slider.setEnabled(false);
					slider_1.setValue(0);
					slider_1.setEnabled(false);
					slider_2.setValue(0);
					slider_2.setEnabled(false);
					slider_3.setValue(0);
					slider_3.setEnabled(true);
				}
				if(CDCStart.getSelectedIndex()==4){
					slider.setValue(0);
					slider.setEnabled(false);
					slider_1.setValue(0);
					slider_1.setEnabled(false);
					slider_2.setValue(0);
					slider_2.setEnabled(false);
					slider_3.setValue(0);
					slider_3.setEnabled(true);
				}
			}
		});
		CDCEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxSameAsCdc.isSelected()==true){
					FactoryEnd.setSelectedIndex(CDCEnd.getSelectedIndex());
				}
				if(CDCEnd.getSelectedIndex()==0){
					slider_11.setValue(0);
					slider_11.setEnabled(false);
					slider_12.setValue(0);
					slider_12.setEnabled(false);
					slider_13.setValue(0);
					slider_13.setEnabled(false);
					slider_14.setValue(0);
					slider_14.setEnabled(false);
				}
				if(CDCEnd.getSelectedIndex()==1){
					slider_11.setValue(0);
					slider_11.setEnabled(true);
					slider_12.setValue(0);
					slider_12.setEnabled(false);
					slider_13.setValue(0);
					slider_13.setEnabled(false);
					slider_14.setValue(0);
					slider_14.setEnabled(false);
				}
				if(CDCEnd.getSelectedIndex()==2){
					slider_11.setValue(0);
					slider_11.setEnabled(true);
					slider_12.setValue(0);
					slider_12.setEnabled(true);
					slider_13.setValue(0);
					slider_13.setEnabled(false);
					slider_14.setValue(0);
					slider_14.setEnabled(false);					
				}
				if(CDCEnd.getSelectedIndex()==3){
					slider_11.setValue(0);
					slider_11.setEnabled(true);
					slider_12.setValue(0);
					slider_12.setEnabled(true);
					slider_13.setValue(0);
					slider_13.setEnabled(true);
					slider_14.setValue(0);
					slider_14.setEnabled(false);
				}
				if(CDCEnd.getSelectedIndex()==4){
					slider_11.setValue(0);
					slider_11.setEnabled(true);
					slider_12.setValue(0);
					slider_12.setEnabled(true);
					slider_13.setValue(0);
					slider_13.setEnabled(true);
					slider_14.setValue(0);
					slider_14.setEnabled(true);
				}
			}
		});
		
		FactoryStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FactoryStart.getSelectedIndex()==0){
					slider_16.setValue(0);
					slider_16.setEnabled(true);
					slider_17.setValue(0);
					slider_17.setEnabled(true);
					slider_18.setValue(0);
					slider_18.setEnabled(true);
					slider_19.setValue(0);
					slider_19.setEnabled(true);
				}
				if(FactoryStart.getSelectedIndex()==1){
					slider_16.setValue(0);
					slider_16.setEnabled(false);
					slider_17.setValue(0);
					slider_17.setEnabled(true);
					slider_18.setValue(0);
					slider_18.setEnabled(true);
					slider_19.setValue(0);
					slider_19.setEnabled(true);
				}
				if(FactoryStart.getSelectedIndex()==2){
					slider_16.setValue(0);
					slider_16.setEnabled(false);
					slider_17.setValue(0);
					slider_17.setEnabled(false);
					slider_18.setValue(0);
					slider_18.setEnabled(true);	
					slider_19.setValue(0);
					slider_19.setEnabled(true);
				}
				if(FactoryStart.getSelectedIndex()==3){
					slider_16.setValue(0);
					slider_16.setEnabled(false);
					slider_17.setValue(0);
					slider_17.setEnabled(false);
					slider_18.setValue(0);
					slider_18.setEnabled(false);
					slider_19.setValue(0);
					slider_19.setEnabled(true);
				}
				if(FactoryStart.getSelectedIndex()==4){
					slider_16.setValue(0);
					slider_16.setEnabled(false);
					slider_17.setValue(0);
					slider_17.setEnabled(false);
					slider_18.setValue(0);
					slider_18.setEnabled(false);
					slider_19.setValue(0);
					slider_19.setEnabled(true);
				}
			}
		});
		
		FactoryEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FactoryEnd.getSelectedIndex()==0){
					slider_27.setValue(0);
					slider_27.setEnabled(false);
					slider_28.setValue(0);
					slider_28.setEnabled(false);
					slider_29.setValue(0);
					slider_29.setEnabled(false);
					slider_30.setValue(0);
					slider_30.setEnabled(false);
				}
				if(FactoryEnd.getSelectedIndex()==1){
					slider_27.setValue(0);
					slider_27.setEnabled(true);
					slider_28.setValue(0);
					slider_28.setEnabled(false);
					slider_29.setValue(0);
					slider_29.setEnabled(false);
					slider_30.setValue(0);
					slider_30.setEnabled(false);					
				}
				if(FactoryEnd.getSelectedIndex()==2){
					slider_27.setValue(0);
					slider_27.setEnabled(true);
					slider_28.setValue(0);
					slider_28.setEnabled(true);
					slider_29.setValue(0);
					slider_29.setEnabled(false);
					slider_30.setValue(0);
					slider_30.setEnabled(false);
				}
				if(FactoryEnd.getSelectedIndex()==3){
					slider_27.setValue(0);
					slider_27.setEnabled(true);
					slider_28.setValue(0);
					slider_28.setEnabled(true);
					slider_29.setValue(0);
					slider_29.setEnabled(true);
					slider_30.setValue(0);
					slider_30.setEnabled(false);
				}
				if(FactoryEnd.getSelectedIndex()==4){
					slider_27.setValue(0);
					slider_27.setEnabled(true);
					slider_28.setValue(0);
					slider_28.setEnabled(true);
					slider_29.setValue(0);
					slider_29.setEnabled(true);
					slider_30.setValue(0);
					slider_30.setEnabled(true);
				}
			}
		});
		
		//ENABLER FOR BOTH TRUCK AND AGV
		chckbxEnableTruckOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TruckMode.setSelectedIndex(0);
				enableComponents(Subtruck, chckbxEnableTruckOperation.isSelected());	
				if(chckbxEnableAgvOperation.isSelected() == true && chckbxEnableTruckOperation.isSelected() == true)
				{
					chckbxPriorityOverAgv.setEnabled(true);
					chckbxPriorityOverTruck.setEnabled(true);
				}else{
					chckbxPriorityOverAgv.setEnabled(false);
					chckbxPriorityOverTruck.setEnabled(false);
				}
				
			}
		});
		
		chckbxEnableAgvOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgvMode.setSelectedIndex(0);				
				enableComponents(SubAGV, chckbxEnableAgvOperation.isSelected());
				if(chckbxEnableTruckOperation.isSelected() == true && chckbxEnableAgvOperation.isSelected() == true ){
					chckbxPriorityOverAgv.setEnabled(true);
					chckbxPriorityOverTruck.setEnabled(true);
				}else{
					chckbxPriorityOverAgv.setEnabled(false);
					chckbxPriorityOverTruck.setEnabled(false);
				}
			}
		});
		
		//MODE CHANGE FOR TRUCK;
		TruckMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TruckMode.getSelectedItem()=="Custom"){
					System.out.println("Be custom");
					TruckSpd.setEnabled(true);
					TruckAccSpd.setEnabled(true);
					TruckDecSpd.setEnabled(true);
					TruckTimeGap.setEnabled(true);
					TruckDistGap.setEnabled(true);
					TruckPolite.setEnabled(true);
					TruckChanging.setEnabled(true);
					Truckfewcargo.setEnabled(true);
					Truckfewocargo.setEnabled(true);
				}
				if(TruckMode.getSelectedItem()=="Patient"){
					System.out.println("Be patient");
					TruckSpd.setSelectedIndex(0);
					TruckAccSpd.setSelectedIndex(0);
					TruckDecSpd.setSelectedIndex(0);
					TruckTimeGap.setSelectedIndex(0);
					TruckDistGap.setSelectedIndex(0);
					TruckPolite.setSelectedIndex(0);
					TruckChanging.setSelectedIndex(0);
					Truckfewcargo.setText("27");
					Truckfewocargo.setText("17");
					TruckSpd.setEnabled(false);
					TruckAccSpd.setEnabled(false);
					TruckDecSpd.setEnabled(false);
					TruckTimeGap.setEnabled(false);
					TruckDistGap.setEnabled(false);
					TruckPolite.setEnabled(false);
					TruckChanging.setEnabled(false);
					Truckfewcargo.setEnabled(false);
					Truckfewocargo.setEnabled(false);
				}
				if(TruckMode.getSelectedItem()=="Normal"){
					System.out.println("Be patient");
					TruckSpd.setSelectedIndex(0);
					TruckAccSpd.setSelectedIndex(0);
					TruckDecSpd.setSelectedIndex(0);
					TruckTimeGap.setSelectedIndex(0);
					TruckDistGap.setSelectedIndex(0);
					TruckPolite.setSelectedIndex(0);
					TruckChanging.setSelectedIndex(0);
					Truckfewcargo.setText("27");
					Truckfewocargo.setText("17");
					TruckSpd.setEnabled(false);
					TruckAccSpd.setEnabled(false);
					TruckDecSpd.setEnabled(false);
					TruckTimeGap.setEnabled(false);
					TruckDistGap.setEnabled(false);
					TruckPolite.setEnabled(false);
					TruckChanging.setEnabled(false);
					Truckfewcargo.setEnabled(false);
					Truckfewocargo.setEnabled(false);
				}
				if(TruckMode.getSelectedItem()=="Aggressive"){
					System.out.println("Be patient");
					TruckSpd.setSelectedIndex(0);
					TruckAccSpd.setSelectedIndex(0);
					TruckDecSpd.setSelectedIndex(0);
					TruckTimeGap.setSelectedIndex(0);
					TruckDistGap.setSelectedIndex(0);
					TruckPolite.setSelectedIndex(0);
					TruckChanging.setSelectedIndex(0);
					Truckfewcargo.setText("27");
					Truckfewocargo.setText("17");
					TruckSpd.setEnabled(false);
					TruckAccSpd.setEnabled(false);
					TruckDecSpd.setEnabled(false);
					TruckTimeGap.setEnabled(false);
					TruckDistGap.setEnabled(false);
					TruckPolite.setEnabled(false);
					TruckChanging.setEnabled(false);
					Truckfewcargo.setEnabled(false);
					Truckfewocargo.setEnabled(false);
				}	
			}
		});
		
		//MODE CHANGE FOR AGV;
		AgvMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AgvMode.getSelectedItem()=="Custom"){
					System.out.println("Be custom");
					AgvSpd.setEnabled(true);
					AgvAccSpd.setEnabled(true);
					AgvDecSpd.setEnabled(true);
					AgvTimeGap.setEnabled(true);
					AgvDistGap.setEnabled(true);
					Agvfewcargo.setEnabled(true);
					Agvfewocargo.setEnabled(true);
				}
				if(AgvMode.getSelectedItem()=="Slow"){
					System.out.println("Be slow");
					AgvSpd.setSelectedIndex(0);
					AgvAccSpd.setSelectedIndex(0);
					AgvDecSpd.setSelectedIndex(0);
					AgvTimeGap.setSelectedIndex(0);
					AgvDistGap.setSelectedIndex(0);
					Agvfewcargo.setText("27");
					Agvfewocargo.setText("17");
					AgvSpd.setEnabled(false);
					AgvAccSpd.setEnabled(false);
					AgvDecSpd.setEnabled(false);
					AgvTimeGap.setEnabled(false);
					AgvDistGap.setEnabled(false);
					Agvfewcargo.setEnabled(false);
					Agvfewocargo.setEnabled(false);
				}
				if(AgvMode.getSelectedItem()=="Normal"){
					System.out.println("Be normal");
					AgvSpd.setSelectedIndex(0);
					AgvAccSpd.setSelectedIndex(0);
					AgvDecSpd.setSelectedIndex(0);
					AgvTimeGap.setSelectedIndex(0);
					AgvDistGap.setSelectedIndex(0);
					Agvfewcargo.setText("27");
					Agvfewocargo.setText("17");
					AgvSpd.setEnabled(false);
					AgvAccSpd.setEnabled(false);
					AgvDecSpd.setEnabled(false);
					AgvTimeGap.setEnabled(false);
					AgvDistGap.setEnabled(false);
					Agvfewcargo.setEnabled(false);
					Agvfewocargo.setEnabled(false);
				}
				if(AgvMode.getSelectedItem()=="Fast"){
					System.out.println("Be fast");
					AgvSpd.setSelectedIndex(0);
					AgvAccSpd.setSelectedIndex(0);
					AgvDecSpd.setSelectedIndex(0);
					AgvTimeGap.setSelectedIndex(0);
					AgvDistGap.setSelectedIndex(0);
					Agvfewcargo.setText("27");
					Agvfewocargo.setText("17");
					AgvSpd.setEnabled(false);
					AgvAccSpd.setEnabled(false);
					AgvDecSpd.setEnabled(false);
					AgvTimeGap.setEnabled(false);
					AgvDistGap.setEnabled(false);
					Agvfewcargo.setEnabled(false);
					Agvfewocargo.setEnabled(false);
				}	
			}
		});
		
		//RUN BUTTON EXE
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				String regex = "[0-9]+";
		
				//TRANSFER VALUE INTO constant FOR SIMULATOR USAGE
				
				//TRANSFER START TIME, END DAY AND END TIME
				String time = (String) SimuStarttime.getSelectedItem();
				constant.starthour = Integer.parseInt( time.split(":")[0] );
				constant.endday = Integer.valueOf((String) SimuEndday.getText());
				time = (String) SimuEndtime.getSelectedItem();
				constant.endhour = Integer.parseInt( time.split(":")[0] );
				
				constant.fuelcost = Double.parseDouble((String) fuelcost.getText());
				
				//TRANSFER CDC OPERATION TIME
				time = (String) CDCStart.getSelectedItem();
				constant.CDCstarth = Integer.parseInt( time.split(":")[0] );
				time = (String) CDCEnd.getSelectedItem();
				constant.CDCendh = Integer.parseInt( time.split(":")[0] );
				
				//TRANSFER FACTORY OPERATION TIME
				time = (String) FactoryStart.getSelectedItem();
				constant.Factstarth = Integer.parseInt( time.split(":")[0] );
				time = (String) FactoryEnd.getSelectedItem();
				constant.Factendh = Integer.parseInt( time.split(":")[0] );
				
				//TRANSFER CDC AND FACTORY CARGO TURNOVER
				constant.CDCcargoturnover = Integer.parseInt( (String) CDCTurnover.getSelectedItem());
				constant.Factcargoturnover = Integer.parseInt( (String) FactTurnover.getSelectedItem());
				
				//TRANSFER CDC AND FACTORY CARGO TURNOVER
				constant.CDCcargolimit = Integer.parseInt( (String) cdccargolimit.getSelectedItem());
				constant.Factcargolimit = Integer.parseInt( (String) factcargolimit.getSelectedItem());
				
				//TRANSFER CDC AND FACTORY BAY
				constant.CDCbay = Integer.parseInt( (String) CDCBay.getSelectedItem());
				constant.Factbay = Integer.parseInt( (String) FactBay.getSelectedItem());
				
				//CALCULATE AND TRANSFER DEMAND PATTERN
				constant.CDCdemandh[0] = slider.getValue();
				constant.CDCdemandh[1] = slider_1.getValue();
				constant.CDCdemandh[2] = slider_2.getValue();
				constant.CDCdemandh[3] = slider_3.getValue();
				constant.CDCdemandh[4] = slider_4.getValue();
				constant.CDCdemandh[5] = slider_5.getValue();
				constant.CDCdemandh[6] = slider_6.getValue();
				constant.CDCdemandh[7] = slider_7.getValue();
				constant.CDCdemandh[8] = slider_8.getValue();
				constant.CDCdemandh[9] = slider_9.getValue();
				constant.CDCdemandh[10] = slider_10.getValue();
				constant.CDCdemandh[11] = slider_11.getValue();
				constant.CDCdemandh[12] = slider_12.getValue();
				constant.CDCdemandh[13] = slider_13.getValue();
				constant.CDCdemandh[14] = slider_14.getValue();
				
				for(int i=0; i<15; i++){
					cdctotal = cdctotal + constant.CDCdemandh[i];
				}
				try{
					if (cdctotal==0) {
						tabbedPane.setSelectedIndex(1);
		            	tabbedPane_3.setSelectedIndex(1);
		                JOptionPane.showMessageDialog(null, "Please input the demand for CDC.");   
		                return;
		            }
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				
				constant.Factdemandh[0] = slider_16.getValue();
				constant.Factdemandh[1] = slider_17.getValue();
				constant.Factdemandh[2] = slider_18.getValue();
				constant.Factdemandh[3] = slider_19.getValue();
				constant.Factdemandh[4] = slider_20.getValue();
				constant.Factdemandh[5] = slider_21.getValue();
				constant.Factdemandh[6] = slider_22.getValue();
				constant.Factdemandh[7] = slider_23.getValue();
				constant.Factdemandh[8] = slider_24.getValue();
				constant.Factdemandh[9] = slider_25.getValue();
				constant.Factdemandh[10] = slider_26.getValue();
				constant.Factdemandh[11] = slider_27.getValue();
				constant.Factdemandh[12] = slider_28.getValue();
				constant.Factdemandh[13] = slider_29.getValue();
				constant.Factdemandh[14] = slider_30.getValue();
				
				for(int i=0; i<15; i++){
					facttotal = facttotal + constant.Factdemandh[i];
				}
				
				try{
					if (facttotal==0) {
						tabbedPane.setSelectedIndex(2);
		            	tabbedPane_1.setSelectedIndex(1);
		                JOptionPane.showMessageDialog(null, "Please input the demand for Factory.");   
		                return;
		            }
				}catch (Exception e) {
		            e.printStackTrace();
		        }

				cdccargode = Integer.valueOf(cdccargo.getText());
				factcargode = Integer.valueOf(factcargo.getText());
				
				constant.CDCdemandh[0] = (int) (((float) constant.CDCdemandh[0]/cdctotal)*cdccargode);
				constant.CDCdemandh[1] = (int) (((float) constant.CDCdemandh[1]/cdctotal)* cdccargode);
				constant.CDCdemandh[2] = (int) (((float) constant.CDCdemandh[2]/cdctotal)* cdccargode);
				constant.CDCdemandh[3] = (int) (((float) constant.CDCdemandh[3]/cdctotal)* cdccargode);
				constant.CDCdemandh[4] = (int) (((float) constant.CDCdemandh[4]/cdctotal)* cdccargode);
				constant.CDCdemandh[5] = (int) (((float) constant.CDCdemandh[5]/cdctotal)* cdccargode);
				constant.CDCdemandh[6] = (int) (((float) constant.CDCdemandh[6]/cdctotal)* cdccargode);
				constant.CDCdemandh[7] = (int) (((float) constant.CDCdemandh[7]/cdctotal)* cdccargode);
				constant.CDCdemandh[8] = (int) (((float) constant.CDCdemandh[8]/cdctotal)* cdccargode);
				constant.CDCdemandh[9] = (int) (((float) constant.CDCdemandh[9]/cdctotal)* cdccargode);
				constant.CDCdemandh[10] = (int) (((float) constant.CDCdemandh[10]/cdctotal)* cdccargode);
				constant.CDCdemandh[11] = (int) (((float) constant.CDCdemandh[11]/cdctotal)* cdccargode);
				constant.CDCdemandh[12] = (int) (((float) constant.CDCdemandh[12]/cdctotal)* cdccargode);
				constant.CDCdemandh[13] = (int) (((float) constant.CDCdemandh[13]/cdctotal)* cdccargode);
				constant.CDCdemandh[14] = (int) (((float) constant.CDCdemandh[14]/cdctotal)* cdccargode);
					
				constant.Factdemandh[0] = (int) (((float) constant.Factdemandh[0]/facttotal)* factcargode);
				constant.Factdemandh[1] = (int) (((float) constant.Factdemandh[1]/facttotal)* factcargode);
				constant.Factdemandh[2] = (int) (((float) constant.Factdemandh[2]/facttotal)* factcargode);
				constant.Factdemandh[3] = (int) (((float) constant.Factdemandh[3]/facttotal)* factcargode);
				constant.Factdemandh[4] = (int) (((float) constant.Factdemandh[4]/facttotal)* factcargode);
				constant.Factdemandh[5] = (int) (((float) constant.Factdemandh[5]/facttotal)* factcargode);
				constant.Factdemandh[6] = (int) (((float) constant.Factdemandh[6]/facttotal)* factcargode);
				constant.Factdemandh[7] = (int) (((float) constant.Factdemandh[7]/facttotal)* factcargode);
				constant.Factdemandh[8] = (int) (((float) constant.Factdemandh[8]/facttotal)* factcargode);
				constant.Factdemandh[9] = (int) (((float) constant.Factdemandh[9]/facttotal)* factcargode);
				constant.Factdemandh[10] = (int) (((float) constant.Factdemandh[10]/facttotal)* factcargode);
				constant.Factdemandh[11] = (int) (((float) constant.Factdemandh[11]/facttotal)* factcargode);
				constant.Factdemandh[12] = (int) (((float) constant.Factdemandh[12]/facttotal)* factcargode);
				constant.Factdemandh[13] = (int) (((float) constant.Factdemandh[13]/facttotal)* factcargode);
				constant.Factdemandh[14] = (int) (((float) constant.Factdemandh[14]/facttotal)* factcargode);
		
				//VALIDATOR FOR AT LEAST ONE FORM OF TRANSPORTATION
				if(chckbxEnableTruckOperation.isSelected() == false){
					if(chckbxEnableAgvOperation.isSelected() == false){
						tabbedPane.setSelectedIndex(3);
						JOptionPane.showMessageDialog(null, "Please select at least one mode of transportation.");
						return;
					}
				}
				
				//TRANSFER TRUCK VARIABLES
				constant.TruckMode = chckbxEnableTruckOperation.isSelected();
				if(chckbxEnableTruckOperation.isSelected()==true){
					
					try {
			            String data = Truckfewcargo.getText();
			            if (!data.matches(regex)) {
			            	tabbedPane.setSelectedIndex(3);
			                JOptionPane.showMessageDialog(null, "Please enter digits only for Truck fuel efficiency.");   
			                return;
			            }
			            data = Truckfewocargo.getText();
			            if (!data.matches(regex)) {
			            	tabbedPane.setSelectedIndex(3);
			                JOptionPane.showMessageDialog(null, "Please enter digits only for Truck fuel efficiency.");   
			                return;
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
					
					constant.TruckQty = Integer.valueOf((String) TruckQty.getSelectedItem());
					constant.TruckSpd = Double.parseDouble((String) TruckSpd.getSelectedItem());
					constant.TruckAccSpd = Double.parseDouble((String) TruckAccSpd.getSelectedItem());
					constant.TruckDecSpd = Double.parseDouble((String) TruckDecSpd.getSelectedItem());
					constant.TruckTimeGap = Double.parseDouble((String) TruckTimeGap.getSelectedItem());
					constant.TruckDistGap = Double.parseDouble((String) TruckDistGap.getSelectedItem());
					constant.TruckPoliteness = Double.parseDouble((String) TruckPolite.getSelectedItem());
					constant.TruckChanging = Double.parseDouble((String) TruckChanging.getSelectedItem());
					constant.Truckfewcargo = Double.parseDouble((String) Truckfewcargo.getText());
					constant.Truckfewocargo = Double.parseDouble((String) Truckfewocargo.getText());
					
					/*//TEST PURPOSE
					System.out.println(constant.TruckMode);
					System.out.println(constant.TruckQty);
					System.out.println(constant.TruckSpd);
					System.out.println(constant.TruckAccSpd);
					System.out.println(constant.TruckDecSpd);
					System.out.println(constant.TruckTimeGap);
					System.out.println(constant.TruckDistGap);
					System.out.println(constant.TruckPoliteness);
					System.out.println(constant.TruckChanging);
					*/
				}
				
					
				constant.AgvMode = chckbxEnableAgvOperation.isSelected();
				if(chckbxEnableAgvOperation.isSelected()==true){
					
					try {
			            String data = Agvfewcargo.getText();
			            if (!data.matches(regex)) {
			            	tabbedPane.setSelectedIndex(4);
			                JOptionPane.showMessageDialog(null, "Please enter digits only for AGV fuel efficiency.");   
			                return;
			            }
			            data = Agvfewocargo.getText();
			            if (!data.matches(regex)) {
			            	tabbedPane.setSelectedIndex(4);
			                JOptionPane.showMessageDialog(null, "Please enter digits only for AGV fuel efficiency.");   
			                return;
			            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
					
					constant.AgvQty = Integer.valueOf((String) AgvQty.getSelectedItem());
					constant.AgvSpd = Double.parseDouble((String) AgvSpd.getSelectedItem());
					constant.AgvAccSpd = Double.parseDouble((String) AgvAccSpd.getSelectedItem());
					constant.AgvDecSpd = Double.parseDouble((String) AgvDecSpd.getSelectedItem());
					constant.AgvTimeGap = Double.parseDouble((String) AgvTimeGap.getSelectedItem());
					constant.AgvDistGap = Double.parseDouble((String) AgvDistGap.getSelectedItem());
					constant.Agvfewcargo = Double.parseDouble((String) Agvfewcargo.getText());
					constant.Agvfewocargo = Double.parseDouble((String) Agvfewocargo.getText());

					/*TEST PURPOSE
					System.out.println(constant.AgvMode);
					System.out.println(constant.AgvQty);
					System.out.println(constant.AgvSpd);
					System.out.println(constant.AgvAccSpd);
					System.out.println(constant.AgvDecSpd);
					System.out.println(constant.AgvTimeGap);
					System.out.println(constant.AgvDistGap);
					*/
				}
				
				if(chckbxEnableAgvOperation.isSelected()==true && chckbxEnableTruckOperation.isSelected()==true){
					if(chckbxPriorityOverAgv.isSelected()==true)
						constant.Truckpriority = true;
					if(chckbxPriorityOverTruck.isSelected()==true)
						constant.Truckpriority = false;
				}
				
				System.out.println("Be patient, we are starting soon!");
				
				//KILL CURRRENT WINDOW AND CALL FOR THE NEXT WINDOW
				setVisible(false);
				dispose();
				SimulatorWindow frame = new SimulatorWindow();
				frame.setVisible(true);	
			}

			
		});
		
		//RESET BUTTON EXECUTION;
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
				dispose();
				StartUI frame = new StartUI();
				frame.setVisible(true);
			}
		});
		
		//Exit button
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JFrame frame = null;
				int n = JOptionPane.showConfirmDialog(
					    frame,
					    "Are you sure you want to quit the Simulation?",
					    "Wenya Industrial Simulator",
					    JOptionPane.YES_NO_OPTION);
				
				if(n == JOptionPane.YES_OPTION){
					setVisible(false);
					dispose();
				}	
			}
		});
		
		SimuEndday.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		char c = arg0.getKeyChar();
        		if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        			arg0.consume();
	                JOptionPane.showMessageDialog(null, "Please enter digits only for End Day.");  
        		}
        	}
        });
	}
	
	//SET ENABLED FOR PANEL COMPONENTS
	public void enableComponents(Container container, boolean state) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(state);
            if (component instanceof Container) {
                enableComponents((Container)component, state);
            }
        }
    }
}
