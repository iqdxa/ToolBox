package com.example.toolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var toolMenu: Menu ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMusic: Button =findViewById(R.id.button_music)

        buttonMusic.setOnClickListener{

        }
    }

    //该方法用于创建显示Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        toolMenu = menu
        return super.onCreateOptionsMenu(menu)
    }

    //该方法对菜单的item进行监听
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about ->
                startActivity(Intent(this,AboutActivity::class.java))
            R.id.menu_quiet -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private var isExit: Boolean = false

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            exitBy2Click() //调用双击退出函数
        return false
    }

    private fun exitBy2Click() {
        val handler = Handler()
        if ((!isExit)) {
            isExit = true
            Toast.makeText(this, "再按一次退出APP", Toast.LENGTH_LONG).show()
            handler.postDelayed({ isExit = false }, 1000 * 2) //x秒后没按就取消
        } else {
            finish()
            //System.exit(0)
        }
    }
}

