package com.example.core.entities

open class zadatak {
    open var id:Int? = null
    open var zadatak : String = ""
    override fun toString(): String {
        return this.zadatak
    }
}