package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        roles.add(new RoleDTO(1, "Administrator", "Administrate"));
        roles.add(new RoleDTO(2, "User", "Use"));
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
