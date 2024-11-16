package com.empresa.pfdesarrollo.controller;

import com.empresa.pfdesarrollo.model.SolicitudCambio;
import com.empresa.pfdesarrollo.repository.SolicitudCambioRepository;
import com.empresa.pfdesarrollo.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @Autowired
    private SolicitudCambioRepository solicitudCambioRepository;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarTipoCambio() {
        String tipoCambio = tipoCambioService.obtenerTipoCambio();
        
        if (tipoCambio != null) {
            SolicitudCambio solicitud = new SolicitudCambio();
            solicitud.setNumeroSolicitud("123"); // Genera o asigna un número de solicitud
            solicitud.setRespuestaTipoCambio(tipoCambio);
            solicitudCambioRepository.save(solicitud);

            return ResponseEntity.ok(solicitud);
        } else {
            return ResponseEntity.status(500).body("Error al obtener el tipo de cambio");
        }
    }
}
