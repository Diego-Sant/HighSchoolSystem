package highSchool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class StudentDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel l1, l2, l3;
	JTable tb;
	JButton b1, b2, b3, b4;
	JTextField tf;
	JPanel jp;
	String x[] = {"Nome", "Responsável", "Idade", "Nascimento", "CEP", "Celular", "Email", "CPF", "ID", "Série", "Turma", "Sexo"};
	String y[][] = new String[100][12];
	
	int i=0, j = 0;
	
	StudentDetails() {
		super("Detalhes dos alunos");
		jp = new JPanel();
		setSize(1260, 700);
		jp.setLayout(null);
		this.setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		jp.setBounds(0, 0, 1483, 660);
		jp.setBackground(new Color(18, 18, 18));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(98, 0, 238), 2), // ((r: g: b:), thickness)
				"Detalhes dos alunos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(55, 0, 179)));
		add(jp);
		
		l1 = new JLabel("Coloque o ID do(a) aluno(a)");
		l1.setBounds(320, 360, 300, 20);
		l1.setFont(new Font("futura", Font.BOLD, 20));
		l1.setForeground(Color.WHITE);
		jp.add(l1);
		
		tf = new RoundJTextField(15);
		tf.setBounds(630, 358, 120, 30);
		tf.setBackground(new Color(28, 28, 28));
		tf.setForeground(Color.WHITE);
        tf.setCaretColor(new Color(98, 0, 238));
		jp.add(tf);
		
		b1 = new JButton("Deletar");
		b1.addActionListener(this);
		b1.setBounds(800, 358, 100, 30);
		b1.setBackground(new Color(28, 28, 28));
		b1.setForeground(Color.WHITE);
		b1.setBorder(new RoundedBorder(10));
		jp.add(b1);
		
		l2 = new JLabel("Adicionar alunos(a)");
		l2.setBounds(50, 460, 400, 20);
		l2.setFont(new Font("futura", Font.BOLD, 20));
		l2.setForeground(Color.WHITE);
		jp.add(l2);
		
		b4 = new JButton("Adicionar");
		b4.addActionListener(this);
		b4.setBounds(350, 458, 100, 30);
		b4.setBackground(new Color(28, 28, 28));
		b4.setForeground(Color.WHITE);
		b4.setBorder(new RoundedBorder(10));
		jp.add(b4);
		
		l3 = new JLabel("Atualizar alunos(a)");
		l3.setBounds(50, 520, 400, 20);
		l3.setFont(new Font("futura", Font.BOLD, 20));
		l3.setForeground(Color.WHITE);
		jp.add(l3);
		
		b2 = new JButton("Atualizar");
		b2.addActionListener(this);
		b2.setBounds(350, 518, 100, 30);
		b2.setBackground(new Color(28, 28, 28));
		b2.setForeground(Color.WHITE);
		b2.setBorder(new RoundedBorder(10));
		jp.add(b2);
		
		b3 = new JButton("Voltar");
		b3.addActionListener(this);
		b3.setBounds(50, 590, 100, 30);
		b3.setBackground(new Color(28, 28, 28));
		b3.setForeground(Color.WHITE);
		b3.setBorder(new RoundedBorder(10));
		jp.add(b3);
		
		try {
			Conn c = new Conn();
			String query = "SELECT * FROM student";
			ResultSet rs = c.st.executeQuery(query);
			
			while(rs.next()) {
				y[i][j++]=rs.getString("name");
				y[i][j++]=rs.getString("responsible_name");
				y[i][j++]=rs.getString("age");
				y[i][j++]=rs.getString("birthDate");
				y[i][j++]=rs.getString("address");
				y[i][j++]=rs.getString("phone");
				y[i][j++]=rs.getString("email");
				y[i][j++]=rs.getString("cpf");
				y[i][j++]=rs.getString("rollno");
				y[i][j++]=rs.getString("grade");
				y[i][j++]=rs.getString("classes");
				y[i][j++]=rs.getString("gender");
				i++;
				j=0;
			}
			tb = new JTable(y, x);
			tb.setBackground(new Color(28, 28, 28));
			tb.setForeground(Color.WHITE);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(tb);
		sp.setBounds(20, 20, 1200, 330);
		sp.setBackground(new Color(28, 28, 28));
		sp.getVerticalScrollBar().setBackground(new Color(28, 28, 28));
		jp.add(sp);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(98, 0, 238);
		    }
		});
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			if (actionEvent.getSource() == b1) {
				try {
					Conn c = new Conn();
					String id = tf.getText();
					String query = "DELETE FROM student WHERE rollno = '" + id + "'";
					
					c.st.executeUpdate(query);
					setVisible(false);
					new StudentDetails().setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			} else if (actionEvent.getSource() == b4) {
				new AddStudent().setVisible(true);
			} else if (actionEvent.getSource() == b2) {
				//new UpdateStudent().setVisible(true);
			} else if (actionEvent.getSource() == b3) {
				new Project().setVisible(true);
				setVisible(false);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

