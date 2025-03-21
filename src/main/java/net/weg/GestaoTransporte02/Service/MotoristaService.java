package net.weg.GestaoTransporte02.Service;
import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.DTO.MotoristaPostRequestDTO;
import net.weg.GestaoTransporte02.Model.Entity.Motorista;
import net.weg.GestaoTransporte02.Repository.MotoristaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MotoristaService {

    private MotoristaRepository motoristaRepository;

    public Motorista addMotorista(MotoristaPostRequestDTO motoristaPostRequestDTO){
        if (motoristaRepository.existsByNome(motoristaPostRequestDTO.nome())){
            throw new RuntimeException();
        }
        return motoristaRepository.save(motoristaPostRequestDTO.convertMotorista());
    }

    public List<Motorista> buscarMotorista(){
        return motoristaRepository.findAll();
    }

    public Motorista buscarMotoristaPorId(Integer id){
        Optional<Motorista> motoristaOptional = motoristaRepository.findById(id);
        if (motoristaOptional.isPresent()){
            return motoristaOptional.get();
        }
        throw  new RuntimeException();
    }

    public Motorista atualizarMotorista(Integer id, Motorista motorista){
        motorista.setId(id);
        return motoristaRepository.save(motorista);
    }

    public void deleteMotorista(Integer id){
        motoristaRepository.deleteById(id);
    }
}
