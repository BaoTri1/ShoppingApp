package com.example.shopproject.view;

import com.example.shopproject.mode.Orders;

import java.util.List;

public interface ListordersHistoryView {
    void DislayListOrders(List<Orders> mList);
    void DislayMessageDeleteOrders(String message);
    void DisplayError(String error);
}
