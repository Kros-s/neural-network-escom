package perceptronM.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import perceptronM.Model.Const;
import perceptronM.Model.Logic;
import perceptronM.Model.Muestras;
import perceptronM.Model.Test;

/**
 * @author PRETXEL-H
 * @author imarban
 * Interfaz gráfica principal de la aplicación, que contiene dos grids, uno de entrada
 * y otro de salida. También cuenta un un Log, para verificar los calculos realizsados.
 */
public class GUI extends JFrame {
    
   public static List<Muestras> stack = new ArrayList(10);
   Muestras temp;
   private static final Dimension PREF_SIZE = new Dimension(Const.W, Const.H);
   protected static final Color SELECTION_COLOR = Color.black;
   private JPanel selectedPanel = null;
   private Color originalColor = null;
   private String CLASSNAME = GUI.class.getName();
   public static JTextArea txtLogger = new JTextArea();
   public Logic l = null;
   
   private MouseListener ml_In = new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            JPanel panel = (JPanel) panelMaestroIn.getComponentAt(e.getPoint());
            Point p = e.getPoint();
            System.out.println("xc="+(p.x)+" yc="+(p.y));
            System.out.println("x="+(p.x)/Const.W+" y="+(p.y)/Const.W);
            
            if (panel == null ) {
              return;
            }
            if (selectedPanel != null) {
               //selectedPanel.setBackground(originalColor);
               selectedPanel.removeAll();
               selectedPanel.revalidate();
               selectedPanel.repaint();
            }
            
            if (p.x != Const.W+1 && p.y != Const.H+2 && p.x != Const.W*2 && 
                    p.y!= Const.H*2+1&& p.x != (Const.W*3)-1 && p.y != (Const.H*3)
                    && p.x != (Const.W*4)-2 && p.y != (Const.H*4)-1
                    && p.x != (Const.W*5)-3 && p.y != (Const.H*5)-2
                    && p.y != (Const.H*6)-3 && p.y != (Const.H*7)-4
                    && p.x != 0 && p.x != 1 && p.x != 2 && p.x != 248 && p.x != 249 && p.x != 250  
                    && p.y != 0 && p.y != 1 && p.y != 2 
                    && p.y != 395 && p.y != 396 && p.y != 397 && p.y != 398 && p.y != 399 && p.y != 400) 
            {
            selectedPanel = panel;
            System.out.println(selectedPanel.getBackground());
           
            
            if (Color.black == selectedPanel.getBackground()|| Const.prueba[((p.y)/Const.W)*Const.COLUMN_COUNT + (p.x)/Const.W][0] == 1){
                selectedPanel.setBackground(originalColor);
                Const.prueba[((p.y)/Const.W)*Const.COLUMN_COUNT + (p.x)/Const.W][0] = 0;
            }
            else{
                selectedPanel.setBackground(SELECTION_COLOR);
                Const.prueba[((p.y)/Const.W)*Const.COLUMN_COUNT + (p.x)/Const.W][0] = 1;
            }
            //selectedPanel.add(new JLabel(selectedPanel.getName()));
            selectedPanel.revalidate();
            selectedPanel.repaint();
            
            for(int r=0;r<Const.COLUMN_COUNT*Const.ROW_COUNT;r++){
                System.out.println("i ="+r+" val="+Const.prueba[r][0]);
            }

            }
            //[((p.y)/W)*ROW_COUNT + (p.x)/W] = 1;
   
         }
      };
   
   
   private MouseListener ml_Out = new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            JPanel panel = (JPanel) panelMaestroOut.getComponentAt(e.getPoint());
            Point p = e.getPoint();
            System.out.println("xc="+(p.x)+" yc="+(p.y));
            System.out.println("x="+(p.x)/Const.W+" y="+(p.y)/Const.W);
            
            if (panel == null ) {
              return;
            }
            if (selectedPanel != null) {
               //selectedPanel.setBackground(originalColor);
               selectedPanel.removeAll();
               selectedPanel.revalidate();
               selectedPanel.repaint();
            }
            
            if (p.x != Const.W+1 && p.y != Const.W+1 && p.x != Const.W*2 && 
                    p.y!= Const.W*2 && p.x != (Const.W*3)-1 && p.y != (Const.W*3)-1
                    && p.x != (Const.W*4)-2 && p.y != (Const.W*4)-2
                    && p.x != (Const.W*5)-3 && p.y != (Const.W*5)-3)
            {
            selectedPanel = panel;
            System.out.println(selectedPanel.getBackground());
           
            
            if (Color.black == selectedPanel.getBackground() || Const.prueba[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] == 1){
                selectedPanel.setBackground(originalColor);
                Const.prueba[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] = 0;
            }
            else{
                selectedPanel.setBackground(SELECTION_COLOR);
                Const.prueba[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] = 1;
            }
            
            selectedPanel.revalidate();
            selectedPanel.repaint();
            
            for(int r=0;r<Const.ROW_COUNT*Const.ROW_COUNT;r++){
                System.out.println("i ="+r+" val="+Const.prueba[r][0]);
            }

            }
            
   
         }
      };
   
   
   
    /**
     * Creates new form NewJFrame
     */
    public GUI() {
        
        initComponents();
        txtLogger = txtLog;
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Init\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());

        txtLimiteEpocas.setText(String.valueOf(Const.epoch));
        
        Grid_Input(); 
        Grid_Output();
