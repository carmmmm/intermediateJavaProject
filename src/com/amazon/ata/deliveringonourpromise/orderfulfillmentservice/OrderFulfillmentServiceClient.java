package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.deliverypromiseservice.OrderServiceClient;
import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.orderfulfillmentservice.OrderFulfillmentService;
import com.amazon.ata.orderfulfillmentservice.OrderPromise;


public class OrderFulfillmentServiceClient implements OrderServiceClient {

    private OrderFulfillmentService orderFulfillmentService;

    /**
     * another java doc.
     * @param orderFulfillmentService is taking this in.
     */
    public OrderFulfillmentServiceClient(OrderFulfillmentService orderFulfillmentService) {
        this.orderFulfillmentService = orderFulfillmentService;
    }

    @Override
    public Promise getDeliveryPromiseByOrderItemId(String customerOrderItemId) {
        //take customer orderITemId and make an order promise and return this promise//returns a promise you just made
        OrderPromise orderPromise = orderFulfillmentService.getOrderPromise(customerOrderItemId);

        if (null == orderPromise) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(orderPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(orderPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(orderPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(orderPromise.getPromiseEffectiveDate())
                .withIsActive(orderPromise.isActive())
                .withPromiseProvidedBy(orderPromise.getPromiseProvidedBy())
                .withAsin(orderPromise.getAsin())
                .build();
    }
}


