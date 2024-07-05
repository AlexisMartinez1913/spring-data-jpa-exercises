package jagarcia.spring_data_jpa;

import jagarcia.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Spring Data JPA Query Methods
    /*
    returns the found product entry by using its name as search criteria
    if no product entry is found, this method returns null
    * */
    public Product findByName(String name);

    /*
    returns an optional which contains the found product entry by using its Id as search criteria
    if no product entry is found, this method returns an empty Optional
    * */
    Optional<Product> findById(Long id);
    /*
    Returns the found list of product entries whose name or description is given
    as a method parameter. If no product entries is found, this method return an empty list
   * */
    List<Product> findByNameOrDescription(String name, String description);

    /*
   Returns the found list of product entries whose name AND description is given
   as a method parameter. If no product entries is found, this method return an empty list
  * */
    List<Product> findByNameAndDescription(String name, String description);
}
