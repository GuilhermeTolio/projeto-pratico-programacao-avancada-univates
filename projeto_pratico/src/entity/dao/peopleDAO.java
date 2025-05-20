package entity.dao;

import entity.peopleEntity;
import support.ConexaoBD;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class peopleDAO {
    private ResultSet resultadoQ = null;

    public void save(peopleEntity person) throws SQLException {
        String sql = ""
                + "INSERT INTO pessoa (id_pessoa, nome_pessoa, cpf_cnpj, telefone_pessoa, "
                + "email_pessoa, tipo_pessoa, historia_pessoa, voluntario_pessoa) VALUES ("
                + person.getId() + ","
                + "'" + person.getName() + "',"
                + "'" + person.getCpfCnpj() + "',"
                + "'" + person.getTelephone() + "',"
                + "'" + person.getEmail() + "',"
                + "'" + person.getType() + "',"
                + "'" + person.getHistoric() + "',"
                + person.isVolunteer()
                + ")";

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<peopleEntity> recoverAll() throws SQLException {
        ArrayList<peopleEntity> people = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM pessoa";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            peopleEntity person = new peopleEntity(
                    resultadoQ.getInt("id_pessoa"),
                    resultadoQ.getString("nome_pessoa"),
                    resultadoQ.getString("cpf_cnpj"),
                    resultadoQ.getString("telefone_pessoa"),
                    resultadoQ.getString("email_pessoa"),
                    resultadoQ.getString("tipo_pessoa"),
                    resultadoQ.getString("historia_pessoa"),
                    resultadoQ.getBoolean("voluntario_pessoa")
            );

            people.add(person);
        }

        return people;
    }

    public peopleEntity recover(int id) throws SQLException {
        peopleEntity person = null;
        String sql = ""
                + "SELECT * FROM pessoa WHERE id_pessoa = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            person = new peopleEntity(
                    resultadoQ.getInt("id_pessoa"),
                    resultadoQ.getString("nome_pessoa"),
                    resultadoQ.getString("cpf_cnpj"),
                    resultadoQ.getString("telefone_pessoa"),
                    resultadoQ.getString("email_pessoa"),
                    resultadoQ.getString("tipo_pessoa"),
                    resultadoQ.getString("historia_pessoa"),
                    resultadoQ.getBoolean("voluntario_pessoa")
            );
        }

        return person;
    }

    public void edit(peopleEntity person) throws SQLException {
        String sql = ""
                + "UPDATE pessoa "
                + "SET "
                + "nome_pessoa = '" + person.getName() + "',"
                + "cpf_cnpj = '" + person.getCpfCnpj() + "',"
                + "telefone_pessoa = '" + person.getTelephone() + "',"
                + "email_pessoa = '" + person.getEmail() + "',"
                + "tipo_pessoa = '" + person.getType() + "',"
                + "historia_pessoa = '" + person.getHistoric() + "',"
                + "voluntario_pessoa = " + person.isVolunteer() + " "
                + "WHERE id_pessoa = " + person.getId();

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    public void delete(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM pessoa WHERE id_pessoa = " + id;

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }
} 