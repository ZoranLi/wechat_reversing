package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements e, OnClickListener {
    private float jWC = 0.0f;
    private MMDotView kSg;
    private ViewPager kSh;
    private Context mContext;
    int mqT = 0;
    private b mxf;
    LinkedList<a> mxg;
    aj mxh = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ GameBannerView mxj;

        {
            this.mxj = r1;
        }

        public final boolean oQ() {
            if (this.mxj.kSh == null || this.mxj.mxg.size() <= 1) {
                this.mxj.mxh.KH();
                return false;
            }
            this.mxj.kSh.k(this.mxj.kSh.ys + 1, true);
            return true;
        }
    }, true);
    private float mxi = 0.0f;

    public static class a {
        public String hqu;
        public int index;
        public String moB;
        public f mxk;
    }

    private final class b extends u {
        final /* synthetic */ GameBannerView mxj;

        public b(GameBannerView gameBannerView) {
            this.mxj = gameBannerView;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            int size = i % this.mxj.mxg.size();
            viewGroup.removeView((View) obj);
            w.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
        }

        public final Object b(ViewGroup viewGroup, int i) {
            int size = i % this.mxj.mxg.size();
            View inflate = View.inflate(this.mxj.mContext, R.i.dec, null);
            inflate.setTag(this.mxj.mxg.get(size));
            inflate.setOnClickListener(this.mxj);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.bSB);
            String str = ((a) this.mxj.mxg.get(size)).hqu;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof i)) {
                imageView.setImageDrawable(new i(str));
            } else {
                ((i) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e) {
                w.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
            }
            w.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
            return inflate;
        }

        public final int getCount() {
            return this.mxj.mxg.size() <= 1 ? this.mxj.mxg.size() : (this.mxj.mxg.size() * 1000) * 2;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        inflate(context, R.i.deb, this);
        this.mxg = new LinkedList();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.kSg = (MMDotView) findViewById(R.h.bSz);
        this.kSh = (ViewPager) findViewById(R.h.bSA);
        this.kSh.zb = this;
        this.mxf = new b(this);
    }

    public final void Q(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            w.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            return;
        }
        w.i("MicroMsg.GameBannerView", "bannerList size", new Object[]{Integer.valueOf(linkedList.size())});
        this.mxh.KH();
        this.mxg.clear();
        this.mxg.addAll(linkedList);
        this.kSh.a(this.mxf);
        this.kSh.k(linkedList.size() * 1000, false);
        if (this.mxg.size() > 1) {
            this.mxh.v(5000, 5000);
        }
        this.kSg.setVisibility(8);
        setVisibility(0);
    }

    public final void W(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void V(int i) {
        int size = i % this.mxg.size();
        w.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
        if (((a) this.mxg.get(size)).mxk != null && ap.zb()) {
            ai.a(this.mContext, 11, 1101, size + 1, 1, this.mqT, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.mxi = rawX;
                this.jWC = rawY;
                break;
            case 1:
            case 3:
                eH(false);
                this.mxi = 0.0f;
                this.jWC = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.mxi)) > Math.abs((int) (rawY - this.jWC))) {
                    eH(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mxh.KH();
                break;
            case 1:
            case 3:
                this.mxh.v(5000, 5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void eH(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.mxk;
            if (bg.mA(aVar.moB)) {
                w.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                ai.a(this.mContext, 11, 1101, 1, c.a(this.mContext, fVar.field_appId, null, bundle), this.mqT, null);
                return;
            }
            String str = aVar.moB;
            Intent intent = new Intent();
            c.aa(this.mContext, str);
            ai.a(this.mContext, 11, 1101, 1, 7, this.mqT, null);
        }
    }
}
