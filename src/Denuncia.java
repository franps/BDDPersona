import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author francisco.perdomo
 */
public class Denuncia extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();
    int ciDenunciante;
    public Denuncia() {
        initComponents();
        fecha.setText(fecha());
    }
    public Denuncia(int ci) {
        initComponents();
        ciDenunciante= ci ;
        fecha.setText(fecha());
    }
    
     public String fecha(){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

        return date.format(now);
    }
    public void imprimirResultados(ResultSet rs, int tipocons){
        try {
            String res="";
            if (tipocons ==0 && rs!=null){
                while (rs.next()) {
                    res += rs.getString(1)+ ", " 
                          +rs.getString(2)+ ", "
                          +rs.getString(3)+ ", "
                          +rs.getString(4)+ ", "
                          +rs.getString(5)+ ", "
                          +rs.getString(6)+ ", "
                          +rs.getString(7)+ ", "
                          +rs.getString(8)+ ", "
                          +rs.getString(9)+ "\n";
                }
            }else{
                res = "Listo" ;
            }
            resultado.setText(res);
        } catch (SQLException ex) {
            Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try {      
            ResultSet rs = bdd.enviarConsulta("SELECT idmascota FROM Mascota WHERE idmascota="+idmascota.getText());
            if (!rs.next()) {
                lerrormascota.setText("No existe una mascota con ese id");
                respuesta = false;
            }   
            if(!isNumeric(zona.getText())){
                lerrorzona.setText("Zona debe contener solo numeros.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException np){
            lerrorzona.setText("Debe rellenar todos los campos.");
        }
        return respuesta;
    } 
    
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public void limpiarErrores(){
        lerrormascota.setText("     ");
        lerrorzona.setText("     ");
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        fecha = new javax.swing.JFormattedTextField();
        lidmascota = new javax.swing.JLabel();
        lzona = new javax.swing.JLabel();
        insertar = new javax.swing.JButton();
        lfecha = new javax.swing.JLabel();
        zona = new javax.swing.JTextField();
        idmascota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        listar = new javax.swing.JButton();
        tipoDenuncia = new javax.swing.JComboBox<>();
        lerrormascota = new javax.swing.JLabel();
        lerrorzona = new javax.swing.JLabel();
        lfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setLayout(null);

        Titulo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 78, 150));
        Titulo.setText("Ingresar Denuncia");
        Fondo.add(Titulo);
        Titulo.setBounds(103, 11, 197, 29);

        try {
            fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setText("01/01/2017");
        fecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        Fondo.add(fecha);
        fecha.setBounds(480, 100, 90, 20);

        lidmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lidmascota.setForeground(new java.awt.Color(0, 78, 150));
        lidmascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidmascota.setText("ID Mascota");
        Fondo.add(lidmascota);
        lidmascota.setBounds(40, 50, 90, 20);

        lzona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lzona.setForeground(new java.awt.Color(0, 78, 150));
        lzona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lzona.setText("Zona perdido");
        Fondo.add(lzona);
        lzona.setBounds(40, 140, 90, 20);

        insertar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        insertar.setText("Ingresar Denuncia");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        Fondo.add(insertar);
        insertar.setBounds(160, 230, 150, 23);

        lfecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lfecha.setForeground(new java.awt.Color(0, 78, 150));
        lfecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfecha.setText("Fecha Perdido");
        Fondo.add(lfecha);
        lfecha.setBounds(370, 100, 100, 14);

        zona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonaActionPerformed(evt);
            }
        });
        Fondo.add(zona);
        zona.setBounds(140, 140, 210, 20);

        idmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(idmascota);
        idmascota.setBounds(140, 50, 210, 20);

        resultado.setColumns(20);
        resultado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        Fondo.add(jScrollPane1);
        jScrollPane1.setBounds(20, 310, 620, 86);

        listar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        listar.setText("Listar denuncias");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        Fondo.add(listar);
        listar.setBounds(250, 400, 150, 23);

        tipoDenuncia.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tipoDenuncia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perdí mi mascota", "Encontré una mascota" }));
        tipoDenuncia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoDenunciaItemStateChanged(evt);
            }
        });
        tipoDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDenunciaActionPerformed(evt);
            }
        });
        Fondo.add(tipoDenuncia);
        tipoDenuncia.setBounds(140, 100, 210, 20);

        lerrormascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrormascota.setForeground(new java.awt.Color(255, 0, 0));
        lerrormascota.setText("          ");
        Fondo.add(lerrormascota);
        lerrormascota.setBounds(140, 70, 270, 20);

        lerrorzona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorzona.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lerrorzona);
        lerrorzona.setBounds(140, 170, 290, 20);

        lfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoMasc.jpg"))); // NOI18N
        lfondo.setText("     ");
        Fondo.add(lfondo);
        lfondo.setBounds(0, 0, 660, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        boolean chequeo = chequeoDatos();
        System.out.println("..."+tipoDenuncia.getSelectedIndex());
        if (chequeo){
            ResultSet rs = bdd.enviarConsulta("INSERT INTO denuncia(cipersona, tipo_denuncia, id_mascota, fechadenuncia, zona) VALUES ("               
                + ciDenunciante + ","
                + tipoDenuncia.getSelectedIndex() + ","
                + idmascota.getText() + ","
                + "'"+ fecha.getText() + "',"
                + zona.getText() +");");
            limpiarErrores();
            imprimirResultados(rs, 1);
        }

    }//GEN-LAST:event_insertarActionPerformed

    private void zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zonaActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        ResultSet rs = bdd.enviarConsulta("SELECT * FROM Denuncia;");
        imprimirResultados(rs, 0);
    }//GEN-LAST:event_listarActionPerformed

    private void tipoDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDenunciaActionPerformed
        
    }//GEN-LAST:event_tipoDenunciaActionPerformed

    private void tipoDenunciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoDenunciaItemStateChanged
        if (tipoDenuncia.getSelectedIndex()==0){
            lfecha.setText("Fecha Perdido");

        }else{
            lfecha.setText("Fecha Encontrado");
        }
    }//GEN-LAST:event_tipoDenunciaItemStateChanged

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
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Denuncia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField idmascota;
    private javax.swing.JButton insertar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lerrormascota;
    private javax.swing.JLabel lerrorzona;
    private javax.swing.JLabel lfecha;
    private javax.swing.JLabel lfondo;
    private javax.swing.JLabel lidmascota;
    private javax.swing.JButton listar;
    private javax.swing.JLabel lzona;
    private javax.swing.JTextArea resultado;
    private javax.swing.JComboBox<String> tipoDenuncia;
    private javax.swing.JTextField zona;
    // End of variables declaration//GEN-END:variables
}
