package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g implements a {
    public final boolean a(Context context, final String[] strArr) {
        if (strArr.length < 2) {
            w.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            return false;
        }
        int i;
        String str = strArr[1];
        if (b.bIu()) {
            i = -1;
            switch (str.hashCode()) {
                case -838846263:
                    if (str.equals("update")) {
                        i = 0;
                        break;
                    }
                    break;
                case 3510:
                    if (str.equals("nd")) {
                        i = 4;
                        break;
                    }
                    break;
                case 3083269:
                    if (str.equals("diff")) {
                        i = 2;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        i = 3;
                        break;
                    }
                    break;
                case 3529469:
                    if (str.equals("show")) {
                        i = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        i = 5;
                        break;
                    }
                    break;
            }
            String str2;
            String str3;
            switch (i) {
                case 0:
                    w.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    Object linkedList = new LinkedList();
                    bfe com_tencent_mm_protocal_c_bfe = new bfe();
                    com_tencent_mm_protocal_c_bfe.arH = "wifi";
                    com_tencent_mm_protocal_c_bfe.value = "1";
                    linkedList.add(com_tencent_mm_protocal_c_bfe);
                    str2 = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde";
                    str3 = "";
                    if (strArr.length >= 3) {
                        str = strArr[2];
                    } else {
                        str = str2;
                    }
                    if (strArr.length >= 4) {
                        str3 = strArr[3];
                    }
                    if (strArr.length >= 5) {
                        com_tencent_mm_protocal_c_bfe = new bfe();
                        com_tencent_mm_protocal_c_bfe.arH = "sdk";
                        com_tencent_mm_protocal_c_bfe.value = strArr[4];
                        linkedList.add(com_tencent_mm_protocal_c_bfe);
                    } else {
                        com_tencent_mm_protocal_c_bfe = new bfe();
                        com_tencent_mm_protocal_c_bfe.arH = "sdk";
                        com_tencent_mm_protocal_c_bfe.value = String.valueOf(VERSION.SDK_INT);
                        linkedList.add(com_tencent_mm_protocal_c_bfe);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bfe = (bfe) it.next();
                        stringBuilder.append(com_tencent_mm_protocal_c_bfe.arH).append(":").append(com_tencent_mm_protocal_c_bfe.value).append("\n");
                    }
                    w.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", new Object[]{str, str3, stringBuilder.toString()});
                    ap.vd().a(new com.tencent.mm.plugin.hp.c.a(str, str3, linkedList), 0);
                    return true;
                case 1:
                    i.a(ab.getContext().getString(R.l.emb), ab.getContext().getString(R.l.emb), ab.getContext().getString(R.l.esE), new OnClickListener(this) {
                        final /* synthetic */ g mLt;

                        {
                            this.mLt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(ab.getContext(), "OK", 0).show();
                        }
                    }, ab.getContext().getString(R.l.eYQ), null);
                    return true;
                case 2:
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ g mLt;

                        public final void run() {
                            int i;
                            String str = e.hgu + "/Download/2017-07-28_19-43-39.apk";
                            String str2 = e.hgu + "/Download/39-50-diff.apk";
                            String str3 = e.hgu + "/Download/new_50.apk";
                            String str4 = "ab099f75f740be5d88e178d662a36779";
                            if (strArr.length >= 3 && !bg.mA(strArr[2])) {
                                str = strArr[2];
                            }
                            if (strArr.length >= 4 && !bg.mA(strArr[3])) {
                                str2 = strArr[3];
                            }
                            if (strArr.length >= 5 && !bg.mA(strArr[4])) {
                                str3 = strArr[4];
                            }
                            if (strArr.length >= 6 && !bg.mA(strArr[5])) {
                                str4 = strArr[5];
                            }
                            if (com.tencent.mm.a.e.aO(str3)) {
                                i = 0;
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                i = com.tencent.mm.plugin.hp.a.b.b(str, str2, str3, str4);
                                w.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", new Object[]{Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i)});
                            }
                            if (i == 0) {
                                w.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
                                w.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", new Object[]{com.tencent.mm.a.g.aV(str3)});
                                com.tencent.mm.plugin.hp.a.a.ad(ab.getContext(), str3);
                                w.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
                                return;
                            }
                            w.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
                        }
                    });
                    return true;
                case 3:
                    str3 = "";
                    str = "";
                    str2 = "";
                    if (strArr.length >= 5) {
                        str3 = strArr[2];
                        str = strArr[3];
                        str2 = strArr[4];
                    }
                    com.tencent.mm.sdk.f.e.post(new com.tencent.mm.plugin.hp.d.a(str3, str, str2), "hp_apply_download_test");
                    return true;
                case 4:
                    if (strArr.length >= 6) {
                        bg.PZ(strArr[5]);
                    }
                    return true;
                case 5:
                    com.tencent.mm.plugin.hp.tinker.g.af(ab.getContext(), "");
                    return true;
                default:
                    w.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", new Object[]{str});
                    break;
            }
        }
        i = -1;
        switch (str.hashCode()) {
            case 94627080:
                if (str.equals("check")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                try {
                    com.tinkerboots.sdk.a.chU().mm(true);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                return true;
            default:
                w.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", new Object[]{str});
                return false;
        }
    }
}
