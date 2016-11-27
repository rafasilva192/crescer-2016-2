/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer;

import br.com.cwi.crescer.business.Executavel;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MeuSqlUtils {

    public MeuSqlUtils() {
    }

    public void SqlUtils(Scanner input) {
        List<String> listaSql;
        boolean executando = true;
        while (executando) {
            System.out.println("1 - Executar ações Sql\n2 - Ler informações do banco\n3 - Importar CSV\nsair - volta para o menu");
            String entrada = input.nextLine();
            switch (entrada) {
                case "1":
                    System.out.println("Digite o nome do arquivo sql");
                    File file = new File(input.nextLine());
                    listaSql = new Executavel().LerArquivo(file);
                    executarSql(listaSql);
                    break;
                case "2":
                    System.out.println("Digite o comando sql");
                    entrada = input.nextLine().trim();
                    lerBanco(entrada);
                    break;
                case "3":
                    System.out.println("Digite o nome do arquivo csv");
                    File fileCSV = new File(input.nextLine().trim());
                    if (fileCSV.exists()) {
                        System.out.println("Digite o nome da Table");
                        entrada = input.nextLine().trim();
                        lerCSV(fileCSV, entrada);
                    } else {
                        System.out.println("Arquivo não existe");
                    }
                    break;
                case "sair":
                    executando = false;
                    break;
            }
        }
    }

    private void executarSql(List<String> listaSql) {

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            for (String executar : listaSql) {
                statement.executeUpdate(executar);
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }

    private void lerBanco(String query) {
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {

            try (final ResultSet resultSet = statement.executeQuery(query);) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int tamanhoResult = rsmd.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= tamanhoResult; i++) {
                        System.out.println(String.format("%s: %s", rsmd.getColumnName(i), resultSet.getString(i)));
                    }
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    private void lerCSV(File file, String Table) {
        String extension = new Executavel().getExtension(file.getAbsolutePath());
        if (extension.equals("csv")) {
            try (
                    final Connection connection = ConnectionUtils.getConnection();
                    final Statement statement = connection.createStatement();) {
                String loadQuery = "LOAD DATA INFILE '" + file.getAbsolutePath()
                        + "' INTO TABLE " + Table + " APPEND FIELDS TERMINATED BY ','";
                System.out.println(loadQuery);

                statement.execute(loadQuery);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        }
    }
}
