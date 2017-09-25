package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.o;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.HashMap;

public class EmojiStoreV2UI extends MMActivity {
    private HashMap<Integer, a> kZp = new HashMap();
    EmojiStoreV2TabView kZq;
    private EmojiStoreV2ViewPager kZr;
    private a kZs;
    private int kZt = 0;
    private boolean kZu = true;
    private boolean kZv = false;

    class a extends o implements e, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a {
        private boolean kZu = false;
        final /* synthetic */ EmojiStoreV2UI kZw;
        private WxViewPager kZx;

        public final /* synthetic */ Fragment I(int i) {
            return lM(i);
        }

        public a(EmojiStoreV2UI emojiStoreV2UI, FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            this.kZw = emojiStoreV2UI;
            super(fragmentActivity.aR());
            this.kZu = z;
            this.kZx = wxViewPager;
            this.kZx.a(this);
            this.kZx.b(this);
            this.kZx.Y(emojiStoreV2UI.kZt);
            d.ep(11);
            if (emojiStoreV2UI.kZq != null) {
                emojiStoreV2UI.kZq.kZm = this;
            }
        }

        public final a lM(int i) {
            return this.kZw.lL(i);
        }

        public final int getCount() {
            if (this.kZu) {
                return 2;
            }
            return 1;
        }

        public final void a(int i, float f, int i2) {
            if (this.kZw.kZq != null) {
                this.kZw.kZq.i(i, f);
            }
        }

        public final void V(int i) {
            w.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[]{Integer.valueOf(i)});
            this.kZw.kZt = i;
            if (this.kZw.kZq != null) {
                this.kZw.kZq.lJ(i);
            }
            if (this.kZw.kZt == 1 && !this.kZw.kZv) {
                g.oUh.i(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = this.kZw;
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzK, Boolean.valueOf(false));
                if (emojiStoreV2UI.kZq != null) {
                    emojiStoreV2UI.kZq.dG(false);
                }
                this.kZw.kZv = true;
            }
        }

        public final void W(int i) {
            w.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[]{Integer.valueOf(i)});
            if (i == 0 && this.kZw.lL(this.kZw.kZt) != null) {
                a lL = this.kZw.lL(this.kZw.kZt);
                if (lL.Fg != null && lL.kLV != null && lL.aoz()) {
                    lL.kLV.aiQ();
                }
            }
        }

        public final void lK(int i) {
            if (i != this.kZw.kZt) {
                this.kZx.k(i, false);
            }
            this.kZw.kZt = i;
        }
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        Intent intent = new Intent();
        String EG = com.tencent.mm.ac.a.EG();
        if (bg.mA(EG)) {
            w.e("MicroMsg.emoji.EmojiStoreV2UI", "load emojiStore Template Path error");
            return;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("showkeyboard", true);
        int i = emojiStoreV2UI.kZt == 0 ? 0 : 1;
        intent.putExtra("sence", i);
        intent.putExtra("rawUrl", "file://" + EG + "/index.html?lang=" + v.ea(emojiStoreV2UI.uSU.uTo) + "&scene=" + i + "&clientType=1&version=" + com.tencent.mm.ac.a.EI());
        com.tencent.mm.bb.d.b(emojiStoreV2UI.uSU.uTo, "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        g.oUh.i(13054, new Object[]{Integer.valueOf(i), Integer.valueOf(0), ""});
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        String value = com.tencent.mm.i.g.sV().getValue("ShowPersonalEmotion");
        w.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[]{value});
        if (bg.mA(value) || bg.PY(value) != 1) {
            this.kZu = false;
        } else {
            this.kZu = true;
        }
        if (this.kZu) {
            this.kZt = getIntent().getIntExtra("emoji_tab", 0);
        }
        KC();
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2UI kZw;

            {
                this.kZw = r1;
            }

            public final void run() {
                com.tencent.mm.q.c.uk().s(262147, false);
                com.tencent.mm.q.c.uk().s(262149, false);
                com.tencent.mm.q.c.uk().aE(262147, 266244);
                com.tencent.mm.q.c.uk().aE(262149, 266244);
                ap.yY();
                c.vr().set(208899, Boolean.valueOf(false));
                ap.yY();
                c.vr().set(208913, Boolean.valueOf(false));
            }
        });
        ap.yY();
        boolean booleanValue = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uzK, Boolean.valueOf(false))).booleanValue();
        if (this.kZq != null) {
            this.kZq.dG(booleanValue);
        }
        g.oUh.a(406, 0, 1, false);
        g.oUh.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ EmojiStoreV2UI kZw;

            {
                this.kZw = r1;
            }

            public final boolean queueIdle() {
                w.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                this.kZw.sendBroadcast(intent);
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.daV;
    }

    protected final void KC() {
        a(0, R.k.dsV, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2UI kZw;

            {
                this.kZw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2UI.a(this.kZw);
                return false;
            }
        });
        a(1, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2UI kZw;

            {
                this.kZw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(this.kZw, EmojiMineUI.class);
                this.kZw.startActivity(intent);
                return false;
            }
        });
        this.kZq = (EmojiStoreV2TabView) findViewById(R.h.bLE);
        this.kZr = (EmojiStoreV2ViewPager) findViewById(R.h.bLD);
        this.kZr.Cb(0);
        this.kZs = new a(this, this, this.kZr, this.kZu);
        if (this.kZu) {
            this.kZq.setVisibility(0);
        } else {
            this.kZq.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kZp != null) {
            this.kZp.clear();
        }
    }

    public final a lL(int i) {
        a aVar = null;
        if (i < 0) {
            return null;
        }
        if (this.kZp.containsKey(Integer.valueOf(i))) {
            return (a) this.kZp.get(Integer.valueOf(i));
        }
        switch (i) {
            case 0:
                aVar = (a) Fragment.a(this, b.class.getName(), null);
                break;
            case 1:
                aVar = (a) Fragment.a(this, c.class.getName(), null);
                break;
            default:
                w.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                break;
        }
        w.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[]{Integer.valueOf(i)});
        if (aVar != null) {
            aVar.a(this);
        }
        this.kZp.put(Integer.valueOf(i), aVar);
        return aVar;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (this.kZs != null && this.kZs.lM(this.kZt) != null) {
            this.kZs.lM(this.kZt).onActivityResult(i, i2, intent);
        }
    }

    protected final int Ol() {
        return 1;
    }
}
