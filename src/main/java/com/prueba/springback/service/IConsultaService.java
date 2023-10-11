package com.prueba.springback.service;

import org.springframework.http.ResponseEntity;

public interface IConsultaService {
    ResponseEntity<?> consultaUsuario(String tipoId, String numeroId);
}
