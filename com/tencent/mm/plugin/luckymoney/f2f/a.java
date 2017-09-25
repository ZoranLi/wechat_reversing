package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.media.SoundPool;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class a {
    public SoundPool njl = new SoundPool(2, 3, 0);
    public Hashtable<String, Integer> njm = new Hashtable();
    public Map<Integer, Boolean> njn = new HashMap();
    public volatile boolean njo = false;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set njp;
        final /* synthetic */ WeakReference njq;
        final /* synthetic */ a njr;

        public AnonymousClass1(a aVar, Set set, WeakReference weakReference) {
            this.njr = aVar;
            this.njp = set;
            this.njq = weakReference;
        }

        public final void run() {
            try {
                for (String str : this.njp) {
                    if (this.njq.get() == null || this.njr.njo) {
                        w.i("AsyncSoundPool", "context = null or soundPool is stopped");
                        this.njr.njl.release();
                        this.njr.njm.clear();
                        this.njr.njn.clear();
                        return;
                    }
                    this.njr.njm.put(str, Integer.valueOf(this.njr.njl.load(((Context) this.njq.get()).getResources().getAssets().openFd(str), 0)));
                }
            } catch (Exception e) {
                w.e("AsyncSoundPool", "load sound file error:" + e.getMessage());
            }
        }
    }

    public final void dj(String str) {
        if (this.njm.containsKey(str)) {
            int intValue = ((Integer) this.njm.get(str)).intValue();
            if (intValue >= 0 && this.njn.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.njn.get(Integer.valueOf(intValue))).booleanValue()) {
                this.njl.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }
}
