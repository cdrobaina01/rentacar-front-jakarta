package cu.edu.cujae.rentacar.front.service;

import cu.edu.cujae.rentacar.front.dto.PayMethodDTO;
import cu.edu.cujae.rentacar.front.mock.PayMethodMock;
import cu.edu.cujae.rentacar.front.utils.ApiResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

@Named
@RequestScoped
public class PayMethodServiceImpl implements PayMethodService{
    @Override
    public List<PayMethodDTO> getAll() {
        return PayMethodMock.getInstance().getAll();
    }

    @Override
    public PayMethodDTO getById(Integer id) {
        return PayMethodMock.getInstance().getById(id);
    }

    @Override
    public ApiResponse save(PayMethodDTO dto) {
        return new ApiResponse(PayMethodMock.getInstance().save(dto), "Saved");
    }

    @Override
    public ApiResponse update(PayMethodDTO dto) {
        return new ApiResponse(PayMethodMock.getInstance().update(dto), "Update");
    }

    @Override
    public ApiResponse delete(Integer id) {
        return new ApiResponse(PayMethodMock.getInstance().delete(id), "Delete");
    }

    @Override
    public ApiResponse delete(List<Integer> ids) {
        PayMethodMock.getInstance().delete(ids);
        return new ApiResponse(true, "Delete");
    }
}
