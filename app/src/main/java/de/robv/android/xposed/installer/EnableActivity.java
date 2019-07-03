package de.robv.android.xposed.installer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import de.robv.android.xposed.installer.util.ModuleUtil;

public class EnableActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String pkg = getIntent().getStringExtra("pkg");
        ModuleUtil.getInstance().setModuleEnabled(pkg, true);
        Toast.makeText(this, pkg + ";" + ModuleUtil.getInstance().isModuleEnabled(pkg), Toast.LENGTH_SHORT).show();
        ModuleUtil.getInstance().updateModulesList(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}
