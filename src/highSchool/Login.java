package highSchool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JFrame fr;
	JPanel jp;
	JPasswordField pf;
	JTextField tf;
	JButton b1, b2;
	JLabel l1, l2, l3;
	
	Login() {
		super("Login");
		jp = new JPanel();
		setSize(600, 300);
		jp.setLayout(null);
		this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		jp.setBounds(0, 0, 583, 260);
		jp.setBackground(new Color(18, 18, 18));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(98, 0, 238), 2), // ((r: g: b:), thickness)
		"Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(55, 0, 179)));																											
		add(jp);
		
		//---------------------------------------------------------------------------------
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image img2 = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		l3 = new JLabel(img3);
		l3.setBounds(370, 50, 150, 150);
		jp.add(l3);
		
		//---------------------------------------------------------------------------------
		
		l1 = new JLabel("Usuário");
		l1.setBounds(40, 60, 100, 30);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("futura", Font.PLAIN, 14));
		jp.add(l1);
		
		tf = new RoundJTextField(15);
		tf.setBounds(150, 60, 150, 30);
		tf.setBackground(new Color(28, 28, 28));
		tf.setForeground(Color.WHITE);
        tf.setCaretColor(new Color(98, 0, 238));
		jp.add(tf);
		
		//---------------------------------------------------------------------------------
		
		l2 = new JLabel("Senha");
		l2.setBounds(40, 120, 100, 30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("futura", Font.PLAIN, 14));
		jp.add(l2);
		
		pf = new RoundJPasswordField(15);
		pf.setBounds(150, 120, 150, 30);
		pf.setForeground(Color.WHITE);
		pf.setBackground(new Color(28, 28, 28));
        pf.setCaretColor(new Color(98, 0, 238));
		jp.add(pf);
		
		//---------------------------------------------------------------------------------
		
		b1 = new JButton("Login");
		b1.addActionListener(this);
		b1.setBounds(180, 185, 111, 33);
		b1.setBackground(new Color(28, 28, 28));
		b1.setForeground(Color.WHITE);
		b1.setBorder(new RoundedBorder(10));
		jp.add(b1);

		b2 = new JButton("Sair");
		b2.addActionListener(this);
		b2.setBounds(40, 185, 111, 33);
		b2.setBackground(new Color(28, 28, 28));
		b2.setForeground(Color.WHITE);
		b2.setBorder(new RoundedBorder(10));
		jp.add(b2);
	}
	
	//---------------------------------------------------------------------------------
	
	public class RoundJTextField extends JTextField {

		private static final long serialVersionUID = 1L;
		
		private Shape shape;
	    public RoundJTextField(int size) {
	        super(size);
	        setOpaque(false);
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(new Color(97, 97, 97));
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
	}
	
	//---------------------------------------------------------------------------------
	
	public class RoundJPasswordField extends JPasswordField {

		private static final long serialVersionUID = 1L;
		
		private Shape shape;
	    public RoundJPasswordField(int size) {
	        super(size);
	        setOpaque(false);
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(new Color(97, 97, 97));
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
	}
	
	//---------------------------------------------------------------------------------
	
	private static class RoundedBorder implements Border {

	    private int radius;

		RoundedBorder(int radius) {
	        this.radius = radius;
	    }

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }

	    public boolean isBorderOpaque() {
	        return true;
	    }

	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.setColor(new Color(97, 97, 97));
	    	g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
	
	//---------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			
			if (actionEvent.getSource() == b1) {
				try {
					Conn c = new Conn();
					String username = tf.getText();
					String password = new String(pf.getPassword());
					
					String query = "SELECT * FROM login WHERE username = '" 
							+ username + "' AND password = '" + password + "'";
					ResultSet rs = c.st.executeQuery(query);
					
					if(rs.next()) {
						//new Project().setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Login inválido!");
						setVisible(false);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b2) {
				System.exit(0);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------------------------------------------

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
