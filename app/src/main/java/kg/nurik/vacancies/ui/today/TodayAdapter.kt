package kg.nurik.vacancies.ui.today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.nurik.vacancies.data.model.ItemVacanciesModel
import kg.nurik.vacancies.databinding.ItemVacanciesBinding

class TodayAdapter(private val viewModel: TodayViewModel) : RecyclerView.Adapter<TodayViewHolder>() {

    private var data: ArrayList<ItemVacanciesModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {

        val binding =
            ItemVacanciesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayViewHolder(binding,viewModel)
    }

    fun update(data: List<ItemVacanciesModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

class TodayViewHolder(
    private val binding: ItemVacanciesBinding,
    private val  viewModel: TodayViewModel
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemVacanciesModel) {
        binding.tvDate.text = item.data
        binding.tvJob.text = item.title
        binding.tvSalary.text = item.salary
        binding.tvTitleCardView.text = item.jobDesc

        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            item.isChecked = isChecked
            viewModel.update(item)
        }

        binding.checkbox.isChecked = item.isChecked
    }
}