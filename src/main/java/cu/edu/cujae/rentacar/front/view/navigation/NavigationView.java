package cu.edu.cujae.rentacar.front.view.navigation;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Named
@ApplicationScoped
@Getter
public class NavigationView {
    private List<MenuCategory> menuCategories;
    private List<MenuItem> menuItems;

    @PostConstruct
    public void init() {
        menuCategories = new ArrayList<>();
        menuItems = new ArrayList<>();

        List<MenuItem> administrationMenuItems = new ArrayList<>();
        administrationMenuItems.add(new MenuItem("Gestionar Usuarios", "/faces/security/manage/users.faces"));
        administrationMenuItems.add(new MenuItem("Gestionar Roles", "/faces/security/manage/roles.faces"));
        menuCategories.add(new MenuCategory("Administración", administrationMenuItems));

        List<MenuItem> nomenclaturesMenuItems = new ArrayList<>();
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Métodos de Pago", "/faces/manage/paymethod.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Países", "/faces/manage/country.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Géneros", "/faces/manage/gender.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Modelos", "/faces/manage/model.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Marcas", "/faces/manage/brand.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Situaciones", "/faces/manage/situation.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Categorías", "/faces/manage/category.faces"));
        nomenclaturesMenuItems.add(new MenuItem("Gestionar Tarífas", "/faces/manage/fee.faces"));
        menuCategories.add(new MenuCategory("Nomencladores", nomenclaturesMenuItems));

        List<MenuItem> entitiesMenuItems = new ArrayList<>();
        entitiesMenuItems.add(new MenuItem("Gestionar Turistas","/faces/manage/tourist.faces"));
        entitiesMenuItems.add(new MenuItem("Gestionar Conductores","/faces/manage/driver.faces"));
        entitiesMenuItems.add(new MenuItem("Gestionar Vehículos","/faces/manage/car.faces"));
        entitiesMenuItems.add(new MenuItem("Gestionar Contratos","/faces/manage/contract.faces"));
        menuCategories.add(new MenuCategory("Entidades", entitiesMenuItems));

        for (MenuCategory category : menuCategories) {
            for (MenuItem menuItem : category.getMenuItems()) {
                menuItem.setParentLabel(category.getLabel());
                if (menuItem.getUrl() != null) {
                    menuItems.add(menuItem);
                }
                if (menuItem.getMenuItems() != null) {
                    for (MenuItem item : menuItem.getMenuItems()) {
                        item.setParentLabel(menuItem.getLabel());
                        if (item.getUrl() != null) {
                            menuItems.add(item);
                        }
                    }
                }
            }
        }
    }

    public List<MenuItem> completeMenuItem(String query) {
        String queryLowerCase = query.toLowerCase();
        List<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getUrl() != null && (item.getLabel().toLowerCase().contains(queryLowerCase)
                    || item.getParentLabel().toLowerCase().contains(queryLowerCase))) {
                filteredItems.add(item);
            }
            else if (item.getBadge() != null) {
                if (item.getBadge().toLowerCase().contains(queryLowerCase)) {
                    filteredItems.add(item);
                }
            }
        }
        filteredItems.sort(Comparator.comparing(MenuItem::getParentLabel));
        return filteredItems;
    }
}
