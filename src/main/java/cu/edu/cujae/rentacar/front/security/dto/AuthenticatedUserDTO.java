package cu.edu.cujae.rentacar.front.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthenticatedUserDTO {
    private String username;
    private String password;
    private RoleDTO role;
    private String token;
}
