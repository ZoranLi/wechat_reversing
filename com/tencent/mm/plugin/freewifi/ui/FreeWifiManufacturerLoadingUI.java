package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private String bssid;
    private aj fyI;
    private ImageView lWT;
    private TextView lWU;
    private Button lWV;
    private final int lWW = 1;
    private final int lWX = 2;
    private final int lWY = 3;
    private int[] lWZ = new int[]{R.g.bfi, R.g.bfj, R.g.bfk, R.g.bfl, R.g.bfm};
    ae lXa = new ae(this) {
        int i = 0;
        final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

        {
            this.lXc = r2;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.i >= this.lXc.lWZ.length) {
                    this.i = 0;
                }
                this.lXc.lWT.setImageResource(this.lXc.lWZ[this.i]);
                this.i++;
            } else if (message.what == 2) {
                this.lXc.lWT.setImageResource(this.lXc.lWZ[this.lXc.lWZ.length - 1]);
            } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
                this.lXc.lWU.setText(message.obj.toString());
            }
            super.handleMessage(message);
        }
    };
    ae lXb = new ae();
    private String ssid;

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, final String str) {
        freeWifiManufacturerLoadingUI.Z(0, "");
        freeWifiManufacturerLoadingUI.wS(freeWifiManufacturerLoadingUI.getString(R.l.emI));
        freeWifiManufacturerLoadingUI.axt();
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : " + str);
        af.v(new Runnable(freeWifiManufacturerLoadingUI) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

            public final void run() {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_bottom", false);
                intent.putExtra("allow_wx_schema_url", true);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("stastic_scene", 7);
                intent.putExtra("neverBlockLocalRequest", true);
                if (FreeWifiManufacturerLoadingUI.g(this.lXc)) {
                    d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(R.a.aRN, R.a.aRM);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        String bk = bk(ab.getContext());
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : " + bk);
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = bk != null && bk.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = " + z);
        return z;
    }

    static /* synthetic */ String j(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                return m.wz(readLine);
            }
        }
    }

    private void axt() {
        if (this.fyI != null) {
            this.fyI.KH();
        }
        this.lXa.sendEmptyMessage(2);
    }

    protected final int getLayoutId() {
        return R.i.ddt;
    }

    public void finish() {
        axt();
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.emO);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.lWT = (ImageView) findViewById(R.h.bRz);
        this.lWU = (TextView) findViewById(R.h.bRA);
        this.lWV = (Button) findViewById(R.h.bRB);
        this.lWV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

            {
                this.lXc = r1;
            }

            public final void onClick(View view) {
                this.lXc.lXb.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 lXd;

                    {
                        this.lXd = r1;
                    }

                    public final void run() {
                        this.lXd.lXc.lWV.setVisibility(4);
                    }
                }, 0);
                this.lXc.axu();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

            {
                this.lXc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXc.finish();
                return true;
            }
        });
        axu();
    }

    public final void axu() {
        this.lXa.sendEmptyMessage(1);
        if (this.fyI != null) {
            this.fyI.KH();
        }
        this.fyI = new aj(new a(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

            {
                this.lXc = r1;
            }

            public final boolean oQ() {
                this.lXc.lXa.sendEmptyMessage(1);
                return true;
            }
        }, true);
        this.fyI.v(200, 200);
        final String str = this.ssid;
        j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;
            private int lXe = 0;
            private final int lXf = 5;

            public final void run() {
                Context context = ab.getContext();
                if (context == null) {
                    this.lXc.Z(1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
                    return;
                }
                if (!(m.awg() && m.wA("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str))) {
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + str);
                    this.lXc.wS(this.lXc.getString(R.l.emJ));
                    int avQ = new b(str, context).avQ();
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=" + avQ);
                    if (avQ != 0) {
                        this.lXc.Z(avQ, "An attempt to switch to special portal ap failed. connectRet=" + avQ);
                        return;
                    }
                }
                axw();
            }

            private void axv() {
                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
                this.lXe++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    w.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
                }
                axw();
            }

            private void axw() {
                Exception exception;
                Writer stringWriter;
                Throwable th;
                String avY = b.lRu.avY();
                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : " + avY);
                this.lXc.wS(this.lXc.getString(R.l.emF));
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(avY).openConnection();
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                            httpURLConnection2.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2.setUseCaches(false);
                            httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                            httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                            int responseCode = httpURLConnection2.getResponseCode();
                            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = " + responseCode);
                            String j;
                            if (com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX == responseCode) {
                                if (m.wA("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str)) {
                                    j = FreeWifiManufacturerLoadingUI.j(httpURLConnection2.getInputStream());
                                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=" + j);
                                    if (j.indexOf("wxwifiecho") == -1) {
                                        FreeWifiManufacturerLoadingUI.b(this.lXc, avY);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    this.lXc.Z(0, "");
                                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                                    this.lXc.Z(0, "");
                                    this.lXc.wS(this.lXc.getString(R.l.emE));
                                    this.lXc.axt();
                                    FreeWifiManufacturerLoadingUI.f(this.lXc);
                                } else {
                                    this.lXc.Z(1150, "Target ssid is not connected.");
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            } else if (302 == responseCode) {
                                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                                j = httpURLConnection2.getHeaderField("Location");
                                if (m.wx(j)) {
                                    this.lXc.Z(1146, "AP cannot response portal url properly.");
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                FreeWifiManufacturerLoadingUI.b(this.lXc, j);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            } else {
                                this.lXc.Z(1149, "Ap response code is neither 200 nor 302.");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e) {
                            Exception exception2 = e;
                            httpURLConnection = httpURLConnection2;
                            exception = exception2;
                            try {
                                stringWriter = new StringWriter();
                                exception.printStackTrace(new PrintWriter(stringWriter));
                                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                                if (exception instanceof UnknownHostException) {
                                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.lXe), Integer.valueOf(5)});
                                    if (this.lXe < 5) {
                                        axv();
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                this.lXc.Z(1153, "An attempt to connect to ap failed.");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            httpURLConnection = httpURLConnection2;
                            th = th4;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.lXe), Integer.valueOf(5)});
                    if (this.lXe < 5) {
                        axv();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                    this.lXc.Z(1148, "An attempt to connect to ap failed.");
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Exception e2) {
                    exception = e2;
                    stringWriter = new StringWriter();
                    exception.printStackTrace(new PrintWriter(stringWriter));
                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                    if (exception instanceof UnknownHostException) {
                        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.lXe), Integer.valueOf(5)});
                        if (this.lXe < 5) {
                            axv();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                    }
                    this.lXc.Z(1153, "An attempt to connect to ap failed.");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        });
    }

    private void Z(int i, String str) {
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (i != 0) {
            axt();
            if (i == 1154) {
                wS(getString(R.l.emH) + "(031" + k.b.ManufacturerConnectLoading.lSn + "-" + Math.abs(i) + ")");
                return;
            }
            wS(getString(R.l.emG) + "(031" + k.b.ManufacturerConnectLoading.lSn + "-" + Math.abs(i) + ")");
            this.lXb.postDelayed(new Runnable(this) {
                final /* synthetic */ FreeWifiManufacturerLoadingUI lXc;

                {
                    this.lXc = r1;
                }

                public final void run() {
                    this.lXc.lWV.setVisibility(0);
                }
            }, 0);
        }
    }

    private void wS(String str) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.lXa.sendMessage(obtain);
    }

    private static String bk(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            return "(null)";
        }
    }
}
