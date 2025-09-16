package rosa.ribeiro.jonas.Endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rosa.ribeiro.jonas.Endpoints.PostagemModel;
import rosa.ribeiro.jonas.Endpoints.PostagemService;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;

    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping
    public List<PostagemModel> listarTodasAsPostagens() {
        return postagemService.listarTodas();
    }

    @GetMapping("/{id}")
    // ResponseEntity nos dá controle total sobre a resposta HTTP (status, headers, body)
    public ResponseEntity<PostagemModel> buscarPorId(@PathVariable Long id) {
        return postagemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostagemModel criarPostagem(@RequestBody PostagemModel novaPostagem) {
        return postagemService.criar(novaPostagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostagemModel> atualizarPostagem(@PathVariable Long id, @RequestBody PostagemModel postagemAtualizada) {
        try {
            PostagemModel postagem = postagemService.atualizar(id, postagemAtualizada);
            return ResponseEntity.ok(postagem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content é o padrão para DELETE bem-sucedido
    public void removerPostagem(@PathVariable Long id) {
        postagemService.deletar(id);
    }
}