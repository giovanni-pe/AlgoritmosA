package tarea;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class sumVec {

    void cargarV(int vec[]) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * 900) + 100;
        }
    }

    int sumaRec(int vec[], int n) {
        return n == 0 ? vec[n] : vec[n] + sumaRec(vec, n - 1);
    }

    int sumarInterativo(int v[]) {
        int suma = 0;
        for (int i : v) {
            suma += i;
        }
        return suma;
    }

    String numerosGenerados(int vec[]) {
        String acu = "";
        int col = 0;
        for (int i : vec) {
            if (col % 20 == 0) {
                acu += "\n";
            }
            acu += " [" + i + "] ";
            col++;
        }
        return acu;
    }
}

class datos {

    private String Tamaño, Tipo;
    private long Inicio, Fin, Resultado;

    public datos(String Tamaño, String Tipo, long Inicio, long Fin, long Resultado) {
        this.Tamaño = Tamaño;
        this.Tipo = Tipo;
        this.Inicio = Inicio;
        this.Fin = Fin;
        this.Resultado = Resultado;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public String getTipo() {
        return Tipo;
    }

    public long getInicio() {
        return Inicio;
    }

    public long getFin() {
        return Fin;
    }

    public long getResultado() {
        return Resultado;
    }

    public String dato() {
        return this.Tamaño + "," + this.Tipo + "," + this.Inicio + "," + this.Fin + "," + this.Resultado;
    }
}

class metodoTXT {

    ArrayList<datos> lista = new ArrayList<>();
    File arch = new File("ABC.txt");

    public metodoTXT(ArrayList<datos> lista) {
        this.lista = lista;
    }

    public metodoTXT() {
    }

    void escribir() throws IOException {
        if (!arch.exists()) {
            arch.createNewFile();
        }
        PrintWriter pw = new PrintWriter(arch);
        for (datos p : lista) {
            pw.println(p.dato());
        }
        pw.close();
    }

    void leer() throws IOException {
        if (!arch.exists()) {
            arch.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(arch));
        String cad;
        while ((cad = br.readLine()) != null) {
            String cad2[] = cad.split(",");
            this.lista.add(new datos(cad2[0].trim(), cad2[1].trim(), Long.parseLong(cad2[2]), Long.parseLong(cad2[3]), Long.parseLong(cad2[4])));
        }
    }

    void ingresar(datos p) {
        lista.add(p);
    }

    public ArrayList<datos> getLista() {
        return lista;
    }
}

public class vistaSumaVector extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    ArrayList<datos> lista;
    int vec[];
    int n = 0;
    sumVec suma_vector = new sumVec();
    metodoTXT mtxt;

