package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.dao.peopleDAO;
import entity.peopleEntity;

public class peopleController {
    static peopleDAO peopleDAO = new peopleDAO();

    public static boolean save(peopleEntity person) {
        try {
            peopleDAO.save(person);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar pessoa: " + ex.getMessage());
            return false;
        }
    }

    public boolean edit(peopleEntity person) {
        try {
            peopleDAO.edit(person);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar pessoa: " + ex.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            peopleDAO.delete(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir pessoa: " + ex.getMessage());
            return false;
        }
    }

    public peopleEntity recover(int id) {
        try {
            peopleEntity person = peopleDAO.recover(id);
            return person;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }
    }

    public static ArrayList<peopleEntity> recoverAll() {
        ArrayList<peopleEntity> people = null;
        try {
            people = peopleDAO.recoverAll();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pessoas: " + ex.getMessage());
        }
        return people;
    }
}
