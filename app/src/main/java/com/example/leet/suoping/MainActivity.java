package com.example.leet.suoping;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        devicePolicyManager=(DevicePolicyManager)getSystemService(DEVICE_POLICY_SERVICE);
        componentName=new ComponentName(this,LockReceiver.class);
        if(devicePolicyManager.isAdminActive(componentName)){
            devicePolicyManager.lockNow();
            android.os.Process.killProcess(android.os.Process.myPid());
        }else{
            activeManager();
        }

    }
    private void activeManager(){
        Intent intent=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,"一键锁屏");
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        if(devicePolicyManager!=null&&devicePolicyManager.isAdminActive(componentName)){
            devicePolicyManager.lockNow();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        super.onResume();
    }
}
