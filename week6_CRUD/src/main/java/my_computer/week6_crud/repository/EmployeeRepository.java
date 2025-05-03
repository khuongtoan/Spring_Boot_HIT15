package my_computer.week6_crud.repository;

import my_computer.week6_crud.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Tìm kiếm nhân viên theo fullName (dùng từ khóa bất kỳ)
    List<Employee> findByFullNameContainingIgnoreCase(String fullName);

    // Tìm kiếm nhân viên theo departmentId
    List<Employee> findByDepartmentId(Long departmentId);

    // Tìm kiếm nhân viên theo positionId
    List<Employee> findByPositionId(Long positionId);

    // Tìm kiếm nhân viên theo nhiều tiêu chí (fullName, departmentId, positionId)
    @Query("SELECT e FROM Employee e " +
            "WHERE (:fullName IS NULL OR LOWER(e.fullName) LIKE LOWER(CONCAT('%', :fullName, '%'))) " +
            "AND (:departmentId IS NULL OR e.department.id = :departmentId) " +
            "AND (:positionId IS NULL OR e.position.id = :positionId)")
    List<Employee> searchEmployees(@Param("fullName") String fullName,
                                   @Param("departmentId") Long departmentId,
                                   @Param("positionId") Long positionId);
}
