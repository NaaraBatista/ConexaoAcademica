package view;

import javax.swing.*;
import java.awt.*;
import model.Curso; // importa a classe Curso
import view.TelaAvaliacao; // importa a tela de avaliação

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("CONEXÃO ACADÊMICA - Login");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Cores
        Color azul = new Color(0, 102, 204);
        Color laranja = new Color(255, 153, 0);
        Color fundo = new Color(245, 245, 245);
        getContentPane().setBackground(fundo);

        // Título
        JLabel lblTitulo = new JLabel("CONEXÃO ACADÊMICA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(100, 20, 250, 30);
        add(lblTitulo);

        // Campo E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(50, 70, 300, 25);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(50, 100, 300, 30);
        add(txtEmail);

        // Campo Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 140, 300, 25);
        add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(50, 170, 300, 30);
        add(txtSenha);

        // Botão Entrar
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 220, 300, 40);
        btnEntrar.setBackground(azul);
        btnEntrar.setForeground(Color.WHITE);
        add(btnEntrar);

        btnEntrar.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criando um curso de exemplo
            Curso cursoExemplo = new Curso("Análise de Dados", 80, "EAD", "UFNiterói");
            new TelaAvaliacao(cursoExemplo).setVisible(true);
            dispose();
        });

        // Botão Cadastrar-se
        JButton btnCadastrar = new JButton("Cadastrar-se");
        btnCadastrar.setBounds(50, 270, 300, 40);
        btnCadastrar.setBackground(laranja);
        btnCadastrar.setForeground(Color.WHITE);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            new TelaCadastroUsuario().setVisible(true);
            dispose();
        });

        // Texto Esqueceu a senha?
        JLabel lblEsqueceuSenha = new JLabel("<HTML><U>Esqueceu a senha?</U></HTML>");
        lblEsqueceuSenha.setForeground(Color.BLUE);
        lblEsqueceuSenha.setBounds(140, 320, 150, 20);
        lblEsqueceuSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lblEsqueceuSenha);

        lblEsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Redirecionando para recuperação de senha...");
            }
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
        new TelaLogin().setVisible(true);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

