package cs32.hero.viewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewFlipper viewFlipper;
    private Button back;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        back = (Button) findViewById(R.id.back);
        next = (Button) findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);

        int size = 3;

        for (int i = 0; i < size; i++) {
            WebView webView = new WebView(this);
            viewFlipper.addView(webView);
            webView.loadUrl(createURL(i));
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });
        }


    }

    private String createURL(final int position) {
        String url = null;
        if (position == 0) {
            url = "https://www.google.co.jp/";
        }
        if (position == 1) {
            url = "http://www.goo.ne.jp/";
        }
        if (position == 2) {
            url = "https://twitter.com/";
        }
        return url;
    }

    @Override
    public void onClick(final View view) {
        if (view == back) {
            viewFlipper.setInAnimation(
                    AnimationUtils.loadAnimation(this,
                            android.R.anim.slide_in_left)
            );
            viewFlipper.showPrevious();
        }
        if (view == next) {
            viewFlipper.setInAnimation(
                    AnimationUtils.loadAnimation(this,
                            android.R.anim.slide_out_right)
            );
            viewFlipper.showNext();
        }
    }


}
