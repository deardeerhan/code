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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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

public class 员工 extends JFrame {

	private JPanel contentPane;
	private JTextField condition1;
	private JTextField condition2;
	private JTextField condition3;
	private JTextField condition4;
	private JTextArea print;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					员工 frame = new 员工();
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
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
            //3.创建语句对象
            stmt = connection.createStatement();
            //4.执行
            String sql = "select * from employee where jno="+jno;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Integer col1 = rs.getInt("jno");
                String col2 = rs.getString("name");
                String col3 = rs.getString("sex");
                String col4 = rs.getString("position");
                Integer col5 = rs.getInt("salary");
                String col6 = rs.getString("tel");
                str = "工号：" + col1 + " 姓名：" + col2 + " 性别：" + col3 + " 职位：" + col4 + " 工资：" + col5 + " 电话：" + col6;
           
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
	
	  public void update(int jno,String position){
	        Scanner scan = new Scanner(System.in);
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        try {
	            //1.加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            //2.获取连接
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
	            //4.执行
	            String sql1 = "update employee set position=? where jno="+jno;
	            stmt = connection.prepareStatement(sql1);
	            stmt.setString(1,position);
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
	  public void update2(int jno,int salary){
	        Scanner scan = new Scanner(System.in);
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        try {
	            //1.加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            //2.获取连接
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
	            //4.执行
	            String sql1 = "update employee set salary=? where jno="+jno;
	            stmt = connection.prepareStatement(sql1);
	            stmt.setInt(1,salary);
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
	  public void update3(int jno,String tel){
	        Scanner scan = new Scanner(System.in);
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        try {
	            //1.加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            //2.获取连接
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
	            //4.执行
	            String sql1 = "update employee set tel=? where jno="+jno;
	            stmt = connection.prepareStatement(sql1);
	            stmt.setString(1,tel);
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
	  
	  
	  public void delete(int jno){
	        Scanner scan = new Scanner(System.in);
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        try {
	            //1.加载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	            //2.获取连接
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/personalSystem?useSSL=false", "root", "");
	            //4.执行
	            String sql = "delete from employee where jno="+jno;
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
	public 员工() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5458\u5DE5\u4FE1\u606F");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(10, 10, 504, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u67E5\u8BE2");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(20, 35, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(30, 60, 71, 15);
		contentPane.add(label_2);
		
		condition1 = new JTextField();
		condition1.setText("");
		condition1.setBounds(111, 57, 217, 21);
		contentPane.add(condition1);
		condition1.setColumns(10);
		
		JButton btn_select = new JButton("\u67E5\u8BE2");
		btn_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                     //查询一个
				if(Integer.parseInt(condition1.getText())<=105&&Integer.parseInt(condition1.getText())>=101 ){
					 员工 b =new 员工();
					 String s = b.select(Integer.parseInt(condition1.getText()));
					print.append(s+"\n");
				}
				else {
					操作提示 c =new 操作提示();
					c.setVisible(true);
				}
			} 
		});
		btn_select.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_select.setBounds(364, 57, 93, 23);
		contentPane.add(btn_select);
		
		JLabel label_3 = new JLabel("\u4FEE\u6539");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(20, 163, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(30, 191, 71, 15);
		contentPane.add(label_4);
		
		condition2 = new JTextField();
		condition2.setBounds(111, 187, 217, 21);
		contentPane.add(condition2);
		condition2.setColumns(10);
		
		condition3 = new JTextField();
		condition3.setBounds(159, 232, 169, 21);
		contentPane.add(condition3);
		condition3.setColumns(10);
		
		JButton btn_updata = new JButton("\u4FEE\u6539");
		btn_updata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                       //修改
				
				if(Integer.parseInt(condition2.getText())<=105&&Integer.parseInt(condition2.getText())>=100&&comboBox.getSelectedItem().equals("position")) {
					员工 b1 =new 员工();
					b1.update(Integer.parseInt(condition2.getText()),condition3.getText());
					操作提示 c1 =new 操作提示();
					c1.setVisible(true);
					}
				else if(Integer.parseInt(condition2.getText())<=105&&Integer.parseInt(condition2.getText())>=100&&comboBox.getSelectedItem().equals("tel")) {
						员工 b3 =new 员工();
						b3.update3(Integer.parseInt(condition2.getText()),condition3.getText());
						操作提示 c1 =new 操作提示();
						c1.setVisible(true);
					}
				else if(Integer.parseInt(condition2.getText())<=105&&Integer.parseInt(condition2.getText())>=100&&comboBox.getSelectedItem().equals("salary")) {
					员工 b2 =new 员工();
					b2.update2(Integer.parseInt(condition2.getText()),Integer.parseInt(condition3.getText()));
					操作提示 c1 =new 操作提示();
					c1.setVisible(true);

				}
				
				else {
					操作提示1 c11 =new 操作提示1();
					c11.setVisible(true);
				}
			}
		});
		btn_updata.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_updata.setBounds(364, 232, 93, 23);
		contentPane.add(btn_updata);
		
		JLabel label_5 = new JLabel("\u5220\u9664");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(20, 288, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5458\u5DE5\u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(30, 326, 71, 15);
		contentPane.add(label_6);
		
		condition4 = new JTextField();
		condition4.setBounds(111, 322, 217, 21);
		contentPane.add(condition4);
		condition4.setColumns(10);
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {                            //删除
				if(Integer.parseInt(condition4.getText())<=105&&Integer.parseInt(condition4.getText())>=100) {
					员工 b2 =new 员工();
					b2.delete(Integer.parseInt(condition4.getText()));
					操作提示 c2 =new 操作提示();
					c2.setVisible(true);
					}
					else {
						操作提示1 c12 =new 操作提示1();
						c12.setVisible(true);
					}
			}
		});
		btn_delete.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_delete.setBounds(364, 322, 93, 23);
		contentPane.add(btn_delete);
		
		JButton btn_return = new JButton("");
		btn_return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//返回
				dispose();			}
		});
		btn_return.setIcon(new ImageIcon(员工.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btn_return.setBounds(0, 0, 34, 25);
		contentPane.add(btn_return);
		
		print = new JTextArea();
		print.setBounds(30, 85, 465, 65);
		contentPane.add(print);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"position", "salary", "tel"}));
		comboBox.setBounds(20, 231, 125, 24);
		contentPane.add(comboBox);
	}
}
