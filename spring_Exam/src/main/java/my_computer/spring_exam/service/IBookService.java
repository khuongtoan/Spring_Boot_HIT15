package my_computer.spring_exam.service;

import my_computer.spring_exam.domain.dto.request.CreateBookRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateBookRequestDTO;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;

public interface IBookService {

    BookResponseDTO create (CreateBookRequestDTO dto);

    BookResponseDTO update (UpdateBookRequestDTO dto, Integer id);

    BookResponseDTO GetById(Integer id);

    BookResponseDTO delete(Integer id);

}
