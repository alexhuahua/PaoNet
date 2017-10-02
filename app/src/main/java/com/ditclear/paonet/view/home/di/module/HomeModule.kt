package com.ditclear.paonet.view.home.di.module

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.ditclear.paonet.ContentFragment
import com.ditclear.paonet.EmptyFragment
import com.ditclear.paonet.lib.adapter.viewpager.AbstractPagerAdapter
import dagger.Module
import dagger.Provides

/**
 * 页面描述：
 *
 * Created by ditclear on 2017/9/30.
 */
@Module
class HomeModule(private val fm: FragmentManager) {

    @Provides
    fun provideHomePagerAdapter(): FragmentStatePagerAdapter {

        return object : AbstractPagerAdapter(fm, arrayOf("Article", "Code")) {
            override fun getItem(pos: Int): Fragment? {
                if (list==null){
                    list= mutableListOf<Fragment?>()
                }
                when (pos) {
                    0 -> list[pos] = ContentFragment()
                    1 -> list[pos]  = EmptyFragment()
                }
                return list[pos]
            }
        }
    }


}