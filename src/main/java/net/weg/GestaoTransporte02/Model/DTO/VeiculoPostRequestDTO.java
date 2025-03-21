package net.weg.GestaoTransporte02.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import net.weg.GestaoTransporte02.Model.Entity.Veiculo;

public record VeiculoPostRequestDTO(@NotBlank String marca,
                                    @NotBlank String modelo,
                                    @NotBlank String placa) {

    public Veiculo converVeiculo(){
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .build();
    }

}
