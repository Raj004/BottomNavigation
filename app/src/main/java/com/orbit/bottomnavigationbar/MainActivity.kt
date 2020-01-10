package com.orbit.bottomnavigationbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.bottomnavigation.LabelVisibilityMode

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.MenuItem

//implement the interface OnNavigationItemSelectedListener in your activity class
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loading the default fragment
        loadFragment(HomeFragment())
        val navigation = findViewById(R.id.navigation) as BottomNavigationView



        //getting bottom navigation view and attaching the listener
        navigation.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.item_message -> fragment = HomeFragment()

            R.id.item_diary -> fragment = DashboardFragment()

            R.id.item_module -> fragment = NotificationsFragment()

            R.id.item_monitoring -> fragment = ProfileFragment()
        }

        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }
}
