package data_mining;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultCaret;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import org.jfree.chart.ChartPanel;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

public class IHM extends JFrame {
	JLabel lblMediane;

	JLabel lblQ1;

	JLabel lblIQR;

	JTextArea textArea;
	JLabel lblQ3;
	int k = 0;
	BoxAndWhiskerDemo bw;
	static int i1;

	static int i2;

	JLabel variance, etendu, ecarttype, outlier;
	int p = 0;
	int ligne = -1;
	private Histogramme hist;
	JRadioButton rscatterplot, rqqplot;
	ButtonGroup gb3 = new ButtonGroup();;
	Object rowData[] = new Object[8];
	String s1 = "", s2 = "", s3 = "", s0 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";
	public static ArrayList<Double> A = new ArrayList(), // area
			P = new ArrayList(), // perimeter
			C = new ArrayList(), // compactness C = 4*pi*A/P^2
			LoK = new ArrayList(), // length of kernel
			WoK = new ArrayList(), // width of kernel
			AC = new ArrayList(), // asymmetry coefficient
			LoKG = new ArrayList();

	ArrayList<String> Class = new ArrayList();
	JPanel panel_3, panel_4;
	JScrollPane scrollPane;
	DefaultTableCellRenderer centerRenderer3, centerRenderer, centerRenderer2, centerRenderer33;
	JTableHeader theader2, theader, theader3;// ,theader33;
	JComboBox comboBox_1, comboBox_2;
	JComboBox comboBox, comboBox_3;
	String selected_option_combobox = "", selected_option_combobox1 = "", selected_option_combobox2 = "",
			selected_option_combobox3 = "", selected_option_combobox4 = "";
	ArrayList<Double> selected_option_list = new ArrayList<Double>();
	ArrayList<Double> selected_option_listb = new ArrayList<Double>();
	ArrayList<Double> selected_option_list4 = new ArrayList<Double>();
	ArrayList<Double> selected_option_list1 = new ArrayList<Double>();
	ArrayList<Double> selected_option_list2 = new ArrayList<Double>();

	ArrayList<Double> selected_option_list1_kama = new ArrayList<Double>();
	ArrayList<Double> selected_option_list1_rosa = new ArrayList<Double>();
	ArrayList<Double> selected_option_list1_canadian = new ArrayList<Double>();

	ArrayList<Double> selected_option_list2_kama = new ArrayList<Double>();
	ArrayList<Double> selected_option_list2_rosa = new ArrayList<Double>();
	ArrayList<Double> selected_option_list2_canadian = new ArrayList<Double>();
	String options[] = { "", "A", "P", "C", "LoK", "WoK", "AC", "LoKG" };
	int radio_boxplot_histo = 1; // 1 = box plot, 2 = histogram
//work done
	int radio_qq_scatter = 1;
	// int radio_boxplot_histo2 = 1;
	double tab[] = new double[5];
	double tab2[] = new double[5];
	double t1, t2, t3;
	private JRadioButton c1, c2;
	static File file = null;
	private JPanel contentPane, panel_Scatter, panel_5;
	private final JPanel panel = new JPanel();
	private JPanel panel_fichier;
	private JTable table_1;
	private ButtonGroup bg = new ButtonGroup();

	private ButtonGroup bg2 = new ButtonGroup();
	DefaultTableModel model;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JTextField text0;
	private JMenu mnLesGraphes;
	private JMenuItem mntmDeTencance;
	private JMenuItem mntmDeDispersion_1;
	private JMenuItem mntmHistogrammeEtBoxplot_1;
	private JMenuItem mntmScatterEtQq_1;
	private JMenuItem mntmAffichages;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel moyenne1;
	private JLabel mediane;
	private JLabel mode2;
	private JLabel milieuetendue;
	private JLabel conclusion;
	private JPanel panel_7;
	private JLabel label;
	private JLabel etendue;
	private JLabel q1, cc;
	private JLabel q2;
	private JLabel q3;
	private JLabel Iqr;
	private JComboBox comboBox_4, comboBox_5;
	private JLabel mt;
	private JButton btnSelectionner;
	private JPanel p2;
	private JPanel p3;
	private JLabel lb;
	private JLabel lblLaDescriptionDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM frame = new IHM();
					// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

					frame.setVisible(true);
					frame.setResizable(false);
					//

					// frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String mode(ArrayList<Double> liste) {
		int pos = 0, occr, max = 0;
		int[] intervalle = new int[2]; // intervalle d'amplitude 1
		String intervalleS = "";

		// trouver la répétition maximale
		while (pos < liste.size()) {
			intervalle[0] = (int) liste.get(pos).intValue(); // intervalle[0] --> Binferieure
			intervalle[1] = intervalle[0] + 1; // intervalle[1] --> Binferieure + 1 -> Bsuperieure
			occr = 0;

			while (pos < liste.size() && (liste.get(pos) >= intervalle[0] && liste.get(pos) < intervalle[1])) {
				occr++;
				// System.out.print(occr+"\t");
				// System.out.println(liste.get(pos));
				pos++;
			}

			// System.out.println();
			if (occr > max) {
				max = occr;
			}
		}
		System.out.println("occurence max : " + max + ".");
		System.out.print("mode(s) : ");

