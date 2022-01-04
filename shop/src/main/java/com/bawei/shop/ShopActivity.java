package com.bawei.shop;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_framework.data.db.UserDao;
import com.bawei.library_framework.data.user.User;
import com.bawei.library_framework.database.UserManager;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.shop.mydapater.UserApater;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车页面
 */
@Route(path = RoutePath.SHOP_PATH)
public class ShopActivity extends BaseFragment {
    public  List<User> users;
    public UserApater apater;
    private RecyclerView reshsops;
    private ImageView fanhui;
    private TextView zhuce;
    private CheckBox quanxuan;
    private TextView price;
    private Button jiesuan;
    int myone = 0;
    int myones = 0;
    CheckBox checkBoxx;
    private TextView pricesss;
    private ArrayList<User> list ;

    @Override
    public int bandLayout() {
        return R.layout.activity_shop;
    }

    @Override
    public void initView() {

        reshsops = (RecyclerView) findViewById(R.id.reshsops);
        reshsops.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);
        quanxuan = (CheckBox) findViewById(R.id.quanxuan);
        price = (TextView) findViewById(R.id.price);
        jiesuan = (Button) findViewById(R.id.jiesuan);
        pricesss = (TextView) findViewById(R.id.pricesss);

    }

    @Override
    public void initData() {

        jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<>();
                for (int i = 0; i < users.size(); i++) {

                    if (users.get(i).getChbox()){
                        list.add(users.get(i));
                        myones+=list.get(i).getPrice();
                        ARouter.getInstance()
                                .build("/shop/Order")
                                .withSerializable("users",list).withInt("myoness",myones)
                                .navigation();
                    }else{
                        ToastUtils.showShort("您还未勾选商品，请勾选商品在结算哦");
                    }
                }

            }
        });

        //返回上一级
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        //数据库
        UserDao usersDao = UserManager.getInstance().getUsersDao();
        //把数据库的东西打印出来

        users = usersDao.loadAll();

        //更新适配器
        apater = new UserApater(users);
        reshsops.setAdapter(apater);

        //长按删除
        apater.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                usersDao.delete(users.get(position));
                apater.notifyDataSetChanged();
                users.remove(position).getPic();
                ToastUtils.showShort("删除成功");
                return false;
            }
        });

        //适配器点击事件
        apater.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {
                //加
                int index;
                if (view.getId() == R.id.jia) {
                    index = users.get(position).getNum();
                    index++;
                    users.get(position).setNum(index);

                    myone += users.get(position).getPrice();

                    price.setText("合计：" + myone + "￥");
                    adapter.notifyDataSetChanged();
                }

                //减
                int index1;
                if (view.getId() == R.id.jian) {
                    index1 = users.get(position).getNum();
                    if (index1 > 0) {
                        index1--;
                        if (index1 == 0) {
                            users.get(position).setChbox(false);
                        }
                        users.get(position).setNum(index1);
                        if (myone >= users.get(position).getPrice()) {
                            myone -= users.get(position).getPrice();
                        }
                        price.setText("合计：" + myone + "￥");
                    }
                    adapter.notifyDataSetChanged();
                    if (index1 <= 0) {
                        ToastUtils.showShort("不能再少了哦。。。");
                    }
                }
                int num;
                if (view.getId() == R.id.chboxs) {
                    checkBoxx = (CheckBox) adapter.getViewByPosition(position, R.id.chboxs);
                    num = users.get(position).getNum();
                    if (checkBoxx.isChecked()) {
                        num = 1;
                        users.get(position).setNum(num);
                        users.get(position).setChbox(true);

                        myone += users.get(position).getPrice();

                        price.setText("合计：" + myone + "￥");
                        if (num == 0) {
                            users.get(position).setChbox(false);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //全选
        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < users.size(); i++) {
                    if (quanxuan.isChecked()) {
                        int num = users.get(i).getNum();
                        num = 1;
                        users.get(i).setNum(num);
                        users.get(i).setChbox(true);
                        myone += users.get(i).getPrice();
                        price.setText("合计：" + myone + "￥");
                    } else {
                        int num = users.get(i).getNum();
                        num = 1;
                        users.get(i).setNum(num);
                        users.get(i).setChbox(false);
                        myone -= users.get(i).getPrice();
                        price.setText("合计：" + myone + "￥");
                        if (num == 0) {
                            users.get(i).setChbox(false);
                        }
                        apater.notifyDataSetChanged();
                    }
                    apater.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }


}