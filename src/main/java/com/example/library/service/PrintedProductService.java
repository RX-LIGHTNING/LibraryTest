package com.example.library.service;

import com.example.library.entity.PrintedProduct;
import com.example.library.entity.dto.PrintedProductDTO;
import com.example.library.entity.ref.AuthorRef;
import com.example.library.entity.ref.PublisherRef;
import com.example.library.repository.AuthorRepo;
import com.example.library.repository.PrintedProductRepo;
import com.example.library.repository.ProductTypeRepo;
import com.example.library.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PrintedProductService {
    @Autowired
    PrintedProductRepo productRepo;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    ProductTypeService productTypeService;

    public List<PrintedProductDTO> getAllProducts() {
        List<PrintedProductDTO> productDTOS = new ArrayList<>();
        for (PrintedProduct item : productRepo.findAll()) {
            PrintedProductDTO dto = new PrintedProductDTO();
            dto.setId(item.getId());
            dto.setAuthors(authorService.findAllByProduct(item));
            dto.setPublishers(publisherService.findAllByProduct(item));
            dto.setProductType(productTypeService.findByProduct(item));
            dto.setName(item.getName());
            dto.setPublishDate(item.getPublishDate());
            productDTOS.add(dto);
        }
        return productDTOS;
    }

    public PrintedProductDTO getProductById(Long id) {
        return productRepo.findById(id).map(item -> {
                    PrintedProductDTO dto = new PrintedProductDTO();
                    dto.setId(item.getId());
                    dto.setAuthors(authorService.findAllByProduct(item));
                    dto.setPublishers(publisherService.findAllByProduct(item));
                    dto.setProductType(productTypeService.findByProduct(item));
                    dto.setName(item.getName());
                    dto.setPublishDate(item.getPublishDate());
                    return dto;
                }
        ).get();
    }

    public PrintedProduct updateProduct(Long id, PrintedProductDTO product) {
        productRepo.findById(id)
                .map(item -> {
                    item.setAuthors(new HashSet<>());
                    item.setPublishers(new HashSet<>());
                    item.setName(product.getName());
                    item.setPublishDate(product.getPublishDate());
                    product.getAuthors().forEach(x -> {
                                item.addAuthor(authorService.save(x));
                            }
                    );
                    product.getPublishers().forEach(x -> {
                                item.addPublisher(publisherService.save(x));
                            }
                    );
                    item.setType_id(productTypeService.save(product.getProductType()).getId());
                    return productRepo.save(item);
                }).orElseThrow(
                        //Здесь мог быть ваш эксепшен
                );
        return productRepo.findById(id).get();
    }

    public PrintedProduct saveProduct(PrintedProductDTO productDTO) {
        PrintedProduct item = new PrintedProduct();
        item.setName(productDTO.getName());
        item.setPublishDate(productDTO.getPublishDate());
        productDTO.getAuthors().forEach(x -> {
                    item.addAuthor(authorService.save(x));
                }
        );
        productDTO.getPublishers().forEach(x -> {
                    item.addPublisher(publisherService.save(x));
                }
        );
        item.setType_id(productTypeService.save(productDTO.getProductType()).getId());
        return productRepo.save(item);
    }

    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

}
