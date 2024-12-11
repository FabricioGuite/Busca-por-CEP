package BuscaCep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaCep {

    // Método retorna um objeto do tipo Endereco
    public Endereco buscaEndereco(String cep) throws Exception {
        // Criação da URI com o CEP informado
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        // Criação do cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criação da requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        // Envio da requisição e obtenção da resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Conversão da resposta JSON para o objeto Endereco
        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
