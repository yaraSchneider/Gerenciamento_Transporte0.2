package net.weg.GestaoTransporte02.Controller;
import lombok.AllArgsConstructor;
import net.weg.GestaoTransporte02.Model.Entity.Rota;
import net.weg.GestaoTransporte02.Service.RotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rota")
@AllArgsConstructor
public class RotaController {

    private RotaService rotaService;

    @PostMapping
    public ResponseEntity<Rota> addRota(@RequestBody Rota rota){
        try{
            rota = rotaService.addRota(rota);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Rota>> procurarRota(){
        try{
            List<Rota> rotas = rotaService.buscarRota();
            return new ResponseEntity<>(rotas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> procurarMotoruistaPorId(@PathVariable Integer id){
        try{
            Rota rota = rotaService.buscarRotaPorId(id);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> atualizarRota(@PathVariable Integer id, @RequestBody Rota rota){
        try {
            rota = rotaService.atualizarRota(id, rota);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRota(@PathVariable Integer id){
        try {
            rotaService.deletarRota(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
