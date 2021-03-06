/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcodemag;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author F
 */
public class Barcode extends javax.swing.JFrame {

    public String server = "";
    public String db = "";
    public String usr = "";
    public String pwd = "";
    public String prt = "";

    public CampiDB aggSigillo;
    public String DbAct = "";

    public static MySqlAccess dao;

    private Object[][] logResults;
    public DefaultTableModel defaultTableModellog;
    public Object[] columnslog;

    /**
     * Creates new form Barcode
     */
    /**
     * *
     * File parametri c:\barcode\cfg.txt: LABEL server database user password
     * prt
     */
    public Barcode() {
        initComponents();
        readConfig();
        lsig.setVisible(false);
        lqta.setVisible(false);
        tqta.setVisible(false);
        tannulla.setVisible(false);
        columnslog = new Object[]{"Codice", "Descrizione", "Lotto", "Qta"};
        defaultTableModellog = new DefaultTableModel(logResults, columnslog);
        dao = new MySqlAccess(server, db, usr, pwd);
        jTable1.setModel(dao.defaultTableModel);
        jTable2.setModel(defaultTableModellog);
        setColumnWidths(jTable1, dao.columns, 7, 10, 180, 20);
        setColumnWidths(jTable2, dao.columns, 7, 180, 10, 20);
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
        bcode = new javax.swing.JTextField();
        lsig = new javax.swing.JLabel();
        lcod = new javax.swing.JLabel();
        ldes = new javax.swing.JLabel();
        llot = new javax.swing.JLabel();
        tqta = new javax.swing.JTextField();
        lqta = new javax.swing.JLabel();
        tannulla = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tsrc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stampa Etichette");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        bcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcodeActionPerformed(evt);
            }
        });

        lsig.setBackground(new java.awt.Color(255, 51, 51));
        lsig.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lsig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lsig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lcod.setBackground(new java.awt.Color(204, 204, 204));
        lcod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lcod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ldes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ldes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        llot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        llot.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        tqta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tqta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tqta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tqtaActionPerformed(evt);
            }
        });

        lqta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lqta.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        tannulla.setText("Annulla");
        tannulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tannullaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lcod, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ldes, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lqta, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tqta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(tannulla, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lsig, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(llot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcod, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ldes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lsig, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(llot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tqta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lqta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tannulla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Stampa Etichette [SIGILLO]");

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 2, 24)); // NOI18N

        labn.setFont(new java.awt.Font("Swis721 Blk BT", 2, 24)); // NOI18N
        labn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        tsrc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tsrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsrcActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(labn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tsrc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tsrc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcodeActionPerformed
        String id = bcode.getText();
        bcode.setText("");
        bcode(id);
    }//GEN-LAST:event_bcodeActionPerformed

    private void tqtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tqtaActionPerformed
        // TODO add your handling code here:
        if (aggSigillo.isCk()) {
            if (DbAct.equals("ins")) {
                try {
                    dao.creaSigillo(aggSigillo, Integer.parseInt(tqta.getText()));
                    leggiSigillo(Integer.toString(aggSigillo.getId()));
                    tqta.setText("");
                    tqta.requestFocus();
                } catch (SQLException ex) {
                    Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (DbAct.equals("upd")) {
                try {
                    doUpdt();
                } catch (Exception ex) {
                    Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tqtaActionPerformed

    private void tsrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsrcActionPerformed
        try {
            dao.listaLotti(tsrc.getText());
            tsrc.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tsrcActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        bcode(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void tannullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tannullaActionPerformed
        resetForm();
    }//GEN-LAST:event_tannullaActionPerformed

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
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barcode().setVisible(true);
            }
        });
    }

    private void bcode(String id) {
        dao.defaultTableModel.setRowCount(0);
        if ("S".equals(id.substring(0, 1))) {
            id = id.substring(1);
            try {
                leggiSigillo(id);
            } catch (SQLException ex) {
                Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                CampiDB campi = dao.cscDecode(id);
                if (campi.isCk()) {
                    lsig.setOpaque(false);
                    tqta.setBackground(Color.YELLOW);
                    compilaCampi(campi);
                    inputQta("Inserire qta sigillo");
                    aggSigillo = campi;
                    DbAct = "ins";
                }
            } catch (SQLException ex) {
                Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void leggiSigillo(String id) throws SQLException {
        CampiDB campi = dao.leggiSigillo(id);
        if (campi.isCk()) {
            tqta.setBackground(Color.WHITE);
            compilaCampi(campi);
            if (campi.getQta() > 0) {
                lsig.setOpaque(false);
                inputQta("Inserire qta prelevata");
                aggSigillo = campi;
                DbAct = "upd";
            } else {
                lsig.setOpaque(true);
            }
        }
    }

    private void doUpdt() throws Exception {
        int qtap = Integer.parseInt(tqta.getText());
        dao.updtSigillo(aggSigillo, qtap);
        leggiSigillo(Integer.toString(aggSigillo.getId()));
        printZebra(qtap);
        logUpdt(aggSigillo, qtap);
        resetForm();
    }

    private void compilaCampi(CampiDB campi) {
        lcod.setText(campi.getCod());
        ldes.setText(campi.getDes());
        llot.setText("Lotto: " + campi.getLotto());
        lsig.setVisible(true);
        lsig.setText(Integer.toString(campi.getQta()));
    }

    private void inputQta(String msg) {
        lqta.setText(msg);
        bcode.setVisible(false);
        lqta.setVisible(true);
        tqta.setVisible(true);
        tqta.requestFocus();
        tannulla.setVisible(true);
    }

    private void resetForm() {
        lcod.setText("");
        ldes.setText("");
        lsig.setText("");
        lsig.setVisible(false);
        llot.setText("");
        lqta.setText("");
        lqta.setVisible(false);
        tqta.setText("");
        tqta.setVisible(false);
        tannulla.setVisible(false);
        bcode.setText("");
        bcode.setVisible(true);
        dao.defaultTableModel.setRowCount(0);
        bcode.requestFocus();
    }

    private void readConfig() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        try {
            BufferedReader br = new BufferedReader(new FileReader("c://barcode//cfg.txt"));
            labn.setText(br.readLine());
            server = br.readLine();
            db = br.readLine();
            usr = br.readLine();
            pwd = br.readLine();
            prt = br.readLine();
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Barcode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void logUpdt(CampiDB campi, int qta) {
        Object[] tempRow;
        tempRow = new Object[]{campi.getCod(), campi.getDes(), campi.getLotto(), qta};
        defaultTableModellog.addRow(tempRow);
    }

    private void printZebra(int qtap) throws Exception {
        PrintService[] service = PrinterJob.lookupPrintServices(); // list of printers
        int count = service.length;
        boolean zebraloc = false;
        for (int i = 0; i < count; i++) {
            if (service[i].getName().equalsIgnoreCase(this.prt)) {
                zebraloc = true;
                printLabel(service[i], qtap);
                i = count;
            }
        }
        if (!zebraloc) {
            URL server = new URL("http://" + this.server + "/" + this.db + "/lot/barcodemag.php?prt=" + this.prt
                    + "&sig=" + aggSigillo.getId()
                    + "&qtap=" + qtap);
            URLConnection yc = server.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine + "\n");
            }
            in.close();
        }
    }

    private boolean printLabel(PrintService printService, int qtap) {
        if (printService == null) {
            System.err.println("[Print Label] print service is invalid.");
            return false;
        }

        String command
                = "CT~~CD,~CC^~CT~"
                + "^XA~TA000~JSN^LT0^MNW^MTT^PON^PMN^LH0,0^JMA^PR3,3~SD25^JUS^LRN^CI0^XZ"
                + "~DG000.GRF,01280,020,"
                + ",:::::::::::::::::::::N03F807F007C07FHFC7FFC03F7F07F,N03F80FE00FE0FIFCFHFE03E3F8FE,N07FC1FF01FE07FHFC7FHF07F1F8FC,N07F83FE03FE0FIFCFIF87E1F9FC,N07FC1FE03FF003F00FC1F87E0FDF8,N0HFC3FE03FE003F00F81F8FE0FHF8,N07DC7DC07DF003F00F81F87C07FF0,N0FBE7BE0FHFH03F00F83F8FE03FE0,N079C7BC07DF007F01F81F07C03FC0,N0FBEFBE0F9F803E01FHFE0FE03F80,N0F9CF7C1F9F007E01FHFC07C03FC0,N0FBFE7E3F8F807E03FHF80FE07FE0,N0F9DE7C3F0F807E01FHFE0FC07FC0,N0F9FEFC3E0F80FE03F87E0FC0FFE0,N0F1FC7C7FHF807C01F03F0FC1FHF0,M01FBFEFE7FHFC0FE03F83F0F83FBF8,M01F1F87C7FHFC07C03F07F1F87F1F8,M01F8F8F8FIFC0FE03F03E1F8FE1F8,M01F0F0F9FC07C0FC03F07E1F8FC0FC,M03F8F0FBF80FE0FE03F03F3FBFE0FE,,:::::::::::::::::::::~DG001.GRF,01024,016,"
                + ",:::::::::::::::::::::H0FE01FC01F01FIF1FHFH0FDFC1FC,H0FE03F803F83FIF3FHF80F8FE3F8,01FF07FC07F81FIF1FHFC1FC7E3F0,01FE0FF80FF83FIF3FHFE1F87E7F0,01FF07F80FFC00FC03F07E1F83F7E0,03FF0FF80FF800FC03E07E3F83FFE0,01F71F701F7C00FC03E07E1F01FFC0,03EF9EF83FFC00FC03E0FE3F80FF80,01E71EF01F7C01FC07E07C1F00FF,03EFBEF83E7E00F807FHF83F80FE,03E73DF07E7C01F807FHF01F00FF,03EFF9F8FE3E01F80FHFE03F81FF80,03E779F0FC3E01F807FHF83F01FF,03E7FBF0F83E03F80FE1F83F03FF80,03C7F1F1FHFE01F007C0FC3F07FFC0,07EFFBF9FIF03F80FE0FC3E0FEFE0,07C7E1F1FIF01F00FC1FC7E1FC7E0,07E3E3E3FIF03F80FC0F87E3F87E0,07C3C3E7F01F03F00FC1F87E3F03F0,0FE3C3EFE03F83F80FC0FCFEFF83F8,,:::::::::::::::::::::^XA"
                + "^MMT"
                + "^PW751"
                + "^LL0200"
                + "^LS - 10"
                + "^FT576,64^XG000.GRF,1,1^FS"
                + "^FT224,64^XG001.GRF,1,1^FS"
                + "^BY2,3,32^FT455,175^B3N,N,,Y,N"
                + "^FDS" + aggSigillo.getId() + "^FS"
                + "^BY2,3,32^FT32,175^B3N,N,,Y,N"
                + "^FD" + aggSigillo.getCsc() + "^FS"
                + "^FT403,44^A0N,34,33^FH\\^FD" + aggSigillo.getCod() + "^FS"
                + "^FT403,69^A0N,28,19^FH\\^FD" + aggSigillo.getDes() + "^FS"
                + "^FT25,44^A0N,34,33^FH\\^FD" + aggSigillo.getCod() + "^FS"
                + "^FT517,111^A0N,39,38^FH\\^FDQta. " + aggSigillo.getQta() + "^FS"
                + "^FT25,69^A0N,28,19^FH\\^FD" + aggSigillo.getDes() + "^FS"
                + "^FT466,139^A0N,23,24^FH\\^FDLotto: " + aggSigillo.getLotto() + "^FS"
                + "^FO448,74^GB250,45,2^FS"
                + "^FT147,106^A0N,34,33^FH\\^FD" + qtap + "^FS"
                + "^FT88,139^A0N,23,24^FH\\^FDLotto: " + aggSigillo.getLotto() + "^FS"
                + "^PQ1,0,1,Y^XZ"
                + "^XA^ID000.GRF^FS^XZ"
                + "^XA^ID001.GRF^FS^XZ";

        byte[] data;
        data = command.getBytes(StandardCharsets.US_ASCII);
        Doc doc = new SimpleDoc(data, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);

        boolean result = false;
        try {
            printService.createPrintJob().print(doc, null);
            result = true;
        } catch (PrintException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void setColumnWidths(JTable table, Object[] columns, int... widths) {
        TableColumn column;
        for (int i = 0; i < columns.length; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(widths[i]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bcode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labn;
    private javax.swing.JLabel lcod;
    private javax.swing.JLabel ldes;
    private javax.swing.JLabel llot;
    private javax.swing.JLabel lqta;
    private javax.swing.JLabel lsig;
    private javax.swing.JButton tannulla;
    private javax.swing.JTextField tqta;
    private javax.swing.JTextField tsrc;
    // End of variables declaration//GEN-END:variables
}
