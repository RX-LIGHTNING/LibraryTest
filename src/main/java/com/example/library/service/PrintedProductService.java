package com.example.library.service;

import com.example.library.entity.PrintedProduct;
import com.example.library.dto.PrintedProductDTO;
import com.example.library.repository.PrintedProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    //Метод для получения всей печатной продукции
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

    //Метод для поиска печатной продукции по идентификатору,  принимает в себя id и возвращает dto
    //объекта PrintedProduct
    public PrintedProductDTO getProductById(Long id) {
        //Поиск объекта по идентификатору и его маппинг в DTO
        return productRepo.findById(id).map(item -> {
                    PrintedProductDTO dto = new PrintedProductDTO();
                    dto.setId(item.getId());

                    //Подстановка списка авторов происходит при помощи метода сервиса authorService,
                    //данный метод возвращает сразу список объектов класса Author
                    dto.setAuthors(authorService.findAllByProduct(item));

                    //Подстановка списка авторов происходит при помощи метода сервиса PublisherService,
                    //данный метод возвращает сразу список объектов класса Publisher
                    dto.setPublishers(publisherService.findAllByProduct(item));

                    //В данном методе происходит подстановка в dto объекта класса ProductType
                    dto.setProductType(productTypeService.findByProduct(item));
                    dto.setName(item.getName());
                    dto.setPublishDate(item.getPublishDate());
                    return dto;
                }
        ).get();
    }

    //Метод предназначенный для обновления уже созданного объекта PrintedProduct, принимает в себя dto
    //В данном методе происходит парсинг dto в обычный объект и его последующее сохранение в БД.
    public PrintedProduct updateProduct(Long id, PrintedProductDTO product) {
        productRepo.findById(id)
                .map(item -> {
                    item.setAuthors(new HashSet<>());
                    item.setPublishers(new HashSet<>());
                    item.setName(product.getName());
                    item.setPublishDate(product.getPublishDate());

                    //В данном цикле происходит пошаговое сохранение всех авторов из списка содержащегося
                    //в dto, в методе сервиса происходит проверка на наличие идентичных записей в БД, чтобы
                    //не создавать дубликатов.
                    product.getAuthors().forEach(x -> {
                                item.addAuthor(authorService.save(x));
                            }
                    );

                    //В данном цикле происходит пошаговое сохранение всех издателей из списка содержащегося
                    //в dto, в методе сервиса происходит проверка на наличие идентичных записей в БД, чтобы
                    //не создавать дубликатов.
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

    //В данном методе происходит сохранение нового объекта класса PrintedProduct,
    //сам метод принимает в себя dto и преобразует его в обычный объект PrintedProduct и
    // сохраняет его в БД
    public void saveProduct(PrintedProductDTO productDTO) {
        PrintedProduct item = new PrintedProduct();
        item.setName(productDTO.getName());
        item.setPublishDate(productDTO.getPublishDate());

        //В данном цикле происходит пошаговое сохранение всех авторов из списка содержащегося
        //в dto, в методе сервиса происходит проверка на наличие идентичных записей в БД, чтобы
        //не создавать дубликатов.
        productDTO.getAuthors().forEach(x -> {
                    item.addAuthor(authorService.save(x));
                }
        );
        //В данном цикле происходит пошаговое сохранение всех издателей из списка содержащегося
        //в dto, в методе сервиса происходит проверка на наличие идентичных записей в БД, чтобы
        //не создавать дубликатов.
        productDTO.getPublishers().forEach(x -> {
                    item.addPublisher(publisherService.save(x));
                }
        );
        item.setType_id(productTypeService.save(productDTO.getProductType()).getId());
        productRepo.save(item);
    }

    //Метод предназначеный для удаления объектов из БД
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

}
