package app.service;

import app.domain.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:application.properties")
@Service
public class ProductServiceImpl implements ProductService {

    /*
    1. @Autowired над полем класса
    2. Внедрение через конструктор
    3. Внедрение через сеттер
     */

    private ProductRepository repository;
    private String articlePrefix;

    //@Autowired
    public ProductServiceImpl(ProductRepository repository, @Value("${article.prefix}") String articlePrefix) {
        this.repository = repository;
        this.articlePrefix = articlePrefix;
    }

    @Override
    public Product getById(Long id) {
        Product product = repository.getById(id);
        if (product != null) {
            setArticle(product);
        }
        return product;
    }


    private void setArticle(Product product) {
        // Banana: id=2 -> Art-B-2
        String article = String.format("%s-%s-%d", articlePrefix, product.getTitle().charAt(0), product.getId());
        product.setArticle(article);
    }
}
