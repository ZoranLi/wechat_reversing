package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;

public class SecurityImage extends LinearLayout {
    private h oHT = null;
    public String uYU = null;
    public String uYV = null;
    public int uYX = 0;
    ProgressBar vfn = null;
    ImageView vfo = null;
    Button vfp = null;
    EditText vfq = null;
    b vfr;

    public static class a {
        public static SecurityImage a(Context context, int i, int i2, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, com.tencent.mm.s.a.h.heK, null);
            if (securityImage.vfr != null) {
                securityImage.vfr.vfu = null;
            }
            securityImage.vfr = bVar;
            securityImage.vfr.vfu = securityImage;
            securityImage.vfn = (ProgressBar) securityImage.findViewById(g.hcU);
            securityImage.vfo = (ImageView) securityImage.findViewById(g.hcg);
            securityImage.vfp = (Button) securityImage.findViewById(g.hce);
            securityImage.vfq = (EditText) securityImage.findViewById(g.hcf);
            securityImage.vfp.setOnClickListener(new View.OnClickListener(securityImage) {
                final /* synthetic */ SecurityImage vfs;

                {
                    this.vfs = r1;
                }

                public final void onClick(View view) {
                    this.vfs.kF(false);
                    if (this.vfs.vfr != null) {
                        this.vfs.vfr.bQI();
                    }
                }
            });
            securityImage.a(i2, bArr, str, str2);
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
            aVar.zW(i);
            aVar.zZ(k.dGw).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    onClickListener.onClick(dialogInterface, i);
                }
            });
            aVar.d(onCancelListener);
            aVar.dd(securityImage);
            aVar.kK(true);
            securityImage.oHT = aVar.WJ();
            securityImage.oHT.setOnDismissListener(onDismissListener);
            securityImage.oHT.show();
            return securityImage;
        }
    }

    public static abstract class b {
        public SecurityImage vfu;

        public abstract void bQI();
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        kF(true);
        this.uYU = str;
        this.uYV = str2;
        this.uYX = i;
        Bitmap bd = d.bd(bArr);
        if (bd != null) {
            w.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bd.getWidth()), Integer.valueOf(bd.getHeight()));
            this.uYU = str;
            this.uYV = str2;
            this.uYX = i;
            if (bd != null) {
                this.vfo.setImageBitmap(bd);
                return;
            } else {
                w.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
                return;
            }
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        w.e(str3, str4, objArr);
    }

    public final String bRz() {
        return this.vfq == null ? "" : this.vfq.getText().toString().trim();
    }

    public final void dismiss() {
        if (this.oHT != null) {
            this.oHT.dismiss();
            this.oHT = null;
        }
    }

    private void kF(boolean z) {
        int i = 0;
        this.vfo.setAlpha(z ? 255 : 40);
        this.vfo.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.vfn;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }
}
