package controllers;

import java.util.Optional;
import models.*;
import repositories.ProjetoRepository;
import views.CadastrarEtapasView;

public class CadastrarEtapasCtrl {
    private CadastrarEtapasView view;

    public CadastrarEtapasCtrl() { this.view = new CadastrarEtapasView(); }

    public void cadastrarEtapa(ProjetoRepository projetos) {

        view.showCadastroEtapaScreen(projetos);

        String selectedProject = view.selecionaProjeto();

        Optional<Projeto> foundProj = projetos.buscarProjeto(selectedProject);
        if(foundProj.isPresent())
            foundProj.get().printaProjeto();
        else
           view.showError("Projeto não encontrado.");



    }
}
