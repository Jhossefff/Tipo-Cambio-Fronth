package com.empresa.pfdesarrollo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SolicitudCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroSolicitud;
    private String respuestaTipoCambio;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getRespuestaTipoCambio() {
        return respuestaTipoCambio;
    }

    public void setRespuestaTipoCambio(String respuestaTipoCambio) {
        this.respuestaTipoCambio = respuestaTipoCambio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
