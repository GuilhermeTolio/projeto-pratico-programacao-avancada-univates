package ONG_pets;

import screen.homeScreen;
import support.ConexaoBD;

import javax.swing.*;

public class ONG_pets {
    public static void main(String[] args) {
        try {
            ConexaoBD.getInstance().getConnection();
            homeScreen HomeScreen = new homeScreen();
            HomeScreen.show();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!\nPor favor entre em contato com o suporte.");
        } finally {
            ConexaoBD.getInstance().shutdown();
        }

    }

}
