package cu.edu.cujae.rentacar.front.security.dto;

import cu.edu.cujae.rentacar.front.dto.EntityDTO;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO extends EntityDTO {
    private String username;
    private String password;
    private RoleDTO role;
}
