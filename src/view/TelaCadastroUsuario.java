package view;

import javax.swing.*;
import java.awt.*;
import model.Usuario;

public class TelaCadastroUsuario extends JFrame {

    public TelaCadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(400, 560);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Cores
        Color verde = new Color(0, 153, 51); // botão cadastrar
        Color azul = new Color(0, 102, 204); // botão buscar curso
        Color fundo = new Color(245, 245, 245);
        getContentPane().setBackground(fundo);

        // Labels e campos
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 50, 300, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(50, 80, 300, 30);
        add(txtNome);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(50, 120, 300, 25);
        add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(50, 150, 300, 30);
        add(txtEmail);

        JLabel lblPerfil = new JLabel("Perfil:");
        lblPerfil.setBounds(50, 190, 300, 25);
        add(lblPerfil);

        String[] perfis = {"Estudante", "Professor", "Administrador"};
        JComboBox<String> cbPerfil = new JComboBox<>(perfis);
        cbPerfil.setBounds(50, 220, 300, 30);
        add(cbPerfil);

        // Botão Buscar Curso
        JButton btnBuscarCurso = new JButton("Buscar Curso");
        btnBuscarCurso.setBounds(50, 270, 300, 40);
        btnBuscarCurso.setBackground(azul);
        btnBuscarCurso.setForeground(Color.WHITE);
        add(btnBuscarCurso);

        // Chamada com flag TRUE — vem da tela de cadastro
        btnBuscarCurso.addActionListener(e -> {
            TelaBusca busca = new TelaBusca(true); // ✨ sinaliza origem
            busca.setVisible(true);
        });

        // Botão Cadastrar
        JButton btnSalvar = new JButton("Cadastrar");
        btnSalvar.setBackground(verde);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setBounds(50, 330, 300, 40);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String email = txtEmail.getText().trim();
            String perfil = (String) cbPerfil.getSelectedItem();

            if (nome.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Usuario novoUsuario = new Usuario(nome, email, perfil);
            JOptionPane.showMessageDialog(this,
                    "Usuário cadastrado com sucesso!\n\n" + novoUsuario.toString(),
                    "Cadastro OK", JOptionPane.INFORMATION_MESSAGE);

            dispose(); // Fecha a tela de cadastro
        });
    }
 
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
        new TelaCadastroUsuario().setVisible(true);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
