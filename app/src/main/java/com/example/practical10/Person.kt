package com.example.practical10

import org.json.JSONObject
import java.io.Serializable

class Person(jsonObject: JSONObject):Serializable {
    var id:String
    var Name: String
    var EmailId: String
    var PhoneNo: String
    var Address: String
    var Latitude: Double
    var Longitude:Double

    init {
        id = jsonObject.getString("id")
        EmailId = jsonObject.getString("email")
        PhoneNo = jsonObject.getString("phone")
        val profileJson = jsonObject.getJSONObject("profile")
        Name = profileJson.getString("name")
        Address = profileJson.getString("address")
        val locationJson = profileJson.getJSONObject("location")
        Latitude = locationJson.getDouble("lat")
        Longitude = locationJson.getDouble("long")
    }

    override fun toString(): String {
        return "$Name\n$PhoneNo\n$EmailId\n$Address\nlat:$Latitude\nlog:$Longitude"
    }
}