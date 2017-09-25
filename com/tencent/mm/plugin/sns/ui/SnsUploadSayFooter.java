package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsUploadSayFooter extends BasePanelKeybordLayout {
    private MMActivity fCi;
    ImageButton nuO;
    ChatFooterPanel nuR;
    private boolean nuU = true;
    MMEditText qGv = null;

    static /* synthetic */ void b(SnsUploadSayFooter snsUploadSayFooter) {
        if (snsUploadSayFooter.nuR.getVisibility() == 8) {
            snsUploadSayFooter.fCi.aHf();
            snsUploadSayFooter.nuR.onResume();
            snsUploadSayFooter.nuR.setVisibility(0);
            snsUploadSayFooter.qGv.requestFocus();
            snsUploadSayFooter.nuO.setImageResource(e.pAq);
            snsUploadSayFooter.nuU = false;
            return;
        }
        snsUploadSayFooter.nuU = false;
        snsUploadSayFooter.qGv.requestFocus();
        snsUploadSayFooter.YD();
        snsUploadSayFooter.fCi.aHj();
        snsUploadSayFooter.nuO.setImageResource(e.pAu);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        this.nuO = (ImageButton) ((ViewGroup) r.eC(this.fCi).inflate(g.pIv, this)).findViewById(f.boi);
        this.nuO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsUploadSayFooter qKi;

            {
                this.qKi = r1;
            }

            public final void onClick(View view) {
                SnsUploadSayFooter.b(this.qKi);
            }
        });
        if (com.tencent.mm.pluginsdk.ui.chat.e.sQl == null) {
            this.nuR = new d(this.fCi);
            return;
        }
        this.nuR = com.tencent.mm.pluginsdk.ui.chat.e.sQl.bR(getContext());
        this.nuR.lw(ChatFooterPanel.SCENE_SNS);
        this.nuR.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.czn);
        linearLayout.setOnClickListener(null);
        linearLayout.addView(this.nuR, -1, 0);
        this.nuR.anO();
        this.nuR.dA(false);
        this.nuR.sIy = new a(this) {
            final /* synthetic */ SnsUploadSayFooter qKi;

            {
                this.qKi = r1;
            }

            public final void aIN() {
            }

            public final void fz(boolean z) {
            }

            public final void Zh() {
                this.qKi.qGv.wvn.sendKeyEvent(new KeyEvent(0, 67));
                this.qKi.qGv.wvn.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    this.qKi.qGv.Uz(str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public final boolean bli() {
        return this.nuR.getVisibility() == 0;
    }

    public final void blj() {
        YD();
        setVisibility(8);
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
