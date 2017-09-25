package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class GameTopBannerView extends FrameLayout implements OnClickListener {
    Context mContext;
    int mFI;
    int mFJ;
    String mFK = "";
    private String mFL = "";
    String mFM = null;
    int mqT;
    ImageView mxG;
    ImageView mxH;

    public GameTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mxG = (ImageView) findViewById(R.h.bsI);
        this.mxH = (ImageView) findViewById(R.h.cFH);
        w.i("MicroMsg.GameTopBannerView", "initView finished");
    }

    final int b(ImageView imageView, int i, int i2) {
        int screenWidth = c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            w.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        return layoutParams.height;
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!bg.mA(str)) {
                c.n(this.mContext, str, "game_center_top_banner");
                ai.a(this.mContext, 10, 1017, 1, 7, 0, null, this.mqT, 0, null, null, this.mFM);
            }
        }
    }
}