    public vistaSumaVector() throws IOException {
        this.setContentPane(fondo);
        this.setTitle("RECURSIVIDAD");
        Image imagen = new ImageIcon(getClass().getResource("insignia.png")).getImage();
        this.setIconImage(imagen);
        initComponents();
        this.jTextArea1.append("\t\t*******************BIENVENIDO*****************");
        lista = new ArrayList<>();
        mtxt = new metodoTXT();
        mtxt.leer();
        lista = mtxt.getLista();
        llenarTabla();
        btng_grupo.add(rbtn_iterativo);
        btng_grupo.add(rbtn_recursivo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.jTextArea1.setEditable(false);
    }

    private void llenarTabla() {
        String cabeza[] = {"Tamaño", "Tipo", "Inicio ", "Fin", "Resultado (ns)"};
        DefaultTableModel modelodef = new DefaultTableModel(cabeza, lista.size());
        tbl_datos.setModel(modelodef);
        TableModel modelo = tbl_datos.getModel();
        for (int i = 0; i < lista.size(); i++) {
            datos d = lista.get(i);
            modelo.setValueAt(d.getTamaño(), i, 0);
            modelo.setValueAt(d.getTipo(), i, 1);
            modelo.setValueAt(d.getInicio(), i, 2);
            modelo.setValueAt(d.getFin(), i, 3);
            modelo.setValueAt(d.getResultado(), i, 4);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btng_grupo = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbtn_recursivo = new javax.swing.JRadioButton();
        rbtn_iterativo = new javax.swing.JRadioButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();
        btn_generar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_numero_elementos = new javax.swing.JTextField();
        btn_realizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 172, 15));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SUMA DE ELEMENTOS DE UN VECTOR");

        jLabel3.setText("Tipo");

        rbtn_recursivo.setBackground(new java.awt.Color(51, 51, 51));
        rbtn_recursivo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbtn_recursivo.setForeground(new java.awt.Color(153, 255, 0));
        rbtn_recursivo.setSelected(true);
        rbtn_recursivo.setText("RECURSIVO");
        rbtn_recursivo.setBorderPainted(true);
        rbtn_recursivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_recursivoActionPerformed(evt);
            }
        });

        rbtn_iterativo.setBackground(new java.awt.Color(0, 0, 0));
        rbtn_iterativo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        rbtn_iterativo.setForeground(new java.awt.Color(255, 255, 0));
        rbtn_iterativo.setText("ITERATIVO");
        rbtn_iterativo.setBorderPainted(true);
        rbtn_iterativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_iterativoActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(102, 204, 0));
        jDesktopPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDesktopPane1.setForeground(new java.awt.Color(0, 102, 0));

        tbl_datos.setBackground(new java.awt.Color(51, 255, 51));
        tbl_datos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 204, 255)));
        tbl_datos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        tbl_datos.setForeground(new java.awt.Color(0, 0, 102));
        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_datos.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tbl_datos.setSelectionForeground(new java.awt.Color(0, 51, 204));
        jScrollPane1.setViewportView(tbl_datos);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btn_generar.setBackground(new java.awt.Color(204, 204, 255));
        btn_generar.setText("Generar Data");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Numero Elementos");

        txt_numero_elementos.setBackground(new java.awt.Color(204, 204, 255));
        txt_numero_elementos.setText("0");
        txt_numero_elementos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_elementosActionPerformed(evt);
            }
        });

        btn_realizar.setBackground(new java.awt.Color(102, 102, 102));
        btn_realizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_realizar.setForeground(new java.awt.Color(153, 255, 255));
        btn_realizar.setText("Realizar");
        btn_realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_realizarActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 255, 51));
        jLabel5.setForeground(new java.awt.Color(204, 255, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tarea/insignia.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(204, 204, 204)));

        jTextArea1.setBackground(new java.awt.Color(153, 255, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(btn_realizar))
                                            .addComponent(rbtn_recursivo)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(rbtn_iterativo))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(txt_numero_elementos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_generar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(261, 261, 261)
                                                .addComponent(jLabel3)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(txt_numero_elementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_generar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtn_recursivo)
                                .addGap(6, 6, 6)
                                .addComponent(rbtn_iterativo)
                                .addGap(65, 65, 65)
                                .addComponent(btn_realizar))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_recursivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_recursivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_recursivoActionPerformed

    private void rbtn_iterativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_iterativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_iterativoActionPerformed

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed

        this.jTextArea1.setText("");
        n = Integer.parseInt(this.txt_numero_elementos.getText().trim());
        this.vec = new int[n];
        this.suma_vector.cargarV(vec);
        this.jTextArea1.append(this.suma_vector.numerosGenerados(vec));
    }//GEN-LAST:event_btn_generarActionPerformed

    private void btn_realizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_realizarActionPerformed
        long inicio = 0;
        long fin = 0;
        int resultado = 0;

        if (this.vec != null) {
            if (this.rbtn_recursivo.isSelected()) {
                inicio = System.nanoTime();
                resultado = suma_vector.sumaRec(vec, n - 1);
                fin = System.nanoTime();
                lista.add(new datos(n + "", "recursivo", inicio, fin, fin - inicio));
            } else {
                inicio = System.nanoTime();
                resultado = this.suma_vector.sumarInterativo(vec);
                fin = System.nanoTime();
                lista.add(new datos(n + "", "Iterativo", inicio, fin, fin - inicio));
            }
            JOptionPane.showMessageDialog(null, "sumatoria: " + resultado);
            mtxt = new metodoTXT(lista);
            try {
                mtxt.escribir();
            } catch (IOException ex) {
                Logger.getLogger(vistaSumaVector.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenarTabla();
        }
    }//GEN-LAST:event_btn_realizarActionPerformed

    private void txt_numero_elementosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_elementosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_elementosActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new vistaSumaVector().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(vistaSumaVector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_realizar;
    private javax.swing.ButtonGroup btng_grupo;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rbtn_iterativo;
    private javax.swing.JRadioButton rbtn_recursivo;
    private javax.swing.JTable tbl_datos;
    private javax.swing.JTextField txt_numero_elementos;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("UNAS.png")).getImage();
            g.drawImage(imagen, 150, 0, 600, 40, this);
            //getWhidth()
            setOpaque(false);
            super.paint(g);
        }

    }
}
