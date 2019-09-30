package iteso.mx.tarea05.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import iteso.mx.tarea05.R
import iteso.mx.tarea05.activities.ActivityRegister
import iteso.mx.tarea05.activities.ActivityTutorial
import iteso.mx.tarea05.adapters.intf
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.startActivity

class FragmentTutorial1 : Fragment()  { //, View.OnClickListener
    private lateinit var listener : intf
    private lateinit var nextBtn: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = context as intf
        } catch ( e: ClassCastException){
            error{e}
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tutorial_1, container, false)

        //mRight = find(R.id.tutorial_1_rbtn)
        //mRight.setOnClickListener(this)
        nextBtn = view.findViewById(R.id.tutorial_1_rbtn)
        nextBtn.setOnClickListener {
            (activity as ActivityTutorial).onNext(1)
        }

        return view
    }

    /* test1
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tutorial_1_rbtn-> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_tutorial_fl_content,
                        FragmentTutorial1() //2
                    )
                    .commit()
            }
        }
    }

     */

    /*
    override fun onClick(view: View?) { //override
        when(view?.id) {
            R.id.tutorial_1_rbtn-> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_tutorial_fl_content, FragmentTutorial2())
                .commit()

        }
    }

     */

}