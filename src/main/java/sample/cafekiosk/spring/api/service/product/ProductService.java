package sample.cafekiosk.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.service.product.dto.request.ProductCreateRequest;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.util.List;
import java.util.stream.Collectors;

import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductCreateRequest request) {
        String latestProductNumber = productRepository.findLatestProductNumber();

        return ProductResponse.builder()
                .productNumber("002")
                .type(ProductType.HANDMADE)
                .sellingStatus(SELLING)
                .name("카푸치노")
                .price(5000)
                .build();
    }

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());
        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
