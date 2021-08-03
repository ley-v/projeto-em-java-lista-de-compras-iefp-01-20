/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import DB.DBWorker;
import com.mysql.cj.util.StringUtils;
import graphic.GAdicionarAlimento;
import javax.swing.DefaultComboBoxModel;
import main.ListaNome;
import estruturasBase.ArrayListObservable;
import excecoes.ErroNaConversaoDeStringParaDoubleException;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Alimentos;
import main.ListaDeCompras;
import modelo.GestaoTabelaAlimentos;
import modelo.GestaoTabelaListaDeCompras;

/**
 *
 * @author Ley
 */
public class GPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form g1
     */
    private DBWorker dbw = new DBWorker();
    /////////////private DefaultComboBoxModel<Lista> modeloLista = new DefaultComboBoxModel<>();
    private ArrayListObservable<Alimentos> listaAlimento = new ArrayListObservable<>();
    private ArrayList<ListaNome> listaListaNome = new ArrayList<>();
    private ArrayListObservable<ListaDeCompras> listaListaDeCompras = new ArrayListObservable<>();

    private GestaoTabelaAlimentos ga = null;
    private GestaoTabelaListaDeCompras glc = null;

    public static int idListaNome = -1;
    public static String nomeListaNome = null;

    public GPrincipal() {
        initComponents();
        ///////////jComboBox1.setModel(modeloLista);
        //centralizar janela ao iniciar a aplicação
        
    
        
        setLocationRelativeTo(null);
        ga = new GestaoTabelaAlimentos(listaAlimento);
        tblAlimento.setModel(ga);

        atualizarTabelaAlimentos();

        cmbListaNome.addItem("Por favor, escolha uma lista");
        atualizarComboBox();

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
        jPanel5 = new javax.swing.JPanel();
        cmbListaNome = new javax.swing.JComboBox<>();
        btnApagarListaNome = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaDeCompras = new javax.swing.JTable();
        lblPrecoTotal = new javax.swing.JLabel();
        btnApagarAlimentoLC = new javax.swing.JButton();
        pnlListaAlimentos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimento = new javax.swing.JTable();
        btnAdicionarAlimento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnApagarAlimento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuConfig = new javax.swing.JMenu();
        mnuAdicionarAlimento = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 95, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(113, 216, 250));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione o nome da lista"));

        cmbListaNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item 222" }));
        cmbListaNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbListaNomeItemStateChanged(evt);
            }
        });
        cmbListaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaNomeActionPerformed(evt);
            }
        });
        cmbListaNome.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbListaNomePropertyChange(evt);
            }
        });

        btnApagarListaNome.setBackground(new java.awt.Color(245, 87, 108));
        btnApagarListaNome.setText("REMOVER");
        btnApagarListaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarListaNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbListaNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApagarListaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagarListaNome))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(108, 249, 108));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de compras"));

        jLabel2.setText("Valor Total:");

        tblListaDeCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimento", "Mercado", "Quantidade", "Preço"
            }
        ));
        jScrollPane2.setViewportView(tblListaDeCompras);

        lblPrecoTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrecoTotal.setForeground(new java.awt.Color(51, 153, 0));
        lblPrecoTotal.setText("0,0 €");

        btnApagarAlimentoLC.setBackground(new java.awt.Color(245, 87, 108));
        btnApagarAlimentoLC.setText("REMOVER");
        btnApagarAlimentoLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarAlimentoLCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnApagarAlimentoLC, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoTotal)
                    .addComponent(btnApagarAlimentoLC)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pnlListaAlimentos.setBackground(new java.awt.Color(242, 242, 84));
        pnlListaAlimentos.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Alimentos"));

        tblAlimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimento", "Mercado", "Preço Kg/L"
            }
        ));
        jScrollPane1.setViewportView(tblAlimento);

        btnAdicionarAlimento.setBackground(new java.awt.Color(162, 238, 143));
        btnAdicionarAlimento.setText("ADICIONAR");
        btnAdicionarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAlimentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        btnApagarAlimento.setBackground(new java.awt.Color(245, 87, 108));
        btnApagarAlimento.setText("REMOVER");
        btnApagarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarAlimentoActionPerformed(evt);
            }
        });

        jLabel1.setText("g/ml");

        javax.swing.GroupLayout pnlListaAlimentosLayout = new javax.swing.GroupLayout(pnlListaAlimentos);
        pnlListaAlimentos.setLayout(pnlListaAlimentosLayout);
        pnlListaAlimentosLayout.setHorizontalGroup(
            pnlListaAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                .addComponent(btnApagarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel1))
            .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnAdicionarAlimento))
        );
        pnlListaAlimentosLayout.setVerticalGroup(
            pnlListaAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlListaAlimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApagarAlimento)
                    .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlListaAlimentosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)))
                .addGap(6, 6, 6)
                .addComponent(btnAdicionarAlimento))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlListaAlimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlListaAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        mnuConfig.setText("Inserir");

        mnuAdicionarAlimento.setText("Adicionar Alimento");
        mnuAdicionarAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdicionarAlimentoActionPerformed(evt);
            }
        });
        mnuConfig.add(mnuAdicionarAlimento);

        jMenuItem1.setText("Criar Lista de Compras");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuConfig.add(jMenuItem1);

        jMenuBar1.add(mnuConfig);

        jMenu1.setText("Outros");

        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayListObservable<Alimentos> getListaAlimento() {
        return listaAlimento;
    }

    private void mnuAdicionarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdicionarAlimentoActionPerformed
        //objeto modal é aquele que bloqueia seu antecessor #####################################################################
        //Quando uma janela Dialog é aberta, o programa para na linha em que o comando de abertura da janela é executada, e volta
        //quando aquela janela é fechada. Porém, isso não acontece com uma janela normal, ou seja, aquela que não bloqueia a 
        //sua antecessora
        GAdicionarAlimento n = new GAdicionarAlimento(this, true/*false para permitir abrir mais janelas*/);
        n.setVisible(true);
        System.out.println(n.getAcaoEscolhida());

        while (n.getAcaoEscolhida() == GAdicionarAlimento.Botao_Guardar) {
            boolean guardou = dbw.guardarAlimento(n.getAlimentos());
            System.out.println("clicou no guardar");
            //recebe a lista de alimentos para gravar na base de dados
//            dbw.guardarObjeto(n.getAlimentos());

//            listaAlimento.add(n.getAlimentos());
            listaAlimento.removeAll(listaAlimento);
            atualizarTabelaAlimentos();
            n = new GAdicionarAlimento(this, true/*false para permitir abrir mais janelas*/);
            n.setVisible(true);
            
            for (int i = 0; i < 10; i++) {
                
            }

        }
        //**********************************************************************************************************
        //ga.fireTableDataChanged();
