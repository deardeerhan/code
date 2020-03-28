package kk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class 考勤 extends JFrame {

	private JPanel contentPane;
	private JTextArea print;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					考勤 frame = new 考勤();
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
	public void insert(int jno){
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //4.执行
            String sql = "insert into worktime values(?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,jno);
            stmt.setString(2,"2019-1-3 8:00:00");
            stmt.setString(3,"2019-1-3 18:00:00");
            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
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
    }
	
	 public String select(int jno){
	        Connection connection = null;
	        Statement stmt = null;
	        String str="";
	        try {
	            //1.加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            //2.获取连接
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
	            //3.创建语句对象
	            stmt = connection.createStatement();
	            //4.执行
	            String sql = "select * from worktime where jno="+jno;
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	                Integer col1 = rs.getInt("jno");
	                String col2 = rs.getString("signin_time");
	                String col3 = rs.getString("signout_time");
	                str = "工号：" + col1 + " 签到时间：" + col2 +"\n"+ "         签退时间：" + col3;
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            //5.关闭资源
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
	public 考勤() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//返回
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(考勤.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		button_1.setBounds(10, 0, 36, 31);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u8003\u52E4");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(10, 10, 414, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BB0\u5F55\u8003\u52E4\u65F6\u95F4");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(20, 41, 112, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u65F6\u95F4\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(30, 69, 162, 15);
		contentPane.add(label_2);
		
		JButton btn_set = new JButton("\u8BBE\u5B9A");
		btn_set.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                //设定时间
				if(Integer.parseInt(textField.getText())<=105&&Integer.parseInt(textField.getText())>=100) {
					考勤 b1 =new 考勤();
					b1.insert(Integer.parseInt(textField.getText()));
					
				操作提示 c1 =new 操作提示();
				c1.setVisible(true);
				}
				else {
					操作提示1 c11 =new 操作提示1();
					c11.setVisible(true);
				}
			}
		});
		btn_set.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_set.setBounds(331, 66, 93, 23);
		contentPane.add(btn_set);
		
		JLabel label_3 = new JLabel("\u67E5\u8BE2\u5458\u5DE5\u8003\u52E4\u4FE1\u606F");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(10, 125, 171, 15);
		contentPane.add(label_3);
		
		JButton btn_select = new JButton("\u67E5\u8BE2");
		btn_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {              //查询textField_1
				if(Integer.parseInt(textField_1.getText())<=105&&Integer.parseInt(textField_1.getText())>=100 ){
					 考勤 b =new 考勤();
					 String s = b.select(Integer.parseInt(textField_1.getText()));
					print.append(s+"\n");
				}
				else {
					操作提示 c =new 操作提示();
					c.setVisible(true);
				}
			}
		});
		btn_select.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_select.setBounds(331, 122, 93, 23);
		contentPane.add(btn_select);
		
		print = new JTextArea();
		print.setFont(new Font("宋体", Font.PLAIN, 13));
		print.setBounds(20, 163, 394, 119);
		contentPane.add(print);
		
		textField = new JTextField();
		textField.setBounds(137, 65, 171, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 121, 144, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
