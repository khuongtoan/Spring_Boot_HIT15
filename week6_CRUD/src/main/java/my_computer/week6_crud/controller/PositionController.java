package my_computer.week6_crud.controller;

import lombok.RequiredArgsConstructor;
import my_computer.week6_crud.domain.dto.request.CreatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.request.UpdatePositionRequestDTO;
import my_computer.week6_crud.domain.dto.response.ApiResponse;
import my_computer.week6_crud.domain.dto.response.PositionDTO;
import my_computer.week6_crud.service.IPositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
@Validated
public class PositionController {

    private final IPositionService positionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PositionDTO>> create(@RequestBody CreatePositionRequestDTO request) {
        PositionDTO created = positionService.create(request);
        return ResponseEntity.created(URI.create("/api/positions/" + created.getId()))
                .body(new ApiResponse<>(201, "Position created", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PositionDTO>> update(@PathVariable Long id, @RequestBody UpdatePositionRequestDTO request) {
        PositionDTO updated = positionService.update(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Position updated", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        positionService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Position deleted", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PositionDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Position fetched", positionService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PositionDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Positions fetched", positionService.getAll()));
    }
}
