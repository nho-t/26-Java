package day13;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;


public class MyFrame2 extends JFrame {
	
	// 생성자
	public MyFrame2() {
		this.setTitle("나만의 프레임 생성 ");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contain = getContentPane();
		contain.setBackground(Color.ORANGE); // 배경색 설정
		contain.setLayout(new FlowLayout()); // 배치관리자 설정
		
		JButton btn1 = new JButton("확인"); // 컴포넌트 생성
		JButton btn2 = new JButton("취소");
		JButton btn3 = new JButton("무시");
		
		contain.add(btn1); 
		contain.add(btn2);
		contain.add(btn3);
		
		// 배치 관리자 대표 유형 4가지 - 시험 출제, BorderLayout 한번 더 언급
		// 컨테이너와 배치 관리자 - 컨테이너의 디폴트 배치관리자 시험 출제 - 배치를 바꾸고자 할 때, setLayout 한번 더 언급 
		
	}

	public static void main(String[] args) {
		MyFrame2 mf2 = new MyFrame2();

		
	}

}
