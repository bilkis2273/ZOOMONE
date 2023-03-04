package com.example.zoom1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLITE(var context: Context) : SQLiteOpenHelper(context, "Repo_DB", null, 1) {

    companion object {
        private const val Table_Name = "TN"
        private const val Id = "id"
        private const val owner = "owner"
        private const val dataofuser = "descerpertion"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $Table_Name($Id  Integer primary key  autoincrement  , $owner Text, $dataofuser  Text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertdata(sqlinsert: MODEL): Long {
        var db = this.writableDatabase
        var contextValues = ContentValues()
        contextValues.put("id", sqlinsert.id)
        contextValues.put("owner", sqlinsert.owner)
        contextValues.put("descerpertion", sqlinsert.descerptions)
        var datainsert = db.insert("$Table_Name", null, contextValues)
        db.close()
        return datainsert
    }
    fun getalldata(): ArrayList<MODEL> {
        var s: ArrayList<MODEL> = ArrayList()
        var querey = "SELECT * FROM $Table_Name"

        var db = this.readableDatabase
        var curcor: Cursor

        try {
            curcor = db.rawQuery(querey, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(querey)
            return ArrayList()
        }
        var id: Int
        var ownerdata: String
        var desctiondata: String

        if (curcor.moveToFirst()) {
            do {
                id = curcor.getInt(curcor.getColumnIndexOrThrow("id"))
                ownerdata = curcor.getString(curcor.getColumnIndexOrThrow("owner"))
                desctiondata = curcor.getString(curcor.getColumnIndexOrThrow("descerpertion"))
                var addeddata = MODEL(id = id, owner = ownerdata, descerptions = desctiondata)
                s.add(addeddata)

            } while (curcor.moveToNext())
        }
        return s
    }
}



