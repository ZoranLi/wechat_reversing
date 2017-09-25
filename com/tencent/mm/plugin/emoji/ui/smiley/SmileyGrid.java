package com.tencent.mm.plugin.emoji.ui.smiley;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.bi.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;

public class SmileyGrid extends GridView {
    public static int kTv = 1;
    public ListAdapter FA;
    int hPi = ChatFooterPanel.sIB;
    a kTA;
    private boolean kTB;
    int kTk = 20;
    private int kTm = 0;
    private int kTw;
    public int kTx = 0;
    public int kTy;
    j kTz;
    private OnItemClickListener kbd = new OnItemClickListener(this) {
        final /* synthetic */ SmileyGrid kTC;

        {
            this.kTC = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (this.kTC.kTk) {
                case 20:
                    if (i == this.kTC.FA.getCount() - 1) {
                        if (this.kTC.kTA != null) {
                            this.kTC.kTA.Zh();
                            return;
                        }
                        return;
                    } else if ((this.kTC.kTy * (this.kTC.kTx - 1)) + i < this.kTC.kTw) {
                        int i2 = (this.kTC.kTy * (this.kTC.kTx - 1)) + i;
                        if (this.kTC.kTA != null) {
                            String iQ;
                            if (this.kTC.kTB) {
                                iQ = e.bKD().iQ(i2);
                            } else {
                                iQ = e.bKD().getText(i2);
                            }
                            this.kTC.kTA.append(iQ);
                            g.oUh.i(13470, new Object[]{iQ.replaceAll(",", " "), Integer.valueOf(this.kTC.hPi)});
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 23:
                case 25:
                    if (this.kTC.kTk == 25 && i == 0 && this.kTC.kTy == 0 && this.kTC.hPi != ChatFooterPanel.sID) {
                        SmileyGrid.c(this.kTC);
                        return;
                    }
                    SmileyGrid.a(this.kTC, (c) this.kTC.FA.getItem(i));
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(SmileyGrid smileyGrid, c cVar) {
        if (smileyGrid.kTz == null || cVar == null) {
            w.e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
        } else if (kTv != 2) {
            if (!smileyGrid.kTz.aJT()) {
                com.tencent.mm.ui.base.g.a(smileyGrid.getContext(), R.l.dUM, 0, new OnClickListener(smileyGrid) {
                    final /* synthetic */ SmileyGrid kTC;

                    {
                        this.kTC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (cVar == null) {
            } else {
                if (cVar.field_type != c.uLc && cVar.field_type != c.uLd) {
                    w.i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", new Object[]{cVar.EP()});
                    c c = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().c(cVar);
                    if (c != null) {
                        smileyGrid.kTz.n(c);
                        w.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", new Object[]{c.EP()});
                        return;
                    }
                    w.w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
                } else if (smileyGrid.kTz.aJS()) {
                    smileyGrid.kTz.o(cVar);
                    w.d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", new Object[]{cVar.EP()});
                } else {
                    Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(R.l.dUL), 0).show();
                }
            }
        } else if (cVar.field_catalog == com.tencent.mm.storage.a.a.uKR) {
            com.tencent.mm.ui.base.g.h(smileyGrid.getContext(), R.l.dTk, R.l.dTk).show();
        }
    }

    static /* synthetic */ void c(SmileyGrid smileyGrid) {
        g.oUh.i(11594, new Object[]{Integer.valueOf(1)});
        String value = com.tencent.mm.i.g.sV().getValue("ShowDesignerEmoji");
        w.i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", new Object[]{value});
        d.b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @TargetApi(8)
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void anL() {
        setOnItemClickListener(this.kbd);
    }

    public final void f(int i, int i2, int i3, int i4, int i5) {
        w.v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.kTy);
        setOnItemClickListener(this.kbd);
        this.kTk = i;
        this.kTy = i2;
        this.kTw = i3;
        this.kTx = i4;
        this.kTm = i5;
    }

    public void release() {
        this.kTA = null;
        this.kTz = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.FA = listAdapter;
    }
}
