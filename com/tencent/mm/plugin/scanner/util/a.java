package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.n.c;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a implements e {
    public Bundle fFu;
    public Activity fPi;
    public ProgressDialog isv;

    class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ f pbM;
        final /* synthetic */ a pcU;

        public AnonymousClass1(a aVar, f fVar) {
            this.pcU = aVar;
            this.pbM = fVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.pcU.aYU();
            ap.vd().c(this.pbM);
        }
    }

    public final void aYU() {
        ap.vd().b(1061, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        aYU();
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 4 && i2 == -4) {
            g.a(this.fPi, R.l.eHq, R.l.dIO, null);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ap.vd().BS()) {
                    com.tencent.mm.pluginsdk.ui.k.u(this.fPi, ap.vd().getNetworkServerIp(), String.valueOf(i2));
                } else if (aa.bn(this.fPi)) {
                    com.tencent.mm.pluginsdk.ui.k.dD(this.fPi);
                } else {
                    Toast.makeText(this.fPi, this.fPi.getString(R.l.elu, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.fPi, this.fPi.getString(R.l.elv), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        if (i == 4 && i2 == -2004) {
            g.h(this.fPi, R.l.eHl, R.l.dIO);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.fPi, this.fPi.getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        } else if (kVar.getType() == 1061) {
            he aXZ = ((f) kVar).aXZ();
            if (aXZ == null) {
                w.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                return;
            }
            w.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(aXZ.jOc)});
            if (!bg.mA(aXZ.tlg)) {
                int i3 = aXZ.jOc;
                Context context = this.fPi;
                String str2 = aXZ.tlg;
                int i4 = ((f) kVar).fFo;
                int i5 = ((f) kVar).fFp;
                e eVar = new e();
                Bundle bundle = this.fFu;
                int DO = n.DO(str2);
                w.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(DO)});
                Intent intent;
                if (DO == 1) {
                    c DP = n.DP(str2);
                    if (DP == null || bg.mA(DP.username)) {
                        w.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        obj = 2;
                    } else {
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(DP.username);
                        if (Rc == null || ((int) Rc.gTQ) <= 0) {
                            eVar.a(context, DP.username, 2, i4, i5, null, bundle);
                            obj = 1;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Contact_User", Rc.field_username);
                            intent.setFlags(65536);
                            b.imv.d(intent, context);
                            obj = null;
                        }
                    }
                } else if (DO == 2) {
                    n.b DQ = n.DQ(str2);
                    if (DQ == null || bg.mA(DQ.hSX)) {
                        w.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        obj = 2;
                    } else {
                        w.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{DQ.hSX});
                        if (i3 == 5) {
                            ((d) h.h(d.class)).b(context, DQ.hSX, 1031, bundle);
                            obj = null;
                        } else {
                            intent = new Intent();
                            intent.putExtra("rawUrl", DQ.hSX);
                            intent.setFlags(65536);
                            b.imv.j(intent, context);
                            obj = null;
                        }
                    }
                } else if (DO == 3 || DO == 4) {
                    w.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(4), Boolean.valueOf(true)});
                    intent = new Intent();
                    intent.setClass(context, ProductUI.class);
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", str2);
                    intent.putExtra("key_Product_funcType", 4);
                    intent.putExtra("key_ProductUI_addToDB", true);
                    intent.putExtra("key_need_add_to_history", true);
                    intent.putExtra("key_is_from_barcode", true);
                    context.startActivity(intent);
                    obj = null;
                } else {
                    w.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    w.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str2});
                    obj = 2;
                }
                switch (obj) {
                    case null:
                        w.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                        return;
                    case 1:
                        w.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        return;
                    case 2:
                        w.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
