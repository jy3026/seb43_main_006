package com.codestates.julsinsa.order.dto;


import com.codestates.julsinsa.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


public class OrderDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response{

        private Long orderId;
        private String name;

        private Order.OrderStatus orderStatus;

        private int totalQuantity;

        private List<ItemOrderDto.Response> itemOrders;

        private LocalDate pickupDate;

        @JsonProperty(value="orderedAt")
        private LocalDate createdAt;

        // 아이템리스트에서 갯수들을 가져와서 더함
        public int getTotalQuantity() {
            int totalQuantity = 0;
            for (ItemOrderDto.Response itemOrder : itemOrders) {
                totalQuantity += itemOrder.getQuantity();
            }
            return totalQuantity;
        }
    }
}
