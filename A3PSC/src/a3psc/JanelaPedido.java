
package a3psc;

import javax.swing.JOptionPane;

public class JanelaPedido extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPedido
     */
    public JanelaPedido() {
        initComponents();
    }

    private boolean Pgto = false;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jbMenuCamis = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setText(Pedido.listaPedido());
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea2.setText(ProdutoDAO.listaProdutos());
        jLabel6 = new javax.swing.JLabel();
        txtNome2 = new javax.swing.JTextField();
        jlMensagens = new javax.swing.JLabel();
        jlMensagens.setVisible(false);
        jlPagamento = new javax.swing.JLabel();
        jrCredito = new javax.swing.JRadioButton();
        jrDebito = new javax.swing.JRadioButton();
        jrDinheiro = new javax.swing.JRadioButton();
        jrPix = new javax.swing.JRadioButton();
        jlErroPgto = new javax.swing.JLabel();
        jlErroPgto.setVisible(false);
        jbAlterar = new javax.swing.JToggleButton();
        jbFiltrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Marola", 2, 36)); // NOI18N
        jLabel1.setText("Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, -1));

        jButton4.setText("Concluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, 90, 30));

        jbMenuCamis.setText("Cancelar e Voltar");
        jbMenuCamis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuCamisActionPerformed(evt);
            }
        });
        getContentPane().add(jbMenuCamis, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 170, 30));

        jLabel2.setText("Adicionar ou remover produtos do pedido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("ID do produto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, -1));

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel4.setText("Filtrar pesquisa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 90, 30));

        txtNome1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtNome1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(txtNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 260, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 420, 190));

        jLabel5.setText("Produtos no Pedido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, 20));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 340, 370));

        jLabel6.setText("Preço Total: R$");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 140, 20));

        txtNome2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtNome2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtNome2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNome2MouseClicked(evt);
            }
        });
        txtNome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, -1));

        jlMensagens.setForeground(new java.awt.Color(0, 0, 204));
        jlMensagens.setText("[msgs aqui]");
        getContentPane().add(jlMensagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, -1));

        jlPagamento.setText("Forma de Pagamento:");
        getContentPane().add(jlPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jrCredito.setText("Cartão de Crédito");
        jrCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrCreditoActionPerformed(evt);
            }
        });
        getContentPane().add(jrCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jrDebito.setText("Cartão de Débito");
        jrDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDebitoActionPerformed(evt);
            }
        });
        getContentPane().add(jrDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        jrDinheiro.setText("Dinheiro");
        jrDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDinheiroActionPerformed(evt);
            }
        });
        getContentPane().add(jrDinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        jrPix.setText("PIX");
        jrPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrPixActionPerformed(evt);
            }
        });
        getContentPane().add(jrPix, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        jlErroPgto.setForeground(new java.awt.Color(255, 102, 102));
        jlErroPgto.setText("Selecione uma forma de pagamento");
        getContentPane().add(jlErroPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 230, -1));

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jbAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jbFiltrar.setText("🔎");
        jbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlPrecoTotal(){
        String preco = "Preço Total:       R$" + Pedido.calcPreco();
        Pedido.setPrecoTotal();
        jLabel6.setText(preco);
    }
    
    private void jbMenuCamisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuCamisActionPerformed
        Pedido.cancelarPedido();
        this.dispose();

        JanelaMenu telaMenu = new JanelaMenu();
        telaMenu.setVisible(true);
        telaMenu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbMenuCamisActionPerformed

    private void txtNome1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtNome1AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNome1AncestorAdded

    private void txtNome2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtNome2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2AncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ADD PRODUTO
        try{
            int idProd = Integer.parseInt(txtNome2.getText());
            if(ProdutoDAO.checarProduto(idProd)){
                Pedido.addProd(idProd);
                jlMensagens.setForeground(new java.awt.Color(0, 0, 204));
                jlMensagens.setText("Produto adicionado.");
                jlMensagens.setVisible(true);
                txtNome2.setText("");
                jlPrecoTotal();
            }
            else{
                jlMensagens.setForeground(new java.awt.Color(255, 0, 0));
                jlMensagens.setText("ID inválido.");
                jlMensagens.setVisible(true);
            }
            
        } catch(NumberFormatException nfe){
            jlMensagens.setForeground(new java.awt.Color(255, 0, 0));
            jlMensagens.setText("o ID deve ser um número inteiro.");
            jlMensagens.setVisible(true);
        }
        jTextArea1.setText(Pedido.listaPedido());
        String pesquisa = txtNome1.getText();
        jTextArea2.setText(ProdutoDAO.filtrarProduto(pesquisa));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // REMOVER PRODUTO
        try{
            int idProd = Integer.parseInt(txtNome2.getText());
            if(ProdutoDAO.checarProduto(idProd)){
                Pedido.removeProd(idProd);
                jlMensagens.setForeground(new java.awt.Color(0, 0, 204));
                jlMensagens.setText("Produto removido.");
                jlMensagens.setVisible(true);
                txtNome2.setText("");
                jlPrecoTotal();
            }
            else{
                jlMensagens.setForeground(new java.awt.Color(255, 0, 0));
                jlMensagens.setText("ID inválido.");
                jlMensagens.setVisible(true);
            }
            
        } catch(NumberFormatException nfe){
            jlMensagens.setForeground(new java.awt.Color(255, 0, 0));
            jlMensagens.setText("o ID deve ser um número inteiro.");
            jlMensagens.setVisible(true);
        }
        jTextArea1.setText(Pedido.listaPedido());
        String pesquisa = txtNome1.getText();
        jTextArea2.setText(ProdutoDAO.filtrarProduto(pesquisa));
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNome2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNome2MouseClicked
        jlMensagens.setVisible(false);
    }//GEN-LAST:event_txtNome2MouseClicked

    private void txtNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // FINALIZAR/CONCLUIR PEDIDO
        if(Pgto == false){
            jlErroPgto.setVisible(true);
        }
        else{
            Pedido.concluirPedido();
            JOptionPane.showMessageDialog(null,"Pedido Concluído.");
            this.dispose();
            JanelaMenu telaMenu = new JanelaMenu();
            telaMenu.setVisible(true);
            telaMenu.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jrCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrCreditoActionPerformed
       
        Pgto = true;
        jrDebito.setEnabled(false);
        jrDinheiro.setEnabled(false);
        jrPix.setEnabled(false);
        jlErroPgto.setVisible(false);
    }//GEN-LAST:event_jrCreditoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        Pgto = false;
        jrDebito.setEnabled(true);
        jrDinheiro.setEnabled(true);
        jrPix.setEnabled(true);
        jrCredito.setEnabled(true);
        
        jrDebito.setSelected(false);
        jrCredito.setSelected(false);
        jrDinheiro.setSelected(false);
        jrPix.setSelected(false);
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jrDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrDebitoActionPerformed
        Pgto = true;
        jrCredito.setEnabled(false);
        jrDinheiro.setEnabled(false);
        jrPix.setEnabled(false);
        jlErroPgto.setVisible(false);
    }//GEN-LAST:event_jrDebitoActionPerformed

    private void jrDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrDinheiroActionPerformed
        Pgto = true;
        jrDebito.setEnabled(false);
        jrCredito.setEnabled(false);
        jrPix.setEnabled(false);
        jlErroPgto.setVisible(false);
    }//GEN-LAST:event_jrDinheiroActionPerformed

    private void jrPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrPixActionPerformed
        Pgto = true;
        jrDebito.setEnabled(false);
        jrDinheiro.setEnabled(false);
        jrCredito.setEnabled(false);
        jlErroPgto.setVisible(false);
    }//GEN-LAST:event_jrPixActionPerformed

    private void jbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarActionPerformed
        String pesquisa = txtNome1.getText();
        jTextArea2.setText(ProdutoDAO.filtrarProduto(pesquisa));
        
    }//GEN-LAST:event_jbFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jbAlterar;
    private javax.swing.JToggleButton jbFiltrar;
    private javax.swing.JButton jbMenuCamis;
    private javax.swing.JLabel jlErroPgto;
    private javax.swing.JLabel jlMensagens;
    private javax.swing.JLabel jlPagamento;
    private javax.swing.JRadioButton jrCredito;
    private javax.swing.JRadioButton jrDebito;
    private javax.swing.JRadioButton jrDinheiro;
    private javax.swing.JRadioButton jrPix;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNome2;
    // End of variables declaration//GEN-END:variables
}
