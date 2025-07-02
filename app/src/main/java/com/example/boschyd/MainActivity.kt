package com.example.boschyd

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
val TAG = MainActivity::class.java.simpleName
    private lateinit var mService: MusicService
    lateinit var resultTv:TextView
    lateinit var viewModel:MainViewmodel
    lateinit var userName:EditText
    lateinit var phNumber:EditText
    lateinit var myComponent: MyComponent

    @Inject
   lateinit var sharedPreferences: SharedPreferences
   //nowhere am i instantitating the sharedpreferences object -- consumer


    var secsObserverphno: Observer<Int> = object : Observer<Int> {
        override fun onChanged(seconds: Int) {
            //receiving the update/notification
            resultTv.setText(seconds.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflation

        userName = findViewById(R.id.inUsername)
        phNumber = findViewById(R.id.inNumber)
        resultTv = findViewById(R.id.tvResult)
        viewModel = ViewModelProvider(this)[MainViewmodel::class.java]

       // resultTv.setText(""+viewModel._seconds)

        viewModel._seconds.observe(this, secsObserverphno);
    //me giving my phno to the postman // hit subscribe/bell icon

//
//        myComponent = DaggerMyComponent.builder()
//            .sharedPrefModule(SharedPrefModule(this))
//            .build();
//        myComponent.inject(this); //inject the dependency into this class

    }

    fun handleClick(view: View) {
        //explicit intnet
//        var calIntent = Intent(this,CalendarActivity::class.java)
//        startActivity(calIntent)
//        var clMain:ConstraintLayout = findViewById(R.id.maincl)
//        Snackbar.make(clMain,"button clicked",Snackbar.LENGTH_SHORT).show()
        var nameEt:EditText = findViewById(R.id.etName) //taking handle
        var name:String = nameEt.text.toString()
        val resultTv:TextView = findViewById(R.id.tvResult)
        resultTv.setText(name)
    }

    fun dialNo(view: View) {
        //https://developer.android.com/guide/components/intents-common
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"))
        startActivity(dialIntent)
    }


    fun startServing(view: View) {
        val intentServ = Intent(applicationContext,MusicService::class.java)
        bindService(intentServ,serviceConn, BIND_AUTO_CREATE)
        //startService(intentServ)
    }

    fun stopService(view: View) {
        val intentServ = Intent(applicationContext,MusicService::class.java)
        stopService(intentServ)

    }

    private val serviceConn = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, nbindr: IBinder?) {
           // var mService = MusicService() -- instantiating
            val binderBridge = nbindr as MusicService.LocalBinder //as = typecastinng
            mService = binderBridge.getService()
            val result = mService.addMusicService(10,20)
            Log.i(TAG,"sum is --"+result)
            Log.i(TAG,"latest score is--"+mService.getCricScore())
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }
    }

    fun incrementCount(view: View) {
        viewModel.startTimer()
        resultTv.setText(""+viewModel._seconds)

    }

    fun saveDetails(view: View) {

    }
    fun getDetails(view: View) {}

}