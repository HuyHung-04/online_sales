package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Ten khong de trong")
    @Size(min = 3, max = 200, message = "Ten phai tu 3 ky tu tro len")
    private String name;

    @Min(value = 0, message = "Gia phai lon hon hoac bang 0")
    @Max(value = 10000000, message = "Gia phai nho hon 10000000")
    private float price;

    private String url;

    private String description;

    @JsonProperty("category_id")
    private Long categoryId;

}
