package org.park.javadesignpattern.uday.command.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.park.javadesignpattern.uday.command.ColorCommand;
import org.park.javadesignpattern.uday.command.Command;
import org.park.javadesignpattern.uday.command.DrawCanvas;
import org.park.javadesignpattern.uday.command.DrawCommand;
import org.park.javadesignpattern.uday.command.MacroCommand;

public class U_Main extends JFrame implements ActionListener,
		MouseMotionListener, WindowListener {
	// �׸� �׸� �̷�
	private MacroCommand history = new MacroCommand();
	
	// �׸� �׸��� ����
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);

	//  �� ��ü 
	private ColorCommand colorChanger = new ColorCommand(canvas);
	
	// �� ��ü��ư
	private JButton colorChangerButton = new JButton("Color Change");
	
	// ������ �� ����� ��ư
	private JButton undoButton = new JButton("undo");
	
	// ���� ��ư
	private JButton clearButton = new JButton("clear");
	
	// ������
	public U_Main(String title) {
		super(title);
		
		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);
		colorChangerButton.addActionListener(this);
		undoButton.addActionListener(this);

		
		Box buttonBox = new Box(BoxLayout.X_AXIS); 
		buttonBox.add(clearButton);
		buttonBox.add(colorChangerButton);
		buttonBox.add(undoButton);

		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		show();
	}
	
	// ActionListener��
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clearButton){
			history.clear();
			canvas.repaint();
		}else if(e.getSource() == colorChangerButton){
			colorChanger.execute();
			canvas.repaint();
		}else if(e.getSource() == undoButton){
			history.undo();
			canvas.repaint();
		}
	}

	// MouseMotionListener��
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}
	
	// WindowListener��
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}	
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}

	
	public static void main(String[] args) {
		new U_Main("Command Pattern Sample");

	}

}
