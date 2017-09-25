package com.tencent.mm.plugin.z.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Set;

public final class a {
    Set<Integer> fTc;
    boolean il = false;
    a oGa = null;
    long oGb = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String oGc;
        final /* synthetic */ a oGd;

        AnonymousClass1(a aVar, String str) {
            this.oGd = aVar;
            this.oGc = str;
        }

        public final void run() {
            new b(this.oGd).execute(new String[]{this.oGc});
        }
    }

    public interface a {
        int a(d dVar);
    }

    class b extends AsyncTask<String, Integer, d> {
        final /* synthetic */ a oGd;

        b(a aVar) {
            this.oGd = aVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return w((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (this.oGd.oGa != null) {
                this.oGd.oGa.a(dVar);
            }
        }

        private d w(String... strArr) {
            d dVar = null;
            w.d("dktest", "doInBackground :" + strArr);
            if (strArr != null && strArr.length == 1) {
                try {
                    this.oGd.oGb = System.currentTimeMillis();
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    dVar = this.oGd.Dc(strArr[0]);
                    w.d("MicroMsg.scanner.DecodeFile", "time: " + aVar.se());
                } catch (OutOfMemoryError e) {
                    w.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", new Object[]{""});
                }
            }
            return dVar;
        }
    }

    final d Dc(String str) {
        OutOfMemoryError e;
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            return null;
        }
        Options Pe = d.Pe(str);
        if (Pe != null) {
            Pe.inJustDecodeBounds = false;
            Pe.inPreferredConfig = Config.RGB_565;
        }
        if (this.il) {
            return null;
        }
        d a;
        try {
            Bitmap decodeFile = d.decodeFile(str, Pe);
            if (decodeFile == null) {
                w.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                return null;
            }
            com.tencent.mm.plugin.scanner.util.d dVar = new com.tencent.mm.plugin.scanner.util.d(null, 0, false);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a = a(dVar, decodeFile, 3);
            l.oWo.aYc();
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            w.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):" + elapsedRealtime);
            if (a == null || bg.mA(a.result)) {
                if (elapsedRealtime == 0) {
                    elapsedRealtime = 1;
                }
                w.i("MicroMsg.scanner.DecodeFile", "max retry time: %s", new Object[]{Integer.valueOf((int) (20000 / elapsedRealtime))});
                for (int i = 1; i < r3 && !this.il; i++) {
                    int i2 = (i * 8) + 3;
                    if (i2 >= decodeFile.getWidth() || i2 >= decodeFile.getHeight() || System.currentTimeMillis() - this.oGb > 5000) {
                        break;
                    }
                    a = a(dVar, decodeFile, i2);
                    l.oWo.aYc();
                    if (a != null && !bg.mA(a.result)) {
                        w.d("MicroMsg.scanner.DecodeFile", "Decode file done, i = %d, max times = %d, width = %d, height = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(r3), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight())});
                        break;
                    }
                }
            }
            dVar.aKx();
            try {
                String str2 = "MicroMsg.scanner.DecodeFile";
                String str3 = "decode result==null:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(a == null);
                w.d(str2, str3, objArr);
                return (a == null || bg.mA(a.result)) ? a : a;
            } catch (OutOfMemoryError e2) {
                e = e2;
                w.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
                return a;
            }
        } catch (OutOfMemoryError e3) {
            OutOfMemoryError outOfMemoryError = e3;
            a = null;
            e = outOfMemoryError;
            w.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
            return a;
        }
    }

    private d a(com.tencent.mm.plugin.scanner.util.d dVar, Bitmap bitmap, int i) {
        c.a fVar = new f(bitmap, i, i);
        if (fVar.aYY() == null || fVar.width <= 0 || fVar.height <= 0) {
            return null;
        }
        return dVar.a(fVar, this.fTc);
    }
}
