package net.weg.GestaoTransporte02.Controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.DTO.VeiculoPostRequestDTO;
import net.weg.GestaoTransporte02.Model.Entity.Veiculo;
import net.weg.GestaoTransporte02.Service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
@AllArgsConstructor
public class VeiculoController {

    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> addVeiculo(@RequestBody @Valid VeiculoPostRequestDTO veiculoPostRequestDTO){
        try{
            Veiculo veiculo = veiculoService.addVeiculo(veiculoPostRequestDTO);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> procurarVeiculo(){
        try{
            List<Veiculo> veiculos = veiculoService.buscarVeiculo();
            return new ResponseEntity<>(veiculos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> procurarMotoruistaPorId(@PathVariable Integer id){
        try{
            Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo){
        try {
            veiculo = veiculoService.atualizarVeiculo(id, veiculo);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Integer id){
        try {
            veiculoService.deletarVeiculo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
