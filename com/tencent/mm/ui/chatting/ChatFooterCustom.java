package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, com.tencent.mm.u.bp.a {
    x fOK;
    private String jia;
    private LinearLayout kZi;
    private Object ppU;
    d sPc;
    private q uUu;
    private ImageView vAi;
    ImageView vAj;
    y vAk;
    com.tencent.mm.ui.chatting.En_5b8fbb1e.a.b vAl;
    private int vAm;
    private ay vAn;
    private a vAo;
    private b vAp;
    private List<String> vAq;
    private final String vAr;
    private final String vAs;
    private i vAt;

    private class a extends c<lf> {
        final /* synthetic */ ChatFooterCustom vAu;

        private a(ChatFooterCustom chatFooterCustom) {
            this.vAu = chatFooterCustom;
            this.usg = lf.class.getName().hashCode();
        }

        /* synthetic */ a(ChatFooterCustom chatFooterCustom, byte b) {
            this(chatFooterCustom);
            this.usg = lf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lf lfVar = (lf) bVar;
            switch (lfVar.fRU.fRW) {
                case 0:
                    this.vAu.h(MMBitmapFactory.ERROR_IO_FAILED, lfVar);
                    break;
                case 1:
                    this.vAu.h(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, lfVar);
                    break;
            }
            return false;
        }
    }

    private class b extends c<lg> {
        final /* synthetic */ ChatFooterCustom vAu;

        private b(ChatFooterCustom chatFooterCustom) {
            this.vAu = chatFooterCustom;
            this.usg = lg.class.getName().hashCode();
        }

        /* synthetic */ b(ChatFooterCustom chatFooterCustom, byte b) {
            this(chatFooterCustom);
            this.usg = lg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            lg lgVar = (lg) bVar;
            switch (lgVar.fRY.fRW) {
                case 0:
                    this.vAu.h(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED, lgVar);
                    break;
                case 1:
                    this.vAu.h(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, lgVar);
                    break;
            }
            return false;
        }
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.kZi = null;
        this.vAi = null;
        this.vAj = null;
        this.vAk = null;
        this.sPc = null;
        this.vAl = null;
        this.vAm = 0;
        this.vAq = new LinkedList();
        this.vAr = "qrcode";
        this.vAs = "barcode";
        this.ppU = new Object();
    }

    public final void a(q qVar, com.tencent.mm.modelbiz.BizInfo.ExtInfo.b bVar, String str) {
        if (bVar == null || bVar.hvf == null || str == null) {
            throw new IllegalArgumentException(" menuInfo or username is null ! ");
        }
        this.vAm = Math.min(bVar.hvf.size(), 6);
        w.i("ChatCustomFooter", "setMenus, count:" + this.vAm);
        if (this.vAm <= 0) {
            throw new IllegalArgumentException(" mTabCount is invalid ! ");
        }
        if (this.vAm > 3) {
            this.vAi.setVisibility(0);
        } else {
            this.vAi.setVisibility(8);
        }
        this.kZi.setWeightSum((float) Math.min(this.vAm, 3));
        for (int i = 0; i < 6; i++) {
            FrameLayout frameLayout = (FrameLayout) this.kZi.getChildAt(i);
            TextView textView = (TextView) frameLayout.getChildAt(0).findViewById(R.h.bAz);
            frameLayout.getChildAt(0).findViewById(R.h.bAy).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(1);
            imageView.setVisibility(8);
            if (i < this.vAm) {
                i iVar = (i) bVar.hvf.get(i);
                frameLayout.setTag(iVar);
                textView.setText(h.a(getContext(), iVar.name));
                if (iVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i < 3 || this.vAm <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
        }
        this.uUu = qVar;
        this.jia = str;
        if (this.vAo != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.vAo);
        }
        if (this.vAp != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.vAp);
        }
        this.vAo = new a();
        this.vAp = new b();
        com.tencent.mm.sdk.b.a.urY.b(this.vAo);
        com.tencent.mm.sdk.b.a.urY.b(this.vAp);
    }

    public final void bkp() {
        if (this.vAo != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.vAo);
        }
        if (this.vAp != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.vAp);
        }
    }

    private void bTT() {
        if (this.uUu != null && this.fOK != null && !u.mA(this.jia)) {
            k.b(this.uUu, 9, this.jia, this.fOK.field_username);
        }
    }

    private void bTU() {
        File file = new File(e.gSz);
        if (!file.exists() && !file.mkdir()) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.dVI), 1).show();
        } else if (this.uUu != null && !k.a(this.uUu, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.eQD), 1).show();
        }
    }

    public final void bTV() {
        if (this.vAk != null) {
            this.vAk.bTY();
        }
    }

    public synchronized void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof i) {
            f.xT(8);
            i iVar = (i) tag;
            iVar.content = "";
            com.tencent.mm.sdk.b.b dqVar;
            switch (iVar.type) {
                case 0:
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    w.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth()));
                    y yVar = this.vAk;
                    int width = iArr[0] + (view.getWidth() / 2);
                    int i = iArr[1];
                    if (!yVar.isShowing()) {
                        yVar.a(iVar, width, i, false);
                        break;
                    }
                    yVar.bTY();
                    if (!(iVar == null || (yVar.vAB.id == iVar.id && yVar.vAB.arH.equals(iVar.arH)))) {
                        yVar.a(iVar, width, i, false);
                        break;
                    }
                case 1:
                    w.i("ChatCustomFooter", "get latest message");
                    bTX();
                    this.vAk.bTY();
                    iVar.state = i.hvJ;
                    b(iVar);
                    d(iVar);
                    this.vAl.bWj();
                    break;
                case 2:
                    w.i("ChatCustomFooter", "start webview url");
                    bTX();
                    this.vAk.bTY();
                    iVar.state = i.hvJ;
                    b(iVar);
                    d(iVar);
                    if (!(com.tencent.mm.pluginsdk.l.a.sBA.b(getContext(), iVar.value, new Object[0]) || s.a(iVar.fZF, getContext(), this.uUu, this.jia))) {
                        Intent intent = new Intent();
                        intent.putExtra("KPublisherId", "custom_menu");
                        intent.putExtra("pre_username", this.jia);
                        intent.putExtra("prePublishId", "custom_menu");
                        intent.putExtra("preUsername", this.jia);
                        intent.putExtra("preChatName", this.jia);
                        intent.putExtra("preChatTYPE", p.G(this.jia, this.jia));
                        intent.putExtra("rawUrl", iVar.value);
                        intent.putExtra("geta8key_username", this.jia);
                        intent.putExtra("from_scence", 1);
                        com.tencent.mm.bb.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        break;
                    }
                case 3:
                    w.i("ChatCustomFooter", "switch to input");
                    this.vAk.bTY();
                    bTW();
                    iVar.state = i.hvJ;
                    b(iVar);
                    d(iVar);
                    break;
                case 4:
                    w.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                    bTX();
                    this.vAk.bTY();
                    iVar.state = i.hvK;
                    String str = iVar.id + iVar.arH;
                    synchronized (this.ppU) {
                        this.vAq.add(str);
                    }
                    w.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", str, Integer.valueOf(this.vAq.size()));
                    g.oUh.i(10809, this.jia, Integer.valueOf(iVar.id), iVar.arH, i.hvK, "");
                    this.vAt = iVar;
                    Intent intent2;
                    switch (iVar.hvN) {
                        case 100:
                            intent2 = new Intent();
                            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                            intent2.putExtra("key_is_finish_on_scanned", true);
                            intent2.putExtra("key_is_hide_right_btn", true);
                            if (!(com.tencent.mm.n.a.aI(getContext()) || com.tencent.mm.n.a.aH(getContext()))) {
                                com.tencent.mm.bb.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                break;
                            }
                        case 101:
                            intent2 = new Intent();
                            intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                            intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                            intent2.putExtra("key_is_finish_on_scanned", false);
                            intent2.putExtra("key_is_hide_right_btn", true);
                            if (!(com.tencent.mm.n.a.aI(getContext()) || com.tencent.mm.n.a.aH(getContext()))) {
                                com.tencent.mm.bb.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                break;
                            }
                        case 102:
                            bTU();
                            break;
                        case 103:
                            ap.yY();
                            if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                                s.eP(getContext());
                                break;
                            } else {
                                com.tencent.mm.ui.base.g.a(getContext(), null, new String[]{getContext().getString(R.l.dTm), getContext().getString(R.l.dTl)}, null, new com.tencent.mm.ui.base.g.c(this) {
                                    final /* synthetic */ ChatFooterCustom vAu;

                                    {
                                        this.vAu = r1;
                                    }

                                    public final void hq(int i) {
                                        switch (i) {
                                            case 0:
                                                this.vAu.bTU();
                                                return;
                                            case 1:
                                                this.vAu.bTT();
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                });
                                break;
                            }
                        case 104:
                            bTT();
                            break;
                        case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                            Intent intent3 = new Intent();
                            intent3.putExtra("map_view_type", 0);
                            String str2 = "map_sender_name";
                            w.i("ChatCustomFooter", "getSender " + (this.vAn == null) + " " + (this.vAn == null ? m.xL() : this.vAn.name));
                            intent3.putExtra(str2, this.vAn == null ? m.xL() : this.vAn.name);
                            intent3.putExtra("map_talker_name", this.fOK == null ? null : this.fOK.field_username);
                            intent3.putExtra("view_type_key", 1);
                            intent3.putExtra("key_get_location_type", 1);
                            com.tencent.mm.bb.d.b(getContext(), "location", ".ui.RedirectUI", intent3);
                            break;
                        case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                            dqVar = new dq();
                            dqVar.fHz.op = 1;
                            dqVar.fHz.userName = this.fOK.field_username;
                            dqVar.fHz.context = getContext();
                            com.tencent.mm.sdk.b.a.urY.m(dqVar);
                            break;
                        case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                            dqVar = new dq();
                            dqVar.fHz.op = 2;
                            dqVar.fHz.userName = this.fOK.field_username;
                            dqVar.fHz.context = getContext();
                            com.tencent.mm.sdk.b.a.urY.m(dqVar);
                            break;
                        default:
                            break;
                    }
                case 5:
                    bTX();
                    this.vAk.bTY();
                    iVar.state = i.hvJ;
                    b(iVar);
                    d(iVar);
                    if (!TextUtils.isEmpty(iVar.value)) {
                        try {
                            JSONObject jSONObject = new JSONObject(iVar.value);
                            dqVar = new pr();
                            dqVar.fWB.userName = jSONObject.optString("userName");
                            dqVar.fWB.fWD = jSONObject.optString("pagePath");
                            dqVar.fWB.fWE = 0;
                            dqVar.fWB.fWF = jSONObject.optInt("version");
                            dqVar.fWB.scene = 1035;
                            dqVar.fWB.fCN = this.jia;
                            com.tencent.mm.sdk.b.a.urY.m(dqVar);
                            break;
                        } catch (JSONException e) {
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        String str = iVar.id + iVar.arH;
        synchronized (this.ppU) {
            int i;
            for (int i2 = 0; i2 < this.vAq.size(); i2++) {
                if (((String) this.vAq.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i >= 0) {
                this.vAq.remove(i);
                w.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", str, Integer.valueOf(this.vAq.size()));
                return true;
            }
            w.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", str, Integer.valueOf(this.vAq.size()));
            return false;
        }
    }

    private void b(i iVar) {
        g.oUh.i(10809, this.jia, Integer.valueOf(iVar.id), iVar.arH, i.hvJ, "");
    }

    private void c(i iVar) {
        g.oUh.i(10809, this.jia, Integer.valueOf(iVar.id), iVar.arH, i.hvL, iVar.content);
    }

    public final boolean h(int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case bh.CTRL_INDEX /*201*/:
                case aq.CTRL_INDEX /*203*/:
                    i = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
                    i = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    w.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        w.e("ChatCustomFooter", "type error");
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (!file.exists() || !file.isFile()) {
                            w.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                            break;
                        }
                        w.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                        w.i("ChatCustomFooter", "MD5 is %s", com.tencent.mm.a.g.f(file));
                        if (this.vAt != null && (this.vAt.hvN == 102 || this.vAt.hvN == 103)) {
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.vAt.state = i.hvL;
                            this.vAt.e(arrayList);
                            if (a(this.vAt)) {
                                d(this.vAt);
                                c(this.vAt);
                                break;
                            }
                        }
                        w.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    w.e("ChatCustomFooter", "return null path");
                    break;
                    break;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    w.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        w.e("ChatCustomFooter", "type error");
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            w.i("ChatCustomFooter", "retrieving bitmap path %s", stringExtra);
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    w.i("ChatCustomFooter", "%s retrieved!", stringExtra);
                                    arrayList.add(com.tencent.mm.a.g.f(file2));
                                    w.i("ChatCustomFooter", "MD5 is %s", stringExtra);
                                } else {
                                    w.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", stringExtra);
                                }
                            } else {
                                w.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.vAt != null && (this.vAt.hvN == 104 || this.vAt.hvN == 103 || this.vAt.hvN == 102)) {
                            this.vAt.state = i.hvL;
                            this.vAt.e(arrayList);
                            if (a(this.vAt)) {
                                d(this.vAt);
                                c(this.vAt);
                                break;
                            }
                        }
                        w.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    w.i("ChatCustomFooter", "send qrcode wait msg");
                    if (bF(obj)) {
                        this.vAl.bWj();
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    w.i("ChatCustomFooter", "send qrcode direct");
                    bF(obj);
                    break;
                case MMBitmapFactory.ERROR_IO_FAILED /*1005*/:
                    w.i("ChatCustomFooter", "send current");
                    bE(obj);
                    break;
                case MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT /*1006*/:
                    w.i("ChatCustomFooter", "send selected");
                    bE(obj);
                    break;
                default:
                    break;
            }
        }
        w.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        return true;
    }

    private boolean bE(Object obj) {
        if (obj instanceof lf) {
            lf lfVar = (lf) obj;
            double d = lfVar.fRU.lat;
            double d2 = lfVar.fRU.lng;
            int i = lfVar.fRU.fOd;
            w.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), lfVar.fRU.label, lfVar.fRU.fRX);
            if (this.vAt == null || this.vAt.hvN != MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                w.e("ChatCustomFooter", "cache lost or location type is not correct");
            } else {
                this.vAt.state = i.hvL;
                i iVar = this.vAt;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", String.valueOf(d));
                    jSONObject.put("y", String.valueOf(d2));
                    jSONObject.put("scale", i);
                    jSONObject.put("label", r5);
                    jSONObject.put("poiname", r6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("location", jSONObject);
                    iVar.content = jSONObject2.toString();
                    w.v("MicroMsg.BizMenuItem", iVar.content);
                } catch (JSONException e) {
                    w.e("MicroMsg.BizMenuItem", e.toString());
                }
                if (a(this.vAt)) {
                    d(this.vAt);
                    c(this.vAt);
                }
            }
        } else {
            w.e("ChatCustomFooter", "send current location data type error!");
        }
        return true;
    }

    private boolean bF(Object obj) {
        if (obj instanceof lg) {
            lg lgVar = (lg) obj;
            if (this.vAt == null || !(this.vAt.hvN == 100 || this.vAt.hvN == 101)) {
                w.e("ChatCustomFooter", "null pointer in cache or type error");
                return false;
            }
            Object obj2;
            switch (lgVar.fRY.fSa) {
                case 0:
                    obj2 = "qrcode";
                    break;
                case 1:
                    obj2 = "barcode";
                    break;
                default:
                    obj2 = "";
                    break;
            }
            w.i("ChatCustomFooter", "scan type: %s , scan result:%s", obj2, lgVar.fRY.scanResult);
            this.vAt.state = i.hvL;
            i iVar = this.vAt;
            w.v("MicroMsg.BizMenuItem", "type is %s , result is %s", obj2, r3);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scan_type", obj2);
                jSONObject.put("scan_result", r3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_code", jSONObject);
                iVar.content = jSONObject2.toString();
                w.v("MicroMsg.BizMenuItem", "content: %s", iVar.content);
            } catch (JSONException e) {
                w.e("MicroMsg.BizMenuItem", e.toString());
            }
            if (a(this.vAt)) {
                d(this.vAt);
                c(this.vAt);
            }
            return true;
        }
        w.e("ChatCustomFooter", "send current location data type error!");
        return false;
    }

    private void d(i iVar) {
        w.i("ChatCustomFooter", iVar.getInfo());
        ap.vd().a(new com.tencent.mm.modelbiz.p(this.jia, 1, iVar.getInfo(), null), 0);
    }

    public final void k(ViewGroup viewGroup) {
        this.kZi = (LinearLayout) findViewById(R.h.bAx);
        this.vAj = (ImageView) findViewById(R.h.bAB);
        this.vAj.setVisibility(0);
        this.vAj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooterCustom vAu;

            {
                this.vAu = r1;
            }

            public final void onClick(View view) {
                this.vAu.bTW();
            }
        });
        this.vAi = (ImageView) findViewById(R.h.bAw);
        this.vAi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChatFooterCustom vAu;

            {
                this.vAu = r1;
            }

            public final void onClick(View view) {
                this.vAu.vAk.bTY();
                ImageView imageView = (ImageView) view;
                int i;
                int i2;
                if (imageView.getTag() == null) {
                    imageView.setTag(new Object());
                    imageView.setImageResource(R.g.bhf);
                    for (i = 0; i < this.vAu.vAm; i++) {
                        View childAt = this.vAu.kZi.getChildAt(i);
                        if (i >= 3) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        childAt.setVisibility(i2);
                    }
                    return;
                }
                imageView.setTag(null);
                imageView.setImageResource(R.g.bhe);
                for (i = 0; i < this.vAu.vAm; i++) {
                    childAt = this.vAu.kZi.getChildAt(i);
                    if (i < 3) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    childAt.setVisibility(i2);
                }
            }
        });
        this.vAk = new y(getContext(), viewGroup);
        this.vAk.vAv = new OnItemClickListener(this) {
            final /* synthetic */ ChatFooterCustom vAu;

            {
                this.vAu = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.vAu.onClick(view);
            }
        };
    }

    public final void a(com.tencent.mm.y.d.a aVar) {
        String a = n.a(aVar.hst.tff);
        w.i("ChatCustomFooter", "SysCmdMsgExtension:" + a);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!SlookAirButtonFrequentContactAdapter.DATA.equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!Columns.TYPE.equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
        }
    }

    private void bTW() {
        w.i("ChatCustomFooter", "switch footer");
        if (this.sPc != null) {
            this.vAk.bTY();
            this.sPc.jH(true);
        }
    }

    private void bTX() {
        if (this.fOK != null && this.fOK.gkJ == 1) {
            ap.yY();
            com.tencent.mm.u.c.wW().Rq(this.fOK.field_username);
        }
    }
}
