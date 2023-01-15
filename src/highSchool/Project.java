package highSchool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Project extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel jp;

	Project() {
		super("Menu principal");
		jp = new JPanel();
		setSize(1920, 990);
		jp.setLayout(null);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		jp.setBounds(0, 0, 1903, 925);
		jp.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		jp.setBorder(new TitledBorder(new LineBorder(new Color(98, 0, 238), 2), // ((r: g: b:), thickness)
		"Menu principal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(55, 0, 179)));
		add(jp);

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/university.jpg"));
		Image img2 = img1.getImage().getScaledInstance(1900, 920, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel l7 = new JLabel(img3);
		l7.setBounds(0, 0, 1900, 900);
		add(l7);

		JMenuBar mb = new JMenuBar();
		mb.setBackground(new Color(18, 18, 18));
		
// ---------------------------------------------------------------------------------

		JMenu menu = new JMenu("Menu");
		menu.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi1 = new JMenuItem("Novo professor");
		JMenuItem mi2 = new JMenuItem("Novo aluno");
		menu.setForeground(Color.WHITE);

		mi1.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/teacher.png"));
		Image img4 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi1.setIcon(new ImageIcon(img4));
		mi1.setMnemonic('A');
		mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		mi1.setBackground(new Color(18, 18, 18));
		mi1.setForeground(Color.WHITE);
		menu.add(mi1);

		mi2.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/student.png"));
		Image img5 = icon2.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi2.setIcon(new ImageIcon(img5));
		mi2.setMnemonic('B');
		mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		mi2.setBackground(new Color(18, 18, 18));
		mi2.setForeground(Color.WHITE);
		menu.add(mi2);

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		
// ---------------------------------------------------------------------------------
		
		JMenu menu9 = new JMenu("Detalhes");
		menu9.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi19 = new JMenuItem("Detalhes dos professores");
		JMenuItem mi20 = new JMenuItem("Detalhes dos alunos");
		menu9.setForeground(Color.WHITE);
		
		mi19.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon17 = new ImageIcon(ClassLoader.getSystemResource("icons/teacherDetails2.png"));
		Image img20 = icon17.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi19.setIcon(new ImageIcon(img20));
		mi19.setMnemonic('C');
		mi19.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		mi19.setBackground(new Color(18, 18, 18));
		mi19.setForeground(Color.WHITE);
		menu.add(mi19);
		
		mi20.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon18 = new ImageIcon(ClassLoader.getSystemResource("icons/studentDetails2.png"));
		Image img21 = icon18.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi20.setIcon(new ImageIcon(img21));
		mi20.setMnemonic('D');
		mi20.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		mi20.setBackground(new Color(18, 18, 18));
		mi20.setForeground(Color.WHITE);
		menu.add(mi20);
		
		mi19.addActionListener(this);
		mi20.addActionListener(this);

// ---------------------------------------------------------------------------------		
		
		JMenu menu2 = new JMenu("Presença");
		menu2.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi3 = new JMenuItem("Presença dos professores");
		JMenuItem mi4 = new JMenuItem("Presença dos alunos");
		menu2.setForeground(Color.WHITE);

		mi3.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/teacherDetails.png"));
		Image img6 = icon3.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi3.setIcon(new ImageIcon(img6));
		mi3.setMnemonic('E');
		mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		mi3.setBackground(new Color(18, 18, 18));
		mi3.setForeground(Color.WHITE);
		menu2.add(mi4);

		mi4.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/studentDetails.png"));
		Image img7 = icon4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi4.setIcon(new ImageIcon(img7));
		mi4.setMnemonic('F');
		mi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		mi4.setBackground(new Color(18, 18, 18));
		mi4.setForeground(Color.WHITE);
		menu2.add(mi4);

		mi3.addActionListener(this);
		mi4.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu3 = new JMenu("Detalhes das presenças");
		menu3.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi5 = new JMenuItem("Detalhes de presenças dos professores");
		JMenuItem mi6 = new JMenuItem("Detalhes de presenças dos alunos");
		menu3.setForeground(Color.WHITE);

		mi5.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/teacherAttendance.png"));
		Image img8 = icon5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi5.setIcon(new ImageIcon(img8));
		mi5.setMnemonic('G');
		mi5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		mi5.setBackground(new Color(18, 18, 18));
		mi5.setForeground(Color.WHITE);
		menu3.add(mi5);

		mi6.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/studentAttendance.png"));
		Image img9 = icon6.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi6.setIcon(new ImageIcon(img9));
		mi6.setMnemonic('H');
		mi6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		mi6.setBackground(new Color(18, 18, 18));
		mi6.setForeground(Color.WHITE);
		menu3.add(mi6);

		mi5.addActionListener(this);
		mi6.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu4 = new JMenu("Exames");
		menu4.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi7 = new JMenuItem("Detalhes de exames");
		JMenuItem mi8 = new JMenuItem("Colocar notas");
		menu4.setForeground(Color.WHITE);

		mi7.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/examDetails.png"));
		Image img10 = icon7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi7.setIcon(new ImageIcon(img10));
		mi7.setMnemonic('I');
		mi7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		mi7.setBackground(new Color(18, 18, 18));
		mi7.setForeground(Color.WHITE);
		menu4.add(mi6);

		mi8.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icons/examMarks.png"));
		Image img11 = icon8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi8.setIcon(new ImageIcon(img11));
		mi8.setMnemonic('J');
		mi8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
		mi8.setBackground(new Color(18, 18, 18));
		mi8.setForeground(Color.WHITE);
		menu4.add(mi8);

		mi7.addActionListener(this);
		mi8.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu5 = new JMenu("Atualizar detalhes");
		menu5.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi9 = new JMenuItem("Atualizar professores");
		JMenuItem mi10 = new JMenuItem("Atualizar alunos");
		menu5.setForeground(Color.WHITE);

		mi9.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/teacherUpdate.png"));
		Image img12 = icon9.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi9.setIcon(new ImageIcon(img12));
		mi9.setMnemonic('K');
		mi9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		mi9.setBackground(new Color(18, 18, 18));
		mi9.setForeground(Color.WHITE);
		menu5.add(mi9);

		mi10.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icons/studentUpdate.png"));
		Image img13 = icon10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi10.setIcon(new ImageIcon(img13));
		mi10.setMnemonic('L');
		mi10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		mi10.setBackground(new Color(18, 18, 18));
		mi10.setForeground(Color.WHITE);
		menu5.add(mi10);

		mi9.addActionListener(this);
		mi10.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu6 = new JMenu("Financeiro");
		menu6.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi11 = new JMenuItem("Estrutura financeira");
		JMenuItem mi12 = new JMenuItem("Mensalidade");
		menu6.setForeground(Color.WHITE);

		mi11.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/studentStructure.png"));
		Image img14 = icon11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi11.setIcon(new ImageIcon(img14));
		mi11.setMnemonic('M');
		mi11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		mi11.setBackground(new Color(18, 18, 18));
		mi11.setForeground(Color.WHITE);
		menu6.add(mi11);

		mi12.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/studentFee.png"));
		Image img15 = icon12.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi12.setIcon(new ImageIcon(img15));
		mi12.setMnemonic('N');
		mi12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		mi12.setBackground(new Color(18, 18, 18));
		mi12.setForeground(Color.WHITE);
		menu6.add(mi12);

		mi11.addActionListener(this);
		mi12.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu7 = new JMenu("Utilidades");
		menu7.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi13 = new JMenuItem("Bloco de notas");
		JMenuItem mi14 = new JMenuItem("Calculadora");
		JMenuItem mi15 = new JMenuItem("Procurar na web");
		menu7.setForeground(Color.WHITE);

		mi13.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
		Image img16 = icon13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi13.setIcon(new ImageIcon(img16));
		mi13.setMnemonic('O');
		mi13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		mi13.setBackground(new Color(18, 18, 18));
		mi13.setForeground(Color.WHITE);
		menu7.add(mi13);

		mi14.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("icons/calculator.png"));
		Image img17 = icon14.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi14.setIcon(new ImageIcon(img17));
		mi14.setMnemonic('P');
		mi14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		mi14.setBackground(new Color(18, 18, 18));
		mi14.setForeground(Color.WHITE);
		menu7.add(mi14);

		mi15.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon15 = new ImageIcon(ClassLoader.getSystemResource("icons/webBrowser.png"));
		Image img18 = icon15.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi15.setIcon(new ImageIcon(img18));
		mi15.setMnemonic('Q');
		mi15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		mi15.setBackground(new Color(18, 18, 18));
		mi15.setForeground(Color.WHITE);
		menu7.add(mi15);

		mi13.addActionListener(this);
		mi14.addActionListener(this);
		mi15.addActionListener(this);
		
// ---------------------------------------------------------------------------------

		JMenu menu8 = new JMenu("Sair");
		menu8.setFont(new Font("futura", Font.PLAIN, 16));
		JMenuItem mi16 = new JMenuItem("Deslogar");
		menu8.setForeground(Color.WHITE);

		mi16.setFont(new Font("futura", Font.PLAIN, 16));
		ImageIcon icon16 = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
		Image img19 = icon16.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		mi16.setIcon(new ImageIcon(img19));
		mi16.setMnemonic('R');
		mi16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		mi16.setBackground(new Color(18, 18, 18));
		mi16.setForeground(Color.WHITE);
		menu8.add(mi16);

		mi16.addActionListener(this);

		menu.add(mi1);
		menu.add(mi2);
		menu9.add(mi19);
		menu9.add(mi20);
		menu2.add(mi3);
		menu2.add(mi4);
		menu3.add(mi5);
		menu3.add(mi6);
		menu4.add(mi7);
		menu4.add(mi8);
		menu5.add(mi9);
		menu5.add(mi10);
		menu6.add(mi11);
		menu6.add(mi12);
		menu7.add(mi13);
		menu7.add(mi14);
		menu7.add(mi15);
		menu8.add(mi16);

		mb.add(menu);
		mb.add(menu9);
		mb.add(menu2);
		mb.add(menu3);
		mb.add(menu4);
		mb.add(menu5);
		mb.add(menu6);
		mb.add(menu7);
		mb.add(menu8);

		setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String msg = actionEvent.getActionCommand();

		if (msg.equals("Novo professor")) {
			// new AddTeacher().f.setVisible(true);

		} else if (msg.equals("Novo aluno")) {
			// new AddStudent().f.setVisible(true);

		} else if (msg.equals("Detalhes dos professores")) {
			// new TeacherDetails().setVisible(true);

		} else if (msg.equals("Detalhes dos alunos")) {
			// new StudentDetails().setVisible(true);

		} else if (msg.equals("Atualizar professores")) {
			// new UpdateTeacher().f.setVisible(true);

		} else if (msg.equals("Atualizar alunos")) {
			// new UpdateStudent().f.setVisible(true);

		} else if (msg.equals("Estrutura financeira")) {
			// new FeeStructure().setVisible(true);

		} else if (msg.equals("Mensalidade")) {
			// new StudentFeeForm().setVisible(true);

		} else if (msg.equals("Presença dos alunos")) {
			// new StudentAttendance().setVisible(true);

		} else if (msg.equals("Presença dos professores")) {
			// new TeacherAttendance().setVisible(true);

		} else if (msg.equals("Detalhes de presenças dos alunos")) {
			// new StudentAttendanceDetail().setVisible(true);

		} else if (msg.equals("Detalhes de presenças dos professores")) {
			// new TeacherAttendanceDetail().setVisible(true);

		} else if (msg.equals("Detalhes de exames")) {
			// new ExaminationDetails().setVisible(true);

		} else if (msg.equals("Colocar notas")) {
			// new EnterMarks().setVisible(true);

// ---------------------------------------------------------------------------------

		} else if (msg.equals("Bloco de notas")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (msg.equals("Calculadora")) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (msg.equals("Procurar na web")) {
			try {
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (msg.equals("Deslogar")) {
			System.exit(0);
		}
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project frame = new Project();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
