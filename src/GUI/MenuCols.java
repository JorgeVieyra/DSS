/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Diagrama_de_Classes.MediaCenterFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jorgevieira
 */
public class MenuCols extends javax.swing.JFrame {

    DefaultListModel dmPrivate = new DefaultListModel();
    DefaultListModel dmPublic = new DefaultListModel();
    Boolean isPrivate;
    private MediaCenterFacade mcF;
    List<Integer> idsPub;
    String[] stringsPub;
    List<Integer> idsPriv;
    String[] stringsPriv;

    /**
     * Creates new form MenuCols
     */
    public MenuCols() {
        try {
            this.mcF = MediaCenterFacade.getInstance();
            mcF.updateTemp();
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        isPrivate = true;
        //Popular listas
        idsPub = mcF.getPublicCol().stream().map(e -> e.getID()).collect(Collectors.toList());
        stringsPub = mcF.getPublicCol().stream().map(e -> e.getTitulo()).toArray(String[]::new);
        for (String teste : stringsPub) dmPublic.addElement(teste);

        idsPriv = mcF.getCollectionUser().stream().map(e -> e.getID()).collect(Collectors.toList());
        stringsPriv = mcF.getCollectionUser().stream().map(e -> e.getTitulo()).toArray(String[]::new);
        for (String teste : stringsPriv) dmPrivate.addElement(teste);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("As suas Cole��es:");
        jList2.setModel(dmPrivate);
        jList2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if(isPrivate) {
                        if(mcF.contaIsAdmin() || mcF.getTemp().getUsername().equals(mcF.getColecao(idsPriv.get(index)).getCriador())){
                            new MenuColecao(idsPriv.get(index)).setVisible(true);
                            close();}
                        else  new MenuColConv(idsPriv.get(index)).setVisible(true);
                    }
                    else {
                        if(mcF.contaIsAdmin() || mcF.getTemp().getUsername().equals(mcF.getColecao(idsPub.get(index)).getCriador())){
                            new MenuColecao(idsPub.get(index)).setVisible(true);
                            close();}
                        else  new MenuColConv(idsPub.get(index)).setVisible(true);
                    }

                } else if (evt.getClickCount() == 3) {

                    // Triple-click detected
                    int index = list.locationToIndex(evt.getPoint());
                }
            }
        });


        jScrollPane2.setViewportView(jList2);

        jButton1.setText("Criar Cole��o");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Apagar Cole��o");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("P�blicas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Privadas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton5)
                                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(21, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(19, 19, 19)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)
                                                .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4)
                                        .addComponent(jButton3))
                                .addGap(0, 12, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(61, 61, 61)
                                .addComponent(jButton2)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        isPrivate = false;
        jList2.setModel(dmPublic);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        isPrivate = true;
        jList2.setModel(dmPrivate);

    }//GEN-LAST:event_jButton4ActionPerformed



    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuCriaCol().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        System.out.println(jList2.getSelectedIndex());
        //Yummi great spaguette
        if(isPrivate){
            System.out.println("True Apaguei a playlist: " + mcF.getColecao(mcF.getCollectionIDsUser().get(jList2.getSelectedIndex())));
            if(idsPub.indexOf(idsPriv.get(jList2.getSelectedIndex())) != -1){
                dmPublic.remove(idsPub.indexOf(idsPriv.get(jList2.getSelectedIndex())));
                idsPub.remove(new Integer(idsPriv.get(jList2.getSelectedIndex())));}

            mcF.apagarColecao(idsPriv.get(jList2.getSelectedIndex()));
            idsPriv.remove(new Integer(idsPriv.get(jList2.getSelectedIndex())));
            dmPrivate.remove(jList2.getSelectedIndex());
            jList2.setModel(dmPrivate);
        }
        else{
            System.out.println("False Apaguei a playlist: " + mcF.getPublicCol().get(jList2.getSelectedIndex()));
            if(idsPriv.indexOf(idsPub.get(jList2.getSelectedIndex())) != -1){
                dmPrivate.remove(idsPriv.indexOf(idsPub.get(jList2.getSelectedIndex())));
                idsPriv.remove(new Integer(idsPub.get(jList2.getSelectedIndex())));}

            mcF.apagarColecao(idsPub.get(jList2.getSelectedIndex()));
            idsPub.remove(new Integer(idsPub.get(jList2.getSelectedIndex())));
            dmPublic.remove(jList2.getSelectedIndex());
            jList2.setModel(dmPublic);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void close(){
        this.dispose();
    }


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
            java.util.logging.Logger.getLogger(MenuCols.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCols.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCols.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCols.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCols().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
}
// End of variables declaration