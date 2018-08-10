package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GUI implements ActionListener {
	
	private JFrame promptFrame;
	private JPanel promptPanel;
	private JButton semaphore, locks;
	
	private JFrame calTrain, simController;
	private JPanel container, controller;
	private JPanel trainCont;
	private JPanel stn1Panel, stn2Panel, stn3Panel,stn4Panel, stn5Panel, stn6Panel, stn7Panel,stn8Panel, railroad;
	private JTextArea console;
	private JScrollPane scroll;
	private JButton addPsngr;
	private JComboBox<String> from;
        private JComboBox<String> to;
	private String[] stations = new String[] {"Station 1", "Station 2", "Station 3", "Station 4","Station 5", "Station 6", "Station 7", "Station 8"};
	int trainX = -200; // initial -200
	JLabel trainCount, st1Count, st2Count, st3Count, st4Count,st5Count, st6Count, st7Count, st8Count;
	int mode; // semaphore = 0, locks = 1;
	
	public void start() {
		initEngine();
		initController();
		initPrompt();
		calTrain.repaint();
		simController.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addPsngr) {
			int x = 0;
                        int y = 0;
			String PsngrFrom = from.getSelectedItem().toString();
                        
			if (PsngrFrom.equals("Station 1"))
				x = 0;
			if (PsngrFrom.equals("Station 2"))
				x = 1;
			if (PsngrFrom.equals("Station 3"))
				x = 2;
			if (PsngrFrom.equals("Station 4"))
				x = 3;
			if (PsngrFrom.equals("Station 5"))
				x = 4;
			if (PsngrFrom.equals("Station 6"))
				x = 5;
			if (PsngrFrom.equals("Station 7"))
				x = 6;
			if (PsngrFrom.equals("Station 8"))
				x = 7;
                        
                        String PsngrTo = to.getSelectedItem().toString();
			if (PsngrTo.equals("Station 1"))
				y = 0;
			if (PsngrTo.equals("Station 2"))
				y = 1;
			if (PsngrTo.equals("Station 3"))
				y = 2;
			if (PsngrTo.equals("Station 4"))
				y = 3;
			if (PsngrTo.equals("Station 5"))
				y = 4;
			if (PsngrTo.equals("Station 6"))
				y = 5;
			if (PsngrTo.equals("Station 7"))
				y = 6;
			if (PsngrTo.equals("Station 8"))
				y = 7;
                        
			console.append("New Passenger Arrived at " + PsngrFrom + "\n");
			controller.repaint();
			
			// add new Passenger()
			if (mode == 0)
				Semaphore.Driver.addPassenger(x,y);
			else if (mode == 1)
				LocksAndMonitors.Driver.addPassenger(x,y);
		}
		
		if (e.getSource() == semaphore) {
			promptFrame.dispose();
			mode = 0;
			Semaphore.Driver.start(this);
		}
		
		if (e.getSource() == locks) {
			promptFrame.dispose();
			mode = 1;
			LocksAndMonitors.Driver.start(this);
		}
	}
	
	public void initPrompt() {
		promptFrame = new JFrame("Choose Mode");
		promptFrame.setSize(1000, 200);
		promptFrame.setVisible(true);
		promptFrame.setResizable(false);
		promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		promptFrame.setFocusable(true);
		
		promptPanel = new JPanel();
		promptFrame.add(promptPanel);
		promptPanel.setLayout(null);
		promptPanel.setBackground(Color.WHITE);
		
		semaphore = new JButton("Semaphore Codes");
		semaphore.addActionListener(this);
		semaphore.setVisible(true);
		semaphore.setBounds(40, 30, 200, 50);
		semaphore.setBackground(Color.WHITE);
		promptPanel.add(semaphore);
		
		locks = new JButton("Locks/Monitors Codes");
		locks.addActionListener(this);
		locks.setVisible(true);
		locks.setBounds(40, 90, 200, 50);
		locks.setBackground(Color.WHITE);
		promptPanel.add(locks);
	}
	
	public void initEngine() {
		calTrain = new JFrame("CalTrain");
		calTrain.setSize(2500, 300);
		calTrain.setVisible(true);
		calTrain.setResizable(true);
		calTrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = new JPanel();
		calTrain.add(container);
		container.setLayout(null);
		container.setBackground(Color.WHITE);
		
		stn1Panel = new JPanel();
		container.add(stn1Panel);
		stn1Panel.setLayout(null);
		stn1Panel.setBounds(20, 30, 200, 100);
		stn1Panel.setBackground(Color.WHITE);
		stn1Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 1"));
		stn1Panel.setVisible(true);
		
		st1Count = new JLabel("0", JLabel.CENTER);
		st1Count.setBounds(35, 20, 132, 70);
		st1Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st1Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn1Panel.add(st1Count);
		
		stn2Panel = new JPanel();
		container.add(stn2Panel);
		stn2Panel.setLayout(null);
		stn2Panel.setBounds(230, 30, 200, 100);
		stn2Panel.setBackground(Color.WHITE);
		stn2Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 2"));
		stn2Panel.setVisible(true);
		
		st2Count = new JLabel("0", JLabel.CENTER);
		st2Count.setBounds(35, 20, 132, 70);
		st2Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st2Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn2Panel.add(st2Count);
		
		stn3Panel = new JPanel();
		container.add(stn3Panel);
		stn3Panel.setLayout(null);
		stn3Panel.setBounds(440, 30, 200, 100);
		stn3Panel.setBackground(Color.WHITE);
		stn3Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 3"));
		stn3Panel.setVisible(true);
		
		st3Count = new JLabel("0", JLabel.CENTER);
		st3Count.setBounds(35, 20, 132, 70);
		st3Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st3Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn3Panel.add(st3Count);
		
		stn4Panel = new JPanel();
		container.add(stn4Panel);
		stn4Panel.setLayout(null);
		stn4Panel.setBounds(650, 30, 200, 100);
		stn4Panel.setBackground(Color.WHITE);
		stn4Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 4"));
		stn4Panel.setVisible(true);
		
		st4Count = new JLabel("0", JLabel.CENTER);
		st4Count.setBounds(35, 20, 132, 70);
		st4Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st4Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn4Panel.add(st4Count);
		
		stn4Panel = new JPanel();
		container.add(stn4Panel);
		stn4Panel.setLayout(null);
		stn4Panel.setBounds(650, 30, 200, 100);
		stn4Panel.setBackground(Color.WHITE);
		stn4Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 4"));
		stn4Panel.setVisible(true);
		
		st4Count = new JLabel("0", JLabel.CENTER);
		st4Count.setBounds(35, 20, 132, 70);
		st4Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st4Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn4Panel.add(st4Count);
		
		stn5Panel = new JPanel();
		container.add(stn5Panel);
		stn5Panel.setLayout(null);
		stn5Panel.setBounds(860, 30, 200, 100);
		stn5Panel.setBackground(Color.WHITE);
		stn5Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 5"));
		stn5Panel.setVisible(true);
		
		st5Count = new JLabel("0", JLabel.CENTER);
		st5Count.setBounds(35, 20, 132, 70);
		st5Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st5Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn5Panel.add(st5Count);
		
		stn6Panel = new JPanel();
		container.add(stn6Panel);
		stn6Panel.setLayout(null);
		stn6Panel.setBounds(1070, 30, 200, 100);
		stn6Panel.setBackground(Color.WHITE);
		stn6Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 6"));
		stn6Panel.setVisible(true);
		
		st6Count = new JLabel("0", JLabel.CENTER);
		st6Count.setBounds(35, 20, 132, 70);
		st6Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st6Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn6Panel.add(st6Count);
		
		stn7Panel = new JPanel();
		container.add(stn7Panel);
		stn7Panel.setLayout(null);
		stn7Panel.setBounds(1280, 30, 200, 100);
		stn7Panel.setBackground(Color.WHITE);
		stn7Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 7"));
		stn7Panel.setVisible(true);
		
		st7Count = new JLabel("0", JLabel.CENTER);
		st7Count.setBounds(35, 20, 132, 70);
		st7Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st7Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn7Panel.add(st7Count);
		
		stn8Panel = new JPanel();
		container.add(stn8Panel);
		stn8Panel.setLayout(null);
		stn8Panel.setBounds(1490, 30, 200, 100);
		stn8Panel.setBackground(Color.WHITE);
		stn8Panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Station 8"));
		stn8Panel.setVisible(true);
		
		st8Count = new JLabel("0", JLabel.CENTER);
		st8Count.setBounds(35, 20, 132, 70);
		st8Count.setFont(new Font("Trebuchet MS", Font.BOLD, 52));
		st8Count.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Waiting Passengers"));
		stn8Panel.add(st8Count);
		
		
		trainCont = new JPanel();
		trainCont.setLayout(null);
		trainCont.setBounds(trainX, 150, 200, 100);
		trainCont.setBackground(Color.WHITE);
		trainCont.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		trainCont.setVisible(true);
		container.add(trainCont);
		
		trainCount = new JLabel("10", JLabel.CENTER);
		trainCount.setBounds(50, 5, 105, 90);
		trainCount.setFont(new Font("Trebuchet MS", Font.BOLD, 69));
		trainCount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "Available Seats"));
		trainCont.add(trainCount);
	
		JLabel bg = new JLabel(new ImageIcon(this.getClass().getResource("/res/railroad.jpg")));
		bg.setVisible(true);
		bg.setBounds(0, 0, 1100, 100);
		
		
		railroad = new JPanel();
		container.add(railroad);
		railroad.setLayout(null);
		railroad.setBounds(0, 150, 980, 100);
		railroad.add(bg);
		railroad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		railroad.setVisible(true);

	}
	
	public void initController() {
		simController = new JFrame("Simulation Controller");
		simController.setSize(2000, 250);
		simController.setVisible(true);
		simController.setResizable(false);
		simController.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		controller = new JPanel();
		simController.add(controller);
		controller.setLayout(null);
		controller.setBounds(75, 480, 800, 200);
		controller.setBackground(Color.WHITE);
		controller.setVisible(true);
		
		JLabel fromLbl = new JLabel("From");
		fromLbl.setVisible(true);
		fromLbl.setBounds(50, 50, 150, 40);
		controller.add(fromLbl);
               
		from = new JComboBox<>(stations);
		from.setBounds(90, 50, 150, 40);
		from.setVisible(true);
		from.setBackground(Color.WHITE);
		controller.add(from);
                
                JLabel toLbl = new JLabel("To");
                toLbl.setVisible(true);
                toLbl.setBounds(50, 100, 150, 40);
                controller.add(toLbl);
                
                to = new JComboBox<>(stations);
		to.setBounds(90, 100, 150, 40);
		to.setVisible(true);
		to.setBackground(Color.WHITE);
		controller.add(to);
               
                
		addPsngr = new JButton("Add Passenger");
		addPsngr.addActionListener(this);
		addPsngr.setVisible(true);
		addPsngr.setBounds(50, 150, 200, 50);
		addPsngr.setBackground(Color.WHITE);
		controller.add(addPsngr);
		
		console = new JTextArea("CalTrain Booted...\n");
		controller.add(console);
		console.setBounds(300, 20, 450, 180);
		console.setVisible(true);
		console.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		console.setEditable(false);
	    console.setVisible(true);
	    console.setLineWrap(true);
	    console.setWrapStyleWord(true);
	     
	    scroll = new JScrollPane(console);
	    scroll.setBounds(300, 20, 450, 180);
	    scroll.setBorder(BorderFactory.createLineBorder(Color.black));
	    controller.add(scroll);
	    controller.repaint();
	}
	
	
	
	
	/* --------------- A C T I O N S ------------------ */
	
	public void appendConsole(String text) {
		console.append(text + "\n");
		console.repaint();
		simController.repaint();
	}
	
	public void updateStation(int station, int count) {
		switch (station) {
		case 0: st1Count.setText(count + ""); break;
		case 1: st2Count.setText(count + ""); break;
		case 2:	st3Count.setText(count + ""); break;
		case 3:	st4Count.setText(count + ""); break;
		case 4: st5Count.setText(count + ""); break;
		case 5: st6Count.setText(count + ""); break;
		case 6:	st7Count.setText(count + ""); break;
		case 7:	st8Count.setText(count + ""); break;
		}
	}
	
	public void updateTrain (int count) {
		trainCount.setText(count + "");
	}
	
	public void goStation1() {
		while(trainX != 20) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	
	public void goStation2() {
		while(trainX != 230) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	public void goStation3() {
		while(trainX != 440) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	public void goStation4() {
		while(trainX != 650) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
		
	public void goStation5() {
		while(trainX != 860) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
		
	public void goStation6() {
		while(trainX != 1070) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	public void goStation7() {
		while(trainX != 1280) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	public void goStation8() {
		while(trainX != 1490) {
			trainX++;
			trainCont.setBounds(trainX, 150, 200, 100);
			trainCont.repaint();
		 try {
		      Thread.sleep(10);
		    } catch (InterruptedException e) {
		    }
		}
	}
	
	

	
	
	
	
	public void goToDestination() {
		trainCont.setBounds(-200, 150, 200, 100);
		trainX = -200;
		trainCont.repaint();
	}
}
