package com.example.project_irfan

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper (context : Context?):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        val session = "CREATE TABLE session(id integer, login text)"
        val sql =
            "CREATE TABLE user(id_user integer PRIMARY KEY AUTOINCREMENT, nama text NOT NULL,email text NOT NULL, password text NOT NULL);"
        val insSession = "INSERT INTO session(id, login) VALUES(1,'Empty')"
        db.execSQL(session)
        db.execSQL(sql)
        db.execSQL(insSession)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS session")
        db.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }

    fun checkSession(sessionValues: String): Boolean{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM session WHERE login=?", arrayOf(sessionValues))
        return cursor.count>0
    }
    fun upgradeSession(sessionValues: String?, id: Int): Boolean{
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put("Login", sessionValues)
        val update = db.update("session", contentValues, "id=$id", null).toLong()
        return update != -1L
    }

    fun insertUser(nama: String?, email: String?, pass:String?): Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("nama", nama)
        contentValues.put("email", email)
        contentValues.put("password", pass)
        val insert = db.insert("user", null, contentValues)
        return insert != -1L
    }
    fun checkLogin(nama: String, pass: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM user WHERE nama = ? AND password = ?", arrayOf(nama, pass))
        return cursor.count>0
    }
    companion object {
        private const val DATABASE_NAME = "login.db"
        private const val DATABASE_VERSION = 1
    }
}