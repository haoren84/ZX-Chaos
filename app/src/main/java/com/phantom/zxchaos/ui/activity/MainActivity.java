package com.phantom.zxchaos.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.phantom.zxchaos.R;
import com.phantom.zxchaos.base.BaseActivity;
import com.phantom.zxchaos.databinding.ActivityMainBinding;

/**
 * @author Soul
 */
public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // 显示导航按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            // 修改默认图标
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_list_24);
        }

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment_activity_main);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //navController.setGraph(R.navigation.main_navigation);
        NavigationUI.setupWithNavController(binding.navView, navController);
        
        initDrawer();
    }

    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout,
                binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        binding.drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
    }

    /**
     * 添加菜单
     * 为ToolBar添加Action按钮
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 处理按钮选中事件
     *
     * @param item  Action
     * @return  boolean
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_1:
                Log.d("ToolBar", "menu_item_1");
                break;
            case R.id.action_2:
                Log.d("ToolBar", "menu_item_2");
                break;
            case R.id.action_3:
                Log.d("ToolBar", "menu_item_3");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}