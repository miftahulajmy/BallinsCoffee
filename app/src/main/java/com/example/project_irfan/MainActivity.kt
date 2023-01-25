package com.example.project_irfan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.project_irfan.utils.SessionLogin
import com.google.android.material.tabs.TabLayout

class MainActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.tambahFragment(BerandaFragment(), "Beranda")
        viewPagerAdapter.tambahFragment(PromoFragment(), "Promo")
        viewPagerAdapter.tambahFragment(ProfilFragment(), "Profil")
        viewPagerAdapter.tambahFragment(AboutFragment(), "About")
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
    fun keHome(view: View?) {
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)

    }

    fun kePesan(view: View?) {
        val i = Intent(applicationContext, Pesan::class.java)
        startActivity(i)
    }

    fun keProduk(view: View?) {
        val i = Intent(applicationContext, Produk::class.java)
        startActivity(i)
    }

    fun keMaps(view: View?) {
        val i = Intent(applicationContext, MapsActivity::class.java)
        startActivity(i)
    }

    fun KeIg(view: View) {
        val url = "https://instagram.com/balins.coffee?igshid=YmMyMTA2M2Y="
        val bukabrowser = Intent(Intent.ACTION_VIEW)
        bukabrowser.data = Uri.parse(url)
        startActivity(bukabrowser)
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(
        fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ){

        private val fragments: ArrayList<Fragment>
        private val juduls:ArrayList<String>

        init {
            fragments= ArrayList()
            juduls = ArrayList()

        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun tambahFragment(fragment: Fragment, judul: String){
            fragments.add(fragment)
            juduls.add(judul)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return juduls[position]
        }
    }
}