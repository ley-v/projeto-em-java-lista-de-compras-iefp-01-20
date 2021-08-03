/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import DB.DBWorker;
import com.mysql.cj.util.StringUtils;
import excecoes.ErroNaConversaoDeStringParaDoubleException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.Alimentos;
import main.ListaDeCompras;

/**
 *
 * @author Ley
 */
public class GAdicionarAlimento extends javax.swing.JDialog {

    //Quando utilizamos 'final' definimos a variável como uma constante e esse valor nunca poderá ser alterado
    public static final int Botao_Guardar = 1;
    public static final int Botao_Cancelar = 0;
    private int acaoEscolhida = -1;

//    private ListaDeCompras a = null;
    private Alimentos a = null;
    private ListaDeCompras lc = new ListaDeCompras();
    DBWorker dbw = new DBWorker();
//    GPrincipal g;

    /**
     * Creates new form NewD
     */
    public GAdicionarAlimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //txtNomeAlimento.requestFocus();
        //Inicializar janela ao centro do ecrã
        //null = para dar a localização relativa a outra janela, ou seja a antecessora. Como definimos null, o programa entende
        //que deve centralizar a janela
        setLocationRelativeTo(null);

        //Serve para deixar um botão em evidência. Quando o utilizador der enter esse botão será acionado #######################
        //busca o contentor principal da janela / definir o botão por omissão
        
//        Color c = btnGuardar.getBackground();
//        getRootPane().setDefaultButton(btnGuardar);
//        btnGuardar.setBackground(c);
//        Color c = Color.BLACK;
//        c.getRGB(162,238,143);
//        btnGuardar.setBackground(Color.);

//Dá foco a esse objeto. PS** necessário para o ESC funcionar
        setFocusable(true);

        //Fechar janela com a tecla ESC
        //Este é um evento de 'escuta' de teclas. O pressionar de uma tecla vai chamar toda a ação abaixo
        //PS** é necessário implementar os 3 métodos mesmo que só se use um (os outros ficam vazios)
        addKeyListener(new KeyListener() {
            @Override
            //quando uma tecla é pressionada e largada
            public void keyTyped(KeyEvent e) {
                System.out.println("Tecla typed");
            }

            @Override
            //quando a tecla é pressionada
            // o 'e' captura o evento que aconteceu
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 27/*KeyEvent.VK_ESCAPE*/) {
                    //dispose fecha a janela atual sem fechar o programa, como o comando 'system exit' faz
                    dispose();
                    //consume: se houver a seguir uma requisição de teclas do teclado numa outra aplicação o buffer do teclado
                    //(uma memória temporária que grava as teclas pressionadas) vai repassar a informação do ESC que foi 
                    //pressionado, e como a intenção é usar o ESC apenas para fehcar a janela e nada além disso, usamos
                    //o 'consume()' para apagar esse registo do buffer
                    System.out.println("TEstes ESC");
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        acaoGuardar();
                    } catch (ErroNaConversaoDeStringParaDoubleException ex) {
                        JOptionPane.showMessageDialog(null, "Atenção! O campo 'Preço' foi preenchido incorretamente",
                    "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            }

            @Override
            //quando a tecla é solta
            public void keyReleased(KeyEvent e) {
                System.out.println("Teclada libertada");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //****************************************************************************************************************
//            JOptionPane.showMessageDialog(rootPane, "bb");
                acaoEscolhida = Botao_Cancelar;
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
//            acaoEscolhida = Botao_Cancelar;
//JOptionPane.showMessageDialog(rootPane, "aa");
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTituloDialogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblNomeAlimento = new javax.swing.JLabel();
        txtNomeAlimento = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lblNomeMercado = new javax.swing.JLabel();
        txtNomeMercado = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lblPrecoKgL = new javax.swing.JLabel();
        txtPrecoKgL = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTituloDialogo.setText("Janela de adição de Alimentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloDialogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloDialogo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(37, 225, 225));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Alimento"));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblNomeAlimento.setText("Nome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeAlimento)
                .addGap(18, 18, 18)
                .addComponent(txtNomeAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAlimento)
                    .addComponent(txtNomeAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblNomeMercado.setText("Mercado");

        txtNomeMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMercadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeMercado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeMercado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeMercado)
                    .addComponent(txtNomeMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPrecoKgL.setText("Preço por Kg/L");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrecoKgL)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtPrecoKgL, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoKgL)
                    .addComponent(txtPrecoKgL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(242, 242, 84));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardar.setBackground(new java.awt.Color(162, 238, 143));
        btnGuardar.setText("ADICIONAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            acaoGuardar();
        } catch (ErroNaConversaoDeStringParaDoubleException e) {
            JOptionPane.showMessageDialog(null, "Atenção! O campo 'Preço' foi preenchido incorretamente",
                    "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        acaoCancelar();


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomeMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMercadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMercadoActionPerformed

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
            java.util.logging.Logger.getLogger(GAdicionarAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GAdicionarAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GAdicionarAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GAdicionarAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GAdicionarAlimento dialog = new GAdicionarAlimento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblNomeAlimento;
    private javax.swing.JLabel lblNomeMercado;
    private javax.swing.JLabel lblPrecoKgL;
    private javax.swing.JLabel lblTituloDialogo;
    private javax.swing.JTextField txtNomeAlimento;
    private javax.swing.JTextField txtNomeMercado;
    private javax.swing.JTextField txtPrecoKgL;
    // End of variables declaration//GEN-END:variables

    private void acaoGuardar() throws ErroNaConversaoDeStringParaDoubleException {
        acaoEscolhida = Botao_Guardar;
        if (!StringUtils.isNullOrEmpty(txtNomeAlimento.getText())
                && !StringUtils.isNullOrEmpty(txtNomeMercado.getText())
                && !StringUtils.isNullOrEmpty(txtPrecoKgL.getText())) {
            if (a == null) {
                a = new Alimentos(txtNomeAlimento.getText(), txtNomeMercado.getText(), lc.converterStringParaDouble(txtPrecoKgL.getText()));
//            la.setNome(txtNomeAlimento.getText());
//            la.setNomeMercado(txtNomeMercado.getText());
//            la.setPrecoKgL(Double.parseDouble(txtPrecoKgL.getText()));
//            System.out.println(txtNomeAlimento.getText() + ", " + txtNomeMercado.getText() + ", " + a.converterStringParaDouble(txtPrecoKgL.getText()));

//        }
                dispose();

                txtNomeAlimento.setText("");
                txtNomeMercado.setText("");
                txtPrecoKgL.setText("");

                txtNomeAlimento.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Atenção! Nenhum campo pode estar vazio", "Preenchimento incorreto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void acaoCancelar() {
        acaoEscolhida = Botao_Cancelar;
        dispose();
    }

    public Alimentos getAlimentos() {
//    public ListaDeCompras getAlimentos(){
        return a;
    }

    public int getAcaoEscolhida() {
        return acaoEscolhida;
    }
}
