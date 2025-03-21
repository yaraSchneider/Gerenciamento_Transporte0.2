package net.weg.GestaoTransporte02.Repository;
import net.weg.GestaoTransporte02.Model.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    boolean existsByPlaca(String placa);
}
