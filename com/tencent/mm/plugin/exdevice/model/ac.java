package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.am.c;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    public boolean htv;
    private View ldU;
    private TextView ldV;
    private TextView ldW;
    private TextView ldX;
    private TextView ldY;
    private View ldZ;
    public boolean lea;
    public Dialog leb;
    private int width;

    public interface a {
        void uX(String str);
    }

    public static final String bS(Context context) {
        return new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
    }

    public final void a(Context context, String str, String str2, String str3, final a aVar) {
        if (!this.lea) {
            this.lea = true;
            this.htv = false;
            if (this.leb == null && !bg.mA(str3)) {
                context.getString(R.l.dIO);
                this.leb = g.a(context, context.getString(R.l.egF), true, new OnCancelListener(this) {
                    final /* synthetic */ ac lec;

                    {
                        this.lec = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.lec.htv = true;
                    }
                });
                this.leb.show();
            }
            this.context = context;
            this.width = 1280;
            if (this.width > com.tencent.mm.bg.a.dO(context)) {
                this.width = com.tencent.mm.bg.a.dO(context);
            }
            this.ldU = LayoutInflater.from(context).inflate(R.i.dbZ, null);
            this.ldV = (TextView) this.ldU.findViewById(R.h.bNe);
            this.ldW = (TextView) this.ldU.findViewById(R.h.bNc);
            this.ldX = (TextView) this.ldU.findViewById(R.h.bNm);
            this.ldY = (TextView) this.ldU.findViewById(R.h.bNl);
            this.ldZ = this.ldU.findViewById(R.h.bsC);
            this.ldV.setText(str);
            this.ldX.setText(str2);
            b.a((ImageView) this.ldU.findViewById(R.h.bqH), m.xL(), 0.5f, false);
            ImageView imageView = (ImageView) this.ldU.findViewById(R.h.bsA);
            this.ldU.setLayoutParams(new LayoutParams(-1, -1));
            this.ldU.measure(MeasureSpec.makeMeasureSpec(this.width, 1073741824), MeasureSpec.makeMeasureSpec(this.width, 1073741824));
            this.ldU.layout(0, 0, this.width, this.width);
            if (bg.mA(str3)) {
                imageView.setImageResource(R.e.aTt);
                aVar.uX(q(null));
                this.lea = false;
                return;
            }
            ad.apw().a(str3, imageView, new com.tencent.mm.ah.a.c.g(this) {
                final /* synthetic */ ac lec;

                public final void jK(String str) {
                }

                public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                    if (this.lec.htv) {
                        this.lec.lea = false;
                        return;
                    }
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 lee;

                        {
                            this.lee = r1;
                        }

                        public final void run() {
                            if (this.lee.lec.leb.isShowing()) {
                                this.lee.lec.leb.dismiss();
                            }
                        }
                    });
                    aVar.uX(this.lec.q(bVar.bitmap));
                    this.lec.lea = false;
                }
            });
        }
    }

    public final String q(Bitmap bitmap) {
        int[] m;
        if (bitmap != null) {
            m = c.m(bitmap);
        } else {
            m = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        ShaderFactory anonymousClass3 = new ShaderFactory(this) {
            final /* synthetic */ ac lec;

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, m[0]}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        };
        Drawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(anonymousClass3);
        this.ldZ.setBackgroundDrawable(paintDrawable);
        this.ldV.setTextColor(m[1]);
        this.ldW.setTextColor(m[1]);
        this.ldX.setTextColor(m[1]);
        this.ldY.setTextColor(m[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.ldU.draw(new Canvas(createBitmap));
        File file = new File(bS(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            d.a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        return file.getAbsolutePath();
    }

    public static boolean b(Context context, String str, String str2, String str3, String str4) {
        w.DH();
        List fy = com.tencent.mm.modelbiz.d.fy(1);
        String str5 = fy.size() > 0 ? (String) fy.get(0) : null;
        IMediaObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String eK = n.eK(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = eK;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(d.decodeFile(str2, null));
        com.tencent.mm.sdk.b.b ntVar = new nt();
        ntVar.fUP.fNK = wXMediaMessage;
        ntVar.fUP.appId = "wx7fa037cc7dfabad5";
        ntVar.fUP.appName = context.getString(R.l.egL);
        ntVar.fUP.toUser = str;
        ntVar.fUP.fUQ = 2;
        if (bg.mA(str5)) {
            ntVar.fUP.fUT = null;
        } else {
            ntVar.fUP.fUR = str5;
            ntVar.fUP.fUS = eK;
        }
        boolean m = com.tencent.mm.sdk.b.a.urY.m(ntVar);
        if (!bg.mA(str3)) {
            com.tencent.mm.sdk.b.b nvVar = new nv();
            nvVar.fVa.fVb = str;
            nvVar.fVa.content = str3;
            nvVar.fVa.type = o.fG(str);
            nvVar.fVa.flags = 0;
            com.tencent.mm.sdk.b.a.urY.m(nvVar);
        }
        return m;
    }
}
