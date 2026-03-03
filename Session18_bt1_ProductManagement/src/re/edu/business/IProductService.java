package re.edu.business;

import re.edu.model.Product;
import java.util.List;
import java.util.Map;

public interface IProductService extends IBaseService<Product, Integer> {

    List<Product> searchByName(String name);

    Map<String, Integer> countByCatalog();

    boolean checkCatalogExists(String catalog);
}