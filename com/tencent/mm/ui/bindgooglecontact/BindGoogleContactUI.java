package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements e {
    private boolean htv = false;
    private boolean jFm = false;
    private int jis;
    private ProgressDialog kIa;
    private TextView mDo;
    String vsA;
    private com.tencent.mm.ag.a vsB;
    private boolean vso = false;
    String vsq;
    private WebView vsw;
    private boolean vsx = false;
    private String vsy;
    String vsz;

    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ BindGoogleContactUI vsC;
        final /* synthetic */ String vsD;

        AnonymousClass4(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.vsC = bindGoogleContactUI;
            this.vsD = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.vsC.cO(this.vsD, com.tencent.mm.ag.a.hDZ);
        }
    }

    class a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ BindGoogleContactUI vsC;
        private String vsE;
        private String vsF;
        private boolean vsG;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCW();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            Context context = this.vsC;
            boolean z = this.vsG;
            String str = this.vsF;
            if (!z || TextUtils.isEmpty(str)) {
                context.Xs();
                context.bTc();
            } else if (TextUtils.isEmpty(context.vsq) || TextUtils.isEmpty(str) || context.vsq.equalsIgnoreCase(str)) {
                context.vsq = str;
                context.cO(context.vsq, com.tencent.mm.ag.a.hDZ);
            } else {
                context.Xs();
                g.a(context, context.getString(R.l.epS), "", new AnonymousClass4(context, str), new OnClickListener(context) {
                    final /* synthetic */ BindGoogleContactUI vsC;

                    {
                        this.vsC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ap.yY();
                        c.vr().set(208905, Boolean.valueOf(true));
                        this.vsC.finish();
                    }
                });
            }
        }

        public a(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.vsC = bindGoogleContactUI;
            this.vsE = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.vsG = false;
        }

        private Void aCW() {
            w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + this.vsE).openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                int responseCode = httpURLConnection.getResponseCode();
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
                if (m.CTRL_INDEX == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str = stringBuffer.toString();
                    w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[]{str});
                }
                httpURLConnection.disconnect();
                this.vsF = new JSONObject(str).optString("email");
                if (!TextUtils.isEmpty(this.vsF)) {
                    this.vsG = true;
                }
            } catch (MalformedURLException e) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[]{e.getMessage()});
            } catch (ProtocolException e2) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[]{e2.getMessage()});
            } catch (UnsupportedEncodingException e3) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[]{e3.getMessage()});
            } catch (IOException e4) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[]{e4.getMessage()});
            } catch (Throwable e5) {
                w.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e5, "", new Object[0]);
            }
            return null;
        }
    }

    class b extends AsyncTask<Void, Void, Void> {
        private boolean fHO;
        final /* synthetic */ BindGoogleContactUI vsC;
        private String vsE;
        private String vsH;
        private String vsI;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCW();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = this.vsC;
            boolean z = this.fHO;
            Object obj2 = this.vsE;
            String str = this.vsI;
            if (!z || TextUtils.isEmpty(obj2)) {
                bindGoogleContactUI.Xs();
                bindGoogleContactUI.bTc();
                return;
            }
            bindGoogleContactUI.vsz = obj2;
            bindGoogleContactUI.vsA = str;
            new a(bindGoogleContactUI, bindGoogleContactUI.vsz).execute(new Void[0]);
        }

        public b(BindGoogleContactUI bindGoogleContactUI, String str) {
            this.vsC = bindGoogleContactUI;
            this.vsH = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.vsE = "";
            this.vsI = "";
            this.fHO = false;
        }

        private Void aCW() {
            try {
                String str = this.vsH;
                String str2 = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
                arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
                str = n.F(arrayList);
                w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[]{str});
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.getBytes().length));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
                if (m.CTRL_INDEX == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str2 = stringBuffer.toString();
                    w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[]{str2});
                }
                httpURLConnection.disconnect();
                this.vsE = new JSONObject(str2).optString("access_token");
                this.vsI = new JSONObject(str2).optString("refresh_token");
                w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[]{str2});
                w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[]{this.vsE});
                w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[]{this.vsI});
                this.fHO = true;
            } catch (MalformedURLException e) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e.getMessage());
            } catch (ProtocolException e2) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e2.getMessage());
            } catch (IOException e3) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e3.getMessage());
            } catch (JSONException e4) {
                w.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e4.getMessage());
            }
            return null;
        }
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str) {
        String substring = str.substring(30);
        w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE value:" + substring);
        bindGoogleContactUI.amU();
        new b(bindGoogleContactUI, substring).execute(new Void[0]);
        w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE End.");
    }

    protected final int getLayoutId() {
        return R.i.cVy;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jis = getIntent().getIntExtra("enter_scene", 0);
        this.jFm = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.vso = n.aV(this);
        ap.yY();
        this.vsq = (String) c.vr().get(208903, null);
        KC();
        if (this.vso) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), MMBitmapFactory.ERROR_IO_FAILED);
        } else {
            ar();
        }
    }

    private void ar() {
        if (this.vso) {
            this.vsw.setVisibility(8);
            amU();
            startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
            return;
        }
        this.mDo.setVisibility(4);
        this.vsw.setVisibility(0);
        bTb();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(487, this);
        ap.yY();
        this.vsx = ((Boolean) c.vr().get(208905, Boolean.valueOf(false))).booleanValue();
        if (this.vsx) {
            bTd();
            this.vsx = false;
            ap.yY();
            c.vr().set(208905, Boolean.valueOf(false));
        }
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(487, this);
    }

    protected final void KC() {
        zi(R.l.epK);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindGoogleContactUI vsC;

            {
                this.vsC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vsC.finish();
                return true;
            }
        });
        this.vsw = com.tencent.mm.ui.widget.MMWebView.a.i(this, R.h.bVl);
        this.mDo = (TextView) findViewById(R.h.empty);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[]{Integer.valueOf(intent.getIntExtra("error_code", -1))});
                    if (intent.getIntExtra("error_code", -1) == 0) {
                        this.vsq = intent.getStringExtra("account");
                        if (this.htv) {
                            Xs();
                            return;
                        }
                        w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.vsq);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                        return;
                    }
                    Xs();
                    bTc();
                    return;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    int intExtra = intent.getIntExtra("error_code", -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[]{Integer.valueOf(intExtra), stringExtra});
                    if (intExtra == 0) {
                        this.vsy = intent.getStringExtra("token");
                        AD(com.tencent.mm.ag.a.hDZ);
                        return;
                    }
                    Xs();
                    bTc();
                    return;
                case MMBitmapFactory.ERROR_IO_FAILED /*1005*/:
                    this.vso = intent.getBooleanExtra("gpservices", false);
                    ar();
                    return;
                default:
                    return;
            }
        } else if (i == MMBitmapFactory.ERROR_IO_FAILED) {
            this.vso = intent.getBooleanExtra("gpservices", false);
            ar();
        } else {
            Xs();
            bTc();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        w.i(str2, str3, objArr);
        Xs();
        if (i == 0 && i2 == 0) {
            if (this.vso) {
                ap.yY();
                c.vr().set(208903, this.vsq);
                ap.yY();
                c.vr().set(208901, this.vsy);
            } else {
                ap.yY();
                c.vr().set(208903, this.vsq);
                ap.yY();
                c.vr().set(208902, this.vsz);
                ap.yY();
                c.vr().set(208904, this.vsA);
            }
            ap.yY();
            c.vr().jY(true);
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.jis);
            startActivity(intent);
            finish();
            if (this.jFm) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11002, new Object[]{Integer.valueOf(6), Integer.valueOf(5)});
            }
        } else if (i2 == com.tencent.mm.ag.a.hEb) {
            g.a(this, getString(R.l.epR), "", new OnClickListener(this) {
                final /* synthetic */ BindGoogleContactUI vsC;

                {
                    this.vsC = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vsC.AD(com.tencent.mm.ag.a.hEa);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ BindGoogleContactUI vsC;

                {
                    this.vsC = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.vsC.bTd();
                    this.vsC.bTb();
                }
            });
        } else {
            bTc();
        }
    }

    private void bTb() {
        amU();
        this.vsw.getSettings().setJavaScriptEnabled(true);
        this.vsw.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ BindGoogleContactUI vsC;

            {
                this.vsC = r1;
            }

            public final void onPageFinished(WebView webView, String str) {
                w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:" + str);
                if (!(this.vsC.vsw == null || this.vsC.vsw.getVisibility() == 0)) {
                    this.vsC.vsw.setVisibility(0);
                    if (this.vsC.mDo != null) {
                        this.vsC.mDo.setVisibility(4);
                    }
                }
                this.vsC.Xs();
                if (webView != null) {
                    String title = webView.getTitle();
                    w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", new Object[]{title});
                    if (!TextUtils.isEmpty(title)) {
                        if (title.toLowerCase().contains("success")) {
                            if (this.vsC.vsw != null) {
                                this.vsC.vsw.setVisibility(4);
                            }
                            s.a(this.vsC.vsw, "weixin://private/googlegetcode", "document.getElementById('code').value");
                        } else if (title.toLowerCase().contains("error")) {
                            w.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                        }
                    }
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                w.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
                if (!str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                BindGoogleContactUI.a(this.vsC, str);
                return true;
            }
        });
        this.vsw.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ BindGoogleContactUI vsC;

            {
                this.vsC = r1;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String Nv = s.Nv(consoleMessage != null ? consoleMessage.message() : null);
                if (!Nv.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    return super.onConsoleMessage(consoleMessage);
                }
                BindGoogleContactUI.a(this.vsC, Nv);
                return true;
            }
        });
        w.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", new Object[]{"https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com"});
        this.vsw.loadUrl("https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
    }

    private void AD(int i) {
        this.vsB = new com.tencent.mm.ag.a(com.tencent.mm.ag.a.a.hEg, this.vsq, i);
        ap.vd().a(this.vsB, 0);
        w.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[]{this.vsy, this.vsz});
    }

    final void cO(String str, int i) {
        this.vsq = str;
        AD(i);
    }

    final void bTc() {
        CharSequence string;
        if (this.vsw != null) {
            this.vsw.setVisibility(4);
        }
        if (this.mDo != null) {
            this.mDo.setVisibility(0);
        }
        if (am.isConnected(this)) {
            string = getString(R.l.epL);
        } else {
            string = getString(R.l.epT);
        }
        this.mDo.setText(string);
    }

    private void bTd() {
        try {
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        } catch (Exception e) {
            w.d("Google Login", "Clear cookie failed");
        }
    }

    private void amU() {
        if (this.kIa == null || !this.kIa.isShowing()) {
            getString(R.l.dIO);
            this.kIa = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ BindGoogleContactUI vsC;

                {
                    this.vsC = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.vsC.htv = true;
                    if (this.vsC.vsB != null) {
                        ap.vd().c(this.vsC.vsB);
                    }
                }
            });
        }
    }

    final void Xs() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }
}
