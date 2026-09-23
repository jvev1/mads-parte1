package demoapp.controller;

import javax.validation.constraints.NotNull;

public class NumeroData {

    @NotNull(message = "El número no puede estar vacío")
    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}