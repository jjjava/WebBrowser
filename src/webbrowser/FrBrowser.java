package webbrowser;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import webbrowser.core.CoreFrBrowser;

/**
 *
 * @author Hudson Schumaker
 */
public class FrBrowser extends JFrame {

    public ArrayList<String> urls;
    public int crt;
    public String path;
    public FrBrowser me;
    private CoreFrBrowser core;

    public FrBrowser() {
        super("HStudio Browser");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/webbrowser/res/web_24.png")));
        initComponents();


//        System.getProperties().put("proxySet", "true");
//        System.getProperties().put("proxyPort", "3128");
//        System.getProperties().put("proxyHost", "172.28.128.15");
//
//
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            public PasswordAuthentication getPasswordAuthentication() {
//                return (new PasswordAuthentication("hudson.sales",
//                        "michelin11".toCharArray()));
//            }
//        };
//        Authenticator.setDefault(authenticator);

        me = this;
        crt = 0;
        urls = new ArrayList<>();
        core = new CoreFrBrowser(this);
        core.start();
        url.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                CoreFrBrowser c = new CoreFrBrowser(me);
                c.start();
                c.getThePage(event.getActionCommand());
            }
        });
        contentsArea.setEditable(false);
        contentsArea.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType()
                        == HyperlinkEvent.EventType.ACTIVATED) {

                    CoreFrBrowser c = new CoreFrBrowser(me);
                    c.start();
                    c.getThePage(event.getURL().toString());
                }
            }
        });
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        bt_ir = new javax.swing.JButton();
        bt_reload = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();
        bt_forward = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentsArea = new javax.swing.JEditorPane();
        jb_Home = new javax.swing.JButton();
        jb_Config = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("URL:");

        bt_ir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/play_16.png"))); // NOI18N
        bt_ir.setToolTipText("Ir");
        bt_ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_irActionPerformed(evt);
            }
        });

        bt_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/ref_16.png"))); // NOI18N
        bt_reload.setToolTipText("Refresh");
        bt_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_reloadActionPerformed(evt);
            }
        });

        bt_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/back_16.png"))); // NOI18N
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        bt_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/forwd_16.png"))); // NOI18N
        bt_forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_forwardActionPerformed(evt);
            }
        });

        contentsArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        contentsArea.setDoubleBuffered(true);
        jScrollPane1.setViewportView(contentsArea);

        jb_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/home_16.png"))); // NOI18N
        jb_Home.setToolTipText("Home");
        jb_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_HomeActionPerformed(evt);
            }
        });

        jb_Config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webbrowser/res/prefs_16.png"))); // NOI18N
        jb_Config.setToolTipText("Home");
        jb_Config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(url)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_reload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_Home))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(bt_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_forward)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_Config)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_reload)
                            .addComponent(bt_ir)
                            .addComponent(jb_Home))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_back)
                    .addComponent(bt_forward)
                    .addComponent(jb_Config))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_irActionPerformed
        core.go();
    }//GEN-LAST:event_bt_irActionPerformed

    private void bt_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reloadActionPerformed
        core.reload();
    }//GEN-LAST:event_bt_reloadActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        core.backPage();
    }//GEN-LAST:event_bt_backActionPerformed

    private void bt_forwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_forwardActionPerformed
        core.fowardPage();
    }//GEN-LAST:event_bt_forwardActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        core.close();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jb_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_HomeActionPerformed
        core.setAdress("http://localhost");
    }//GEN-LAST:event_jb_HomeActionPerformed

    private void jb_ConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_ConfigActionPerformed

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_forward;
    private javax.swing.JButton bt_ir;
    private javax.swing.JButton bt_reload;
    public javax.swing.JEditorPane contentsArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_Config;
    private javax.swing.JButton jb_Home;
    public javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