//        Const.definirEntradas();
//        Const.valoresFijos();
        Logic.aprendio=true;
        l = new Logic();
        //txtLog.setText(Const.LogTexto.toString());
//        Test.obtenerPatrones_Properties();
        //Test.imprime();
//        l.Evalua();
    }

     public void Grid_Input (){
         Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - Create Grid_Input\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         //Const.Log(Const.LogTexto.toString());
         panelMaestroIn.setLayout(new GridLayout(Const.ROW_COUNT, Const.COLUMN_COUNT, 1, 1));
         panelMaestroIn.setBackground(Color.black);
         
      for (int i = 0; i < Const.ROW_COUNT * Const.COLUMN_COUNT; i++) {
         JPanel panel = new JPanel();
         String name = String.format("[%d, %d]",i / Const.ROW_COUNT, i % Const.COLUMN_COUNT);
         
         panel.setName(name);
        
         if (i == 0) {
            originalColor = panel.getBackground();
         }
       
         panel.setPreferredSize(PREF_SIZE);
         panelMaestroIn.add(panel);
      }
      
      panelMaestroIn.validate();
      panelMaestroIn.addMouseListener(ml_In);
    }
    
    
     
     public void Grid_Output (){
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Create Grid_Output\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         //Const.Log(Const.LogTexto.toString());
         panelMaestroOut.setLayout(new GridLayout(Const.ROW_COUNT, Const.COLUMN_COUNT, 1, 1));
         panelMaestroOut.setBackground(Color.black);
         
      for (int i = 0; i < Const.ROW_COUNT * Const.COLUMN_COUNT; i++) {
         JPanel panel = new JPanel();
         String name = String.format("[%d, %d]",i / Const.ROW_COUNT, i % Const.COLUMN_COUNT);
         
         panel.setName(name);
        
         if (i == 0) {
            originalColor = panel.getBackground();
         }
       
         panel.setPreferredSize(PREF_SIZE);
         panelMaestroOut.add(panel);
      }
      
      panelMaestroOut.validate();
      //panelMaestroOut.addMouseListener(ml_Out);
    } 
     
     
     
     public void Draw_Grid(int letra){
         //Point poi = 
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Draw_Grid\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         //Const.Log(Const.LogTexto.toString());
         for(int j=0;j<Const.ROW_COUNT*Const.COLUMN_COUNT;j++){
             if (Const.entradas[j][letra] == 1){
                JPanel panel = (JPanel) panelMaestroOut.getComponent(j);
                panel.setBackground(Color.black);
             }
         }
         
         panelMaestroOut.repaint();
         
     }
     
     
     
     public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
        
        
    }
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrenar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelMaestroIn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMaestroOut = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnEvaluarGrid = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();
        btnEntrenar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtLimiteEpocas = new javax.swing.JTextField();
        btnEntrenar2 = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLogger = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        btnAcercade = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        btnEntrenar1.setText("Entrenar");
        btnEntrenar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrenar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RNA");
        setResizable(false);

        panelMaestroIn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelMaestroIn.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout panelMaestroInLayout = new javax.swing.GroupLayout(panelMaestroIn);
        panelMaestroIn.setLayout(panelMaestroInLayout);
        panelMaestroInLayout.setHorizontalGroup(
            panelMaestroInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        panelMaestroInLayout.setVerticalGroup(
            panelMaestroInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Redes Neuronales Artificiales");

        panelMaestroOut.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelMaestroOut.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout panelMaestroOutLayout = new javax.swing.GroupLayout(panelMaestroOut);
        panelMaestroOut.setLayout(panelMaestroOutLayout);
        panelMaestroOutLayout.setHorizontalGroup(
            panelMaestroOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        panelMaestroOutLayout.setVerticalGroup(
            panelMaestroOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEvaluarGrid.setText("Evaluar Grid");
        btnEvaluarGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarGridActionPerformed(evt);
            }
        });

        btnEvaluar.setText("Evaluar");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        btnEntrenar.setText("Entrenar Aleatorio");
        btnEntrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrenarActionPerformed(evt);
            }
        });

        jLabel2.setText("Limite de Epocas");

        txtLimiteEpocas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimiteEpocas.setText("jTextField1");

        btnEntrenar2.setText("Fijar Valores");
        btnEntrenar2.setName(""); // NOI18N
        btnEntrenar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrenar2ActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);
        txtStatus.setBackground(new java.awt.Color(153, 153, 153));
        txtStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Aprendio?");

        btnLogger.setText("Logger On");
        btnLogger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEvaluarGrid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLimiteEpocas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLogger)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(12, 12, 12))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEntrenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEntrenar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnEntrenar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntrenar2)
                .addGap(18, 18, 18)
                .addComponent(btnEvaluar)
                .addGap(18, 18, 18)
                .addComponent(btnEvaluarGrid)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLimiteEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogger)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setRows(5);
        txtLog.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logger", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));
        jScrollPane1.setViewportView(txtLog);

        btnAcercade.setText("Acerca de...");
        btnAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercadeActionPerformed(evt);
            }
        });

        jButton1.setLabel("Set Pruebas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Grid de Entrada");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Grid de Salida");

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(99, 99, 99)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(btnAcercade))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(237, 237, 237)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(panelMaestroIn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panelMaestroOut, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAcercade)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMaestroIn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelMaestroOut, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //System.out.println(panelMaestroIn.getComponentCount());
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Limpiar\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
        selectedPanel = null;
        originalColor = null;
        
        panelMaestroIn.removeMouseListener(ml_In);
        //panelMaestroOut.removeMouseListener(ml_Out);
        
        panelMaestroOut.removeAll();
        panelMaestroIn.removeAll();
        
        txtLog.setText("");
        
        Grid_Input();
        Grid_Output();
        Const.clean();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEntrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrenarActionPerformed

        if (stack.isEmpty()!=true){
            stack.clear();
        }
        
        for(int i=0;i<10;i++)   
        {
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Train\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        l = new Logic();
        //Const.Log(Const.LogTexto.toString());
        Logic.aprendio = false;
        int n = 0;
        try{
            n = Integer.valueOf(txtLimiteEpocas.getText());
        }catch(Exception e){
            JOptionPane.showConfirmDialog(jPanel1, "El valor de epocas no es un número" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
            return;
        }
        Const.epoch = n;
        //l = new Logic();
        l.init();
        l.train();
         /*
          * Voy a añadir la parte donde almacena los 10 entrenamientos en un array
          * Muestras temp = new Muestras(pesos,b);
          * stack.add(temp);
          * Prototipo para añadir muetras
          */
         temp = new Muestras(l);
         stack.add(temp);
        }
        //System.out.println("TAMAÑO"+stack.size());
        //Hasta aqui el codigo solo toma el ultimo train(), pero ya tenemos almacenados los otros 9 
       ///////////////////////////////////////////////////////////////////////////////////////////
        if(Logic.aprendio == false){
            txtStatus.setBackground(Color.red);
            txtStatus.setForeground(Color.white);
            txtStatus.setText("No");
        }else{
            txtStatus.setBackground(Color.green);
            txtStatus.setForeground(Color.white);
            txtStatus.setText("Si");
        }
        
        //Se agrega algortimo para mejorar implementacion de aprendizaje
        
         try {
                Test.Eval_Pesos();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }//GEN-LAST:event_btnEntrenarActionPerformed

    private void btnEvaluarGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarGridActionPerformed
        
        if(l == null){
            JOptionPane.showConfirmDialog(jPanel1, "Primero Entrene las Vocales" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
            return;
        }else if (Logic.aprendio == false){
            JOptionPane.showConfirmDialog(jPanel1, "No Aprendio, no se puede evaluar" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
            return;
        }
        int index_vocal = -1;
        //JOptionPane.showConfirmDialog(jPanel1, "Patrón no clasificado" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
        panelMaestroOut.removeAll();
        Grid_Output();
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Evaluar Grid\n");
        index_vocal = l.TestGrid(Const.prueba);
        if(index_vocal>=0){
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Letra Detectada: ").append(Const.abecedario[index_vocal]).append("\n");
        //Draw_Grid(2);
        System.out.println("Letra detectada: "+Const.abecedario[l.TestGrid(Const.prueba)]);
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Dibujar en Grid_Out\n");
        Draw_Grid(index_vocal);
        }//else {
            float ap[][] = l.TestGrid2(Const.prueba);
            //System.out.println("Salida Hardlim ");
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append("- Salida Hardlim: \n");
            for(int i=0;i<ap.length;i++){
                //System.out.println(ap[i][0]);
                Const.LogTexto.append(ap[i][0]).append("\n");
                
            //}
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
    }//GEN-LAST:event_btnEvaluarGridActionPerformed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        if(l==null ){
            JOptionPane.showConfirmDialog(jPanel1, "Primero Entrene las Vocales" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
            return;
        }else if (Logic.aprendio == false){
            JOptionPane.showConfirmDialog(jPanel1, "No Aprendio, no se puede evaluar" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
            return;
        }
        else{
            l.Test();
     
        }
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void btnAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercadeActionPerformed
        Acerca.start();
    }//GEN-LAST:event_btnAcercadeActionPerformed

    private void btnLoggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggerActionPerformed
       
        AbstractButton abstractButton = (AbstractButton) evt.getSource();
        boolean selected = abstractButton.getModel().isSelected();
        //System.out.println("Action - selected=" + selected + "\n");
        if (selected){
            btnLogger.setText("Logger Off");
            txtLog.setVisible(false);
        }else{
            btnLogger.setText("Logger On");
            txtLog.setVisible(true);
            
        }
    }//GEN-LAST:event_btnLoggerActionPerformed

    private void btnEntrenar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrenar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrenar1ActionPerformed

    private void btnEntrenar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrenar2ActionPerformed
              
            //l=new Logic();
             //l.fijarValores_Properties(); //Agregar valores de l
            Const.valoresFijos(); 
    }//GEN-LAST:event_btnEntrenar2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Testing tes = null;
        tes.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ayuda.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcercade;
    private javax.swing.JButton btnEntrenar;
    private javax.swing.JButton btnEntrenar1;
    private javax.swing.JButton btnEntrenar2;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnEvaluarGrid;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JToggleButton btnLogger;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMaestroIn;
    private javax.swing.JPanel panelMaestroOut;
    private javax.swing.JTextField txtLimiteEpocas;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
