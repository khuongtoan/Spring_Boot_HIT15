package my_computer.spring_exam.respository;

import my_computer.spring_exam.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("SELECT COUNT(b) FROM Book b WHERE b.author.id = :authorId")
    Long countByAuthorId(@Param("authorId") Long authorId);

    @Query("SELECT COUNT(b) FROM Book b WHERE b.category.id = :categoryId")
    Long countByCategoryId(@Param("categoryId") Long categoryId);

    boolean existsByName(String name);

    @Query("""
    SELECT b FROM Book b
    WHERE (:name IS NULL OR b.name LIKE CONCAT('%', :name, '%'))
      AND (:price IS NULL OR b.price = :price)
      AND (:authorName IS NULL OR b.author.name LIKE CONCAT('%', :authorName, '%'))
      AND (:categoryName IS NULL OR b.category.name LIKE CONCAT('%', :categoryName, '%'))
""")
    List<Book> filterBooks(
            @Param("name") String name,
            @Param("price") Double price,
            @Param("authorName") String authorName,
            @Param("categoryName") String categoryName
    );

}
