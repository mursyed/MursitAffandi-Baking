package com.mursitaffandi.mursitaffandi_baking.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mursitaffandi.mursitaffandi_baking.R;
import com.mursitaffandi.mursitaffandi_baking.adapter.Recyclerfood_adapter;
import com.mursitaffandi.mursitaffandi_baking.event.RecyclerClick_food;
import com.mursitaffandi.mursitaffandi_baking.model.Baking;
import com.mursitaffandi.mursitaffandi_baking.model.MultiBaking;
import com.mursitaffandi.mursitaffandi_baking.utilities.ConstantString;

import butterknife.BindView;
import butterknife.ButterKnife;

public class List_food extends AppCompatActivity implements RecyclerClick_food{
    private Recyclerfood_adapter mFoodAdapter;

    @BindView(R.id.rc_listfood)
    RecyclerView mRc_food;

    MultiBaking list_baking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        ButterKnife.bind(this);
        RecyclerView.LayoutManager recipeLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        mRc_food.setLayoutManager(recipeLayoutManager);
        if(savedInstanceState != null){
            list_baking = savedInstanceState.getParcelable("baking");
        }else {
            list_baking = getIntent().getParcelableExtra("list_baking");
        }
        mFoodAdapter = new Recyclerfood_adapter(list_baking,this);
        mRc_food.setAdapter(mFoodAdapter);
    }

    @Override
    public void onFoodSelected(Baking food) {
        Intent gotoDetail = new Intent(this, DetailFoodActivity.class);
        gotoDetail.putExtra(ConstantString.TAG_DETAIL_FOOT, food);
        startActivity(gotoDetail);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("baking", list_baking);
    }
}
