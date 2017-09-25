package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements com.tencent.mm.platformtools.j.a, e {
    private long fGM;
    private c gKi;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ProductUI oZO;

        {
            this.oZO = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                w.i("MicroMsg.scanner.ProductUI", "getLocation suc");
                if (this.oZO.oZw != null) {
                    w.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                    ap.vd().a(new com.tencent.mm.plugin.scanner.a.c(this.oZO.kMS, k.bj(this.oZO.oZw.per), this.oZO.hPi, this.oZO.oZE, (double) f, (double) f2), 0);
                }
                if (this.oZO.gKi != null) {
                    this.oZO.gKi.c(this.oZO.gKp);
                }
                if (!this.oZO.hvS) {
                    this.oZO.hvS = true;
                    n.a(2011, f, f2, (int) d2);
                }
                return false;
            }
            w.w("MicroMsg.scanner.ProductUI", "getLocation fail");
            return false;
        }
    };
    private int hPi;
    private boolean hvS = false;
    private com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
        final /* synthetic */ ProductUI oZO;

        {
            this.oZO = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((jc) bVar).fPc.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    if (this.oZO.isJ != null) {
                        this.oZO.aYH();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private TextView ioX;
    protected f isJ;
    protected ProgressDialog isv = null;
    private String kMS;
    private long mStartTime;
    private List<MusicPreference> nSU;
    private a oZA;
    private boolean oZB = false;
    private HashMap<String, Boolean> oZC;
    private com.tencent.mm.plugin.scanner.ui.e.a oZD;
    private String oZE;
    private boolean oZF = false;
    private String oZG;
    private boolean oZH = false;
    private boolean oZI = false;
    private boolean oZJ = false;
    private com.tencent.mm.plugin.scanner.history.a.a oZK;
    private com.tencent.mm.u.bp.a oZL = new com.tencent.mm.u.bp.a(this) {
        final /* synthetic */ ProductUI oZO;

        {
            this.oZO = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            String a = com.tencent.mm.platformtools.n.a(aVar.hst.tff);
            w.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            com.tencent.mm.plugin.scanner.util.n.a a2 = this.oZO.oZw;
            if (!(a2 == null || bg.mA(a))) {
                Map q = bh.q(a, "sysmsg");
                a = (String) q.get(".sysmsg.scanproductinfo.product.id");
                if (bg.mA(a2.field_productid) || !a2.field_productid.equals(a)) {
                    w.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + bg.mz(a) + ", target=" + a2.field_productid);
                } else {
                    List j = com.tencent.mm.plugin.scanner.a.a.j(q, ".sysmsg.scanproductinfo.product");
                    Map hashMap = new HashMap();
                    for (int i = 0; i < j.size(); i++) {
                        List list = ((com.tencent.mm.plugin.scanner.a.a) j.get(i)).hSY;
                        if (list != null) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) list.get(i2);
                                if (aVar2 != null) {
                                    hashMap.put(aVar2.arH, aVar2);
                                }
                            }
                        }
                    }
                    w.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    k.b(a2.per, hashMap);
                }
            }
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass9 oZT;

                {
                    this.oZT = r1;
                }

                public final void run() {
                    this.oZT.oZO.b(this.oZT.oZO.oZw);
                }
            });
        }
    };
    private com.tencent.mm.plugin.scanner.ui.MusicPreference.a oZM = new com.tencent.mm.plugin.scanner.ui.MusicPreference.a(this) {
        final /* synthetic */ ProductUI oZO;

        {
            this.oZO = r1;
        }

        public final void a(MusicPreference musicPreference) {
            if (musicPreference == null) {
                w.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
            } else if (bg.mA(musicPreference.oVO) && bg.mA(musicPreference.oVP)) {
                w.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
                if (!bg.mA(musicPreference.oVQ)) {
                    this.oZO.DM(musicPreference.oVQ);
                }
            } else {
                if (ProductUI.DJ(String.format("%s_cd_%s", new Object[]{musicPreference.oVO, musicPreference.igL}))) {
                    com.tencent.mm.am.b.HH();
                    w.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[]{r1});
                } else if (musicPreference.getTitle() == null) {
                    w.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                    return;
                } else {
                    String str;
                    int i = -1;
                    if (this.oZO.oZA == null) {
                        str = null;
                    } else {
                        str = this.oZO.oZA.Nm();
                    }
                    String format = String.format("%s_cd_%s", new Object[]{musicPreference.oVO, musicPreference.igL});
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (MusicPreference musicPreference2 : this.oZO.nSU) {
                        int i3;
                        String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.oVO, musicPreference2.igL});
                        if (format.equals(format2)) {
                            i3 = i2;
                        } else {
                            i3 = i;
                        }
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(((com.tencent.mm.am.a.a) h.h(com.tencent.mm.am.a.a.class)).a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.oVQ, musicPreference2.oVP, musicPreference2.oVO, format2, com.tencent.mm.plugin.scanner.c.xv(), str, "", "wx482a4001c37e2b74"));
                        i2++;
                        i = i3;
                    }
                    if (i >= 0) {
                        com.tencent.mm.sdk.b.b jbVar = new jb();
                        jbVar.fOW.action = 0;
                        jbVar.fOW.fKC = arrayList;
                        jbVar.fOW.fOZ = i;
                        com.tencent.mm.sdk.b.a.urY.m(jbVar);
                    } else {
                        return;
                    }
                }
                this.oZO.aYH();
            }
        }
    };
    private boolean oZN = true;
    private ImageView oZn;
    private ImageView oZo;
    private View oZp;
    private TextView oZq;
    private ImageView oZr;
    private View oZs;
    private TextView oZt;
    private LinearLayout oZu;
    private ImageView oZv;
    private com.tencent.mm.plugin.scanner.util.n.a oZw;
    private View oZx;
    private int oZy = 0;
    private int oZz;

    public static final class a implements i {
        private com.tencent.mm.plugin.scanner.util.n.a oZw;

        public a(com.tencent.mm.plugin.scanner.util.n.a aVar) {
            this.oZw = aVar;
        }

        public final String Nm() {
            return com.tencent.mm.plugin.scanner.c.aXW().dl(this.oZw.field_thumburl, "@S");
        }

        public final String Nn() {
            if (this.oZw == null) {
                return "";
            }
            return this.oZw.field_thumburl;
        }

        public final String No() {
            if (this.oZw == null) {
                return "";
            }
            return this.oZw.field_thumburl;
        }

        public final String Np() {
            if (this.oZw == null) {
                return "";
            }
            return this.oZw.field_thumburl;
        }

        public final boolean Nq() {
            return false;
        }

        public final boolean Nr() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
            if (com.tencent.mm.platformtools.i.a.ihH == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, Nm(), false);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
                }
            }
            return bitmap;
        }

        public final void Nt() {
        }

        public final void F(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final Bitmap Ns() {
            if (ab.getContext() == null) {
                return null;
            }
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }

        public final com.tencent.mm.platformtools.i.b Nl() {
            return null;
        }
    }

    private final class b {
        int Sa = ProductUI.u(this.oZO);
        final /* synthetic */ ProductUI oZO;
        ProductScrollView oZU = ((ProductScrollView) this.oZO.findViewById(R.h.ctu));
        boolean oZV;
        private com.tencent.mm.plugin.scanner.ui.ProductScrollView.a oZW = new com.tencent.mm.plugin.scanner.ui.ProductScrollView.a(this) {
            final /* synthetic */ b oZX;

            {
                this.oZX = r1;
            }

            public final void aqr() {
                float f = 1.0f;
                b bVar = this.oZX;
                int scrollY = bVar.oZU.getScrollY();
                float x = scrollY < 0 ? -1.0f : (scrollY >= bVar.oZO.oZz - bVar.Sa || ((float) bVar.oZO.oZz) == 0.0f) ? 1.0f : (((float) scrollY) * 1.37f) / ((float) bVar.oZO.oZz);
                w.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=" + x);
                if (x != 1.0f) {
                    bVar.oZV = false;
                } else if (!bVar.oZV) {
                    bVar.oZV = true;
                } else {
                    return;
                }
                if (bVar.oZO.oZu != null) {
                    float f2 = (1.0f - x) - 0.2f;
                    if (f2 <= 0.0f) {
                        f2 = 0.0f;
                    }
                    if (x == 0.0f) {
                        f2 = 1.0f;
                    }
                    ProductUI.j(bVar.oZO.oZu, f2);
                }
                if (bVar.oZO.oZx != null) {
                    if (x == 0.0f) {
                        f = 0.0f;
                    } else if (x >= 0.0f) {
                        x += 0.2f;
                        if (x <= 1.0f) {
                            f = x;
                        }
                    }
                    ProductUI.j(bVar.oZO.oZx, f);
                }
            }
        };

        public b(ProductUI productUI) {
            this.oZO = productUI;
        }
    }

    static /* synthetic */ void b(ProductUI productUI, com.tencent.mm.plugin.scanner.util.n.a aVar) {
        if (aVar == null || bg.mA(aVar.field_thumburl)) {
            w.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            return;
        }
        try {
            productUI.oZp.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!bg.mA(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.oZx.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            w.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        w.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a = j.a(productUI.oZA);
        if (a != null) {
            productUI.oZn.setImageBitmap(a);
            productUI.oZn.setBackgroundDrawable(null);
            productUI.oZn.setBackgroundColor(-1);
            productUI.oZB = true;
            productUI.aYG();
        } else {
            productUI.oZn.setImageBitmap(null);
        }
        if (!bg.mA(aVar.field_headerbackgroundurl)) {
            a = j.a(new o(aVar.field_headerbackgroundurl));
            if (a != null && !a.isRecycled()) {
                productUI.oZo.setImageBitmap(a);
            }
        }
    }

    static /* synthetic */ void j(ProductUI productUI) {
        if (productUI.oZw == null) {
            return;
        }
        if (!bg.mA(productUI.oZw.field_detailurl)) {
            productUI.al(10000, productUI.oZw.field_detailurl);
            productUI.DM(productUI.oZw.field_detailurl);
        } else if (!bg.mA(productUI.oZw.field_xml) && productUI.oZF) {
            productUI.al(CdnLogic.MediaType_FAVORITE_FILE, "");
            Intent intent = new Intent();
            intent.setClass(productUI, ProductFurtherInfoUI.class);
            intent.putExtra("key_Product_xml", productUI.oZw.field_xml);
            intent.putExtra("key_title", productUI.oZG);
            productUI.startActivity(intent);
        }
    }

    static /* synthetic */ void l(ProductUI productUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(R.l.fnv));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(R.l.fnu));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(R.l.eGa));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(R.l.dGB);
            linkedList.add(productUI.getString(R.l.ehz));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.oZw == null || TextUtils.isEmpty(productUI.oZw.field_exposeurl))) {
            linkedList.add(productUI.getString(R.l.dYa));
            linkedList2.add(Integer.valueOf(4));
        }
        g.a(productUI, "", linkedList, linkedList2, str, false, new g.d(productUI) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final void bN(int i, int i2) {
                if (this.oZO.oZw != null) {
                    Intent intent;
                    switch (i2) {
                        case -1:
                            g.a(this.oZO.uSU.uTo, this.oZO.uSU.uTo.getString(R.l.dGC), null, null, this.oZO.uSU.uTo.getString(R.l.dGB), new g.d(this) {
                                final /* synthetic */ AnonymousClass6 oZQ;

                                {
                                    this.oZQ = r1;
                                }

                                public final void bN(int i, int i2) {
                                    switch (i2) {
                                        case -1:
                                            com.tencent.mm.sdk.b.b byVar = new by();
                                            byVar.fFv.fFx = this.oZQ.oZO.getIntent().getLongExtra("key_favorite_local_id", -1);
                                            com.tencent.mm.sdk.b.a.urY.m(byVar);
                                            w.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[]{Long.valueOf(byVar.fFv.fFx), Boolean.valueOf(byVar.fFw.fFj)});
                                            if (byVar.fFw.fFj) {
                                                this.oZQ.oZO.finish();
                                                return;
                                            }
                                            return;
                                        default:
                                            w.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                            return;
                                    }
                                }
                            });
                            return;
                        case 0:
                            com.tencent.mm.plugin.report.service.g.oUh.i(11446, new Object[]{this.oZO.oZw.field_productid, Integer.valueOf(2)});
                            if (this.oZO.hPi == 3) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0)});
                            }
                            intent = new Intent();
                            intent.putExtra("KContentObjDesc", this.oZO.oZw.field_subtitle);
                            intent.putExtra("Ksnsupload_title", this.oZO.oZw.field_title);
                            intent.putExtra("Ksnsupload_link", this.oZO.oZw.field_shareurl);
                            intent.putExtra("Ksnsupload_appname", com.tencent.mm.plugin.scanner.util.n.D(this.oZO, this.oZO.oZw.field_type));
                            intent.putExtra("Ksnsupload_appid", com.tencent.mm.plugin.scanner.a.i.sc(this.oZO.oZw.field_functionType));
                            intent.putExtra("Ksnsupload_imgurl", this.oZO.oZw.field_thumburl);
                            w.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + this.oZO.oZw.field_thumburl);
                            if (this.oZO.oZA != null) {
                                intent.putExtra("KsnsUpload_imgPath", this.oZO.oZA.Nm());
                            } else {
                                w.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                            }
                            intent.putExtra("Ksnsupload_type", 3);
                            intent.putExtra("KUploadProduct_UserData", com.tencent.mm.plugin.scanner.util.n.c(this.oZO.oZw));
                            intent.putExtra("KUploadProduct_subType", this.oZO.oZw.field_type);
                            String fQ = q.fQ("scan_product");
                            q.yC().n(fQ, true).l("prePublishId", "scan_product");
                            intent.putExtra("reportSessionId", fQ);
                            com.tencent.mm.bb.d.b(this.oZO, "sns", ".ui.En_c4f742e5", intent);
                            return;
                        case 1:
                            com.tencent.mm.plugin.report.service.g.oUh.i(11446, new Object[]{this.oZO.oZw.field_productid, Integer.valueOf(1)});
                            String a = com.tencent.mm.plugin.scanner.a.i.a(this.oZO.uSU.uTo, this.oZO.oZw);
                            Intent intent2 = new Intent();
                            intent2.putExtra("Retr_Msg_content", a);
                            intent2.putExtra("Retr_Msg_Type", 2);
                            if (this.oZO.oZA != null) {
                                intent2.putExtra("Retr_Msg_thumb_path", this.oZO.oZA.Nm());
                            } else {
                                w.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                            }
                            intent2.putExtra("Retr_go_to_chattingUI", false);
                            intent2.putExtra("Retr_show_success_tips", true);
                            com.tencent.mm.plugin.scanner.b.imv.l(intent2, this.oZO);
                            if (this.oZO.hPi == 3) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(0)});
                                return;
                            }
                            return;
                        case 2:
                            com.tencent.mm.plugin.report.service.g.oUh.i(11446, new Object[]{this.oZO.oZw.field_productid, Integer.valueOf(3)});
                            ProductUI.p(this.oZO);
                            return;
                        case 3:
                            intent = new Intent();
                            intent.putExtra("key_fav_scene", 2);
                            intent.putExtra("key_fav_item_id", this.oZO.getIntent().getLongExtra("key_favorite_local_id", -1));
                            com.tencent.mm.bb.d.b(this.oZO.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent);
                            return;
                        case 4:
                            intent = new Intent();
                            intent.putExtra("rawUrl", this.oZO.oZw.field_exposeurl);
                            com.tencent.mm.bb.d.b(this.oZO.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    static /* synthetic */ void p(ProductUI productUI) {
        if (productUI.oZw == null) {
            w.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            return;
        }
        com.tencent.mm.sdk.b.b cbVar = new cb();
        rv rvVar = new rv();
        rw rwVar = new rw();
        ru ruVar = new ru();
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(8);
        rwVar.ep(bg.Nz());
        rwVar.OJ(com.tencent.mm.plugin.scanner.a.i.sc(productUI.oZw.field_functionType));
        ruVar.Ow(productUI.oZw.field_title);
        ruVar.Ox(productUI.oZw.field_subtitle);
        ruVar.yg(productUI.oZw.field_type);
        ruVar.Oz(com.tencent.mm.plugin.scanner.util.n.c(productUI.oZw));
        ruVar.Oy(productUI.oZw.field_thumburl);
        cbVar.fFA.title = productUI.oZw.field_title;
        cbVar.fFA.desc = productUI.oZw.field_subtitle;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 10;
        rvVar.a(rwVar);
        rvVar.b(ruVar);
        cbVar.fFA.fFH = 11;
        cbVar.fFA.activity = productUI;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    static /* synthetic */ int u(ProductUI productUI) {
        TypedValue typedValue = new TypedValue();
        return productUI.getTheme().resolveAttribute(R.d.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics()) : 0;
    }

    protected final int getLayoutId() {
        return R.i.csD;
    }

    public final int ON() {
        return R.o.ftT;
    }

    public final int aeq() {
        return R.i.dkY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = bg.Ny();
        this.hPi = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        j.b(this);
        ap.getSysCmdMsgExtension().a("scanproductinfo", this.oZL, true);
        KC();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(1063, this);
        ap.vd().a(1068, this);
    }

    protected void onPause() {
        ap.vd().b(1063, this);
        ap.vd().b(1068, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        ap.getSysCmdMsgExtension().b("scanproductinfo", this.oZL, true);
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        if (this.gKi != null) {
            this.gKi.c(this.gKp);
        }
        al(10100, (bg.Ny() - this.mStartTime));
        super.onDestroy();
    }

    protected final void KC() {
        View customView;
        zi(R.l.ePe);
        this.isJ = this.vrv;
        if (cO().cP() != null) {
            cO().cP().setBackgroundDrawable(null);
            customView = cO().cP().getCustomView();
        } else {
            customView = null;
        }
        if (customView != null) {
            customView = customView.findViewById(R.h.divider);
            if (customView != null) {
                customView.setBackgroundColor(-1);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.oZO.hPi == 4) {
                    this.oZO.setResult(0);
                }
                this.oZO.finish();
                return true;
            }
        });
        this.ioX = (TextView) findViewById(R.h.csO);
        this.oZo = (ImageView) findViewById(R.h.csF);
        this.oZp = findViewById(R.h.csK);
        this.oZr = (ImageView) findViewById(R.h.csC);
        this.oZx = findViewById(R.h.csy);
        this.oZu = (LinearLayout) findViewById(R.h.csJ);
        this.oZv = (ImageView) findViewById(R.h.csH);
        this.oZs = findViewById(R.h.csB);
        j(this.oZx, 0.0f);
        if (com.tencent.mm.bg.a.dM(this.uSU.uTo)) {
            this.ioX.setTextSize(0, ((float) this.uSU.uTo.getResources().getDimensionPixelSize(R.f.aWX)) * 1.25f);
        } else {
            this.ioX.setTextSize(0, (float) com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aWX));
        }
        this.oZq = (TextView) findViewById(R.h.csA);
        this.oZt = (TextView) findViewById(R.h.czW);
        this.oZC = new HashMap();
        this.oZD = new com.tencent.mm.plugin.scanner.ui.e.a(this) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final void a(String str, Boolean bool) {
                if (str != null && str.length() > 0) {
                    this.oZO.oZC.put(str, bool);
                }
            }

            public final Boolean DH(String str) {
                if (str == null || str.length() <= 0) {
                    return null;
                }
                return (Boolean) this.oZO.oZC.get(str);
            }

            public final void aYE() {
                if (this.oZO.isJ != null) {
                    this.oZO.isJ.notifyDataSetChanged();
                }
            }
        };
        this.oZK = new com.tencent.mm.plugin.scanner.history.a.a();
        this.oZK.field_ScanTime = System.currentTimeMillis();
        this.oZK.field_scene = this.hPi;
        String stringExtra;
        String DK;
        if (this.hPi == 5) {
            this.oZH = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            DK = DK(stringExtra);
            this.oZK.field_qrcodeUrl = stringExtra;
            this.oZK.field_productId = DK;
            m(DK, stringExtra, false);
        } else if (this.hPi == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            DK = getIntent().getStringExtra("key_Qrcode_Url");
            if (bg.mA(stringExtra)) {
                w.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                return;
            }
            m(stringExtra, DK, false);
        } else {
            this.oZJ = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.oZH = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (bg.mA(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (bg.mA(stringExtra)) {
                    w.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    return;
                }
                m(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.oZw = com.tencent.mm.plugin.scanner.a.i.bA(stringExtra, intExtra);
                if (this.oZw == null) {
                    w.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    return;
                }
                this.kMS = this.oZw.field_productid;
                this.oZE = this.oZw.field_extinfo;
                if (!this.oZH || TextUtils.isEmpty(this.kMS)) {
                    w.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.oZH + " mProductId:" + this.kMS);
                } else {
                    this.oZK.field_xmlContent = stringExtra;
                    this.oZK.field_qrcodeUrl = this.oZE;
                    this.oZK.field_productId = this.kMS;
                    this.oZK.field_funcType = intExtra;
                    aYK();
                }
                com.tencent.mm.plugin.scanner.util.n.a aVar = this.oZw;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || bg.mA(this.oZw.field_productid)) {
                    aYJ();
                } else {
                    m(this.oZw.field_productid, this.oZw.field_extinfo, true);
                }
            }
        }
        findViewById(R.h.csM).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final void onClick(View view) {
                ProductUI.j(this.oZO);
            }
        });
        findViewById(R.h.csD).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final void onClick(View view) {
                ProductUI.j(this.oZO);
            }
        });
        this.oZs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI oZO;

            {
                this.oZO = r1;
            }

            public final void onClick(View view) {
                if (this.oZO.oZw != null && !bg.mA(this.oZO.oZw.field_certificationurl)) {
                    this.oZO.al(CdnLogic.MediaType_FAVORITE_VIDEO, this.oZO.oZw.field_certificationurl);
                    this.oZO.DM(this.oZO.oZw.field_certificationurl);
                }
            }
        });
        b bVar = new b(this);
    }

    private void a(final com.tencent.mm.plugin.scanner.util.n.a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        if (!bg.mA(aVar.field_thumburl)) {
            this.oZA = new a(aVar);
        }
        this.oZz = this.uSU.uTo.getResources().getDimensionPixelSize(R.f.baO);
        if (this.oZw != null && (this.oZw.field_type == 1 || this.oZw.field_type == 2)) {
            this.oZz = this.uSU.uTo.getResources().getDimensionPixelSize(R.f.baP);
            LayoutParams layoutParams = this.oZo.getLayoutParams();
            layoutParams.height = this.oZz;
            this.oZo.setLayoutParams(layoutParams);
            layoutParams = this.oZp.getLayoutParams();
            layoutParams.height = this.oZz;
            this.oZu.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.h.csG);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.oZz;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.oZu.getLayoutParams();
            layoutParams.height = this.oZz;
            this.oZu.setLayoutParams(layoutParams);
        }
        if (bg.mA(aVar.field_introtitle) || bg.mA(aVar.field_introlink)) {
            this.oZt.setVisibility(8);
        } else {
            this.oZt.setText(aVar.field_introtitle);
            this.oZt.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductUI oZO;

                public final void onClick(View view) {
                    this.oZO.al(10003, aVar.field_introlink);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.field_introlink);
                    intent.putExtra("geta8key_scene", this.oZO.UP());
                    com.tencent.mm.bb.d.b(this.oZO.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            this.oZt.setVisibility(0);
        }
        this.oZy = this.oZw.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.ioX.setText(aVar.field_title);
            if (bg.mA(aVar.field_certification)) {
                this.oZq.setText(aVar.field_source);
                this.oZr.setVisibility(8);
                this.oZs.setOnClickListener(null);
                this.oZs.setBackgroundDrawable(null);
                this.oZs.setFocusable(false);
            } else {
                this.oZq.setText(aVar.field_certification);
                this.oZr.setVisibility(0);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.oZn = (ImageView) findViewById(R.h.csI);
                findViewById(R.h.csI).setVisibility(0);
                findViewById(R.h.csL).setVisibility(8);
            } else {
                this.oZn = (ImageView) findViewById(R.h.csL);
                findViewById(R.h.csL).setVisibility(0);
                findViewById(R.h.csI).setVisibility(8);
            }
            if (!bg.mA(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(R.h.csE);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ProductUI oZO;

                    public final void onClick(View view) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse(aVar.field_playurl), "video/*");
                        this.oZO.startActivity(intent);
                    }
                });
            }
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ ProductUI oZO;

                {
                    this.oZO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ProductUI.l(this.oZO);
                    return true;
                }
            });
        } else if (aVar.field_xmlType == 4) {
            this.oZn = (ImageView) findViewById(R.h.csL);
            findViewById(R.h.csL).setVisibility(0);
            findViewById(R.h.csI).setVisibility(8);
            this.oZn.setImageResource(R.k.dzp);
            this.oZn.setBackgroundResource(R.k.dzp);
            this.ioX.setText(R.l.eOM);
            this.oZq.setText(null);
        }
        w.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        af.v(new Runnable(this) {
            final /* synthetic */ ProductUI oZO;

            public final void run() {
                this.oZO.b(aVar);
                ProductUI.b(this.oZO, aVar);
            }
        });
    }

    private void aYG() {
        this.fGM = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.fGM > 0 && ap.zb()) {
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(this.fGM);
            if (cA.field_msgId > 0) {
                cA.cI(this.oZA.Nm());
                ap.yY();
                com.tencent.mm.u.c.wT().a(this.fGM, cA);
            }
        }
    }

    private void b(com.tencent.mm.plugin.scanner.util.n.a aVar) {
        if (aVar != null && aVar.per != null && aVar.per.size() != 0 && this.isJ != null) {
            this.isJ.removeAll();
            for (int i = 0; i < aVar.per.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a) aVar.per.get(i);
                if (!(aVar2 == null || aVar2.hSY == null || aVar2.hSY.size() == 0 || aVar2.oVJ == 1 || !aVar2.oVL)) {
                    Preference preference;
                    if (i != 0) {
                        preference = new Preference(this);
                        preference.setLayoutResource(R.i.dkQ);
                        this.isJ.a(preference);
                    }
                    if (!bg.mA(aVar2.title) && (aVar2.type == 6 || aVar2.type == 7)) {
                        preference = new CategoryWithTitlePreference(this);
                        preference.setTitle(aVar2.title);
                        this.isJ.a(preference);
                    }
                    int i2;
                    com.tencent.mm.plugin.scanner.a.a.a aVar3;
                    if (aVar2.type == 6) {
                        List arrayList = new ArrayList();
                        for (i2 = 0; i2 < aVar2.hSY.size(); i2++) {
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.hSY.get(i2);
                            if (aVar3.type == 10) {
                                arrayList.add(aVar3);
                            }
                        }
                        if (arrayList.size() > 0) {
                            Preference hVar = new h(this);
                            hVar.setKey((i * 100));
                            hVar.oqu = arrayList;
                            this.isJ.a(hVar);
                        }
                    } else {
                        i2 = 0;
                        while (i2 < aVar2.hSY.size()) {
                            String str = ((i * 100) + i2);
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.hSY.get(i2);
                            if (aVar3.type == 11) {
                                this.oZF = true;
                                this.oZG = aVar3.name;
                            }
                            if (aVar3.showType != 2) {
                                Preference musicPreference;
                                if (aVar3.showType != 1) {
                                    if (aVar3.type == 5) {
                                        musicPreference = new MusicPreference(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.oVO = aVar3.oVO;
                                        musicPreference.oVP = aVar3.oVP;
                                        musicPreference.oVQ = aVar3.oVQ;
                                        if (DJ(String.format("%s_cd_%s", new Object[]{aVar3.oVO, str}))) {
                                            musicPreference.gI(true);
                                        } else {
                                            musicPreference.gI(false);
                                        }
                                        musicPreference.oYT = this.oZM;
                                        this.isJ.a(musicPreference);
                                        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
                                        if (this.nSU == null) {
                                            this.nSU = new ArrayList();
                                        }
                                        if (this.oZN) {
                                            this.nSU.add(musicPreference);
                                        }
                                    } else if (aVar3.type == 6) {
                                        musicPreference = new e(this);
                                        musicPreference.setKey(str);
                                        musicPreference.mTitle = aVar3.name;
                                        musicPreference.setSummary(aVar3.desc);
                                        this.isJ.a(musicPreference);
                                        musicPreference.oYI = this.oZD;
                                    } else if (aVar3.type == 12) {
                                        musicPreference = new f(this);
                                        musicPreference.setKey(str);
                                        musicPreference.kOm = aVar3.thumburl;
                                        musicPreference.isJ = this.isJ;
                                        this.isJ.a(musicPreference);
                                    } else if (aVar3.type == 2) {
                                        CharSequence charSequence = DL(aVar3.username) ? aVar3.oVW : aVar3.oVV;
                                        Preference aVar4 = new a(this);
                                        aVar4.setKey(str);
                                        aVar4.setTitle(charSequence);
                                        aVar4.setSummary(aVar3.desc);
                                        aVar4.oXf = aVar3.hku;
                                        this.isJ.a(aVar4);
                                    } else if (aVar3.type == 22) {
                                        musicPreference = new d(this);
                                        musicPreference.setKey(str);
                                        if (!bg.mA(aVar3.fFa)) {
                                            musicPreference.oRg = aVar3.fFa + ":";
                                        }
                                        musicPreference.mqI = aVar3.content;
                                        musicPreference.oYw = aVar3.thumburl;
                                        this.isJ.a(musicPreference);
                                    } else {
                                        musicPreference = new a(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.setSummary(aVar3.desc);
                                        musicPreference.oXf = aVar3.hku;
                                        musicPreference.lia = aVar3.iconUrl;
                                        this.isJ.a(musicPreference);
                                    }
                                    if (!(i2 >= aVar2.hSY.size() - 1 || aVar3.type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.hSY.get(i2 + 1)).type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.hSY.get(i2 + 1)).showType == 1 || !a(i2, aVar2.hSY))) {
                                        this.isJ.a(new g(this));
                                    }
                                } else if (!bg.mA(aVar3.oVM)) {
                                    musicPreference = new b(this);
                                    musicPreference.setKey(str);
                                    musicPreference.kOm = aVar3.oVM;
                                    musicPreference.isJ = this.isJ;
                                    this.isJ.a(musicPreference);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            this.isJ.notifyDataSetChanged();
            w.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
            if (this.nSU != null) {
                this.oZN = false;
            }
        }
    }

    private static boolean a(int i, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> linkedList) {
        if (linkedList != null) {
            for (int i2 = i + 1; i2 < linkedList.size(); i2++) {
                if (((com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i2)).showType != 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void aYH() {
        if (this.oZw != null && this.oZw.per != null && this.oZw.per.size() != 0 && this.isJ != null) {
            for (int i = 0; i < this.oZw.per.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.oZw.per.get(i);
                if (!(aVar == null || aVar.hSY == null || aVar.hSY.size() == 0)) {
                    for (int i2 = 0; i2 < aVar.hSY.size(); i2++) {
                        if (((com.tencent.mm.plugin.scanner.a.a.a) aVar.hSY.get(i2)).type == 5) {
                            MusicPreference musicPreference = (MusicPreference) this.isJ.Td(((i * 100) + i2));
                            if (musicPreference != null) {
                                if (DJ(String.format("%s_cd_%s", new Object[]{r1.oVO, r6}))) {
                                    musicPreference.gI(true);
                                } else {
                                    musicPreference.gI(false);
                                }
                            }
                        }
                    }
                }
            }
            this.isJ.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        w.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.igL});
        if (this.oZw == null || this.oZw.per == null) {
            w.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.igL).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            w.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.oZw.per.size()) {
                w.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.oZw.per.size())});
                return false;
            }
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.oZw.per.get(i);
            if (aVar == null) {
                w.w("MicroMsg.scanner.ProductUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.hSY.size()) {
                w.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.hSY.size())});
                return false;
            } else {
                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) aVar.hSY.get(i2);
                if (aVar2 == null) {
                    w.w("MicroMsg.scanner.ProductUI", "action == null");
                    return false;
                }
                w.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[]{Integer.valueOf(aVar2.type)});
                String str = null;
                Intent intent = new Intent();
                switch (aVar2.type) {
                    case 1:
                    case 3:
                    case 22:
                        str = aVar2.hSX;
                        if (!bg.mA(aVar2.hSX)) {
                            DM(aVar2.hSX);
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        str = aVar2.username;
                        if (!bg.mA(aVar2.username)) {
                            Object obj = aVar2.username;
                            Intent intent2;
                            if (!DL(obj)) {
                                if (!TextUtils.isEmpty(obj)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("Contact_User", obj);
                                    intent2.putExtra("force_get_contact", true);
                                    intent2.putExtra("Contact_Scene", aYI());
                                    com.tencent.mm.plugin.scanner.b.imv.d(intent2, this);
                                    break;
                                }
                                w.v("MicroMsg.scanner.ProductUI", "username is null");
                                break;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Chat_User", obj);
                            intent2.putExtra("finish_direct", true);
                            intent2.putExtra("add_scene", aYI());
                            com.tencent.mm.plugin.scanner.b.imv.e(intent2, this.uSU.uTo);
                            break;
                        }
                        break;
                    case 5:
                        str = aVar2.oVQ;
                        intent.putExtra("rawUrl", aVar2.oVQ);
                        intent.putExtra("geta8key_scene", UP());
                        com.tencent.mm.plugin.scanner.b.imv.j(intent, this);
                        com.tencent.mm.am.b.HH();
                        aYH();
                        break;
                    case 6:
                    case 7:
                    case 10:
                        break;
                    case 8:
                        str = aVar2.oVS;
                        intent.putExtra("key_card_id", aVar2.oVU);
                        intent.putExtra("key_card_ext", aVar2.oVT);
                        intent.putExtra("key_from_scene", 9);
                        com.tencent.mm.bb.d.b(this, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 9:
                        str = aVar2.oVS;
                        if (!bg.mA(aVar2.oVS)) {
                            intent.putExtra("key_product_id", aVar2.oVS);
                            intent.putExtra("key_product_scene", 12);
                            com.tencent.mm.bb.d.b(this, "product", ".ui.MallProductUI", intent);
                            break;
                        }
                        break;
                    case 11:
                        intent.setClass(this, ProductFurtherInfoUI.class);
                        intent.putExtra("key_Product_xml", this.oZw.field_xml);
                        intent.putExtra("key_title", aVar2.name);
                        startActivity(intent);
                        break;
                    case 12:
                        str = aVar2.hSX;
                        if (!bg.mA(aVar2.hSX)) {
                            DM(aVar2.hSX);
                            break;
                        }
                        break;
                    case 21:
                        str = aVar2.oVK;
                        intent.setClass(this, ProductPurchaseAreaUI.class);
                        intent.putExtra("key_Product_xml", this.oZw.field_xml);
                        intent.putExtra("referkey", aVar2.oVK);
                        intent.putExtra("key_Product_funcType", this.oZy);
                        startActivity(intent);
                        break;
                    default:
                        w.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar2.hSX);
                        if (!bg.mA(aVar2.hSX)) {
                            DM(aVar2.hSX);
                            break;
                        }
                        break;
                }
                ap.vd().a(new com.tencent.mm.plugin.scanner.a.h(this.oZw.field_productid, aVar2.oVR, aVar2.type, str, aVar.hSY.size(), aVar2.showType), 0);
                return true;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean DJ(String str) {
        anf HL = com.tencent.mm.am.b.HL();
        if (HL != null && HL.tRH == 5 && str.equals(HL.tqY) && com.tencent.mm.am.b.HJ()) {
            return true;
        }
        return false;
    }

    private void al(int i, String str) {
        if (this.oZw != null) {
            ap.vd().a(new com.tencent.mm.plugin.scanner.a.h(this.oZw.field_productid, "", i, str, 0, 0), 0);
        }
    }

    public final void k(final String str, final Bitmap bitmap) {
        if (!bg.mA(str) && this.oZw != null && bitmap != null && !bitmap.isRecycled()) {
            w.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
            af.v(new Runnable(this) {
                final /* synthetic */ ProductUI oZO;

                public final void run() {
                    if (str.equals(this.oZO.oZw.field_thumburl) && this.oZO.oZn != null) {
                        w.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            this.oZO.oZn.setImageBitmap(bitmap);
                            this.oZO.oZn.setBackgroundDrawable(null);
                            this.oZO.oZn.setBackgroundColor(-1);
                            this.oZO.aYG();
                            this.oZO.oZB = true;
                        } catch (Exception e) {
                            w.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                        }
                    }
                    if (str.equals(this.oZO.oZw.field_headerbackgroundurl) && this.oZO.oZo != null) {
                        this.oZO.oZo.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar == null) {
            w.w("MicroMsg.scanner.ProductUI", "scene == null");
        } else if (kVar.getType() == 1063) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.scanner.a.d dVar = (com.tencent.mm.plugin.scanner.a.d) kVar;
                hc hcVar = (dVar.gUA == null || dVar.gUA.hsk.hsr == null) ? null : (hc) dVar.gUA.hsk.hsr;
                if (hcVar == null) {
                    w.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                    return;
                } else if (hcVar.tlg != null) {
                    w.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                    com.tencent.mm.plugin.scanner.util.n.a bA = com.tencent.mm.plugin.scanner.a.i.bA(hcVar.tlg, this.oZy);
                    if (this.oZw != null && this.oZw.field_xml != null && bA != null && bA.field_xml != null && !this.oZw.field_xml.equals(bA.field_xml)) {
                        this.oZw = bA;
                        a(this.oZw);
                    } else if (!(bA == null || bA.field_xml == null)) {
                        this.oZw = bA;
                        a(this.oZw);
                    }
                    if (this.isv != null && this.isv.isShowing()) {
                        this.isv.dismiss();
                    }
                    aYJ();
                    if (!this.oZH || this.oZI || TextUtils.isEmpty(this.kMS)) {
                        w.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.oZH + " mProductId:" + this.kMS + "  hasAddToHistory:" + this.oZI);
                        return;
                    }
                    this.oZK.field_xmlContent = hcVar.tlg;
                    this.oZK.field_funcType = this.oZy;
                    aYK();
                    return;
                } else {
                    return;
                }
            }
            w.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar.getType() == 1068 && i == 0 && i2 == 0) {
            List list = ((ha) ((com.tencent.mm.plugin.scanner.a.c) kVar).gUA.hsk.hsr).tlf;
            if (this.oZw != null && k.b(this.oZw.per, k.bk(list))) {
                b(this.oZw);
            }
        }
    }

    private static String DK(String str) {
        String str2 = null;
        if (!bg.mA(str)) {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
            } catch (Exception e) {
                w.w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
            }
        }
        return str2;
    }

    private void m(String str, String str2, boolean z) {
        this.kMS = str;
        this.oZE = str2;
        final com.tencent.mm.y.k dVar = new com.tencent.mm.plugin.scanner.a.d(str, this.hPi, str2);
        ap.vd().a(dVar, 0);
        if (!z) {
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.eOV), new OnCancelListener(this) {
                final /* synthetic */ ProductUI oZO;

                public final void onCancel(DialogInterface dialogInterface) {
                    w.d("MicroMsg.scanner.ProductUI", "User cancel");
                    ap.vd().c(dVar);
                }
            });
        }
    }

    private static boolean DL(String str) {
        ap.yY();
        com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc == null || ((int) Rc.gTQ) <= 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
            return false;
        }
        return true;
    }

    private int UP() {
        if (this.oZy == 4) {
            return 11;
        }
        if (this.oZy == 3) {
            return 12;
        }
        return 0;
    }

    private void DM(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", com.tencent.mm.plugin.scanner.a.i.sc(this.oZy));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", UP());
        com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
    }

    private int aYI() {
        if (this.oZy == 3) {
            return 47;
        }
        return 49;
    }

    private void aYJ() {
        if (this.oZw != null) {
            w.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.oZw.field_getaction);
            if ((this.oZw.field_getaction & 2) > 0) {
                this.gKi = c.Gk();
                if (this.gKi != null) {
                    this.gKi.b(this.gKp);
                }
            } else if ((this.oZw.field_getaction & 1) > 0) {
                ap.vd().a(new com.tencent.mm.plugin.scanner.a.c(this.kMS, k.bj(this.oZw.per), this.hPi, this.oZE, 0.0d, 0.0d), 0);
            }
        }
    }

    private static void j(View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void aYK() {
        if (com.tencent.mm.plugin.scanner.util.j.aZh()) {
            boolean c;
            com.tencent.mm.sdk.e.c aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            aVar.field_productId = this.kMS;
            if (com.tencent.mm.plugin.scanner.c.aXX().b(aVar, new String[0])) {
                c = com.tencent.mm.plugin.scanner.c.aXX().c(this.oZK, new String[0]);
            } else {
                c = com.tencent.mm.plugin.scanner.c.aXX().b(this.oZK);
            }
            if (c) {
                w.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.oZI = true;
                return;
            }
            w.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            return;
        }
        w.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
    }
}
