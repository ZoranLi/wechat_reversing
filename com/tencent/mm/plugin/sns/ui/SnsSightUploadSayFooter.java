package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity fCi;
    private ImageButton nuO;
    ChatFooterPanel nuR;
    private boolean nuU = true;
    MMEditText qGv = null;
    SightRangeWidget qGw;
    SightLocationWidget qGx;

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        if (snsSightUploadSayFooter.nuR.getVisibility() == 8) {
            snsSightUploadSayFooter.fCi.aHf();
            snsSightUploadSayFooter.nuR.onResume();
            snsSightUploadSayFooter.nuR.setVisibility(0);
            snsSightUploadSayFooter.qGv.requestFocus();
            snsSightUploadSayFooter.nuO.setImageResource(i.pJf);
            snsSightUploadSayFooter.nuU = false;
            return;
        }
        snsSightUploadSayFooter.nuU = false;
        snsSightUploadSayFooter.qGv.requestFocus();
        snsSightUploadSayFooter.YD();
        snsSightUploadSayFooter.fCi.aHj();
        snsSightUploadSayFooter.nuO.setImageResource(i.pJe);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fCi, g.pIa, this);
        this.nuO = (ImageButton) viewGroup.findViewById(f.boi);
        this.nuO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightUploadSayFooter qGy;

            {
                this.qGy = r1;
            }

            public final void onClick(View view) {
                SnsSightUploadSayFooter.d(this.qGy);
            }
        });
        if (e.sQl == null) {
            this.nuR = new d(this.fCi);
        } else {
            this.nuR = e.sQl.bR(getContext());
            this.nuR.lw(ChatFooterPanel.SCENE_SNS);
            this.nuR.setVisibility(8);
            ((LinearLayout) findViewById(f.czn)).addView(this.nuR, -1, 0);
            this.nuR.anO();
            this.nuR.dA(false);
            this.nuR.sIy = new a(this) {
                final /* synthetic */ SnsSightUploadSayFooter qGy;

                {
                    this.qGy = r1;
                }

                public final void aIN() {
                }

                public final void fz(boolean z) {
                }

                public final void Zh() {
                    this.qGy.qGv.wvn.sendKeyEvent(new KeyEvent(0, 67));
                    this.qGy.qGv.wvn.sendKeyEvent(new KeyEvent(1, 67));
                }

                public final void append(String str) {
                    try {
                        this.qGy.qGv.Uz(str);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                    }
                }
            };
        }
        this.qGw = (SightRangeWidget) viewGroup.findViewById(f.pDy);
        this.qGw.qpS = null;
        this.qGw.style = 1;
        this.qGx = (SightLocationWidget) viewGroup.findViewById(f.pDi);
    }

    private void YD() {
        this.nuR.onPause();
        this.nuR.setVisibility(8);
    }

    protected final List<View> aIM() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.nuR);
        return arrayList;
    }
}
