package cu.edu.cujae.rentacar.front.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import java.io.IOException;

public class NavigationUtils {
    public static String localContext = "/faces";
    public static String globalContext = "/rentacar-front";
    public static String extension = ".faces";
    public static void redirectTo(String target) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(globalContext + localContext + target + extension);
        } catch (IOException e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "navigation_error");
        }
    }
    public static void redirectTo() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(globalContext + "/");
        } catch (IOException e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "navigation_error");
        }
    }
    public static void rawRedirect(String target) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(target);
        } catch (IOException e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_WARN, "navigation_error");
        }
    }
    public static String outcome(String target) {
        return localContext + target + extension;
    }
}
