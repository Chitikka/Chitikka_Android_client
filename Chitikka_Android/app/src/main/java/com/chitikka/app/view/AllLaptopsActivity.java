package com.chitikka.app.view;

import static com.chitikka.app.storage.LanguageUtils.loadLocale;
import static com.chitikka.app.utils.Constant.PRODUCT;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chitikka.app.R;
import com.chitikka.app.adapter.ProductAdapter;
import com.chitikka.app.databinding.ActivityAllLaptopsBinding;
import com.chitikka.app.model.Product;
import com.chitikka.app.storage.LoginUtils;
import com.chitikka.app.viewmodel.ProductViewModel;

public class AllLaptopsActivity extends AppCompatActivity implements ProductAdapter.ProductAdapterOnClickHandler {

    private ActivityAllLaptopsBinding binding;
    private ProductAdapter laptopAdapter;
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_laptops);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.all_laptops));

        int userID = LoginUtils.getInstance(this).getUserInfo().getId();

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.loadLaptops("laptop",userID);

        setupRecyclerViews();

        getAllLaptops();
    }

    private void setupRecyclerViews() {
        // Laptops
        binding.allLaptopsRecyclerView.setHasFixedSize(true);
        binding.allLaptopsRecyclerView.setLayoutManager(new GridLayoutManager(this, (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) ? 2 : 4));
        laptopAdapter = new ProductAdapter(this, this);
    }

    public void getAllLaptops() {
        productViewModel.laptopPagedList.observe(this, products -> laptopAdapter.submitList(products));
        binding.allLaptopsRecyclerView.setAdapter(laptopAdapter);
    }

    @Override
    public void onClick(Product product) {
        Intent intent = new Intent(AllLaptopsActivity.this, DetailsActivity.class);
        // Pass an object of product class
        intent.putExtra(PRODUCT, (product));
        startActivity(intent);
    }
}
