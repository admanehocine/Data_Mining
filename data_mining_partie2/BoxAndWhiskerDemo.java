package data_mining;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

/** @see https://stackoverflow.com/questions/6844759 */
public class BoxAndWhiskerDemo {

    private static final int COLS = 20;
    private static final int VISIBLE = 4;
     //private List<String> columns;
    private List<List<List<Double>>> data;
    private DefaultBoxAndWhiskerCategoryDataset dataset;
    private CategoryPlot plot;
    private ChartPanel chartPanel;
    private JPanel controlPanel;
    private int start = 0;

    public BoxAndWhiskerDemo() {
        createData();
        createDataset(start);
        createChartPanel();
        createControlPanel();
       
    }

    private void createData() {
        //columns = new ArrayList<String>(COLS);
        data = new ArrayList<List<List<Double>>>();
           
            List<List<Double>> list = new ArrayList<List<Double>>();
            
                 list.add(IHM.A);
                 data.add(list);
                  list.add(IHM.P);
                  data.add(list);
                  
                 list.add(IHM.C);
                 data.add(list);
                 
                 list.add(IHM.LoK);
                 data.add(list);
                 
                 list.add(IHM.WoK);
                 
                 data.add(list);
                 list.add(IHM.AC);
                 data.add(list);
 
                 list.add(IHM.LoKG);
                 data.add(list);
                 
           
        
    }
 
    private void createDataset(int start) {
        dataset = new DefaultBoxAndWhiskerCategoryDataset();
        for (int i = start; i < start + VISIBLE; i++) {
          //  List<List<Double>> list = data.get(i);
            int row = 0;
            
            //String category = columns.get(i);
                dataset.add(IHM.A, row++, "A");
                dataset.add(IHM.P, row++, "P");
                dataset.add(IHM.C, row++, "C");
                dataset.add(IHM.LoK, row++, "LoK");
                dataset.add(IHM.WoK, row++, "WoK");
                dataset.add(IHM.AC, row++, "AC");
                dataset.add(IHM.LoKG, row++, "LoKG");
            
        }
    }

    private void createChartPanel() {
        CategoryAxis xAxis = new CategoryAxis("Category");
        NumberAxis yAxis = new NumberAxis("Value");
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        JFreeChart chart = new JFreeChart("Box Plot", plot);
        chartPanel = new ChartPanel(chart);
    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1301, 644));
        controlPanel.add(new JButton(new AbstractAction("u22b2Prev") {

            @Override
            public void actionPerformed(ActionEvent e) {
                start -= VISIBLE;
                if (start < 0) {
                    start = 0;
                    return;
                }
                createDataset(start);
                plot.setDataset(dataset);
            }
        }));
        controlPanel.add(new JButton(new AbstractAction("Nextu22b3") {

            @Override
            public void actionPerformed(ActionEvent e) {
                start += VISIBLE;
                if (start > COLS - VISIBLE) {
                    start = COLS - VISIBLE;
                    return;
                }
                createDataset(start);
                plot.setDataset(dataset);
            }
        }));
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

 
}