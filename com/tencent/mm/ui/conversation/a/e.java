package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.a.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.b.b.b;
import com.tencent.mm.u.c;

public final class e {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] weM = new int[a.bYQ().length];

        static {
            try {
                weM[a.weO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                weM[a.weP - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                weM[a.weQ - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                weM[a.weR - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                weM[a.weS - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                weM[a.weN - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                weM[a.weT - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                weM[a.weU - 1] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                weM[a.weV - 1] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                weM[a.weW - 1] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                weM[a.weX - 1] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bYQ() {
            return (int[]) weY.clone();
        }

        static {
            weN = 1;
            weO = 2;
            weP = 3;
            weQ = 4;
            weR = 5;
            weS = 6;
            weT = 7;
            weU = 8;
            weV = 9;
            weW = 10;
            weX = 11;
            weY = new int[]{weN, weO, weP, weQ, weR, weS, weT, weU, weV, weW, weX};
        }
    }

    public static com.tencent.mm.pluginsdk.ui.b.a a(Context context, int i, Object[] objArr) {
        boolean z = false;
        String obj;
        String obj2;
        switch (AnonymousClass1.weM[i - 1]) {
            case 1:
                if (objArr == null || objArr.length != 2) {
                    return null;
                }
                obj = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj2 = objArr[1].toString();
                } else {
                    obj2 = null;
                }
                if (ap.yY().xy() == null) {
                    w.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                }
                if (ap.yY().xy() == null) {
                    return null;
                }
                if (ap.yY().xy().gA(obj) || ap.yY().xy().gA(obj2)) {
                    return new f(context, obj, obj2);
                }
                return null;
            case 2:
                if (objArr == null || objArr.length != 3) {
                    return null;
                }
                String obj3;
                boolean z2;
                obj2 = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj3 = objArr[1].toString();
                } else {
                    obj3 = null;
                }
                if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) objArr[2]).booleanValue();
                }
                if ((ap.zb() && ap.yY().xz() != null && ap.yY().xz().gA(obj2)) || ap.yY().xz().gA(obj3)) {
                    return new g(context, obj2, obj3, z2);
                }
                return null;
            case 3:
                return new m(context);
            case 4:
                return new h(context);
            case 5:
                return new a(context);
            case 6:
                ax.zj();
                aw zk = ax.zk();
                if (zk != null) {
                    return new k(context, zk);
                }
                return null;
            case 7:
                com.tencent.mm.u.a.e gu = g.Ae().gu("4");
                if (gu == null) {
                    return null;
                }
                obj = gu.value;
                if (bg.mA(obj) || obj.equals("0")) {
                    return null;
                }
                Object obj4;
                com.tencent.mm.pluginsdk.ui.b.a kVar;
                if (obj.equals("1")) {
                    ap.yY();
                    obj4 = c.vr().get(328195, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        w.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                        return null;
                    }
                    ax.zj();
                    int zl = ax.zl();
                    if (zl == com.tencent.mm.u.ax.a.hmD || zl == com.tencent.mm.u.ax.a.hmE) {
                        w.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        return null;
                    }
                    kVar = new k(context, new aw(1, 1, ""));
                    f.gy("4");
                    return kVar;
                } else if (!obj.equals("2")) {
                    return null;
                } else {
                    ap.yY();
                    obj4 = c.vr().get(328196, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        w.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                        return null;
                    }
                    ax.zj();
                    if (ax.zl() == com.tencent.mm.u.ax.a.hmD) {
                        w.i("MicroMsg.BannerFactory", "already upload the Mobile");
                        return null;
                    }
                    kVar = new k(context, new aw(2, 1, ""));
                    f.gy("4");
                    return kVar;
                }
            case 8:
                return new l(context);
            case 9:
                return new n(context);
            case 10:
                return new j(context);
            case 11:
                b bVar;
                if (objArr == null || objArr.length <= 0) {
                    bVar = b.Main;
                } else {
                    bVar = (b) objArr[0];
                }
                if (bVar == b.Main) {
                    return new com.tencent.mm.ui.e.a(context, bVar);
                }
                return new com.tencent.mm.ui.e.b(context, bVar);
            default:
                return null;
        }
    }
}
