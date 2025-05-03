package my_computer.week6_crud.service;

import my_computer.week6_crud.domain.dto.request.CreatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.response.PositionDTO;

import java.util.List;

public interface IPositionService {
    PositionDTO createPosition(CreatePositionRequestDTO request);
    PositionDTO getPositionById(Long id);
    List<PositionDTO> getAllPositions();
    PositionDTO updatePosition(Long id, UpdatePositionRequestDTO request);
    void deletePosition(Long id);
}
