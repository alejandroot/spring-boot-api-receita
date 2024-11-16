package br.com.atflow.springbootapireceita.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class CnpjService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_CNPJ = "https://receitaws.com.br/v1/cnpj/";

    public String consultarCnpj(String cnpj) {
        try {
            // Chamada para a API externa da Receita Federal
            String url = URL_CNPJ + cnpj;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            // Verificando o status da resposta e retornando o conteúdo
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                return "Erro ao consultar CNPJ";
            }
        } catch (Exception e) {
            return "Erro ao consultar CNPJ: " + e.getMessage();
        }
    }
}

