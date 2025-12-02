
package com.giray.laboratory7;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class productservice {

    private final Map<Long, product> products = new HashMap<>();
    private Long idCounter = 1L;

    public List<product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public product getProductById(Long id) {
        return products.get(id);
    }

    public product createProduct(product product) {
        product.setId(idCounter++);
        products.put(product.getId(), product);
        return product;
    }

    public product updateProduct(Long id, product updated) {
        product existing = products.get(id);

        if (existing == null) {
            return null;
        }

        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        return existing;
    }

    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}
