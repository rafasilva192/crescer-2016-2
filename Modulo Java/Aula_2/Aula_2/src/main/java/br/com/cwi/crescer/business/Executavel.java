/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executavel {

    final private String action;
    final private File file;
    final private ImageValidator validador = new ImageValidator();

    public Executavel(String comando) {
        action = comando.trim().split(" ")[0];
        file = new File(comando.trim().substring(2).trim());
    }

    public Executavel() {
        action = null;
        file = null;
    }

    public boolean exec() {

        // executar metodo
        return false;
    }

    public String getAction() {
        return action;
    }

    public File getFile() {
        return file;
    }

    public boolean CriarArquivo(File file) {
        String extension = getExtension(file.getAbsolutePath());
        try {
            if (!file.exists() && validador.validate(String.format("%s.%s", file.getName(), extension))) {
                return file.createNewFile();
            } else if (!file.exists()) {
                return file.mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean RemoverArquivo(File file) {
        String extension = getExtension(file.getAbsolutePath());
        try {
            if (file.exists() && validador.validate(String.format("%s.%s", file.getName(), extension))) {
                return Files.deleteIfExists(file.toPath());
            }
        } catch (IOException ex) {
            Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<String> CaminhoArquivo(File file) {
        String extension = getExtension(file.getAbsolutePath());
        List<String> listaCaminho = new ArrayList<>();

        if (file.exists() && validador.validate(String.format("%s.%s", file.getName(), extension))) {
            listaCaminho.add(file.getAbsolutePath());
        } else if (file.exists()) {
            for (File fileDiretorio : file.listFiles()) {
                if (fileDiretorio.isFile()) {
                    listaCaminho.add(fileDiretorio.getName());
                }
            }
        }
        return listaCaminho;
    }

    public boolean MoverArquivo(File file, File path) {
        String extension = getExtension(file.getAbsolutePath());
        String pathExtension = getExtension(path.getAbsolutePath());
        if (file.exists() && !path.exists() && validador.validate(String.format("%s.%s", path.getName(), pathExtension)) && validador.validate(String.format("%s.%s", file.getName(), extension))) {
            try {
                Files.move(Paths.get(file.getPath()), Paths.get(path.getPath()));
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<String> LerArquivo(File file) {
        List<String> listaConteudo = new ArrayList<>();
        String extension = getExtension(file.getAbsolutePath());
        if (file.exists() && (extension.equals("txt") || extension.equals("sql"))) {
            try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                String linhaAtual = br.readLine();
                while (linhaAtual != null) {
                    listaConteudo.add(linhaAtual);
                    linhaAtual = br.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!file.exists()) {
            listaConteudo.add("Arquivo não encontrado!");
        } else if (!extension.equals("txt")) {
            listaConteudo.add("Extensão não suportada");
        }
        return listaConteudo;
    }

    public String editarArquivo(File file, List<String> listParaAppend) {
        String extension = getExtension(file.getAbsolutePath());
        if (file.exists() && extension.equals("txt")) {
            try (Writer output = new BufferedWriter(new FileWriter(file, true));) {
                 for(String linha : listParaAppend){
                     
                     output.append(String.format("%s\r\n",linha));
                     
                 }
            } catch (IOException ex) {
                Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Arquivo escrito com sucesso!";
    }

    public static String getExtension(String path) {
        int i = path.lastIndexOf('.');
        if (i >= 0) {
            return path = path.substring(i + 1);
        }
        return "";
    }


}
