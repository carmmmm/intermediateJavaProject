package com.amazon.ata.deliveringonourpromise.deliverypromiseservice;

import com.amazon.ata.deliveringonourpromise.types.Promise;


public interface OrderServiceClient {

    /**
     * this is the java doc comment.
     * @param customerOrderItemId the string cust ID to come in.
     * @return nothing.
     */
    Promise getDeliveryPromiseByOrderItemId(String customerOrderItemId);

}
