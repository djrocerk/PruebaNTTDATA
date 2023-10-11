package com.prueba.springback.api;

import com.prueba.springback.model.cliente;

import com.prueba.springback.service.IConsultaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class ClienteController {

    private final IConsultaService consultaService;
    
    public ClienteController(IConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/cliente")
    public ResponseEntity<?> obtenerCliente(@RequestParam String tipoId, @RequestParam String numeroId) {
        return consultaService.consultaUsuario(tipoId, numeroId);
    }
}
