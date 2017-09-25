package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.k.b;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.io.IOException;

public class AppMsgEmojiDownloadUI extends MMActivity implements a, e {
    private String appName;
    private String fCW;
    private long fGM;
    private String fKz;
    private String fSs;
    private String fTO;
    private au fTk;
    private String hhs;
    private ProgressBar jKM;
    private ab kOu;
    private f kOv;
    private TextView kOw;
    private String kOx;
    private PreViewEmojiView kOy;

    protected final int getLayoutId() {
        return R.i.cUH;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.kOx = "da_" + bg.Nz();
        this.fGM = getIntent().getLongExtra("msgid", -1);
        if (this.fGM == -1) {
            z = false;
        } else {
            ap.yY();
            this.fTk = c.wT().cA(this.fGM);
            if (this.fTk == null || this.fTk.field_msgId == 0 || this.fTk.field_content == null) {
                z = false;
            } else {
                this.fSs = this.fTk.field_content;
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.fSs);
                if (ek == null) {
                    z = false;
                } else {
                    this.hhs = ek.hhs;
                    this.fCW = ek.fCW;
                    this.fTO = ek.appId;
                    this.appName = g.a(this.uSU.uTo, g.aJ(this.fTO, true), null);
                    this.fKz = this.fTk.field_imgPath;
                }
            }
        }
        if (z) {
            an.abL().c(this);
            KC();
            this.kOv = new f(this) {
                final /* synthetic */ AppMsgEmojiDownloadUI kOz;

                {
                    this.kOz = r1;
                }

                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    this.kOz.lq((int) f);
                }
            };
            if (an.abL().LW(this.fCW) == null) {
                long j = this.fGM;
                String str = this.fSs;
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                l.b(j, str, stringBuilder.append(c.xi()).append(this.kOx).toString());
            }
            this.kOu = new ab(this.fCW, this.kOv, 8);
            ap.vd().a(this.kOu, 0);
            return;
        }
        finish();
    }

    protected final void KC() {
        this.kOy = (PreViewEmojiView) findViewById(R.h.bHz);
        this.kOy.setImageBitmap(n.GS().a(this.fKz, 1.0f, true));
        qP("");
        this.kOw = (TextView) findViewById(R.h.bKr);
        TextView textView = (TextView) findViewById(R.h.bqk);
        this.appName = g.a(this.uSU.uTo, g.aJ(this.fTO, true), null);
        if (this.fTO != null && this.fTO.length() > 0) {
            String str = this.appName;
            boolean z = (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) ? false : true;
            if (z) {
                textView.setText(getString(R.l.dVF, new Object[]{this.appName}));
                textView.setVisibility(0);
                str = this.fTO;
                b bVar = new b();
                bVar.appId = str;
                bVar.fTm = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.k(this));
                Bitmap b = g.b(this.fTO, 2, com.tencent.mm.bg.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bhT));
                } else {
                    a(this, textView, b);
                }
                this.jKM = (ProgressBar) findViewById(R.h.bLc);
                this.jKM.setMax(100);
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ AppMsgEmojiDownloadUI kOz;

                    {
                        this.kOz = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kOz.finish();
                        return true;
                    }
                });
            }
        }
        textView.setVisibility(8);
        this.jKM = (ProgressBar) findViewById(R.h.bLc);
        this.jKM.setMax(100);
        b(/* anonymous class already generated */);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 221) {
            if (i == 0 && i2 == 0) {
                lq(this.jKM.getMax());
                return;
            }
            Toast.makeText(this, R.l.ebM, 0).show();
            this.jKM.setVisibility(8);
            this.kOw.setVisibility(8);
            w.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "onSceneEnd, download fail, errType = " + i + ", errCode = " + i2);
        }
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(221, this);
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(221, this);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(this.fCW);
        if (LW == null) {
            w.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "updateProgress fail");
            return;
        }
        long j = LW.field_totalLen;
        long j2 = LW.field_offset;
        this.kOw.setText(getString(R.l.ebO) + " " + getString(R.l.ebL, new Object[]{bg.ay(j2), bg.ay(j)}));
        int i = (int) ((LW.field_offset * 100) / LW.field_totalLen);
        w.v("MicroMsg.emoji.AppMsgEmojiDownloadUI", "attach progress:" + i + " offset:" + j2 + " totallen:" + j);
        lq(i);
    }

    private void lq(int i) {
        this.jKM.setProgress(i);
        if (i >= 100) {
            ap.yY();
            String xi = c.xi();
            com.tencent.mm.sdk.e.c LW = an.abL().LW(this.fCW);
            if (LW == null) {
                w.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "saveImageAndPreview fail, info is null, attachid = " + this.fCW + ", msgContent = " + this.fSs);
            } else {
                int aN = com.tencent.mm.a.e.aN(LW.field_fileFullPath);
                Object c = com.tencent.mm.a.e.c(LW.field_fileFullPath, 0, aN);
                String n = com.tencent.mm.a.g.n(c);
                if (!bg.mA(n)) {
                    if (n == null || this.hhs == null || n.equalsIgnoreCase(this.hhs)) {
                        com.tencent.mm.a.e.h(xi, this.kOx, n);
                        LW.field_fileFullPath = xi + n;
                        an.abL().a(LW.field_msgInfoId, LW);
                        Bitmap a = n.GS().a(this.fKz, 1.0f, true);
                        if (a != null) {
                            l(xi + n + "_thumb", a);
                        }
                        com.tencent.mm.storage.a.c a2 = o.bf(c) ? h.amc().kLa.a(n, "", com.tencent.mm.storage.a.c.uKT, com.tencent.mm.storage.a.c.uLc, aN, this.fTO, "") : h.amc().kLa.a(n, "", com.tencent.mm.storage.a.c.uKT, com.tencent.mm.storage.a.c.uLd, aN, this.fTO, "");
                        this.jKM.setVisibility(8);
                        this.kOw.setVisibility(8);
                        if (a2 != null) {
                            this.kOy.ct(a2.eN(a2.field_groupId, a2.EP()), null);
                            this.kOy.resume();
                        }
                    } else {
                        w.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "md5 not match!! emoticonmd5 is=" + this.hhs + ", gen md5 is=" + n);
                        w.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "fileFullPath = " + LW.field_fileFullPath + ", fileLength = " + aN + ", bufLength = " + c.length + ", buf = " + c);
                        Toast.makeText(this, getString(R.l.ebM), 0).show();
                        finish();
                    }
                }
            }
            an.abL().f(this);
            ap.vd().b(221, this);
        }
    }

    private static boolean l(String str, Bitmap bitmap) {
        try {
            d.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void a(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) appMsgEmojiDownloadUI.getResources().getDimension(R.f.aXs);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().c(this.kOu);
        an.abL().f(this);
    }
}
