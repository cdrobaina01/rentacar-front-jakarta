package cu.edu.cujae.rentacar.front.mock;

import cu.edu.cujae.rentacar.front.dto.RoleDTO;
import cu.edu.cujae.rentacar.front.dto.UserDTO;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserMock {
    public static UserMock instance;
    private final List<UserDTO> users;

    public static UserMock getInstance() {
        if (instance == null) {
            instance = new UserMock();
        }
        return instance;
    }

    private UserMock() {
        users = new LinkedList<>();
        users.add(new UserDTO(1, "admin", "asd", RoleMock.getInstance().getById(1)));
        users.add(new UserDTO(2, "user1", "123", RoleMock.getInstance().getById(2)));
        users.add(new UserDTO(3, "user2", "123", RoleMock.getInstance().getById(2)));
    }

    public List<UserDTO> getAll() {
        return users;
    }

    public UserDTO getById(Integer id) {
        UserDTO user = null;
        for(UserDTO dto : users) {
            if (dto.getId().equals(id)) {
                user = dto;
                break;
            }
        }
        return user;
    }

    public boolean save(UserDTO dto) {
        boolean result = true;
        for (UserDTO user : users) {
            if (user.getId().equals(dto.getId())) {
                result = false;
                break;
            }
        }
        if (result) {
            dto.setId(users.size() + 1);
            users.add(dto);
        }
        return result;
    }

    public boolean update(UserDTO dto) {
        boolean result = false;
        for (UserDTO user : users) {
            if (user.getId().equals(dto.getId())) {
                result = true;
                user = dto;
            }
        }
        return result;
    }

    public boolean delete(Integer id) {
        boolean result = false;
        UserDTO deleted = null;
        for (UserDTO user : users) {
            if (user.getId().equals(id)) {
                result = true;
                deleted = user;
            }
        }
        users.remove(deleted);
        return result;
    }
}
