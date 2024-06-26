/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1compi1;

import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.parser;

/**
 *
 * @author Dominic
 */
public class Main extends javax.swing.JFrame {

    public static Objeto miObjeto = new Objeto();

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        //this.setSize(1350, 700);
        this.setLocationRelativeTo(null);

    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        File directorioInicial = new File("C:\\Users\\Dominic\\Documents\\NetBeansProjects\\Proyecto1Compi1\\src\\proyecto1compi1\\archivosPrueba");
        fileChooser.setCurrentDirectory(directorioInicial);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            boolean archivoYaAbierto = miObjeto.contieneString(selectedFile.toString());
            if (archivoYaAbierto) {
                JOptionPane.showMessageDialog(this, "El archivo ya está abierto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                leerArchivo(selectedFile);
            }
        }
    }

    private void leerArchivo(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            jTabbedPane1.addTab(file.getName(), scrollPane);
            miObjeto.agregarString(file.toString()); // Almacena la ruta del archivo
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarArchivoActual() {
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        if (selectedIndex != -1) {
            JScrollPane scrollPane = (JScrollPane) jTabbedPane1.getComponentAt(selectedIndex);
            JViewport viewport = scrollPane.getViewport();
            JTextArea textArea = (JTextArea) viewport.getView();
            String contenido = textArea.getText();

            String file = miObjeto.obtenerString(selectedIndex);
            if (file != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(contenido);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la ruta del archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna pestaña seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void guardarArchivoComo() {
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        if (selectedIndex != -1) {
            JScrollPane scrollPane = (JScrollPane) jTabbedPane1.getComponentAt(selectedIndex);
            JViewport viewport = scrollPane.getViewport();
            JTextArea textArea = (JTextArea) viewport.getView();
            String contenido = textArea.getText();

            JFileChooser fileChooser = new JFileChooser();
            File directorioInicial = new File("C:\\Users\\Dominic\\Documents\\NetBeansProjects\\Proyecto1Compi1\\src\\proyecto1compi1");
            fileChooser.setCurrentDirectory(directorioInicial);
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(contenido);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna pestaña seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cerrarPestañaActual() {
        //guardarArchivoActual();
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        if (selectedIndex != -1) {
            jTabbedPane1.removeTabAt(selectedIndex);
            miObjeto.eliminarString(selectedIndex); // Elimina la ruta del archivo asociada
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna pestaña seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void abrirArchivoEnBlanco() {
        String nombreArchivo = JOptionPane.showInputDialog(this, "Ingrese el nombre del documento:", "Nuevo documento", JOptionPane.PLAIN_MESSAGE);
        if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);
            jTabbedPane1.addTab(nombreArchivo, scrollPane);
            miObjeto.agregarString("C:\\Users\\Dominic\\Documents\\NetBeansProjects\\Proyecto1Compi1\\src\\proyecto1compi1\\" + nombreArchivo + ".df");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dominic\\Documents\\NetBeansProjects\\Proyecto1Compi1\\src\\proyecto1compi1\\" + nombreArchivo + ".df"))) {
                writer.write("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del documento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
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

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataForge");

        jButton3.setText("Ejecutar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reportes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextArea3.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setFocusable(false);
        jScrollPane3.setViewportView(jTextArea3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abrir Archivo", "Nuevo Archivo", "Guardar Archivo Como", "Guardar Archivo", "Cerrar Ventana de Archivo", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFocusable(false);
        jLabel1.setOpaque(true);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cargar");

        jButton5.setText("Anterior");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Siguiente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton3)
                        .addGap(77, 77, 77)
                        .addComponent(jButton4)
                        .addGap(55, 55, 55)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton5)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) jComboBox1.getSelectedItem();
        switch (selectedItem) {
            case "Abrir Archivo":
                abrirArchivo();
                break;
            case "Guardar Archivo Como":
                guardarArchivoComo();
                break;
            case "Guardar Archivo":
                guardarArchivoActual();
                break;
            case "Cerrar Ventana de Archivo":
                cerrarPestañaActual();
                break;
            case "Nuevo Archivo":
                abrirArchivoEnBlanco();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Se detectó un error, por favor vuelva a seleccionar una opción.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextArea3.setText("");
        miObjeto.limpiarMapa();
        System.out.println("----- Ejemplo 1 -----");
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        String analisis = "";
        if (selectedIndex != -1) {
            try {
                JScrollPane scrollPane = (JScrollPane) jTabbedPane1.getComponentAt(selectedIndex);
                JViewport viewport = scrollPane.getViewport();
                JTextArea textArea = (JTextArea) viewport.getView();
                String contenido = textArea.getText();
                lexEx1 scan = new lexEx1(new BufferedReader(new StringReader(contenido)));
                // System.out.println(contenido);
                Parser sintax = new Parser(scan);
                sintax.parse().toString();
            } catch (Exception ex) {
                miObjeto.imprimirMapa();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            miObjeto.generarYAbrirHTML();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardarArchivoActual();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
