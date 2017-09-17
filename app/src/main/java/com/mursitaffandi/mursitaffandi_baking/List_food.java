package com.mursitaffandi.mursitaffandi_baking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mursitaffandi.mursitaffandi_baking.adapter.Recyclerfood_adapter;
import com.mursitaffandi.mursitaffandi_baking.event.RecyclerClick_food;
import com.mursitaffandi.mursitaffandi_baking.model.Baking;
import com.mursitaffandi.mursitaffandi_baking.model.MultiBaking;
import com.mursitaffandi.mursitaffandi_baking.utilities.ConstantString;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class List_food extends AppCompatActivity implements RecyclerClick_food{
    private Recyclerfood_adapter mFoodAdapter;

    @BindView(R.id.rc_listfood)
    RecyclerView mRc_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        ButterKnife.bind(this);
        MultiBaking list_baking = getIntent().getParcelableExtra("list_baking");
        mFoodAdapter = new Recyclerfood_adapter(list_baking,this);
        RecyclerView.LayoutManager recipeLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        mRc_food.setLayoutManager(recipeLayoutManager);
        mRc_food.setAdapter(mFoodAdapter);
    }

    @Override
    public void onFoodSelected(Baking food) {
        Intent gotoDetail = new Intent(this, DetailFoodActivity.class);
        gotoDetail.putExtra(ConstantString.TAG_FOOD, food);
        startActivity(gotoDetail);
    }
}
