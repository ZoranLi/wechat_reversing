package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.wcdb.FileUtils;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private TextPaint gm;
    private int hbc = 0;
    private String jia;
    private TextView kmZ;
    private ImageView lhR;

    public void setAlpha(float f) {
        this.kmZ.setAlpha(f);
        this.lhR.setAlpha(f);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dbN, this, true);
        this.gm = new TextPaint(1);
        this.kmZ = (TextView) inflate.findViewById(R.h.cIU);
        this.lhR = (ImageView) inflate.findViewById(R.h.bqH);
        this.lhR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankChampionInfoView lnb;

            public final void onClick(View view) {
                if (bg.mA(this.lnb.jia)) {
                    w.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", this.lnb.jia);
                context.startActivity(intent);
            }
        });
        this.kmZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankChampionInfoView lnb;

            public final void onClick(View view) {
                if (bg.mA(this.lnb.jia)) {
                    w.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", this.lnb.jia);
                context.startActivity(intent);
            }
        });
        try {
            this.hbc = context.getResources().getDimensionPixelSize(R.f.aXh);
            if (this.hbc <= 0) {
                this.hbc = FileUtils.S_IWUSR;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.hbc <= 0) {
                this.hbc = FileUtils.S_IWUSR;
            }
        } catch (Throwable th) {
            if (this.hbc <= 0) {
                this.hbc = FileUtils.S_IWUSR;
            }
        }
        w.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[]{Integer.valueOf(this.hbc)});
    }

    public final void vt(String str) {
        this.jia = str;
        if (this.kmZ != null) {
            if (bg.mA(str)) {
                this.kmZ.setVisibility(8);
                this.kmZ.setText("");
            } else {
                this.kmZ.setVisibility(0);
                Context context = getContext();
                int i = R.l.efz;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(h.a(getContext(), n.eK(this.jia)), this.gm, (float) this.hbc, TruncateAt.END);
                w.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[]{h.a(getContext(), context.getString(i, objArr))});
                this.kmZ.setText(h.b(getContext(), r0, this.kmZ.getTextSize()));
            }
        }
        if (this.lhR == null) {
            return;
        }
        if (bg.mA(str)) {
            this.lhR.setVisibility(4);
            return;
        }
        b.m(this.lhR, str);
        this.lhR.setVisibility(0);
    }
}
