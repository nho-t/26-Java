package day14;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import java.awt.*;

public class MouseListenerEx extends JFrame {
	
	JLabel lb;
	
	public MouseListenerEx() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		lb = new JLabel("안녕하세요");
		lb.setLocation(30, 30);
		lb.setSize(50, 20);
		
		con.add(lb);
		
		con.addMouseMotionListener(new MyMouseListener2());
		setSize(400, 400);
		setVisible(true);
		setTitle(lb.getText());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MouseListenerEx();

	}
	
	class MyMouseListener2 extends MouseMotionAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			lb.setText("MouseDragged (" +e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			lb.setText("MouseMoved (" +e.getX()+","+e.getY()+")");
		}
	}
}