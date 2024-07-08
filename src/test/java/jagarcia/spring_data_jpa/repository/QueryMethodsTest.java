package jagarcia.spring_data_jpa.repository;

import jagarcia.spring_data_jpa.ProductRepository;
import jagarcia.spring_data_jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(55L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product 2", "product 2 description");
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }));
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("Product 3", "product 3 description");
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }));
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(200));
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }));
    }
    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(400));
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
        }));
    }
    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product 2");
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        }));
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product 3");
        products.forEach((product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        }));
    }
    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100), new BigDecimal(300)
        );
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        }));
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        //start date
        LocalDateTime startDate = LocalDateTime.of(2024, 7, 8, 11,25, 11,87);

        //end date
        LocalDateTime endDate = LocalDateTime.of(2024, 7, 8, 11,25, 20);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getLastUpdated());
        });
    }
    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 2", "product 3"));
        products.forEach((product -> {
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        }));
    }
}
