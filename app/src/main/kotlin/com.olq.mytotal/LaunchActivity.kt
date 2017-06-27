package com.olq.mytotal

import android.content.Intent
import android.os.Handler
import com.olq.mytotal.base.BaseActivity

class LaunchActivity : BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_launch
    }

    override fun onCreate() {
        var handler=Handler()
        var run= Runnable {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
        handler.post(run)
    }

}
