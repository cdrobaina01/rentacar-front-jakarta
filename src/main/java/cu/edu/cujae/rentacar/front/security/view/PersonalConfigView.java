package cu.edu.cujae.rentacar.front.security.view;

import cu.edu.cujae.rentacar.front.security.dto.AuthenticatedUserDTO;
import cu.edu.cujae.rentacar.front.security.service.UserService;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import cu.edu.cujae.rentacar.front.utils.JsfUtils;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.primefaces.PrimeFaces;

import java.io.Serializable;

@Named
@ViewScoped
@Data
public class PersonalConfigView implements Serializable {
    private AuthenticatedUserDTO user;
    @Size(min = 4, max = 255)
    private String changedPassword;

    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private UserService userService;

    @PostConstruct
    public void init() {
        user = authenticationManager.getCurrentUser();
    }

    public void changePassword() {
        ApiResponse response = userService.changePassword(user.getId(), changedPassword);
        if (response.isSuccess()) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "password_changed");
            PrimeFaces.current().ajax().update("form:messages", "form:entities");
        } else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "password_no_changed");
        }
        PrimeFaces.current().executeScript("PF('manageEntityDialog').hide()");
    }
}
