package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carlos H. Nonnemacher
 */
public class ExemploConsulta {

    public static void main(String[] args) {

        final String query = "SELECT * FROM CARLOS";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
            ) 
        {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                
                while(resultSet.next()) {
                    final long idPessoa = resultSet.getLong("ID_PESSOA");
                    final String nmPessoa = resultSet.getString("NM_PESSOA");
                    
                    System.out.format("ID: %s NOME: %s\n", idPessoa, nmPessoa);
                }
                
                
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
