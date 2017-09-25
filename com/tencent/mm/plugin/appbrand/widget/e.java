package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends FrameLayout {
    private int RQ = 0;
    public LinearLayout jqJ;
    public ImageView jqK;
    public String jqL;
    public int jqM;
    public int jqN;
    public LinkedList<a> jqO = new LinkedList();
    private int jqP = 0;
    public b jqQ;

    private static class a {
        public Bitmap jqS;
        public String jqT;
        public String mUrl;
        public Bitmap uL;
    }

    public interface b {
        void qi(String str);
    }

    static /* synthetic */ void b(e eVar) {
        if (eVar.jqQ != null) {
            eVar.jqQ.qi(((a) eVar.jqO.get(eVar.jqP)).mUrl);
        }
    }

    public e(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        this.jqK = new ImageView(context);
        this.jqK.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.jqK);
        this.jqJ = new LinearLayout(context);
        this.jqJ.setOrientation(0);
        this.jqJ.setGravity(16);
        this.jqJ.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.jqJ);
    }

    public static Bitmap ri(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public final void iJ(int i) {
        a(this.jqJ.getChildAt(this.jqP), (a) this.jqO.get(this.jqP), false);
        if (i <= 0 || i >= this.jqO.size()) {
            this.jqP = 0;
        } else {
            this.jqP = i;
        }
        a(this.jqJ.getChildAt(this.jqP), (a) this.jqO.get(this.jqP), true);
    }

    public final void a(View view, a aVar, boolean z) {
        ImageView imageView = (ImageView) view.findViewById(R.h.icon);
        TextView textView = (TextView) view.findViewById(R.h.text);
        View findViewById = view.findViewById(R.h.bXz);
        View findViewById2 = view.findViewById(R.h.bXA);
        if ("top".equals(this.jqL)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView.setTextSize(1, 14.0f);
            findViewById2.setVisibility(0);
        } else {
            if (aVar.uL != null && aVar.jqT != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 54), 1.0f));
                imageView.setVisibility(0);
                imageView.getLayoutParams().width = com.tencent.mm.bg.a.fromDPToPix(getContext(), 32);
                imageView.getLayoutParams().height = com.tencent.mm.bg.a.fromDPToPix(getContext(), 28);
                textView.setVisibility(0);
                textView.setTextSize(1, 12.0f);
            } else if (aVar.uL != null && aVar.jqT == null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 48), 1.0f));
                imageView.setVisibility(0);
                imageView.getLayoutParams().width = com.tencent.mm.bg.a.fromDPToPix(getContext(), 36);
                imageView.getLayoutParams().height = com.tencent.mm.bg.a.fromDPToPix(getContext(), 36);
                textView.setVisibility(8);
            } else if (aVar.uL == null && aVar.jqT != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bg.a.fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView.setVisibility(0);
                textView.setTextSize(1, 16.0f);
            }
            findViewById2.setVisibility(8);
        }
        if (!z || aVar.jqS == null) {
            imageView.setImageBitmap(aVar.uL);
        } else {
            imageView.setImageBitmap(aVar.jqS);
        }
        textView.setText(aVar.jqT);
        if (z) {
            textView.setTextColor(this.jqN);
        } else {
            textView.setTextColor(this.jqM);
        }
        if (z) {
            findViewById.setBackgroundColor(this.jqN);
            findViewById.setVisibility(0);
            return;
        }
        findViewById.setVisibility(4);
    }

    public final int rj(String str) {
        Object obj;
        LinkedList linkedList = this.jqO;
        String qW = o.qW(str);
        Iterator it = this.jqO.iterator();
        while (it.hasNext()) {
            obj = (a) it.next();
            if (o.qW(obj.mUrl).equals(qW)) {
                break;
            }
        }
        obj = null;
        return linkedList.indexOf(obj);
    }
}
