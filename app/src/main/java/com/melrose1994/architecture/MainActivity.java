package com.melrose1994.architecture;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.melrose1994.baselibrary.extend.ThreadUtils;
import com.melrose1994.baselibrary.ioc.ui.ActivityInject;


/**
 * @author Melrose
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityInject.inject(this);




       // throw  new IllegalStateException("crash from code!");


    }
}
