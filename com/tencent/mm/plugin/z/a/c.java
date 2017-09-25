package com.tencent.mm.plugin.z.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.e.a.nq;
import com.tencent.mm.e.a.x;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {

    public interface a {
        Context getContext();

        void gu(boolean z);
    }

    public static boolean a(final a aVar, l lVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        if (aVar == null || aVar.getContext() == null) {
            w.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            return false;
        }
        int IS = lVar.IS();
        int i3 = ((tn) lVar.gUA.hsj.hsr).tBC;
        w.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[]{Integer.valueOf(IS), Integer.valueOf(i3)});
        w.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + i);
        final Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        f.xT(rI(i));
        String IQ;
        String string;
        switch (IS) {
            case 1:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + lVar.pM());
                intent.putExtra(SlookAirButtonFrequentContactAdapter.DATA, lVar.pM());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", rI(i));
                intent.putExtra("geta8key_session_id", lVar.IY());
                b.imv.j(intent, aVar.getContext());
                new ae(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 2:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + lVar.IQ());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                IS = R.l.eHk;
                Object[] objArr = new Object[1];
                if (bg.mA(str)) {
                    str = lVar.IQ();
                }
                objArr[0] = str;
                final l lVar2 = lVar;
                final int i4 = i2;
                final int i5 = i;
                final a aVar2 = aVar;
                g.a(context, context2.getString(IS, objArr), aVar.getContext().getString(R.l.dIO), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        intent.putExtra("title", lVar2.getTitle());
                        intent.putExtra("rawUrl", lVar2.IQ());
                        if (i4 == 2) {
                            intent.putExtra("stastic_scene", 13);
                        } else if (i4 == 1) {
                            intent.putExtra("stastic_scene", 14);
                        } else {
                            intent.putExtra("stastic_scene", 11);
                        }
                        intent.putExtra("pay_channel", c.rI(i5));
                        intent.putExtra("geta8key_session_id", lVar2.IY());
                        b.imv.j(intent, aVar2.getContext());
                    }
                }, onClickListener);
                return true;
            case 3:
                IQ = lVar.IQ();
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + IQ);
                if (IQ == null || IQ.length() == 0) {
                    w.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    return false;
                }
                string = aVar.getContext().getString(R.l.eHj);
                if (IQ.startsWith("http")) {
                    string = aVar.getContext().getString(R.l.eHk, new Object[]{IQ});
                }
                Uri parse = Uri.parse(IQ);
                if (parse != null) {
                    final Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (bg.j(aVar.getContext(), intent2)) {
                        g.a(aVar.getContext(), string, aVar.getContext().getString(R.l.dIO), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.getContext().startActivity(intent2);
                            }
                        }, onClickListener);
                        return true;
                    }
                }
                return false;
            case 4:
                return false;
            case 6:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + lVar.IQ());
                intent.putExtra("rawUrl", lVar.IQ());
                intent.putExtra("pay_channel", rI(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", lVar.IY());
                b.imv.j(intent, aVar.getContext());
                return true;
            case 7:
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[]{lVar.IR(), lVar.IQ(), lVar.IU()});
                intent.putExtra("title", lVar.getTitle());
                intent.putExtra("rawUrl", lVar.IQ());
                intent.putExtra("k_share_url", lVar.IU());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + rI(i));
                intent.putExtra("pay_channel", rI(i));
                intent.putExtra("geta8key_session_id", lVar.IY());
                List<afe> IX = lVar.IX();
                if (!bg.bV(IX)) {
                    afe com_tencent_mm_protocal_c_afe;
                    Object obj;
                    String[] strArr;
                    String[] strArr2;
                    for (afe com_tencent_mm_protocal_c_afe2 : IX) {
                        if (com_tencent_mm_protocal_c_afe2 == null || bg.mA(com_tencent_mm_protocal_c_afe2.tkE)) {
                            w.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[IX.size()];
                                strArr2 = new String[IX.size()];
                                for (IS = 0; IS < IX.size(); IS++) {
                                    com_tencent_mm_protocal_c_afe2 = (afe) IX.get(IS);
                                    w.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(IS), com_tencent_mm_protocal_c_afe2.tkE, com_tencent_mm_protocal_c_afe2.oTN});
                                    strArr[IS] = r8;
                                    strArr2[IS] = IQ;
                                }
                                intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                intent.putExtra("k_has_http_header", true);
                            }
                        } else if (bg.mA(com_tencent_mm_protocal_c_afe2.oTN)) {
                            w.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                strArr = new String[IX.size()];
                                strArr2 = new String[IX.size()];
                                for (IS = 0; IS < IX.size(); IS++) {
                                    com_tencent_mm_protocal_c_afe2 = (afe) IX.get(IS);
                                    w.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(IS), com_tencent_mm_protocal_c_afe2.tkE, com_tencent_mm_protocal_c_afe2.oTN});
                                    strArr[IS] = r8;
                                    strArr2[IS] = IQ;
                                }
                                intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                intent.putExtra("k_has_http_header", true);
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        strArr = new String[IX.size()];
                        strArr2 = new String[IX.size()];
                        for (IS = 0; IS < IX.size(); IS++) {
                            com_tencent_mm_protocal_c_afe2 = (afe) IX.get(IS);
                            w.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(IS), com_tencent_mm_protocal_c_afe2.tkE, com_tencent_mm_protocal_c_afe2.oTN});
                            strArr[IS] = r8;
                            strArr2[IS] = IQ;
                        }
                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                        intent.putExtra("k_has_http_header", true);
                    }
                }
                b.imv.j(intent, aVar.getContext());
                new ae(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 8:
                string = lVar.pM();
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + string);
                if (!bg.mA(string)) {
                    try {
                        new o().DF(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.gu(false);
                        return true;
                    } catch (Throwable e) {
                        w.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        w.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        w.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        w.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                g.a(aVar.getContext(), aVar.getContext().getString(R.l.eHr), aVar.getContext().getString(R.l.dIO), false, onClickListener);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                return b.imv.b(aVar.getContext(), lVar.IQ(), bundle2);
            case 10:
            case 11:
                a(aVar, IS, lVar.IQ(), rI(i));
                new ae(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 12:
            case 15:
                a(aVar, IS, lVar.IQ(), rI(i));
                return true;
            case 14:
                IQ = lVar.IQ();
                if (IQ != null) {
                    IQ = IQ.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", IQ);
                intent.putExtra("key_product_scene", 7);
                d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                ab.getContext().startService(bg.y(ab.getContext(), new Intent().setClassName(ab.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService")).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, lVar.IQ()).putExtra("isFromWifi", true));
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                return true;
            case 17:
                final Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", lVar.IQ());
                string = "free_wifi_mid";
                to toVar = (to) lVar.gUA.hsk.hsr;
                if (toVar == null || toVar.tcb == null) {
                    w.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    IQ = null;
                } else {
                    IQ = toVar.tcb;
                }
                intent3.putExtra(string, IQ);
                string = "free_wifi_ssid";
                toVar = (to) lVar.gUA.hsk.hsr;
                if (toVar == null || toVar.SSID == null) {
                    w.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    IQ = null;
                } else {
                    IQ = toVar.SSID;
                }
                intent3.putExtra(string, IQ);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", lVar.IQ());
                ap.yY();
                if (com.tencent.mm.u.c.vr().get(303104, null) != null) {
                    g.a(aVar.getContext(), R.l.emo, R.l.dIO, R.l.emD, R.l.dGs, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                            aVar.gu(false);
                        }
                    }, onClickListener);
                } else {
                    d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.gu(false);
                }
                return true;
            case 18:
                com.tencent.mm.plugin.scanner.util.p.a DS = p.DS(lVar.IQ());
                if (DS == null) {
                    w.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (p.ko(DS.kdF)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", DS.kdE);
                    intent.putExtra("key_card_ext", DS.fVm);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    w.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    p.au(aVar.getContext(), aVar.getContext().getString(R.l.dRx));
                }
                return false;
            case 20:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + lVar.IQ());
                ap.vd().a(new y(lVar.IQ()), 0);
                return true;
            case 21:
                Intent intent4 = new Intent();
                intent4.setClass(aVar.getContext(), ProductUI.class);
                intent4.putExtra("key_ProductUI_getProductInfoScene", 5);
                intent4.putExtra("key_Qrcode_Url", lVar.IQ());
                aVar.getContext().startActivity(intent4);
                return true;
            case 22:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + lVar.IQ());
                e.a(aVar.getContext(), 1, lVar.IQ(), rI(i), null);
                new ae(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 23:
                IQ = lVar.IQ();
                if (bg.mA(IQ)) {
                    w.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    return true;
                }
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[]{IQ});
                com.tencent.mm.sdk.b.b xVar = new x();
                xVar.fDe.url = IQ;
                com.tencent.mm.sdk.b.a.urY.m(xVar);
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                return true;
            case 24:
                com.tencent.mm.sdk.b.b nqVar = new nq();
                nqVar.fUL.fUM = str;
                com.tencent.mm.sdk.b.a.urY.m(nqVar);
                return true;
            case 25:
                IQ = lVar.IQ();
                ArrayList DT = p.DT(IQ);
                if (DT == null || DT.size() == 0) {
                    w.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (p.P(DT)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", IQ);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    w.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    p.au(aVar.getContext(), aVar.getContext().getString(R.l.dRx));
                }
                return false;
            case 26:
                String IQ2 = lVar.IQ();
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + IQ2);
                Context context3 = aVar.getContext();
                w.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + IQ2);
                Uri parse2 = Uri.parse(IQ2);
                int i6;
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    if (i2 == 2) {
                        i6 = i3 == 22 ? 1048 : 1012;
                    } else if (i2 == 1) {
                        i6 = i3 == 22 ? 1049 : 1013;
                    } else {
                        i6 = i3 == 22 ? 1047 : 1011;
                    }
                    ((com.tencent.mm.plugin.appbrand.i.d) h.h(com.tencent.mm.plugin.appbrand.i.d.class)).b(context3, IQ2, i6, bundle);
                } else {
                    IQ = parse2.getQueryParameter("search_query");
                    String queryParameter = parse2.getQueryParameter("appid");
                    String queryParameter2 = parse2.getQueryParameter("search_extInfo");
                    int i7 = bg.getInt(parse2.getQueryParameter("debug"), 0);
                    i6 = bg.getInt(parse2.getQueryParameter("version"), 0);
                    com.tencent.mm.sdk.b.b khVar = new kh();
                    khVar.fQJ.scene = 1;
                    khVar.fQJ.appId = queryParameter;
                    khVar.fQJ.type = i7;
                    khVar.fQJ.version = i6;
                    khVar.fQJ.fQK = IQ;
                    khVar.fQJ.url = IQ2;
                    khVar.fQJ.fQL = queryParameter2;
                    com.tencent.mm.sdk.b.a.urY.m(khVar);
                    intent = com.tencent.mm.as.d.Il();
                    intent.putExtra("ftsbizscene", 99999);
                    intent.putExtra("ftsQuery", IQ);
                    intent.putExtra("ftsqrcodestring", IQ2);
                    Map a = com.tencent.mm.as.d.a(com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX, false, 262144);
                    a.put("query", IQ);
                    a.put("sessionid", com.tencent.mm.as.d.gm(bg.PY((String) a.get("scene"))));
                    intent.putExtra("rawUrl", com.tencent.mm.as.d.m(a));
                    d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", intent);
                }
                aVar.gu(false);
                return true;
            default:
                w.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + lVar.IS());
                return false;
        }
    }

    private static void a(final a aVar, int i, String str, int i2) {
        w.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(i), str});
        final com.tencent.mm.sdk.b.b grVar = new gr();
        grVar.fLZ.actionCode = i;
        grVar.fLZ.result = str;
        grVar.fLZ.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        grVar.fLZ.fMb = bundle;
        grVar.nFq = new Runnable() {
            public final void run() {
                if (aVar != null && grVar != null && grVar.fMa != null) {
                    if (grVar.fMa.ret == 1) {
                        aVar.gu(true);
                    } else if (grVar.fMa.ret == 2) {
                        aVar.gu(false);
                    }
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(grVar, Looper.myLooper());
    }

    protected static int rI(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }
}
