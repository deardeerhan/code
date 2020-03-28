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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class 考勤1 extends JFrame {

	private JPanel contentPane;
	private JTextArea print;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					考勤1 frame = new 考勤1();
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
	public 考勤1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
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
		label.setBounds(10, 10, 414, 40);
		contentPane.add(label);
		
		JLabel label_3 = new JLabel("\u67E5\u8BE2\u5458\u5DE5\u8003\u52E4\u4FE1\u606F");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(14, 71, 171, 15);
		contentPane.add(label_3);
		
		JButton btn_select = new JButton("\u67E5\u8BE2");
		btn_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {              //查询全体
				if(Integer.parseInt(textField.getText())<=105&&Integer.parseInt(textField.getText())>=100 ){
					 考勤 b =new 考勤();
					 String s = b.select(Integer.parseInt(textField.getText()));
					print.append(s+"\n");
				}
				else {
					操作提示 c =new 操作提示();
					c.setVisible(true);
				}
				
			}
		});
		btn_select.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_select.setBounds(331, 68, 93, 23);
		contentPane.add(btn_select);
		
		print = new JTextArea();
		print.setFont(new Font("宋体", Font.PLAIN, 13));
		print.setBounds(10, 99, 414, 128);
		contentPane.add(print);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(199, 67, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
