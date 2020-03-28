package kk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class 功能选择1 extends JFrame {

	private JPanel contentPane;
	public JButton btn_bumen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					功能选择1 frame = new 功能选择1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 功能选择1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u529F\u80FD\u9009\u62E9\u754C\u9762");
		label.setForeground(new Color(176, 196, 222));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label.setBounds(10, 10, 277, 42);
		contentPane.add(label);
		
		btn_bumen = new JButton("\u90E8\u95E8\u7BA1\u7406");
		btn_bumen.setEnabled(false);
	
		btn_bumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_bumen.setBounds(10, 79, 277, 35);
		contentPane.add(btn_bumen);
		
		
		
		JButton btn_guanli = new JButton("\u7BA1\u7406\u5458\u7BA1\u7406");
		btn_guanli.setEnabled(false);
		
		btn_guanli.setBounds(10, 124, 277, 35);
		contentPane.add(btn_guanli);
		
		JButton btn_yuangong = new JButton("\u5458\u5DE5\u7BA1\u7406");
		btn_yuangong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                          //员工
				员工1 f3 = new 员工1();
				f3.setVisible(true);
			}
		});
		btn_yuangong.setBounds(10, 169, 277, 35);
		contentPane.add(btn_yuangong);
		
		JButton btn_kaoqin = new JButton("\u8003\u52E4");
		btn_kaoqin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                          //考勤
				考勤1 f4 = new 考勤1();
				f4.setVisible(true);
			}
		});
		btn_kaoqin.setBounds(10, 214, 277, 35);
		contentPane.add(btn_kaoqin);

	}

}
