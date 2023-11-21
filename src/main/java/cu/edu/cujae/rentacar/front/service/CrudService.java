package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.utils.ApiResponse;

import java.util.List;

public interface CrudService<E> {
    List<E> getAll();
    E getById(Integer id);
    ApiResponse save(E dto);
    ApiResponse update(E dto);
    ApiResponse delete(Integer id);
    ApiResponse delete(List<Integer> id);
}
