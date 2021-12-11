package qq.sharyar.todolist.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*
import qq.sharyar.todolist.R
import qq.sharyar.todolist.data.UserViewModel

class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerViewMainActivity
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        mUserViewModel.readAllData.observe(viewLifecycleOwner,  { user->
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

}