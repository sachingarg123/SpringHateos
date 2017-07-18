package com.sample.springhateos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.springhateos.model.Customer;
import com.sample.springhateos.model.Order;

@Service
public class OrderService {

	private HashMap<String, Customer> customerMap;
	private HashMap<String, Order> customerOneOrderMap;
	private HashMap<String, Order> customerTwoOrderMap;
	private HashMap<String, Order> customerThreeOrderMap;

	public OrderService() {

		customerMap = new HashMap<String, Customer>();
		customerOneOrderMap = new HashMap<String, Order>();
		customerTwoOrderMap = new HashMap<String, Order>();
		customerThreeOrderMap = new HashMap<String, Order>();

		customerOneOrderMap.put("001A", new Order("001A", 150.00, 25));
		customerOneOrderMap.put("002A", new Order("002A", 250.00, 15));

		customerTwoOrderMap.put("002B", new Order("002B", 550.00, 325));
		customerTwoOrderMap.put("002B", new Order("002B", 450.00, 525));

		final Customer customerOne = new Customer("10A", "Jane", "ABC Company");
		final Customer customerTwo = new Customer("20B", "Bob", "XYZ Company");
		final Customer customerThree = new Customer("30C", "Tim", "CKV Company");

		customerOne.setOrders(customerOneOrderMap);
		customerTwo.setOrders(customerTwoOrderMap);
		customerThree.setOrders(customerThreeOrderMap);
		customerMap.put("10A", customerOne);
		customerMap.put("20B", customerTwo);
		customerMap.put("30C", customerThree);

	}

	public List<Order> getAllOrdersForCustomer(final String customerId) {
		return new ArrayList<Order>(customerMap.get(customerId).getOrders().values());
	}

	public Order getOrderByIdForCustomer(final String customerId, final String orderId) {

		final List<Order> orders = (List<Order>) customerMap.get(customerId).getOrders().values();
		Order selectedOrder = null;
		for (final Order order : orders) {
			if (order.getId().equals(orderId)) {
				selectedOrder = order;
			}
		}
		return selectedOrder;

	}

}
