package com.example.shopproject.presenter;

import android.content.Context;

import com.example.shopproject.mode.MessagResponse;
import com.example.shopproject.mode.Orders;
import com.example.shopproject.orther_handle.Publics;
import com.example.shopproject.presenter.callbackMode.CallbackProductMode;
import com.example.shopproject.repository.ProductInterator;
import com.example.shopproject.view.ListordersHistoryView;

import java.util.List;

public class ListordersHistoryPresenter implements CallbackProductMode {

    private Context mContext;
    private ListordersHistoryView listordersHistoryView;
    private ProductInterator productInterator;
    private List<Orders> mList;

    public ListordersHistoryPresenter(Context mContext, ListordersHistoryView listordersHistoryView) {
        this.mContext = mContext;
        this.listordersHistoryView = listordersHistoryView;
        this.productInterator = new ProductInterator(mContext, this);
    }

    public void getListOrderHistory(){
        if(Publics.isNetWorkAvaliable(mContext)){
            productInterator.getListOrdersHistory();
        }else {
            listordersHistoryView.DisplayError("Đã xảy ra lỗi. Vui lòng kiểm tra kết nối mạng!");
        }
    }

    public void deleteOrders(Orders orders){
        mList.remove(orders);
        listordersHistoryView.DislayListOrders(this.mList);
        productInterator.deleteOrders(orders.get_id());
    }

    @Override
    public void deleteOrdersSuccess(MessagResponse messagResponse) {
        listordersHistoryView.DislayMessageDeleteOrders(messagResponse.getMessage());
    }

    @Override
    public void getDataFailure(String message) {
        listordersHistoryView.DisplayError(message);
    }

    @Override
    public void getListOrdersHistorySuccess(List<Orders> mList) {
        this.mList = mList;
        listordersHistoryView.DislayListOrders(mList);
    }
}
