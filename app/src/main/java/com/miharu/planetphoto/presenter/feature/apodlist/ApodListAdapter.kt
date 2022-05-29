package com.miharu.planetphoto.presenter.feature.apodlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.miharu.planetphoto.R
import com.miharu.planetphoto.databinding.ItemApodListBinding
import com.miharu.planetphoto.domain.model.ApodResponse

class ApodListAdapter(
    private val apodList: List<ApodResponse> = listOf()
) : RecyclerView.Adapter<ApodListAdapter.ApodListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodListViewHolder {
        val binding =
            ItemApodListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (ApodListViewHolder(binding))
    }

    override fun onBindViewHolder(holder: ApodListViewHolder, position: Int) {
        holder.bind(apodList[position])
    }

    override fun getItemCount(): Int = apodList.size

    inner class ApodListViewHolder(private val binding: ItemApodListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(apod: ApodResponse) {
            binding.apply {
                Glide.with(root)
                    .load(apod.url)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(apodImageView)
                apodTitleTextView.text = root.context.getString(R.string.apod_title, apod.title)
                apodDateTextView.text = root.context.getString(R.string.apod_date, apod.date)
                apodCopyRightTextView.text =
                    root.context.getString(R.string.apod_copyright, apod.copyright)
                apodExplanationTextView.text =
                    root.context.getString(R.string.apod_explanation, apod.explanation)
            }
        }
    }
}