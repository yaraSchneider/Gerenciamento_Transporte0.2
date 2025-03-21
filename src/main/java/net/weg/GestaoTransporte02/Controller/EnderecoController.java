package net.weg.GestaoTransporte02.Controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.DTO.EnderecoPostRequestDTO;
import net.weg.GestaoTransporte02.Model.Entity.Endereco;
import net.weg.GestaoTransporte02.Service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/endereco")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> addEndereco(@RequestBody @Valid EnderecoPostRequestDTO enderecoPostRequestDTO){
        try{
            Endereco endereco = enderecoService.addEndereco(enderecoPostRequestDTO);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> procurarEndereco(){
        try{
            List<Endereco> enderecos = enderecoService.procurarEndereco();
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> procurarMotoruistaPorId(@PathVariable Integer id){
        try{
            Endereco endereco = enderecoService.procurarEnderecoPorId(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco){
        try {
            endereco = enderecoService.atualizarEndereco(id, endereco);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Integer id){
        try {
            enderecoService.deletarEndereco(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
