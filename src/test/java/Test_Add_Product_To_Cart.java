import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class Test_Add_Product_To_Cart extends BaseTest {
    HomePage homePage ;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;

    @Test
    @Order(1)

    public void search_a_product(){
        homePage = new HomePage(driver);

        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Pantolon");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Ürünler sayfasında yok!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(2);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Ürün detay sayfasında yok!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Ürün sayısı artmadı !");
    }

    @Test
    @Order(4)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Ürün sepete eklenmedi!");
    }
}

