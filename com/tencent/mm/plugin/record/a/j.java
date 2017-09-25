package com.tencent.mm.plugin.record.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class j {
    private HashMap<String, String[]> lGk = new HashMap();
    public f<String, Bitmap> lGm = new f(10);
    private HashMap<String, a> oOA = new HashMap();
    public g oOy = new g(this) {
        final /* synthetic */ j oOB;

        {
            this.oOB = r2;
        }

        protected final i g(String str, String str2, int i, int i2) {
            return new o(str, str2, i, i2);
        }
    };
    private HashSet<String> oOz = new HashSet();

    public final void destory() {
        this.oOy.destory();
        this.lGk.clear();
        this.oOz.clear();
        this.oOy = null;
        this.lGk = null;
        this.oOz = null;
    }

    public final boolean a(rm rmVar, long j) {
        String d = m.d(rmVar.lKv, j, true);
        a aVar = (a) this.oOA.get(d);
        if (aVar == null) {
            this.oOA.put(d, new a());
            return true;
        } else if (aVar.se() <= 30000) {
            return false;
        } else {
            aVar.gSO = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public final Bitmap a(rm rmVar, long j, boolean z, boolean z2) {
        if (!com.tencent.mm.compatible.util.f.rZ()) {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }
        String f;
        if (z) {
            f = m.f(rmVar, j);
        } else {
            f = m.c(rmVar, j);
        }
        if (bg.mA(f) || !e.aO(f)) {
            w.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(z), f});
            return null;
        }
        Bitmap bitmap = (Bitmap) this.lGm.get(f);
        if (bitmap != null) {
            return bitmap;
        }
        int i;
        int i2;
        w.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{f});
        Options options = new Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(f, options);
        if (bitmap != null) {
            w.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        Object obj = (!d.bh(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
        Object obj2 = (!d.bg(options.outWidth, options.outHeight) || options.outHeight <= 480) ? null : 1;
        if (obj == null && obj2 == null) {
            i = 960;
            i2 = 960;
        } else {
            i = options.outHeight;
            i2 = options.outWidth;
        }
        int Pc = ExifHelper.Pc(f);
        if (Pc == 90 || Pc == 270) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        bitmap = d.d(f, i, i2, false);
        if (bitmap == null) {
            w.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + f);
            return null;
        }
        bitmap = d.b(bitmap, (float) Pc);
        this.lGm.put(f, bitmap);
        return bitmap;
    }

    public final Bitmap b(rm rmVar, long j) {
        Bitmap a = a(rmVar, j, true, false);
        if (a == null) {
            w.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", new Object[]{Boolean.valueOf(a(rmVar, j))});
            m.b(rmVar, j, r1);
        }
        return a;
    }

    public final void a(ImageView imageView, rm rmVar, long j, String str, int i, int i2, int i3) {
        String str2 = m.vZ(rmVar.lKv) + "@" + String.valueOf(j);
        if (rmVar.lKv != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.lGk.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{m.f(rmVar, j)};
                this.lGk.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.oOy.a(imageView, strArr, str, i, i2, i3);
            if (!this.oOz.contains(str2)) {
                this.oOz.add(str2);
                if (!new File(strArr[0]).exists() && !bg.mA(rmVar.hhy)) {
                    m.b(rmVar, j, a(rmVar, j));
                }
            }
        }
    }
}
