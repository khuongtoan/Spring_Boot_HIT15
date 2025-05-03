package my_computer.week6_crud.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.response.PositionDTO;
import my_computer.week6_crud.domain.entity.Position;
import my_computer.week6_crud.domain.mapper.PositionMapper;
import my_computer.week6_crud.repository.PositionRepository;
import my_computer.week6_crud.service.IPositionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements IPositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Override
    public PositionDTO create(CreatePositionRequestDTO dto) {
        Position position = positionMapper.toEntity(dto);
        return positionMapper.toDTO(positionRepository.save(position));
    }

    @Override
    public PositionDTO update(Long id, UpdatePositionRequestDTO dto) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found"));
        position.setTitle(dto.getTitle());
        position.setDescription(dto.getDescription());
        return positionMapper.toDTO(positionRepository.save(position));
    }

    @Override
    public void delete(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public PositionDTO getById(Long id) {
        return positionMapper.toDTO(positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found")));
    }

    @Override
    public List<PositionDTO> getAll() {
        return positionRepository.findAll().stream()
                .map(positionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
