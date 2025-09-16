package rosa.ribeiro.jonas.Endpoints;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public List<PostagemModel> listarTodas() {
        return (List<PostagemModel>) postagemRepository.findAll();
    }

    public Optional<PostagemModel> buscarPorId(Long id) {
        return postagemRepository.findById(id);
    }

    public PostagemModel criar(PostagemModel novaPostagem) {
        novaPostagem.setDataCriacao(LocalDateTime.now());
        return postagemRepository.save(novaPostagem);
    }

    public PostagemModel atualizar(Long id, PostagemModel dadosAtualizacao) {
        PostagemModel postagemExistente = postagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));

        postagemExistente.setTitulo(dadosAtualizacao.getTitulo());
        postagemExistente.setConteudo(dadosAtualizacao.getConteudo());

        return postagemRepository.save(postagemExistente);
    }

    public void deletar(Long id) {
        if (!postagemRepository.existsById(id)) {
            throw new RuntimeException("Postagem não encontrada!");
        }
        postagemRepository.deleteById(id);
    }
}