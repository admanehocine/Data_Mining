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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class IHM extends JFrame {
	ChartPanel charPanel;
	ArrayList<String> classpredit=new ArrayList<>();
	JLabel lblMediane;

	JLabel lblQ1;
	double time[]=new double[2] ;
	JLabel lblIQR;
	
	JTextArea textArea;
	JLabel lblQ3;
	int k = 0;
	BoxAndWhiskerDemo bw;
	static int i1;

	static int i2;

	JLabel variance, etendu, ecarttype, outlier;
	int p = 0,iterator = 0;
	int ligne = -1;
	private Histogramme hist;
	JRadioButton rscatterplot, rqqplot;
	ButtonGroup gb3 = new ButtonGroup();;
	Object rowData[] = new Object[8];
	Object rowData1[] = new Object[9];
	String s1 = "", s2 = "", s3 = "", s0 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";
	public static ArrayList<Double>
			A = new ArrayList(), // area
			P = new ArrayList(), // perimeter
			C = new ArrayList(), // compactness C = 4*pi*A/P^2
			LoK = new ArrayList(), // length of kernel
			WoK = new ArrayList(), // width of kernel
			AC = new ArrayList(), // asymmetry coefficient
			LoKG = new ArrayList();
	
	public static ArrayList<Double>
	Atemp = new ArrayList(), // area
	Ptemp = new ArrayList(), // perimeter
	Ctemp = new ArrayList(), // compactness C = 4*pi*A/P^2
	LoKtemp = new ArrayList(), // length of kernel
	WoKtemp = new ArrayList(), // width of kernel
	ACtemp = new ArrayList(), // asymmetry coefficient
	LoKGtemp = new ArrayList();

	public static ArrayList<String>
	Atempd = new ArrayList(), // area
	Ptempd= new ArrayList(), // perimeter
	Ctempd = new ArrayList(), // compactness C = 4*pi*A/P^2
	LoKtempd = new ArrayList(), // length of kernel
	WoKtempd = new ArrayList(), // width of kernel
	ACtempd = new ArrayList(), // asymmetry coefficient
	LoKGtempd = new ArrayList();
ArrayList <String > Classknn=new ArrayList<>();
ArrayList <String > Classtemp=new ArrayList<>();
ArrayList <ArrayList<Integer>> matconfusion = new ArrayList<>();
ArrayList <Double> resMoyKnn = new ArrayList<>();
ArrayList <Double> resMoyNaive = new ArrayList<>();
public static ArrayList<String>
Atempnaive = new ArrayList(), // area
Ptempnaive= new ArrayList(), // perimeter
Ctempnaive = new ArrayList(), // compactness C = 4*pi*A/P^2
LoKtempnaive = new ArrayList(), // length of kernel
WoKtempnaive = new ArrayList(), // width of kernel
ACtempnaive = new ArrayList(), // asymmetry coefficient
LoKGtempnaive = new ArrayList();
	
public static ArrayList<Double>
	Atempknn = new ArrayList(), // area
	Ptempknn = new ArrayList(), // perimeter
	Ctempknn = new ArrayList(), // compactness C = 4*pi*A/P^2
	LoKtempknn = new ArrayList(), // length of kernel
	WoKtempknn = new ArrayList(), // width of kernel
	ACtempknn = new ArrayList(), // asymmetry coefficient
	LoKGtempknn = new ArrayList();

	public static ArrayList<Double>
	Anorm = new ArrayList(), // area
	Pnorm = new ArrayList(), // perimeter
	Cnorm = new ArrayList(), // compactness C = 4*pi*A/P^2
	LoKnorm = new ArrayList(), // length of kernel
	WoKnorm = new ArrayList(), // width of kernel
	ACnorm = new ArrayList(), // asymmetry coefficient
	LoKGnorm = new ArrayList();
	
	public static ArrayList<String>
	Adisc = new ArrayList(), // area
	Pdisc = new ArrayList(), // perimeter
	Cdisc = new ArrayList(), // compactness C = 4*pi*A/P^2
	LoKdisc = new ArrayList(), // length of kernel
	WoKdisc = new ArrayList(), // width of kernel
	ACdisc = new ArrayList(), // asymmetry coefficient
	LoKGdisc = new ArrayList();
	ArrayList<ArrayList<String>> discall=new ArrayList<>();
    public static HashMap<ArrayList<String>, Integer> AprioriResult = new HashMap<>();
	
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
	private JTable tableNorm;
	private JTable tableDiscre;
	public static  Algo_Eclat eclat = new Algo_Eclat();
	private JSpinner spinnerMin;
	private JSpinner spinnerMax;
	private JLabel lblMin;
	private JLabel lblMax;
	private JMenuItem mntmNewMenuItem;
	private JButton btnNormaliser_1;
	private JComboBox comboBoxDiscre;
	private JSpinner spinner;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JLabel lblNewLabel_4;
	private JLabel lblLift;
	private JLabel lblNewLabel_6;
	private static JTextArea textApriori;
	private static JTextArea textAssAp;
	private static JTextArea textCorrAp;
	private JSpinner spinnerMinSupp;
	private JSpinner spinner_MinConf;
	private JPanel eclat_panel;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JScrollPane scrollPane_9;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton button;
	private JLabel label_4;
	private JSpinner spinner_minconfec;
	private JLabel label_5;
	private JSpinner spinner_minsupec;
	private static JTextArea txteclat;
	private static JTextArea txtassec;
	private static JTextArea txtcorrec;
	private JPanel knn;
	private JScrollPane scrollPane_10;
	private JScrollPane scrollPane_11;
	private JLabel lblMatriceDeConfusion;
	private JLabel label_8;
	private JButton button_1;
	private JSpinner spinnerNbrInstanceKnn;
	private JLabel lblNbrInstance;
	private JLabel lblKvoisins;
	private JPanel resultat;
	private JScrollPane scrollPane_17;
	private JScrollPane scrollPane_18;
	private JLabel lblNaiveBayesien;
	private JLabel lblKnn;
	private JLabel lblClassificationSupervise;
	private JComboBox comboInstances;
	private static knn kmean=new knn();
	private static naive_baysien naive=new naive_baysien();
	private JTable table_knn;
	private JComboBox comboformul;
	private JComboBox Kvoisins;
	private JTextArea txtconfknn;
	private JComboBox comboinstancesnaive;
	private JSpinner spinnerNbrInstanceNaive;
	private JTable tablenaive;
	private JTextArea txtmatconfnaive;
	private JTextArea textResKNN;
	private JTextArea textResNaive;
	private JTextArea textComp;
	private JScrollPane scrollPane_12;
	private JPanel temp_execution;
	private JPanel panel_time;
	private JMenu mnFile;
	
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
	
	
	public static ArrayList<ArrayList<Integer>> matriceconfusion(ArrayList<String> predite,int k){
		ArrayList<String> kama=new ArrayList<>();
		ArrayList<String> canadian=new ArrayList<>();
		ArrayList<String> rosa=new ArrayList<>();
		ArrayList<ArrayList<String>> prediteclass=new ArrayList<>();
		ArrayList<ArrayList<Integer>>matconf=new ArrayList<>();
		ArrayList<Integer> ligne1=new ArrayList<>();
		ArrayList<Integer> ligne2=new ArrayList<>();
		ArrayList<Integer> ligne3=new ArrayList<>();
		for(int i=0 ; i<3;i++){
		ligne1.add(0);
		ligne3.add(0);
		ligne2.add(0);
		}
		matconf.add(ligne1);
		matconf.add(ligne2);
		matconf.add(ligne3);
		int ktemp=0;
		for(int i=0 ; i<predite.size();i++) {//recuper les elements pour chaque class
			if(i<k) 
			kama.add(predite.get(i));	
			else {

				if(i>=(k) && i<2*k) 
					rosa.add(predite.get(i));
				
				else
					canadian.add(predite.get(i)); }
			}
		//creation de la matrice
		int nbkama=0;
		for(int i=0 ; i<k;i++)  {
			if(kama.get(i).equals("Kama")) matconf.get(0).set(0, matconf.get(0).get(0)+1);
			else {
			if(kama.get(i).equals("Rosa")) matconf.get(0).set(1, matconf.get(0).get(1)+1);
			else 
			if(kama.get(i).equals("Canadian")) matconf.get(0).set(2, matconf.get(0).get(2)+1);
		}
			
			if(rosa.get(i).equals("Kama")) matconf.get(1).set(0, matconf.get(1).get(0)+1);
			else {
			if(rosa.get(i).equals("Rosa")) matconf.get(1).set(1, matconf.get(1).get(1)+1);
			else 
			if(rosa.get(i).equals("Canadian")) matconf.get(1).set(2, matconf.get(1).get(2)+1);
		}
			
			
			if(canadian.get(i).equals("Kama")) matconf.get(2).set(0, matconf.get(2).get(0)+1);
			else {
			if(canadian.get(i).equals("Rosa")) matconf.get(2).set(1, matconf.get(2).get(1)+1);
			else 
			if(canadian.get(i).equals("Canadian")) matconf.get(2).set(2, matconf.get(2).get(2)+1);
		}
			
			
			
		}
		
		return matconf;
	}


	public static ArrayList<ArrayList<Integer>> matriceconfusiondetails(ArrayList<String> predite,int k){
		ArrayList<String> kama=new ArrayList<>();
		ArrayList<String> canadian=new ArrayList<>();
		ArrayList<String> rosa=new ArrayList<>();
		ArrayList<ArrayList<String>> prediteclass=new ArrayList<>();
		ArrayList<ArrayList<Integer>>matconf=new ArrayList<>();
		ArrayList<Integer> ligne1=new ArrayList<>();
		ArrayList<Integer> ligne2=new ArrayList<>();
		//ArrayList<Integer> ligne3=new ArrayList<>();
		for(int i=0 ; i<2;i++){
		ligne1.add(0);
		ligne2.add(0);
		}
		matconf.add(ligne1);
		matconf.add(ligne2);
		matconf.add(ligne2);
		for(int i=0 ; i<predite.size();i++) {//recuper les elements pour chaque class
			if(i<k) 
			kama.add(predite.get(i));	
			else {

				if(i>=(k) && i<2*k) 
					rosa.add(predite.get(i));
				
				else
					canadian.add(predite.get(i)); }
			}
		//creation de la matrice
		int nb=0;int nb1=0;int nb2=0;
		for(int i=0 ; i<k;i++)  {
			//pour kama true false
			if(rosa.get(i).equals("Kama")) nb++;
			if(canadian.get(i).equals("Kama")) nb++;
			//pour rosa true false

			if(kama.get(i).equals("Rosa")) nb1++;
			if(canadian.get(i).equals("Rosa")) nb1++;
			//pour canadian 

			if(rosa.get(i).equals("Canadian")) nb2++;
			if(kama.get(i).equals("Canadian")) nb2++;
			
		}//pour kama
		matconf.get(0).set(0, nb);matconf.get(0).set(1, k*2-nb);
//pour rosa
		matconf.get(1).set(0, nb1);matconf.get(1).set(1, k*2-nb1);
//pour canadian
		matconf.get(2).set(0, nb2);matconf.get(2).set(1, k*2-nb2);
		return matconf;
	}

	public IHM() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1357, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 51, 51));
		panel.setBounds(0, 0, 1341, 781);
		contentPane.add(panel);
		panel.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setVisible(false);
		layeredPane.setBounds(10, 36, 1321, 702);
		panel.add(layeredPane);
		layeredPane.setLayout(null);
				
				JPanel panel_normal = new JPanel();
				panel_normal.setBackground(new Color(174,241,241));
				panel_normal.setBounds(0, 0, 1321, 702);
				layeredPane.add(panel_normal);
				panel_normal.setLayout(null);
				
				JComboBox comboBoxNorm = new JComboBox();
				comboBoxNorm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBoxNorm.getSelectedIndex() == 1) {
							lblMax.setVisible(true);
							lblMin.setVisible(true);
							spinnerMax.setVisible(true);
							spinnerMin.setVisible(true);
						}else {
							lblMax.setVisible(false);
							lblMin.setVisible(false);
							spinnerMax.setVisible(false);
							spinnerMin.setVisible(false);
						}
					}
				});
				
				btnNormaliser_1 = new JButton("Discretiser");
				btnNormaliser_1.setIcon(new ImageIcon("database.png"));
				btnNormaliser_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean t=false;
						if(tableNorm.getRowCount() != 0) {
							discall=new ArrayList<>();	
							eclat.tvtemp=new HashMap<>();
						if(comboBoxDiscre.getSelectedIndex() == 0) {
							Adisc = new ArrayList<>(DiscreteEffective(Anorm,1,(int)spinner.getValue()));
							Pdisc = new ArrayList<>(DiscreteEffective(Pnorm,2,(int)spinner.getValue())); // perimeter
							Cdisc = new ArrayList<>(DiscreteEffective(Cnorm,3,(int)spinner.getValue())); // compactness C = 4*pi*A/P^2
							LoKdisc = new ArrayList<>(DiscreteEffective(LoKnorm,4,(int)spinner.getValue())); // length of kernel
							WoKdisc = new ArrayList<>(DiscreteEffective(WoKnorm,5,(int)spinner.getValue())); // width of kernel
							ACdisc = new ArrayList<>(DiscreteEffective(ACnorm,6,(int)spinner.getValue())); // asymmetry coefficient
							LoKGdisc = new ArrayList<>(DiscreteEffective(LoKGnorm,7,(int)spinner.getValue()));
							model = (DefaultTableModel) tableDiscre.getModel();
						
							discall.add(Adisc);
							discall.add(Pdisc);
							discall.add(Cdisc);
							discall.add(LoKdisc);
							discall.add(WoKdisc);
							discall.add(ACdisc);
							discall.add(LoKGdisc);
								 
								    
						t=true;
							}else {
								double correction = 0.001;
								Adisc = new ArrayList<>(DiscreteAmplitude(Anorm,1,(int)spinner.getValue(),correction));
								Pdisc = new ArrayList<>(DiscreteAmplitude(Pnorm,2,(int)spinner.getValue(),correction)); // perimeter
								Cdisc = new ArrayList<>(DiscreteAmplitude(Cnorm,3,(int)spinner.getValue(),correction)); // compactness C = 4*pi*A/P^2
								LoKdisc = new ArrayList<>(DiscreteAmplitude(LoKnorm,4,(int)spinner.getValue(),correction)); // length of kernel
								WoKdisc = new ArrayList<>(DiscreteAmplitude(WoKnorm,5,(int)spinner.getValue(),correction)); // width of kernel
								ACdisc = new ArrayList<>(DiscreteAmplitude(ACnorm,6,(int)spinner.getValue(),correction)); // asymmetry coefficient
								LoKGdisc = new ArrayList<>(DiscreteAmplitude(LoKGnorm,7,(int)spinner.getValue(),correction));
								model = (DefaultTableModel) tableDiscre.getModel();
								 
								discall.add(Adisc);
								discall.add(Pdisc);
								discall.add(Cdisc);
								discall.add(LoKdisc);
								discall.add(WoKdisc);
								discall.add(ACdisc);
								discall.add(LoKGdisc);
					t=true;				
							}
						}else {
						t=false;
							JOptionPane.showMessageDialog(null, "Veuillez d'abord normaliser !");
						}
						
						if(t==true) {
						model.getDataVector().removeAllElements();
							for (int i = 0; i < Adisc.size(); i++) {
								rowData[0] = Adisc.get(i);
								rowData[1] = Pdisc.get(i);
								rowData[2] = Cdisc.get(i);
								rowData[3] = LoKdisc.get(i);
								rowData[4] = WoKdisc.get(i);
								rowData[5] = ACdisc.get(i);
								rowData[6] = LoKGdisc.get(i);
								rowData[7] = Class.get(i);

								model.addRow(rowData);
							
								
							}
							eclat.table_v(discall, (int)spinner.getValue());	
							 
						}
					}
				});
				
				JLabel lblNewLabel_3 = new JLabel("Nb d'intervalles");
				lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 12));
				lblNewLabel_3.setBounds(236, 423, 97, 29);
				panel_normal.add(lblNewLabel_3);
				btnNormaliser_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnNormaliser_1.setBounds(443, 423, 141, 29);
				panel_normal.add(btnNormaliser_1);
				
				comboBoxNorm.setFont(new Font("Century Gothic", Font.BOLD, 12));
				comboBoxNorm.setModel(new DefaultComboBoxModel(new String[] {"Z-score", "Min-Max"}));
				comboBoxNorm.setBounds(39, 64, 139, 29);
				panel_normal.add(comboBoxNorm);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(39, 104, 543, 235);
				panel_normal.add(scrollPane_1);
				
				tableNorm = new JTable();
				tableNorm.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG", "Class" }));

				theader = tableNorm.getTableHeader();
				tableNorm.setFont(new Font("Century Gothic", Font.BOLD, 14));
				scrollPane_1.setViewportView(tableNorm);
				
				comboBoxDiscre = new JComboBox();
				comboBoxDiscre.setModel(new DefaultComboBoxModel(new String[] {"Classes d'\u00E9ffectifs \u00E9gaux", "Classes d'amplitudes \u00E9gales"}));
				comboBoxDiscre.setFont(new Font("Century Gothic", Font.BOLD, 12));
				comboBoxDiscre.setBounds(41, 423, 170, 29);
				panel_normal.add(comboBoxDiscre);
				
				JScrollPane scrollPane_1_1 = new JScrollPane();
				scrollPane_1_1.setBounds(41, 463, 543, 220);
				panel_normal.add(scrollPane_1_1);
				
				tableDiscre = new JTable();
				tableDiscre.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG", "Class" }));

				theader = tableDiscre.getTableHeader();
				tableDiscre.setFont(new Font("Century Gothic", Font.BOLD, 14));
				scrollPane_1_1.setViewportView(tableDiscre);
				
				JLabel lblNewLabel_1 = new JLabel("Normalization");
				lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblNewLabel_1.setBounds(39, 24, 209, 29);
				panel_normal.add(lblNewLabel_1);
				
				JLabel lblNewLabel_1_1 = new JLabel("Discretization");
				lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblNewLabel_1_1.setBounds(41, 383, 209, 29);
				panel_normal.add(lblNewLabel_1_1);
				
				spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(3, 3, 5, 1));
				spinner.setBounds(343, 424, 46, 29);
				panel_normal.add(spinner);
				
				JLabel lblNewLabel_2 = new JLabel((String) null);
				lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setOpaque(true);
				lblNewLabel_2.setBounds(22, 370, 583, 321);
				panel_normal.add(lblNewLabel_2);
				
				spinnerMax = new JSpinner();
				spinnerMax.setVisible(false);
				spinnerMax.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
				spinnerMax.setBounds(375, 65, 58, 29);
				panel_normal.add(spinnerMax);
				
				spinnerMin = new JSpinner();
				spinnerMin.setVisible(false);
				spinnerMin.setBounds(243, 65, 58, 29);
				panel_normal.add(spinnerMin);
				
				lblMin = new JLabel("Min");
				lblMin.setVisible(false);
				lblMin.setFont(new Font("Century Gothic", Font.BOLD, 12));
				lblMin.setBounds(212, 64, 21, 29);
				panel_normal.add(lblMin);
				
				lblMax = new JLabel("Max");
				lblMax.setVisible(false);
				lblMax.setFont(new Font("Century Gothic", Font.BOLD, 12));
				lblMax.setBounds(331, 64, 31, 29);
				panel_normal.add(lblMax);
				
				JButton btnNormaliser = new JButton("Normaliser");
				btnNormaliser.setIcon(new ImageIcon("normalisation.png"));
				//normalisation.png
				btnNormaliser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBoxNorm.getSelectedItem().equals("Z-score")) {
							Anorm = new ArrayList<>(Normalize_Z_Score(A));
							Pnorm = new ArrayList<>(Normalize_Z_Score(P)); // perimeter
							Cnorm = new ArrayList<>(Normalize_Z_Score(C)); // compactness C = 4*pi*A/P^2
							LoKnorm = new ArrayList<>(Normalize_Z_Score(LoK)); // length of kernel
							WoKnorm = new ArrayList<>(Normalize_Z_Score(WoK)); // width of kernel
							ACnorm = new ArrayList<>(Normalize_Z_Score(AC)); // asymmetry coefficient
							LoKGnorm = new ArrayList<>(Normalize_Z_Score(LoKG));
							model = (DefaultTableModel) tableNorm.getModel();
						
						
							}else {
								Anorm = new ArrayList<>(NormalizeMinMax(A,(int)spinnerMin.getValue(),(int)spinnerMax.getValue()));
								Pnorm = new ArrayList<>(NormalizeMinMax(P,(int)spinnerMin.getValue(),(int)spinnerMax.getValue())); // perimeter
								Cnorm = new ArrayList<>(NormalizeMinMax(C,(int)spinnerMin.getValue(),(int)spinnerMax.getValue())); // compactness C = 4*pi*A/P^2
								LoKnorm = new ArrayList<>(NormalizeMinMax(LoK,(int)spinnerMin.getValue(),(int)spinnerMax.getValue())); // length of kernel
								WoKnorm = new ArrayList<>(NormalizeMinMax(WoK,(int)spinnerMin.getValue(),(int)spinnerMax.getValue())); // width of kernel
								ACnorm = new ArrayList<>(NormalizeMinMax(AC,(int)spinnerMin.getValue(),(int)spinnerMax.getValue())); // asymmetry coefficient
								LoKGnorm = new ArrayList<>(NormalizeMinMax(LoKG,(int)spinnerMin.getValue(),(int)spinnerMax.getValue()));
								model = (DefaultTableModel) tableNorm.getModel();
								}
						model.getDataVector().removeAllElements();
							for (int i = 0; i < Anorm.size(); i++) {
								rowData[0] = Anorm.get(i);
								rowData[1] = Pnorm.get(i);
								rowData[2] = Cnorm.get(i);
								rowData[3] = LoKnorm.get(i);
								rowData[4] = WoKnorm.get(i);
								rowData[5] = ACnorm.get(i);
								rowData[6] = LoKGnorm.get(i);
								rowData[7] = Class.get(i);

								model.addRow(rowData);
							
								
							}
					}
				});
				btnNormaliser.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnNormaliser.setBounds(443, 64, 139, 27);
				panel_normal.add(btnNormaliser);
				
				JLabel lblNewLabel_2_1 = new JLabel((String) null);
				lblNewLabel_2_1.setOpaque(true);
				lblNewLabel_2_1.setForeground(Color.WHITE);
				lblNewLabel_2_1.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_2_1.setBounds(22, 11, 583, 342);
				panel_normal.add(lblNewLabel_2_1);
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setForeground(Color.BLACK);
				tabbedPane.setBackground(Color.LIGHT_GRAY);
				tabbedPane.setBounds(615, 11, 696, 680);
				panel_normal.add(tabbedPane);
				
				JPanel apriori = new JPanel();
				apriori.setBackground(Color.LIGHT_GRAY);
				tabbedPane.addTab("Apriori", new ImageIcon("apriori.png"), apriori, null);
				tabbedPane.setBackgroundAt(0, Color.WHITE);
				tabbedPane.setForegroundAt(0, Color.BLACK);
				apriori.setLayout(null);
				
				scrollPane_6 = new JScrollPane();
				scrollPane_6.setBounds(10, 50, 671, 267);
				apriori.add(scrollPane_6);
				
				textApriori = new JTextArea();
				textApriori.setFont(new Font("Century Gothic", Font.BOLD, 12));
				scrollPane_6.setViewportView(textApriori);
				
				scrollPane_4 = new JScrollPane();
				scrollPane_4.setBounds(10, 366, 329, 275);
				apriori.add(scrollPane_4);
				
				textAssAp = new JTextArea();
				textAssAp.setFont(new Font("Century Gothic", Font.BOLD, 12));
				scrollPane_4.setViewportView(textAssAp);
				
				scrollPane_5 = new JScrollPane();
				scrollPane_5.setBounds(349, 366, 332, 275);
				apriori.add(scrollPane_5);
				
				textCorrAp = new JTextArea();
				textCorrAp.setFont(new Font("Century Gothic", Font.BOLD, 12));
				scrollPane_5.setViewportView(textCorrAp);
				
				lblNewLabel_4 = new JLabel("R\u00E9gles d'associations");
				lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblNewLabel_4.setBounds(10, 332, 161, 29);
				apriori.add(lblNewLabel_4);
				
				lblLift = new JLabel("R\u00E9gles de corr\u00E9lation");
				lblLift.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblLift.setBounds(442, 332, 193, 29);
				apriori.add(lblLift);
				
				lblNewLabel_6 = new JLabel("Ex\u00E9cution de l'agorithme");
				lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblNewLabel_6.setBounds(10, 10, 329, 29);
				apriori.add(lblNewLabel_6);
				
				JButton btnLancer = new JButton("Lancer");
				btnLancer.setIcon(new ImageIcon("cliquez-ici.png"));
				btnLancer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HashMap<String,Double> res=new HashMap<>();
						HashMap<String,Double> res_lift=new HashMap<>();
						HashMap<String,Double> res_apres_conf=new HashMap<>();
						ArrayList <String> tempkey=new ArrayList<>();
						DecimalFormat f = new DecimalFormat("#0.000");
						if(tableDiscre.getRowCount() != 0) {
							panel_time.removeAll();
							textAssAp.setText("");
							textCorrAp.setText("");
						//Apriori
							double minsupp =  (int)spinnerMinSupp.getValue();
						minsupp /= 100;
						AprioriResult=new HashMap<>();

						long startTime = System.currentTimeMillis();
						Apriori(minsupp);//lancement apriori
					long stopTime = System.currentTimeMillis();
					 
					time[0]=(stopTime - startTime);
						textApriori.append("\n le resultat de l'algorithme : \n"+AprioriResult.toString()
						 +" , nombre d élèments ="+ AprioriResult.size()+"\n");
						eclat.regle_association(AprioriResult);//regle d association apriori
						textAssAp.append("\n Regles d associations : nombre d élèments="+ eclat.regle.size()+"\n" ); 
						for (ArrayList<String> key2 : eclat.regle.keySet()) { //affichage regle d association
							tempkey=new ArrayList<>();
							tempkey.addAll(key2);
							tempkey.remove(tempkey.size()-1);
							textAssAp.append("\n"+tempkey+"=>"+eclat.regle.get(key2));
						}
						res.putAll(eclat.confidance(AprioriResult,A.size()));//regle association confidance
						textAssAp.append("\n Resultats des supports :");
						for (String key2 : eclat.support.keySet()) {
							textAssAp.append("\n"+key2+"="+eclat.support.get(key2));
						}
					
						textAssAp.append("\n\n\n\n\n Resultats du Confidence :  nombre d élèments="+ res.size()+"\n");
						for (String key2 : res.keySet()) {
							
							textAssAp.append("\n"+key2+"="+f.format(res.get(key2)));
						}
						res_apres_conf.putAll(eclat.calcule_minimum_confidance(res,(int)spinner_MinConf.getValue()));
						textAssAp.append("\n\n\n\n\n Resultats final du Confidence : nombre d élèments ="+ res_apres_conf.size()+"\n");
						for (String key2 : res_apres_conf.keySet()) {//regle d association sup a confidance
							textAssAp.append("\n"+key2+"="+f.format(res.get(key2)));
						}
						 
						
						res_lift.putAll(eclat.lift(AprioriResult,A.size()));
						textCorrAp.append("les règles positivement corrélées : nombre d élèments="+ res_lift.size()+"\n");
						for (String key2 : res_lift.keySet()) {//lift de confidance
							if(res_lift.get(key2)>1)
							{
								  	
									textCorrAp.append("\n"+key2+"="+f.format(res_lift.get(key2)));

							}
						}
						
						}else {
							JOptionPane.showMessageDialog(null, "Veuillez  d'abord discretiser !");
						}
					}
				});
				btnLancer.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnLancer.setBounds(570, 10, 111, 27);
				apriori.add(btnLancer);
				
				spinnerMinSupp = new JSpinner();
				spinnerMinSupp.setModel(new SpinnerNumberModel(20, 20, 30, 10));
				spinnerMinSupp.setBounds(506, 10, 54, 27);
				apriori.add(spinnerMinSupp);
				
				JLabel lblMinSupport = new JLabel("Min support (%)");
				lblMinSupport.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblMinSupport.setBounds(385, 10, 111, 29);
				apriori.add(lblMinSupport);
				
				spinner_MinConf = new JSpinner();
				spinner_MinConf.setModel(new SpinnerNumberModel(30, 30, 50, 20));
				spinner_MinConf.setBounds(288, 336, 51, 27);
				apriori.add(spinner_MinConf);
				
				JLabel lblMinConfidance = new JLabel("Min_Conf (%)");
				lblMinConfidance.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblMinConfidance.setBounds(188, 333, 90, 29);
				apriori.add(lblMinConfidance);
				
				eclat_panel = new JPanel();
				eclat_panel.setBackground(Color.LIGHT_GRAY);
				eclat_panel.setLayout(null);
				tabbedPane.addTab("Eclat", new ImageIcon("Eclat.png"), eclat_panel, null);
				tabbedPane.setForegroundAt(1, Color.BLACK);
				tabbedPane.setBackgroundAt(1, Color.WHITE);
				
				scrollPane_7 = new JScrollPane();
				scrollPane_7.setBounds(10, 50, 671, 267);
				eclat_panel.add(scrollPane_7);
				
				txteclat = new JTextArea();
				txteclat.setFont(new Font("Century Gothic", Font.BOLD, 12));
				txteclat.setEditable(false);
				scrollPane_7.setViewportView(txteclat);
				
				scrollPane_8 = new JScrollPane();
				scrollPane_8.setBounds(10, 366, 329, 275);
				eclat_panel.add(scrollPane_8);
				
				txtassec = new JTextArea();
				txtassec.setFont(new Font("Century Gothic", Font.BOLD, 12));
				txtassec.setEditable(false);
				scrollPane_8.setViewportView(txtassec);
				
				scrollPane_9 = new JScrollPane();
				scrollPane_9.setBounds(349, 366, 332, 275);
				eclat_panel.add(scrollPane_9);
				
				txtcorrec = new JTextArea();
				txtcorrec.setFont(new Font("Century Gothic", Font.BOLD, 12));
				txtcorrec.setEditable(false);
				scrollPane_9.setViewportView(txtcorrec);
				
				label_1 = new JLabel("R\u00E9gles d'associations");
				label_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
				label_1.setBounds(10, 332, 161, 29);
				eclat_panel.add(label_1);
				
				label_2 = new JLabel("R\u00E9gles de corr\u00E9lation");
				label_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
				label_2.setBounds(442, 332, 193, 29);
				eclat_panel.add(label_2);
				
				label_3 = new JLabel("Ex\u00E9cution de l'agorithme");
				label_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
				label_3.setBounds(10, 10, 329, 29);
				eclat_panel.add(label_3);
				
				button = new JButton("Lancer");
				button.setIcon(new ImageIcon("cliquez-ici.png"));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HashMap<String,Double> res=new HashMap<>();
						HashMap<String,Double> res_lift=new HashMap<>();
						HashMap<String,Double> res_apres_conf=new HashMap<>();
						ArrayList <String> tempkey=new ArrayList<>();
						DecimalFormat f = new DecimalFormat("#0.000");
						HashMap<ArrayList<String>, Integer> eclatResult=new HashMap<>();
						if(tableDiscre.getRowCount() != 0) {
							txtassec.setText("");
							txtcorrec.setText("");
							panel_time.removeAll();
						//Eclat
							 
							long startTime = System.currentTimeMillis();
							 eclatResult =
					eclat.eclat(discall,(int)spinner_minsupec.getValue(),(int)spinner.getValue(), txteclat);//lancement eclat
									
						long stopTime = System.currentTimeMillis();
					
						time[1]=(stopTime - startTime);
						eclat.regle_association(eclatResult);//regle d association apriori
						txtassec.append("\n Regles d associations : nombre d élèments="+ eclat.regle.size()+"\n" ); 
						for (ArrayList<String> key2 : eclat.regle.keySet()) { //affichage regle d association
							tempkey=new ArrayList<>();
							tempkey.addAll(key2);
							tempkey.remove(tempkey.size()-1);
							txtassec.append("\n"+tempkey+"=>"+eclat.regle.get(key2));
						}
						res.putAll(eclat.confidance(eclatResult,A.size()));//regle association confidance
						txtassec.append("\n Resultats des supports :");
						for (String key2 : eclat.support.keySet()) {
							txtassec.append("\n"+key2+"="+eclat.support.get(key2));
						}
						txtassec.append("\n\n\n\n\n Resultats du Confidence :  nombre d élèments="+ res.size()+"\n");
						for (String key2 : res.keySet()) {
							
							txtassec.append("\n"+key2+"="+f.format(res.get(key2)));
						}
						res_apres_conf.putAll(eclat.calcule_minimum_confidance(res,(int)spinner_minconfec.getValue()));
						txtassec.append("\n\n\n\n\n Resultats final du Confidence : nombre d élèments ="+ res_apres_conf.size()+"\n");
						for (String key2 : res_apres_conf.keySet()) {//regle d association sup a confidance
							txtassec.append("\n"+key2+"="+f.format(res.get(key2)));
						}
						 
						
						res_lift.putAll(eclat.lift(eclatResult,A.size()));
						txtcorrec.append("les règles positivement corrélées : nombre d élèments="+ res_lift.size()+"\n");
						for (String key2 : res_lift.keySet()) {//lift de confidance
							if(res_lift.get(key2)>1)
							{
								  	
								txtcorrec.append("\n"+key2+"="+f.format(res_lift.get(key2)));

							}
						}
						
						}else {
							JOptionPane.showMessageDialog(null, "Veuillez  d'abord discretiser !");
						}		
					}
				});
				button.setFont(new Font("Century Gothic", Font.BOLD, 12));
				button.setBounds(570, 10, 111, 27);
				eclat_panel.add(button);
				
				spinner_minsupec = new JSpinner();
				spinner_minsupec.setModel(new SpinnerNumberModel(20, 20, 30, 10));
				spinner_minsupec.setBounds(506, 10, 54, 27);
				eclat_panel.add(spinner_minsupec);
				
				label_4 = new JLabel("Min support (%)");
				label_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
				label_4.setBounds(385, 10, 111, 29);
				eclat_panel.add(label_4);
				
				spinner_minconfec = new JSpinner();
				spinner_minconfec.setModel(new SpinnerNumberModel(30, 30, 50, 20));
				spinner_minconfec.setBounds(288, 336, 51, 27);
				eclat_panel.add(spinner_minconfec);
				
				label_5 = new JLabel("Min_Conf (%)");
				label_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
				label_5.setBounds(188, 333, 90, 29);
				eclat_panel.add(label_5);
				
				knn = new JPanel();
				knn.setBackground(Color.LIGHT_GRAY);
				knn.setLayout(null);
				tabbedPane.addTab("KNN", new ImageIcon("KNN.png"), knn, null);
				tabbedPane.setForegroundAt(2, Color.BLACK);
				tabbedPane.setBackgroundAt(2, Color.WHITE);
				
				scrollPane_10 = new JScrollPane();
				scrollPane_10.setBounds(10, 89, 671, 267);
				knn.add(scrollPane_10);
				
				table_knn = new JTable();
				table_knn.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG", "Class reel","Class predit" }));

				theader = table_knn.getTableHeader();
				table_knn.setFont(new Font("Century Gothic", Font.BOLD, 14));

				scrollPane_10.setViewportView(table_knn);
				
				scrollPane_11 = new JScrollPane();
				scrollPane_11.setBounds(10, 407, 671, 234);
				knn.add(scrollPane_11);
				
				txtconfknn = new JTextArea();
				txtconfknn.setFont(new Font("Century Gothic", Font.BOLD, 12));
				scrollPane_11.setViewportView(txtconfknn);
				
				lblMatriceDeConfusion = new JLabel("Matrice de confusion");
				lblMatriceDeConfusion.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblMatriceDeConfusion.setBounds(10, 367, 161, 29);
				knn.add(lblMatriceDeConfusion);
				
				label_8 = new JLabel("Ex\u00E9cution de l'agorithme");
				label_8.setFont(new Font("Century Gothic", Font.BOLD, 16));
				label_8.setBounds(10, 10, 199, 29);
				knn.add(label_8);
				
				button_1 = new JButton("Lancer");
				button_1.setIcon(new ImageIcon("cliquez-ici.png"));
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tableNorm.getRowCount() > 0) {
							textResKNN.setText("");
						 	model = (DefaultTableModel) table_knn.getModel();
						
						txtconfknn.setText("");
						Atemp=new ArrayList<>();
						Ptemp=new ArrayList<>();
						Ctemp=new ArrayList<>();
						LoKtemp=new ArrayList<>();
						WoKtemp=new ArrayList<>();
						ACtemp=new ArrayList<>();
						LoKGtemp=new ArrayList<>();
						Classtemp=new ArrayList<>();
						Atempknn=new ArrayList<>();
						Ptempknn=new ArrayList<>();
						Ctempknn=new ArrayList<>();
						LoKtempknn=new ArrayList<>();
						WoKtempknn=new ArrayList<>();
						ACtempknn=new ArrayList<>();
						LoKGtempknn=new ArrayList<>();
						Classknn=new ArrayList<>();
						
						ArrayList <ArrayList <Double>> cres=new ArrayList<ArrayList <Double>>();		
						if(comboInstances.getSelectedIndex()==0) {
							int j=0;
							int k=0;
							while(j<3) {
							
								for(int i=0;i<(int)spinnerNbrInstanceKnn.getValue();i++) {
										
								Atemp.add(Anorm.get(k));
								Ptemp.add(Pnorm.get(k));
								Ctemp.add(Cnorm.get(k));
								LoKtemp.add(LoKnorm.get(k));
								WoKtemp.add(WoKnorm.get(k));
								ACtemp.add(ACnorm.get(k));
								LoKGtemp.add(LoKnorm.get(k));
								Classtemp.add(Class.get(k));
								k++;
							}
								if(Class.get(k).equals("Kama")) {
								while(Class.get(k).equals("Kama")) {
									Atempknn.add(Anorm.get(k));
									Ptempknn.add(Pnorm.get(k));
									Ctempknn.add(Cnorm.get(k));
									LoKtempknn.add(LoKnorm.get(k));
									WoKtempknn.add(WoKnorm.get(k));
									ACtempknn.add(ACnorm.get(k));
									LoKGtempknn.add(LoKnorm.get(k));
									Classknn.add(Class.get(k));	
									k++;
									
								}
								
								
								}else { 
									while(Class.get(k).equals("Rosa")) {
										Atempknn.add(Anorm.get(k));
										Ptempknn.add(Pnorm.get(k));
										Ctempknn.add(Cnorm.get(k));
										LoKtempknn.add(LoKnorm.get(k));
										WoKtempknn.add(WoKnorm.get(k));
										ACtempknn.add(ACnorm.get(k));
										LoKGtempknn.add(LoKnorm.get(k));
										Classknn.add(Class.get(k));	

										k++;
									}
										
								}
								
							j++;
							}
							while(k<Class.size()) {
								Atempknn.add(Anorm.get(k));
								Ptempknn.add(Pnorm.get(k));
								Ctempknn.add(Cnorm.get(k));
								LoKtempknn.add(LoKnorm.get(k));
								WoKtempknn.add(WoKnorm.get(k));
								ACtempknn.add(ACnorm.get(k));
								LoKGtempknn.add(LoKnorm.get(k));
								Classknn.add(Class.get(k));	

								k++;
							}

							
							cres.add(Atempknn);cres.add(Ptempknn);
							cres.add(Ctempknn);cres.add(LoKtempknn);
							cres.add(WoKtempknn);cres.add(ACtempknn);
							cres.add(LoKGtempknn);
							if(comboformul.getSelectedIndex()==0) {//euclidienne
								classpredit=new ArrayList<>();
								for(int p=0;p<Atemp.size();p++) {
								ArrayList <String>tempen=new ArrayList<>();
								tempen.add(String.valueOf(Atemp.get(p)));
								tempen.add(String.valueOf(Ptemp.get(p)));
								tempen.add(String.valueOf(Ctemp.get(p)));
								tempen.add(String.valueOf(LoKtemp.get(p)));
								tempen.add(String.valueOf(WoKtemp.get(p)));
								tempen.add(String.valueOf(ACtemp.get(p)));
								tempen.add(String.valueOf(LoKGtemp.get(p)));
							classpredit.add(kmean.resultat_knn(
						kmean.trier_par_insertion(
					    kmean.calcule_euclidienne(cres,tempen)).get(1),
						Classknn,Integer.parseInt(Kvoisins.getSelectedItem().toString()) ));	
		
								}				
							}else {
										classpredit=new ArrayList<>();
										for(int p=0;p<Atemp.size();p++) {
										ArrayList <String>tempen=new ArrayList<>();
										tempen.add(String.valueOf(Atemp.get(p)));
										tempen.add(String.valueOf(Ptemp.get(p)));
										tempen.add(String.valueOf(Ctemp.get(p)));
										tempen.add(String.valueOf(LoKtemp.get(p)));
										tempen.add(String.valueOf(WoKtemp.get(p)));
										tempen.add(String.valueOf(ACtemp.get(p)));
										tempen.add(String.valueOf(LoKGtemp.get(p)));
									classpredit.add(kmean.resultat_knn(
								kmean.trier_par_insertion(
							    kmean.calcule_Manhattan(cres,tempen)).get(1),
								Classknn,Integer.parseInt(Kvoisins.getSelectedItem().toString()) ));	
											
							
										}
												
									}
							
							model.getDataVector().removeAllElements();

							for (int i = 0; i < Atemp.size(); i++) {
								rowData1[0] = Atemp.get(i);
								rowData1[1] = Ptemp.get(i);
								rowData1[2] = Ctemp.get(i);
								rowData1[3] = LoKtemp.get(i);
								rowData1[4] = WoKtemp.get(i);
								rowData1[5] = ACtemp.get(i);
								rowData1[6] = LoKGtemp.get(i);
								rowData1[7] = Classtemp.get(i);
								rowData1[8] =classpredit.get(i);
								model.addRow(rowData1);
							}

							txtconfknn.append("\nMatrice du confusion : ");
							txtconfknn.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(0).toString()); 

							txtconfknn.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(1).toString()); 

							txtconfknn.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(2).toString()); 
							
							//pour kama
							ArrayList<Integer> temp=new ArrayList<>();
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(0));
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(1)+
									matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(2));
							txtconfknn.append("\nKama : ");
							txtconfknn.append("\n"+temp.toString());
							txtconfknn.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(0).toString());
					
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(0));
							textResKNN.append("\nClasse Kama =============================\n");
							ArrayList<Double> KamaMoy = new ArrayList<>();
							textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
							KamaMoy.add(accuracy(matconfusion));
							textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							KamaMoy.add(sensitivity(matconfusion));
							textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
							KamaMoy.add(specificity(matconfusion));
							textResKNN.append("Precision : "+precision(matconfusion)+"\n");
							KamaMoy.add(precision(matconfusion));
							textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
							KamaMoy.add(rappel(matconfusion));
							textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
							KamaMoy.add(f_score(matconfusion));
							

							//pour rosa
							  temp=new ArrayList<>();
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(1));
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(0)+
									matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(2));
							txtconfknn.append("\nRosa : ");
							txtconfknn.append("\n"+temp.toString());
							txtconfknn.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(1).toString());
							
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(1));
							textResKNN.append("\nClasse Rosa =============================\n");
							ArrayList<Double> RosaMoy = new ArrayList<>();
							textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
							RosaMoy.add(accuracy(matconfusion));
							textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							RosaMoy.add(sensitivity(matconfusion));
							textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
							RosaMoy.add(specificity(matconfusion));
							textResKNN.append("Precision : "+precision(matconfusion)+"\n");
							RosaMoy.add(precision(matconfusion));
							textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
							RosaMoy.add(rappel(matconfusion));
							textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
							RosaMoy.add(f_score(matconfusion));
							
							
							
							//pour kama
							  temp=new ArrayList<>();
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(2));
							temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(0)+
									matriceconfusion(classpredit,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(1));
							txtconfknn.append("\nCanadian: ");
							txtconfknn.append("\n"+temp.toString());
							txtconfknn.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(2).toString());
							
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceKnn.getValue() ).get(2));
							textResKNN.append("\nClasse Canadian =============================\n");
							ArrayList<Double> CanadianMoy = new ArrayList<>();
							textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
							CanadianMoy.add(accuracy(matconfusion));
							textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							CanadianMoy.add(sensitivity(matconfusion));
							textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
							CanadianMoy.add(specificity(matconfusion));
							textResKNN.append("Precision : "+precision(matconfusion)+"\n");
							CanadianMoy.add(precision(matconfusion));
							textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
							CanadianMoy.add(rappel(matconfusion));
							textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
							CanadianMoy.add(f_score(matconfusion));
							
							resMoyKnn = new ArrayList<>();
							for(int i = 0 ; i < CanadianMoy.size();i++)
							resMoyKnn.add((KamaMoy.get(i) + RosaMoy.get(i) + CanadianMoy.get(i))/3);
							
							afficheResKNN();
							
							
							
						}else {
							if(comboInstances.getSelectedIndex()==1) {
								int j=0;
								int k=Anorm.size()-1;
								while(j<3) {
								
									for(int i=0;i<(int)spinnerNbrInstanceKnn.getValue();i++) {
											
									Atemp.add(Anorm.get(k));
									Ptemp.add(Pnorm.get(k));
									Ctemp.add(Cnorm.get(k));
									LoKtemp.add(LoKnorm.get(k));
									WoKtemp.add(WoKnorm.get(k));
									ACtemp.add(ACnorm.get(k));
									LoKGtemp.add(LoKnorm.get(k));
									Classtemp.add(Class.get(k));
									k--;
								}
									if(Class.get(k).equals("Canadian")) {
									while(Class.get(k).equals("Canadian")) {
										Atempknn.add(Anorm.get(k));
										Ptempknn.add(Pnorm.get(k));
										Ctempknn.add(Cnorm.get(k));
										LoKtempknn.add(LoKnorm.get(k));
										WoKtempknn.add(WoKnorm.get(k));
										ACtempknn.add(ACnorm.get(k));
										LoKGtempknn.add(LoKnorm.get(k));
										Classknn.add(Class.get(k));	
										k--;
										
									}
									
									
									}else { 
										while(Class.get(k).equals("Rosa")) {
											Atempknn.add(Anorm.get(k));
											Ptempknn.add(Pnorm.get(k));
											Ctempknn.add(Cnorm.get(k));
											LoKtempknn.add(LoKnorm.get(k));
											WoKtempknn.add(WoKnorm.get(k));
											ACtempknn.add(ACnorm.get(k));
											LoKGtempknn.add(LoKnorm.get(k));
											Classknn.add(Class.get(k));	

											k--;
										}
											
									}
									
								j++;
								}
								while(k>=0) {
									Atempknn.add(Anorm.get(k));
									Ptempknn.add(Pnorm.get(k));
									Ctempknn.add(Cnorm.get(k));
									LoKtempknn.add(LoKnorm.get(k));
									WoKtempknn.add(WoKnorm.get(k));
									ACtempknn.add(ACnorm.get(k));
									LoKGtempknn.add(LoKnorm.get(k));
									Classknn.add(Class.get(k));	

									k--;
								}

								
								cres.add(Atempknn);cres.add(Ptempknn);
								cres.add(Ctempknn);cres.add(LoKtempknn);
								cres.add(WoKtempknn);cres.add(ACtempknn);
								cres.add(LoKGtempknn);
								if(comboformul.getSelectedIndex()==0) {//euclidienne
									classpredit=new ArrayList<>();
									for(int p=0;p<Atemp.size();p++) {
									ArrayList <String>tempen=new ArrayList<>();
									tempen.add(String.valueOf(Atemp.get(p)));
									tempen.add(String.valueOf(Ptemp.get(p)));
									tempen.add(String.valueOf(Ctemp.get(p)));
									tempen.add(String.valueOf(LoKtemp.get(p)));
									tempen.add(String.valueOf(WoKtemp.get(p)));
									tempen.add(String.valueOf(ACtemp.get(p)));
									tempen.add(String.valueOf(LoKGtemp.get(p)));
								classpredit.add(kmean.resultat_knn(
							kmean.trier_par_insertion(
						    kmean.calcule_euclidienne(cres,tempen)).get(1),
							Classknn,Integer.parseInt(Kvoisins.getSelectedItem().toString()) ));	
 						/*
						 * kmean.trier_par_insertion(
											    kmean.calcule_euclidienne(cres,tempen)).get(1)
												
												+kmean.resultat_knn(
														kmean.trier_par_insertion(
															    kmean.calcule_euclidienne(cres,tempen)).get(1),
																Classknn,Integer.parseInt(Kvoisins.getSelectedItem().toString()) )
												
												
												+
						 */
									}				
								}else {
											classpredit=new ArrayList<>();
											for(int p=0;p<Atemp.size();p++) {
											ArrayList <String>tempen=new ArrayList<>();
											tempen.add(String.valueOf(Atemp.get(p)));
											tempen.add(String.valueOf(Ptemp.get(p)));
											tempen.add(String.valueOf(Ctemp.get(p)));
											tempen.add(String.valueOf(LoKtemp.get(p)));
											tempen.add(String.valueOf(WoKtemp.get(p)));
											tempen.add(String.valueOf(ACtemp.get(p)));
											tempen.add(String.valueOf(LoKGtemp.get(p)));
										classpredit.add(kmean.resultat_knn(
									kmean.trier_par_insertion(
								    kmean.calcule_Manhattan(cres,tempen)).get(1),
									Classknn,Integer.parseInt(Kvoisins.getSelectedItem().toString()) ));	
												
								
											}
													
										}
								
								model.getDataVector().removeAllElements();

								for (int i = 0; i < Atemp.size(); i++) {
									rowData1[0] = Atemp.get(i);
									rowData1[1] = Ptemp.get(i);
									rowData1[2] = Ctemp.get(i);
									rowData1[3] = LoKtemp.get(i);
									rowData1[4] = WoKtemp.get(i);
									rowData1[5] = ACtemp.get(i);
									rowData1[6] = LoKGtemp.get(i);
									rowData1[7] = Classtemp.get(i);
									rowData1[8] =classpredit.get(i);
									model.addRow(rowData1);
								}

								ArrayList<String> inverse =new ArrayList<>();
								for(int i=classpredit.size()-1;i>=0;i--)
									inverse.add(classpredit.get(i));
								txtconfknn.append("\nMatrice du confusion : ");
								txtconfknn.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(0).toString()); 

								txtconfknn.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(1).toString()); 

								txtconfknn.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(2).toString()); 
								
									
								
								//pour kama
								ArrayList<Integer> temp=new ArrayList<>();
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(0));
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(1)+
										matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(0).get(2));
								txtconfknn.append("\nKama : ");
								txtconfknn.append("\n"+temp.toString());
								txtconfknn.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(0).toString());
								matconfusion = new ArrayList<>();
								matconfusion.add(temp);
								matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(0));
								textResKNN.append("Classe Kama =============================\n");
								ArrayList<Double> KamaMoy = new ArrayList<>();
								textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
								KamaMoy.add(accuracy(matconfusion));
								textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
								KamaMoy.add(sensitivity(matconfusion));
								textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
								KamaMoy.add(specificity(matconfusion));
								textResKNN.append("Precision : "+precision(matconfusion)+"\n");
								KamaMoy.add(precision(matconfusion));
								textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
								KamaMoy.add(rappel(matconfusion));
								textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
								KamaMoy.add(f_score(matconfusion));
								
								

								//pour rosa
								  temp=new ArrayList<>();
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(1));
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(0)+
										matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(1).get(2));
								txtconfknn.append("\nRosa : ");
								txtconfknn.append("\n"+temp.toString());
								txtconfknn.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(1).toString());
								matconfusion = new ArrayList<>();
								matconfusion.add(temp);
								matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(1));
								textResKNN.append("\nClasse Rosa =============================\n");
								ArrayList<Double> RosaMoy = new ArrayList<>();
								textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
								RosaMoy.add(accuracy(matconfusion));
								textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
								RosaMoy.add(sensitivity(matconfusion));
								textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
								RosaMoy.add(specificity(matconfusion));
								textResKNN.append("Precision : "+precision(matconfusion)+"\n");
								RosaMoy.add(precision(matconfusion));
								textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
								RosaMoy.add(rappel(matconfusion));
								textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
								RosaMoy.add(f_score(matconfusion));

								//pour canadian
								  temp=new ArrayList<>();
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(2));
								temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(0)+
										matriceconfusion(inverse,(int)spinnerNbrInstanceKnn.getValue()).get(2).get(1));
								txtconfknn.append("\nCanadian: ");
								txtconfknn.append("\n"+temp.toString());
								txtconfknn.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(2).toString());
								matconfusion = new ArrayList<>();
								matconfusion.add(temp);
								matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceKnn.getValue() ).get(2));
								textResKNN.append("\nClasse Canadian =============================\n");
								ArrayList<Double> CanadianMoy = new ArrayList<>();
								textResKNN.append("Accuracy : "+accuracy(matconfusion)+"\n");
								CanadianMoy.add(accuracy(matconfusion));
								textResKNN.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
								CanadianMoy.add(sensitivity(matconfusion));
								textResKNN.append("Specificity : "+specificity(matconfusion)+"\n");
								CanadianMoy.add(specificity(matconfusion));
								textResKNN.append("Precision : "+precision(matconfusion)+"\n");
								CanadianMoy.add(precision(matconfusion));
								textResKNN.append("Rappel : "+rappel(matconfusion)+"\n");
								CanadianMoy.add(rappel(matconfusion));
								textResKNN.append("F-Score : "+f_score(matconfusion)+"\n");
								CanadianMoy.add(f_score(matconfusion));
								
								resMoyKnn = new ArrayList<>();
								for(int i = 0 ; i < CanadianMoy.size();i++)
								resMoyKnn.add((KamaMoy.get(i) + RosaMoy.get(i) + CanadianMoy.get(i))/3);
								
								afficheResKNN();
							
							}
						}
						}else {
							JOptionPane.showMessageDialog(null, "Veuillez d'abord normaliser !");
						}
					}
				});
				button_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
				button_1.setBounds(570, 49, 111, 27);
				knn.add(button_1);
				
				spinnerNbrInstanceKnn = new JSpinner();
				spinnerNbrInstanceKnn.setModel(new SpinnerNumberModel(20, 20, 25, 5));
				spinnerNbrInstanceKnn.setBounds(102, 50, 54, 27);
				knn.add(spinnerNbrInstanceKnn);
				
				lblNbrInstance = new JLabel("nbr instance");
				lblNbrInstance.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNbrInstance.setBounds(10, 50, 82, 29);
				knn.add(lblNbrInstance);
				
				lblKvoisins = new JLabel("Nbr K-voisins");
				lblKvoisins.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblKvoisins.setBounds(409, 368, 90, 29);
				knn.add(lblKvoisins);
				
				comboInstances = new JComboBox();
				comboInstances.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					
					
					}
				});
				comboInstances.setFont(new Font("Century Gothic", Font.BOLD, 12));
				comboInstances.setModel(new DefaultComboBoxModel(new String[] {"premi\u00E8res instances", "derni\u00E8res instances"}));
				comboInstances.setBounds(181, 50, 170, 27);
				knn.add(comboInstances);
				
				Kvoisins = new JComboBox();
				Kvoisins.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "10"}));
				Kvoisins.setFont(new Font("Century Gothic", Font.BOLD, 12));
				Kvoisins.setBounds(519, 370, 40, 27);
				knn.add(Kvoisins);
				
				comboformul = new JComboBox();
				comboformul.setModel(new DefaultComboBoxModel(new String[] {"Euclidienne", "Manhattan"}));
				comboformul.setFont(new Font("Century Gothic", Font.BOLD, 12));
				comboformul.setBounds(375, 49, 170, 27);
				knn.add(comboformul);
				
				JPanel naive_baisien = new JPanel();
				naive_baisien.setBackground(Color.LIGHT_GRAY);
				naive_baisien.setLayout(null);
				tabbedPane.addTab("Naive Bayesien", new ImageIcon("Naive.png"), naive_baisien, null);
				tabbedPane.setBackgroundAt(3, Color.WHITE);
				tabbedPane.setForegroundAt(3, Color.BLACK);
				
				JScrollPane scrollPane_10_1 = new JScrollPane();
				scrollPane_10_1.setBounds(10, 89, 671, 267);
				naive_baisien.add(scrollPane_10_1);
				
				tablenaive = new JTable();
				tablenaive.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "A", "P", "C", "LoK", "WoK", "AC", "LoKG", "Class reel","Class predit" }));

				theader = tablenaive.getTableHeader();
				tablenaive.setFont(new Font("Century Gothic", Font.BOLD, 14));

				scrollPane_10_1.setViewportView(tablenaive);
				
				JScrollPane scrollPane_11_1 = new JScrollPane();
				scrollPane_11_1.setBounds(10, 407, 671, 234);
				naive_baisien.add(scrollPane_11_1);
				
				txtmatconfnaive = new JTextArea();
				txtmatconfnaive.setFont(new Font("Century Gothic", Font.BOLD, 12));
				scrollPane_11_1.setViewportView(txtmatconfnaive);
				
				JLabel lblMatriceDeConfusion_1 = new JLabel("Matrice de confusion");
				lblMatriceDeConfusion_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblMatriceDeConfusion_1.setBounds(10, 367, 161, 29);
				naive_baisien.add(lblMatriceDeConfusion_1);
				
				JLabel label_8_1 = new JLabel("Ex\u00E9cution de l'agorithme");
				label_8_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
				label_8_1.setBounds(10, 10, 199, 29);
				naive_baisien.add(label_8_1);
				
				JButton button_1_1 = new JButton("Lancer");
				button_1_1.setIcon(new ImageIcon("cliquez-ici.png"));
				button_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if(tableDiscre.getRowCount() > 0) {
					 
						textResNaive.setText("");
					 	model = (DefaultTableModel) tablenaive.getModel();

						model.getDataVector().removeAllElements();

					 	ArrayList<Float> res=new ArrayList<>();
					 	txtmatconfnaive.setText("");
					Atempd=new ArrayList<>();
					Ptempd=new ArrayList<>();
					Ctempd=new ArrayList<>();
					LoKtempd=new ArrayList<>();
					WoKtempd=new ArrayList<>();
					ACtempd=new ArrayList<>();
					LoKGtempd=new ArrayList<>();
					Classtemp=new ArrayList<>();
					Atempnaive=new ArrayList<>();
					Ptempnaive=new ArrayList<>();
					Ctempnaive=new ArrayList<>();
					LoKtempnaive=new ArrayList<>();
					WoKtempnaive=new ArrayList<>();
					ACtempnaive=new ArrayList<>();
					LoKGtempnaive=new ArrayList<>();
					Classknn=new ArrayList<>();
					
 
					ArrayList <ArrayList <Double>> cres=new ArrayList<ArrayList <Double>>();		
					if(comboinstancesnaive.getSelectedIndex()==0) {
						int j=0;
						int k=0;
						while(j<3) {
						
							for(int i=0;i<(int)spinnerNbrInstanceNaive.getValue();i++) {
									
							Atempd.add(Adisc.get(k));
							Ptempd.add(Pdisc.get(k));
							Ctempd.add(Cdisc.get(k));
							LoKtempd.add(LoKdisc.get(k));
							WoKtempd.add(WoKdisc.get(k));
							ACtempd.add(ACdisc.get(k));
							LoKGtempd.add(LoKGdisc.get(k));
							Classtemp.add(Class.get(k));
							k++;
						}
							if(Class.get(k).equals("Kama")) {
							while(Class.get(k).equals("Kama")) {
								Atempnaive.add(Adisc.get(k));
								Ptempnaive.add(Pdisc.get(k));
								Ctempnaive.add(Cdisc.get(k));
								LoKtempnaive.add(LoKdisc.get(k));
								WoKtempnaive.add(WoKdisc.get(k));
								ACtempnaive.add(ACdisc.get(k));
								LoKGtempnaive.add(LoKGdisc.get(k));
								Classknn.add(Class.get(k));	
								k++;
								
							}
							
							
							}else { 
								while(Class.get(k).equals("Rosa")) {
									Atempnaive.add(Adisc.get(k));
									Ptempnaive.add(Pdisc.get(k));
									Ctempnaive.add(Cdisc.get(k));
									LoKtempnaive.add(LoKdisc.get(k));
									WoKtempnaive.add(WoKdisc.get(k));
									ACtempnaive.add(ACdisc.get(k));
									LoKGtempnaive.add(LoKGdisc.get(k));
									Classknn.add(Class.get(k));	

									k++;
								}
									
							}
							
						j++;
						}
						while(k<Class.size()) {
							Atempnaive.add(Adisc.get(k));
							Ptempnaive.add(Pdisc.get(k));
							Ctempnaive.add(Cdisc.get(k));
							LoKtempnaive.add(LoKdisc.get(k));
							WoKtempnaive.add(WoKdisc.get(k));
							ACtempnaive.add(ACdisc.get(k));
							LoKGtempnaive.add(LoKGdisc.get(k));
							Classknn.add(Class.get(k));	

							k++;
						}

						
					
					
							classpredit=new ArrayList<>();
							for(int p=0;p<Atempd.size();p++) {
							ArrayList <String>tempen=new ArrayList<>();
							tempen.add( Atempd.get(p));
							tempen.add( Ptempd.get(p));
							tempen.add( Ctempd.get(p));
							tempen.add( LoKtempd.get(p));
							tempen.add( WoKtempd.get(p));
							tempen.add( ACtempd.get(p));
							tempen.add( LoKGtempd.get(p));
						classpredit.add(naive.calcule_final_proba
								(naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Atempnaive,"I1"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Ptempnaive,"I2"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Ctempnaive,"I3"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,LoKtempnaive,"I4"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,WoKtempnaive,"I5"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,ACtempnaive,"I6"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,LoKGtempnaive,"I7"),(int)spinner.getValue()),
										tempen, naive.proba_class(Classknn)));
								 				 
			 
									
						}
									 
						
						for (int i = 0; i < Atempd.size(); i++) {
							rowData1[0] = Atempd.get(i);
							rowData1[1] = Ptempd.get(i);
							rowData1[2] = Ctempd.get(i);
							rowData1[3] = LoKtempd.get(i);
							rowData1[4] = WoKtempd.get(i);
							rowData1[5] = ACtempd.get(i);
							rowData1[6] = LoKGtempd.get(i);
							rowData1[7] = Classtemp.get(i);
							rowData1[8] =classpredit.get(i);
							model.addRow(rowData1);
						}

						

						
						///////***
						txtmatconfnaive.append("\nMatrice du confusion : ");
						txtmatconfnaive.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(0).toString()); 

						txtmatconfnaive.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(1).toString()); 

						txtmatconfnaive.append("\n"+matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(2).toString()); 
						
						//pour kama
						ArrayList<Integer> temp=new ArrayList<>();
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(0));
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(1)+
								matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(2));
						txtmatconfnaive.append("\nKama : ");
						txtmatconfnaive.append("\n"+temp.toString());
						txtmatconfnaive.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(0).toString());
						
						matconfusion = new ArrayList<>();
						matconfusion.add(temp);
						matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(0));
						textResNaive.append("Classe Kama =============================\n");
						ArrayList<Double> KamaMoy = new ArrayList<>();
						textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
						KamaMoy.add(accuracy(matconfusion));
						textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
						KamaMoy.add(sensitivity(matconfusion));
						textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
						KamaMoy.add(specificity(matconfusion));
						textResNaive.append("Precision : "+precision(matconfusion)+"\n");
						KamaMoy.add(precision(matconfusion));
						textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
						KamaMoy.add(rappel(matconfusion));
						textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
						KamaMoy.add(f_score(matconfusion));

						//pour rosa
						  temp=new ArrayList<>();
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(1));
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(0)+
								matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(2));
						txtmatconfnaive.append("\nRosa : ");
						txtmatconfnaive.append("\n"+temp.toString());
						txtmatconfnaive.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(1).toString());
						
						matconfusion = new ArrayList<>();
						matconfusion.add(temp);
						matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(1));
						textResNaive.append("\nClasse Rosa =============================\n");
						ArrayList<Double> RosaMoy = new ArrayList<>();
						textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
						RosaMoy.add(accuracy(matconfusion));
						textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
						RosaMoy.add(sensitivity(matconfusion));
						textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
						RosaMoy.add(specificity(matconfusion));
						textResNaive.append("Precision : "+precision(matconfusion)+"\n");
						RosaMoy.add(precision(matconfusion));
						textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
						RosaMoy.add(rappel(matconfusion));
						textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
						RosaMoy.add(f_score(matconfusion));

						//pour canadian
						  temp=new ArrayList<>();
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(2));
						temp.add(matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(0)+
								matriceconfusion(classpredit,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(1));
						txtmatconfnaive.append("\nCanadian: ");
						txtmatconfnaive.append("\n"+temp.toString());
						txtmatconfnaive.append("\n"+matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(2).toString());
						
						matconfusion = new ArrayList<>();
						matconfusion.add(temp);
						matconfusion.add(matriceconfusiondetails(classpredit,(int)spinnerNbrInstanceNaive.getValue() ).get(2));
						textResNaive.append("\nClasse Canadian =============================\n");
						ArrayList<Double> CanadianMoy = new ArrayList<>();
						textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
						CanadianMoy.add(accuracy(matconfusion));
						textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
						CanadianMoy.add(sensitivity(matconfusion));
						textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
						CanadianMoy.add(specificity(matconfusion));
						textResNaive.append("Precision : "+precision(matconfusion)+"\n");
						CanadianMoy.add(precision(matconfusion));
						textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
						CanadianMoy.add(rappel(matconfusion));
						textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
						CanadianMoy.add(f_score(matconfusion));
						
						resMoyNaive = new ArrayList<>();
						for(int i = 0 ; i < CanadianMoy.size();i++)
						resMoyNaive.add((KamaMoy.get(i) + RosaMoy.get(i) + CanadianMoy.get(i))/3);
						
						afficheResNaive();
						//System.out.println("temp A"+Atemp);
					}
					else {
						if(comboinstancesnaive.getSelectedIndex()==1) {
							int j=0;
							int k=Anorm.size()-1;
							while(j<3) {
							

								for(int i=0;i<(int)spinnerNbrInstanceNaive.getValue();i++) {
										
								Atempd.add(Adisc.get(k));
								Ptempd.add(Pdisc.get(k));
								Ctempd.add(Cdisc.get(k));
								LoKtempd.add(LoKdisc.get(k));
								WoKtempd.add(WoKdisc.get(k));
								ACtempd.add(ACdisc.get(k));
								LoKGtempd.add(LoKGdisc.get(k));
								Classtemp.add(Class.get(k));
								k--;
							}
								if(Class.get(k).equals("Canadian")) {
								while(Class.get(k).equals("Canadian")) {
							
									Atempnaive.add(Adisc.get(k));
									Ptempnaive.add(Pdisc.get(k));
									Ctempnaive.add(Cdisc.get(k));
									LoKtempnaive.add(LoKdisc.get(k));
									WoKtempnaive.add(WoKdisc.get(k));
									ACtempnaive.add(ACdisc.get(k));
									LoKGtempnaive.add(LoKGdisc.get(k));
									Classknn.add(Class.get(k));	
									k--;	 
									
								}
								
								
								}else { 
									while(Class.get(k).equals("Rosa")) {
										Atempnaive.add(Adisc.get(k));
										Ptempnaive.add(Pdisc.get(k));
										Ctempnaive.add(Cdisc.get(k));
										LoKtempnaive.add(LoKdisc.get(k));
										WoKtempnaive.add(WoKdisc.get(k));
										ACtempnaive.add(ACdisc.get(k));
										LoKGtempnaive.add(LoKGdisc.get(k));
										Classknn.add(Class.get(k));	

										k--;
									}
										
								}
								
							j++;
							 
						
							}
								 
							while(k>=0) {
							 
							Atempnaive.add(Adisc.get(k));
							Ptempnaive.add(Pdisc.get(k));
							Ctempnaive.add(Cdisc.get(k));
							LoKtempnaive.add(LoKdisc.get(k));
							WoKtempnaive.add(WoKdisc.get(k));
							ACtempnaive.add(ACdisc.get(k));
							LoKGtempnaive.add(LoKGdisc.get(k));
							Classknn.add(Class.get(k));	
							k--;
							}

							 
									 
							
							
							classpredit=new ArrayList<>();
							for(int p=0;p<Atempd.size();p++) {
							ArrayList <String>tempen=new ArrayList<>();
							tempen.add( Atempd.get(p));
							tempen.add( Ptempd.get(p));
							tempen.add( Ctempd.get(p));
							tempen.add( LoKtempd.get(p));
							tempen.add( WoKtempd.get(p));
							tempen.add( ACtempd.get(p));
							tempen.add( LoKGtempd.get(p));
						classpredit.add(naive.calcule_final_proba
								(naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Atempnaive,"I1"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Ptempnaive,"I2"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,Ctempnaive,"I3"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,LoKtempnaive,"I4"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,WoKtempnaive,"I5"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,ACtempnaive,"I6"),(int)spinner.getValue()),
										naive.proba_items_selon_class(naive.recuperer_selon_class(Classknn,LoKGtempnaive,"I7"),(int)spinner.getValue()),
										tempen, naive.proba_class(Classknn)));
								 				 
			 
									
						}
									 
						

						
							
							 
					  			
						 
							
							for (int i = 0; i < Atempd.size(); i++) {
								rowData1[0] = Atempd.get(i);
								rowData1[1] = Ptempd.get(i);
								rowData1[2] = Ctempd.get(i);
								rowData1[3] = LoKtempd.get(i);
								rowData1[4] = WoKtempd.get(i);
								rowData1[5] = ACtempd.get(i);
								rowData1[6] = LoKGtempd.get(i);
								rowData1[7] = Classtemp.get(i);
								rowData1[8] =classpredit.get(i);
								model.addRow(rowData1);
							}

							ArrayList<String> inverse =new ArrayList<>();
							for(int i=classpredit.size()-1;i>=0;i--)
								inverse.add(classpredit.get(i));
							txtmatconfnaive.append("\nMatrice du confusion : ");
							txtmatconfnaive.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(0).toString()); 

							txtmatconfnaive.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(1).toString()); 

							txtmatconfnaive.append("\n"+matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(2).toString()); 
							
								
							
							//pour kama
							ArrayList<Integer> temp=new ArrayList<>();
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(0));
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(1)+
									matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(0).get(2));
							txtmatconfnaive.append("\nKama : ");
							txtmatconfnaive.append("\n"+temp.toString());
							txtmatconfnaive.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(0).toString());
							
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(0));
							
							textResNaive.append("Classe Kama =============================\n");
							ArrayList<Double> KamaMoy = new ArrayList<>();
							textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
							KamaMoy.add(accuracy(matconfusion));
							textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							KamaMoy.add(sensitivity(matconfusion));
							textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
							KamaMoy.add(specificity(matconfusion));
							textResNaive.append("Precision : "+precision(matconfusion)+"\n");
							KamaMoy.add(precision(matconfusion));
							textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
							KamaMoy.add(rappel(matconfusion));
							textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
							KamaMoy.add(f_score(matconfusion));
							

							//pour rosa
							temp=new ArrayList<>();
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(1));
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(0)+
									matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(1).get(2));
							txtmatconfnaive.append("\nRosa : ");
							txtmatconfnaive.append("\n"+temp.toString());
							txtmatconfnaive.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(1).toString());
							
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(1));
							textResNaive.append("\nClasse Rosa =============================\n");
							ArrayList<Double> RosaMoy = new ArrayList<>();
							textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
							RosaMoy.add(accuracy(matconfusion));
							textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							RosaMoy.add(sensitivity(matconfusion));
							textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
							RosaMoy.add(specificity(matconfusion));
							textResNaive.append("Precision : "+precision(matconfusion)+"\n");
							RosaMoy.add(precision(matconfusion));
							textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
							RosaMoy.add(rappel(matconfusion));
							textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
							RosaMoy.add(f_score(matconfusion));

							//pour kama
							  temp=new ArrayList<>();
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(2));
							temp.add(matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(0)+
									matriceconfusion(inverse,(int)spinnerNbrInstanceNaive.getValue()).get(2).get(1));
							txtmatconfnaive.append("\nCanadian: ");
							txtmatconfnaive.append("\n"+temp.toString());
							txtmatconfnaive.append("\n"+matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(2).toString());
							
							matconfusion = new ArrayList<>();
							matconfusion.add(temp);
							matconfusion.add(matriceconfusiondetails(inverse,(int)spinnerNbrInstanceNaive.getValue() ).get(2));
							textResNaive.append("\nClasse Canadian =============================\n");
							ArrayList<Double> CanadianMoy = new ArrayList<>();
							textResNaive.append("Accuracy : "+accuracy(matconfusion)+"\n");
							CanadianMoy.add(accuracy(matconfusion));
							textResNaive.append("Sensitivity : "+sensitivity(matconfusion)+"\n");
							CanadianMoy.add(sensitivity(matconfusion));
							textResNaive.append("Specificity : "+specificity(matconfusion)+"\n");
							CanadianMoy.add(specificity(matconfusion));
							textResNaive.append("Precision : "+precision(matconfusion)+"\n");
							CanadianMoy.add(precision(matconfusion));
							textResNaive.append("Rappel : "+rappel(matconfusion)+"\n");
							CanadianMoy.add(rappel(matconfusion));
							textResNaive.append("F-Score : "+f_score(matconfusion)+"\n");
							CanadianMoy.add(f_score(matconfusion));
							
							resMoyNaive = new ArrayList<>();
							for(int i = 0 ; i < CanadianMoy.size();i++)
							resMoyNaive.add((KamaMoy.get(i) + RosaMoy.get(i) + CanadianMoy.get(i))/3);
							
							afficheResNaive();
							
							
							
						}
					}
					}else {
					
						JOptionPane.showMessageDialog(null, "Veuillez d'abord discrétiser !");
					
					}
					}
				});
				button_1_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
				button_1_1.setBounds(559, 51, 111, 27);
				naive_baisien.add(button_1_1);
				
				spinnerNbrInstanceNaive = new JSpinner();
				spinnerNbrInstanceNaive.setModel(new SpinnerNumberModel(20, 20, 25, 5));
				spinnerNbrInstanceNaive.setBounds(102, 50, 54, 27);
				naive_baisien.add(spinnerNbrInstanceNaive);
				
				JLabel lblNbrInstance_1 = new JLabel("nbr instance");
				lblNbrInstance_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
				lblNbrInstance_1.setBounds(10, 50, 82, 29);
				naive_baisien.add(lblNbrInstance_1);
				
				comboinstancesnaive = new JComboBox();
				comboinstancesnaive.setModel(new DefaultComboBoxModel(new String[] {"premi\u00E8res instances", "derni\u00E8res instances"}));
				comboinstancesnaive.setFont(new Font("Century Gothic", Font.BOLD, 12));
				comboinstancesnaive.setBounds(181, 50, 170, 27);
				naive_baisien.add(comboinstancesnaive);
				
				resultat = new JPanel();
				resultat.setBackground(Color.LIGHT_GRAY);
				resultat.setLayout(null);
				tabbedPane.addTab("R\u00E9sultat", new ImageIcon("Resultat.png"), resultat, null);
				tabbedPane.setForegroundAt(4, Color.BLACK);
				tabbedPane.setBackgroundAt(4, Color.WHITE);
				
				scrollPane_17 = new JScrollPane();
				scrollPane_17.setBounds(10, 68, 329, 371);
				resultat.add(scrollPane_17);
				
				textResNaive = new JTextArea();
				textResNaive.setFont(new Font("Century Gothic", Font.BOLD, 13));
				scrollPane_17.setViewportView(textResNaive);
				
				scrollPane_18 = new JScrollPane();
				scrollPane_18.setBounds(349, 68, 332, 371);
				resultat.add(scrollPane_18);
				
				textResKNN = new JTextArea();
				textResKNN.setFont(new Font("Century Gothic", Font.BOLD, 13));
				scrollPane_18.setViewportView(textResKNN);
				
				lblNaiveBayesien = new JLabel("Naive Bayesien");
				lblNaiveBayesien.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblNaiveBayesien.setBounds(20, 41, 161, 29);
				resultat.add(lblNaiveBayesien);
				
				lblKnn = new JLabel("KNN");
				lblKnn.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblKnn.setBounds(364, 41, 193, 29);
				resultat.add(lblKnn);
				
				lblClassificationSupervise = new JLabel("Classification supervis\u00E9e");
				lblClassificationSupervise.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblClassificationSupervise.setBounds(10, 6, 329, 24);
				resultat.add(lblClassificationSupervise);
				
				scrollPane_12 = new JScrollPane();
				scrollPane_12.setBounds(10, 484, 671, 157);
				resultat.add(scrollPane_12);
				
				textComp = new JTextArea();
				scrollPane_12.setViewportView(textComp);
				textComp.setFont(new Font("Century Gothic", Font.BOLD, 13));
				
				JButton btnNormaliser_1_1 = new JButton("Comparer");
				btnNormaliser_1_1.setIcon(new ImageIcon("comparatif.png"));
				btnNormaliser_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textResKNN.getText().isEmpty() && !textResNaive.getText().isEmpty()) {
							textComp.setText("Comparison entre Naive et KNN :");
							//Accuracy
							if(resMoyNaive.get(0) > resMoyKnn.get(0))
								textComp.append("\nL'algorithme Naive a prédit correctement plus que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(0) < resMoyKnn.get(0))
								textComp.append("\nL'algorithme KNN a prédit correctement plus de classe que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont prédis correctement le meme nombre de classe.");
							}
							//Sensitivity
							if(resMoyNaive.get(1) > resMoyKnn.get(1))
								textComp.append("\nL'algorithme Naive a une meilleure sensitivité que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(1) < resMoyKnn.get(1))
								textComp.append("\nL'algorithme KNN a une meilleure sensitivité que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont la meme sensitivité.");
							}
							//Specificity
							if(resMoyNaive.get(1) > resMoyKnn.get(1))
								textComp.append("\nL'algorithme Naive a une meilleure spécisficité que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(1) < resMoyKnn.get(1))
								textComp.append("\nL'algorithme KNN a une meilleure spécificité que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont la meme spécificité.");
							}
							//Precision
							if(resMoyNaive.get(1) > resMoyKnn.get(1))
								textComp.append("\nL'algorithme Naive a une meilleure précision que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(1) < resMoyKnn.get(1))
								textComp.append("\nL'algorithme KNN a une meilleure précision que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont la meme précision.");
							}
							//Rappel
							if(resMoyNaive.get(1) > resMoyKnn.get(1))
								textComp.append("\nL'algorithme Naive a prédit correctement plus d'enregistrement positifs que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(1) < resMoyKnn.get(1))
								textComp.append("\nL'algorithme KNN a prédit correctement plus d'enregistrement positifs que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont prédis correctement le meme nombre d'enregistrement positifs.");
							}
							//F-score
							if(resMoyNaive.get(1) > resMoyKnn.get(1))
								textComp.append("\nL'algorithme Naive a un meuilleur F-score que l'algorithme KNN.");
							else {
								if(resMoyNaive.get(1) < resMoyKnn.get(1))
								textComp.append("\nL'algorithme KNN a une meuilleur F-score que l'algorithme Naive.");
								else
								textComp.append("\nLes deux algorithmes ont le meme F-score.");
							}
							
							
							
							
							
						}else {
							JOptionPane.showMessageDialog(null, "Veuillez exécuter les deux algorithmes KNN et Naive Bayesien avant de comparer les résultats !");
						}
					}
				});
				btnNormaliser_1_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnNormaliser_1_1.setBounds(542, 450, 139, 29);
				resultat.add(btnNormaliser_1_1);
				
				JLabel lblComparaisonEntreKnn = new JLabel("Comparaison entre KNN et Naive Bayesien");
				lblComparaisonEntreKnn.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblComparaisonEntreKnn.setBounds(20, 450, 399, 29);
				resultat.add(lblComparaisonEntreKnn);
				
				temp_execution = new JPanel();
				temp_execution.setBackground(Color.LIGHT_GRAY);
				 
				temp_execution.setLayout(null);
				tabbedPane.addTab("Temp d'\u00E9x\u00E9cution ", new ImageIcon("Time.png"), temp_execution, null);
				tabbedPane.setBackgroundAt(5, Color.WHITE);
				tabbedPane.setForegroundAt(5, Color.BLACK);
				
				JButton btnLancer_1 = new JButton("Lancer");
				btnLancer_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnLancer_1.setIcon(new ImageIcon("cliquez-ici.png"));
				btnLancer_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  DefaultCategoryDataset dcd=new DefaultCategoryDataset();
						  	dcd.setValue(time[0], "Temps d\'execution","APRIORI");
						  	dcd.setValue(time[1], "Temps d\'execution","ECLAT");
						JFreeChart jchart=ChartFactory.createBarChart("Comparaison temps  d éxécution"
						, "Algorithme", "temps d éxécution (ms)",
						dcd,PlotOrientation.VERTICAL,true,true,false);
						
						CategoryPlot plot =jchart.getCategoryPlot();
						DecimalFormat labelFormat = new DecimalFormat("##0.0 ");
						labelFormat.setMultiplier(1);
						plot.getRenderer().setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator("{2}", labelFormat));
						plot.getRenderer().setSeriesItemLabelsVisible(0, true);
						plot.setRangeGridlinePaint(Color.blue);
						//ChartFrame chf=new ChartFrame("Comapraison temps d'execution",jchart,true);
						//chf.setVisible(true);
						//chf.setSize(900,700);
						 charPanel=new ChartPanel(jchart);
						 charPanel.setPreferredSize(new java.awt.Dimension(671, 448));
						 //10, 41, 671, 448
						panel_time.removeAll();
						panel_time.add(charPanel);
						panel_time.updateUI();
					}
				});
				btnLancer_1.setBounds(570, 10, 111, 27);
				temp_execution.add(btnLancer_1);
				
				JLabel lblTempsDxcution = new JLabel("Temps d'\u00E9x\u00E9cution");
				lblTempsDxcution.setFont(new Font("Century Gothic", Font.BOLD, 16));
				lblTempsDxcution.setBounds(10, 11, 329, 29);
				temp_execution.add(lblTempsDxcution);
				
				panel_time = new JPanel();
				panel_time.setBackground(Color.WHITE);
				panel_time.setBounds(10, 72, 671, 448);
				temp_execution.add(panel_time);
				
				JPanel description = new JPanel();
				description.setBounds(0, 0, 1321, 702);
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
						panel_6.setBounds(0, 0, 1321, 702);
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
		panel_fichier.setBounds(0, 0, 1321, 702);

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
					//model.removeRow(ligne);
					
					A.remove(ligne);
					P.remove(ligne);
					C.remove(ligne);
					LoK.remove(ligne);
					WoK.remove(ligne);
					AC.remove(ligne);
					LoKG.remove(ligne);
					Class.remove(ligne);
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
		btnSauvegarder.setBounds(486, 435, 153, 39);
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
		btnSelectionner.setBounds(647, 435, 138, 39);
		panel_fichier.add(btnSelectionner);

		// for (int I=0;I< model.getRowCount();I++)
		// model.removeRow(I);
		// LinkedList <Vols> list = L;
		model = (DefaultTableModel) table_1.getModel();
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(174,241,241));
		panel_5.setBounds(0, 0, 1321, 702);
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
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "", "Kama", "Rosa", "canadian" }));
		comboBox_5.setBounds(405, 444, 193, 29);
		panel_5.add(comboBox_5);

		p2 = new JPanel();
		p2.setBackground(new Color(174,241,241));
		p2.setBounds(0, 0, 1321, 702);
		layeredPane.add(p2);
		p2.setLayout(null);

		p3 = new JPanel();
		p3.setBounds(10, 11, 1301, 644);
		p2.add(p3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(174,241,241));
		panel_2.setBounds(0, 0, 1321, 702);
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
		panel_3.setBounds(0, 0, 1321, 702);
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
		panel_7.setBounds(0, 0, 1321, 702);
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
		panel_1.setBounds(0, 0, 1321, 702);
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
		menuBar.setBounds(0, 0, 385, 36);
		panel.add(menuBar);

		mnFile = new JMenu("Data Set");
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
		
		mntmNewMenuItem = new JMenuItem("Partie 2");
		mntmNewMenuItem.setIcon(new ImageIcon("second.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() != 0) {
					layeredPane.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_normal);
					layeredPane.repaint();
					layeredPane.revalidate();
				} else {

					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un fichier");
				}
			}
		});
		menuBar.add(mntmNewMenuItem);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("fenetre.png"));
		lblNewLabel.setBounds(0, 0, 1341, 753);
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
	/*+*************************************************************************************************************
     **** Classification supervisée *********************************************************************************
     ****************************************************************************************************************/
	
	public double accuracy (ArrayList<ArrayList<Integer>> matconf) {
		return (double)(matconf.get(0).get(0) + matconf.get(1).get(1))/(double)(matconf.get(0).get(0)+matconf.get(0).get(1)+matconf.get(1).get(0)+matconf.get(1).get(1));
	}
	public double sensitivity (ArrayList<ArrayList<Integer>> matconf) {
		return (double)matconf.get(0).get(0) / (double)(matconf.get(0).get(0) + matconf.get(0).get(1));
	}
	public double specificity (ArrayList<ArrayList<Integer>> matconf) {
		return (double)matconf.get(1).get(1) / (double)(matconf.get(0).get(1) + matconf.get(1).get(1));
	}
	public double precision (ArrayList<ArrayList<Integer>> matconf) {
		return (double)matconf.get(0).get(0) / (double)(matconf.get(0).get(0) + matconf.get(1).get(0));
	}
	public double rappel (ArrayList<ArrayList<Integer>> matconf) {
		return (double)matconf.get(0).get(0) / (double)(matconf.get(0).get(0) + matconf.get(0).get(1));
	}
	public double f_score (ArrayList<ArrayList<Integer>> matconf) {
		return 2*precision(matconf)*rappel(matconf)/(precision(matconf) + rappel(matconf));
	}
	
	public void afficheResNaive () {
		textResNaive.append("\n Résulatas Naive Bayesien ============================="); 
		textResNaive.append("\n Accuracy Moyenne    : "+resMoyNaive.get(0)+"\t");
		textResNaive.append("\n Sensitivity Moyenne : "+resMoyNaive.get(1)+"\t");
		textResNaive.append("\n Specificity Moyenne : "+resMoyNaive.get(2)+"\t");
		textResNaive.append("\n Precision Moyenne   : "+resMoyNaive.get(3)+"\t");
		textResNaive.append("\n Rappel Moyenne      : "+resMoyNaive.get(4)+"\t"); 
		textResNaive.append("\n F-Score Moyenne     : "+resMoyNaive.get(5)+"\t");
	}
	public void afficheResKNN () {
		textResKNN.append("\n Résultats KNN ============================="); 
		textResKNN.append("\n Accuracy Moyenne : "+resMoyKnn.get(0));
		textResKNN.append("\n Sensitivity Moyenne : "+resMoyKnn.get(1));
		textResKNN.append("\n Specificity Moyenne : "+resMoyKnn.get(2));
		textResKNN.append("\n Precision Moyenne : "+resMoyKnn.get(3));
		textResKNN.append("\n Rappel Moyenne : "+resMoyKnn.get(4));
		textResKNN.append("\n F-Score Moyenne : "+resMoyKnn.get(5));
	}
	
	
	/*+*************************************************************************************************************
     **** Part 2 ****************************************************************************************************
     ****************************************************************************************************************/


    /**
     * NewValue = (CurrentValue - MinValue) / (MaxValue - MinValue)) * (NewMax - NewMin) + NewMin
     * @param InputList must be a (double) list
     * @return a new normalized list
     */
    @SuppressWarnings("unused")
    public static ArrayList<Double>
    NormalizeMinMax(ArrayList<Double> InputList, double NewMin, double NewMax) {
        if(InputList.isEmpty())
                return new ArrayList<>();
        ArrayList<Double> OutputList = new ArrayList<>();
        double MaxValue = Collections.max(InputList);
        double MinValue = Collections.min(InputList);
        DecimalFormat f = new DecimalFormat("#0.00"); // 3 numbers after comma
        double temp;
        for (double i : InputList) {
            temp = ((i - MinValue) / (MaxValue - MinValue)) * (NewMax - NewMin) + NewMin;
            OutputList.add(Double.parseDouble(f.format(temp).replace(",", ".")));
        }

        return OutputList;
    }

    /**
     * NewValue = (CurrentValue - mean) / sum(CurrentValue_i - mean)
     */
    @SuppressWarnings("unused")
    public static ArrayList<Double>
    Normalize_Z_Score(ArrayList<Double> InputList) {
        if(InputList.isEmpty())
            return new ArrayList<>();
        ArrayList<Double> OutputList = new ArrayList<>();
        double moy = moy(InputList), sum = 0;
        int n = InputList.size();
        DecimalFormat f = new DecimalFormat("#0.00"); // 2 numbers after comma
        for (double i : InputList) {
            sum += Math.abs(i - moy);
        }
        sum = sum / n;
        for (double i : InputList) {
            OutputList.add(Double.parseDouble((f.format((i - moy) / sum)).replace(",", ".")));
        }
        return OutputList;
    }

    /**
     * @param input      Given list
     * @param num_list   list number (must be correct)
     * @param Q          number of intervals
     * @return item list
     */
    @SuppressWarnings("unused")
    public static ArrayList<String>
    DiscreteEffective(ArrayList<Double> input, int num_list, int Q) {
        if(input.isEmpty())
            return new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();                   /* Item List output */
        ArrayList<Double> copyList = new ArrayList<>(input);            /* Copy of input list */
        Collections.sort(copyList);
        ArrayList<Double> quartiles = new ArrayList<>();                /* list of quartiles */

        int n = input.size();
        double min, max, temp;
        min = copyList.get(0);                                          /* Get minimum (Q0)*/
        quartiles.add(min);

        for (int i=1; i <= Q; i++){
            temp = (n/(double)Q)*i;                                     /* Get exact position of quartile*/
            if(temp%1>0.5)                                              /* If its bigger than xx.5, the its rounded to next int value*/
                temp = Math.ceil(temp);
            else
                temp = Math.floor(temp);                                /* Else its floored down */
            quartiles.add(copyList.get((int)temp-1));                   /* Now get that element which quartile points to*/
        }

        for (double i : input) {                                                /*For each element in input list*/
            for (int ind = 0; ind < quartiles.size() - 1; ind++) {
                if (i >= quartiles.get(ind) && i < quartiles.get(ind + 1)) {    /* If its between [Q(i), Q(i+1)[ */
                    output.add("I" + num_list + (ind + 1));                     /* Concat 'I' list number and its interval index */
                }
            }
            if(i == quartiles.get(quartiles.size()-1)){                         /* just to take max value into consideration */
                output.add("I" + num_list + (quartiles.size()-1));
            }
        }

        return output;
    }

    /**
     * @param input      Given list
     * @param num_list   list number (must be correct)
     * @param Q          number of intervals
     * @param correction small value to include max into intervals, (default 0.01)
     * @return item list
     */
    @SuppressWarnings("unused")
    public static ArrayList<String>
    DiscreteAmplitude(ArrayList<Double> input, int num_list, int Q, double correction) {
        if(input.isEmpty())
            return new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();                   /* Item list*/
        ArrayList<Double> intervals = new ArrayList<>();                /* list of intervals*/
        double min, max, amp, temp;
        min = Collections.min(input);                                   /* Get minimum */
        max = Collections.max(input);                                   /* Get maximum */
        amp = ((max - min) / Q) + correction;                           /* Calculate amplitude by its formula */

        temp = min;
        intervals.add(temp);
        while (temp < max) {                                            /* Create intervals */
            temp += amp;
            intervals.add(temp);
        }

        for (double i : input) {                                /*Determine where the list values located within intervals*/
            for (int ind = 0; ind < intervals.size() - 1; ind++) {
                if (i >= intervals.get(ind) && i < intervals.get(ind + 1)) {    /* If its between [Interval(i), Interval(i+1)[ */
                    output.add("I" + num_list + (ind + 1));                     /* Concat 'I' list number and its interval index */
                }
            }
        }
        return output;
    }

    /*+**************************************************************************************************************
     **** Apriori ****************************************************************************************************
     ****************************************************************************************************************/

    /**
     * @param MinSupport you know what's this, needs to be a percentage; 0~1
     * @return A set of sets L1 ~union~ L2 ~union~ L3
     */
    @SuppressWarnings("unused")
    public static HashSet<HashSet<String>>
    Apriori(double MinSupport){    /* MinSupport needs to be a percentage; 0~1*/
        HashSet<HashSet<String>>
                L = Create_1_ItemSet(MinSupport),           /* Lk in Apriori, we start with Creating L1 */
                L_PlusOne,                                  /* Lk+1  Creating next set */
                OutputSet= new HashSet<>(L);                /* Concat all sets L1 ~union~ L2 ~union~ L3 ... */
        int k = 2;                                          /* Index of L_PlusOne */

        do{
            L_PlusOne = CreateNextL(L, k, MinSupport);      /* Get Lk+1 */
            L = L_PlusOne;                                  /* Update L */
            OutputSet.addAll(L);                            /* append to output */
            k++;                                            /* get ready for next List L_PlusOne */
        } while (!L.isEmpty());                             /* Stop when List's empty */
        return OutputSet;
    }

    /**
     * The function everybody dreamed about
     * @param ItemSet a set of items, like [I11, I24, I36 ...]
     * @return It's support
     */
    @SuppressWarnings("unused")
    public static int
    CalcSupport(HashSet<String> ItemSet){
        if(ItemSet.isEmpty())
            return 0;
        int n = Adisc.size();                      /* Dataset's Length */
        int CurrentSupport = 0;                     /* Calculate current support */
        boolean SameLine;                           /* Check if all items from itemSet are found  on the same line of dataset (instance) */

        Map<String, ArrayList<String>> Tab = new HashMap<>();   /*Map of items with their concerning list,  Item: <List>*/

        for(String item: ItemSet){       /* init map by adding all corresponding lists, ex: if we found I16, we add list _A_ to Tab */
            Tab.put(item, new ArrayList<>(GetListFromItem(item.charAt(1))));
        }

        for(int i=0; i<n; i++){                             /* For all instances */
            SameLine = true;                                /* Suppose we found a line containing all items */
            for(String key: Tab.keySet()){                  /* For each item from the map */
                if(!Tab.get(key).get(i).equals(key)){       /* if an item is not found in its list in this current instance */
                    SameLine = false;                       /* then dont bother checking the other one */
                    break;
                }
            }
            if(SameLine) {                                  /* if we found all item in current instance */
                CurrentSupport++;
            }
        }
        return CurrentSupport;
    }

    /*---------------------------------------------- [Helper Functions] ----------------------------------------------*/
    /*-------------------------------------------- [No need to call them] --------------------------------------------*/
    /**
     * @param L Precedent L set
     * @param k Current List number
     * @param MinSupport Guess what?
     * @return Lk+1, it also prints (Ck+1, Lk+1)
     */
    private static
    HashSet<HashSet<String>>
    CreateNextL(HashSet<HashSet<String>> L, int k, double MinSupport){
        HashSet<HashSet<String>>
                Output = new HashSet<>();               /* This is Lk+1 */
        HashSet<String>
                combinedSet,                            /* Combination set: for creating all possible combination */
                NextC = new HashSet<>(),                /* Next Candidate list (K+1), used for printing only */
                NextL = new HashSet<>();                /* Next "Valid" list (K+1), also used for printing only */

        MinSupport = MinSupport * Adisc.size();        /* Recalculate support */
        int CurrentSupport;                             /* Current support of current combined set */

        for(HashSet<String > set1: L){                  /* For Set1 and Set2 in L, while Set1 != Set2 */
            for(HashSet<String > set2: L){              /*                  ||                        */
                if(set1.hashCode() != set2.hashCode()){   /*                  ||                        */
                    combinedSet = new HashSet<>();
                    combinedSet.addAll(set1);
                    combinedSet.addAll(set2);           /* Creating combined set, it doesn't add duplicates */
                    if (combinedSet.size() >= k){       /* We dont want to create small combinations, smaller than k anyway */
                        CurrentSupport = CalcSupport(combinedSet);                      /* Get support */
                        NextC.add(combinedSet.toString() + ": " + CurrentSupport);      /* Adding to candidate list*/
                        if(CurrentSupport >= MinSupport){                               /* If its greater, then it belongs to Lk+1 */
                            Output.add(combinedSet);                                    /* Adding to Lk+1*/
                            NextL.add(combinedSet.toString() + ": " + CurrentSupport);          /* Also adding to Lk+1 but this one's for printing only*/
                            AprioriResult.put(new ArrayList<>(combinedSet), CurrentSupport);    /* Hadi lik HOCINE */
                        }
                    }
                }
            }
        }

        /* Write this down in your JFrame will ya */
        if(!NextC.isEmpty()) {
        textApriori.append("C" + k + ":\n" + NextC + "");
        textApriori.append("\n");
        }
        if(!NextL.isEmpty()) {
        textApriori.append("L" + k + ":\n" + NextL + "");
        textApriori.append("\n");
        }
        return  Output;
    }

    /**
     * First step of Apriori algorithm
     * @param MinSupport Guess what's this
     * @return A set of sets (containing 1-ItemSets), ex [[I11], [I42], [I63], ...], it also prints (Ck+1, Lk+1)
     */
    private static HashSet<HashSet<String>>
    Create_1_ItemSet(double MinSupport) {
        MinSupport = (int) Math.floor(MinSupport * Adisc.size());              /* Recalculate minimum support */

        Set<String> AllItems = new HashSet<>();                                 /* A Set of all items*/
        AllItems.addAll(Adisc);                                                /* Add All */
        AllItems.addAll(Pdisc);
        AllItems.addAll(Cdisc);
        AllItems.addAll(LoKdisc);
        AllItems.addAll(WoKdisc);
        AllItems.addAll(ACdisc);
        AllItems.addAll(LoKGdisc);

        ArrayList<String> currentList;                                          /* Get attribute list of current item */
                                                                                /* Ex: if item = "I24" then current list is list _P_*/
        HashSet<HashSet<String>> output = new HashSet<>();                      /* This is actually L1 used in algorithm*/
        HashSet<String> L1 = new HashSet<>(), C1 = new HashSet<>();             /* C1 and L1 are used for printing*/
        int CurrentSupport;                                                     /* Current Support */

        for (String key : AllItems) {                                           /* For each item */
            currentList = GetListFromItem(key.charAt(1));                       /* get its list */
            CurrentSupport = Collections.frequency(currentList, key);           /* Calculate support, (Function frequency)*/
            C1.add(key+": "+CurrentSupport);                                    /* Add to C1*/
            if (CurrentSupport >= MinSupport) {                                 /* If it has min support */
                L1.add(key+": "+CurrentSupport);                                /* Add to L1 */
                output.add(new HashSet<>(Collections.singleton(key)));          /* Add to real L1, lol*/
                AprioriResult.put(new ArrayList<>(Collections.singleton(key)), CurrentSupport);    /* Hadi lik HOCINE */
            }
        }

        /* Write this down in your JFrame please */
        textApriori.setText("");
        if(!C1.isEmpty()) {
        textApriori.append("C1:\n" + C1 + "");
        textApriori.append("\n");
        }
        if(!L1.isEmpty()) {
        textApriori.append("L1:\n" + L1 + "");
        textApriori.append("\n");
        }
        return output;
    }

    /**
     * Help's you which list the item belongs to
     * Like: 'I34' ~ 'I(3)4' -> 3rd list, so its attribute 'C'
     * @param ch the index (comes after 'I' in item)
     * @return its list
     */
    private static ArrayList<String>
    GetListFromItem(char ch) {
        switch (ch) {                           /* Go and get the list */
            case '1':
                return Adisc;
            case '2':
                return Pdisc;
            case '3':
                return Cdisc;
            case '4':
                return LoKdisc;
            case '5':
                return WoKdisc;
            case '6':
                return ACdisc;
            case '7':
                return LoKGdisc;
            default:
                return  new ArrayList<>();          /* Return empty */
        }
    }
}
