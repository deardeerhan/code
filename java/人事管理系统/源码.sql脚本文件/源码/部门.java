package kk;

import java.awt.BorderLayout;

import java.sql.*;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class 部门 extends JFrame {

	private JPanel contentPane;
	private JTextField condition1;
	private JTextField textField_1;
	private JTextField condition3;
	private JTextField condition2;
	private JTextArea print;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					部门 frame = new 部门();
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
	public String select(String sno) {
        Connection connection = null;
        Statement stmt = null;
        String str ="";
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //3.创建语句对象
            stmt = connection.createStatement();
            //4.执行
            String sql = "select * from section where sno="+sno;
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Integer col1 = rs.getInt("sno");
                String col2 = rs.getString("sname");
                String col3 = rs.getString("smanager");
                str = "部门号\t" + col1 + " 部门名\t" + col2 + " 经理\t" + col3;
                
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

	public void update(String smanager,int sno){
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //4.执行
            String sql1 = "update section set smanager=? where sno="+sno;
            stmt = connection.prepareStatement(sql1);
            stmt.setObject(1,smanager);
            stmt.executeUpdate();
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
	
	
	public void delete(int sno){
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //4.执行
            String sql = "delete from section where sno="+sno;
            stmt = connection.prepareStatement(sql);
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
	public 部门() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u90E8\u95E8\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(10, 10, 595, 45);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u67E5\u8BE2");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(10, 46, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F93\u5165\u90E8\u95E8\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(20, 71, 104, 15);
		contentPane.add(label_2);
		
		condition1 = new JTextField();
		condition1.setBounds(134, 68, 66, 21);
		contentPane.add(condition1);
		condition1.setColumns(10);
		
		JButton btn_select = new JButton("\u67E5\u8BE2");
	      
		btn_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {           // 查询一个
				if(Integer.parseInt(condition1.getText())<=5 ){
					 部门 b =new 部门();
					 String s = b.select(condition1.getText());
					print.append(s+"\n");
				}
				else {
					操作提示 c =new 操作提示();
					c.setVisible(true);
				}
				
				
			}
		});
		btn_select.setBounds(210, 67, 93, 23);
		contentPane.add(btn_select);
		
		JLabel label_3 = new JLabel("\u4FEE\u6539");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(10, 244, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("新的管理人");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(20, 305, 83, 15);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 302, 169, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btn_updata = new JButton("\u4FEE\u6539");
		btn_updata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                 //修改
				
				if(Integer.parseInt(condition2.getText())<=5 ) {
					部门 b1 =new 部门();
					b1.update(textField_1.getText(),Integer.parseInt(condition2.getText()));
					
				操作提示 c1 =new 操作提示();
				c1.setVisible(true);
				}
				else {
					操作提示1 c11 =new 操作提示1();
					c11.setVisible(true);
				}
				
			}
		});
		btn_updata.setBounds(335, 304, 93, 23);
		contentPane.add(btn_updata);
		
		JLabel label_5 = new JLabel("\u5220\u9664");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(10, 333, 54, 15);
		contentPane.add(label_5);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u90E8\u95E8\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 358, 104, 15);
		contentPane.add(lblNewLabel);
		
		condition3 = new JTextField();
		condition3.setBounds(134, 355, 169, 21);
		contentPane.add(condition3);
		condition3.setColumns(10);
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                       //删除
				
				if(Integer.parseInt(condition3.getText())<=5) {
					部门 b2 =new 部门();
					b2.delete(Integer.parseInt(condition3.getText()));
					操作提示 c2 =new 操作提示();
					c2.setVisible(true);
					}
					else {
						操作提示1 c12 =new 操作提示1();
						c12.setVisible(true);
					}
			}
		});
		btn_delete.setBounds(335, 354, 93, 23);
		contentPane.add(btn_delete);
		
		JLabel label_6 = new JLabel("\u8F93\u5165\u90E8\u95E8\u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(20, 274, 104, 15);
		contentPane.add(label_6);
		
		condition2 = new JTextField();
		condition2.setText("");
		condition2.setBounds(134, 271, 66, 21);
		contentPane.add(condition2);
		condition2.setColumns(10);
		
		JButton button_3 = new JButton("");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//返回
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(部门.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		button_3.setBounds(20, 8, 34, 28);
		contentPane.add(button_3);
		
		print = new JTextArea();
		print.setEnabled(false);
		print.setBounds(99, 96, 434, 154);
		contentPane.add(print);
	}
}
