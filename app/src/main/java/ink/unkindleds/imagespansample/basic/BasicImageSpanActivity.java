package ink.unkindleds.imagespansample.basic;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import ink.unkindleds.imagespansample.R;

public class BasicImageSpanActivity extends AppCompatActivity {

    private static final String CONTENT = "扫描福字领取福卡";
    private static final String FU = "福字";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_image_span);
        textView = findViewById(R.id.text_view);
        textView.setText(generateSpannableString());
    }

    private SpannableString generateSpannableString() {
        SpannableString spannableString = new SpannableString(CONTENT);
        int start = CONTENT.indexOf(FU);
        int end = start + FU.length();
        Drawable fuDrawable = getResources().getDrawable(R.drawable.image_fu);
        fuDrawable.setBounds(0, 0, textView.getLineHeight(), textView.getLineHeight());
        ImageSpan imageSpan = new ImageSpan(fuDrawable);
        spannableString.setSpan(imageSpan, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return spannableString;
    }
}
