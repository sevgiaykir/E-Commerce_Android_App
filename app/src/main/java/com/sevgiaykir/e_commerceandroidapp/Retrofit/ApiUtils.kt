package com.sevgiaykir.e_commerceandroidapp.Retrofit

class ApiUtils {
    companion object{
        val BASE_URL= "http://upschool.canerture.com/"

        fun getProductsDaoInterface(): ProductsDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(ProductsDAOInterface::class.java)
        }

        fun getUsersDaoInterface(): UsersDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(UsersDAOInterface::class.java)
        }
    }
}