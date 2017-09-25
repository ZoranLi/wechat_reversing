package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMImageView;

public class CdnImageView extends MMImageView implements com.tencent.mm.ui.f.a {
    private ae handler;
    private int lKi;
    private int neJ;
    private String sMe;
    public boolean sMf;
    private String url;

    static class a implements Runnable {
        private ae handler;
        private String url;

        a(String str, ae aeVar) {
            this.url = str;
            this.handler = aeVar;
        }

        public final void run() {
            byte[] Qc = bg.Qc(this.url);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putByteArray("k_data", Qc);
            bundle.putString("k_url", this.url);
            obtain.setData(bundle);
            this.handler.sendMessage(obtain);
        }
    }

    public CdnImageView(Context context) {
        this(context, null);
    }

    public CdnImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CdnImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.url = null;
        this.handler = new ae(this) {
            final /* synthetic */ CdnImageView sMg;

            {
                this.sMg = r1;
            }

            public final void handleMessage(Message message) {
                String ap = bg.ap(message.getData().getString("k_url"), "");
                this.sMg.url = bg.ap(this.sMg.url, "");
                if (bg.mA(this.sMg.url) && bg.mA(ap)) {
                    this.sMg.setImageBitmap(null);
                    this.sMg.u(null);
                } else if (this.sMg.url.equals(ap)) {
                    byte[] byteArray = message.getData().getByteArray("k_data");
                    if (byteArray == null || byteArray.length == 0) {
                        w.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
                        return;
                    }
                    Bitmap bd = d.bd(byteArray);
                    n.GR();
                    b.f(this.sMg.url, bd);
                    if (bd != null && this.sMg.neJ > 0 && this.sMg.lKi > 0) {
                        bd = d.a(bd, this.sMg.lKi, this.sMg.neJ, true, false);
                    }
                    if (!(bd == null || bg.mA(this.sMg.sMe))) {
                        try {
                            d.a(bd, 100, CompressFormat.JPEG, this.sMg.sMe, false);
                        } catch (Exception e) {
                            w.e("MicroMsg.CdnImageView", "save image failed, %s", e.getMessage());
                        }
                    }
                    if (this.sMg.sMf && bd != null) {
                        bd = d.a(bd, false, ((float) bd.getWidth()) * 0.5f);
                    }
                    this.sMg.setImageBitmap(bd);
                    this.sMg.u(bd);
                } else {
                    w.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
                }
            }
        };
    }

    public void u(Bitmap bitmap) {
    }

    public final void K(String str, int i, int i2) {
        L(str, i, i2);
    }

    public void L(String str, int i, int i2) {
        Bitmap Pg;
        this.url = str;
        this.neJ = i;
        this.lKi = i2;
        this.sMe = null;
        if (!bg.mA(this.sMe)) {
            Pg = d.Pg(this.sMe);
            if (Pg != null && Pg.getWidth() > 0 && Pg.getHeight() > 0) {
                setImageBitmap(Pg);
                u(Pg);
                return;
            }
        }
        if (str == null || str.length() == 0) {
            setVisibility(8);
        } else if (str.startsWith("http")) {
            n.GR();
            Pg = b.gS(str);
            if (Pg != null) {
                if (this.neJ > 0 && this.lKi > 0) {
                    Pg = d.a(Pg, this.neJ, this.lKi, true, false);
                }
                setImageBitmap(Pg);
                u(Pg);
                return;
            }
            e.post(new a(str, this.handler), "CdnImageView_download");
        } else if (com.tencent.mm.a.e.aO(str)) {
            Pg = (this.neJ <= 0 || this.lKi <= 0) ? d.Pg(str) : d.d(str, this.neJ, this.lKi, true);
            if (Pg == null) {
                setVisibility(8);
                return;
            }
            setImageBitmap(Pg);
            u(Pg);
        } else {
            setVisibility(8);
        }
    }
}
