package net.weg.GestaoTransporte02.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne
    private Endereco endereco;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany
    private List<Veiculo> veiculos;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany (mappedBy = "motorista")
    private List<Rota> rotas;
}
