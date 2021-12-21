package ir.ha.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var frg1 : Frg1
    private lateinit var frg2 : Frg2
    private lateinit var frg3 : Frg3
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var fm : FragmentManager
    private lateinit var activeFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragments()
        bottomNav = findViewById(R.id.bottomNav)

        activeFragment = frg1

        fm.beginTransaction().add(R.id.container, frg3, "3")
            .hide(frg3).commit()
        fm.beginTransaction().add(R.id.container, frg2, "2")
            .hide(frg2).commit()
        fm.beginTransaction().add(R.id.container, frg1, "1").commit()



        bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.item1 ->{
                    fm.beginTransaction().hide(activeFragment).show(frg1).commit()
                    activeFragment = frg1
                    return@setOnItemSelectedListener true
                }

                R.id.item2 ->{
                    fm.beginTransaction().hide(activeFragment).show(frg2).commit()
                    activeFragment = frg2
                    return@setOnItemSelectedListener true
                }

                R.id.item3 ->{
                    fm.beginTransaction().hide(activeFragment).show(frg3).commit()
                    activeFragment = frg3
                    return@setOnItemSelectedListener true
                }

                else ->{
                    Toast.makeText(this,"error" , Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
            }

        }
        bottomNav.setOnItemReselectedListener {  }


    }

    private fun initFragments() {
        frg1 = Frg1()
        frg2 = Frg2()
        frg3 = Frg3()
        fm = supportFragmentManager
    }
}