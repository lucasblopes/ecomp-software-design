package views;

import models.Projeto;
import repositories.ProjetoRepository;
import java.util.List;

public class CadastrarEtapasView extends GenericView {

    public CadastrarEtapasView() {
        super();
    }

    public void showProjetos(ProjetoRepository projetos){
        if(projetos.getProjetos().isEmpty()){
            showError("Nenhum projeto cadastrado ainda");
            return;
        }

        for(Projeto pj : projetos.getProjetos()){
            System.out.println("- " + pj.getTitulo());
        }
    }

    public void showCadastroEtapaScreen(ProjetoRepository projetos) {
        showTitle("Cadastro de Etapas do Projeto");
        System.out.println("Selecione o nome do projeto desejado:");
        showProjetos(projetos);
    }

    public String selecionaProjeto() {
        System.out.println("Projeto Selecionado: ");
        String selectedProject = getInput();
        return selectedProject;
    }

}
