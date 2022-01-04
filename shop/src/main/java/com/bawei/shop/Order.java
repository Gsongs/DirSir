package com.bawei.shop;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_framework.data.db.UserDao;
import com.bawei.library_framework.data.user.User;
import com.bawei.library_framework.room.UserDataBase;
import com.bawei.library_framework.room.UserRoom;
import com.bawei.library_framework.room.Users;
import com.bawei.library_framework.sp.Preferences;
import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.shop.mydapater.OrderApater;
import com.bawei.sort.collter.TakeCollter;
import com.bawei.sort.json.TakeBean;
import com.bawei.sort.model.TakeModel;
import com.bawei.sort.presenter.TakePresenter;
import com.blankj.utilcode.util.ToastUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public

/**
 * 作者：王先生
 * 时间：2021/12/17 19:34
 * 用途：订单确认页面
 */

@Route(path = "/shop/Order")
class Order extends BaseActivity implements TakeCollter.TakeView {
    private ImageView fanhui;
    private TextView zhuce;
    private RecyclerView resorder;
    private TextView nums;
    private android.widget.Button tijiao;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    TakePresenter takePresenter;
    @Override
    public int bandLayout() {
        return R.layout.order;
    }

    //自动导入
    @Autowired(name = "users")
    public ArrayList<User> users;
    @Autowired(name = "myoness")
    public int myoness;

    public ArrayList<Users> orders = new ArrayList<>();


    @Override
    public void initView() {

        //初始化
        ARouter.getInstance().inject(this);

        fanhui = (ImageView) findViewById(R.id.fanhui);
        zhuce = (TextView) findViewById(R.id.zhuce);
        resorder = (RecyclerView) findViewById(R.id.resorder);
        nums = (TextView) findViewById(R.id.nums);
        resorder.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        tijiao = (Button) findViewById(R.id.tijiao);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);

        takePresenter = new TakePresenter(new TakeModel(), this);
    }
    @Override
    public void initData() {

        takePresenter.get();
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/m/m").navigation();
            }
        });

        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRoom userRoom = UserDataBase.getInstance(Order.this).getUserRoom();
                //提交订单的时候创建
                for (int i = 0; i < users.size(); i++) {
                    long time = System.currentTimeMillis();
                    Users users = new Users(time,Order.this.users.get(i).getName(), Order.this.users.get(i).getPic(), "" + Order.this.users.get(i).getPrice(), 0,0.0f,"");
                    userRoom.insert(users);
                    orders.add(users);
                }
                ARouter.getInstance().build("/pay/pay").withSerializable("ints",orders).navigation();
            }
        });

        //返回上一个页面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //结算出来的总价格
        nums.setText("金额："+myoness+"￥");
        //适配勾选过来的数据
        OrderApater apater = new OrderApater(users);
        resorder.setAdapter(apater);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void TakeViews(TakeBean takeBean) {
        for (int i = 0; i < takeBean.getData().size(); i++) {
            Integer is = (Integer) Preferences.getInstance().get("is", 211);

            if (takeBean.getData().get(i).getId()== is){
                t1.setText(takeBean.getData().get(i).getAddress());
                t2.setText(takeBean.getData().get(i).getPhonenum());
                t3.setText(takeBean.getData().get(i).getIsdefault());
            }
        }
    }

    @Override
    public void shot(@NotNull String msg) {

    }
}
