package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.search.ui.FTSTalkerUI;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.List;

public class f extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public CharSequence ipq;
    public CharSequence ipr;
    public int phb;
    private b phc = new b(this);
    a phd = new a(this);
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public View ipu;
        public ImageView ipv;
        public TextView jWd;
        public TextView kxh;
        final /* synthetic */ f phe;

        public a(f fVar) {
            this.phe = fVar;
            super(fVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ f phe;

        public b(f fVar) {
            this.phe = fVar;
            super(fVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.ddU, viewGroup, false);
            a aVar = this.phe.phd;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.jWd = (TextView) inflate.findViewById(R.h.cof);
            aVar.kxh = (TextView) inflate.findViewById(R.h.clB);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            f fVar = (f) aVar2;
            a aVar3 = (a) aVar;
            ch(aVar3.ipu);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.ipv, fVar.username);
            e.a(fVar.ipq, aVar3.jWd);
            e.a(fVar.ipr, aVar3.kxh);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            String str = null;
            f fVar = (f) aVar;
            Intent intent;
            BizInfo hW;
            Intent intent2;
            if (this.phe.phb < 2) {
                if (com.tencent.mm.modelbiz.e.ib(fVar.username)) {
                    com.tencent.mm.plugin.search.a.imv.d(new Intent().putExtra("Contact_User", fVar.username), context);
                } else if (com.tencent.mm.modelbiz.e.dr(fVar.username)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", fVar.username);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 5);
                    d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
                } else if (com.tencent.mm.modelbiz.e.ic(fVar.username)) {
                    hW = com.tencent.mm.modelbiz.e.hW(fVar.username);
                    if (hW != null) {
                        str = hW.CL();
                    }
                    if (str == null) {
                        str = "";
                    }
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", fVar.username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                } else {
                    com.tencent.mm.plugin.search.a.imv.e(new Intent().putExtra("Chat_User", fVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", fVar.iJC.mam).putExtra("highlight_keyword_list", new ArrayList(fVar.iJD)), context);
                }
            } else if (com.tencent.mm.modelbiz.e.dr(fVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", fVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (com.tencent.mm.modelbiz.e.ic(fVar.username)) {
                hW = com.tencent.mm.modelbiz.e.hW(fVar.username);
                if (hW != null) {
                    str = hW.CL();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", fVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                context.startActivity(new Intent(context, FTSTalkerUI.class).putExtra("Search_Scene", this.phe.mcx).putExtra("key_talker", fVar.username).putExtra("key_query", fVar.fRM).putExtra("key_count", fVar.phb));
            }
            return true;
        }
    }

    public f(int i) {
        super(6, i);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        a aVar2 = (a) aVar;
        this.username = this.iJC.lZO;
        this.ipq = h.b(context, n.eK(this.username), aVar2.jWd.getTextSize());
        if (this.iJC.userData instanceof Integer) {
            this.phb = ((Integer) this.iJC.userData).intValue();
        }
        if (this.phb < 2) {
            CharSequence charSequence = "";
            String str = "";
            ap.yY();
            ce cA = c.wT().cA(this.iJC.mam);
            com.tencent.mm.t.f.a ek;
            com.tencent.mm.t.f.a ek2;
            switch (this.iJC.hPr) {
                case v.CTRL_BYTE /*41*/:
                    str = cA.field_content;
                    if (str == null) {
                        str = this.iJC.content == null ? "" : this.iJC.content;
                    }
                    if (o.dH(this.username)) {
                        str = ay.gj(str);
                        break;
                    }
                    break;
                case 42:
                    ek = com.tencent.mm.t.f.a.ek(cA.field_content);
                    if (ek != null) {
                        str = ek.title;
                    }
                    charSequence = context.getString(R.l.enn);
                    break;
                case 43:
                    ek = com.tencent.mm.t.f.a.ek(cA.field_content);
                    if (ek != null) {
                        str = ek.title;
                    }
                    charSequence = context.getString(R.l.eno);
                    break;
                case 44:
                    ek2 = com.tencent.mm.t.f.a.ek(cA.field_content);
                    if (ek2 != null) {
                        charSequence = ek2.title + ": ";
                        str = ek2.description;
                        break;
                    }
                    break;
                case 45:
                    ek2 = com.tencent.mm.t.f.a.ek(cA.field_content);
                    if (ek2 != null) {
                        str = bg.ap(ek2.title, "") + ": " + bg.ap(ek2.description, "");
                        break;
                    }
                    break;
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    com.tencent.mm.t.f.a ek3 = com.tencent.mm.t.f.a.ek(cA.field_content);
                    if (cA.field_isSend != 1) {
                        str = bg.ap(ek3.hiT, "") + ": " + bg.ap(ek3.hiP, "");
                        break;
                    } else {
                        str = bg.ap(ek3.hiT, "") + ": " + bg.ap(ek3.hiQ, "");
                        break;
                    }
            }
            this.ipr = h.c(context, str.replace('\n', ' '), com.tencent.mm.plugin.fts.d.d.b.mcE);
            if (bg.J(charSequence)) {
                this.ipr = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.ipr, this.fRM, this.iJD, (float) com.tencent.mm.plugin.fts.d.f.a.mcJ, com.tencent.mm.plugin.fts.d.d.b.mcF)).mdL;
                return;
            }
            this.ipr = com.tencent.mm.plugin.fts.d.f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.ipr, this.fRM, this.iJD, ((float) com.tencent.mm.plugin.fts.d.f.a.mcJ) - com.tencent.mm.plugin.fts.d.d.b.mcF.measureText(charSequence.toString()), com.tencent.mm.plugin.fts.d.d.b.mcF)).mdL;
            this.ipr = TextUtils.concat(new CharSequence[]{charSequence, this.ipr});
            return;
        }
        this.ipr = context.getResources().getString(R.l.eQd, new Object[]{Integer.valueOf(this.phb)});
    }

    public com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.phc;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.phd;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
