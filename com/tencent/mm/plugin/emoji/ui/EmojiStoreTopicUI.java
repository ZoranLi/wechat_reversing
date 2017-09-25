package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.n;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int hPi;
    private int kRZ;
    private String kSa;
    private String kSb;
    private String kSc;
    private String kSd;
    private String kSe;

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        e eVar = new e(emojiStoreTopicUI.uSU.uTo, e.wuP, false);
        eVar.qJf = new c(emojiStoreTopicUI) {
            final /* synthetic */ EmojiStoreTopicUI kSf;

            {
                this.kSf = r1;
            }

            public final void a(l lVar) {
                lVar.a(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kSf.getString(R.l.fnw), R.k.duZ);
                lVar.a(1000, this.kSf.getString(R.l.fnv), R.k.duP);
            }
        };
        eVar.qJg = new d(emojiStoreTopicUI) {
            final /* synthetic */ EmojiStoreTopicUI kSf;

            {
                this.kSf = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        Context context = this.kSf.uSU.uTo;
                        String a = this.kSf.kSa;
                        String e = this.kSf.kSc;
                        String b = this.kSf.kSb;
                        h.alY();
                        k.a(context, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(this.kSf.kRZ, this.kSf.kSa, this.kSf.kSc, this.kSf.kSb, this.kSf.kSd, 0), 13);
                        g.oUh.i(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(this.kSf.kRZ)});
                        return;
                    case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                        k.bQ(this.kSf.uSU.uTo);
                        this.kSf.uSU.uTo.overridePendingTransition(R.a.aRq, R.a.aQY);
                        g.oUh.i(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(this.kSf.kRZ)});
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
        g.oUh.i(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.kRZ)});
    }

    protected final void amE() {
        super.amE();
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.oUh.i(12740, new Object[]{Integer.valueOf(3), "", "", Integer.valueOf(this.kRZ), Integer.valueOf(this.hPi)});
    }

    protected final void KC() {
        this.kRZ = getIntent().getIntExtra("topic_id", -1);
        this.kSa = getIntent().getStringExtra("topic_name");
        this.kSd = getIntent().getStringExtra("topic_ad_url");
        this.kSb = getIntent().getStringExtra("topic_icon_url");
        this.kSc = getIntent().getStringExtra("topic_desc");
        this.kSe = getIntent().getStringExtra("sns_object_data");
        this.hPi = getIntent().getIntExtra("extra_scence", 0);
        if (!bg.mA(this.kSe)) {
            this.kRZ = EmojiLogic.uo(this.kSe);
            this.kSa = EmojiLogic.up(this.kSe);
            this.kSb = EmojiLogic.ur(this.kSe);
            this.kSc = EmojiLogic.uq(this.kSe);
            this.kSd = EmojiLogic.us(this.kSe);
        }
        qP(this.kSa);
        super.KC();
        a(0, R.k.dyx, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreTopicUI kSf;

            {
                this.kSf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
                if (bg.mA(this.kSf.kSa) || bg.mA(this.kSf.kSb)) {
                    w.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
                } else {
                    EmojiStoreTopicUI.c(this.kSf);
                }
                return true;
            }
        });
        af(0, false);
        uB(this.kSd);
    }

    protected final void uB(String str) {
        if (this.kOB != null && this.kOC != null && !bg.mA(str)) {
            a.getDensity(this);
            com.tencent.mm.storage.a.c a = EmojiLogic.a("Toptic", 8, str, true);
            if (a == null) {
                n.GW().a(str, null, f.b("Toptic", str, new Object[]{"Toptic", "BANNER"}), new i(this) {
                    final /* synthetic */ EmojiStoreTopicUI kSf;

                    {
                        this.kSf = r1;
                    }

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        EmojiBaseActivity emojiBaseActivity = this.kSf;
                        if (emojiBaseActivity.kPE != null) {
                            emojiBaseActivity.kPE.sendEmptyMessage(1009);
                        }
                    }
                });
                return;
            }
            this.kOC.ct(a.eN(a.field_groupId, a.EP()), null);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void a(com.tencent.mm.plugin.emoji.model.e eVar, boolean z, boolean z2) {
        super.a(eVar, z, z2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        amV();
        if (i == MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bg.mA(stringExtra)) {
                w.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + stringExtra);
                int i3 = this.kRZ;
                String str = this.kSa;
                String str2 = this.kSc;
                String str3 = this.kSb;
                String str4 = this.kSd;
                h.alY();
                k.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(boolean z, com.tencent.mm.plugin.emoji.model.e eVar, boolean z2, boolean z3) {
        super.a(z, eVar, z2, z3);
    }

    protected final int amO() {
        return 7;
    }

    public final int amP() {
        return this.kRZ;
    }

    protected final boolean amW() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a amH() {
        return new com.tencent.mm.plugin.emoji.a.f(this.uSU.uTo);
    }

    protected final boolean amM() {
        if (bg.mA(this.kSd)) {
            return false;
        }
        return true;
    }

    protected final boolean amL() {
        return false;
    }

    public final void h(Message message) {
        super.h(message);
        if (message.what == 1009) {
            uB(this.kSd);
        }
    }

    protected final int amF() {
        return 11;
    }

    protected final int amG() {
        return 14;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        super.a(i, i2, str, kVar);
        if (this.kOF) {
            af(0, false);
        } else {
            af(0, true);
        }
    }
}
