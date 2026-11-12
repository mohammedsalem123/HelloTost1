package com.example.hellotost1;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hellotost1.R;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ربط العناصر مع الـ XML
        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);
        mButtonCount = findViewById(R.id.button_count);
    }

    // زر TOAST
    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }

    // زر COUNT: زيادة العداد وتغيير ألوان الأزرار ديناميكياً
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // تفعيل زر ZERO باللون الوردي/الفوشي كما في الواجب
        mButtonZero.setBackgroundColor(Color.MAGENTA);

        // فحص العدد: فردي (أخضر) - زوجي (أزرق)
        if (mCount % 2 == 1) {
            mButtonCount.setBackgroundColor(Color.GREEN);
        } else {
            mButtonCount.setBackgroundColor(Color.BLUE);
        }
    }

    // زر ZERO: تصفير العداد وإعادة زر الصفر إلى اللون الرمادي
    public void resetZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // إعادة زر ZERO إلى الرمادي (غير نشط)
        mButtonZero.setBackgroundColor(Color.GRAY);

        // إعادة زر COUNT إلى الأزرق الأصلي
        mButtonCount.setBackgroundColor(Color.parseColor("#3F51B5"));
    }

    // حفظ قيمة العداد ولون زر ZERO قبل تدوير الشاشة
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_value", mCount);
    }

    // استرجاع القيمة وضبط الألوان بعد اكتمال التدوير
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCount = savedInstanceState.getInt("count_value");
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // إعادة ضبط حالة ولون الأزرار حسب الرقم المسترجع
        if (mCount > 0) {
            mButtonZero.setBackgroundColor(Color.MAGENTA);
            if (mCount % 2 == 1) {
                mButtonCount.setBackgroundColor(Color.GREEN);
            } else {
                mButtonCount.setBackgroundColor(Color.BLUE);
            }
        }
    }
}