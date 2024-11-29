package repositories;

import models.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjetoRepository {
    private List<Projeto> projetos;

    public ProjetoRepository() {
        this.projetos = new ArrayList<>();
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public void removerProjeto(Projeto projeto) {
        projetos.remove(projeto);
    }

    public Optional<Projeto> buscarProjeto(String titulo) {
        return projetos.stream()
                .filter(p -> p.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }
}
