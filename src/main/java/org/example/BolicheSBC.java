package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BolicheSBC {
    public static void main(String[] args) {
        // Janela principal
        JFrame frame = new JFrame("Verificador de Bolas de Boliche");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Painel para os campos de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        //  campos de entrada
        JLabel diametroLabel = new JLabel("Diâmetro da Bola:");
        JTextField diametroField = new JTextField();

        JLabel alturaLabel = new JLabel("Altura da Caixa:");
        JTextField alturaField = new JTextField();

        JLabel larguraLabel = new JLabel("Largura da Caixa:");
        JTextField larguraField = new JTextField();

        JLabel profundidadeLabel = new JLabel("Profundidade da Caixa:");
        JTextField profundidadeField = new JTextField();

        // Botão para verificar
        JButton verificarButton = new JButton("Verificar");

        // Resultado
        JLabel resultadoLabel = new JLabel("Resultado: ", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Adiciona os componentes ao painel
        panel.add(diametroLabel);
        panel.add(diametroField);
        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(larguraLabel);
        panel.add(larguraField);
        panel.add(profundidadeLabel);
        panel.add(profundidadeField);
        panel.add(verificarButton);
        panel.add(resultadoLabel);

        // Adiciona o painel à janela
        frame.add(panel);

        // Ação do botão "Verificar"
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int diametro = Integer.parseInt(diametroField.getText());
                    int altura = Integer.parseInt(alturaField.getText());
                    int largura = Integer.parseInt(larguraField.getText());
                    int profundidade = Integer.parseInt(profundidadeField.getText());

                    // Verifica se a bola cabe na caixa
                    boolean cabe = diametro <= Math.min(Math.min(altura, largura), profundidade);

                    // Atualiza o resultado
                    resultadoLabel.setText("Resultado: " + (cabe ? "S" : "N"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
}