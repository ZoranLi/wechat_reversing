package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.y.e;

public final class c {

    static class AnonymousClass1 implements e {
        final /* synthetic */ int lTY = 3;
        final /* synthetic */ String lTZ;
        final /* synthetic */ b lUa;

        public AnonymousClass1(String str, b bVar) {
            this.lTZ = str;
            this.lUa = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.y.k r13) {
            /*
            r9 = this;
            r0 = r9.lTY;
            r1 = "MicroMsg.FreeWifi.Protocol31Handler";
            r2 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] returns. errType=%d, errCode=%d, errMsg=%s";
            r3 = 5;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = r9.lTZ;
            r3[r4] = r5;
            r4 = 1;
            r0 = r0 + 1;
            r5 = java.lang.Integer.valueOf(r0);
            r3[r4] = r5;
            r4 = 2;
            r5 = java.lang.Integer.valueOf(r10);
            r3[r4] = r5;
            r4 = 3;
            r5 = java.lang.Integer.valueOf(r11);
            r3[r4] = r5;
            r4 = 4;
            r3[r4] = r12;
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
            if (r10 != 0) goto L_0x00f9;
        L_0x002f:
            if (r11 != 0) goto L_0x00f9;
        L_0x0031:
            r1 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;
            monitor-enter(r1);
            r2 = r9.lUa;	 Catch:{ all -> 0x00cc }
            r3 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x00cc }
            r3 = r3.awy();	 Catch:{ all -> 0x00cc }
            if (r2 == r3) goto L_0x0040;
        L_0x003e:
            monitor-exit(r1);	 Catch:{ all -> 0x00cc }
        L_0x003f:
            return;
        L_0x0040:
            r2 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x00cc }
            r2.awz();	 Catch:{ all -> 0x00cc }
            monitor-exit(r1);	 Catch:{ all -> 0x00cc }
            r13 = (com.tencent.mm.plugin.freewifi.d.g) r13;
            r1 = r13.awT();
            r2 = "MicroMsg.FreeWifi.Protocol31Handler";
            r3 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema.callback, desc=net request [GetInterruptedProtocol31] gets response. schemaUrl=%s";
            r4 = 3;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r6 = r9.lTZ;
            r4[r5] = r6;
            r5 = 1;
            r6 = r0 + 1;
            r0 = java.lang.Integer.valueOf(r6);
            r4[r5] = r0;
            r0 = 2;
            r4[r0] = r1;
            com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
            r0 = com.tencent.mm.plugin.freewifi.m.wx(r1);
            if (r0 != 0) goto L_0x003f;
        L_0x006f:
            r0 = "apKey=([^&]+)&ticket=([^&$]+)";
            r0 = java.util.regex.Pattern.compile(r0);
            r0 = r0.matcher(r1);
            r2 = r0.find();
            if (r2 == 0) goto L_0x003f;
        L_0x0080:
            r2 = 1;
            r2 = r0.group(r2);
            r3 = "utf8";
            r1 = java.net.URLDecoder.decode(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x00cf }
            r2 = 2;
            r0 = r0.group(r2);
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = "free_wifi_ap_key";
            r2.putExtra(r3, r1);
            r1 = "free_wifi_source";
            r3 = 5;
            r2.putExtra(r1, r3);
            r1 = "free_wifi_threeone_startup_type";
            r3 = 2;
            r2.putExtra(r1, r3);
            r1 = "free_wifi_schema_ticket";
            r2.putExtra(r1, r0);
            r1 = "free_wifi_sessionkey";
            r2.putExtra(r1, r0);
            r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r2.addFlags(r0);
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
            r1 = com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.class;
            r2.setClass(r0, r1);
            com.tencent.mm.plugin.freewifi.e.b.awY();
            com.tencent.mm.plugin.freewifi.e.b.D(r2);
            goto L_0x003f;
        L_0x00cc:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00cc }
            throw r0;
        L_0x00cf:
            r0 = move-exception;
            r3 = "MicroMsg.FreeWifi.Protocol31Handler";
            r4 = "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s";
            r5 = 5;
            r5 = new java.lang.Object[r5];
            r7 = 0;
            r8 = r9.lTZ;
            r5[r7] = r8;
            r7 = 1;
            r6 = r6 + 1;
            r6 = java.lang.Integer.valueOf(r6);
            r5[r7] = r6;
            r6 = 2;
            r5[r6] = r1;
            r1 = 3;
            r5[r1] = r2;
            r1 = 4;
            r0 = r0.getMessage();
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
            goto L_0x003f;
        L_0x00f9:
            r0 = -30020; // 0xffffffffffff8abc float:NaN double:NaN;
            if (r11 != r0) goto L_0x003f;
        L_0x00fd:
            r1 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;
            monitor-enter(r1);
            r0 = r9.lUa;	 Catch:{ all -> 0x010d }
            r2 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x010d }
            r2 = r2.awy();	 Catch:{ all -> 0x010d }
            if (r0 == r2) goto L_0x0110;
        L_0x010a:
            monitor-exit(r1);	 Catch:{ all -> 0x010d }
            goto L_0x003f;
        L_0x010d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x010d }
            throw r0;
        L_0x0110:
            r0 = com.tencent.mm.plugin.freewifi.model.f.a.lTl;	 Catch:{ all -> 0x010d }
            r0.awz();	 Catch:{ all -> 0x010d }
            monitor-exit(r1);	 Catch:{ all -> 0x010d }
            goto L_0x003f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.c.1.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
        }
    }
}
