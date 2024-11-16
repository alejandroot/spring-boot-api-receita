package br.com.atflow.springbootapireceita.controllers;

import br.com.atflow.springbootapireceita.services.CnpjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultar")
public class CnpjController {

    @Autowired
    private CnpjService cnpjService;

    @Value("${api.version}")
    private String apiVersion;

    @GetMapping("/{cnpj}")
    public String consultarCnpj(@PathVariable String cnpj) {
        return cnpjService.consultarCnpj(cnpj);
    }

    @GetMapping("/version")
    public String getApiVersion() {
        return apiVersion;
    }
}

