package net.weg.GestaoTransporte02.Service;

import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.DTO.VeiculoPostRequestDTO;
import net.weg.GestaoTransporte02.Model.Entity.Veiculo;
import net.weg.GestaoTransporte02.Repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public Veiculo addVeiculo(VeiculoPostRequestDTO veiculoPostRequestDTO){
        if (veiculoRepository.existsByPlaca(veiculoPostRequestDTO.placa())){
            throw new RuntimeException();
        }
        return veiculoRepository.save(veiculoPostRequestDTO.converVeiculo());
    }

    public List<Veiculo> buscarVeiculo(){
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Integer id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()){
            return  veiculoOptional.get();
        }
        throw  new RuntimeException();
    }

    public Veiculo atualizarVeiculo (Integer id, Veiculo veiculo){
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Integer id){
        veiculoRepository.deleteById(id);
    }
}
