package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.dao.animalDAO;
import entity.animalEntity;

public class animalController {
    static animalDAO animalDAO = new animalDAO();

    public static boolean save(animalEntity animal) {
        try {
            animalDAO.save(animal);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar animal: " + ex.getMessage());
            return false;
        }
    }

    public boolean edit(animalEntity animal){
        try {
            animalDAO.edit(animal);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar animal: " + ex.getMessage());
            return false;
        }
    }

    public boolean delete(int id){
        try {
            animalDAO.delete(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir animal: " + ex.getMessage());
            return false;
        }
    }

    public animalEntity recover(int id){
        try {
            animalEntity animal = animalDAO.recover(id);
            return animal;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar animal: " + ex.getMessage());
            return null;
        }
    }

    public static ArrayList<animalEntity> recoverAll(){
        ArrayList<animalEntity> vetorClientes = null;
        try {
            vetorClientes = animalDAO.recoverAll();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar animais: " + ex.getMessage());
        }
        return vetorClientes;
    }
}
