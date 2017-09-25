package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.i.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class i extends b {
    public int gkv;
    private c uPz;
    public View wfe;

    public i(final Context context) {
        super(context);
        this.wfe = View.inflate(context, R.i.dfO, null);
        if (this.wfe != null) {
            this.gkv = u.getInt(g.sV().getValue("InviteFriendsControlFlags"), 0);
            this.wfe.setVisibility(8);
            this.wfe.setPadding(0, -a.fromDPToPix(context, R.f.aXG), 0, 0);
            if ((this.gkv & 1) > 0) {
                this.wfe.setVisibility(0);
                this.wfe.setPadding(0, 0, 0, 0);
            }
            this.wfe.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ i wff;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Invite_friends", 1);
                    d.b(context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
                    com.tencent.mm.plugin.report.service.g.oUh.i(14034, Integer.valueOf(1));
                }
            });
            this.uPz = new c<cg>(this) {
                final /* synthetic */ i wff;

                {
                    this.wff = r2;
                    this.usg = cg.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    w.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
                    this.wff.gkv = u.getInt(g.sV().getValue("InviteFriendsControlFlags"), 0);
                    if ((this.wff.gkv & 1) > 0) {
                        this.wff.wfe.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 wfg;

                            {
                                this.wfg = r1;
                            }

                            public final void run() {
                                this.wfg.wff.wfe.setVisibility(0);
                                this.wfg.wff.wfe.setPadding(0, 0, 0, 0);
                            }
                        });
                    }
                    return true;
                }
            };
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean Xj() {
        com.tencent.mm.sdk.b.a.urY.b(this.uPz);
        return this.wfe != null && this.wfe.getVisibility() == 0;
    }

    public final void release() {
        com.tencent.mm.sdk.b.a.urY.c(this.uPz);
    }

    public final void destroy() {
    }

    public final View getView() {
        return this.wfe;
    }
}
