package cu.edu.cujae.rentacar.front.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class LoginRequestDTO {
    private String username;
    private String password;
}
