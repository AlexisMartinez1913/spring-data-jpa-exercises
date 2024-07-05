package jagarcia.spring_data_jpa.repository;

import jagarcia.spring_data_jpa.ProductRepository;
import jagarcia.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("image1.png");
        //save product
        Product savedObject = productRepository.save(product);
        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();


        //update entity information
        product.setName("Updated product 1");
        product.setDescription("product 1 description updated");


        //save entity
        productRepository.save(product);


    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

    }
    @Test
    void saveAllMethod() {
        //create product
        Product product = new Product();
        product.setName("Product 2");
        product.setDescription("product 2 description");
        product.setSku("101ABC");
        product.setPrice(new BigDecimal(400));
        product.setActive(true);
        product.setImageUrl("image2.png");

        Product product2 = new Product();
        product2.setName("Product 3");
        product2.setDescription("product 3 description");
        product2.setSku("102ABC");
        product2.setPrice(new BigDecimal(500));
        product2.setActive(true);
        product2.setImageUrl("image3.png");

        productRepository.saveAll(List.of(product, product2));

    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }
    @Test
    void deleteByIdMethod() {
        Long id = 2L;
        productRepository.deleteById(id);
    }
    @Test
    void deleteMethod() {
        //find an entity by id
        Long id = 3L;
        Product product = productRepository.findById(id).get();
        //delete entity
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod() {
        //productRepository.deleteAll();
        Product product = productRepository.findById(52L).get();
        Product product1 = productRepository.findById(53L).get();
        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 56L;

        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }



}