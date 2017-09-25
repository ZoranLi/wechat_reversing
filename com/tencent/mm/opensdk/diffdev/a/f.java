package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener m;
    private String p;
    private String url;
    private int v;

    static class a {
        public OAuthErrCode o;
        public String w;
        public int x;

        a() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.opensdk.diffdev.a.f.a b(byte[] r9) {
            /*
            r8 = 1;
            r7 = 0;
            r0 = new com.tencent.mm.opensdk.diffdev.a.f$a;
            r0.<init>();
            if (r9 == 0) goto L_0x000c;
        L_0x0009:
            r1 = r9.length;
            if (r1 != 0) goto L_0x001a;
        L_0x000c:
            r1 = "MicroMsg.SDK.NoopingResult";
            r2 = "parse fail, buf is null";
            com.tencent.mm.opensdk.utils.Log.e(r1, r2);
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            r0.o = r1;
        L_0x0019:
            return r0;
        L_0x001a:
            r1 = new java.lang.String;	 Catch:{ Exception -> 0x006e }
            r2 = "utf-8";
            r1.<init>(r9, r2);	 Catch:{ Exception -> 0x006e }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0053 }
            r2.<init>(r1);	 Catch:{ Exception -> 0x0053 }
            r1 = "wx_errcode";
            r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0053 }
            r0.x = r1;	 Catch:{ Exception -> 0x0053 }
            r1 = "MicroMsg.SDK.NoopingResult";
            r3 = "nooping uuidStatusCode = %d";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0053 }
            r5 = 0;
            r6 = r0.x;	 Catch:{ Exception -> 0x0053 }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0053 }
            r4[r5] = r6;	 Catch:{ Exception -> 0x0053 }
            r3 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0053 }
            com.tencent.mm.opensdk.utils.Log.d(r1, r3);	 Catch:{ Exception -> 0x0053 }
            r1 = r0.x;	 Catch:{ Exception -> 0x0053 }
            switch(r1) {
                case 402: goto L_0x00a3;
                case 403: goto L_0x00a9;
                case 404: goto L_0x0097;
                case 405: goto L_0x0089;
                case 408: goto L_0x009d;
                case 500: goto L_0x00af;
                default: goto L_0x004e;
            };	 Catch:{ Exception -> 0x0053 }
        L_0x004e:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x0053:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse json fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            com.tencent.mm.opensdk.utils.Log.e(r2, r1);
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.o = r1;
            goto L_0x0019;
        L_0x006e:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse fail, build String fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            com.tencent.mm.opensdk.utils.Log.e(r2, r1);
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.o = r1;
            goto L_0x0019;
        L_0x0089:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            r1 = "wx_code";
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0053 }
            r0.w = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x0097:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x009d:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00a3:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00a9:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00af:
            r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0053 }
            r0.o = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.f.a.b(byte[]):com.tencent.mm.opensdk.diffdev.a.f$a");
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.p = str;
        this.m = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (this.p == null || this.p.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a aVar = new a();
            aVar.o = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.v == 0 ? "" : "&last=" + this.v);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = e.a(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar = a.b(a);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, aVar.o.toString(), Integer.valueOf(aVar.x), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (aVar.o == OAuthErrCode.WechatAuth_Err_OK) {
                this.v = aVar.x;
                if (aVar.x == g.UUID_SCANED.getCode()) {
                    this.m.onQrcodeScanned();
                } else if (aVar.x != g.UUID_KEEP_CONNECT.getCode() && aVar.x == g.UUID_CONFIRM.getCode()) {
                    if (aVar.w != null && aVar.w.length() != 0) {
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    aVar.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{aVar.o.toString(), Integer.valueOf(aVar.x)}));
            return aVar;
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        aVar = new a();
        aVar.o = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.m.onAuthFinish(aVar.o, aVar.w);
    }
}
