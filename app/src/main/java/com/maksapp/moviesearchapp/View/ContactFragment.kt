package com.maksapp.moviesearchapp.View

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.pm.PackageManager
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



class ContactFragment(): Fragment() {

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

        getContact()
        checkPermission()
    }

    private fun checkPermission() {
        when{
            ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED->{
                getContact()
            }
            shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_CONTACTS)->{
                AlertDialog.Builder(this).setTitle("Доступ нннада")
                    .setMessage("ощень хочеься")
                    .setPositiveButton("на доступ"){_,_-> requestPermission()}
                    .setNegativeButton("не не не"){ dialog,_->dialog.dismiss()}
                    .create()
                    .show()
            }else->{
              requestPermission()
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),42)
    }


    private fun getContact() {
        val contentResolver: ContentResolver? = context?.contentResolver
        val cursor: Cursor? = contentResolver?.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"


        )
        val contactList = view?.findViewById<TextView>(R.id.contacts)?.apply {
            text = ""
        }
        cursor?.let { cursor ->
            val columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                if (columnIndex >= 0) {
                    for (i in 0..cursor.count) {
                        if (cursor.moveToPosition(i)) {
                            val name = getString(columnIndex)
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