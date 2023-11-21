package cu.edu.cujae.rentacar.front.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FeeDTO extends EntityDTO{
    @Size(min = 2, max = 255)
    private String name;
    private double fee;
}
