package com.zafir.bojiu.net

object AppMainHost {
    const val HEADER_KEY = "skey"
    private var HTTP_BASE_URL: String = "http://calendar.360.cn/"
    private var httpService: IHttpService

    init {
        httpService = HttpLoader.addHttpService(HTTP_BASE_URL, IHttpService::class.java)
    }

    fun getHttpService(): IHttpService {
        return httpService
    }

    interface IHttpService {

//        @POST("app/token/get")
//        fun getToken(@Header(HEADER_KEY) key: String, @Body body: RequestBody): Observable<TokenData>
//
//        @POST("app/token/refresh")
//        fun refreshToken(@Header(HEADER_KEY) key: String, @Body body: RequestBody): Observable<TokenData>
    }
}