		// trouver les intervalles où la répétition est maximale
		pos = 0;
		while (pos < liste.size()) {
			intervalle[0] = (int) liste.get(pos).intValue(); // intervalle[0] --> Binferieure
			intervalle[1] = intervalle[0] + 1; // intervalle[1] --> Binferieure + 1 -> Bsuperieure
			occr = 0;

			while (pos < liste.size() && (liste.get(pos) >= intervalle[0] && liste.get(pos) < intervalle[1])) {
				occr++;
				pos++;
			}

			// afficher les intervalles
			if (occr == max) {
				intervalleS = "[" + intervalle[0] + ", " + intervalle[1] + "]\t";
				i1 = intervalle[0];
				i2 = intervalle[1];
			}
		}
		return intervalleS;
	}

	public static ArrayList<Double> resume_5_nombre(ArrayList<Double> liste) {
		if (liste.size() == 0)
			return new ArrayList<Double>();
		Collections.sort(liste);
		int ind_min = 0, ind_q1 = (int) Math.ceil((liste.size() - 1) / 4),
				ind_med1 = (int) Math.ceil((liste.size() - 1) / 2),
				ind_med2 = (int) (liste.size() % 2 == 0 ? Math.ceil((liste.size() - 1) / 2) + 1
						: Math.ceil((liste.size() - 1) / 2)),
				ind_q3 = (int) Math.ceil((3 * liste.size() - 1) / 4), ind_max = liste.size() - 1;
		return new ArrayList<Double>(Arrays.asList(liste.get(ind_min), liste.get(ind_q1),
				(liste.get(ind_med1) + liste.get(ind_med2)) / 2, liste.get(ind_q3), liste.get(ind_max)));
	}

	public static Double iqr(ArrayList<Double> liste) {
		ArrayList<Double> temp = resume_5_nombre(liste);
		return temp.get(3) - temp.get(1);
	}

	public static Double moy(ArrayList<Double> liste) {
		Double sum = (double) 0;
		for (double x : liste)
			sum += x;
		return sum / liste.size();
	}

	public static Double moy_t(ArrayList<Double> l1, ArrayList<Double> l2, ArrayList<Double> l3, ArrayList<Double> l4,
			ArrayList<Double> l5, ArrayList<Double> l6, ArrayList<Double> l7) {
		Double sum = (double) 0;
		sum += moy(l1);
		sum += moy(l2);
		sum += moy(l3);
		sum += moy(l4);
		sum += moy(l5);
		sum += moy(l6);
		sum += moy(l7);

		return sum / 7;

	}

	public static int[] mode2(ArrayList<Double> liste) {
		int pos = 0, occr, max = 0;
		int[] intervalle = new int[2]; // intervalle d'amplitude 1
		// Double[] mi_max = min_max(liste);

		// trouver la répétition maximale
		while (pos < liste.size()) {
			intervalle[0] = (int) liste.get(pos).intValue(); // intervalle[0] --> Binferieure
			// if (mi_max[0] == 0.8107 && mi_max[1] == 0.9183)
			// intervalle[1] = (float) (intervalle[0] + 0.2); // intervalle[1] -->
			// Binferieure + 0.2 -> Bsuperieure
			// else
			intervalle[1] = intervalle[0] + 1; // intervalle[1] --> Binferieure + 1 -> Bsuperieure

			occr = 0;

			while (pos < liste.size() && (liste.get(pos) >= intervalle[0] && liste.get(pos) < intervalle[1])) {
				occr++;
				// System.out.print(occr+"\t");
				// System.out.println(liste.get(pos));
				pos++;
			}

			// System.out.println();
			if (occr > max) {
				max = occr;
			}
		}
		System.out.println("occurence max : " + max + ".");
		System.out.print("mode(s) : ");

		// trouver les intervalles où la répétition est maximale
		pos = 0;
		while (pos < liste.size()) {
			intervalle[0] = (int) liste.get(pos).intValue(); // intervalle[0] --> Binferieure
			intervalle[1] = intervalle[0] + 1; // intervalle[1] --> Binferieure + 1 -> Bsuperieure
			occr = 0;

			while (pos < liste.size() && (liste.get(pos) >= intervalle[0] && liste.get(pos) < intervalle[1])) {
				occr++;
				pos++;
			}

			// afficher les intervalles
			if (occr == max) {
				System.out.print("[" + intervalle[0] + ", " + intervalle[1] + "]\t");
			}
		}
		return intervalle;
	}

	// fct - coefficient de correlation
	public static Double coef_correlation(ArrayList<Double> A, ArrayList<Double> B) {
		Double CC = (double) 0, moy_A = moy(A), moy_B = moy(B), ecrtpA = ecar_type(A), ecrtpB = ecar_type(B),
				sum = (double) 0;

		int n = A.size();

		// calculer la somme du produit des valeurs
		for (int i = 0; i < n; i++) {
			sum += A.get(i) * B.get(i);
		}
		CC = (sum - n * moy_A * moy_B) / ((n - 1) * ecrtpA * ecrtpB);

		return CC;
		// return (sum - n*moy_A*moy_B)/((n-1)*ecrtpA*ecrtpB);
	}

	public static String estSymetrique(ArrayList<Double> liste) { // mean < mediane < mode --> négatives | mean >
																	// mediane > mode --> positives
		Double med = resume_5_nombre(liste).get(2);
		Double moy = moy(liste);
		int[] mod = mode2(liste);

		// symétriques
		if (Math.abs(med - moy) < 0.01) // la différence entre les trois valeurs doit etre inférieur à 0.01, càd proche
										// de 0
			return "les données sont symétriques";

		else if (moy < med && med < (mod[0] + mod[1]) / 2)
			return "les données sont Asymétriques à gauche (Négativement)";

		else
			return "les données sont Asymétriques à droite (Positivement)";

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Double moy_t(ArrayList<ArrayList> listes) {
		Double sum = (double) 0;

		for (int i = 0; i < listes.size(); i++)
			sum += moy(listes.get(i));

		return sum / listes.size();

	}

	public static Double etendu(ArrayList<Double> liste) {
		Collections.sort(liste);
		return liste.get(liste.size() - 1) - liste.get(0);
	}

	public static Double milieu_etendu(ArrayList<Double> liste) {
		return (liste.get(liste.size() - 1) + liste.get(0)) / 2;
	}

	public static Double variance(ArrayList<Double> liste) {
		Double sum = (double) 0, moy = moy(liste);
		for (double i : liste)
			sum += Math.pow(i - moy, 2);
		return sum / (liste.size() - 1);
	}

	public static Double ecar_type(ArrayList<Double> liste) {
		return Math.sqrt(variance(liste));
	}
	
	public static Double[] quartiles(ArrayList <Double> liste) {
		int PQ1 = liste.size()/4,			// PQ_ = Position du quartile
			PQ3 = 3* liste.size()/4;
		
		Double Q1 = liste.get(PQ1),
			Q3 = liste.get(PQ3);
		
		Double[] qrtl = new Double[2];
		qrtl[0] = Q1;
		qrtl[1] = Q3;
		
		return qrtl;
	}
	public static ArrayList<Double> outliers2(ArrayList <Double> liste) {
		int i=0;
		Double[] qrtl = quartiles(liste);
		
		Double elt = (double) 0,
			IQR = iqr(liste),
			Bmin = qrtl[0] - 1.5 * IQR,			// qrtl[0] --> Q1
			Bmax = qrtl[1] + 1.5 * IQR;			// qrtl[1] --> Q3
		
		ArrayList <Double> outlr = new ArrayList<Double>();
		
		while (i<liste.size()) {
			elt = liste.get(i);
			
			if (elt<Bmin || elt>Bmax) {
				outlr.add(elt);
			}
			
			i++;
		}
		
	 
 
if (outlr.size() == 0) {
			return null;
		}
		
		return outlr;
	}

	public static ArrayList<Double> outliers(ArrayList<Double> liste) {

		ArrayList<Double> temp = resume_5_nombre(liste);
		Double IQR = iqr(liste), Bmin = temp.get(1) - 1.5 * IQR, Bmax = temp.get(4) + 1.5 * IQR;
		ArrayList<Double> outlr = new ArrayList<Double>();

		for (double x : liste)
			if (x < Bmin || x > Bmax)
				outlr.add(x);

		if (outlr.size() == 0)
			return null;
		return outlr;
	}

	public static Double tau(ArrayList<Double> A, ArrayList<Double> B) throws Exception {
		if (A.size() == 0)
			throw new Exception();
		Collections.sort(A);
		Collections.sort(B);
		double sumAxB = 0;

		for (int i = 0; i < A.size(); i++)
			sumAxB += A.get(i) * B.get(i);

		double n_moyA_moyB = moy(A) * moy(B) * A.size();
		double x = (A.size() - 1) * ecar_type(A) * ecar_type(B);

		return (sumAxB - n_moyA_moyB) / x;
	}

	/**
	 * Create the frame.
	 */
	public IHM() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1357, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 1341, 713);
		contentPane.add(panel);
		panel.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setVisible(false);
		layeredPane.setBounds(10, 36, 1321, 666);
		panel.add(layeredPane);
		layeredPane.setLayout(null);
				
				JPanel description = new JPanel();
				description.setBounds(0, 0, 1321, 666);
				description.setBackground(new Color(174,241,241));
				layeredPane.add(description);
				description.setLayout(null);
				
				lb = new JLabel("");
				lb.setText("<html>Cette base de données représente différentes mesures des propriétés "
						+ "géométriques des grains appartenant à trois variétés différentes de blé.\r\n<br>" + 
						"Une visualisation de haute qualité de la structure interne du noyau a été détectée à l’aide d’une technique de rayons X doux.<br>\r\n" + 
						"Chaque instance est classée dans l’une des trois ‘3’ classes suivantes :\r\n<br>" + 
						"- Rosa avec 69 instances\r\n<br>" + 
						"- Kama avec 65 instances\r\n<br>" + 
						"- Variétés canadiennes avec 76 instances\r\n<br>" + 
						"les caractéristiques de l'ensemble de données : multivariées.\r\n<br>" + 
						"le nombre d'instances : 210.\r\n<br>" + 
						"le nombre d'attributs : 7.\r\n<br>" + 
						"pas de valeurs manquantes.</html>");
				lb.setFont(new Font("Tahoma", Font.BOLD, 19));
				lb.setBounds(69, 174, 1183, 399);
				description.add(lb);
				
				lblLaDescriptionDe = new JLabel("La d\u00E9scription de Data Set");
				lblLaDescriptionDe.setFont(new Font("Tahoma", Font.PLAIN, 41));
				lblLaDescriptionDe.setBounds(348, 33, 531, 56);
				description.add(lblLaDescriptionDe);
		
				JPanel panel_6 = new JPanel();
				
						panel_6.setBackground(new Color(174,241,241));
						panel_6.setBounds(0, 0, 1331, 666);
						layeredPane.add(panel_6);
						panel_6.setLayout(null);
						
								JLabel lblInformationsSurLes = new JLabel("Informations sur les variables ");
								lblInformationsSurLes.setBackground(new Color(0, 0, 0));
								lblInformationsSurLes.setForeground(new Color(0, 0, 0));
								lblInformationsSurLes.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
								lblInformationsSurLes.setBounds(426, 45, 688, 59);
								panel_6.add(lblInformationsSurLes);
								
										JLabel lblAArea = new JLabel("A : Area");
										lblAArea.setBackground(new Color(0, 0, 0));
										lblAArea.setForeground(new Color(0, 0, 0));
										lblAArea.setFont(new Font("Tahoma", Font.BOLD, 23));
										lblAArea.setBounds(447, 158, 423, 44);
										panel_6.add(lblAArea);
										
												JLabel lblPPerimeter = new JLabel("P : Perimeter ");
												lblPPerimeter.setBackground(new Color(0, 0, 0));
												lblPPerimeter.setForeground(new Color(0, 0, 0));
												lblPPerimeter.setFont(new Font("Tahoma", Font.BOLD, 23));
												lblPPerimeter.setBounds(447, 221, 423, 44);
												panel_6.add(lblPPerimeter);
												
														JLabel lblCComactness = new JLabel("C : Comactness");
														lblCComactness.setBackground(new Color(0, 0, 0));
														lblCComactness.setForeground(new Color(0, 0, 0));
														lblCComactness.setFont(new Font("Tahoma", Font.BOLD, 23));
														lblCComactness.setBounds(447, 289, 423, 44);
														panel_6.add(lblCComactness);
														
																JLabel lblLokLengh = new JLabel("LoK : Lengh of Kernel");
																lblLokLengh.setBackground(new Color(0, 0, 0));
																lblLokLengh.setForeground(new Color(0, 0, 0));
																lblLokLengh.setFont(new Font("Tahoma", Font.BOLD, 23));
																lblLokLengh.setBounds(447, 354, 423, 44);
																panel_6.add(lblLokLengh);
																
																		JLabel lblWokWidth = new JLabel("WoK : Width of Kernel");
																		lblWokWidth.setBackground(new Color(0, 0, 0));
																		lblWokWidth.setForeground(new Color(0, 0, 0));
																		lblWokWidth.setFont(new Font("Tahoma", Font.BOLD, 23));
																		lblWokWidth.setBounds(447, 417, 423, 44);
																		panel_6.add(lblWokWidth);
																		
																				JLabel lblAcAsymmetry = new JLabel("AC : Asymmetry Coefficient");
																				lblAcAsymmetry.setBackground(new Color(0, 0, 0));
																				lblAcAsymmetry.setForeground(new Color(0, 0, 0));
																				lblAcAsymmetry.setFont(new Font("Tahoma", Font.BOLD, 23));
																				lblAcAsymmetry.setBounds(447, 485, 423, 44);
																				panel_6.add(lblAcAsymmetry);
																				
																						JLabel lblLokgLength = new JLabel("LoKG : Length of Kernel Groove");
																						lblLokgLength.setBackground(new Color(0, 0, 0));
																						lblLokgLength.setForeground(new Color(0, 0, 0));
																						lblLokgLength.setFont(new Font("Tahoma", Font.BOLD, 23));
																						lblLokgLength.setBounds(447, 547, 423, 44);
																						panel_6.add(lblLokgLength);

		panel_fichier = new JPanel();
		panel_fichier.setBackground(new Color(174,241,241));
		panel_fichier.setBounds(0, 0, 1321, 666);

		layeredPane.add(panel_fichier);
		panel_fichier.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(39, 46, 1164, 357);
		panel_fichier.add(scrollPane_2);

		table_1 = new JTable() {
			public boolean isCellEditable(int d, int c) {
				return false;
			}
		};
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ligne = table_1.getSelectedRow();
				// t9.setText(null);

				s0 = table_1.getModel().getValueAt(ligne, 0).toString();
				text0.setText(s0);
				s1 = table_1.getModel().getValueAt(ligne, 1).toString();
				text1.setText(s1);
				s2 = table_1.getModel().getValueAt(ligne, 2).toString();
				text2.setText(s2);
				s3 = table_1.getModel().getValueAt(ligne, 3).toString();
				text3.setText(s3);
				s4 = table_1.getModel().getValueAt(ligne, 4).toString();
				text4.setText(s4);
				s5 = table_1.getModel().getValueAt(ligne, 5).toString();
				text5.setText(s5);
				s6 = table_1.getModel().getValueAt(ligne, 6).toString();
				text6.setText(s6);
				s7 = table_1.getModel().getValueAt(ligne, 7).toString();
				comboBox_5.setSelectedItem(s7);
				// s7= table_1.getModel().getValueAt(ligne, 2).toString();
				table_1.setSelectionBackground(Color.getColor("a", Color.getHSBColor(520, 50, 50)));
				table_1.setSelectionForeground(Color.BLACK);
			}
		});

		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG", "Class" }));

		theader = table_1.getTableHeader();
		table_1.setFont(new Font("tahome", Font.BOLD, 14));

		scrollPane_2.setViewportView(table_1);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setIcon(new ImageIcon("plus.png"));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_5);
				layeredPane.repaint();
				layeredPane.revalidate();
				k = 1;
			}
		});
		btnAjouter.setBounds(72, 435, 128, 39);
		panel_fichier.add(btnAjouter);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("delete.png"));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ligne != -1) {
					model.removeRow(ligne);

					A.remove(ligne);
					P.remove(ligne);
					C.remove(ligne);
					LoK.remove(ligne);
					WoK.remove(ligne);
					AC.remove(ligne);
					LoKG.remove(ligne);
					ligne = -1;

				} else {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner une instance");
				}
			}
		});
		btnSupprimer.setBounds(209, 435, 128, 39);
		panel_fichier.add(btnSupprimer);

		mt = new JLabel("Moyenne Tranqu\u00E9e :");

		mt.setFont(new Font("Tahoma", Font.BOLD, 21));
		mt.setBounds(901, 416, 388, 69);
		panel_fichier.add(mt);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("edit.png"));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ligne != -1) {
					// model.removeRow(ligne);

					/*
					 * A.remove(ligne); P.remove(ligne); C.remove(ligne); LoK.remove(ligne);
					 * WoK.remove(ligne); AC.remove(ligne); LoKG.remove(ligne); ligne = -1;
					 */
					layeredPane.removeAll();
					layeredPane.add(panel_5);
					layeredPane.repaint();
					layeredPane.revalidate();
					k = 2;

				} else {
					JOptionPane.showMessageDialog(null, "Veuillez selectionner une instance");
				}

			}
		});
		btnModifier.setBounds(347, 435, 128, 39);
		panel_fichier.add(btnModifier);

		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setIcon(new ImageIcon("sauvegarde.png"));
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fichierChooser = new JFileChooser();
				fichierChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				fichierChooser.setAcceptAllFileFilterUsed(false);
				fichierChooser.addChoosableFileFilter(new FileNameExtensionFilter("File (.txt)", "txt"));

				int reps = fichierChooser.showOpenDialog(null);

				if (reps == JFileChooser.APPROVE_OPTION) {

					String line = "";
					try {
						FileWriter myWriter = new FileWriter(fichierChooser.getSelectedFile().getAbsoluteFile());

						for (int i = 0; i < table_1.getRowCount(); i++) {
							for (int j = 0; j < table_1.getColumnCount(); j++) {

								if (j == 7) {
									switch (String.valueOf(table_1.getValueAt(i, j))) {
									case "Kama":
										line += "1";

										break;
									case "Rosa":
										line += "2";
										break;
									case "Canadian":
										line += "3";
										break;
									}

								} else {
									line += String.valueOf(table_1.getValueAt(i, j));

								}
								line += "\t";

							}
							myWriter.write(line + "\n");
							line = "";
						}
						myWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnSauvegarder.setBounds(486, 435, 128, 39);
		panel_fichier.add(btnSauvegarder);

		btnSelectionner = new JButton("Selectionner");
		btnSelectionner.setIcon(new ImageIcon("folder.png"));
		btnSelectionner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fichierChooser = new JFileChooser();
				fichierChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				fichierChooser.setAcceptAllFileFilterUsed(false);
				fichierChooser.addChoosableFileFilter(new FileNameExtensionFilter("File (.txt)", "txt"));
				int reps = fichierChooser.showOpenDialog(null);

				if (reps == JFileChooser.APPROVE_OPTION) {

					try (BufferedReader br = new BufferedReader(
							new FileReader(fichierChooser.getSelectedFile().getAbsolutePath()))) {

						String line;
						String[] temp;
						A.clear();
						P.clear();
						C.clear();
						LoK.clear();
						WoK.clear();
						LoKG.clear();
						Class.clear();
						System.out.println("===>" + Class.size());

						// length of kernel groove
						while ((line = br.readLine()) != null) {

							temp = line.split("\t+");

							A.add(Double.valueOf(temp[0]));
							P.add(Double.valueOf(temp[1]));
							C.add(Double.valueOf(temp[2]));
							LoK.add(Double.valueOf(temp[3]));
							WoK.add(Double.valueOf(temp[4]));
							AC.add(Double.valueOf(temp[5]));
							LoKG.add(Double.valueOf(temp[6]));
							switch (temp[7]) {
							case "1":
								Class.add("Kama");
								break;
							case "2":
								Class.add("Rosa");
								break;
							case "3":
								Class.add("Canadian");
								break;
							}

						}

						System.out.println("" + Class.size());
						model = (DefaultTableModel) table_1.getModel();
						model.getDataVector().removeAllElements();

						for (int i = 0; i < A.size(); i++) {
							rowData[0] = A.get(i);
							rowData[1] = P.get(i);
							rowData[2] = C.get(i);
							rowData[3] = LoK.get(i);
							rowData[4] = WoK.get(i);
							rowData[5] = AC.get(i);
							rowData[6] = LoKG.get(i);
							rowData[7] = Class.get(i);

							model.addRow(rowData);
						}
						DecimalFormat f = new DecimalFormat("#0.0000"); // 3 numbers after comma

						mt.setText("Moyenne Tranquée :" + f.format(moy_t(A, AC, LoK, WoK, C, P, LoKG)));


					}

					catch (IOException Exc) {
						System.out.println("An error occurred.");
						// e.printStackTrace();
					}
				}

			}
		});
		btnSelectionner.setBounds(624, 435, 128, 39);
		panel_fichier.add(btnSelectionner);

		// for (int I=0;I< model.getRowCount();I++)
		// model.removeRow(I);
		// LinkedList <Vols> list = L;
		model = (DefaultTableModel) table_1.getModel();
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(174,241,241));
		panel_5.setBounds(0, 0, 1331, 666);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblP = new JLabel("Perimeter");
		lblP.setBounds(234, 192, 161, 29);
		lblP.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblP);

		text1 = new JTextField();
		text1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});
		text1.setBounds(405, 192, 193, 29);
		panel_5.add(text1);
		text1.setColumns(10);

		JLabel lblCompactnessC = new JLabel("compactness ");
		lblCompactnessC.setBounds(234, 236, 161, 29);
		lblCompactnessC.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblCompactnessC);

		text2 = new JTextField();
		text2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		text2.setBounds(405, 236, 193, 29);
		text2.setColumns(10);
		panel_5.add(text2);

		JLabel lblWidthOfKernel = new JLabel("width of kernel");
		lblWidthOfKernel.setBounds(234, 320, 161, 29);
		lblWidthOfKernel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblWidthOfKernel);

		JLabel lblLengthOfKernel_1 = new JLabel("length of kernel");
		lblLengthOfKernel_1.setBounds(234, 276, 161, 29);
		lblLengthOfKernel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblLengthOfKernel_1);

		text3 = new JTextField();
		text3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		text3.setBounds(405, 276, 193, 29);
		text3.setColumns(10);
		panel_5.add(text3);

		text4 = new JTextField();
		text4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		text4.setBounds(405, 320, 193, 29);
		text4.setColumns(10);
		panel_5.add(text4);

		JLabel lblLengthOfKernel = new JLabel("length of kernel groove");
		lblLengthOfKernel.setBounds(234, 404, 161, 29);
		lblLengthOfKernel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblLengthOfKernel);

		JLabel lblAsymmetryCoefficient = new JLabel("asymmetry coefficient");
		lblAsymmetryCoefficient.setBounds(234, 360, 161, 29);

		lblAsymmetryCoefficient.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblAsymmetryCoefficient);

		text5 = new JTextField();
		text5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		text5.setBounds(405, 360, 193, 29);
		text5.setColumns(10);
		panel_5.add(text5);

		text6 = new JTextField();
		text6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});

		text6.setBounds(405, 404, 193, 29);
		text6.setColumns(10);
		panel_5.add(text6);

		JButton btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon("check.png"));
		btnValider.setBounds(370, 486, 115, 43);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (k == 1) {// ajouter if k==1

					if (text0.getText().equals("") || text1.getText().equals("") || text2.getText().equals("")
							|| text3.getText().equals("") || text4.getText().equals("") || text5.getText().equals("")
							|| text6.getText().equals("")
							|| comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString().equals(""))
						JOptionPane.showMessageDialog(null, "Veuillez remplire tous les champs vides");
					else {
						rowData[0] = text0.getText();
						rowData[1] = text1.getText();
						rowData[2] = text2.getText();
						rowData[3] = text3.getText();
						rowData[4] = text4.getText();
						rowData[5] = text5.getText();
						rowData[6] = text6.getText();
						rowData[7] = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString();
						// rowData[7] = text7.getText() ;

						model.addRow(rowData);
						A.add(Double.valueOf(text0.getText()));
						P.add(Double.valueOf(text1.getText()));
						C.add(Double.valueOf(text2.getText()));
						LoK.add(Double.valueOf(text3.getText()));
						WoK.add(Double.valueOf(text4.getText()));
						AC.add(Double.valueOf(text5.getText()));
						LoKG.add(Double.valueOf(text6.getText()));

						text0.setText("");
						text1.setText("");
						text2.setText("");
						text3.setText("");
						text4.setText("");
						text5.setText("");
						text6.setText("");
						ligne = -1;
						layeredPane.removeAll();
						layeredPane.add(panel_fichier);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				}

				else {

					if (text0.getText().equals("") || text1.getText().equals("") || text2.getText().equals("")
							|| text3.getText().equals("") || text4.getText().equals("") || text5.getText().equals("")
							|| text6.getText().equals("")
							|| comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString().equals(""))
						JOptionPane.showMessageDialog(null, "Veuillez remplire tous les champs vides");
					else {
						if (k == 2) {// sinon modifier
							rowData[0] = text0.getText();
							rowData[1] = text1.getText();
							rowData[2] = text2.getText();
							rowData[3] = text3.getText();
							rowData[4] = text4.getText();
							rowData[5] = text5.getText();
							rowData[6] = text6.getText();
							rowData[7] = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString();
							// (
							model.setValueAt(rowData[0], ligne, 0);
							model.setValueAt(rowData[1], ligne, 1);
							model.setValueAt(rowData[2], ligne, 2);
							model.setValueAt(rowData[3], ligne, 3);
							model.setValueAt(rowData[4], ligne, 4);
							model.setValueAt(rowData[5], ligne, 5);
							model.setValueAt(rowData[6], ligne, 6);
							model.setValueAt(rowData[7], ligne, 7);
							A.set(ligne, Double.valueOf(text0.getText()));
							P.set(ligne, Double.valueOf(text1.getText()));
							C.set(ligne, Double.valueOf(text2.getText()));
							LoK.set(ligne, Double.valueOf(text3.getText()));
							WoK.set(ligne, Double.valueOf(text4.getText()));
							AC.set(ligne, Double.valueOf(text5.getText()));
							LoKG.set(ligne, Double.valueOf(text6.getText()));
							ligne = -1;
							layeredPane.removeAll();
							layeredPane.add(panel_fichier);
							layeredPane.repaint();
							layeredPane.revalidate();
						}
					}
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(btnValider);

		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(234, 152, 161, 29);
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblArea);

		text0 = new JTextField();
		text0.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume(); // ignorer l'événement
				}
			}
		});
		text0.setBounds(405, 152, 193, 29);
		text0.setColumns(10);
		panel_5.add(text0);

		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClass.setBounds(234, 444, 161, 29);
		panel_5.add(lblClass);

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "", "Kama", "Rosa", "canadian" }));
		comboBox_5.setBounds(405, 444, 193, 29);
		panel_5.add(comboBox_5);

		p2 = new JPanel();
		p2.setBackground(new Color(174,241,241));
		p2.setBounds(0, 0, 1321, 666);
		layeredPane.add(p2);
		p2.setLayout(null);

		p3 = new JPanel();
		p3.setBounds(10, 11, 1301, 644);
		p2.add(p3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(174,241,241));
		panel_2.setBounds(0, 0, 1331, 666);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		// work done

		// scrollPane = new JScrollPane();
		// scrollPane.setBounds(245, 111, 958, 432);
		panel_4 = new JPanel();
		panel_4.setBounds(71, 145, 984, 432);
		panel_2.add(panel_4);

		JRadioButton R_BoxPlot = new JRadioButton("BoxPlot");
		R_BoxPlot.setBounds(612, 66, 109, 23);
		panel_2.add(R_BoxPlot);
		R_BoxPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio_boxplot_histo == 2) { // switch to Box Plot
					radio_boxplot_histo = 1;
			 
					panel_4.removeAll();
					DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
					HashMap<String, ArrayList<Double>> test = new HashMap<String, ArrayList<Double>>();
					test.put("", selected_option_list);
					for (String k : test.keySet()) {
						String xAxisLabel = k;
						dataset.add(test.get(k), xAxisLabel, k);// + beta of interactionterm");
					}
					CategoryAxis xAxis = new CategoryAxis("" + selected_option_combobox);
					NumberAxis yAxis = new NumberAxis("Valeur");
					yAxis.setAutoRangeIncludesZero(false);
					BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
					renderer.setFillBox(true);
					renderer.setSeriesToolTipGenerator(1, new BoxAndWhiskerToolTipGenerator());
					renderer.setMeanVisible(false);
					CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
					JFreeChart chart = new JFreeChart("Box Plot", plot);
					ChartPanel chartPanel = new ChartPanel(chart);
					chartPanel.setPreferredSize(new java.awt.Dimension(900, 450));

					renderer.setMaximumBarWidth(0.2);
					panel_4.add(chartPanel);
					panel_4.setVisible(false);
					panel_4.setVisible(true);
				}
			}
		});
		R_BoxPlot.setSelected(true);
		bg2.add(R_BoxPlot);

		JRadioButton R_Histogramme = new JRadioButton("Histogramme");
		R_Histogramme.setBounds(612, 90, 109, 23);
		panel_2.add(R_Histogramme);
		R_Histogramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio_boxplot_histo == 1) { // switch to histogram
					radio_boxplot_histo = 2;
					panel_4.removeAll();
					panel_4.setEnabled(false);
					panel_4.setEnabled(true);
		 
					// histogram goes here
					if (selected_option_list.size() > 0) {
						hist = new Histogramme(selected_option_list.size(), Collections.max(selected_option_list),
								Collections.min(selected_option_list));

						hist.CalculNbInterval();
						hist.CalculAmpInterval();
						hist.GenererIntervalles();
					}
					DefaultCategoryDataset dcd = new DefaultCategoryDataset();
					if (selected_option_list.size() > 0) {
						try {
							hist.CalculFrequencesIntervalles(selected_option_list);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						for (int i = 0; i < hist.getNbInterval(); i++) {
							dcd.setValue(hist.getListeIntervalles().get(i).getFreq(), "Temps d\'execution",
									"[" + hist.getListeIntervalles().get(i).getMin() + ","
											+ hist.getListeIntervalles().get(i).getMax() + "[");
						}
					}
					JFreeChart jchart = ChartFactory.createBarChart(selected_option_combobox, "intevalles",
							"fréquences", dcd, PlotOrientation.VERTICAL, true, true, false);

					// CategoryPlot plot = new categoryPlot
					CategoryPlot plot = jchart.getCategoryPlot();
					DecimalFormat labelFormat = new DecimalFormat("#.00");
					labelFormat.setMultiplier(1);

					plot.getRenderer().setSeriesItemLabelGenerator(0,
							new StandardCategoryItemLabelGenerator("{2}", labelFormat));
					plot.getRenderer().setSeriesItemLabelsVisible(0, true);
					plot.setRangeGridlinePaint(Color.blue);
					// ChartFrame chf=new ChartFrame("Comapraison temps d'execution",jchart,true);
					// chf.setVisible(true);
					// chf.setSize(900,700);
					ChartPanel cp = new ChartPanel(jchart);
					cp.setPreferredSize(new java.awt.Dimension(1000, 450));
					panel_4.removeAll();
					panel_4.add(cp);
					panel_4.updateUI();

				}

			}
		});
		bg2.add(R_Histogramme);
		comboBox = new JComboBox(options);
		comboBox.setBounds(562, 11, 205, 44);
		panel_2.add(comboBox);

		lblMediane = new JLabel("Mediane :");
		lblMediane.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMediane.setBounds(1118, 202, 182, 35);
		panel_2.add(lblMediane);

		lblQ1 = new JLabel("Q1 :");
		lblQ1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQ1.setBounds(1118, 169, 182, 35);
		panel_2.add(lblQ1);

		lblIQR = new JLabel("IQR :");
		lblIQR.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIQR.setBounds(1118, 321, 182, 35);
		panel_2.add(lblIQR);

		lblQ3 = new JLabel("Q3:");
		lblQ3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQ3.setBounds(1118, 240, 182, 35);
		panel_2.add(lblQ3);

		JLabel min = new JLabel("Min");
		min.setFont(new Font("Tahoma", Font.BOLD, 16));
		min.setBounds(1118, 134, 150, 35);
		panel_2.add(min);

		JLabel max = new JLabel("Max");
		max.setFont(new Font("Tahoma", Font.BOLD, 16));
		max.setBounds(1118, 282, 170, 35);
		panel_2.add(max);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option_combobox = comboBox.getItemAt(comboBox.getSelectedIndex()).toString();
				selected_option_list = new ArrayList<Double>();

				switch (selected_option_combobox) {
				case "A":
					selected_option_list.addAll(A);
					break;
				case "P":
					selected_option_list.addAll(P);
					break;
				case "C":
					selected_option_list.addAll(C);
					break;
				case "LoK":
					selected_option_list.addAll(LoK);
					break;
				case "WoK":
					selected_option_list.addAll(WoK);
					break;
				case "AC":
					selected_option_list.addAll(AC);
					break;
				case "LoKG":
					selected_option_list.addAll(LoKG);
					break;
				}
				/* Update Labels */
				if (selected_option_combobox.equals("")) { // Reset

					lblMediane.setText("Mediane: ");

					lblQ1.setText("Q1: ");
					lblIQR.setText("IQR: ");
					lblQ3.setText("Q3: ");
					min.setText("Min:");
					max.setText("Max:");
				} else { // Option exists
					double moy = moy(selected_option_list);
					ArrayList<Double> five_num = resume_5_nombre(selected_option_list);

					double iqr = iqr(selected_option_list);
					ArrayList<Double> outliers = outliers(selected_option_list);
					// reset text area
					DecimalFormat f = new DecimalFormat("#.0000"); // 3 numbers after comma

					lblMediane.setText("Mediane: " + f.format(five_num.get(2)));

					lblQ1.setText("Q1: 0" + f.format(five_num.get(1)));
					lblIQR.setText("IQR: 0" + f.format(iqr));
					lblQ3.setText("Q3: 0" + f.format(five_num.get(3)));
					min.setText("Min: 0" + f.format(five_num.get(0)));
					max.setText("Max: 0" + f.format(five_num.get(4)));

				}
				/* Update Diagrams */
				if (radio_boxplot_histo == 1) { /* Box plot */
					panel_4.removeAll();
					DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
					HashMap<String, ArrayList<Double>> test = new HashMap<String, ArrayList<Double>>();
					test.put("", selected_option_list);
					for (String k : test.keySet()) {
						String xAxisLabel = k;
						dataset.add(test.get(k), xAxisLabel, k);// + beta of interactionterm");
					}
					CategoryAxis xAxis = new CategoryAxis("" + selected_option_combobox);
					NumberAxis yAxis = new NumberAxis("Valeur");
					yAxis.setAutoRangeIncludesZero(false);
					BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
					renderer.setFillBox(true);
					renderer.setSeriesToolTipGenerator(1, new BoxAndWhiskerToolTipGenerator());
					renderer.setMeanVisible(false);
					CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
					JFreeChart chart = new JFreeChart("Box Plot", plot);
					ChartPanel chartPanel = new ChartPanel(chart);
					chartPanel.setPreferredSize(new java.awt.Dimension(900, 450));
					// chart.setBackgroundPaint(new Color(249, 231, 0));
					// chart.setBackgroundPaint(new Color(249, 231, 236));
					renderer.setMaximumBarWidth(0.2);
					panel_4.add(chartPanel);
					panel_4.setVisible(false);
					panel_4.setVisible(true);
				} else { /* Histogram */
					panel_4.removeAll();
					panel_4.setEnabled(false);
					panel_4.setEnabled(true);
					/* Histogram goes here */

					if (selected_option_list.size() > 0) {
						hist = new Histogramme(selected_option_list.size(), Collections.max(selected_option_list),
								Collections.min(selected_option_list));
					}
					hist.CalculNbInterval();
					hist.CalculAmpInterval();
					hist.GenererIntervalles();
					try {
						hist.CalculFrequencesIntervalles(selected_option_list);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					}

					DefaultCategoryDataset dcd = new DefaultCategoryDataset();
					for (int i = 0; i < hist.getNbInterval(); i++) {
						dcd.setValue(hist.getListeIntervalles().get(i).getFreq(), "Temps d\'execution",
								"[" + hist.getListeIntervalles().get(i).getMin() + ","
										+ hist.getListeIntervalles().get(i).getMax() + "[");
					}
					JFreeChart jchart = ChartFactory.createBarChart(selected_option_combobox, "intevalles",
							"fréquences", dcd, PlotOrientation.VERTICAL, true, true, false);

					// CategoryPlot plot = new categoryPlot
					CategoryPlot plot = jchart.getCategoryPlot();
					DecimalFormat labelFormat = new DecimalFormat("#.00 ");
					labelFormat.setMultiplier(1);

					plot.getRenderer().setSeriesItemLabelGenerator(0,
							new StandardCategoryItemLabelGenerator("{2}", labelFormat));
					// plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
					plot.getRangeAxis().setLabel("1");
					plot.getRenderer().setSeriesItemLabelsVisible(0, true);
					plot.setRangeGridlinePaint(Color.blue);
					// ChartFrame chf=new ChartFrame("Comapraison temps d'execution",jchart,true);
					// chf.setVisible(true);
					// chf.setSize(900,700);
					ChartPanel cp = new ChartPanel(jchart);
					cp.setPreferredSize(new java.awt.Dimension(1000, 450));
					panel_4.removeAll();
					panel_4.add(cp);
					panel_4.updateUI();

				}
			}
		});

		// scrollPane.setViewportView(panel_4);
		panel_3 = new JPanel();
		panel_3.setToolTipText("d");
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(174,241,241));
		panel_3.setBounds(0, 0, 1331, 691);
		layeredPane.add(panel_3);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG" }));
		comboBox_1.setBounds(717, 11, 172, 40);
		comboBox_1.setSelectedIndex(0);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option_combobox1 = comboBox_1.getItemAt(comboBox_1.getSelectedIndex()).toString();
				selected_option_combobox2 = comboBox_2.getItemAt(comboBox_2.getSelectedIndex()).toString();
				selected_option_list1 = new ArrayList<Double>();
				selected_option_list2 = new ArrayList<Double>();

				switch (selected_option_combobox1) {
				case "A":
					selected_option_list1.addAll(A);
					break;
				case "P":
					selected_option_list1.addAll(P);
					break;
				case "C":
					selected_option_list1.addAll(C);
					break;
				case "LoK":
					selected_option_list1.addAll(LoK);
					break;
				case "WoK":
					selected_option_list1.addAll(WoK);
					break;
				case "AC":
					selected_option_list1.addAll(AC);
					break;
				case "LoKG":
					selected_option_list1.addAll(LoKG);
					break;
				}
				switch (selected_option_combobox2) {
				case "A":
					selected_option_list2.addAll(A);
					break;
				case "P":
					selected_option_list2.addAll(P);
					break;
				case "C":
					selected_option_list2.addAll(C);
					break;
				case "LoK":
					selected_option_list2.addAll(LoK);
					break;
				case "WoK":
					selected_option_list2.addAll(WoK);
					break;
				case "AC":
					selected_option_list2.addAll(AC);
					break;
				case "LoKG":
					selected_option_list2.addAll(LoKG);
					break;
				}
				DecimalFormat f = new DecimalFormat("#0.0000"); // 3 numbers after comma
				if(coef_correlation(selected_option_list1, selected_option_list2)==0) {
				
				cc.setText("<html>Coefficient de corélation : "
						+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/>Conclusion : les deux attributs ne sont pas corrélés</html>");
				}
				else {
					if(coef_correlation(selected_option_list1, selected_option_list2)>0) {
						
						cc.setText("<html>Coefficient de corélation : "
								+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/>Conclusion : les deux attributs sont positivement corrélés</html>");
						}else {
								
								cc.setText("<html>Coefficient de corélation : "
										+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/> Conclusion : les deux attributs sont negativement corrélés</html>");

                          }
				}
				if (radio_qq_scatter == 1) { // qq plot
					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection qqplot = new XYSeriesCollection();
					XYSeries data = new XYSeries("Q_Q plot");
					Collections.sort(selected_option_list1);
					Collections.sort(selected_option_list2);
					for (int i = 0; i < selected_option_list1.size(); i++) {

						data.add(selected_option_list1.get(i), selected_option_list2.get(i));
					}
					qqplot.addSeries(data);
					JFreeChart qqPlotChart = ChartFactory.createScatterPlot("qq-Plot", selected_option_combobox1,
							selected_option_combobox2, qqplot);
					ChartPanel qqPlotPanel = new ChartPanel(qqPlotChart);
					panel_Scatter.add(qqPlotPanel);
					panel_Scatter.setVisible(true);
					qqPlotPanel.setMouseZoomable(true);
					qqPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					qqPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);

					qqPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					qqPlotPanel.setSize(1200, 440);

				} else {
					selected_option_list1_kama.clear();
					selected_option_list2_kama.clear();
					selected_option_list1_rosa.clear();
					selected_option_list2_rosa.clear();
					selected_option_list1_canadian.clear();
					selected_option_list2_canadian.clear();
					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);

					for (int i = 0; i < Class.size(); i++) {
						switch (Class.get(i)) {

						case "Kama":
							selected_option_list1_kama.add(selected_option_list1.get(i));
							selected_option_list2_kama.add(selected_option_list2.get(i));
							break;
						case "Rosa":
							selected_option_list1_rosa.add(selected_option_list1.get(i));
							selected_option_list2_rosa.add(selected_option_list2.get(i));
							break;
						case "Canadian":
							selected_option_list1_canadian.add(selected_option_list1.get(i));
							selected_option_list2_canadian.add(selected_option_list2.get(i));
							break;
						}
					}

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection collection = new XYSeriesCollection();
					XYSeries serie_kama = new XYSeries("Kama");
					XYSeries serie_rosa = new XYSeries("Rosa");
					XYSeries serie_canadian = new XYSeries("Canadian");
					for (int i = 0; i < selected_option_list1_kama.size(); i++) {
						serie_kama.add(selected_option_list1_kama.get(i), selected_option_list2_kama.get(i));
					}
					for (int i = 0; i < selected_option_list1_rosa.size(); i++) {
						serie_rosa.add(selected_option_list1_rosa.get(i), selected_option_list2_rosa.get(i));
					}
					for (int i = 0; i < selected_option_list1_canadian.size(); i++) {
						serie_canadian.add(selected_option_list1_canadian.get(i),
								selected_option_list2_canadian.get(i));
					}
					collection.addSeries(serie_kama);
					collection.addSeries(serie_rosa);
					collection.addSeries(serie_canadian);
					JFreeChart scatterPlotChart = ChartFactory.createScatterPlot("Scatter Plot",
							selected_option_combobox1, selected_option_combobox2, collection);
					scatterPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					scatterPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);
					ChartPanel scatterPlotPanel = new ChartPanel(scatterPlotChart);
					//
					panel_Scatter.add(scatterPlotPanel);
					panel_Scatter.setVisible(true);
					scatterPlotPanel.setVisible(true);
					scatterPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					scatterPlotPanel.setSize(1200, 440);
					panel_Scatter.add(scatterPlotPanel);
				}
			}
		});
		panel_3.add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG" }));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(436, 11, 172, 40);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option_combobox1 = comboBox_1.getItemAt(comboBox_1.getSelectedIndex()).toString();
				selected_option_combobox2 = comboBox_2.getItemAt(comboBox_2.getSelectedIndex()).toString();
				selected_option_list1 = new ArrayList<Double>();
				selected_option_list2 = new ArrayList<Double>();

				switch (selected_option_combobox1) {
				case "A":
					selected_option_list1.addAll(A);
					break;
				case "P":
					selected_option_list1.addAll(P);
					break;
				case "C":
					selected_option_list1.addAll(C);
					break;
				case "LoK":
					selected_option_list1.addAll(LoK);
					break;
				case "WoK":
					selected_option_list1.addAll(WoK);
					break;
				case "AC":
					selected_option_list1.addAll(AC);
					break;
				case "LoKG":
					selected_option_list1.addAll(LoKG);
					break;
				}
				switch (selected_option_combobox2) {
				case "A":
					selected_option_list2.addAll(A);
					break;
				case "P":
					selected_option_list2.addAll(P);
					break;
				case "C":
					selected_option_list2.addAll(C);
					break;
				case "LoK":
					selected_option_list2.addAll(LoK);
					break;
				case "WoK":
					selected_option_list2.addAll(WoK);
					break;
				case "AC":
					selected_option_list2.addAll(AC);
					break;
				case "LoKG":
					selected_option_list2.addAll(LoKG);
					break;
				}
				DecimalFormat f = new DecimalFormat("#0.0000"); // 3 numbers after comma

					if(coef_correlation(selected_option_list1, selected_option_list2)==0) {
				
				cc.setText("<html>Coefficient de corélation : "
						+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/> Conclusion : les deux attributs ne sont pas corrélés</html>");
				}
				else {
					if(coef_correlation(selected_option_list1, selected_option_list2)>0) {
						
						cc.setText("<html>Coefficient de corélation : "
								+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/> Conclusion : les deux attributs sont positivement corrélés</html>");
						}else {
								
								cc.setText("<html>Coefficient de corélation : "
										+ f.format(coef_correlation(selected_option_list1, selected_option_list2))+"<br/> Conclusion : les deux attributs sont negativement corrélés</html>");

                          }
				}				if (radio_qq_scatter == 1) {

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection qqplot = new XYSeriesCollection();
					XYSeries data = new XYSeries("Q_Q plot");
					Collections.sort(selected_option_list1);
					Collections.sort(selected_option_list2);
					for (int i = 0; i < selected_option_list1.size(); i++) {

						data.add(selected_option_list1.get(i), selected_option_list2.get(i));
					}
					qqplot.addSeries(data);
					JFreeChart qqPlotChart = ChartFactory.createScatterPlot("qq-Plot", selected_option_combobox1,
							selected_option_combobox2, qqplot);
					ChartPanel qqPlotPanel = new ChartPanel(qqPlotChart);
					panel_Scatter.add(qqPlotPanel);
					panel_Scatter.setVisible(true);
					qqPlotPanel.setMouseZoomable(true);
					qqPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					qqPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);

					qqPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					qqPlotPanel.setSize(1200, 440);

				} else {
					selected_option_list1_kama.clear();
					selected_option_list2_kama.clear();
					selected_option_list1_rosa.clear();
					selected_option_list2_rosa.clear();
					selected_option_list1_canadian.clear();
					selected_option_list2_canadian.clear();

					for (int i = 0; i < Class.size(); i++) {
						switch (Class.get(i)) {

						case "Kama":
							selected_option_list1_kama.add(selected_option_list1.get(i));
							selected_option_list2_kama.add(selected_option_list2.get(i));
							break;
						case "Rosa":
							selected_option_list1_rosa.add(selected_option_list1.get(i));
							selected_option_list2_rosa.add(selected_option_list2.get(i));
							break;
						case "Canadian":
							selected_option_list1_canadian.add(selected_option_list1.get(i));
							selected_option_list2_canadian.add(selected_option_list2.get(i));
							break;
						}
					}

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection collection = new XYSeriesCollection();
					XYSeries serie_kama = new XYSeries("Kama");
					XYSeries serie_rosa = new XYSeries("Rosa");
					XYSeries serie_canadian = new XYSeries("Canadian");
					for (int i = 0; i < selected_option_list1_kama.size(); i++) {
						serie_kama.add(selected_option_list1_kama.get(i), selected_option_list2_kama.get(i));
					}
					for (int i = 0; i < selected_option_list1_rosa.size(); i++) {
						serie_rosa.add(selected_option_list1_rosa.get(i), selected_option_list2_rosa.get(i));
					}
					for (int i = 0; i < selected_option_list1_canadian.size(); i++) {
						serie_canadian.add(selected_option_list1_canadian.get(i),
								selected_option_list2_canadian.get(i));
					}
					collection.addSeries(serie_kama);
					collection.addSeries(serie_rosa);
					collection.addSeries(serie_canadian);
					JFreeChart scatterPlotChart = ChartFactory.createScatterPlot("Scatter Plot",
							selected_option_combobox1, selected_option_combobox2, collection);
					scatterPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					scatterPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);
					ChartPanel scatterPlotPanel = new ChartPanel(scatterPlotChart);
					//
					panel_Scatter.add(scatterPlotPanel);
					panel_Scatter.setVisible(true);
					scatterPlotPanel.setVisible(true);
					scatterPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					scatterPlotPanel.setSize(1200, 440);
					panel_Scatter.add(scatterPlotPanel);
				}

			}
		});

		panel_3.add(comboBox_2);

		panel_Scatter = new JPanel();
		panel_Scatter.setBounds(70, 141, 1187, 436);
		panel_3.add(panel_Scatter);
		panel_Scatter.setLayout(null);

		rscatterplot = new JRadioButton("Scatter Plot");
		rscatterplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio_qq_scatter == 1) {
					selected_option_list1_kama.clear();
					selected_option_list2_kama.clear();
					selected_option_list1_rosa.clear();
					selected_option_list2_rosa.clear();
					selected_option_list1_canadian.clear();
					selected_option_list2_canadian.clear();
					radio_qq_scatter = 2;

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);

					for (int i = 0; i < Class.size(); i++) {
						switch (Class.get(i)) {

						case "Kama":
							selected_option_list1_kama.add(selected_option_list1.get(i));
							selected_option_list2_kama.add(selected_option_list2.get(i));
							break;
						case "Rosa":
							selected_option_list1_rosa.add(selected_option_list1.get(i));
							selected_option_list2_rosa.add(selected_option_list2.get(i));
							break;
						case "Canadian":
							selected_option_list1_canadian.add(selected_option_list1.get(i));
							selected_option_list2_canadian.add(selected_option_list2.get(i));
							break;
						}
					}

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection collection = new XYSeriesCollection();
					XYSeries serie_kama = new XYSeries("Kama");
					XYSeries serie_rosa = new XYSeries("Rosa");
					XYSeries serie_canadian = new XYSeries("Canadian");
					for (int i = 0; i < selected_option_list1_kama.size(); i++) {
						serie_kama.add(selected_option_list1_kama.get(i), selected_option_list2_kama.get(i));
					}
					for (int i = 0; i < selected_option_list1_rosa.size(); i++) {
						serie_rosa.add(selected_option_list1_rosa.get(i), selected_option_list2_rosa.get(i));
					}
					for (int i = 0; i < selected_option_list1_canadian.size(); i++) {
						serie_canadian.add(selected_option_list1_canadian.get(i),
								selected_option_list2_canadian.get(i));
					}
					collection.addSeries(serie_kama);
					collection.addSeries(serie_rosa);
					collection.addSeries(serie_canadian);
					JFreeChart scatterPlotChart = ChartFactory.createScatterPlot("Scatter Plot",
							selected_option_combobox1, selected_option_combobox2, collection);
					scatterPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					scatterPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);
					ChartPanel scatterPlotPanel = new ChartPanel(scatterPlotChart);
					//
					panel_Scatter.add(scatterPlotPanel);
					panel_Scatter.setVisible(true);
					scatterPlotPanel.setVisible(true);
					scatterPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					scatterPlotPanel.setSize(1200, 440);// 70, 141, 1187, 436
					panel_Scatter.add(scatterPlotPanel);

				}
			}
		});
		rscatterplot.setBounds(593, 85, 109, 23);

		panel_3.add(rscatterplot);

		rqqplot = new JRadioButton("Q_Q plot");
		rqqplot.setSelected(true);
		rqqplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio_qq_scatter == 2) {
					radio_qq_scatter = 1;
					ArrayList<Double> temp1 = new ArrayList<Double>();
					temp1.addAll(selected_option_list1);
					ArrayList<Double> temp2 = new ArrayList<Double>();
					temp2.addAll(selected_option_list1);

					panel_Scatter.removeAll();
					panel_Scatter.setEnabled(false);
					panel_Scatter.setEnabled(true);
					XYSeriesCollection qqplot = new XYSeriesCollection();
					XYSeries data = new XYSeries("Q_Q plot");
					Collections.sort(temp1);
					Collections.sort(temp2);
					for (int i = 0; i < temp1.size(); i++) {

						data.add(temp1.get(i), temp2.get(i));
					}
					qqplot.addSeries(data);
					JFreeChart qqPlotChart = ChartFactory.createScatterPlot("qq-Plot", selected_option_combobox1,
							selected_option_combobox2, qqplot);
					ChartPanel qqPlotPanel = new ChartPanel(qqPlotChart);
					panel_Scatter.add(qqPlotPanel);
					panel_Scatter.setVisible(true);
					qqPlotPanel.setMouseZoomable(true);
					qqPlotChart.setBackgroundPaint(Color.LIGHT_GRAY);
					qqPlotChart.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);

					qqPlotPanel.setPreferredSize(new java.awt.Dimension(1200, 440));
					qqPlotPanel.setSize(1200, 440);
				}

			}
		});
		rqqplot.setBounds(593, 111, 109, 23);
		panel_3.add(rqqplot);
		gb3.add(rscatterplot);
		gb3.add(rqqplot);

		cc = new JLabel("Coefficient de cor\u00E9lation :");
		cc.setFont(new Font("Tahoma", Font.BOLD, 22));
		cc.setBounds(100, 588, 1145, 49);
		panel_3.add(cc);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(174,241,241));
		panel_7.setBounds(0, 0, 1321, 666);
		layeredPane.add(panel_7);

		label = new JLabel("Les Mesures de tendance");
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(345, 26, 763, 44);
		panel_7.add(label);

		etendue = new JLabel("L'\u00E9tendue :");
		etendue.setFont(new Font("Tahoma", Font.BOLD, 24));
		etendue.setBounds(363, 138, 477, 44);
		panel_7.add(etendue);

		q1 = new JLabel("Q1 :");
		q1.setFont(new Font("Tahoma", Font.BOLD, 24));
		q1.setBounds(363, 183, 508, 44);
		panel_7.add(q1);

		q2 = new JLabel("Q2 :");
		q2.setFont(new Font("Tahoma", Font.BOLD, 24));
		q2.setBounds(363, 229, 508, 44);
		panel_7.add(q2);

		q3 = new JLabel("Q3 :");
		q3.setFont(new Font("Tahoma", Font.BOLD, 24));
		q3.setBounds(363, 275, 605, 44);
		panel_7.add(q3);

		Iqr = new JLabel("L'\u00E9cart Interquartile :");
		Iqr.setFont(new Font("Tahoma", Font.BOLD, 24));
		Iqr.setBounds(363, 322, 564, 44);
		panel_7.add(Iqr);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "", "A", "P", "C", "LoK", "WoK", "AC", "LoKG" }));

		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Update Labels */

				selected_option_combobox4 = comboBox_4.getItemAt(comboBox_4.getSelectedIndex()).toString();
				selected_option_list4 = new ArrayList<Double>();

				switch (selected_option_combobox4) {
				case "A":
					selected_option_list4.addAll(A);
					break;
				case "P":
					selected_option_list4.addAll(P);
					break;
				case "C":
					selected_option_list4.addAll(C);
					break;
				case "LoK":
					selected_option_list4.addAll(LoK);
					break;
				case "WoK":
					selected_option_list4.addAll(WoK);
					break;
				case "AC":
					selected_option_list4.addAll(AC);
					break;
				case "LoKG":
					selected_option_list4.addAll(LoKG);
					break;
				}
				/* Update Labels */
				if (selected_option_combobox4.equals("")) { // Reset
					etendue.setText("L'étendue : ");
					// moyennetranquee.setText("Moyenne Tranquée: ");
					q1.setText("Q1 : ");
					q2.setText("Q2 : ");
					Iqr.setText("L'écart Interquartile :");
					q3.setText("Q3 :");
					variance.setText("La variance :");
					ecarttype.setText("L'écart Type :");
					outlier.setText("L'outliers :");
					textArea.setVisible(false);
					textArea.setText("");

				} else { // Option exists
					textArea.setText("");
					ArrayList<Double> five_num = resume_5_nombre(selected_option_list4);
					ArrayList<Double> outliers = outliers2(selected_option_list4);
					DecimalFormat f = new DecimalFormat("#.0000"); // 3 numbers after comma
					etendue.setText("L'étendue : 0" + f.format(etendu(selected_option_list4)));
					q1.setText("Q1 : 0" + f.format(five_num.get(1)));
					q2.setText("Q2 : 0" + f.format(resume_5_nombre(selected_option_list4).get(2)));
					Iqr.setText("L'écart Interquartile : 0" + f.format(iqr(selected_option_list4)));
					q3.setText("Q3 :" + f.format(five_num.get(3)));
					variance.setText("La variance :0" + f.format(variance(selected_option_list4)));
					ecarttype.setText("L'écart Type :0" + f.format(ecar_type(selected_option_list4)));
					outlier.setText("L'outliers :");
					milieuetendue.setText("Milieu de L'etnendu: 0" + f.format(milieu_etendu(selected_option_list4)));

					if (outliers == null)
						textArea.append("Pas des outliers");
					else
						for (double x : outliers)
							textArea.append("0" + f.format(x) + "\n");
					textArea.setVisible(true);

//		   				 
				}

			}
		});
		comboBox_4.setBounds(363, 81, 270, 35);
		panel_7.add(comboBox_4);

		variance = new JLabel("La variance :");
		variance.setFont(new Font("Tahoma", Font.BOLD, 24));
		variance.setBounds(363, 377, 592, 44);
		panel_7.add(variance);

		ecarttype = new JLabel("L'\u00E9cart Type");
		ecarttype.setFont(new Font("Tahoma", Font.BOLD, 24));
		ecarttype.setBounds(363, 436, 616, 44);
		panel_7.add(ecarttype);

		outlier = new JLabel("L'outliers :");
		outlier.setFont(new Font("Tahoma", Font.BOLD, 24));
		outlier.setBounds(363, 491, 592, 44);
		panel_7.add(outlier);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(363, 532, 161, 123);
		panel_7.add(scrollPane_3);

		textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1321, 666);
		panel_1.setBackground(new Color(174,241,241));
		layeredPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLesMesuresDe = new JLabel("Les Mesures de tendance");
		lblLesMesuresDe.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblLesMesuresDe.setBounds(345, 26, 734, 44);
		panel_1.add(lblLesMesuresDe);

		moyenne1 = new JLabel("Moyenne  :");
		moyenne1.setFont(new Font("Tahoma", Font.BOLD, 23));
		moyenne1.setBounds(363, 138, 405, 44);
		panel_1.add(moyenne1);

		mediane = new JLabel("M\u00E9diane :");
		mediane.setFont(new Font("Tahoma", Font.BOLD, 23));
		mediane.setBounds(363, 183, 388, 44);
		panel_1.add(mediane);

		mode2 = new JLabel("Mode :");
		mode2.setFont(new Font("Tahoma", Font.BOLD, 23));
		mode2.setBounds(363, 229, 658, 44);
		panel_1.add(mode2);

		milieuetendue = new JLabel("Le milieu de L'\u00E9tendue :");
		milieuetendue.setFont(new Font("Tahoma", Font.BOLD, 23));
		milieuetendue.setBounds(363, 275, 641, 44);
		panel_1.add(milieuetendue);

		conclusion = new JLabel("Conclusion :");
		conclusion.setFont(new Font("Tahoma", Font.BOLD, 23));
		conclusion.setBounds(363, 322, 904, 44);
		panel_1.add(conclusion);

		comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option_combobox3 = comboBox_3.getItemAt(comboBox_3.getSelectedIndex()).toString();
				selected_option_listb = new ArrayList<Double>();

				switch (selected_option_combobox3) {
				case "A":
					selected_option_listb.addAll(A);
					break;
				case "P":
					selected_option_listb.addAll(P);
					break;
				case "C":
					selected_option_listb.addAll(C);
					break;
				case "LoK":
					selected_option_listb.addAll(LoK);
					break;
				case "WoK":
					selected_option_listb.addAll(WoK);
					break;
				case "AC":
					selected_option_listb.addAll(AC);
					break;
				case "LoKG":
					selected_option_listb.addAll(LoKG);
					break;
				}
				/* Update Labels */
				if (selected_option_combobox3.equals("")) { // Reset
					moyenne1.setText("Moyenne : ");
					mediane.setText("Médiane : ");
					mode2.setText("Mode : ");
					milieuetendue.setText("Le milieu de L'étendue : ");
					conclusion.setVisible(false);
					conclusion.setText("Conclusion : ");

				} else { // Option exists
					double moy = moy(selected_option_listb);

					DecimalFormat f = new DecimalFormat("#.0000"); // 3 numbers after comma
					moyenne1.setText("Moyenne : 0" + f.format(moy));
					// moyennetranquee.setText("Moyenne Tranquée: "+f);
					mediane.setText("Médiane : 0" + f.format(resume_5_nombre(selected_option_listb).get(2)));
					mode2.setText("Mode : " + mode(selected_option_listb));
					int moyinterval = (i1 + i2) / 2;
					System.out.println("" + moyinterval);
					milieuetendue
							.setText("Le milieu de L'étendue : 0" + f.format(milieu_etendu(selected_option_listb)));
					conclusion.setVisible(true);

					conclusion.setText("Conclusion : " + estSymetrique(selected_option_listb));

					// if()

				}
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "", "A", "P", "C", "LoK", "WoK", "AC", "LoKG" }));
		comboBox_3.setBounds(363, 81, 270, 35);
		panel_1.add(comboBox_3);
		gb3 = new ButtonGroup();

		bg2 = new ButtonGroup();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 305, 36);
		panel.add(menuBar);

		JMenu mnFile = new JMenu("Data Set");
		mnFile.setIcon(new ImageIcon("data.png"));
		menuBar.add(mnFile);

		JMenuItem mntmDataSet = new JMenuItem("Informations");
		mntmDataSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				layeredPane.removeAll();
				layeredPane.add(panel_6);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});

		mntmAffichages = new JMenuItem("affichages");
		mntmAffichages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				layeredPane.removeAll();
				layeredPane.add(panel_fichier);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		mnFile.add(mntmAffichages);
		mnFile.add(mntmDataSet);
		
		JMenuItem mntmDetails = new JMenuItem("Details");
		mntmDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				layeredPane.removeAll();
				layeredPane.add(description);
				layeredPane.repaint();
				layeredPane.revalidate();}
		});
		mnFile.add(mntmDetails);

		mnLesGraphes = new JMenu("Les Mesures");
		mnLesGraphes.setIcon(new ImageIcon("tachometer.png"));
		menuBar.add(mnLesGraphes);

		mntmDeTencance = new JMenuItem("De Tencance centrale");
		mntmDeTencance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_1);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}
			}
		});
		mnLesGraphes.add(mntmDeTencance);

		mntmDeDispersion_1 = new JMenuItem("De Dispersion");
		mntmDeDispersion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_7);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}

			}
		});
		mnLesGraphes.add(mntmDeDispersion_1);

		JMenu mnLesGraphes_1 = new JMenu("Les Graphes");
		mnLesGraphes_1.setIcon(new ImageIcon("bar-graph.png"));
		menuBar.add(mnLesGraphes_1);

		mntmHistogrammeEtBoxplot_1 = new JMenuItem("Histogramme et BoxPlot");
		mntmHistogrammeEtBoxplot_1.setIcon(new ImageIcon("box.png"));
		mntmHistogrammeEtBoxplot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_2);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}

			}
		});
		mnLesGraphes_1.add(mntmHistogrammeEtBoxplot_1);

		mntmScatterEtQq_1 = new JMenuItem("Scatter et Q_Q plot");
		mntmScatterEtQq_1.setIcon(new ImageIcon("scatter.png"));
		mntmScatterEtQq_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_3);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}

			}
		});
		mnLesGraphes_1.add(mntmScatterEtQq_1);

		JMenuItem mntmToutLesBoxplot = new JMenuItem("BoxPlot g\u00E9neral");
		mntmToutLesBoxplot.setIcon(new ImageIcon("plot.png"));
		mntmToutLesBoxplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					p3.removeAll();

					BoxAndWhiskerDemo bw = new BoxAndWhiskerDemo();
					p3.add(bw.getChartPanel());
					p3.setVisible(false);
					p3.setVisible(true);

					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(p2);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}

			}
		});
		mnLesGraphes_1.add(mntmToutLesBoxplot);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("fenetre.png"));
		lblNewLabel.setBounds(0, 0, 1341, 713);
		panel.add(lblNewLabel);

		c1 = new JRadioButton("temps d'execution");
		c1.setFont(new Font("Tahoma", Font.BOLD, 14));
		c1.setForeground(new Color(0, 0, 0));
 
		bg.add(c1);
		bg.add(c2);
		 centerRenderer33 = new DefaultTableCellRenderer();
		centerRenderer33.setHorizontalAlignment(JLabel.CENTER);
		 centerRenderer3 = new DefaultTableCellRenderer();
		centerRenderer3.setHorizontalAlignment(JLabel.CENTER);
		ButtonGroup bg = new ButtonGroup();
		 centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
           centerRenderer2 = new DefaultTableCellRenderer();
		centerRenderer2.setHorizontalAlignment(JLabel.CENTER);

 	}
}
