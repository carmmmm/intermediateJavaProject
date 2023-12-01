package com.amazon.ata.deliveringonourpromise.types;

import com.amazon.ata.ordermanipulationauthority.OrderCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private String orderId = "1";
    private String customerId = "2";
    private String marketplaceId = "3";
    private OrderCondition condition;
    private List<OrderItem> customerOrderItemList = new ArrayList<>();
    private String shipOption = "good";
    private ZonedDateTime orderDate;


    //happy case
    @Test
    void noExternallyModifiedVariable_noModifiedVariables_noException() {
        //WHEN
    }


    @Test
    void externallyModifiedVariables_modifiedVariables_throwsException() {
        //Given
        Order order;
        OrderItem orderItem = OrderItem.builder().withOrderId("1").withCustomerOrderItemId("56").build();
        List<OrderItem> initialOrderItemsList= new ArrayList<>();
        initialOrderItemsList.add(orderItem);
        order = Order.builder().withOrderId("1").withShipOption("1").withCustomerOrderItemList(initialOrderItemsList).build();
//        order.orderId = "23";
        List<OrderItem> orderOriginalItemList = order.getCustomerOrderItemList();
        orderOriginalItemList.add(OrderItem.builder().withCustomerOrderItemId("23").build());
        List<OrderItem> finalResult = order.getCustomerOrderItemList();
        Assertions.assertEquals(1,finalResult.size());
//        OrderItem customerOrderItem = OrderItem.builder()
//                .withCustomerOrderItemId("1")
//                .build();
        //When
        // then return exception

    }

}
