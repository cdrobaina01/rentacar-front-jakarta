package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import cu.edu.cujae.rentacar.front.utils.NavigationUtils;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class LoginView {
    private String username;
    private String password;
    @Inject
    private AuthenticationManager authenticationManager;

    public void login() {
        boolean response = authenticationManager.login(username, password);
        if (response) {
            if (authenticationManager.getActualPage() == null) {
                NavigationUtils.redirectTo();
            } else {
                NavigationUtils.rawRedirect(authenticationManager.getActualPage());
            }
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "invalid_credentials");
        }
    }
}
