package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private int hTj;
    private int hTk;
    private ae hgN = new ae();
    private double pvG = 0.0d;
    private int qjA;
    private VideoSightView qyJ;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar qyK;

    private static class a extends AsyncTask<String, Void, Void> {
        private static Set<String> qku = new HashSet();
        private static byte[] qkv = new byte[0];
        final String filePath;
        final String fyF;
        final ae handler;
        final int qkA;
        final String qkw;
        final String qkx;
        final String qky;
        final a qyP;

        interface a {
            void FY(String str);

            void FZ(String str);

            void bL(String str, int i);
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return x((String[]) objArr);
        }

        public a(String str, String str2, ae aeVar, a aVar) {
            this(str, str2, aeVar, aVar, 0);
        }

        public a(String str, String str2, final ae aeVar, final a aVar, int i) {
            FileOp.kl(str);
            this.qky = str;
            this.fyF = str2;
            this.filePath = str + "/" + str2;
            this.qkx = "temp_" + str2;
            this.qkw = str + "/" + this.qkx;
            this.handler = aeVar;
            this.qkA = i;
            this.qyP = new a(this) {
                final /* synthetic */ a qyR;

                public final void bL(final String str, final int i) {
                    aeVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 qyS;

                        public final void run() {
                            aVar.bL(str, i);
                        }
                    });
                }

                public final void FY(final String str) {
                    aeVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 qyS;

                        public final void run() {
                            aVar.FY(str);
                        }
                    });
                }

                public final void FZ(final String str) {
                    aeVar.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 qyS;

                        public final void run() {
                            aVar.FZ(str);
                        }
                    });
                }
            };
        }

        private Void x(String... strArr) {
            InputStream inputStream;
            OutputStream fileOutputStream;
            Exception exception;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Exception exception2;
            HttpURLConnection httpURLConnection2 = null;
            int i = 0;
            synchronized (qkv) {
                if (qku.contains(strArr[0])) {
                } else {
                    qku.add(strArr[0]);
                    try {
                        if (FileOp.aO(this.filePath)) {
                            this.qyP.FZ(this.filePath);
                            synchronized (qkv) {
                                qku.remove(strArr[0]);
                            }
                        } else {
                            if (FileOp.aO(this.qkw)) {
                                FileOp.deleteFile(this.qkw);
                            }
                            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                            try {
                                httpURLConnection3.connect();
                                if (httpURLConnection3.getResponseCode() != m.CTRL_INDEX) {
                                    this.qyP.FY("Server returned HTTP " + httpURLConnection3.getResponseCode() + " " + httpURLConnection3.getResponseMessage());
                                    if (httpURLConnection3 != null) {
                                        httpURLConnection3.disconnect();
                                    }
                                    synchronized (qkv) {
                                        qku.remove(strArr[0]);
                                    }
                                } else {
                                    httpURLConnection3.getContentLength();
                                    inputStream = httpURLConnection3.getInputStream();
                                    try {
                                        fileOutputStream = new FileOutputStream(this.qkw);
                                    } catch (Exception e) {
                                        fileOutputStream = null;
                                        HttpURLConnection httpURLConnection4 = httpURLConnection3;
                                        exception = e;
                                        httpURLConnection = httpURLConnection4;
                                        try {
                                            this.qyP.FY(exception.getMessage());
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e2) {
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                    synchronized (qkv) {
                                                        qku.remove(strArr[0]);
                                                    }
                                                    return null;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (qkv) {
                                                qku.remove(strArr[0]);
                                            }
                                            return null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection2 = httpURLConnection;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3) {
                                                    if (httpURLConnection2 != null) {
                                                        httpURLConnection2.disconnect();
                                                    }
                                                    synchronized (qkv) {
                                                        qku.remove(strArr[0]);
                                                    }
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                            synchronized (qkv) {
                                                qku.remove(strArr[0]);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        fileOutputStream = null;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th3;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (qkv) {
                                            qku.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                    try {
                                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                        int i2 = 0;
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                            i2 += read;
                                            if (this.qkA != 0 && i2 - r1 >= this.qkA) {
                                                this.qyP.bL(this.qkw, i2);
                                                i = i2;
                                            }
                                        }
                                        FileOp.aj(this.qkw, this.filePath);
                                        this.qyP.FZ(this.filePath);
                                        try {
                                            fileOutputStream.close();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (IOException e4) {
                                        }
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        synchronized (qkv) {
                                            qku.remove(strArr[0]);
                                        }
                                    } catch (Exception e5) {
                                        exception2 = e5;
                                        httpURLConnection = httpURLConnection3;
                                        exception = exception2;
                                        this.qyP.FY(exception.getMessage());
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (qkv) {
                                            qku.remove(strArr[0]);
                                        }
                                        return null;
                                    } catch (Throwable th32) {
                                        httpURLConnection2 = httpURLConnection3;
                                        th = th32;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        synchronized (qkv) {
                                            qku.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e52) {
                                fileOutputStream = null;
                                inputStream = null;
                                exception2 = e52;
                                httpURLConnection = httpURLConnection3;
                                exception = exception2;
                                this.qyP.FY(exception.getMessage());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                synchronized (qkv) {
                                    qku.remove(strArr[0]);
                                }
                                return null;
                            } catch (Throwable th322) {
                                fileOutputStream = null;
                                inputStream = null;
                                httpURLConnection2 = httpURLConnection3;
                                th = th322;
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                synchronized (qkv) {
                                    qku.remove(strArr[0]);
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        exception = e6;
                        httpURLConnection = null;
                        fileOutputStream = null;
                        inputStream = null;
                        this.qyP.FY(exception.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        synchronized (qkv) {
                            qku.remove(strArr[0]);
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        synchronized (qkv) {
                            qku.remove(strArr[0]);
                        }
                        throw th;
                    }
                }
            }
            return null;
        }
    }

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.pvG = snsAdNativeLandingTestUI.qyJ.bcw();
        snsAdNativeLandingTestUI.qyJ.pause();
        snsAdNativeLandingTestUI.hgN.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void run() {
                this.qyL.qyK.bX(false);
            }
        });
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.qyJ.k(snsAdNativeLandingTestUI.pvG);
        snsAdNativeLandingTestUI.qyJ.start();
        snsAdNativeLandingTestUI.hgN.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void run() {
                this.qyL.qyK.bX(true);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ((Button) findViewById(f.pEt)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 259);
                intent.putExtra("select_is_ret", true);
                d.a(this.qyL, ".ui.transmit.SelectConversationUI", intent, 0, new com.tencent.mm.ui.MMActivity.a(this) {
                    final /* synthetic */ AnonymousClass1 qyM;

                    {
                        this.qyM = r1;
                    }

                    public final void a(int i, int i2, Intent intent) {
                        if (i2 == -1) {
                            String str;
                            if (intent == null) {
                                str = null;
                            } else {
                                str = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str == null || str.length() == 0) {
                                w.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                                return;
                            }
                            final Context context = this.qyM.qyL;
                            com.tencent.mm.pluginsdk.ui.applet.n.a.sNx.a(((MMActivity) context).uSU, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", context.getResources().getString(j.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                                final /* synthetic */ AnonymousClass1 qyN;

                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.title = "test title";
                                        wXMediaMessage.description = "test desc";
                                        IMediaObject wXWebpageObject = new WXWebpageObject();
                                        wXWebpageObject.canvasPageXml = "<xml></xml>";
                                        wXWebpageObject.webpageUrl = "http://www.baidu.com/";
                                        wXMediaMessage.mediaObject = wXWebpageObject;
                                        String str2 = (Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages") + "/" + ("adId" + "_image_" + aa.Pq("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"));
                                        Bitmap c = FileOp.aO(str2) ? b.c(str2, 1.0f) : null;
                                        if (!(c == null || c.isRecycled())) {
                                            w.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "thumb image is not null");
                                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            c.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        com.tencent.mm.sdk.b.b ntVar = new nt();
                                        ntVar.fUP.fNK = wXMediaMessage;
                                        ntVar.fUP.toUser = str;
                                        ntVar.fUP.fUQ = 49;
                                        ntVar.fUP.fUR = "";
                                        ntVar.fUP.fUS = "";
                                        com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                        if (!TextUtils.isEmpty(str)) {
                                            ntVar = new nv();
                                            ntVar.fVa.fVb = str;
                                            ntVar.fVa.content = str;
                                            ntVar.fVa.type = o.fG(str);
                                            ntVar.fVa.flags = 0;
                                            com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                        }
                                        g.bl(context, context.getString(j.dIG));
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(f.pEs);
        LayoutInflater layoutInflater = (LayoutInflater) this.uSU.uTo.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.uSU.uTo.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + aa.Pq("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + aa.Pq("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(i.g.pHe, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(f.pEe);
        this.qyJ = new VideoSightView(this.uSU.uTo);
        this.qyJ.bN(false);
        viewGroup2.addView(this.qyJ, 0, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.a(this.uSU.uTo, this.uSU.uTo.getResources().getDimension(i.d.pzk));
        this.qyK = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.uSU.uTo);
        this.qyK.setVisibility(0);
        this.qyJ.he(true);
        ((ViewGroup) inflate).addView(this.qyK, layoutParams);
        this.qyK.puM = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void Uh() {
            }

            public final void hR(int i) {
                w.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time " + i);
                this.qyL.pvG = (double) i;
                this.qyL.qyJ.k((double) i);
            }
        };
        this.qyK.d(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void onClick(View view) {
                if (this.qyL.qyJ.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(this.qyL);
                } else {
                    SnsAdNativeLandingTestUI.c(this.qyL);
                }
            }
        });
        this.qyK.bX(this.qyJ.isPlaying());
        this.qyK.setVisibility(0);
        this.qyK.seek(0);
        this.qyJ.pvi = new com.tencent.mm.pluginsdk.ui.tools.f.a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void Uc() {
                if (this.qyL.qyK.fKD) {
                    SnsAdNativeLandingTestUI.c(this.qyL);
                }
            }

            public final void onError(int i, int i2) {
                this.qyL.qyJ.stop();
            }

            public final void oW() {
            }

            public final int bI(final int i, final int i2) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 qyO;

                    public final void run() {
                        w.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            this.qyO.qyL.duration = i2;
                            this.qyO.qyL.qjA = i2;
                        }
                        if (this.qyO.qyL.qyK.puT != i2) {
                            this.qyO.qyL.qyK.sH(i2);
                        }
                        this.qyO.qyL.qyK.seek(i);
                    }
                });
                return 0;
            }

            public final void bp(int i, int i2) {
                this.qyL.hTk = i;
                this.qyL.hTj = i2;
            }
        };
        this.qyJ.qld = false;
        this.qyJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void onClick(View view) {
                if (!"".equals(this.qyL.qyJ.pvc.ptO) && this.qyL.qyJ.pvc.ptO != null) {
                    if (this.qyL.qyK.getVisibility() == 0) {
                        this.qyL.qyK.setVisibility(4);
                    } else {
                        this.qyL.qyK.setVisibility(0);
                    }
                }
            }
        });
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.qyJ.post(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (this.qyL.uSU.uTo instanceof MMActivity) {
                    ((MMActivity) this.qyL.uSU.uTo).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    this.qyL.qyJ.sF(displayMetrics.widthPixels);
                }
                this.qyL.qyJ.requestLayout();
                this.qyL.qyJ.postInvalidate();
            }
        });
        new a(str2, str3, com.tencent.mm.plugin.sns.model.ae.ayz(), new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void bL(String str, int i) {
            }

            public final void FY(String str) {
            }

            public final void FZ(String str) {
                this.qyL.qyJ.B(BitmapFactory.decodeFile(str));
            }
        }).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, com.tencent.mm.plugin.sns.model.ae.ayz(), new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI qyL;

            {
                this.qyL = r1;
            }

            public final void bL(String str, int i) {
                if (!this.qyL.qyJ.isPlaying()) {
                    this.qyL.qyJ.bN(false);
                    if (!str.equals(this.qyL.qyJ.pvc.ptO)) {
                        this.qyL.qyJ.setVideoPath(str);
                    }
                    if (this.qyL.qyK.fKD) {
                        this.qyL.qyJ.k(this.qyL.pvG);
                        this.qyL.qyJ.start();
                    }
                }
            }

            public final void FY(String str) {
                w.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
            }

            public final void FZ(String str) {
                this.qyL.qyJ.setVideoPath(str);
                this.qyL.qyJ.bN(true);
                if (this.qyL.qyK.fKD) {
                    this.qyL.qyJ.k(this.qyL.pvG);
                    this.qyL.qyJ.start();
                }
            }
        }, Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
    }

    protected final int getLayoutId() {
        return i.g.pHj;
    }
}
