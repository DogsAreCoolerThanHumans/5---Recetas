package iteso.mx.tarea05.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import iteso.mx.tarea05.R
import iteso.mx.tarea05.adapters.intf
import iteso.mx.tarea05.fragments.FragmentTutorial1
import iteso.mx.tarea05.fragments.FragmentTutorial2
import iteso.mx.tarea05.fragments.FragmentTutorial3
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityTutorial : AppCompatActivity(), intf { //view.onclick
    //private lateinit var mRight: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        //mRight = find(R.id.tutorial_1_rbtn)
        //mRight.setOnClickListener(this)



        /* TODO Create three fragments for the tutorial and place them in activity_tutorial_fl_content
        *   First Fragment has a background image and a next button
        *   Second Fragment has a background image a next and previous button
        *   Third Fragment has a background image a finish and a previous button
        *  */

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_tutorial_fl_content,
                FragmentTutorial1()
            )
            .commit()

    }

    override fun onNext(activityNumber : Int){
        when(activityNumber){
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorial2()
                    )
                    .addToBackStack(null)
                    .commit()
            }
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorial3()
                    ).addToBackStack(null)
                    .commit()
            }
            3 -> {
                startActivity<ActivityMain>()
            }
        }
    }

    override fun onPrevious(activityNumber: Int) {
        when (activityNumber) {
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.activity_tutorial_fl_content,
                        FragmentTutorial1()
                    ).addToBackStack(null)
                    .commit()
            }
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.activity_tutorial_fl_content,
                        FragmentTutorial2()
                    ).addToBackStack(null)
                    .commit()
            }
        }
    }

    /*
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tutorial_1_rbtn-> {
                startActivity<ActivityRegister>() //main
            }
        }
    }

     */


    /*
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_home -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_tutorial_fl_content,
                    FragmentTutorial1()
                )
                .commit()
            /*
            R.id.action_search -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_tutorial_fl_content, FragmentSearch())
                .commit()
            R.id.action_profile -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_tutorial_fl_content, FragmentProfile())
                .commit()

             */
        }
        return true
    }
     */

    //@+id/activity_tutorial_fl_content
}
