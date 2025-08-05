package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Avaliacao;
import model.Curso;

public class TelaAvaliacao extends JFrame {

    private final Curso curso;
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public TelaAvaliacao(Curso curso) {
        this.curso = curso;
        setTitle("Avaliação do Curso");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cabeçalho com dados do curso
        JTextArea detalhesCurso = new JTextArea(curso.getDetalhes());
        detalhesCurso.setEditable(false);
        add(detalhesCurso, BorderLayout.NORTH);

        // Lista de avaliações
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> listaAvaliacoes = new JList<>(model);
        JScrollPane scroll = new JScrollPane(listaAvaliacoes);
        add(scroll, BorderLayout.CENTER);

        // Painel para nova avaliação com respiro
        JPanel painelNova = new JPanel();
        painelNova.setLayout(null);
        painelNova.setPreferredSize(new Dimension(500, 180));
        painelNova.setBackground(new Color(245, 245, 245)); // mesma cor de fundo

        JLabel lblNota = new JLabel("Nota:");
        lblNota.setBounds(30, 10, 100, 25);
        painelNova.add(lblNota);

        JComboBox<Integer> notaBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        notaBox.setBounds(30, 35, 100, 30);
        painelNova.add(notaBox);

        JLabel lblComentario = new JLabel("Comentário:");
        lblComentario.setBounds(30, 75, 300, 25);
        painelNova.add(lblComentario);

        JTextField comentario = new JTextField();
        comentario.setBounds(30, 100, 430, 30);
        painelNova.add(comentario);

        JButton enviar = new JButton("Enviar Avaliação");
        enviar.setBounds(160, 140, 180, 35); // botão com espaço abaixo
        painelNova.add(enviar);

        add(painelNova, BorderLayout.SOUTH);

        // Lógica de envio da avaliação
        enviar.addActionListener(e -> {
            int nota = (int) notaBox.getSelectedItem();
            String texto = comentario.getText();
            Avaliacao nova = new Avaliacao(nota, texto);
            avaliacoes.add(nova);
            model.addElement("⭐ " + nota + " - " + texto);
            comentario.setText("");
        });
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
        Curso cursoExemplo = new Curso("Análise de Dados", 80, "EAD", "UFNiterói");
        new TelaAvaliacao(cursoExemplo).setVisible(true);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

