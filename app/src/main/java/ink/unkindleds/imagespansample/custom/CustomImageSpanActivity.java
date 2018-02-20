package ink.unkindleds.imagespansample.custom;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import ink.unkindleds.imagespansample.R;

import static android.text.style.DynamicDrawableSpan.ALIGN_BASELINE;
import static android.text.style.DynamicDrawableSpan.ALIGN_BOTTOM;

public class CustomImageSpanActivity extends AppCompatActivity {

    private static final String CONTENT = "刮开谢谢惠顾查看是否中奖";
    private static final String THANKS = "谢谢惠顾";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_image_span);
        TextView defaultTv = findViewById(R.id.default_text);
        TextView bottomTv = findViewById(R.id.bottom_text);
        TextView baselineTv = findViewById(R.id.baseline_text);
        TextView customTv = findViewById(R.id.custom_text);
        defaultTv.setText(generateSpan(Type.DEFAULT));
        bottomTv.setText(generateSpan(Type.BOTTOM));
        baselineTv.setText(generateSpan(Type.BASELINE));
        customTv.setText(generateSpan(Type.CUSTOM));
    }

    private SpannableString generateSpan(Type type) {
        SpannableString result = new SpannableString(CONTENT);
        Drawable drawable = getResources().getDrawable(R.drawable.image_black);
        drawable.setBounds(0, 0, 48, 16);
        int start = CONTENT.indexOf(THANKS);
        int end = start + THANKS.length();
        ImageSpan imageSpan;
        switch (type) {
            case CUSTOM:
                imageSpan = new CustomImageSpan(drawable);
                break;
            case BOTTOM:
                imageSpan = new ImageSpan(drawable, ALIGN_BOTTOM);
                break;
            case BASELINE:
                imageSpan = new ImageSpan(drawable, ALIGN_BASELINE);
                break;
            case DEFAULT:
            default:
                imageSpan = new ImageSpan(drawable);

        }
        result.setSpan(imageSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return result;
    }

    private enum Type {
        DEFAULT, BOTTOM, BASELINE, CUSTOM
    }
}
