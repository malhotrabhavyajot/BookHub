package com.bsm.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bsm.bookhub.R
import com.bsm.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouriteRecyclerAdapter(val context: Context, val bookList: List<BookEntity>): RecyclerView.Adapter<FavouriteRecyclerAdapter.FavouriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_favourite_single_row,parent,false)

        return FavouriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val book = bookList[position]

        holder.txtFavBookTitle.text = book.bookName
        holder.txtFavBookAuthor.text=book.bookAuthor
        holder.txtFavBookPrice.text= book.bookPrice
        holder.txtFavBookRating.text=book.bookRating

        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgFavBookImage)
    }
    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtFavBookTitle: TextView =view.findViewById(R.id.txtFavBookTitle)
        val txtFavBookAuthor: TextView =view.findViewById(R.id.txtFavBookAuthor)
        val txtFavBookPrice: TextView =view.findViewById(R.id.txtFavBookPrice)
        val txtFavBookRating: TextView =view.findViewById(R.id.txtFavBookRating)
        val imgFavBookImage: ImageView =view.findViewById(R.id.imgFavBookImage)
        val llFavContent: LinearLayout =view.findViewById(R.id.llFavContent)
    }
}