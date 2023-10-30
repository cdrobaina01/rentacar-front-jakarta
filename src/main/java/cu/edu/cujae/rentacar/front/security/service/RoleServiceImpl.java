package cu.edu.cujae.rentacar.front.security.service;

import cu.edu.cujae.rentacar.front.security.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.mock.RoleMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class RoleServiceImpl implements RoleService {
    @Override
    public List<RoleDTO> getAll() {
        return RoleMock.getInstance().getAll();
    }

    @Override
    public RoleDTO getById(Integer id) {
        return RoleMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(RoleDTO dto) {
        return new ApiResponse(RoleMock.getInstance().save(dto), "Save");
    }

    @Override
    public ApiResponse update(RoleDTO dto) {
        return new ApiResponse(RoleMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(RoleMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> id) {
        return null;
    }
}
