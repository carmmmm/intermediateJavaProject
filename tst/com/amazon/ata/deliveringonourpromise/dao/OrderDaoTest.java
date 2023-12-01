package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.activity.GetPromiseHistoryByOrderIdActivity;
import com.amazon.ata.deliveringonourpromise.types.Order;
import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.deliveringonourpromise.types.PromiseHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderDaoTest {

    private OrderDao dao;
    private GetPromiseHistoryByOrderIdActivity activity;
    private ReadOnlyDao<String, Order> orderDao;
    private ReadOnlyDao<String, List<Promise>> promiseDao;

    @BeforeEach
    private void createActivity() {
        orderDao = App.getOrderDao();
        promiseDao = App.getPromiseDao();
        activity = new GetPromiseHistoryByOrderIdActivity(orderDao, promiseDao);
    }

    @Test
    public void get_forKnownOrderId_returnsOrder() {
        //given
        String orderId = "900-3746402-0000002";
        //when && //then
        assertNotNull(orderDao.get(orderId));
    }

    @Test
    public void get_forUnknownOrderId_returnsNull() {
        //given
        String orderId = "111-749023-7630574";
        //when && //then
        assertNull(orderDao.get(orderId));
    }

    @Test
    public void get_forNullID_returnsNull() {
        //given
        String orderId = null;
        //when && //then
        assertNull(orderDao.get(orderId));
    }

    @Test
    public void get_withIncorrectOrderIdFormat_returnsNullOmaOrder() {
        //given
        String orderId = "6";
        //when
        //take
        assertNull(orderDao.get(orderId));
    }

}
