package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.x.d;
import com.tencent.mm.x.e;
import com.tencent.mm.x.n;

public final class f {
    private static final Drawable num = new ColorDrawable();
    private Activity activity;
    private String iGg;
    public o nul;
    private GetHdHeadImageGalleryView nun;
    public e piU;
    private String sIM;
    public b sIN;
    private int sIO;
    public String username;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] sIQ = new int[a.bEg().length];

        static {
            try {
                sIQ[a.sIR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                sIQ[a.sIS - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                sIQ[a.sIT - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bEg() {
            return (int[]) sIU.clone();
        }

        static {
            sIR = 1;
            sIS = 2;
            sIT = 3;
            sIU = new int[]{sIR, sIS, sIT};
        }
    }

    public interface b {
    }

    public f(Activity activity, String str) {
        this(activity, str, null);
    }

    public f(Activity activity, String str, String str2) {
        this(activity, str, str2, a.sIR);
    }

    public f(Activity activity, String str, String str2, int i) {
        this(activity, str, str2, i, (byte) 0);
    }

    private f(Activity activity, String str, String str2, int i, byte b) {
        this.sIM = null;
        this.iGg = null;
        this.activity = activity;
        this.username = str;
        this.iGg = str2;
        this.sIN = null;
        this.sIO = i;
    }

    public final void bEf() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.i.dfx, null);
        this.nul = new o(inflate, -1, -1);
        switch (AnonymousClass2.sIQ[this.sIO - 1]) {
            case 1:
                this.nul.setAnimationStyle(R.m.foC);
                break;
            case 2:
                this.nul.setAnimationStyle(R.m.foD);
                break;
            case 3:
                this.nul.setAnimationStyle(R.m.foB);
                break;
        }
        this.nul.setFocusable(true);
        this.nul.setOutsideTouchable(true);
        this.nul.setBackgroundDrawable(num);
        this.nul.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.nun = (GetHdHeadImageGalleryView) inflate.findViewById(R.h.bSr);
        this.nun.sIE = this.nul;
        this.nun.username = this.username;
        ap.yY();
        if (c.isSDCardAvailable()) {
            Bitmap b = !bg.mA(this.iGg) ? l.b(this.username, this.iGg, R.g.bhR) : com.tencent.mm.x.b.a(this.username, true, -1);
            if (b == null) {
                b = BitmapFactory.decodeResource(this.activity.getResources(), R.g.bes);
            }
            if (b == null || b.isRecycled()) {
                w.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                w.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.nun.setThumbImage(b);
            }
            if (!bg.mA(this.sIM)) {
                this.username = this.sIM;
            }
            n.Bl();
            Bitmap hl = d.hl(this.username);
            if (hl == null || hl.isRecycled()) {
                this.piU = new e();
                this.piU.a(this.username, new com.tencent.mm.x.e.b(this) {
                    final /* synthetic */ f sIP;

                    public final int aM(int i, int i2) {
                        this.sIP.piU.Bp();
                        w.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        b bVar;
                        String str;
                        if (i == 0 && i2 == 0) {
                            n.Bl();
                            Bitmap hl = d.hl(this.sIP.username);
                            if (hl != null) {
                                f fVar = this.sIP;
                                n.Bl();
                                fVar.c(hl, d.r(this.sIP.username, true));
                            } else {
                                this.sIP.c(b, null);
                            }
                            if (this.sIP.sIN != null) {
                                bVar = this.sIP.sIN;
                                str = this.sIP.username;
                            }
                        } else {
                            this.sIP.c(b, null);
                            if (this.sIP.sIN != null) {
                                bVar = this.sIP.sIN;
                                str = this.sIP.username;
                            }
                        }
                        return 0;
                    }
                });
                return;
            }
            w.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            n.Bl();
            c(hl, d.r(this.username, true));
            return;
        }
        s.eP(this.activity);
        c(n.Bl().aS(this.activity), null);
    }

    public final void c(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            w.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.nun.H(createBitmap);
            this.nun.piV = str;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GetHdHeadImg", e, "", new Object[0]);
        }
    }
}
