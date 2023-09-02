package com.project.semester7cw.BroadcasrReceiverAndJobService

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.project.semester7cw.R

class BRAJSMain : AppCompatActivity() {
    lateinit var jobScheduler: JobScheduler
    lateinit var startJob: Button
    lateinit var stopJob: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brajsmain)
        startJob = findViewById(R.id.startJob)
        stopJob = findViewById(R.id.stopJob)

        startJob.setOnClickListener {
            jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName = ComponentName(this, BRAJSJobService::class.java)
            val builder = JobInfo.Builder(123, componentName)
            builder.setMinimumLatency(1000)
            builder.setOverrideDeadline(3000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())
        }


        stopJob.setOnClickListener {
            if(jobScheduler != null) {
                jobScheduler
            }
        }
    }
}