package cu.edu.cujae.rentacar.front.view.navigation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Data
@Builder
public class MenuItem implements Serializable {
    private final String label;
    private String url;
    private List<MenuItem> menuItems;
    private String badge;
    private String parentLabel;
    private String imageSrc;

    public MenuItem(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public MenuItem(String label, String url, String badge) {
        this.label = label;
        this.url = url;
        this.badge = badge;
    }

    public MenuItem(String label, String url, String badge, String imageSrc) {
        this.label = label;
        this.url = url;
        this.badge = badge;
        this.imageSrc = imageSrc;
    }

    public MenuItem(String label, List<MenuItem> menuItems) {
        this.label = label;
        this.menuItems = menuItems;
    }

    public MenuItem(String label, List<MenuItem> menuItems, String badge) {
        this.label = label;
        this.menuItems = menuItems;
        this.badge = badge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) obj;
        return Objects.equals(label, other.label) && Objects.equals(url, other.url);
    }

    @Override
    public String toString() {
        return "MenuItem [label=" + label + ", url=" + url + "]";
    }
}