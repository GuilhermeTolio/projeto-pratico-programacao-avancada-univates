package entity.dao;

import entity.animalEntity;
import support.ConexaoBD;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class animalDAO {
    private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public void save(animalEntity animal) throws SQLException {
        String sql = ""
                + "INSERT INTO animais (id_animal, nome_animal, especie_animal, raca_animal, "
                + "idade_animal, estado_saude_animal, historico_vacinas_animal, data_resgate_animal) VALUES ("
                + animal.getId() + ","
                + "'" + animal.getNome() + "',"
                + "'" + animal.getEspecie() + "',"
                + "'" + animal.getRaca() + "',"
                + animal.getIdade() + ","
                + "'" + animal.getEstadoSaude() + "',"
                + "'" + animal.getHistoricoVacinas() + "',"
                + "'" + animal.getDataResgate() + "'"
                + ")";

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<animalEntity> recoverAll() throws SQLException {
        ArrayList<animalEntity> animais = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM animais";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            animalEntity animal = new animalEntity(
                    resultadoQ.getInt("id_animal"),
                    resultadoQ.getString("nome_animal"),
                    resultadoQ.getString("especie_animal"),
                    resultadoQ.getString("raca_animal"),
                    resultadoQ.getString("idade_animal"),
                    resultadoQ.getString("estado_saude_animal"),
                    resultadoQ.getString("historico_vacinas_animal"),
                    resultadoQ.getString("data_resgate_animal")
            );

            animais.add(animal);
        }

        return animais;
    }

    public animalEntity recover(int id) throws SQLException {
        animalEntity animal = null;
        String sql = ""
                + "SELECT * FROM animais WHERE id_animal = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            animal = new animalEntity(
                    resultadoQ.getInt("id_animal"),
                    resultadoQ.getString("nome_animal"),
                    resultadoQ.getString("especie_animal"),
                    resultadoQ.getString("raca_animal"),
                    resultadoQ.getString("idade_animal"),
                    resultadoQ.getString("estado_saude_animal"),
                    resultadoQ.getString("historico_vacinas_animal"),
                    resultadoQ.getString("data_resgate_animal")
            );
        }

        return animal;
    }

    public void edit(animalEntity animal) throws SQLException {
        String sql = ""
                + "UPDATE animais "
                + "SET "
                + "nome_animal = '" + animal.getNome() + "',"
                + "especie_animal = '" + animal.getEspecie() + "',"
                + "raca_animal = '" + animal.getRaca() + "',"
                + "idade_animal = " + animal.getIdade() + ","
                + "estado_saude_animal = '" + animal.getEstadoSaude() + "',"
                + "historico_vacinas_animal = '" + animal.getHistoricoVacinas() + "',"
                + "data_resgate_animal = '" + animal.getDataResgate() + "' "
                + "WHERE id_animal = " + animal.getId();

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }

    public void delete(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM animais WHERE id_animal = " + id;

        System.out.println("sql: " + sql);
        ConexaoBD.executeUpdate(sql);
    }
}