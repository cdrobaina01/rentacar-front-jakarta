package cu.edu.cujae.rentacar.front.mock;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

public class RoleMock {
    private static RoleMock instance;
    private final List<RoleDTO> roles;

    public static RoleMock getInstance() {
        if (instance == null) {
            instance = new RoleMock();
        }
        return instance;
    }

    private RoleMock() {
        roles = new ArrayList<>();
        RoleDTO dto = RoleDTO.builder().name("Administrator").description("Administrate").build();
        dto.setId(1);
        roles.add(dto);
        dto = RoleDTO.builder().name("User").description("Use").build();
        dto.setId(2);
        roles.add(dto);
    }

    public List<RoleDTO> getAll() {
        return roles;
    }

    public RoleDTO getById(Integer id) {
        RoleDTO role = null;
        for(RoleDTO dto : roles) {
            if (dto.getId().equals(id)) {
                role = dto;
                break;
            }
        }
        return role;
    }

    public boolean save(RoleDTO dto) {
        boolean result = true;
        for (RoleDTO user : roles) {
            if (user.getId().equals(dto.getId())) {
                result = false;
                break;
            }
        }
        if (result) {
            dto.setId(roles.size() + 1);
            roles.add(dto);
        }
        return result;
    }

    public boolean update(RoleDTO dto) {
        boolean result = false;
        for (RoleDTO role : roles) {
            if (role.getId().equals(dto.getId())) {
                result = true;
                role = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        RoleDTO deleted = null;
        for (RoleDTO role : roles) {
            if (role.getId().equals(id)) {
                result = true;
                deleted = role;
            }
        }
        roles.remove(deleted);
        return result;
    }
}
