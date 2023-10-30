package cu.edu.cujae.rentacar.front.mock;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacar.front.security.dto.UserDTO;

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
        UserDTO dto = UserDTO.builder()
                .username("admin")
                .password("admin")
                .role(RoleMock.getInstance().getById(1))
                .build();
        dto.setId(1);
        users.add(dto);
        for (int i = 2; i < 4; i++) {
            dto = UserDTO.builder()
                    .username(Faker.instance().name().username())
                    .password("rentacar")
                    .role(RoleMock.getInstance().getById(2))
                    .build();
            dto.setId(i);
            users.add(dto);
        }
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
        dto.setPassword("rentacar");
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
