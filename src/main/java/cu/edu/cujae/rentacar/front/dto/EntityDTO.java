package cu.edu.cujae.rentacar.front.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class EntityDTO implements Serializable {
    private Integer id;
}
