package Logica_De_Negocio;

import javax.swing.*;

public class Menu {
    String[] opcoes;
    int resX, resY;
    int buttonX = 256;
    int buttonY = 64;
    JFrame frame;

    public Menu(String[] opcoes){
        this.opcoes = opcoes;
        this.resX = 1280;
        this.resY = 720;
    }

    public Menu(String[] opcoes, int resX, int resY){
        this.opcoes = opcoes;
        this.resX = resX;
        this.resY = resY;
    }

    /**
     *
     * @return valor escolhido pelo utilizador, 0 caso cancelar ou erro
     */
    public int startMenu(){
        frame = new JFrame();//creating instance of JFrame
        JButton[] buttons = new JButton[opcoes.length];
        for(int i = 0; i < opcoes.length; i++){
            buttons[i] = new JButton(opcoes[i]);
            buttons[i].setBounds(resX/2-buttonX/2,(resY/2)+2*i*buttonY,buttonX,buttonY);
            frame.add(buttons[i]);
        }
        frame.setSize(resX,resY);
        frame.setLayout(null);
        frame.setVisible(true);
        return -1;
    }
}
