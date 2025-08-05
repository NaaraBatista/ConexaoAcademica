package view;

import dao.CursoDAO;
import model.Curso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaBusca extends JFrame {
    private JTextField txtBusca;
    private final JButton btnBuscar;
    private JPanel painelResultados;
    private JCheckBox chkPresencial, chkPrivada, chkEAD;
    private boolean chamadaPelaCadastro;

    public TelaBusca(boolean chamadaPelaCadastro) {
        this.chamadaPelaCadastro = chamadaPelaCadastro;

        setTitle("Buscar Cursos");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null); // centraliza
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Botão de fechar "X"
        JButton btnFechar = new JButton("X");
        btnFechar.setBounds(550, 10, 40, 30);
        btnFechar.setFocusable(false);
        add(btnFechar);

        btnFechar.addActionListener(e -> {
            if (chamadaPelaCadastro) {
                this.setVisible(false); // só esconde se veio da tela de cadastro
            } else {
                this.dispose(); // fecha geral se veio sozinho
            }
        });

        // Título
        JLabel lblTitulo = new JLabel("Buscar cursos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(30, 20, 200, 30);
        add(lblTitulo);

        // Campo de busca com placeholder
        txtBusca = new JTextField("Digite o nome do curso...");
        txtBusca.setForeground(Color.GRAY);
        txtBusca.setBounds(30, 60, 300, 30);
        add(txtBusca);

        txtBusca.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (txtBusca.getText().equals("Digite o nome do curso...")) {
                    txtBusca.setText("");
                    txtBusca.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (txtBusca.getText().isEmpty()) {
                    txtBusca.setText("Digite o nome do curso...");
                    txtBusca.setForeground(Color.GRAY);
                }
            }
        });

        // Botão de busca
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(340, 60, 100, 30);
        add(btnBuscar);

        // Filtros
        chkPresencial = new JCheckBox("Presencial");
        chkPrivada = new JCheckBox("Privada");
        chkEAD = new JCheckBox("EAD");

        chkPresencial.setBounds(30, 100, 100, 30);
        chkPrivada.setBounds(140, 100, 100, 30);
        chkEAD.setBounds(250, 100, 100, 30);

        add(chkPresencial);
        add(chkPrivada);
        add(chkEAD);

        // Painel de resultados
        painelResultados = new JPanel();
        painelResultados.setLayout(new GridLayout(0, 1, 5, 5));
        JScrollPane scrollPane = new JScrollPane(painelResultados);
        scrollPane.setBounds(30, 150, 540, 280);
        add(scrollPane);

        // Ação do botão buscar
        btnBuscar.addActionListener(e -> {
            String termo = txtBusca.getText().trim().toLowerCase();
            painelResultados.removeAll();

            CursoDAO dao = new CursoDAO();
            ArrayList<Curso> encontrados = new ArrayList<>();

            for (Curso c : dao.listarCursos()) {
                boolean nomeCombina = c.getNome().toLowerCase().contains(termo);
                boolean modalidadeCombina = (
                    (chkPresencial.isSelected() && c.getModalidade().equalsIgnoreCase("Presencial")) ||
                    (chkPrivada.isSelected() && c.getModalidade().equalsIgnoreCase("Privada")) ||
                    (chkEAD.isSelected() && c.getModalidade().equalsIgnoreCase("EAD")) ||
                    (!chkPresencial.isSelected() && !chkPrivada.isSelected() && !chkEAD.isSelected())
                );

                if (nomeCombina && modalidadeCombina) {
                    encontrados.add(c);

                    JPanel card = new JPanel(new GridLayout(3, 1));
                    card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    card.add(new JLabel("Curso: " + c.getNome()));
                    card.add(new JLabel("Instituição: " + c.getInstituicao()));
                    card.add(new JLabel("Modalidade: " + c.getModalidade()));
                    painelResultados.add(card);
                }
            }

            painelResultados.revalidate();
            painelResultados.repaint();

            if (encontrados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum curso encontrado.");
            }
        });

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaBusca(false)); // direta
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

