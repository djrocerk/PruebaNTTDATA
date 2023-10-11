package com.prueba.springback.service.Impl;

import com.prueba.springback.model.cliente;
import com.prueba.springback.service.IConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    private Map<String, cliente> clientes = new HashMap<>();

    public ConsultaServiceImpl(){
        // Datos quemados (simulando una base de datos)
        clientes.put("C23445322", new cliente("Roberto", "Carlos", "Cerquera", "Guerrero", "3044659022", "Calle 1, No. 28 b-50", "Neiva"));
        clientes.put("P79765431", new cliente("María", "", "Ortiz", "Muñoz", "3186929471", "Calle 1, No. 28 b-50", "Neiva"));
    }

    @Override
    public ResponseEntity<?> consultaUsuario(String tipoId, String numeroId) {
        try {
            if (tipoId == null || numeroId == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los parámetros 'tipo' y 'numero' son obligatorios.");
            }

            if (!tipoId.equals("C") && !tipoId.equals("P")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El tipo de documento debe ser 'C' o 'P'.");
            }

            // Formar el identificador del cliente
            String clienteId = tipoId + numeroId;

            // Buscar al cliente en la "base de datos (quemada)"
            cliente cliente = clientes.get(clienteId);


            if (cliente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado.");
            }

            return ResponseEntity.ok("Cliente encontrado: " + cliente);

        } catch (Exception ex) {
            // Capturar cualquier excepción no controladas y manejar el error 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + ex.getMessage());
        }
    }
}
