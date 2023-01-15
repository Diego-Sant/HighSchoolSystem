package highSchool;

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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Random;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.MaskFormatter;

public class AddTeacher extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel jp;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
	JButton b1, b2;
	JComboBox<String> c1, c2, c3, c4, c5, c6;

	Random ran = new Random();
	long rn = (ran.nextLong() % 9000L) + 10000L;
	long random = Math.abs(rn);

	AddTeacher() {
		super("Adicionar professor(a)");
		jp = new JPanel();
		setSize(900, 700);
		jp.setLayout(null);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		jp.setBounds(0, 0, 883, 660);
		jp.setBackground(new Color(18, 18, 18));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(98, 0, 238), 2), // ((r: g: b:), thickness)
				"Adicionar professor(a)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(55, 0, 179)));
		add(jp);
		
		MetalLookAndFeel.setCurrentTheme(new javax.swing.plaf.metal.OceanTheme() {
			@Override
			protected javax.swing.plaf.ColorUIResource getSecondary2() {
				return new javax.swing.plaf.ColorUIResource(new Color(28, 28, 28));
			}
		});

		// ---------------------------------------------------------------------------------

		l1 = new JLabel("Nome");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("futura", Font.BOLD, 20));
		l1.setBounds(60, 150, 100, 30);
		l1.setForeground(Color.WHITE);
		jp.add(l1);

		t1 = new JTextField("Nome completo");
		t1.setForeground(Color.GRAY);
		t1.setBackground(new Color(28, 28, 28));
		t1.setBounds(200, 150, 180, 30);
		t1.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t1.setCaretColor(new Color(98, 0, 238));
		jp.add(t1);
		t1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (t1.getText().equals("Nome completo")) {
					t1.setText("");
					t1.setForeground(Color.WHITE);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (t1.getText().isEmpty()) {
					t1.setForeground(Color.GRAY);
					t1.setText("Nome completo");
				}
			}
		});

		// ---------------------------------------------------------------------------------

		l2 = new JLabel("Idade");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("futura", Font.BOLD, 20));
		l2.setBounds(460, 150, 200, 30);
		l2.setForeground(Color.WHITE);
		jp.add(l2);


		t2 = new JTextField();
		t2.setForeground(Color.WHITE);
		t2.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t2.setCaretColor(new Color(98, 0, 238));
		t2.setBackground(new Color(28, 28, 28));
		t2.setBounds(620, 150, 180, 30);
		jp.add(t2);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				t2.requestFocus();
			}
		});

		// ---------------------------------------------------------------------------------

		l3 = new JLabel("CEP");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("futura", Font.BOLD, 20));
		l3.setBounds(60, 200, 100, 30);
		l3.setForeground(Color.WHITE);
		jp.add(l3);

		try {
			t3 = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t3.setForeground(Color.WHITE);
		t3.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t3.setCaretColor(new Color(98, 0, 238));
		t3.setBackground(new Color(28, 28, 28));
		t3.setBounds(200, 200, 180, 30);
		jp.add(t3);

		// ---------------------------------------------------------------------------------

		l4 = new JLabel("Nascimento");
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("futura", Font.BOLD, 20));
		l4.setBounds(460, 200, 200, 30);
		l4.setForeground(Color.WHITE);
		jp.add(l4);

		try {
			t4 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t4.setForeground(Color.WHITE);
		t4.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t4.setCaretColor(new Color(98, 0, 238));
		t4.setBackground(new Color(28, 28, 28));
		t4.setBounds(620, 200, 180, 30);
		jp.add(t4);

		// ---------------------------------------------------------------------------------

		l5 = new JLabel("Celular");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("futura", Font.BOLD, 20));
		l5.setBounds(60, 250, 100, 30);
		l5.setForeground(Color.WHITE);
		jp.add(l5);

		try {
			t5 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t5.setForeground(Color.WHITE);
		t5.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t5.setCaretColor(new Color(98, 0, 238));
		t5.setBackground(new Color(28, 28, 28));
		t5.setBounds(200, 250, 180, 30);
		jp.add(t5);

		// ---------------------------------------------------------------------------------

		l6 = new JLabel("Email");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("futura", Font.BOLD, 20));
		l6.setBounds(460, 250, 200, 30);
		l6.setForeground(Color.WHITE);
		jp.add(l6);

		t6 = new JTextField();
		t6.setForeground(Color.WHITE);
		t6.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t6.setCaretColor(new Color(98, 0, 238));
		t6.setBackground(new Color(28, 28, 28));
		t6.setBounds(620, 250, 180, 30);
		jp.add(t6);

		// ---------------------------------------------------------------------------------

		l7 = new JLabel("CPF");
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("futura", Font.BOLD, 20));
		l7.setBounds(60, 300, 100, 30);
		l7.setForeground(Color.WHITE);
		jp.add(l7);

		try {
			t7 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t7.setForeground(Color.WHITE);
		t7.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t7.setCaretColor(new Color(98, 0, 238));
		t7.setBackground(new Color(28, 28, 28));
		t7.setBounds(200, 300, 180, 30);
		jp.add(t7);

		// ---------------------------------------------------------------------------------

		l8 = new JLabel("Graduação");
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("futura", Font.BOLD, 20));
		l8.setBounds(460, 300, 200, 30);
		l8.setForeground(Color.WHITE);
		jp.add(l8);

		c1 = new JComboBox<String>(new String[] { "", "Bacharelado", "Licenciatura", "Tecnólogo" });
		c1.setBounds(620, 300, 180, 30);
		c1.setForeground(Color.WHITE);
		c1.setBackground(new Color(28, 28, 28));
		c1.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		jp.add(c1);
		c1.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				setBackground(new Color(28, 28, 28));
				setForeground(Color.WHITE);
				super.paint(g);
			}
		});

		// ---------------------------------------------------------------------------------

		l9 = new JLabel("Matéria");
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("futura", Font.BOLD, 20));
		l9.setBounds(60, 350, 100, 30);
		l9.setForeground(Color.WHITE);
		jp.add(l9);

		c2 = new JComboBox<String>(new String[] { "Português", "Matemática", "História", "Geografia", "Química",
				"Física", "Artes", "Educação Física", "Inglês", "Espanhol", "Sociologia", "Filosofia", "Informática" });
		c2.setSelectedIndex(-1);
		c2.setBounds(200, 350, 180, 30);
		c2.setForeground(Color.WHITE);
		c2.setBackground(new Color(28, 28, 28));
		c2.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		jp.add(c2);
		c2.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				setBackground(new Color(28, 28, 28));
				setForeground(Color.WHITE);
				super.paint(g);
			}
		});

		// ---------------------------------------------------------------------------------

		l10 = new JLabel("Sexo");
		l10.setForeground(Color.BLACK);
		l10.setFont(new Font("futura", Font.BOLD, 20));
		l10.setBounds(460, 350, 200, 30);
		l10.setForeground(Color.WHITE);
		jp.add(l10);

		c3 = new JComboBox<String>(new String[] { "Homem", "Mulher", "Indefinido" });
		c3.setSelectedIndex(-1);
		c3.setBounds(620, 350, 180, 30);
		c3.setForeground(Color.WHITE);
		c3.setBackground(new Color(28, 28, 28));
		c3.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		jp.add(c3);
		c3.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				setBackground(new Color(28, 28, 28));
				setForeground(Color.WHITE);
				super.paint(g);
			}
		});

		// ---------------------------------------------------------------------------------

		l11 = new JLabel("Série(s)");
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("futura", Font.BOLD, 20));
		l11.setBounds(60, 400, 100, 30);
		l11.setForeground(Color.WHITE);
		jp.add(l11);

		c4 = new JComboBox<String>(new String[] { "1° Ano", "2° Ano", "3° Ano", "1° e 2° ano", "1° e 3° ano",
				"2° e 3° ano", "1°, 2° e 3° ano" });
		c4.setBounds(200, 400, 180, 30);
		c4.setForeground(Color.WHITE);
		c4.setBackground(new Color(28, 28, 28));
		c4.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		jp.add(c4);
		c4.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				setBackground(new Color(28, 28, 28));
				setForeground(Color.WHITE);
				super.paint(g);
			}
		});

		// ---------------------------------------------------------------------------------

		l12 = new JLabel("Turma(s)");
		l12.setForeground(Color.BLACK);
		l12.setFont(new Font("futura", Font.BOLD, 20));
		l12.setBounds(460, 400, 200, 30);
		l12.setForeground(Color.WHITE);
		jp.add(l12);

		t8 = new JTextField();
		t8.setForeground(Color.WHITE);
		t8.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t8.setCaretColor(new Color(98, 0, 238));
		t8.setBackground(new Color(28, 28, 28));
		t8.setBounds(620, 400, 180, 30);
		jp.add(t8);

		// ---------------------------------------------------------------------------------

		l8 = new JLabel("ID");
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("futura", Font.BOLD, 20));
		l8.setBounds(60, 450, 200, 30);
		l8.setForeground(Color.WHITE);
		jp.add(l8);

		t9 = new JTextField();
		t9.setForeground(Color.WHITE);
		t9.setText("" + random);
		t9.setBorder(new LineBorder(new Color(97, 97, 97), 1));
		t9.setCaretColor(new Color(98, 0, 238));
		t9.setBackground(new Color(28, 28, 28));
		t9.setBounds(200, 450, 180, 30);
		jp.add(t9);

		// ---------------------------------------------------------------------------------

		b1 = new JButton("Adicionar");
		b1.addActionListener(this);
		b1.setBounds(450, 550, 150, 40);
		b1.setBackground(new Color(28, 28, 28));
		b1.setForeground(Color.WHITE);
		b1.setBorder(new RoundedBorder(10));
		jp.add(b1);

		b2 = new JButton("Voltar");
		b2.addActionListener(this);
		b2.setBounds(250, 550, 150, 40);
		b2.setBackground(new Color(28, 28, 28));
		b2.setForeground(Color.WHITE);
		b2.setBorder(new RoundedBorder(10));
		jp.add(b2);

	}

	// ---------------------------------------------------------------------------------
	
	private static class RoundedBorder implements Border {

		private int radius;

		RoundedBorder(int radius) {
			this.radius = radius;
		}

		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		public boolean isBorderOpaque() {
			return true;
		}

		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.setColor(new Color(97, 97, 97));
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
		}

	}

	// ---------------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		try {
			if (actionEvent.getSource() == b1) {
				try {
					String name = t1.getText();
					String age = t2.getText();
					String cep = t3.getText();
					String birthDate = t4.getText();
					String phone = t5.getText();
					String email = t6.getText();
					String cpf = t7.getText();
					String graduation = (String) c1.getSelectedItem();
					String subject = (String) c2.getSelectedItem();
					String gender = (String) c3.getSelectedItem();
					String grade = (String) c4.getSelectedItem();
					String classes = t8.getText();
					String emp_id = t9.getText();
					
					Conn c = new Conn();
					String query = "INSERT INTO teacher VALUES('" + name + "', '" 
						+ age + "', '" + cep + "', '" + birthDate + "', '" 
						+ phone + "', '" + email + "', '" + cpf + "', '" 
						+ graduation + "', '" + subject + "', '" + gender + "', '" 
						+ grade + "', '" + classes + "', '" + emp_id + "')";
					
					c.st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Professor(a) adicionado(a) com sucesso!");
					setVisible(false);
					
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
