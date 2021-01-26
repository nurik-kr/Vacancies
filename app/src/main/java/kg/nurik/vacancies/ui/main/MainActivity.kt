package kg.nurik.vacancies.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kg.nurik.vacancies.common.BaseActivity
import kg.nurik.vacancies.data.model.ViewPagerModel
import kg.nurik.vacancies.databinding.ActivityMainBinding
import kg.nurik.vacancies.ui.PagerAdapter
import kg.nurik.vacancies.ui.similar.SimilarFragment
import kg.nurik.vacancies.ui.today.TodayFragment
import kg.nurik.vacancies.utils.viewBinding

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { PagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar) //если есть свой туулбар
        createDrawer(binding.toolBar)
        binding.viewPager.adapter = adapter
        adapter.update(getDataForPager())
        TabLayoutMediator(binding.tableLayout, binding.viewPager) { tab, pos ->
            tab.text = adapter.getCurrentItem(pos).title
        }.attach()
    }

//        override fun onNavigationItemSelected(item: MenuItem): Boolean {
//            when (item.itemId) {
//                item.itemId -> Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
//            }
//            return true
//        }

    private fun getDataForPager(): ArrayList<ViewPagerModel> {
        val list = arrayListOf<ViewPagerModel>()
        list.add(
            ViewPagerModel(
                TodayFragment(),
                "Вакансии за сутки"
            )
        )
        list.add(
            ViewPagerModel(
                SimilarFragment(),
                "Подходящие"
            )
        )

        return list
    }
}