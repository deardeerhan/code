package kk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ա��1 extends JFrame {

	private JPanel contentPane;
	private JTextField condition1;
	private JTextArea print;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ա��1 frame = new Ա��1();
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
	public String select(int jno) {
        Connection connection = null;
        Statement stmt = null;
        String str ="";
        try {
            //1.��������
            Class.forName("com.mysql.jdbc.Driver");
            //2.��ȡ����
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //3.����������
            stmt = connection.createStatement();
            //4.ִ��
            String sql = "select * from employee where jno="+jno;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Integer col1 = rs.getInt("jno");
                String col2 = rs.getString("name");
                String col3 = rs.getString("sex");
                String col4 = rs.getString("position");
                Integer col5 = rs.getInt("salary");
                String col6 = rs.getString("tel");
                str = "���ţ�" + col1 + " ������" + col2 + " �Ա�" + col3 + " ְλ��" + col4 + " ���ʣ�" + col5 + " �绰��" + col6;
           
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.�ر���Դ
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
	public Ա��1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5458\u5DE5\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 24));
		label.setBounds(10, 0, 447, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u67E5\u8BE2");
		label_1.setFont(new Font("����", Font.PLAIN, 16));
		label_1.setBounds(20, 35, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(30, 60, 71, 15);
		contentPane.add(label_2);
		
		condition1 = new JTextField();
		condition1.setText("");
		condition1.setBounds(103, 56, 202, 21);
		contentPane.add(condition1);
		condition1.setColumns(10);
		
		JButton btn_select = new JButton("\u67E5\u8BE2");
		btn_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                     //��ѯһ��
				if(Integer.parseInt(condition1.getText())<=105&&Integer.parseInt(condition1.getText())>=101 ){
					 Ա�� b =new Ա��();
					 String s = b.select(Integer.parseInt(condition1.getText()));
					print.append(s+"\n");
				}
				else {
					������ʾ c =new ������ʾ();
					c.setVisible(true);
				}
			} 
		});
		btn_select.setFont(new Font("����", Font.PLAIN, 14));
		btn_select.setBounds(347, 56, 93, 23);
		contentPane.add(btn_select);
		
		JButton btn_return = new JButton("");
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//����
				dispose();			}
		});
		btn_return.setIcon(new ImageIcon(Ա��.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btn_return.setBounds(0, 0, 34, 25);
		contentPane.add(btn_return);
		
		print = new JTextArea();
		print.setBounds(30, 85, 410, 95);
		contentPane.add(print);
	}

}
