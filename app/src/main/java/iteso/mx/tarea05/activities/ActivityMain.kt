package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import iteso.mx.tarea05.R
import iteso.mx.tarea05.fragments.FragmentProfile
import iteso.mx.tarea05.fragments.FragmentRecipes
import iteso.mx.tarea05.fragments.home.FragmentHome

class ActivityMain : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.setOnNavigationItemSelectedListener(this)
        navigation.getMenu().findItem(R.id.action_home).setChecked(true)//default

        supportFragmentManager //clickeado por default
            .beginTransaction()
            .replace(R.id.activity_main_fl_main_content,
                FragmentHome()
            )
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_home -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content,
                    FragmentHome()
                )
                .commit()
            R.id.action_recipes -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentRecipes())
                .commit()
            R.id.action_profile -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentProfile())
                .commit()
        }
        return true
    }
}

