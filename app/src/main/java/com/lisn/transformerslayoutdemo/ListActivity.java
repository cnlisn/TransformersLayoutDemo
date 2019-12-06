package com.lisn.transformerslayoutdemo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.lisn.transformerslayout.TransformersLayout;
import com.lisn.transformerslayout.TransformersOptions;
import com.lisn.transformerslayout.holder.Holder;
import com.lisn.transformerslayout.holder.TransformersHolderCreator;
import com.lisn.transformerslayout.listener.OnTransformersItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: LiShan
 * Time: 2019-12-06
 * Description:
 */
public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region HeaderView
        final List<Nav> navList = DataFactory.loadData();
        final TransformersLayout<Nav> header = new TransformersLayout<>(this);
        TransformersOptions options = new TransformersOptions.Builder()
                .lines(3)
                .spanCount(5)
                .scrollBarWidth(Util.dp2px(this, 40))
                .scrollBarHeight(Util.dp2px(this, 3))
                .scrollBarRadius(Util.dp2px(this, 3) / 2f)
                .scrollBarTopMargin(Util.dp2px(this, 6))
                .build();
        header.apply(options)
                .addOnTransformersItemClickListener(new OnTransformersItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getApplication(), "点击：" + navList.get(position).getText() + "，位置" + position, Toast.LENGTH_SHORT).show();
                    }
                })
                .load(navList, new TransformersHolderCreator<Nav>() {
                    @Override
                    public Holder<Nav> createHolder(View itemView) {
                        return new NavAdapterViewHolder(itemView);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_nav_list;
                    }
                });
        //endregion

        RecyclerView rv = findViewById(R.id.rv_main);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> beans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            beans.add("");
        }
        final ListAdapter adapter = new ListAdapter(beans);
        adapter.addHeaderView(header);
        rv.setAdapter(adapter);

        final SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        header.notifyDataChanged(navList);
                        refreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }
}
