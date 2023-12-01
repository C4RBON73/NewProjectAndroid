package com.example.newprojectandroid

import android.content.Context
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class Api(private val context: Context?) {
    fun get(cible: String?) {
        val request = JsonObjectRequest(
            Request.Method.GET,
            "http://10.0.2.2:3000/$cible",
            null,
            { res -> Toast.makeText(context, R.string.succes, Toast.LENGTH_SHORT).show() },
            { err -> Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show() }
        )
        val queue = Volley.newRequestQueue(context)
        queue.add(request)
        queue.start()

    }
}
/*import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class Api {
    class InitApplication : Application() {
        private var queue: RequestQueue? = null
        override fun onCreate() {
            super.onCreate()
            instance = this
        }

        fun <T> addToQueue(req: Request<T>, tag: String?) {
            req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
            getQueue().add<T>(req)
        }

        fun <T> addToQueue(req: Request<T>) {
            req.tag = TAG
            getQueue().add<T>(req)
        }

        fun cancelPendingRequests(tag: Any?) {
            if (queue != null) {
                queue!!.cancelAll(tag)
            }
        }

        fun getQueue(): RequestQueue {
            if (queue == null) {
                queue = Volley.newRequestQueue(applicationContext)
                return queue!!
            }
            return queue!!
        }

        companion object {
            @get:Synchronized
            var instance: InitApplication? = null
                private set
            private val TAG = InitApplication::class.java.simpleName
        }
    }
    companion object {
        fun postScore(name: String, Score: Int) {
            val instance: InitApplication = InitApplication.instance!!;
            val TAG: String = "updateScore"
            val req: JsonObjectRequest = JsonObjectRequest(Request.Method.POST,
                "http://localhost:3000/updateScore",
                JSONObject("{'username': $name, 'Score': $Score}"),
                {
                    fun onResponse(response: JSONObject) {
                        Log.d(TAG, response.toString())
                    }
                },
                {
                    fun onErrorResponse(e: VolleyError) {
                        Log.d(TAG, "Error: $e")
                    }
                })
            instance.addToQueue(req, TAG)
        }
    }
}*/