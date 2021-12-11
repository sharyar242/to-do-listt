package qq.sharyar.todolist.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import qq.sharyar.todolist.R
import qq.sharyar.todolist.data.User
import qq.sharyar.todolist.data.UserDatabase
import qq.sharyar.todolist.data.UserViewModel

class AddFragment : Fragment() {


    private  var mUserViewModel: UserViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        view.btnCheck.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }
    private fun insertDataToDatabase() {
        val missionName = eTextZadacha.text.toString()
        val dateName = eTextDate.text

        if (inputCheck(missionName)){

            val user = User(0,missionName,Integer.parseInt(dateName.toString()))

            mUserViewModel?.addUser(user)

            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(missionName:String): Boolean {
        return !(TextUtils.isEmpty(missionName))
    }

}