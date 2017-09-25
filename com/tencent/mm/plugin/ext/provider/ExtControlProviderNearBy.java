package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bj.d;
import com.tencent.mm.e.a.ji;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements a {
    private static final UriMatcher lrc;
    private static boolean lre = false;
    private static aj lrf = new aj(new aj.a() {
        public final boolean oQ() {
            ExtControlProviderNearBy.lre = false;
            return false;
        }
    }, false);
    private static final String[] tl = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private boolean aJo;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ExtControlProviderNearBy lrg;

        {
            this.lrg = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!this.lrg.lrd) {
                this.lrg.lrd = true;
                if (z) {
                    b jiVar = new ji();
                    jiVar.fPD.fJA = this.lrg.lqV;
                    jiVar.fPD.fPF = f;
                    jiVar.fPD.fOb = f2;
                    jiVar.fPD.fPG = (int) d2;
                    jiVar.fPD.fPH = i;
                    jiVar.fPD.fPI = "";
                    jiVar.fPD.fPJ = "";
                    if (com.tencent.mm.sdk.b.a.urY.m(jiVar)) {
                        w.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                } else {
                    w.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.f(this.lrg);
                    this.lrg.lqZ.countDown();
                }
            }
            return false;
        }
    };
    private c hvP;
    private com.tencent.mm.pluginsdk.e.b ktI = new com.tencent.mm.pluginsdk.e.b(this) {
        final /* synthetic */ ExtControlProviderNearBy lrg;

        {
            this.lrg = r2;
        }

        public final void a(int i, int i2, String str, b bVar) {
            if ((bVar instanceof ji) && this.lrg.lqZ != null) {
                ji jiVar = (ji) bVar;
                w.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
                if (i == 0 && i2 == 0) {
                    this.lrg.lqW = jiVar.fPE.fPL;
                    if (this.lrg.lqW == null || this.lrg.lqW.size() == 0) {
                        w.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        this.lrg.lqZ.countDown();
                    } else {
                        if (this.lrg.lqW.size() > 10) {
                            w.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + this.lrg.lqW.size());
                            this.lrg.lqW.subList(10, this.lrg.lqW.size()).clear();
                        }
                        this.lrg.lra = new CountDownLatch(this.lrg.lqW.size());
                        this.lrg.lqZ.countDown();
                        ExtControlProviderNearBy.e(this.lrg);
                    }
                } else {
                    w.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                    this.lrg.lqZ.countDown();
                }
                ExtControlProviderNearBy.f(this.lrg);
            }
        }
    };
    private int lqV;
    private List<aiw> lqW;
    private d lqX;
    private Set<String> lqY;
    private CountDownLatch lqZ;
    private CountDownLatch lra;
    private aiw lrb;
    private boolean lrd = false;

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        n.Bl().a(extControlProviderNearBy);
        if (extControlProviderNearBy.lqX == null) {
            extControlProviderNearBy.lqX = new d(tl, (byte) 0);
        }
        for (aiw a : extControlProviderNearBy.lqW) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.lra.countDown();
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        w.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (ap.zb()) {
            com.tencent.mm.pluginsdk.e.b.b(ji.class.getName(), extControlProviderNearBy.ktI);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.hvP != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.v(str, str2, objArr);
            if (extControlProviderNearBy.hvP != null) {
                extControlProviderNearBy.hvP.c(extControlProviderNearBy.gKp);
                return;
            }
            return;
        }
        w.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lrc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        lrc.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        lrc.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    }

    private static void dO(boolean z) {
        if (z) {
            lre = true;
            lrf.v(15000, 15000);
            return;
        }
        lrf.v(0, 0);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.ExtControlProviderNearBy", "query() " + uri);
        a(uri, getContext(), 15);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (lre) {
            w.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            md(5);
            return null;
        } else {
            dO(true);
            if (!acK()) {
                dO(false);
                md(1);
                return this.jPp;
            } else if (bW(getContext())) {
                w.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.lqV);
                getType(uri);
                if (this.lqV < 0) {
                    w.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    dO(false);
                    md(3);
                    return null;
                }
                try {
                    this.lqW = new ArrayList();
                    this.lqX = new d(tl, (byte) 0);
                    this.lqZ = new CountDownLatch(1);
                    this.lra = null;
                    this.lqY = new HashSet();
                    this.lqW = new ArrayList();
                    this.aJo = false;
                    w.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (ap.zb()) {
                        com.tencent.mm.pluginsdk.e.b.a(ji.class.getName(), this.ktI);
                        af.v(new Runnable(this) {
                            final /* synthetic */ ExtControlProviderNearBy lrg;

                            {
                                this.lrg = r1;
                            }

                            public final void run() {
                                if (this.lrg.hvP == null) {
                                    this.lrg.hvP = c.Gk();
                                }
                                this.lrg.hvP.a(this.lrg.gKp, true);
                            }
                        });
                    } else {
                        w.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    w.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.lqZ.await(15000, TimeUnit.MILLISECONDS)) {
                        w.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.lra != null) {
                        w.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.lra.await(15000, TimeUnit.MILLISECONDS)) {
                            w.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        w.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Throwable e) {
                    w.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    w.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e, "", new Object[0]);
                    md(4);
                }
                dO(false);
                n.Bl().b(this);
                this.aJo = true;
                arb();
                if (this.lqX == null || this.lqX.getCount() <= 0) {
                    md(4);
                } else {
                    md(0);
                }
                w.i("MicroMsg.ExtControlProviderNearBy", "return now");
                return this.lqX;
            } else {
                w.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                dO(false);
                md(2);
                return null;
            }
        }
    }

    private aiw vC(String str) {
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            return null;
        }
        for (aiw com_tencent_mm_protocal_c_aiw : this.lqW) {
            if (com_tencent_mm_protocal_c_aiw.jNj.equals(str)) {
                return com_tencent_mm_protocal_c_aiw;
            }
        }
        return null;
    }

    private void a(aiw com_tencent_mm_protocal_c_aiw) {
        if (com_tencent_mm_protocal_c_aiw == null || com_tencent_mm_protocal_c_aiw.jNj == null) {
            w.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            return;
        }
        this.lqY.add(com_tencent_mm_protocal_c_aiw.jNj);
        Bitmap a = com.tencent.mm.x.b.a(com_tencent_mm_protocal_c_aiw.jNj, false, -1);
        w.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.lra.getCount());
        if (a != null) {
            w.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.lqY.remove(com_tencent_mm_protocal_c_aiw.jNj);
            this.lqX.addRow(new Object[]{com_tencent_mm_protocal_c_aiw.jOp, bArr, com_tencent_mm_protocal_c_aiw.tMO, com_tencent_mm_protocal_c_aiw.hAG, Integer.valueOf(com_tencent_mm_protocal_c_aiw.hAD)});
            w.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
    }

    public final void ho(String str) {
        w.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + str);
        if (this.aJo) {
            w.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            return;
        }
        a(vC(str));
        this.lra.countDown();
    }

    private void arb() {
        if (this.lqY.size() > 0) {
            for (String str : this.lqY) {
                w.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
                this.lrb = vC(str);
                if (!(this.lrb == null || this.lrb.jNj == null)) {
                    this.lqX.addRow(new Object[]{this.lrb.jOp, null, this.lrb.tMO, this.lrb.hAG, Integer.valueOf(this.lrb.hAD)});
                }
            }
            return;
        }
        w.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    }

    public final String getType(Uri uri) {
        this.lqV = -1;
        switch (lrc.match(uri)) {
            case 0:
                this.lqV = 1;
                break;
            case 1:
                this.lqV = 3;
                break;
            case 2:
                this.lqV = 4;
                break;
            default:
                this.lqV = -1;
                break;
        }
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
