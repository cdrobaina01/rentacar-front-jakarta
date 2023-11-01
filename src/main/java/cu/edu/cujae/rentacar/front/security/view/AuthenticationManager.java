package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.AuthenticatedUserDTO;
import cu.edu.cujae.rentacar.front.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacar.front.security.service.AuthenticationService;
import cu.edu.cujae.rentacar.front.utils.NavigationUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@SessionScoped
public class AuthenticationManager implements Serializable {
    @Getter
    private AuthenticatedUserDTO currentUser;
    @Getter @Setter
    private String actualPage;
    @Inject
    private AuthenticationService authenticationService;

    public boolean login(String username, String password) {
        currentUser = authenticationService.login(LoginRequestDTO.builder().username(username).password(password).build());
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
        NavigationUtils.redirectTo("/security/login");
    }

    public boolean isUserLogged() {
        return currentUser != null;
    }
}
