package com.example.flashcardsappfrontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.flashcardsappfrontend.databinding.ActivityMainBinding

/**
 * PUBLIC_INTERFACE
 * Main activity holding the bottom navigation with Review, Create, and Categories tabs.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val reviewFragment = ReviewFragment()
    private val createFragment = CreateFragment()
    private val categoriesFragment = CategoriesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCurrentFragment(reviewFragment)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_review -> setCurrentFragment(reviewFragment)
                R.id.menu_create -> setCurrentFragment(createFragment)
                R.id.menu_categories -> setCurrentFragment(categoriesFragment)
                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        return true
    }
}
