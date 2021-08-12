package one.digitainnovation.projetodio.controller;

import one.digitainnovation.projetodio.model.JornadaTrabalho;
import one.digitainnovation.projetodio.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity <JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception{
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new Exception("Not ¤ Found!")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteById(@PathVariable Long idJornada) {
        jornadaService.deleteJornada(idJornada);
        return ResponseEntity.noContent().build();
    }

}
