package BuscaCep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void geraJson(Endereco endereco) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter escrita = new FileWriter("Enderecos.json")) {
            escrita.write(gson.toJson(endereco));
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }
}
