package repositories;

import models.Membro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Data Access Object Pattern
public class MembroRepository {
  private List<Membro> membros;

  public MembroRepository() {
    this.membros = new ArrayList<>();
  }

  public List<Membro> getMembros() {
    return membros;
  }

  public void setMembros(List<Membro> membros) {
    this.membros = membros;
  }

  public void adicionarMembro(Membro membro) {
    membros.add(membro);
  }

  public void removerMembro(Membro membro) {
    membros.remove(membro);
  }

  public Optional<Membro> buscarMembro(String nome) {
    return membros.stream()
        .filter(p -> p.getNome().equalsIgnoreCase(nome))
        .findFirst();
  }
}
