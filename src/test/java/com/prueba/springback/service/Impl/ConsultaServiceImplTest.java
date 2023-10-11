package com.prueba.springback.service.Impl;

import com.prueba.springback.model.cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceImplTest {

    @InjectMocks
    private ConsultaServiceImpl consultaService;

    @BeforeEach
    void setUp() {
        Map<String, cliente> clientes = new HashMap<>();
        clientes.put("C23445322", new cliente("Roberto", "Carlos", "Cerquera", "Guerrero", "3044659022", "Calle 1, No. 28 b-50", "Neiva"));
        clientes.put("P79765431", new cliente("María", "", "Ortiz", "Muñoz", "3186929471", "Calle 1, No. 28 b-50", "Neiva"));
    }

    @Test
    void consultaUsuarioWhenResultOK() {
        var result = consultaService.consultaUsuario("C", "23445322");
        System.out.println(result);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("200 OK", result.getStatusCode().toString());
    }

    @Test
    void consultaUsuarioWhenResultBadRequest() {
        var result = consultaService.consultaUsuario("X", "23445322");
        System.out.println(result);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("400 BAD_REQUEST", result.getStatusCode().toString());
    }

    @Test
    void consultaUsuarioWhenResultNotFound() {
        var result = consultaService.consultaUsuario("C", "0000000");
        System.out.println(result);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("404 NOT_FOUND", result.getStatusCode().toString());
    }
}