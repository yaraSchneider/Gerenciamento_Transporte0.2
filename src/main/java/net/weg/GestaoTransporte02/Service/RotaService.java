package net.weg.GestaoTransporte02.Service;
import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.Entity.Rota;
import net.weg.GestaoTransporte02.Repository.RotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RotaService {

    private RotaRepository rotaRepository;

    public Rota addRota(Rota rota){
        return rotaRepository.save(rota);
    }

    public List<Rota> buscarRota(){
        return rotaRepository.findAll();
    }

    public Rota buscarRotaPorId(Integer id){
        Optional<Rota> rotaOptional = rotaRepository.findById(id);
        if (rotaOptional.isPresent()){
            return rotaOptional.get();
        }
        throw new RuntimeException();
    }

    public Rota atualizarRota(Integer id, Rota rota){
        rota.setId(id);
        return rotaRepository.save(rota);
    }

    public void deletarRota (Integer id){
        rotaRepository.deleteById(id);
    }

}
