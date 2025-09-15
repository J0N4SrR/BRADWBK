package rosa.ribeiro.jonas.Endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {
    private final PostagemRepository postagemRepository;

    public PostagemController(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    @GetMapping
    public List<PostagemModel> listarTodasAsPostagens() {
        return postagemRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostagemModel criarPostagem(@RequestBody PostagemModel novaPostagem) {
        novaPostagem.setDataCriacao(LocalDateTime.now()); // Garante que a data de criação é a atual.
        return postagemRepository.save(novaPostagem);
    }

}
