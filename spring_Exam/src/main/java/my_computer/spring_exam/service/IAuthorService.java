package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.request.CreateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateAuthorRequestDTO;
import my_computer.spring_exam.domain.dto.response.AuthorResponseDTO;
import my_computer.spring_exam.domain.entity.Author;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface IAuthorService {

    AuthorResponseDTO create(CreateAuthorRequestDTO createAuthorRequestDTO);

    AuthorResponseDTO update(UpdateAuthorRequestDTO dto,Integer integer);

    AuthorResponseDTO delete(Integer id);

    AuthorResponseDTO getById(Integer id);

    List<AuthorResponseDTO> getAll();

}
