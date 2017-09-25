package com.tencent.mm.plugin.accountsync.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b {

    public interface a {
        int bt(Context context);
    }

    public static final class b implements a {
        private String isg;
        private int toScene;
        private Uri uri;

        public final int bt(android.content.Context r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r11 = this;
            r2 = 3;
            r7 = 0;
            r4 = 2;
            r3 = 0;
            r6 = 1;
            if (r12 != 0) goto L_0x0012;
        L_0x0007:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "null context";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r0 = r6;
        L_0x0011:
            return r0;
        L_0x0012:
            r0 = com.tencent.mm.u.ap.za();
            if (r0 == 0) goto L_0x001e;
        L_0x0018:
            r0 = com.tencent.mm.u.ap.uP();
            if (r0 == 0) goto L_0x0029;
        L_0x001e:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "not login, start bind login";
            com.tencent.mm.sdk.platformtools.w.d(r0, r1);
            r0 = r2;
            goto L_0x0011;
        L_0x0029:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r1 = 6;
            r5 = "";
            r0 = r0.get(r1, r5);
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 == 0) goto L_0x004b;
        L_0x0040:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "not bind mobile, start bind mobie";
            com.tencent.mm.sdk.platformtools.w.d(r0, r1);
            r0 = r4;
            goto L_0x0011;
        L_0x004b:
            r0 = "android.permission.READ_CONTACTS";
            r0 = com.tencent.mm.pluginsdk.i.a.aT(r12, r0);
            if (r0 != 0) goto L_0x005f;
        L_0x0054:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "no contacts permission";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r0 = r6;
            goto L_0x0011;
        L_0x005f:
            r0 = r11.uri;
            if (r0 == 0) goto L_0x0140;
        L_0x0063:
            r0 = r12.getContentResolver();
            r1 = r11.uri;
            r2 = new java.lang.String[r2];
            r5 = "contact_id";
            r2[r7] = r5;
            r5 = "_id";
            r2[r6] = r5;
            r5 = "data4";
            r2[r4] = r5;
            r4 = r3;
            r5 = r3;
            r3 = r0.query(r1, r2, r3, r4, r5);
            if (r3 != 0) goto L_0x008d;
        L_0x0082:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "query database err";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r0 = r6;
            goto L_0x0011;
        L_0x008d:
            r0 = r3.moveToFirst();
            if (r0 != 0) goto L_0x00a2;
        L_0x0093:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "query database err, move to first fail";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r3.close();
            r0 = r6;
            goto L_0x0011;
        L_0x00a2:
            r0 = "data4";
            r0 = r3.getColumnIndex(r0);
            r1 = -1;
            if (r0 != r1) goto L_0x00bb;
        L_0x00ac:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "no data4 segment exist";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r3.close();
            r0 = r6;
            goto L_0x0011;
        L_0x00bb:
            r2 = "";
            r1 = "";
            r4 = "";
            r2 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r0 = "contact_id";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            if (r0 < 0) goto L_0x00f7;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        L_0x00d1:
            r1 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        L_0x00d5:
            r0 = "_id";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            if (r0 < 0) goto L_0x00fb;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        L_0x00de:
            r0 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        L_0x00e2:
            r3.close();
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
            if (r3 == 0) goto L_0x013a;
        L_0x00eb:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "null friendmobile";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r0 = r6;
            goto L_0x0011;
        L_0x00f7:
            r1 = "";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            goto L_0x00d5;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        L_0x00fb:
            r0 = "";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            goto L_0x00e2;
        L_0x00ff:
            r0 = move-exception;
            r5 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7 = "match error, %s\n%s";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r8 = 2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r9 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r10 = r0.getMessage();	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r9 = 1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r8[r9] = r0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            com.tencent.mm.sdk.platformtools.w.e(r5, r7, r8);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r5 = "result friendMobileMd5 %s contact_id %s data_id %s";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7 = 3;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r8 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7[r8] = r2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r2 = 1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7[r2] = r1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r1 = 2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r7[r1] = r4;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            com.tencent.mm.sdk.platformtools.w.e(r0, r5, r7);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
            r3.close();
            r0 = r6;
            goto L_0x0011;
        L_0x0135:
            r0 = move-exception;
            r3.close();
            throw r0;
        L_0x013a:
            r0 = r11.c(r12, r2, r0, r1);
            goto L_0x0011;
        L_0x0140:
            r0 = r11.isg;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 != 0) goto L_0x015c;
        L_0x0148:
            r0 = r11.isg;
            r0 = com.tencent.mm.pluginsdk.a.Di(r0);
            r0 = r0.getBytes();
            r0 = com.tencent.mm.a.g.n(r0);
            r0 = r11.c(r12, r0, r3, r3);
            goto L_0x0011;
        L_0x015c:
            r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
            r1 = "uri is null and the phone num is null";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            r0 = r6;
            goto L_0x0011;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.accountsync.model.b.b.bt(android.content.Context):int");
        }

        public b(int i, String str, Uri uri) {
            this.toScene = i;
            this.isg = str;
            this.uri = uri;
        }

        private int c(Context context, String str, String str2, String str3) {
            com.tencent.mm.modelfriend.b ja = af.FY().ja(str);
            if (context == null) {
                w.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                return 1;
            } else if (ja == null) {
                w.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
                return 1;
            } else {
                String username = ja.getUsername();
                if (bg.mA(username)) {
                    w.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is " + str);
                    return 1;
                }
                ap.yY();
                if (c.wR().QY(username)) {
                    g.oUh.i(11157, Integer.valueOf(this.toScene));
                    com.tencent.mm.sdk.b.b rrVar;
                    switch (this.toScene) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", username);
                            intent.putExtra("finish_direct", true);
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.c.a.imv.e(intent, context);
                            return 0;
                        case 2:
                            Intent intent2 = new Intent();
                            intent2.putExtra("sns_userName", username);
                            intent2.addFlags(67108864);
                            d.b(context, "sns", ".ui.SnsUserUI", intent2);
                            return 0;
                        case 3:
                            rrVar = new rr();
                            rrVar.fYI.fJK = 5;
                            rrVar.fYI.fJL = username;
                            rrVar.fYI.context = context;
                            rrVar.fYI.fYD = 3;
                            com.tencent.mm.sdk.b.a.urY.m(rrVar);
                            return 0;
                        case 4:
                            rrVar = new rr();
                            rrVar.fYI.fJK = 5;
                            rrVar.fYI.fJL = username;
                            rrVar.fYI.context = context;
                            rrVar.fYI.fYD = 2;
                            com.tencent.mm.sdk.b.a.urY.m(rrVar);
                            return 0;
                        default:
                            return 1;
                    }
                } else if (bg.mA(str3) || bg.mA(str2)) {
                    return 1;
                } else {
                    if (com.tencent.mm.pluginsdk.i.a.aT(context, "android.permission.READ_CONTACTS")) {
                        Toast.makeText(context, context.getString(R.l.eaF), 1).show();
                        context.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{str2});
                        context.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                        return 1;
                    }
                    w.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                    return 1;
                }
            }
        }
    }
}
