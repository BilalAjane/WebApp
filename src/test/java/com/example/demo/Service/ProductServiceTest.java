package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    /* // Hvis Mockito ikke bliver brugt.
    @Autowired
    ProductService productService;


    @BeforeAll
    public static void initialize(){
        //rutine der køres en gang før alle test
    }

    @BeforeEach
    void setUp() {
        //Arrange
        //lav rutine, der reinitialiserer databasen
    }
     */


    private static final long Product_id1 = 1;
    private static final long Product_id2 = 2;
    private static final long Product_id3 = 3;
    private static final long Product_id4 = 4;

    private static final List<Product> productList = new ArrayList<>();
    @InjectMocks
            // Initialisere Service til at teste med Mocks
    ProductService productService;

    @Mock
            // Mocked repository som returnere testdata
    ProductRepository mockedProductRepository;

    @BeforeEach
    void setUp() {
        //Instantiere mock repo
        MockitoAnnotations.openMocks(this);

        //arrangere
        //Definere dummydata - Product_id er defineret som konstant 3
        Product product1 = new Product(Product_id1,"Gaming bord",1500.0);
        Product product2 = new Product(Product_id2,"Gaming stol",3000.0);
        Product product3 = new Product(Product_id3,"Gaming mus",800.0);
        Product product4 = new Product(Product_id4,"Gaming skærm",2000.0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        //Definere hvad der bliver returneret når mock repo bliver kaldt
        Mockito.when(mockedProductRepository.findProductById(Product_id1)).thenReturn(product1);
        Mockito.when(mockedProductRepository.findProductById(Product_id2)).thenReturn(product2);
        Mockito.when(mockedProductRepository.findProductById(Product_id3)).thenReturn(product1);
        Mockito.when(mockedProductRepository.findProductById(Product_id4)).thenReturn(product2);

        Mockito.when(mockedProductRepository.getAllProducts()).thenReturn(productList);

    }

    @Test
    void getAll() {
        //Act
        long antal = productService.getAll().size();

        //Assert
        //Mock listen har 4 produkter - tester service med mock injection
        assertEquals(antal, 4);

        // Test at getAllProducts bliver kaldt præcis en gang når service bliver kaldt.
        Mockito.verify(mockedProductRepository, Mockito.times(1)).getAllProducts();
    }

    /*
    // TEST UDEN MOCKITO
    @Test
    void findProductById() {
        //Act
        Product product;
        //læs fra service og sæt et id med
        product = productService.findProductById(3);
        long id = product.getIdproduct();

        //Assert
        //db finder id nummer 3 på produkter, så der skal returneres nr 3
        assertEquals(id,3);
    }
     */

    @Test
    void findProductById() {
        //Act
        long id = productService.findProductById(Product_id1).getIdproduct();

        //Assert
        //Assertion på id - tester service med mock inject
        assertEquals(1,id);

        // Test at findProductById bliver kaldt præcis en gang når service bliver kaldt.
        Mockito.verify(mockedProductRepository, Mockito.times(1)).findProductById(Product_id1);
    }

    @Test
    void create() {
    }

    @Test
    void updateProduct() {
        //Act
        Product product1 = productList.get(1);
        product1.setProductPrice(2000.0);


        //Assert
        //Mock listen har nu 3 produkter - tester service med mock injection
        assertEquals(product1, 1500.0);
    }

    @Test
    void deleteProduct() {
        //Act
        productList.remove(0);
        long antal = productList.size();

        //Assert
        //Mock listen har nu 3 produkter - tester service med mock injection
        assertEquals(antal, 4);
    }
}