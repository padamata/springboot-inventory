package com.apex.eqp.inventory.services;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.helpers.ProductFilter;
import com.apex.eqp.inventory.repositories.InventoryRepository;
import com.apex.eqp.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;



/*The Challenge:
        The application has two API for Products and for Recalled Products, the candidate must complete and
        fix the code so that the get AllProducts API always returns the products that are not in the recalled list.
        Note: The recalled products have Expired flag, if the recalled product is expired, must be excluded from the
         recalledList. This is added to make the Filtering a bit more challenging.
*/
@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private RecalledProductRepository recalledProductRepository;

    @Transactional
    public Product save(Product product) {
        return inventoryRepository.save(product);
    }

    public List<Product> getAllProduct() {

        List<Product> productList = new ArrayList<>();

        productList = inventoryRepository.findAll();

        List<RecalledProduct> recalledProductList = new ArrayList<>();

        recalledProductList = recalledProductRepository.findAll();


        Set<String> recalledProducts = new HashSet<>();


        for(RecalledProduct recalledProduct: recalledProductList){
            recalledProducts.add(recalledProduct.getName());
        }


       ProductFilter filter = new ProductFilter(recalledProducts);

        return filter.removeRecalledFrom(productList);
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}
