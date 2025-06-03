package com.example.order_service.service;

import com.example.order_service.model.dto.OrderLineItemsDto;
import com.example.order_service.model.entity.Order;
import com.example.order_service.model.entity.OrderLineItems;
import com.example.order_service.repository.OrderDao;
import com.example.order_service.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderDao orderDao;

    public void placeOreder(OrderRequest request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems= request.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItems(orderLineItems);
        orderDao.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemDto.getPrice());
        orderLineItems.setQuantity(orderLineItemDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItems;
    }
}
