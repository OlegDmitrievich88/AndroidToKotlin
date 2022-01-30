package com.maksapp.moviesearchapp.View

import android.Manifest
import android.content.ContentResolver
import android.database.Cursor
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.maksapp.moviesearchapp.R

class PermissionActivity : AppCompatActivity() {




    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        checkPermission()
    }
   // private val contactList = findViewById<TextView>(R.id.contact_two)


    @RequiresApi(Build.VERSION_CODES.M)
    private val permissionResult =
                  registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                when {
                    result -> getContact()
                    !shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_CONTACTS
                    ) -> {
                        AlertDialog.Builder(this)
                            .setTitle("Доступ нннада")
                            .setMessage("ощень хочеься")
                            .setPositiveButton("на доступ") { _, _ -> checkPermission() }
                            .setNegativeButton("не не не") { dialog, _ -> dialog.dismiss() }
                            .create()
                            .show()

                    }
                    else -> Toast.makeText(this, "voy", Toast.LENGTH_LONG).show()
                }
            }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermission() {
        permissionResult.launch(Manifest.permission.READ_CONTACTS)
    }

    private fun getContact() {

            val contentResolver: ContentResolver? = contentResolver
            val cursor: Cursor? = contentResolver?.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"


            )

            cursor?.let { cursor ->
           val contactList = findViewById<TextView>(R.id.contact_two)

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