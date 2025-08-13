package app.service;

import app.domain.Product;
import app.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    /*
    1. @Autowired над полем класса
    2. Внедрение через конструктор
    3. Внедрение через сеттер
     */

    private ProductRepository repository;

    //@Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product getById(Long id) {
        return repository.getById(id);
    }
}
