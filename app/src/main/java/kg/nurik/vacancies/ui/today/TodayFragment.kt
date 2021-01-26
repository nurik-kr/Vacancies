package kg.nurik.vacancies.ui.today

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.vacancies.R
import kg.nurik.vacancies.databinding.FragmentTodayBinding
import kg.nurik.vacancies.utils.viewBinding
import kg.nurik.vacancies.utils.viewModel

class TodayFragment : Fragment(R.layout.fragment_today) {

    private val viewModel by viewModel(TodayViewModel::class)
    private val adapter by lazy { TodayAdapter(viewModel) }
    private val binding by viewBinding(FragmentTodayBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.getAllList().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    private fun setupRV() {
        binding.RecyclerView.adapter = adapter
    }
}