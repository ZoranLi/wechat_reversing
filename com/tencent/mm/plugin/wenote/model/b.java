package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b {
    public static String stF = "";
    public static HashMap<String, JSONArray> stG = new HashMap();
    public static String stI = (a.Mf() + "/fav_fileicon_recording.png");
    private static String stJ = (a.Mf() + "/ofm_file_icon.png");
    private static String stK = (a.Mf() + "/app_attach_file_icon_pic.png");
    public static String stL = (a.Mf() + "/location_msg.png");
    public static String stM = (a.Mf() + "/note_fav_not_support.png");
    public String fQG = "WeNote_0";
    private Runnable lGL = new Runnable(this) {
        final /* synthetic */ b stN;

        {
            this.stN = r1;
        }

        public final void run() {
            w.d("MicroMsg.WNNoteBase", "refresh adapter");
        }
    };
    public HashMap<String, String> soC = new HashMap();
    public boolean soD = false;
    public i stA = null;
    public d stB;
    public HashMap<String, r> stC = new HashMap();
    public HashMap<String, k> stD = new HashMap();
    public String stE = "";
    public rv stH = new rv();

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b stN;
        final /* synthetic */ String stP;

        public AnonymousClass3(b bVar, String str) {
            this.stN = bVar;
            this.stP = str;
        }

        public final void run() {
            b bVar = this.stN;
            String str = this.stP;
            List linkedList = new LinkedList();
            linkedList.add(bVar.stD.get(str));
            rv a = b.a(null, linkedList, null);
            if (a.tzn != null && a.tzn.size() > 0 && bVar.stH != null) {
                bVar.stH.tzn.add(a.tzn.get(0));
                ((k) bVar.stD.get(str)).lKv = ((rm) a.tzn.get(0)).lKv;
                e.bBd();
            }
        }
    }

    public abstract void Le(String str);

    public abstract void Lf(String str);

    public abstract void Lg(String str);

    public abstract void a(rm rmVar, String str);

    public abstract String g(rm rmVar);

    public abstract String h(rm rmVar);

    public abstract void n(rm rmVar);

    public final void dh(Context context) {
        String Mg = a.Mg();
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("key_load_js_without_delay", true);
        intent.putExtra("showShare", false);
        intent.putExtra("from_session", bBc());
        intent.putExtra("edit_status", this.soD);
        intent.putExtra("rawUrl", "file://" + Mg + "/WNNote.html");
        t(context, intent);
    }

    public final void bBa() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ b stN;

            {
                this.stN = r1;
            }

            public final void run() {
                this.stN.g(this.stN.stA.oOQ, false);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 stO;

                    {
                        this.stO = r1;
                    }

                    public final void run() {
                        JSONArray bBb = this.stO.stN.bBb();
                        if (!bg.mA(this.stO.stN.stE)) {
                            com.tencent.mm.sdk.b.b kbVar = new kb();
                            kbVar.fQz.type = 0;
                            kbVar.fQz.fQD = bBb;
                            kbVar.fQz.fQB = this.stO.stN.stE;
                            kbVar.fQz.fQF = this.stO.stN.stA.fQF;
                            kbVar.fQz.fQG = this.stO.stN.fQG;
                            com.tencent.mm.sdk.b.a.urY.m(kbVar);
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|dealWNoteInfo";
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.util.List<com.tencent.mm.protocal.c.rm> r13, boolean r14) {
        /*
        r12 = this;
        r3 = new com.tencent.mm.plugin.wenote.model.a.r;
        r3.<init>();
        r2 = 0;
        r4 = r13.iterator();
    L_0x000a:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x04bb;
    L_0x0010:
        r0 = r4.next();
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        r5 = new com.tencent.mm.plugin.wenote.model.a.k;
        r5.<init>();
        r1 = r0.tyk;
        r5.suI = r1;
        r1 = r0.aMw;
        r6 = 1;
        if (r1 != r6) goto L_0x0029;
    L_0x0024:
        r1 = "-1";
        r5.suI = r1;
    L_0x0029:
        r1 = r5.suI;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x0056;
    L_0x0031:
        r1 = "MicroMsg.WNNoteBase";
        r2 = "Note: DataItem.htmlid is null";
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
        r1 = r12.g(r0);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 != 0) goto L_0x0052;
    L_0x0044:
        r2 = com.tencent.mm.a.e.aO(r1);
        if (r2 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r12.stA;
        r2 = r0.fQF;
        com.tencent.mm.plugin.wenote.model.e.r(r2, r1);
    L_0x0051:
        return;
    L_0x0052:
        r12.n(r0);
        goto L_0x0051;
    L_0x0056:
        r1 = r5.suI;
        r6 = "WeNoteHtmlFile";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x00f0;
    L_0x0061:
        r1 = r12.g(r0);
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r6 != 0) goto L_0x00d1;
    L_0x006b:
        r6 = com.tencent.mm.a.e.aO(r1);
        if (r6 == 0) goto L_0x00d1;
    L_0x0071:
        r5 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x04f3 }
        r5.<init>(r1);	 Catch:{ FileNotFoundException -> 0x04f3 }
        r1 = com.tencent.mm.sdk.platformtools.bg.convertStreamToString(r5);	 Catch:{ FileNotFoundException -> 0x04f3 }
        r3.fQB = r1;	 Catch:{ FileNotFoundException -> 0x04f3 }
        r1 = r3.fQB;	 Catch:{ FileNotFoundException -> 0x04f3 }
        r1 = com.tencent.mm.plugin.wenote.b.a.Lu(r1);	 Catch:{ FileNotFoundException -> 0x04f3 }
        r2 = "MicroMsg.WNNoteBase";
        r5 = "local html file exist,dataid: %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ FileNotFoundException -> 0x00c3 }
        r7 = 0;
        r8 = r0.lKv;	 Catch:{ FileNotFoundException -> 0x00c3 }
        r6[r7] = r8;	 Catch:{ FileNotFoundException -> 0x00c3 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);	 Catch:{ FileNotFoundException -> 0x00c3 }
        r2 = stG;	 Catch:{ FileNotFoundException -> 0x00c3 }
        r5 = r3.fQB;	 Catch:{ FileNotFoundException -> 0x00c3 }
        r2.containsKey(r5);	 Catch:{ FileNotFoundException -> 0x00c3 }
    L_0x009a:
        r2 = "MicroMsg.WNNoteBase";
        r5 = "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r0.txi;
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        r8 = java.lang.Boolean.valueOf(r8);
        r6[r7] = r8;
        r7 = 1;
        r0 = r0.txk;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        r0 = java.lang.Boolean.valueOf(r0);
        r6[r7] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);
        r2 = r1;
        goto L_0x000a;
    L_0x00c3:
        r2 = move-exception;
    L_0x00c4:
        r5 = "MicroMsg.WNNoteBase";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r2, r6, r7);
        goto L_0x009a;
    L_0x00d1:
        r12.n(r0);
        r1 = "MicroMsg.WNNoteBase";
        r6 = "local html file not exist,download htmlfile,dataid: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r0.lKv;
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.w.i(r1, r6, r7);
        r1 = r12.soC;
        r6 = r0.lKv;
        r5 = r5.suI;
        r1.put(r6, r5);
        r1 = r2;
        goto L_0x009a;
    L_0x00f0:
        r1 = r5.suI;
        r6 = "-1";
        r1 = r1.equals(r6);
        if (r1 != 0) goto L_0x012b;
    L_0x00fb:
        r1 = r5.suI;
        r6 = 7;
        r1 = r1.substring(r6);
        r6 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bg.getInt(r1, r6);
        r6 = r12.fQG;
        r7 = 7;
        r6 = r6.substring(r7);
        r7 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.getInt(r6, r7);
        r7 = new java.lang.StringBuilder;
        r8 = "WeNote_";
        r7.<init>(r8);
        if (r6 <= r1) goto L_0x0181;
    L_0x011d:
        r1 = java.lang.String.valueOf(r6);
    L_0x0121:
        r1 = r7.append(r1);
        r1 = r1.toString();
        r12.fQG = r1;
    L_0x012b:
        r1 = r0.lKv;
        r5.lKv = r1;
        r1 = r0.aMw;
        switch(r1) {
            case 1: goto L_0x0186;
            case 2: goto L_0x01fe;
            case 3: goto L_0x0287;
            case 4: goto L_0x0414;
            case 5: goto L_0x0134;
            case 6: goto L_0x0314;
            case 7: goto L_0x0134;
            case 8: goto L_0x03ad;
            default: goto L_0x0134;
        };
    L_0x0134:
        r1 = new com.tencent.mm.plugin.wenote.model.a.f;
        r1.<init>();
        r6 = r5.suI;
        r1.suI = r6;
        r6 = 0;
        r1.type = r6;
        r6 = r5.lKv;
        r1.lKv = r6;
        r1.suH = r0;
        r0 = r12.g(r0);
        r6 = 1;
        r1.suJ = r6;
        r1.fQE = r0;
        r0 = stM;
        r1.fQH = r0;
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r0 = r0.getResources();
        r6 = com.tencent.mm.R.l.ejg;
        r0 = r0.getString(r6);
        r1.title = r0;
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r0 = r0.getResources();
        r6 = com.tencent.mm.R.l.eiP;
        r0 = r0.getString(r6);
        r1.content = r0;
        r0 = r3.suR;
        r0.add(r1);
        r0 = r12.stD;
        r5 = r5.suI;
        r0.put(r5, r1);
        goto L_0x000a;
    L_0x0181:
        r1 = java.lang.String.valueOf(r1);
        goto L_0x0121;
    L_0x0186:
        r1 = r0.desc;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x000a;
    L_0x018e:
        r1 = r3.suR;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x01ea;
    L_0x0196:
        r1 = r3.suR;
        r6 = r3.suR;
        r6 = r6.size();
        r6 = r6 + -1;
        r1 = r1.get(r6);
        if (r1 == 0) goto L_0x01ea;
    L_0x01a6:
        r1 = r3.suR;
        r6 = r3.suR;
        r6 = r6.size();
        r6 = r6 + -1;
        r1 = r1.get(r6);
        r1 = (com.tencent.mm.plugin.wenote.model.a.k) r1;
        r1 = r1.suI;
        r6 = "-1";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x01ea;
    L_0x01c1:
        r1 = r3.suR;
        r5 = r3.suR;
        r5 = r5.size();
        r5 = r5 + -1;
        r1 = r1.get(r5);
        r1 = (com.tencent.mm.plugin.wenote.model.a.o) r1;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r1.content;
        r5 = r5.append(r6);
        r0 = r0.desc;
        r0 = r5.append(r0);
        r0 = r0.toString();
        r1.content = r0;
        goto L_0x000a;
    L_0x01ea:
        r1 = new com.tencent.mm.plugin.wenote.model.a.e;
        r1.<init>();
        r5 = r5.suI;
        r1.suI = r5;
        r0 = r0.desc;
        r1.content = r0;
        r0 = r3.suR;
        r0.add(r1);
        goto L_0x000a;
    L_0x01fe:
        r1 = new com.tencent.mm.plugin.wenote.model.a.c;
        r1.<init>();
        r6 = r5.suI;
        r1.suI = r6;
        r6 = 2;
        r1.type = r6;
        r6 = r5.lKv;
        r1.lKv = r6;
        r1.suH = r0;
        r6 = r12.g(r0);
        r7 = r12.h(r0);
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r8 != 0) goto L_0x0245;
    L_0x021e:
        r8 = com.tencent.mm.a.e.aO(r7);
        if (r8 == 0) goto L_0x0245;
    L_0x0224:
        r1.fQE = r7;
    L_0x0226:
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r7 != 0) goto L_0x0277;
    L_0x022c:
        r7 = com.tencent.mm.a.e.aO(r6);
        if (r7 == 0) goto L_0x0277;
    L_0x0232:
        r0 = 1;
        r1.suJ = r0;
    L_0x0235:
        r1.suK = r6;
        r0 = r3.suR;
        r0.add(r1);
        r0 = r12.stD;
        r5 = r5.suI;
        r0.put(r5, r1);
        goto L_0x000a;
    L_0x0245:
        r8 = com.tencent.mm.a.e.aO(r6);
        if (r8 == 0) goto L_0x0252;
    L_0x024b:
        r7 = com.tencent.mm.plugin.wenote.b.b.eg(r6, r7);
        r1.fQE = r7;
        goto L_0x0226;
    L_0x0252:
        r12.a(r0, r7);
        r7 = stK;
        r1.fQE = r7;
        r7 = r12.soC;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = r0.lKv;
        r8 = r8.append(r9);
        r9 = "_t";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r9 = r5.suI;
        r7.put(r8, r9);
        goto L_0x0226;
    L_0x0277:
        r12.n(r0);
        r7 = 0;
        r1.suJ = r7;
        r7 = r12.soC;
        r0 = r0.lKv;
        r8 = r5.suI;
        r7.put(r0, r8);
        goto L_0x0235;
    L_0x0287:
        r1 = new com.tencent.mm.plugin.wenote.model.a.h;
        r1.<init>();
        r6 = r5.suI;
        r1.suI = r6;
        r6 = 4;
        r1.type = r6;
        r6 = r5.lKv;
        r1.lKv = r6;
        r1.suH = r0;
        r6 = r12.g(r0);
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r7 != 0) goto L_0x02f8;
    L_0x02a3:
        r7 = com.tencent.mm.a.e.aO(r6);
        if (r7 == 0) goto L_0x02f8;
    L_0x02a9:
        r1.fQE = r6;
        r6 = 1;
        r1.suJ = r6;
        r6 = stI;
        r1.fQH = r6;
        r6 = r0.duration;
        r1.length = r6;
    L_0x02b6:
        r6 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r7 = r0.duration;
        r8 = (long) r7;
        r7 = com.tencent.mm.plugin.wenote.model.e.aw(r8);
        r7 = (int) r7;
        r6 = com.tencent.mm.plugin.wenote.model.e.J(r6, r7);
        r1.suP = r6;
        r6 = r0.duration;
        r1.fKx = r6;
        r6 = new com.tencent.mm.e.a.fp;
        r6.<init>();
        r7 = r6.fKp;
        r8 = 17;
        r7.type = r8;
        r7 = r6.fKp;
        r7.fKr = r0;
        r7 = com.tencent.mm.sdk.b.a.urY;
        r7.m(r6);
        r6 = r6.fKq;
        r6 = r6.ret;
        r1.fKw = r6;
        r0 = r0.txx;
        r1.suC = r0;
        r0 = r3.suR;
        r0.add(r1);
        r0 = r12.stD;
        r5 = r5.suI;
        r0.put(r5, r1);
        goto L_0x000a;
    L_0x02f8:
        r12.n(r0);
        r6 = 0;
        r1.suJ = r6;
        r6 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r7 = com.tencent.mm.R.l.ejS;
        r6 = r6.getString(r7);
        r1.suQ = r6;
        r6 = r12.soC;
        r7 = r0.lKv;
        r8 = r5.suI;
        r6.put(r7, r8);
        goto L_0x02b6;
    L_0x0314:
        r6 = new com.tencent.mm.plugin.wenote.model.a.m;
        r6.<init>();
        r1 = r0.tyc;
        r1 = r1.tyw;
        r8 = r1.lat;
        r1 = (float) r8;
        r6.fOb = r1;
        r1 = r0.tyc;
        r1 = r1.tyw;
        r8 = r1.lng;
        r1 = (float) r8;
        r6.hGU = r1;
        r1 = r0.tyc;
        r1 = r1.tyw;
        r1 = r1.fOd;
        r6.fOd = r1;
        r1 = r0.tyc;
        r1 = r1.tyw;
        r1 = r1.label;
        r6.suL = r1;
        r1 = r0.tyc;
        r1 = r1.tyw;
        r1 = r1.fRX;
        r6.suM = r1;
        r1 = r0.tyk;
        r6.suN = r1;
        if (r14 != 0) goto L_0x0399;
    L_0x0349:
        r1 = 1;
    L_0x034a:
        r1 = com.tencent.mm.plugin.wenote.b.b.a(r6, r1);
        r7 = com.tencent.mm.a.e.aO(r1);
        if (r7 == 0) goto L_0x039b;
    L_0x0354:
        r7 = "MicroMsg.WNNoteBase";
        r8 = "fileExist suc, use getimagelocalpath";
        com.tencent.mm.sdk.platformtools.w.i(r7, r8);
    L_0x035d:
        r7 = new com.tencent.mm.plugin.wenote.model.a.d;
        r7.<init>();
        r8 = r5.suI;
        r7.suI = r8;
        r8 = 3;
        r7.type = r8;
        r8 = r5.lKv;
        r7.lKv = r8;
        r7.suH = r0;
        r0 = 1;
        r7.suJ = r0;
        r0 = r6.suM;
        r7.ndv = r0;
        r0 = r6.suL;
        r7.hCE = r0;
        r0 = r6.fOb;
        r8 = (double) r0;
        r7.lat = r8;
        r0 = r6.hGU;
        r8 = (double) r0;
        r7.lng = r8;
        r0 = r6.fOd;
        r8 = (double) r0;
        r7.suO = r8;
        r7.fQE = r1;
        r0 = r3.suR;
        r0.add(r7);
        r0 = r12.stD;
        r1 = r5.suI;
        r0.put(r1, r7);
        goto L_0x000a;
    L_0x0399:
        r1 = 0;
        goto L_0x034a;
    L_0x039b:
        r7 = "MicroMsg.WNNoteBase";
        r8 = "Temp file fileExist fail:%s ,use default file";
        r9 = 1;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r9[r10] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r7, r8, r9);
        r1 = stL;
        goto L_0x035d;
    L_0x03ad:
        r1 = new com.tencent.mm.plugin.wenote.model.a.b;
        r1.<init>();
        r6 = r5.suI;
        r1.suI = r6;
        r6 = 5;
        r1.type = r6;
        r6 = r5.lKv;
        r1.lKv = r6;
        r1.suH = r0;
        r6 = r12.g(r0);
        r7 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r7 != 0) goto L_0x0407;
    L_0x03c9:
        r7 = com.tencent.mm.a.e.aO(r6);
        if (r7 == 0) goto L_0x0407;
    L_0x03cf:
        r7 = 1;
        r1.suJ = r7;
        r1.fQE = r6;
    L_0x03d4:
        r6 = r0.txx;
        r6 = com.tencent.mm.plugin.wenote.model.g.Lm(r6);
        r1.fQH = r6;
        r6 = r0.title;
        r1.title = r6;
        r6 = r0.desc;
        r1.content = r6;
        r6 = r0.txx;
        r1.suC = r6;
        r6 = r1.content;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 == 0) goto L_0x03f9;
    L_0x03f0:
        r6 = r0.txD;
        r0 = (float) r6;
        r0 = com.tencent.mm.plugin.wenote.model.e.U(r0);
        r1.content = r0;
    L_0x03f9:
        r0 = r3.suR;
        r0.add(r1);
        r0 = r12.stD;
        r5 = r5.suI;
        r0.put(r5, r1);
        goto L_0x000a;
    L_0x0407:
        r6 = 0;
        r1.suJ = r6;
        r6 = r12.soC;
        r7 = r0.lKv;
        r8 = r5.suI;
        r6.put(r7, r8);
        goto L_0x03d4;
    L_0x0414:
        if (r14 == 0) goto L_0x0134;
    L_0x0416:
        r6 = new com.tencent.mm.plugin.wenote.model.a.g;
        r6.<init>();
        r1 = r5.suI;
        r6.suI = r1;
        r1 = 6;
        r6.type = r1;
        r1 = r5.lKv;
        r6.lKv = r1;
        r6.suH = r0;
        r1 = r12.h(r0);
        r6.fKz = r1;
        r7 = r12.g(r0);
        r6.fQE = r7;
        r1 = r6.fKz;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0460;
    L_0x043c:
        r1 = r6.fKz;
        r1 = com.tencent.mm.a.e.aO(r1);
        if (r1 != 0) goto L_0x0460;
    L_0x0444:
        r1 = com.tencent.mm.a.e.aO(r7);
        if (r1 == 0) goto L_0x048b;
    L_0x044a:
        r1 = com.tencent.mm.pluginsdk.model.c.LP(r7);
        if (r1 == 0) goto L_0x0460;
    L_0x0450:
        r8 = "MicroMsg.WNNoteBase";
        r9 = "add fav service: create thumbpath bitmap, saveBitmapToImage ";
        com.tencent.mm.sdk.platformtools.w.i(r8, r9);	 Catch:{ Exception -> 0x047d }
        r8 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x047d }
        r9 = r6.fKz;	 Catch:{ Exception -> 0x047d }
        com.tencent.mm.pluginsdk.m.e.a(r1, r8, r9);	 Catch:{ Exception -> 0x047d }
    L_0x0460:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r1 != 0) goto L_0x04ae;
    L_0x0466:
        r1 = com.tencent.mm.a.e.aO(r7);
        if (r1 == 0) goto L_0x04ae;
    L_0x046c:
        r0 = 1;
        r6.suJ = r0;
    L_0x046f:
        r0 = r3.suR;
        r0.add(r6);
        r0 = r12.stD;
        r1 = r5.suI;
        r0.put(r1, r6);
        goto L_0x000a;
    L_0x047d:
        r1 = move-exception;
        r8 = "MicroMsg.WNNoteBase";
        r9 = "";
        r10 = 0;
        r10 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r8, r1, r9, r10);
        goto L_0x0460;
    L_0x048b:
        r1 = r6.fKz;
        r12.a(r0, r1);
        r1 = r12.soC;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = r0.lKv;
        r8 = r8.append(r9);
        r9 = "_t";
        r8 = r8.append(r9);
        r8 = r8.toString();
        r9 = r5.suI;
        r1.put(r8, r9);
        goto L_0x0460;
    L_0x04ae:
        r1 = 0;
        r6.suJ = r1;
        r1 = r12.soC;
        r0 = r0.lKv;
        r7 = r5.suI;
        r1.put(r0, r7);
        goto L_0x046f;
    L_0x04bb:
        if (r2 == 0) goto L_0x04cb;
    L_0x04bd:
        r0 = r2.size();
        if (r0 <= 0) goto L_0x04cb;
    L_0x04c3:
        if (r14 == 0) goto L_0x04cb;
    L_0x04c5:
        r0 = r3.suR;
        r1 = 1;
        com.tencent.mm.plugin.wenote.model.g.a(r0, r2, r1);
    L_0x04cb:
        r0 = r12.stA;
        r0 = r0.fGM;
        r4 = -1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x04e4;
    L_0x04d5:
        r0 = r12.stC;
        r1 = r12.stA;
        r4 = r1.fQF;
        r1 = java.lang.Long.toString(r4);
        r0.put(r1, r3);
        goto L_0x0051;
    L_0x04e4:
        r0 = r12.stC;
        r1 = r12.stA;
        r4 = r1.fGM;
        r1 = java.lang.Long.toString(r4);
        r0.put(r1, r3);
        goto L_0x0051;
    L_0x04f3:
        r1 = move-exception;
        r11 = r1;
        r1 = r2;
        r2 = r11;
        goto L_0x00c4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.b.g(java.util.List, boolean):void");
    }

    public final JSONArray bBb() {
        r rVar;
        JSONArray jSONArray = new JSONArray();
        if (this.stA.fGM != -1) {
            rVar = (r) this.stC.get(Long.toString(this.stA.fGM));
        } else {
            rVar = (r) this.stC.get(Long.toString(this.stA.fQF));
        }
        if (rVar == null) {
            return null;
        }
        rVar.fQB = g.Lo(rVar.fQB);
        this.stE = rVar.fQB;
        stF = this.stE;
        for (k kVar : rVar.suR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localEditorId", kVar.suI);
                jSONObject.put(Columns.TYPE, kVar.type);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
            }
            switch (kVar.type) {
                case 1:
                case 6:
                    break;
                case 2:
                    try {
                        jSONObject.put("width", ((l) kVar).width);
                        jSONObject.put("height", ((l) kVar).height);
                        jSONObject.put("downloaded", kVar.suJ);
                        jSONObject.put("localPath", kVar.fQE);
                        break;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                        break;
                    }
                case 3:
                    try {
                        jSONObject.put("downloaded", kVar.suJ);
                        if (kVar.fQE.endsWith("_temp.png")) {
                            String replaceAll = kVar.fQE.replaceAll("_temp.png", ".png");
                            if (e.aO(replaceAll)) {
                                w.d("MicroMsg.WNNoteBase", "wenote location thumb use thumbfile");
                                jSONObject.put("localPath", replaceAll);
                            } else {
                                jSONObject.put("localPath", kVar.fQE);
                            }
                        } else {
                            jSONObject.put("localPath", kVar.fQE);
                        }
                        jSONObject.put("poiName", ((n) kVar).ndv);
                        jSONObject.put("address", ((n) kVar).hCE);
                        jSONObject.put("lat", ((n) kVar).lat);
                        jSONObject.put("lng", ((n) kVar).lng);
                        break;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e22, "", new Object[0]);
                        break;
                    }
                case 4:
                    try {
                        jSONObject.put("downloaded", kVar.suJ);
                        if (!kVar.suJ) {
                            jSONObject.put("lengthStr", ((q) kVar).suP);
                            jSONObject.put("placeHolder", ((q) kVar).suQ);
                            break;
                        }
                        jSONObject.put("length", ((q) kVar).length);
                        jSONObject.put("lengthStr", ((q) kVar).suP);
                        jSONObject.put("iconPath", ((q) kVar).fQH);
                        jSONObject.put("localPath", ((q) kVar).fQE);
                        break;
                    } catch (Throwable e222) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e222, "", new Object[0]);
                        break;
                    }
                case 5:
                    try {
                        jSONObject.put("downloaded", kVar.suJ);
                        jSONObject.put("localPath", kVar.fQE);
                        jSONObject.put("iconPath", ((p) kVar).fQH);
                        jSONObject.put("title", ((p) kVar).title);
                        jSONObject.put("content", ((p) kVar).content);
                        break;
                    } catch (Throwable e2222) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e2222, "", new Object[0]);
                        break;
                    }
                default:
                    try {
                        jSONObject.put("downloaded", kVar.suJ);
                        jSONObject.put("localPath", kVar.fQE);
                        jSONObject.put("iconPath", ((j) kVar).fQH);
                        jSONObject.put("title", ((j) kVar).title);
                        jSONObject.put("content", ((j) kVar).content);
                        break;
                    } catch (Throwable e22222) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e22222, "", new Object[0]);
                        break;
                    }
            }
            jSONArray.put(jSONObject);
        }
        stG.put(this.stE, jSONArray);
        return jSONArray;
    }

    public boolean bBc() {
        return false;
    }

    public void t(Context context, Intent intent) {
        d.b(context, "webview", ".ui.tools.wenote.WNNoteWebViewUI", intent);
    }

    public final boolean b(ka kaVar) {
        if (kaVar.fQo != null) {
            String str = kaVar.fQo.fQq;
            switch (((k) this.stD.get(str)).type) {
                case 2:
                    Lg(str);
                    break;
                case 3:
                    Lf(str);
                    break;
                case 4:
                    q qVar = (q) this.stD.get(str);
                    com.tencent.mm.sdk.b.b fpVar = new fp();
                    fpVar.fKp.type = 20;
                    fpVar.fKp.title = qVar.fQE;
                    fpVar.fKp.fKw = qVar.fKw;
                    fpVar.fKp.fKx = qVar.fKx;
                    com.tencent.mm.sdk.b.a.urY.m(fpVar);
                    fpVar = new kb();
                    fpVar.fQz.type = 2;
                    fpVar.fQz.fQE = qVar.fQE;
                    fpVar.fQz.fKw = qVar.fKw;
                    fpVar.fQz.fKx = qVar.fKx;
                    com.tencent.mm.sdk.b.a.urY.m(fpVar);
                    break;
                case 5:
                    Le(str);
                    break;
                case 6:
                    g gVar = (g) this.stD.get(str);
                    if (!bg.mA(gVar.fQE)) {
                        if (!e.aO(gVar.fQE)) {
                            rm Li = Li(gVar.lKv);
                            if (Li == null) {
                                w.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                                break;
                            }
                            n(Li);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("key_detail_fav_path", gVar.fQE);
                        intent.putExtra("key_detail_fav_thumb_path", gVar.fKz);
                        intent.putExtra("key_detail_fav_video_duration", gVar.duration);
                        intent.putExtra("key_detail_data_id", gVar.lKv);
                        intent.putExtra("key_detail_statExtStr", "");
                        intent.putExtra("key_detail_fav_video_show_download_status", true);
                        d.b(ab.getContext(), "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        w.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
        return false;
    }

    public final void aF(String str, boolean z) {
        List arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("html");
            boolean z2 = jSONObject.getBoolean("isSuccess");
            if (z || !string.equals(stF)) {
                int i;
                JSONArray jSONArray = jSONObject.getJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                if (jSONArray != null) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            arrayList.add(this.stD.get(jSONObject2.getString("localEditorId")));
                        } else {
                            w.e("MicroMsg.WNNoteBase", "jsonArray.getJSONObject(%d) is null", new Object[]{Integer.valueOf(i)});
                        }
                    }
                }
                if (z2) {
                    ArrayList Lt = com.tencent.mm.plugin.wenote.b.a.Lt(string);
                    String str2 = " ";
                    if (Lt != null && Lt.size() == 1) {
                        str2 = g.Ln((String) Lt.get(0));
                    }
                    if (Lt != null && !bg.mA(r0)) {
                        if (Lt != null) {
                            if (Lt.size() > 0) {
                                Iterator it = Lt.iterator();
                                int i2 = 0;
                                while (it.hasNext()) {
                                    str2 = (String) it.next();
                                    if (str2.equals("[ThisisNoteNodeObj]")) {
                                        i2++;
                                    } else {
                                        str2 = str2.trim();
                                        if (str2.length() <= 0) {
                                            i = i2;
                                        } else if (i2 > arrayList.size()) {
                                            w.e("MicroMsg.WNNoteBase", "WeNote: index out of array");
                                            break;
                                        } else {
                                            o eVar = new com.tencent.mm.plugin.wenote.model.a.e();
                                            eVar.content = str2;
                                            arrayList.add(i2, eVar);
                                            i = i2 + 1;
                                        }
                                        i2 = i;
                                    }
                                }
                            }
                        }
                        byte[] bytes = string.getBytes();
                        String Mi = a.Mi();
                        File file = new File(Mi);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        if (e.b(Mi, bytes, bytes.length) == 0) {
                            rv a = a(string, arrayList, null);
                            com.tencent.mm.sdk.b.b fpVar;
                            if (z) {
                                fpVar = new fp();
                                fpVar.fKp.type = 19;
                                fpVar.fKp.fFC = a;
                                fpVar.fKp.title = string;
                                fpVar.fKp.fFx = -1;
                                com.tencent.mm.sdk.b.a.urY.m(fpVar);
                            } else {
                                fpVar = new fp();
                                fpVar.fKp.type = 19;
                                fpVar.fKp.fFC = a;
                                fpVar.fKp.title = string;
                                fpVar.fKp.fFx = this.stB.field_localId;
                                com.tencent.mm.sdk.b.a.urY.m(fpVar);
                            }
                            w.i("MicroMsg.WNNoteBase", "write html to file suc");
                        }
                    } else if (!z) {
                        com.tencent.mm.sdk.b.b fpVar2 = new fp();
                        fpVar2.fKp.type = 12;
                        fpVar2.fKp.fFx = this.stB.field_localId;
                        com.tencent.mm.sdk.b.a.urY.m(fpVar2);
                    }
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.rv a(java.lang.String r11, java.util.List<com.tencent.mm.plugin.wenote.model.a.k> r12, com.tencent.mm.protocal.c.rm r13) {
        /*
        r7 = new java.util.LinkedList;
        r7.<init>();
        r8 = new com.tencent.mm.protocal.c.rv;
        r8.<init>();
        if (r13 == 0) goto L_0x002b;
    L_0x000c:
        r7.add(r13);
    L_0x000f:
        r9 = r12.iterator();
    L_0x0013:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x01bf;
    L_0x0019:
        r6 = r9.next();
        r6 = (com.tencent.mm.plugin.wenote.model.a.k) r6;
        if (r6 == 0) goto L_0x0013;
    L_0x0021:
        r0 = r6.suH;
        if (r0 == 0) goto L_0x0064;
    L_0x0025:
        r0 = r6.suH;
        r7.add(r0);
        goto L_0x0013;
    L_0x002b:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r11);
        if (r0 != 0) goto L_0x000f;
    L_0x0031:
        r0 = r11.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x0037:
        r0 = com.tencent.mm.ay.a.Mi();
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        r2 = 8;
        r1.yb(r2);
        r2 = "WeNoteHtmlFile";
        r1.Oi(r2);
        r1.NZ(r0);
        r2 = 1;
        r1.jK(r2);
        r0 = com.tencent.mm.a.e.aN(r0);
        r2 = (long) r0;
        r1.ej(r2);
        r0 = ".htm";
        r1.NV(r0);
        r7.add(r1);
        goto L_0x000f;
    L_0x0064:
        r10 = new com.tencent.mm.protocal.c.rm;
        r10.<init>();
        r0 = new com.tencent.mm.protocal.c.rn;
        r0.<init>();
        r1 = new com.tencent.mm.protocal.c.ro;
        r1.<init>();
        r2 = 6;
        r1.ye(r2);
        r0.c(r1);
        r10.a(r0);
        r0 = r6.type;
        switch(r0) {
            case 1: goto L_0x018a;
            case 2: goto L_0x008b;
            case 3: goto L_0x00d3;
            case 4: goto L_0x012c;
            case 5: goto L_0x0105;
            case 6: goto L_0x0159;
            default: goto L_0x0082;
        };
    L_0x0082:
        r0 = r6.suI;
        r10.Oi(r0);
        r7.add(r10);
        goto L_0x0013;
    L_0x008b:
        r0 = 2;
        r10.yb(r0);
        r1 = r6;
        r1 = (com.tencent.mm.plugin.wenote.model.a.l) r1;
        r0 = r1.suK;
        r10.NZ(r0);
        r2 = r6;
        r2 = (com.tencent.mm.plugin.wenote.model.a.l) r2;
        r2 = r2.lKv;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x00b1;
    L_0x00a2:
        r0 = r6.lKv;
        r10.NY(r0);
        r0 = r1.fQE;
        r10.Oa(r0);
    L_0x00ac:
        r0 = 2;
        r10.yb(r0);
        goto L_0x0082;
    L_0x00b1:
        r1 = r1.toString();
        r1 = com.tencent.mm.plugin.wenote.model.e.Lj(r1);
        r10.NY(r1);
        r1 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r3 = android.graphics.Bitmap.CompressFormat.JPEG;
        r4 = 90;
        r5 = com.tencent.mm.plugin.wenote.model.e.h(r10);
        com.tencent.mm.sdk.platformtools.d.b(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.wenote.model.e.h(r10);
        r10.Oa(r0);
        goto L_0x00ac;
    L_0x00d3:
        r0 = 6;
        r10.yb(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.n) r0;
        r1 = r6.lKv;
        r10.NY(r1);
        r1 = new com.tencent.mm.protocal.c.rs;
        r1.<init>();
        r2 = r0.hCE;
        r1.Ou(r2);
        r2 = r0.lat;
        r1.m(r2);
        r2 = r0.lng;
        r1.l(r2);
        r2 = r0.suO;
        r2 = (int) r2;
        r1.yf(r2);
        r0 = r0.ndv;
        r1.Ov(r0);
        r0 = r10.tyc;
        r0.a(r1);
        goto L_0x0082;
    L_0x0105:
        r0 = 8;
        r10.yb(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.p) r0;
        r1 = r6.lKv;
        r10.NY(r1);
        r1 = r0.fQE;
        r10.NZ(r1);
        r1 = 1;
        r10.jK(r1);
        r1 = r0.title;
        r10.NL(r1);
        r1 = r0.content;
        r10.NM(r1);
        r0 = r0.suC;
        r10.NV(r0);
        goto L_0x0082;
    L_0x012c:
        r0 = 3;
        r10.yb(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.q) r0;
        r1 = r6.lKv;
        r10.NY(r1);
        r1 = r0.fQE;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 != 0) goto L_0x0013;
    L_0x0140:
        r2 = r1.length();
        if (r2 == 0) goto L_0x0013;
    L_0x0146:
        r10.NZ(r1);
        r1 = r0.length;
        r10.ya(r1);
        r1 = 1;
        r10.jK(r1);
        r0 = r0.suC;
        r10.NV(r0);
        goto L_0x0082;
    L_0x0159:
        r0 = 4;
        r10.yb(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.g) r0;
        r1 = r6.lKv;
        r10.NY(r1);
        r1 = r0.fQE;
        r10.NZ(r1);
        r1 = r0.fKz;
        r10.Oa(r1);
        r1 = r0.fQE;
        r1 = com.tencent.mm.plugin.sight.base.d.Er(r1);
        if (r1 == 0) goto L_0x0185;
    L_0x0177:
        r1 = r1.bbO();
        r10.ya(r1);
    L_0x017e:
        r0 = r0.suC;
        r10.NV(r0);
        goto L_0x0082;
    L_0x0185:
        r1 = 1;
        r10.ya(r1);
        goto L_0x017e;
    L_0x018a:
        r0 = 1;
        r10.yb(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;
        r1 = r6.lKv;
        r10.NY(r1);
        r0 = r0.content;
        r0 = com.tencent.mm.plugin.wenote.b.a.Kn(r0);
        r10.NM(r0);
        r0 = r10.desc;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0082;
    L_0x01a7:
        r0 = r10.desc;
        r0 = r0.length();
        r1 = 100;
        if (r0 <= r1) goto L_0x0082;
    L_0x01b1:
        r0 = r10.desc;
        r1 = 0;
        r2 = 100;
        r0 = r0.substring(r1, r2);
        r10.NM(r0);
        goto L_0x0082;
    L_0x01bf:
        as(r7);
        r8.av(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.b.a(java.lang.String, java.util.List, com.tencent.mm.protocal.c.rm):com.tencent.mm.protocal.c.rv");
    }

    private static void as(LinkedList<rm> linkedList) {
        w.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String aV;
                String aW;
                rm rmVar = (rm) linkedList.get(i);
                if (bg.mA(rmVar.lKv)) {
                    rmVar.NY(e.Lj(rmVar.toString()));
                }
                w.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(rmVar.aMw)});
                String str = rmVar.txG;
                if (FileOp.aO(str)) {
                    w.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[]{str});
                    aV = com.tencent.mm.a.g.aV(str);
                    aW = com.tencent.mm.a.g.aW(str);
                    rmVar.NW(aV);
                    rmVar.NX(aW);
                    rmVar.ej(new File(str).length());
                    aV = e.o(rmVar);
                    boolean aO = FileOp.aO(aV);
                    if (!(str.equals(aV) || aO || rmVar.tyk.equals("WeNoteHtmlFile"))) {
                        FileOp.p(str, aV);
                    }
                } else {
                    w.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[]{str});
                }
                str = rmVar.txI;
                if (FileOp.aO(str)) {
                    w.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[]{str});
                    aV = com.tencent.mm.a.g.aV(str);
                    aW = com.tencent.mm.a.g.aW(str);
                    rmVar.Ob(aV);
                    rmVar.Oc(aW);
                    rmVar.ek(new File(str).length());
                    String h = e.h(rmVar);
                    if (!(str.equals(h) || FileOp.aO(h))) {
                        FileOp.p(str, h);
                    }
                } else {
                    w.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[]{str});
                }
            }
        }
    }

    public void Lh(String str) {
    }

    public final rm Li(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.soC.get(str);
        if (bg.mA(str2)) {
            w.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[]{str});
            return null;
        }
        k kVar = (k) this.stD.get(str2);
        if (kVar != null) {
            return kVar.suH;
        }
        w.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[]{str2});
        return null;
    }
}
