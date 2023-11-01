package cu.edu.cujae.rentacar.front.view;

import cu.edu.cujae.rentacar.front.security.view.AuthenticationManager;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
@Data
public class HomeView implements Serializable {
    private String title;
    @Inject
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init() {
        title = "Rentacar";
    }
}
