import com.renxf.common.pojo.Products;
import com.renxf.product.ProductApplication;
import com.renxf.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class test {
    @Autowired
    ProductService service;
    @Test
    public void test(){
        Products products = service.selectById(1);
        System.out.println("查询为============"+products);
    }
}
