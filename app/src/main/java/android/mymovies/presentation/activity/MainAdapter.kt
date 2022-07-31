package android.mymovies.presentation.activity

import android.mymovies.databinding.ItemMovieBinding
import android.mymovies.domain.model.Result
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter : PagingDataAdapter<Result, MainAdapter.MovieViewHolder>(MOVIES_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentItem = getItem(position)
        if (currentItem != null) holder.bind(currentItem)
    }

    class MovieViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Result) {
            binding.apply {
                Glide.with(this.root).load(movie.multimedia.src).into(ivMovieImage)
                tvTitle.text = movie.displayTitle
                tvDescription.text = movie.summaryShort
            }
        }
    }

    companion object {
        private val MOVIES_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.summaryShort == newItem.summaryShort

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem
        }
    }
}