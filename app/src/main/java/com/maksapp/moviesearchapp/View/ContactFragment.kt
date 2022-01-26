package com.maksapp.moviesearchapp.View

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import com.maksapp.moviesearchapp.R



class ContactFragment : Fragment() {

    private val contactList = view?.findViewById<TextView>(R.id.contacts)?.apply {
        text = ""
    }

    companion object{
        fun newInstance() = ContactFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contacts,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
       // getContact()
        //checkPermission()
    }

    private fun checkPermission() {
        when{
            context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.READ_CONTACTS) } == PERMISSION_GRANTED->{
                getContact()
            }
            shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)->{
                context?.let {
                    AlertDialog.Builder(it)
                        .setTitle("Доступ нннада")
                        .setMessage("ощень хочеься")
                        .setPositiveButton("на доступ"){_,_-> requestPermission()}
                        .setNegativeButton("не не не"){ dialog,_->dialog.dismiss()}
                        .create()
                        .show()
                }
            }else->{
              requestPermission()
            }
        }
    }

    private fun requestPermission() {
       // ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.READ_CONTACTS),42)
        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 42)


    }


    private fun getContact() {
        context?.let {
            val contentResolver: ContentResolver? = it.contentResolver
            val cursor: Cursor? = contentResolver?.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"


            )

            cursor?.let { cursor ->
                val columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                if (columnIndex >= 0) {
                    for (i in 0..cursor.count) {
                        if (cursor.moveToPosition(i)) {
                            val name = cursor.getString(columnIndex)
                            if (contactList != null) {
                                contactList.text = "${contactList.text} + $name + \n"
                            }
                        }
                    }
                }

            }
            cursor?.close()
        }
    }
}