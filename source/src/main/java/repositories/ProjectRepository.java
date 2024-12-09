package repositories;

import models.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Data Access Object Pattern
public class ProjectRepository {

    private List<Project> projects;

    public ProjectRepository() {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Optional<Project> findProject(String title) {
        return projects.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }
}
