package com.example.edibi.bitcoupon;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by edibi on 4/13/15.
 */
public class PostRequest {

    private static CookieManager ckm = new CookieManager();

    public static void post(String url, String jsnObject, Callback callback){

        MediaType JSON = MediaType.parse("application/json");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, jsnObject);
        //     String basicAuth = "Basic" + Base64.encodeToString(
        //     String.format("%s:%s", sEmail, sPassword).getBytes(), Base64.NO_WRAP);

        //      ckm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        //      client.setCookieHandler(ckm);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                        //.addHeader("Authorization", "Basic dGVzdEBtYWlsLmNvbToxMjM0NTY=")
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        ckm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client.setCookieHandler(ckm);

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
