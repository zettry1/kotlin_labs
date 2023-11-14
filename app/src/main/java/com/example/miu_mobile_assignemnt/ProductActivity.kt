package com.example.miu_mobile_assignemnt

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miu_mobile_assignemnt.model.Product

class ProductActivity (private val products: List<Product>) : RecyclerView.Adapter<ProductActivity.ProductViewHolder>(){
    private var onClickListener: OnClickListener? = null

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.productName)
        val description: TextView = itemView.findViewById(R.id.productDescription)
        val image: ImageView = itemView.findViewById(R.id.image)
        val price: TextView = itemView.findViewById(R.id.cost)
        val logo: ImageView = itemView.findViewById(R.id.brandLogo)
        val addProduct: Button = itemView.findViewById(R.id.addProduct)
    }

//
//    private fun addProd() {
//        val name = findViewById<TextView>(R.id.name)
//        val description = findViewById<TextView>(R.id.description)
//        val price = findViewById<TextView>(R.id.cost)
//        val image = findViewById<ImageView>(R.id.image)
    //        image.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_background))
//
//    }
    override fun onBindViewHolder(myHolder: ProductViewHolder, position: Int) {
        val product = products[position]

    myHolder.name.text = product.productName
    myHolder.description.text = product.productDescription
    myHolder.price.text = "${product.cost}$"
    myHolder.image.setImageResource(product.image)
    myHolder.logo.setImageResource(product.brandLogo)
    myHolder.addProduct.setOnClickListener {
            if(onClickListener != null) {
                onClickListener!!.onClick(position, product, "ADD PRODUCT")
            }
        }

    myHolder.itemView.setOnClickListener {
            if (onClickListener!=null) {
                onClickListener!!.onClick(position, product, "VIEW")
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, product: Product, action: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return products.size
    }

}