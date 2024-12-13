
package repositories;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import models.Dev;

public class DevRepository {

    private List<Dev> devs;

    public DevRepository() {
        this.devs = new ArrayList<>();
    }

    public void setDevs(List<Dev> devs) {
        this.devs = devs;
    }
    
    public List<Dev> getDevs() {
        return devs;
    }

    public void addDev(Dev dev) {
        this.devs.add(dev);
    }

    public Optional<Dev> findDev(String name) {
        return devs.stream()
            .filter(d -> d.getMember().getName().equalsIgnoreCase(name))
            .findFirst();
    }
}
