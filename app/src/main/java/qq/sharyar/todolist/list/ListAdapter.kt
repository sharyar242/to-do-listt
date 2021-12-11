package qq.sharyar.todolist.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import qq.sharyar.todolist.R
import qq.sharyar.todolist.data.User
import kotlin.collections.List

class ListAdapter :RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var userList = emptyList<User>()

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {}

    fun setData(user: List<User>){
        this.userList =user
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        val item =(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.textViewTop.text = currentItem.missionName
        holder.itemView.textViewBottom.text = currentItem.dateName.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}