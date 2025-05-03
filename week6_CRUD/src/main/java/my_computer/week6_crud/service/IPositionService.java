package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.response.PositionDTO;

import java.util.List;

public interface IPositionService {
    PositionDTO create(CreatePositionRequestDTO request);
    PositionDTO getById(Long id);
    List<PositionDTO> getAll();
    PositionDTO update(Long id, UpdatePositionRequestDTO request);
    void delete(Long id);
}
