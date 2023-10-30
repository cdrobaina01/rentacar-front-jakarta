package cu.edu.cujae.rentacar.front.security.service;

import cu.edu.cujae.rentacar.front.security.dto.UserDTO;
import cu.edu.cujae.rentacar.front.mock.UserMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class UserServiceImpl implements UserService{
    @Override
    public List<UserDTO> getAll() {
        return UserMock.getInstance().getAll();
    }

    @Override
    public UserDTO getById(Integer id) {
        return UserMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(UserDTO dto) {
        return new ApiResponse(UserMock.getInstance().save(dto), "Save");
    }

    @Override
    public ApiResponse update(UserDTO dto) {
        return new ApiResponse(UserMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(UserMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> id) {
        return null;
    }
}
