/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipedreams;

/**
 *
 * @author Jasmine
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jIntroMenu = new javax.swing.JLayeredPane();
        Start = new javax.swing.JButton();
        Rules = new javax.swing.JButton();
        jRulesPane = new javax.swing.JLayeredPane();
        rulesLabel = new javax.swing.JLabel();
        revealLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jPipeDreams = new javax.swing.JLayeredPane();
        jCoverPane = new javax.swing.JLayeredPane();
        A1 = new javax.swing.JLabel();
        A2 = new javax.swing.JLabel();
        A3 = new javax.swing.JLabel();
        A4 = new javax.swing.JLabel();
        A5 = new javax.swing.JLabel();
        A6 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B3 = new javax.swing.JLabel();
        B4 = new javax.swing.JLabel();
        B5 = new javax.swing.JLabel();
        B6 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        C4 = new javax.swing.JLabel();
        C5 = new javax.swing.JLabel();
        C6 = new javax.swing.JLabel();
        D1 = new javax.swing.JLabel();
        D2 = new javax.swing.JLabel();
        D3 = new javax.swing.JLabel();
        D4 = new javax.swing.JLabel();
        D5 = new javax.swing.JLabel();
        D6 = new javax.swing.JLabel();
        E1 = new javax.swing.JLabel();
        E2 = new javax.swing.JLabel();
        E3 = new javax.swing.JLabel();
        E4 = new javax.swing.JLabel();
        E5 = new javax.swing.JLabel();
        E6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jIntroMenu.setPreferredSize(new java.awt.Dimension(1000, 800));

        Start.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        Start.setText("Start");
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartMouseClicked(evt);
            }
        });

        Rules.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        Rules.setText("Rules");
        Rules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RulesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jIntroMenuLayout = new javax.swing.GroupLayout(jIntroMenu);
        jIntroMenu.setLayout(jIntroMenuLayout);
        jIntroMenuLayout.setHorizontalGroup(
            jIntroMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jIntroMenuLayout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addGroup(jIntroMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Rules, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(Start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        jIntroMenuLayout.setVerticalGroup(
            jIntroMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jIntroMenuLayout.createSequentialGroup()
                .addContainerGap(375, Short.MAX_VALUE)
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Rules, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jIntroMenu.setLayer(Start, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jIntroMenu.setLayer(Rules, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRulesPane.setVisible(false);
        jRulesPane.setPreferredSize(new java.awt.Dimension(1000, 800));

        rulesLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        rulesLabel.setText("Rules");

        revealLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        revealLabel.setText("Reveal the tiles");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jasmine\\Documents\\PipeDreams\\Resized Tiles\\Cover_100x100.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jasmine\\Documents\\PipeDreams\\Resized Tiles\\Tile_4_100x100.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLabel3.setText("Press Enter to reveal pipes");

        Back.setText("Back");
        Back.setToolTipText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jRulesPaneLayout = new javax.swing.GroupLayout(jRulesPane);
        jRulesPane.setLayout(jRulesPaneLayout);
        jRulesPaneLayout.setHorizontalGroup(
            jRulesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRulesPaneLayout.createSequentialGroup()
                .addGroup(jRulesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jRulesPaneLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(rulesLabel))
                    .addGroup(jRulesPaneLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(jRulesPaneLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(revealLabel))
                    .addGroup(jRulesPaneLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3)))
                .addContainerGap(489, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRulesPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(34, 34, 34))
        );
        jRulesPaneLayout.setVerticalGroup(
            jRulesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRulesPaneLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(rulesLabel)
                .addGap(61, 61, 61)
                .addComponent(revealLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRulesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(38, 38, 38))
        );
        jRulesPane.setLayer(rulesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jRulesPane.setLayer(revealLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jRulesPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jRulesPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jRulesPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jRulesPane.setLayer(Back, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPipeDreams.setVisible(false);
        jPipeDreams.setPreferredSize(new java.awt.Dimension(1000, 800));

        jCoverPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        A2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        A3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        A3.setToolTipText("");
        jCoverPane.add(A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        A4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        A5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        A6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(A6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        B4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        B5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        B6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(B6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        C4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        C5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        C6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        D1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        D2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        D3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        D4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        D5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        D6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(D6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        E1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, -1));

        E2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        E3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        E4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        E5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        E6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pipedreams/Cover_100x100.png"))); // NOI18N
        jCoverPane.add(E6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        javax.swing.GroupLayout jPipeDreamsLayout = new javax.swing.GroupLayout(jPipeDreams);
        jPipeDreams.setLayout(jPipeDreamsLayout);
        jPipeDreamsLayout.setHorizontalGroup(
            jPipeDreamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(jPipeDreamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPipeDreamsLayout.createSequentialGroup()
                    .addContainerGap(187, Short.MAX_VALUE)
                    .addComponent(jCoverPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );
        jPipeDreamsLayout.setVerticalGroup(
            jPipeDreamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jPipeDreamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPipeDreamsLayout.createSequentialGroup()
                    .addContainerGap(147, Short.MAX_VALUE)
                    .addComponent(jCoverPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(153, Short.MAX_VALUE)))
        );
        jPipeDreams.setLayer(jCoverPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jIntroMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jRulesPane, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPipeDreams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jIntroMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jRulesPane, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BackgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPipeDreams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RulesMouseClicked
        // TODO add your handling code here:
        jRulesPane.setVisible(true);
        jIntroMenu.setVisible(false);
    }//GEN-LAST:event_RulesMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        jRulesPane.setVisible(false);
        jIntroMenu.setVisible(true);
    }//GEN-LAST:event_BackMouseClicked

    private void StartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMouseClicked
        // TODO add your handling code here:
        jPipeDreams.setVisible(true);
        jIntroMenu.setVisible(false);
    }//GEN-LAST:event_StartMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A1;
    private javax.swing.JLabel A2;
    private javax.swing.JLabel A3;
    private javax.swing.JLabel A4;
    private javax.swing.JLabel A5;
    private javax.swing.JLabel A6;
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel B4;
    private javax.swing.JLabel B5;
    private javax.swing.JLabel B6;
    private javax.swing.JButton Back;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel C1;
    private javax.swing.JLabel C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel C4;
    private javax.swing.JLabel C5;
    private javax.swing.JLabel C6;
    private javax.swing.JLabel D1;
    private javax.swing.JLabel D2;
    private javax.swing.JLabel D3;
    private javax.swing.JLabel D4;
    private javax.swing.JLabel D5;
    private javax.swing.JLabel D6;
    private javax.swing.JLabel E1;
    private javax.swing.JLabel E2;
    private javax.swing.JLabel E3;
    private javax.swing.JLabel E4;
    private javax.swing.JLabel E5;
    private javax.swing.JLabel E6;
    private javax.swing.JButton Rules;
    private javax.swing.JButton Start;
    private javax.swing.JLayeredPane jCoverPane;
    private javax.swing.JLayeredPane jIntroMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jPipeDreams;
    private javax.swing.JLayeredPane jRulesPane;
    private javax.swing.JLabel revealLabel;
    private javax.swing.JLabel rulesLabel;
    // End of variables declaration//GEN-END:variables
}
