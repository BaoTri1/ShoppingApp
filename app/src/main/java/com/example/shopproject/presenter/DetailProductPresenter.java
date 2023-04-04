package com.example.shopproject.presenter;

import android.content.Context;

import com.example.shopproject.R;
import com.example.shopproject.mode.Photo;
import com.example.shopproject.mode.Product;
import com.example.shopproject.orther_handle.Publics;
import com.example.shopproject.presenter.callbackMode.CallbackProductMode;
import com.example.shopproject.repository.ProductInterator;
import com.example.shopproject.view.DetailProductView;

import java.util.ArrayList;
import java.util.List;

public class DetailProductPresenter implements CallbackProductMode {

    private Context mContext;
    private DetailProductView mDetailProductView;
    private ProductInterator mProductInterator;

    public DetailProductPresenter(Context mContext, DetailProductView mDetailProductView) {
        this.mContext = mContext;
        this.mDetailProductView = mDetailProductView;
        this.mProductInterator = new ProductInterator(mContext, this);
    }

    public void getProduct(String slug){
        if(slug == null)
            return;
        if(Publics.isNetWorkAvaliable(mContext)){
            mProductInterator.getProduct(slug);
        }else {
            mDetailProductView.DisplayNoNetWork("Đã xảy ra lỗi. Vui lòng kiểm tra lại kết nối mạng.");
        }
    }

    public void setImagesProduct(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.mipmap.addidas1));
        list.add(new Photo(R.mipmap.adirunner2));
        list.add(new Photo(R.mipmap.aohoodie1));
        list.add(new Photo(R.mipmap.q14));
        mDetailProductView.DisplayImagesProduct(list);
    }


    public void createListProduct(){
        if(Publics.isNetWorkAvaliable(mContext)){
            mProductInterator.getListProducts();
        }
        else {
            mDetailProductView.DisplayNoNetWork("Đã xảy ra lỗi. Vui lòng kiểm tra lại kết nối mạng.");
        }
    }



    @Override
    public void getProductSuccess(Product product) {
        mDetailProductView.DisplayInforProduct(product);
        mDetailProductView.DisplayReviews(product.getRating(), product.getNumReviews(), product.getReviews());
    }

    @Override
    public void getListProductSuccess(List<Product> mlist) {
        mDetailProductView.DisplayListProduct(mlist);
    }

    @Override
    public void getDataFailure(String message) {
        mDetailProductView.DisplayError(message);
    }
}