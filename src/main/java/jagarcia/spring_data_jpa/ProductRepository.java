package jagarcia.spring_data_jpa;

import jagarcia.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
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

    /*
    Return the distinct product entry whose name is given as a method parameter
    if no product entry is found, this method returns null
    * */
    Product findDistinctByName(String name);

    /*
    Return the products whose price is greater than give price as method parameter
    @Param price
    @Return
    * */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /*
   Return the products whose price is LESS than give price as method parameter
   @Param price
   @Return
   * */
    List<Product> findByPriceLessThan(BigDecimal price);

    /*
    Return the filtered the product that match the given text
    @Param name
    @return
    * */
    List<Product> findByNameContaining(String name);

    /*
    return the products based on sql like condition
    * */
    List<Product> findByNameLike(String name);
}
