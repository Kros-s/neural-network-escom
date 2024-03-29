/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronM.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import perceptronM.Model.Const;
import perceptronM.Model.Test;

/**
 *
 * @author PRETXEL-H
 */
public class Testing extends JFrame {

   
   private static final Dimension PREF_SIZE = new Dimension(Const.W, Const.H);
   protected static final Color SELECTION_COLOR = Color.black;
   private JPanel selectedPanel = null;
   private Color originalColor = null;
   private String CLASSNAME = Testing.class.getName();
   short NumPatron = Const.patrones_Test;
   DataOutputStream dos = null;
    /**
     * Creates new form NewJFrame
     */
    public Testing() throws FileNotFoundException {
        initComponents();
        Grid_Input();
        
    }

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
            
            if (p.x != Const.W+1 && p.y != Const.W+1 && p.x != Const.W*2 && 
                    p.y!= Const.W*2 && p.x != (Const.W*3)-1 && p.y != (Const.W*3)-1
                    && p.x != (Const.W*4)-2 && p.y != (Const.W*4)-2
                    && p.x != (Const.W*5)-3 && p.y != (Const.W*5)-3)
            {
            selectedPanel = panel;
            System.out.println(selectedPanel.getBackground());
           
            
            if (Color.black == selectedPanel.getBackground() || Test.patron[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] == 1){
                selectedPanel.setBackground(originalColor);
                Test.patron[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] = 0;
            }
            else{
                selectedPanel.setBackground(SELECTION_COLOR);
                Test.patron[((p.y)/Const.W)*Const.ROW_COUNT + (p.x)/Const.W][0] = 1;
            }
            //selectedPanel.add(new JLabel(selectedPanel.getName()));
            selectedPanel.revalidate();
            selectedPanel.repaint();
            
            for(int r=0;r<Const.ROW_COUNT*Const.ROW_COUNT;r++){
                System.out.println("i ="+r+" val="+Test.patron[r][0]);
            }

            }
            //[((p.y)/W)*ROW_COUNT + (p.x)/W] = 1;
   
         }
      };
     
     public void Grid_Input (){
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Create Grid_Input\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         //Const.Log(Const.LogTexto.toString());
         panelMaestroIn.setLayout(new GridLayout(Const.ROW_COUNT, Const.ROW_COUNT, 1, 1));
         panelMaestroIn.setBackground(Color.black);
         
      for (int i = 0; i < Const.ROW_COUNT * Const.ROW_COUNT; i++) {
         JPanel panel = new JPanel();
         String name = String.format("[%d, %d]",i / Const.ROW_COUNT, i % Const.ROW_COUNT);
         
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelMaestroIn = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtVocal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setMaximizedBounds(new java.awt.Rectangle(0, 0, 800, 500));
        setPreferredSize(new java.awt.Dimension(600, 400));

        panelMaestroIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelMaestroInLayout = new javax.swing.GroupLayout(panelMaestroIn);
        panelMaestroIn.setLayout(panelMaestroInLayout);
        panelMaestroInLayout.setHorizontalGroup(
            panelMaestroInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        panelMaestroInLayout.setVerticalGroup(
            panelMaestroInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        jLabel1.setText("Letra");

        txtVocal.setText("...");

        jButton1.setText("Agregar Patron Memoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar a Archivo");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVocal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panelMaestroIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMaestroIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
            if (NumPatron>0){
                
                String vo = txtVocal.getText();
                Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Button\n");
            
                Const.LogTexto.append("No. Patron: ").append(Test.index+1).append(" --- ");
                for (int i=0;i<Const.ROW_COUNT*Const.ROW_COUNT;i++)
                {
                    Const.LogTexto.append(Test.patron[i][0]).append(",");
                    Test.pesos[i][Test.index] = Test.patron[i][0];
                    Test.targets[Test.index] = vo.charAt(0);
                }

                Const.LogTexto.append("\n");
                Const.LogTexto.append("Vocal: ").append(vo).append("\n");
                GUI.txtLogger.append(Const.LogTexto.toString());
                Const.LogTexto.setLength(0);
                NumPatron--;
                Test.index++;
            }else{
                Const.LogTexto.append("Se agoto el máximo de pesos para agregar\n");
                GUI.txtLogger.append(Const.LogTexto.toString());
                Const.LogTexto.setLength(0);
            
            }
            
            
                
        
           
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Test.fijarPatrones_Properties();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Testing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Testing().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelMaestroIn;
    private javax.swing.JTextField txtVocal;
    // End of variables declaration//GEN-END:variables
}
