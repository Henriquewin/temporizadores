package com.hw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

@Entity
public class Temporizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double days;
    private Double segundos;
    private Double hours;
    private Double min;
    private Double seg;
    private String titulo;
    @Transient
    private String dataFormatada;

    public String getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }
    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days  ;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getSeg() {
        return seg;
    }

    public void setSeg(Double seg) {
        this.seg = seg;
    }

    private LocalDateTime data;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
        this.dataFormatada = formatarData(data);
    }

    @Transient
    private Duration cronometro;

    public Duration getCronometro() {
        return cronometro;
    }

    public void setCronometro(Duration cronometro) {
        this.cronometro = cronometro;
    }

    public Double getSegundos() {
        return segundos;
    }

    public void setSegundos(Double segundos) {
        this.segundos = segundos;
    }
    private String formatarData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(formatter);
    }
}
