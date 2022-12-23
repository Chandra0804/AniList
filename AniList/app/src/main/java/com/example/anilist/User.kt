package com.example.anilist

import io.realm.kotlin.types.RealmObject


class User : RealmObject{

    var Email : String = ""

    var Password : String = ""
    var Username : String = ""
}