package kk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import personalSystem.Manager.Manager;
import personalSystem.Manager.Operation;
import personalSystem.User.User;

import java.sql.*;

import java.util.*;

public class aa extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField pass_word;
	public JRadioButton r1;
	public JRadioButton r2;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aa frame = new aa();
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
	  public boolean login(int jobNumber,String passWord) {
	        Connection conn=null;
	        Statement st=null;
	        ResultSet rs=null;
	        try {
	            //1、装载驱动
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            //2、链接数据库，使用com.mysql.jdbc.Connection包会出错
	            List<User> list=new ArrayList<User>();
	            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/personalSystem?useSSL=false","root","");
	            //3、创建连接语句
	            st=conn.createStatement();
	            //4、执行ＳＱＬ语句获得结果集
	            rs=st.executeQuery("select * from password where jno = "+jobNumber +" and password = '"+ passWord+"'");
	            //5、循环获得数据库字段生成对象
	            if(rs.next()) {
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            //关闭结果集
	            try {
	                if(rs!=null) {
	                    rs.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            //关闭连接语句
	            try {
	                if(st!=null) {
	                    st.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            //关闭数据库连接
	            try {
	                if(conn!=null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return false;
	    }
	public aa() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.BLUE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label.setBounds(10, 10, 363, 34);
		contentPane.add(label);
		
		JLabel Label_username = new JLabel("\u7528\u6237\u540D\uFF1A");
		Label_username.setFont(new Font("宋体", Font.PLAIN, 16));
		Label_username.setBounds(33, 92, 77, 34);
		contentPane.add(Label_username);
		
		JLabel label_password = new JLabel("\u5BC6\u7801\uFF1A");
		label_password.setFont(new Font("宋体", Font.PLAIN, 16));
		label_password.setBounds(33, 151, 77, 35);
		contentPane.add(label_password);
		
		user_name = new JTextField();                                                     //用户名
		user_name.setBounds(149, 100, 155, 21);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		pass_word = new JPasswordField();                                            //密码
		pass_word.setBounds(149, 159, 155, 21);
		contentPane.add(pass_word);
		
		r1 = new JRadioButton("\u7BA1\u7406\u5458");              //管理员选项
		r1.setBounds(90, 217, 103, 23);
		contentPane.add(r1);
		
		r2 = new JRadioButton("\u5458\u5DE5");            //员工选项
		r2.setBounds(208, 217, 83, 23);
		contentPane.add(r2);
		
		ButtonGroup group =new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		JButton btn_login = new JButton("\u767B\u5F55");                    //登录
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				功能选择 frame = new 功能选择();
				功能选择1 frame1 = new 功能选择1();
				登陆提示 frame2 = new 登陆提示();
				String p1 =new String(pass_word.getPassword());
				
				try {
					aa a1 =new aa();
					if(a1.login(Integer.parseInt(user_name.getText()),p1)&&r2.isSelected()) {        //员工
						frame1.setVisible(true);
					}
					else if(a1.login(Integer.parseInt(user_name.getText()),p1)&&r1.isSelected()) {
						frame.setVisible(true);
					}
					else
					{
					
						frame2.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					frame2.setVisible(true);
				}
//				if(user_name.getText().equals("12345") && p1.equals("12345")&&r1.isSelected()) {
//				frame.setVisible(true);
//				
//				}
//				else if(user_name.getText().equals("12345") && p1.equals("12345")&&r2.isSelected()) {
//					frame1.setVisible(true);
//				}
//				else
//				{
//					登陆提示 frame2 = new 登陆提示();
//					frame2.setVisible(true);
//				}
			}
		});
		btn_login.setBounds(90, 272, 93, 23);
		contentPane.add(btn_login);
		
		JButton btn_exit = new JButton("\u9000\u51FA");               //退出
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_exit.setBounds(198, 272, 93, 23);
		contentPane.add(btn_exit);
	}
}
