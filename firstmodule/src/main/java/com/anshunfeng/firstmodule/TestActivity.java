package com.anshunfeng.firstmodule;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.BaseActivity;

/**
 * Created by ${Young} on 2018/11/29.
 */
@Route(path =ARouterPath.TestAct)
public class TestActivity  extends BaseActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
    }
}