//                        while(ga.getRowCount() > 0){
//                            tblAlimento.remove(0);
//                        }                

//                atualizarTabelaAlimentos();

    }//GEN-LAST:event_mnuAdicionarAlimentoActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        //Encerra o programa
        System.exit(0);
    }//GEN-LAST:event_mnuSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GListaNome c = new GListaNome(this, true);
        c.setVisible(true);

        atualizarComboBox();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnApagarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarAlimentoActionPerformed
        if (tblAlimento.getSelectedRow() > -1) {
//            String s = listaAlimento.remove(evt)
//            JOptionPane.showMessageDialog(null, listaAlimento.);

//            //Busca o Id do objeto ###################################################
//            System.out.println(listaAlimento.get(tblAlimento.getSelectedRow()).getId());
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja apagar o alimento '"
                    + listaAlimento.get(tblAlimento.getSelectedRow()).getNomeAlimento()
                    + "' ?", "Selecione uma opção",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == 0) {
                dbw.apagarLinhasRelacionadasAoAlimento(listaAlimento.get(tblAlimento.getSelectedRow()).getId());
                dbw.apagarAlimento(listaAlimento.get(tblAlimento.getSelectedRow()).getId());

                JOptionPane.showMessageDialog(null, "O alimento '"
                        + listaAlimento.get(tblAlimento.getSelectedRow()).getNomeAlimento()
                        + "' foi apagado com sucesso",
                        "Exclusão bem sucedida", JOptionPane.INFORMATION_MESSAGE);

                listaAlimento.remove(tblAlimento.getSelectedRow());

                try {
                    //**********************************************************************************************************
                    //ga.fireTableDataChanged();
//                        while(tblAlimento.getModel().getRowCount() > 0){
//                            tblAlimento.remove(0);
//                        } 
//                atualizarTabelaAlimentos();
                    atualizarTabelaListaDeCompras();
                } catch (ErroNaConversaoDeStringParaDoubleException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnApagarAlimentoActionPerformed

    private void cmbListaNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbListaNomeItemStateChanged
//        if (cmbListaNome.getSelectedIndex() > 0) {
//            System.out.println(listaListaNome.get(cmbListaNome.getSelectedIndex() - 1));
//            idListaNome = Integer.parseInt(listaListaNome.get(cmbListaNome.getSelectedIndex() - 1).getId());
//            nomeListaNome = cmbListaNome.getSelectedItem().toString();
//            System.out.println(idListaNome);
//            
//            glc = new GestaoTabelaListaDeCompras(listaListaDeCompras);
//            tblListaDeCompras.setModel(glc);
//            tblListaDeCompras.removeAll();
//            atualizarTabelaListaDeCompras();
//            
//        }
    }//GEN-LAST:event_cmbListaNomeItemStateChanged

    private void btnApagarListaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarListaNomeActionPerformed
        if (cmbListaNome.getSelectedIndex() > 0) {
//                            System.out.println(nomeListaNome + "-1");

            int resposta = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja apagar a lista '"
                    + nomeListaNome/*listaListaNome.get(idListaNome).getNomeLista()*/
                    + "' ?", "Selecione uma opção",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//                            System.out.println(idListaNome + "-2");

            if (resposta == 0) {
                //*******************************************************************************************************
                dbw.apagarLinhasRelacionadasAListaNome(idListaNome);
                dbw.apagarListaNome(idListaNome);

                //*********************** APAGAR LINHAS E LISTA  DE COMPRAS CONJUNTAMENTE *******************
                System.out.println(idListaNome + "-3");
                JOptionPane.showMessageDialog(null, "A lista '"
                        + nomeListaNome/*listaListaNome.get(idListaNome).getNomeLista()*/
                        + "' foi apagada com sucesso",
                        "Exclusão bem sucedida", JOptionPane.INFORMATION_MESSAGE);
//                                System.out.println(idListaNome + "-4");
                atualizarComboBox();
                try {
                    atualizarTabelaListaDeCompras();
                } catch (ErroNaConversaoDeStringParaDoubleException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnApagarListaNomeActionPerformed

    private void btnAdicionarAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAlimentoActionPerformed
        if (StringUtils.isNullOrEmpty(txtQuantidade.getText())) {
            JOptionPane.showMessageDialog(null, "O campo 'Quantidade' não pode estar vazio", "Preenchimento incorreto",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                ListaDeCompras lc = new ListaDeCompras();
                double quantidade = lc.converterStringParaDouble(txtQuantidade.getText());
                if (idListaNome < 0 || tblAlimento.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "Selecione o alimento e o nome da lista",
                            "Lista ou Alimento não selecionado", JOptionPane.ERROR_MESSAGE);
                } else {
                    dbw.guardarLinha(txtQuantidade.getText(),
                            listaAlimento.get(tblAlimento.getSelectedRow()).getId(), Integer.toString(idListaNome));
//System.out.println("add linha");
//System.out.println("id lista: "+idListaNome+", id alimento: "+listaAlimento.get(tblAlimento.getSelectedRow()).getId()+", Quantidade: " + txtQuantidade.getText());
                    JOptionPane.showMessageDialog(null, "O alimento '"
                            + listaAlimento.get(tblAlimento.getSelectedRow()).getNomeAlimento()
                            + "' foi adicionado a lista '" //                            + listaListaNome.get(cmbListaNome.getSelectedIndex() - 1).getNomeLista()
                            //                            + "' com sucesso." + txtQuantidade.getText() +","+
                            //                            listaAlimento.get(tblAlimento.getSelectedRow()).getId()+ ","+ Integer.toString(idListaNome)
                            ,
                             "Inclusão bem sucedida", JOptionPane.INFORMATION_MESSAGE);
                    txtQuantidade.setText("");
                    atualizarTabelaListaDeCompras();

                }
            } catch (ErroNaConversaoDeStringParaDoubleException e) {
                JOptionPane.showMessageDialog(null, "O campo 'Quantidade' deve ser preenchido apenas com números",
                        "Preenchimento incorreto", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnAdicionarAlimentoActionPerformed

    private void btnApagarAlimentoLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarAlimentoLCActionPerformed

//        btnAdicionarAlimentoActionPerformed(null);
        
        
        if (tblListaDeCompras.getSelectedRow() > -1) {
            System.out.println(listaListaDeCompras.get(tblListaDeCompras.getSelectedRow()).getId());
            String nomeAlimento = listaListaDeCompras.get(tblListaDeCompras.getSelectedRow()).getAlimento();
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja apagar o alimento '"
                    + nomeAlimento
                    + " da lista '" + listaListaNome.get(cmbListaNome.getSelectedIndex() - 1).getNomeLista()
                    + "' ?", "Selecione uma opção",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == 0) {
                dbw.apagarAlimentoLC(listaListaDeCompras.get(tblListaDeCompras.getSelectedRow()).getId());

                JOptionPane.showMessageDialog(null, "O alimento '"
                        + nomeAlimento
                        + "' foi apagado com sucesso",
                        "Exclusão bem sucedida", JOptionPane.INFORMATION_MESSAGE);

                listaListaDeCompras.remove(tblListaDeCompras.getSelectedRow());
            }
        }
    }//GEN-LAST:event_btnApagarAlimentoLCActionPerformed

    private void cmbListaNomePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbListaNomePropertyChange

    }//GEN-LAST:event_cmbListaNomePropertyChange

    private void cmbListaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaNomeActionPerformed
        if (cmbListaNome.getSelectedIndex() > 0) {
            System.out.println(listaListaNome.get(cmbListaNome.getSelectedIndex() - 1));
            idListaNome = Integer.parseInt(listaListaNome.get(cmbListaNome.getSelectedIndex() - 1).getId());
            nomeListaNome = cmbListaNome.getSelectedItem().toString();
            System.out.println(idListaNome);

            try {
                atualizarTabelaListaDeCompras();
            } catch (ErroNaConversaoDeStringParaDoubleException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (cmbListaNome.getSelectedIndex() == 0) {
            listaListaDeCompras.removeAll(listaListaDeCompras);
            tblListaDeCompras.revalidate();
        }
    }//GEN-LAST:event_cmbListaNomeActionPerformed

    public void atualizarTabelaAlimentos() {
        //**********************************************************************************************************

        tblAlimento.removeAll();
        dbw.buscarAlimento(listaAlimento);
    }

    public void atualizarComboBox() {
        cmbListaNome.removeAllItems();
        cmbListaNome.addItem("Por favor, escolha uma lista");

        //Resetar a Lista
        listaListaNome.clear();

        dbw.buscarListaNome(listaListaNome);

        //**********************************************************************************************************
        for (ListaNome ln : listaListaNome) {
            cmbListaNome.addItem(ln.getNomeLista());
        }

//        for (int i = 0; i < listaListaNome.size(); i++) {
//            cmbListaNome.addItem(listaListaNome.get(i).getNomeLista());
//        }
    }

    public void atualizarTabelaListaDeCompras() throws ErroNaConversaoDeStringParaDoubleException {
        glc = new GestaoTabelaListaDeCompras(listaListaDeCompras);
        tblListaDeCompras.setModel(glc);
        listaListaDeCompras.removeAll(listaListaDeCompras);

        dbw.buscarListaDeCompras(listaListaDeCompras, idListaNome);

        double precoTotal = 0;
        for (ListaDeCompras lc : listaListaDeCompras) {
            precoTotal += lc.converterStringParaDouble(lc.getPreco());
        }
//LIMITAR CASAS DECIMAIS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        lblPrecoTotal.setText(String.format("%.2f",(precoTotal)) + "€");
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
            java.util.logging.Logger.getLogger(GPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAlimento;
    private javax.swing.JButton btnApagarAlimento;
    private javax.swing.JButton btnApagarAlimentoLC;
    private javax.swing.JButton btnApagarListaNome;
    private javax.swing.JComboBox<String> cmbListaNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrecoTotal;
    private javax.swing.JMenuItem mnuAdicionarAlimento;
    private javax.swing.JMenu mnuConfig;
    private javax.swing.JMenuItem mnuSair;
    private javax.swing.JPanel pnlListaAlimentos;
    private javax.swing.JTable tblAlimento;
    private javax.swing.JTable tblListaDeCompras;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}