package cu.edu.cujae.rentacar.front.view.navigation;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class MenuCategory {
    private final String label;
    private List<MenuItem> menuItems;
    private boolean custom;

    public MenuCategory(String label, List<MenuItem> menuItems) {
        this.label = label;
        this.menuItems = menuItems;
    }

    public MenuCategory(String label, List<MenuItem> menuItems, boolean custom) {
        this.label = label;
        this.menuItems = menuItems;
        this.custom = custom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuCategory)) {
            return false;
        }
        MenuCategory other = (MenuCategory) obj;
        return Objects.equals(label, other.label);
    }

    @Override
    public String toString() {
        return "MenuCategory [label=" + label + "]";
    }
}
