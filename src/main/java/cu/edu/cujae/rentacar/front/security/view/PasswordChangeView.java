package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.AuthenticatedUserDTO;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.security.service.AuthenticationService;
import cu.edu.cujae.rentacar.front.security.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Named
@RequestScoped
@Data
public class PasswordChangeView {
    private AuthenticatedUserDTO user;
    private String changedPassword;

    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        user = authenticationManager.getCurrentUser();
    }
}
