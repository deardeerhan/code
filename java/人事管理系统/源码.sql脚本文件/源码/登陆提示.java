package kk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 登陆提示 extends JFrame {
	
	private JPanel contentPane;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					登陆提示 frame = new 登陆提示();
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
	public 登陆提示() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u6709\u8BEF\u6216\u672A\u52FE\u9009\u8EAB\u4EFD");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 26, 224, 15);
		contentPane.add(label);
		
		button = new JButton("\u597D\u7684\uFF01");
		button.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				/*登陆提示 f1 = new 登陆提示();
				f1.setVisible(false);*/
				dispose();			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(71, 72, 93, 23);
		contentPane.add(button);
	}
}
