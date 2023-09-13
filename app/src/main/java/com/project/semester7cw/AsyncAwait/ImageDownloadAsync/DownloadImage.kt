package com.project.semester7cw.AsyncAwait.ImageDownloadAsync

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.project.semester7cw.R
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadImage : AppCompatActivity() {
    lateinit var downloadImage: ImageView
    lateinit var downloadBtn: Button
    lateinit var url: URL
    var inputStream: InputStream? = null
    var bitmap: Bitmap? = null
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_image)
        downloadImage = findViewById(R.id.downloadImage)
        downloadBtn = findViewById(R.id.downloadBtn)
        downloadBtn.setOnClickListener{
            val asyncTask: AsyncImageDownload = AsyncImageDownload()
            asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg")
        }

    }

    private inner class AsyncImageDownload: AsyncTask<String?, String?, Bitmap?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(this@DownloadImage)
            progressDialog.setMessage("Please wait....image is downloading")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }
        override fun doInBackground(vararg params: String?): Bitmap? {
            try {
                url = URL(params[0])
                val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
                conn.doInput = true
                conn.connect()
                inputStream = conn.inputStream
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.RGB_565
                bitmap = BitmapFactory.decodeStream(inputStream, null, options)
            }
            catch (e: IOException) {
                e.printStackTrace()
            }
            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            progressDialog.hide()
            downloadImage.setImageBitmap(bitmap)
        }
    }
}