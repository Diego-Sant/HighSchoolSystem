package highSchool;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StudentAttendance extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel l1, l2, l3;
	JButton b1, b2;
	Choice c1, c2, c3;
	JPanel jp;
	
	StudentAttendance() {
		super("Presença dos(a) alunos(a)");
		jp = new JPanel();
		setSize(500, 350);
		jp.setLayout(null);
		this.setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		jp.setBounds(0, 0, 483, 310);
		jp.setBackground(new Color(18, 18, 18));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(98, 0, 238), 2), // ((r: g: b:), thickness)
		"Presença dos(a) alunos(a)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(55, 0, 179)));
		add(jp);
		
		l1 = new JLabel("Selecione o ID do(a) aluno(a)");
		l1.setBounds(20, 50, 250, 20);
		l1.setFont(new Font("futura", Font.BOLD, 14));
		l1.setForeground(Color.WHITE);
		jp.add(l1);
		
		c1 = new Choice();
		c1.setBackground(new Color(28, 28, 28));
		c1.setBounds(300, 50, 150, 20);
		c1.setForeground(Color.WHITE);
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("SELECT * FROM student");
			
			while(rs.next()) {
				c1.add(rs.getString("rollno"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jp.add(c1);
		
		l2 = new JLabel("Primeiro período");
		l2.setBounds(20, 100, 250, 20);
		l2.setFont(new Font("futura", Font.BOLD, 14));
		l2.setForeground(Color.WHITE);
		jp.add(l2);
		
		c2 = new Choice();
		c2.setBackground(new Color(28, 28, 28));
		c2.setBounds(300, 100, 150, 20);
		c2.setForeground(Color.WHITE);
		c2.add("Presente");
		c2.add("Faltou");
		c2.add("Saiu");
		jp.add(c2);
		
		l3 = new JLabel("Segundo período");
		l3.setBounds(20, 150, 250, 20);
		l3.setFont(new Font("futura", Font.BOLD, 14));
		l3.setForeground(Color.WHITE);
		jp.add(l3);
		
		c3 = new Choice();
		c3.setBackground(new Color(28, 28, 28));
		c3.setBounds(300, 150, 150, 20);
		c3.setForeground(Color.WHITE);
		c3.add("Presente");
		c3.add("Faltou");
		c3.add("Saiu");
		jp.add(c3);
		
		b1 = new JButton("Enviar");
		b1.addActionListener(this);
		b1.setBounds(260, 240, 100, 30);
		b1.setBackground(new Color(28, 28, 28));
		b1.setForeground(Color.WHITE);
		b1.setBorder(new RoundedBorder(10));
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(110, 240, 100, 30);
		b2.setBackground(new Color(28, 28, 28));
		b2.setForeground(Color.WHITE);
		b2.setBorder(new RoundedBorder(10));
		jp.add(b2);
	}
	
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
					String rollno = c1.getSelectedItem();
					String date = new java.util.Date().toString();
					String first = c2.getSelectedItem();
					String second = c3.getSelectedItem();
					
					String query = "INSERT INTO attendance_student VALUES('"
							+ rollno + "', '" + date + "', '" + first 
							+ "', '" + second + "')";
					
					Conn c = new Conn();
					c.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Presença atualizada!");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b2) {
				new Project().setVisible(true);
				setVisible(false);
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
					StudentAttendance frame = new StudentAttendance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
