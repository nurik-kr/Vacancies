package kg.nurik.vacancies.ui.chosen

import android.os.Bundle
import androidx.lifecycle.Observer
import kg.nurik.vacancies.R
import kg.nurik.vacancies.common.BaseActivity
import kg.nurik.vacancies.utils.viewModel
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : BaseActivity() {

    private val viewModel by viewModel(FavouriteViewModel::class)
    private val adapter by lazy { ChosenAdapter(viewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        setSupportActionBar(toolBar) //если есть свой туулбар
        createDrawer(toolBar)
        setupRV()
        setupViewModel()
    }

    private fun setupRV() {
        RecyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel.getAllList().observe(this, Observer {
            adapter.update(it)
        })
    }
}