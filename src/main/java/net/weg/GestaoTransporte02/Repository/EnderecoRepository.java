package net.weg.GestaoTransporte02.Repository;
import net.weg.GestaoTransporte02.Model.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    boolean existsByNumero(Integer numero);
}
