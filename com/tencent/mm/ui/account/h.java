package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.g.a.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    ae handler;
    private c uXj;
    public a uZt;

    public interface a {
        void m(Bundle bundle);

        void onError(int i, String str);
    }

    public h(c cVar, a aVar) {
        this.uXj = cVar;
        this.uZt = aVar;
    }

    public final void bQS() {
        this.handler = new ae(this) {
            final /* synthetic */ h uZu;

            {
                this.uZu = r1;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (this.uZu.uZt != null) {
                            this.uZu.uZt.onError(message.arg1, (String) message.obj);
                            return;
                        }
                        return;
                    case 2:
                        if (this.uZu.uZt != null) {
                            this.uZu.uZt.m(message.getData());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("client_id", "290293790992170");
        bundle.putString("client_secret", "6667e9307e67283c76028fd37189c096");
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.uXj.vsE);
        e.post(new com.tencent.mm.ui.g.a.a.AnonymousClass1(new com.tencent.mm.ui.g.a.a(this.uXj), "oauth/access_token", bundle, "GET", new com.tencent.mm.ui.g.a.a.a(this) {
            final /* synthetic */ h uZu;

            {
                this.uZu = r1;
            }

            public final void SN(String str) {
                if (str == null || str.length() == 0) {
                    w.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
                    this.uZu.aD(1, "response is null or nil");
                } else if (!str.contains("access_token") || str.length() <= 12) {
                    try {
                        com.tencent.mm.ui.g.a.e.Ub(str);
                    } catch (Throwable e) {
                        w.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                        w.printErrStackTrace("MicroMsg.RefreshTokenRunner", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        String str2 = "errCode = " + e2.jUO + ", errType = " + e2.wgk + ", errMsg = " + e2.getMessage();
                        w.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, " + str2);
                        w.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                        this.uZu.aD(3, str2);
                        return;
                    }
                    this.uZu.aD(2, "parseJson error");
                } else {
                    try {
                        JSONObject Ub = com.tencent.mm.ui.g.a.e.Ub(str);
                        if (Ub.has("access_token")) {
                            Bundle bundle = new Bundle();
                            Iterator keys = Ub.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                JSONArray optJSONArray = Ub.optJSONArray(str3);
                                Double valueOf = Double.valueOf(Ub.optDouble(str3));
                                String optString = Ub.optString(str3);
                                if (optJSONArray == null || optJSONArray.length() > 0) {
                                    int i;
                                    if (optJSONArray != null) {
                                        if (!Double.isNaN(optJSONArray.optDouble(0))) {
                                            double[] dArr = new double[optJSONArray.length()];
                                            for (i = 0; i < optJSONArray.length(); i++) {
                                                dArr[i] = optJSONArray.optDouble(i);
                                            }
                                            bundle.putDoubleArray(str3, dArr);
                                        }
                                    }
                                    if (optJSONArray != null && optJSONArray.optString(0) != null) {
                                        String[] strArr = new String[optJSONArray.length()];
                                        for (i = 0; i < optJSONArray.length(); i++) {
                                            strArr[i] = optJSONArray.optString(i);
                                        }
                                        bundle.putStringArray(str3, strArr);
                                    } else if (!valueOf.isNaN()) {
                                        bundle.putDouble(str3, valueOf.doubleValue());
                                    } else if (optString != null) {
                                        bundle.putString(str3, optString);
                                    } else {
                                        System.err.println("unable to transform json to bundle " + str3);
                                    }
                                } else {
                                    bundle.putStringArray(str3, new String[0]);
                                }
                            }
                            h hVar = this.uZu;
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.setData(bundle);
                            hVar.handler.sendMessage(obtain);
                            return;
                        }
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.RefreshTokenRunner", e22, "", new Object[0]);
                    }
                    this.uZu.aD(2, "decodeUrl fail");
                }
            }

            public final void a(IOException iOException) {
                w.e("MicroMsg.RefreshTokenRunner", "onIOException");
                this.uZu.aD(2, iOException.getMessage());
            }

            public final void a(FileNotFoundException fileNotFoundException) {
                w.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
                this.uZu.aD(2, fileNotFoundException.getMessage());
            }

            public final void a(MalformedURLException malformedURLException) {
                w.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
                this.uZu.aD(2, malformedURLException.getMessage());
            }
        }, null), "AsyncFacebookRunner_request");
    }

    public final void aD(int i, String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        this.handler.sendMessage(obtain);
    }
}
