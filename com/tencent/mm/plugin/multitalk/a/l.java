package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public Map<String, a> nQp = Collections.synchronizedMap(new HashMap());

    private class a {
        public int angle;
        public int nQa;
        Bitmap nQq;
        Bitmap nQr;
        public Bitmap nQs;
        final /* synthetic */ l nQt;
        String username;

        public a(l lVar) {
            this.nQt = lVar;
        }
    }

    public final synchronized boolean a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3, int i4) {
        boolean z;
        if (multiTalkVideoView == null) {
            w.e("MicroMsg.MT.MultiTalkViewManager", "drawVideo view is null");
            z = false;
        } else if (iArr == null) {
            w.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
            z = false;
        } else if (iArr.length < i * i2) {
            w.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(i * i2)});
            z = false;
        } else if (i != i2) {
            w.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
            z = false;
        } else {
            a aVar;
            a aVar2 = (a) this.nQp.get(multiTalkVideoView.username);
            if (aVar2 == null) {
                aVar2 = new a(this);
                this.nQp.put(multiTalkVideoView.username, aVar2);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
            aVar.nQa = i3;
            aVar.angle = i4;
            if (aVar.nQs == null || aVar.nQs.getWidth() != i2) {
                aVar.nQs = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
            }
            aVar.nQs.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            multiTalkVideoView.a(aVar.nQs, aVar.angle, aVar.nQa);
            z = true;
        }
        return z;
    }

    public final boolean a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        if (multiTalkVideoView == null) {
            w.e("MicroMsg.MT.MultiTalkViewManager", "drawAvatar view is null");
            return false;
        }
        a aVar;
        if (this.nQp.containsKey(multiTalkVideoView.username)) {
            aVar = (a) this.nQp.get(multiTalkVideoView.username);
        } else {
            aVar = new a(this);
            aVar.username = multiTalkVideoView.username;
            this.nQp.put(multiTalkVideoView.username, aVar);
        }
        Bitmap a;
        if (aVar.nQq == null) {
            a = b.bEa().a(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (a != null && a.getHeight() < a.getWidth()) {
                a = Bitmap.createBitmap(a, 0, 0, a.getHeight(), a.getHeight());
            }
            aVar.nQq = a;
        } else if (z) {
            a = b.bEa().a(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (a != null && a.getHeight() < a.getWidth()) {
                a = Bitmap.createBitmap(a, 0, 0, a.getHeight(), a.getHeight());
            }
            aVar.nQq = a;
        }
        if (aVar.nQq != null) {
            multiTalkVideoView.a(aVar.nQq, 0, 0);
            return true;
        }
        if (aVar.nQr == null) {
            aVar.nQr = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), R.g.bhl);
        }
        multiTalkVideoView.a(aVar.nQr, 0, 0);
        return true;
    }

    public final void aNh() {
        this.nQp.clear();
    }
}
