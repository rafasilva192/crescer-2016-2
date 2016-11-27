package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaFactory {

    public void create() {
        final String ddl = "CREATE TABLE CARLOS ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(ddl);

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }

    public List<Pessoa> findAll() {
        final String query = "SELECT * FROM CARLOS";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            List<Pessoa> list = new ArrayList<>();
            while (resultSet.next()) {
                final Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(resultSet.getLong("id_pessoa"));
                pessoa.setNmPessoa(resultSet.getString("nm_pessoa"));
                list.add(pessoa);
            }
            return list;
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }

    public void delete(Pessoa p) {
        final String insert = "DELETE CARLOS WHERE ID_PESSOA = ?";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setLong(1, p.getIdPessoa());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void insert(Pessoa p) {
        final String insert = "INSERT INTO CARLOS("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setLong(1, p.getIdPessoa());
            preparedStatement.setString(2, p.getNmPessoa());

            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void main(String args[]) {
        final PessoaFactory pessoaFactory = new PessoaFactory();

        for (int i = 0; i < 10; i++) {
            final Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(Long.valueOf(i));
            pessoa.setNmPessoa("PESSOA " + i);
            pessoaFactory.insert(pessoa);
        }

        pessoaFactory.findAll().forEach(pessoa -> {
            System.out.format("{'idPessoa':'%s', 'nmPessoa':'%s'}", pessoa.getIdPessoa(), pessoa.getNmPessoa());
        });

    }

}
