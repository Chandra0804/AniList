package com.example.anilist

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


object Database{
    private var configuration = RealmConfiguration.Builder(setOf(User::class)).build()
    private var realm = Realm.open(configuration)

    fun write(Email_input:String,UserName_input : String, Password_input : String){
        val user = User().apply {
            Email = Email_input
            Username = UserName_input
            Password = Password_input
        }

        val manageduser = realm.writeBlocking {
            copyToRealm(user)
        }
    }

}