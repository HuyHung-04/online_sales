package com.example.shopapp.services;

import com.example.shopapp.dtos.ProductDTO;
import com.example.shopapp.dtos.ProductImageDTO;
import com.example.shopapp.exceptions.DataNotFoundException;
import com.example.shopapp.exceptions.InvalidParamException;
import com.example.shopapp.models.Category;
import com.example.shopapp.models.Product;
import com.example.shopapp.models.ProductImage;
import com.example.shopapp.repositoties.CategoryRepository;
import com.example.shopapp.repositoties.ProductImageRepository;
import com.example.shopapp.repositoties.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException {
      Category existingCategory = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException("Khong tim thay id category"));
        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .url(productDTO.getUrl())
                .categoty(existingCategory)
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Khong tim thay id product"));
    }

    @Override
    public Page<Product> getAllProduct(PageRequest pageRequest) {
        // lay danh sach san pham theo trang(page) va gioi han(limit)
        return productRepository.findAll(pageRequest);
    }

    @Override
    public Product updateProduct(long id,
                                 ProductDTO productDTO)
            throws Exception {
        Product existingProduct = getProductById(id);
        if (existingProduct != null){
            // copy cac thuoc tinh tu dto sang product
            // co th su dung ModelMapper
            Category existingCategory = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new DataNotFoundException(
                            "Khong tim thay id category"));
            existingProduct.setName(productDTO.getName());
            existingProduct.setCategoty(existingCategory);
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setUrl(productDTO.getUrl());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
      Optional<Product> optionalProduct = productRepository.findById(id);
      if (optionalProduct.isPresent()){
          productRepository.delete(optionalProduct.get());
      }
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception {
        Product existingProduct = productRepository
                .findById(productImageDTO.getProductId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Khong tim thay id category"));
        ProductImage newProductImage = ProductImage
                .builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        // khong cho them qua 5 anh 1 san pham
       int size = productImageRepository.findByProductId(productId).size();
       if (size >= 5){
           throw new InvalidParamException("So luong anh lon hon hoac bang 5");
       }
      return productImageRepository.save(newProductImage);
    }
}
