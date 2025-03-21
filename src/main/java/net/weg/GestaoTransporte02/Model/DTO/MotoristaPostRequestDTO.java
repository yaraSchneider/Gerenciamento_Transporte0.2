package net.weg.GestaoTransporte02.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import net.weg.GestaoTransporte02.Model.Entity.Motorista;

public record MotoristaPostRequestDTO (@NotBlank String nome,
                                       @NotBlank String email,
                                       String telefone){

    public Motorista convertMotorista (){
        return Motorista.builder()
                .nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .build();
    }
}
