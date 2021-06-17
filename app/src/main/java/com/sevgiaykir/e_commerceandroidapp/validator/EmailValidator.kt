package com.sevgiaykir.e_commerceandroidapp.validator

class EmailValidator {

    fun validate(email:String?):String? {
        if (email==null) return "Bu alan boş bırakılamaz"
        if (email.isBlank()) return "Bu alan boş bırakılamaz"
        if (email.length<9) return "Geçerli bir e-posta adresi girin."
        if (!email.contains("@") || !email.contains(".")) return "Geçerli bir e-posta adresi girin."
        return null
    }
}