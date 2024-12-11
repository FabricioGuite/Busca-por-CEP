package BuscaCep;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite seu CEP");
        var cep = teclado.nextLine();

        ConsultaCep consultaCep = new ConsultaCep();
        Endereco novEndereco = consultaCep.buscaEndereco(cep);
        System.out.println(novEndereco);

        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.geraJson(novEndereco);

        teclado.close();
    }
          
        
}
    
