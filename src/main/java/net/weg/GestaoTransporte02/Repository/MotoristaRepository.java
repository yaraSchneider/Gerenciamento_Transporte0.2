package net.weg.GestaoTransporte02.Repository;
import net.weg.GestaoTransporte02.Model.Entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {

    boolean existsByNome(String nome);
}
