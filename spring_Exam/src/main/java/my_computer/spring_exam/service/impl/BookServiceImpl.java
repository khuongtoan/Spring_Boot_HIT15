package my_computer.spring_exam.service.impl;

import lombok.RequiredArgsConstructor;
import my_computer.spring_exam.domain.dto.request.CreateBookRequestDTO;
import my_computer.spring_exam.domain.dto.request.UpdateBookRequestDTO;
import my_computer.spring_exam.domain.dto.response.BookResponseDTO;
import my_computer.spring_exam.service.IBookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    @Override
    public BookResponseDTO create(CreateBookRequestDTO dto) {
        return null;
    }

    @Override
    public BookResponseDTO update(UpdateBookRequestDTO dto, Integer id) {
        return null;
    }

    @Override
    public BookResponseDTO GetById(Integer id) {
        return null;
    }

    @Override
    public BookResponseDTO delete(Integer id) {
        return null;
    }
}
