package com.empresa.pfdesarrollo.controller;

import com.empresa.pfdesarrollo.model.SolicitudCambio;
import com.empresa.pfdesarrollo.repository.SolicitudCambioRepository;
import com.empresa.pfdesarrollo.service.TipoCambioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;
    private final SolicitudCambioRepository solicitudCambioRepository;

    public TipoCambioController(TipoCambioService tipoCambioService, SolicitudCambioRepository solicitudCambioRepository) {
        this.tipoCambioService = tipoCambioService;
        this.solicitudCambioRepository = solicitudCambioRepository;
    }

    @GetMapping("/ultima")
    public SolicitudCambio obtenerUltimoTipoCambio() {
        return solicitudCambioRepository.findTopByOrderByIdDesc();
    }

    @GetMapping("/todas")
    public List<SolicitudCambio> obtenerTodasSolicitudes() {
        return solicitudCambioRepository.findAll();
    }

    @PostMapping("/registrar")
    public SolicitudCambio registrarSolicitud() {
        String respuestaTipoCambio = tipoCambioService.obtenerTipoCambio();
        SolicitudCambio solicitud = new SolicitudCambio();
        solicitud.setNumeroSolicitud("123"); // Número de solicitud (puedes generar uno único aquí)
        solicitud.setRespuestaTipoCambio(respuestaTipoCambio);
        return solicitudCambioRepository.save(solicitud);
    }
}
