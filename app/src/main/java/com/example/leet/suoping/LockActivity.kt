package com.example.leet.suoping

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class LockActivity : AppCompatActivity() {
    var policyManager:DevicePolicyManager= getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
    }
}
