package com.anynew.mine;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredHomeAdapter mStaggeredHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mRecyclerView = (RecyclerView)findViewById(R.id.id_recyclerview);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        mStaggeredHomeAdapter = new StaggeredHomeAdapter(this, mDatas);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mStaggeredHomeAdapter);
        // 设置item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        initEvent();

       /* HomeAdapter adapter = new HomeAdapter(this);

        mRecyclerView.setAdapter(adapter);

        adapter.notityData(mDatas);

        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());*/

    }

    private void initEvent() {
        mStaggeredHomeAdapter.setOnItemClickLitener(new StaggeredHomeAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(MainActivity.this,
                        position + " click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(MainActivity.this,
                        position + " long click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

}
