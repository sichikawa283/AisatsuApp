package jp.techacademy.shun.ichikawa.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 画面の初期状態
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    // BUTTONをクリックした時の動作
    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    // TimePickerDialogを表示する
    private fun showTimePickerDialog() {
        // 現在時刻の取得
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // TimePickerDialogクラスのインスタンスを生成
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                if (hour in 2..9 && minute in 0..59) {
                    textView.text = "おはよう"
                } else if (hour in 10..17 && minute in 0..59) {
                    textView.text = "こんにちは"
                } else if (hour in 18..24 && minute in 0..59) {
                    textView.text = "こんばんは"
                } else if (hour in 0..1 && minute in 0..59) {
                    textView.text = "こんばんは"
                }
            },
            hour,
            minute,
            true
        )

        timePickerDialog.show()
    }
}
