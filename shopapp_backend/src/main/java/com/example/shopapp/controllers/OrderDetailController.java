package com.example.shopapp.controllers;

import com.example.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    // them moi 1 order_datail
    @PostMapping("")
    public ResponseEntity<?> addOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO
            ){
        return ResponseEntity.ok("Them order_detail thanh cong");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(
            @Valid @PathVariable("id")  Long id
            ){
        return ResponseEntity.ok("Lay order_detail voi id " + id);
    }

    // lay ra danh sach cac orderdetail cua 1 order nao do
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(@Valid @PathVariable Long orderId){
        return ResponseEntity.ok("Lay order_detail tu order voi id " + orderId);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Valid @PathVariable("id") Long id,
            @RequestBody OrderDetailDTO newOrderDetailDTO
    ){
        return ResponseEntity.ok("Update order_detail voi id " + id +
                "du lieu order_detail moi " + newOrderDetailDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok("Xoa thanh cong order_detail");
    }
}
