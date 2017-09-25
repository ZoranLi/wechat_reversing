package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameKeepPageTopTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.model.FavUrlTask;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public class j {
    public static b mnV = new b() {
        public final void aAt() {
            GWMainProcessTask favUrlTask = new FavUrlTask();
            favUrlTask.actionType = 2;
            GameWebViewMainProcessService.a(favUrlTask);
        }
    };
    private boolean mEnable = false;
    protected GameWebViewBaseActivity mmc;
    private a mnR;
    public HashSet<Integer> mnS = new HashSet();
    public Map<String, Integer> mnT = new HashMap();
    public HashSet<Integer> mnU = new HashSet();
    protected b mnz;

    class AnonymousClass4 implements c {
        final /* synthetic */ j mnW;
        final /* synthetic */ Boolean mnX;
        final /* synthetic */ ArrayList mnY = null;

        AnonymousClass4(j jVar, Boolean bool, ArrayList arrayList) {
            this.mnW = jVar;
            this.mnX = bool;
        }

        public final void a(l lVar) {
            g.oUh.a(480, 0, 1, false);
            if (this.mnX.booleanValue()) {
                int size = this.mnY.size();
                for (int i = 0; i < size; i++) {
                    d.b bVar = (d.b) this.mnY.get(i);
                    m mVar = (m) lVar.e(bVar.id, bVar.title);
                    mVar.vld = bVar;
                    mVar.setIcon(null);
                    mVar.setIcon(0);
                }
                return;
            }
            if (this.mnW.mnz.azx().nw(21) && this.mnW.nA(1)) {
                lVar.a(1, this.mnW.mmc.getString(R.l.eHR), R.k.duZ);
            }
            if (this.mnW.mnz.azx().nw(23) && this.mnW.nA(2)) {
                lVar.a(2, this.mnW.mmc.getString(R.l.eHS), R.k.duP);
            }
            boolean z = this.mnW.getBundle().getBoolean("is_favorite_item", false);
            if (!z && j.aAs() && this.mnW.nA(3)) {
                lVar.a(3, this.mnW.mmc.getString(R.l.eGa), R.k.duI);
            }
            lVar.a(31, this.mnW.mmc.getString(R.l.fnQ), R.k.duX);
            if (this.mnW.mnz.azx().nw(44) && this.mnW.nA(6)) {
                lVar.a(6, this.mnW.mmc.getString(R.l.fnm), R.k.duC);
            }
            boolean z2 = this.mnW.getBundle().getBoolean("key_detail_can_delete", true);
            if (z && z2 && j.aAs()) {
                if (this.mnW.nA(12)) {
                    lVar.a(12, this.mnW.mmc.getString(R.l.ehz), R.k.dux);
                }
                if (this.mnW.nA(9)) {
                    lVar.a(9, this.mnW.mmc.getString(R.l.dGB), R.k.duD);
                }
            }
            if (this.mnW.LZ()) {
                if (this.mnW.nA(32)) {
                    lVar.a(32, this.mnW.mmc.getString(R.l.eHT), R.k.dva);
                }
            } else if (this.mnW.nA(30)) {
                lVar.a(30, this.mnW.mmc.getString(R.l.eHY), R.k.dvb);
            }
            if (this.mnW.mnz.azx().nw(45) && this.mnW.nA(7)) {
                lVar.a(7, this.mnW.mmc.getString(R.l.fnr), R.k.duA);
            }
            if (this.mnW.nA(28)) {
                lVar.a(28, this.mnW.mmc.getString(R.l.flP), R.k.duV);
            }
            if (this.mnW.mnz.azx().mnd) {
                lVar.a(27, this.mnW.mmc.getString(R.l.eHX), R.k.duH);
            }
            String azO = this.mnW.mnz.azx().azO();
            String string = this.mnW.getBundle().getString("shortcut_user_name");
            if (!(this.mnW.getBundle().getBoolean("from_shortcut", false) || bg.mA(azO) || bg.mA(string) || !this.mnW.mnz.azx().nw(255) || !this.mnW.nA(29))) {
                lVar.a(29, this.mnW.mmc.getString(R.l.eHP), R.k.dAF);
            }
            lVar.a(10, this.mnW.mmc.getString(R.l.dOR), R.k.duB);
        }
    }

    public j(b bVar) {
        this.mnz = bVar;
        this.mmc = (GameWebViewBaseActivity) bVar.getContext();
        this.mnT.clear();
        this.mnT.put("menuItem:share:brand", Integer.valueOf(0));
        this.mnT.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.mnT.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.mnT.put("menuItem:share:timeline", Integer.valueOf(2));
        this.mnT.put("menuItem:favorite", Integer.valueOf(3));
        this.mnT.put("menuItem:profile", Integer.valueOf(5));
        this.mnT.put("menuItem:addContact", Integer.valueOf(5));
        this.mnT.put("menuItem:copyUrl", Integer.valueOf(6));
        this.mnT.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.mnT.put("menuItem:share:email", Integer.valueOf(8));
        this.mnT.put("menuItem:delete", Integer.valueOf(9));
        this.mnT.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.mnT.put("menuItem:setFont", Integer.valueOf(11));
        this.mnT.put("menuItem:editTag", Integer.valueOf(12));
        this.mnT.put("menuItem:readMode", Integer.valueOf(14));
        this.mnT.put("menuItem:originPage", Integer.valueOf(14));
        this.mnT.put("menuItem:share:qq", Integer.valueOf(20));
        this.mnT.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.mnT.put("menuItem:share:QZone", Integer.valueOf(22));
        this.mnT.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.mnT.put("menuItem:refresh", Integer.valueOf(28));
        this.mnT.put("menuItem:share:wework", Integer.valueOf(25));
        this.mnT.put("menuItem:share:weread", Integer.valueOf(26));
        this.mnT.put("menuItem:keepTop", Integer.valueOf(30));
        this.mnT.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.mnT.put("menuItem:addShortcut", Integer.valueOf(29));
        this.mnT.put("menuItem:search", Integer.valueOf(31));
        this.mnU.clear();
        this.mnU.add(Integer.valueOf(28));
        this.mnU.add(Integer.valueOf(6));
        this.mnU.add(Integer.valueOf(27));
        this.mnU.add(Integer.valueOf(30));
        this.mnU.add(Integer.valueOf(32));
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.mnR == null || !a.a(this.mmc, i, i2, intent)) {
            return false;
        }
        return true;
    }

    public final boolean nA(int i) {
        return !this.mnS.contains(Integer.valueOf(i));
    }

    public static boolean h(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    public void aAb() {
        e eVar;
        Boolean valueOf = Boolean.valueOf(false);
        if (valueOf.booleanValue()) {
            eVar = new e(this.mmc, e.wuP, false);
        } else {
            eVar = new e(this.mmc, e.wuO, true);
        }
        eVar.wnf = new n.a(this) {
            final /* synthetic */ j mnW;

            {
                this.mnW = r1;
            }

            public final void a(ImageView imageView, MenuItem menuItem) {
                if (j.h(menuItem)) {
                    imageView.setVisibility(8);
                }
            }
        };
        eVar.wng = new n.b(this) {
            final /* synthetic */ j mnW;

            {
                this.mnW = r1;
            }

            public final void a(TextView textView, MenuItem menuItem) {
                CharSequence charSequence = menuItem.getTitle();
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
        };
        eVar.qJg = new n.d(this) {
            final /* synthetic */ j mnW;

            {
                this.mnW = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                if (!this.mnW.mmc.isFinishing() && !this.mnW.mmc.uSW) {
                    if (j.h(menuItem)) {
                        menuItem.getMenuInfo();
                        return;
                    }
                    switch (menuItem.getItemId()) {
                        case 1:
                            this.mnW.aAh();
                            return;
                        case 2:
                            this.mnW.aAi();
                            return;
                        case 3:
                            this.mnW.aAo();
                            return;
                        case 6:
                            this.mnW.aAj();
                            return;
                        case 7:
                            this.mnW.aAm();
                            return;
                        case 9:
                            this.mnW.aAq();
                            return;
                        case 10:
                            this.mnW.aAr();
                            return;
                        case 12:
                            this.mnW.aAp();
                            return;
                        case 27:
                            this.mnW.aAg();
                            return;
                        case 28:
                            this.mnW.refresh();
                            return;
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            this.mnW.aAn();
                            return;
                        case 30:
                            this.mnW.aAk();
                            return;
                        case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                            this.mnW.mnz.azx().eC(true);
                            return;
                        case 32:
                            this.mnW.aAl();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        eVar.qJf = new AnonymousClass4(this, valueOf, null);
        String azN = this.mnz.azx().azN();
        if (!bg.mA(azN)) {
            if (!bg.mA(Uri.parse(azN).getHost())) {
                eVar.d(this.mmc.getString(R.l.fmw, new Object[]{azN}), 1);
            }
        }
        if (this.mnz.isFullScreen()) {
            eVar.sjm = true;
            eVar.sjn = true;
        } else {
            eVar.sjm = false;
            eVar.sjn = false;
        }
        if (this.mnz.azx().mmA.isShown()) {
            this.mnz.azx().eC(false);
            af.f(new Runnable(this) {
                final /* synthetic */ j mnW;

                public final void run() {
                    eVar.bzh();
                }
            }, 100);
            return;
        }
        this.mmc.aHf();
        af.f(new Runnable(this) {
            final /* synthetic */ j mnW;

            public final void run() {
                eVar.bzh();
            }
        }, 100);
    }

    protected final void aAg() {
        if (!this.mnz.azx().azQ()) {
            this.mnz.azC();
        }
    }

    protected final void aAh() {
        h.c(this.mnz.azx());
    }

    protected final void aAi() {
        d azx = this.mnz.azx();
        if (azx.aY("shareTimeline", 88)) {
            azx.xJ("shareTimeline");
            azx.ck("menu:share:timeline", "");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String IU = azx.IU();
            jSONObject.put("link", IU);
            jSONObject.put("desc", IU);
            jSONObject.put("title", azx.getTitle());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GameWebViewShareController", e, "", new Object[0]);
        }
        azx.cl("shareTimeline", jSONObject.toString());
    }

    protected final void aAj() {
        CharSequence IU = this.mnz.azx().IU();
        ClipboardManager clipboardManager = (ClipboardManager) this.mmc.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(IU);
                Toast.makeText(this.mmc, this.mmc.getString(R.l.fnn), 0).show();
                return;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.OptionMenuBtnHelp", e, "clip.setText error", new Object[0]);
                return;
            }
        }
        w.e("MicroMsg.OptionMenuBtnHelp", "clipboard manager is null");
    }

    protected final void aAk() {
        w.i("MicroMsg.OptionMenuBtnHelp", "doKeepPageTopLogic");
        String string = getBundle().getString("custom_keep_top_url");
        String string2 = getBundle().getString("custom_keep_top_title");
        String string3 = getBundle().getString("shortcut_user_name");
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        if (bg.mA(string2) || bg.mA(string)) {
            gameKeepPageTopTask.url = bg.mz(this.mnz.azx().mlI);
            gameKeepPageTopTask.title = this.mnz.azx().getTitle();
            gameKeepPageTopTask.username = "";
        } else {
            gameKeepPageTopTask.url = string;
            gameKeepPageTopTask.title = string2;
            gameKeepPageTopTask.username = string3;
        }
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        b bVar = this.mnz;
        bVar.mme = true;
        bVar.mEnable = bVar.azy();
        bVar.mmd.b(bVar);
        com.tencent.mm.ui.snackbar.a.e(this.mmc, this.mmc.getString(R.l.eHZ));
    }

    protected final void aAl() {
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 2;
        gameKeepPageTopTask.url = "";
        gameKeepPageTopTask.title = "";
        gameKeepPageTopTask.username = "";
        GameWebViewMainProcessService.a(gameKeepPageTopTask);
        SwipeBackLayout swipeBackLayout = this.mnz;
        swipeBackLayout.mme = false;
        swipeBackLayout.mEnable = swipeBackLayout.azy();
        swipeBackLayout.mmd.azE();
        com.tencent.mm.ui.snackbar.a.e(this.mmc, this.mmc.getString(R.l.eHU));
    }

    protected final boolean LZ() {
        if (this.mnz.azB() || this.mnz.mme) {
            return true;
        }
        GWMainProcessTask gameKeepPageTopTask = new GameKeepPageTopTask();
        gameKeepPageTopTask.type = 1;
        GameWebViewMainProcessService.b(gameKeepPageTopTask);
        if (bg.mz(this.mnz.azx().mlI).equals(bg.mz(gameKeepPageTopTask.url))) {
            return true;
        }
        return false;
    }

    protected final void aAm() {
        String IU = this.mnz.azx().IU();
        if (this.mnR == null) {
            this.mnR = new a();
        }
        a.d(this.mmc, IU);
    }

    protected final void aAn() {
        String string = getBundle().getString("shortcut_user_name");
        String azO = this.mnz.azx().azO();
        if (bg.mA(string) || bg.mA(azO)) {
            w.e("MicroMsg.OptionMenuBtnHelp", "addShortcut,appid or username is null");
            return;
        }
        final GWMainProcessTask addShortcutTask = new AddShortcutTask();
        addShortcutTask.username = string;
        addShortcutTask.appId = azO;
        addShortcutTask.iMD = new Runnable(this) {
            final /* synthetic */ j mnW;

            public final void run() {
                addShortcutTask.SN();
                d azx = this.mnW.mnz.azx();
                boolean z = addShortcutTask.success;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", z);
                    azx.ck("onAddShortcutStatus", jSONObject.toString());
                } catch (Exception e) {
                    w.e("MicroMsg.GameWebviewJsLoader", "onGetAddShortcutStatus, e:" + e.getMessage());
                }
                if (addShortcutTask.success) {
                    com.tencent.mm.ui.base.g.a(this.mnW.mmc, R.l.fnj, R.l.dIO, false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 mob;

                        {
                            this.mob = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } else {
                    Toast.makeText(this.mnW.mmc, this.mnW.mmc.getString(R.l.fni), 0).show();
                }
            }
        };
        addShortcutTask.SM();
        GameWebViewMainProcessService.a(addShortcutTask);
    }

    protected final void refresh() {
        if (this.mnz.azx().mmy != null) {
            this.mnz.azx().mmy.reload();
        }
    }

    protected final void aAo() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getBundle().getLong("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getBundle().getString("sns_local_id"));
        bundle.putInt("news_svr_id", getBundle().getInt("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getBundle().getString("news_svr_tweetid"));
        bundle.putInt("message_index", getBundle().getInt("message_index", 0));
        String mz = bg.mz(this.mnz.azx().mlI);
        bundle.putString("rawUrl", mz);
        String azN = this.mnz.azx().azN();
        if (!bg.mA(mz) && mz.endsWith("#rd")) {
            mz = mz.substring(0, mz.length() - 3);
            if (!(bg.mA(azN) || azN.startsWith(mz))) {
                bundle.putString("rawUrl", azN);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bg.mA(azN) || azN.startsWith(mz))) {
            bundle.putString("rawUrl", azN);
            bundle.putLong("msg_id", Long.MIN_VALUE);
            bundle.putString("sns_local_id", "");
        }
        if (getBundle() != null) {
            bundle.putString("preChatName", getBundle().getString("preChatName"));
            bundle.putInt("preMsgIndex", getBundle().getInt("preMsgIndex", 0));
            bundle.putString("prePublishId", getBundle().getString("prePublishId"));
            bundle.putString("preUsername", getBundle().getString("preUsername"));
        }
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 1;
        favUrlTask.lHw = bundle;
        GameWebViewMainProcessService.b(favUrlTask);
        if (favUrlTask.mlt) {
            d azx = this.mnz.azx();
            GameJsApiSendAppMessage.gaz = 1;
            h.c(azx);
            w.i("MicroMsg.OptionMenuBtnHelp", "on favorite simple url");
            return;
        }
        com.tencent.mm.pluginsdk.model.c.a(favUrlTask.ret, 35, this.mmc, mnV);
    }

    public final void aAp() {
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", getBundle().getLong("fav_local_id", -1));
        com.tencent.mm.bb.d.b(this.mmc, "favorite", ".ui.FavTagEditUI", intent);
    }

    protected final void aAq() {
        com.tencent.mm.ui.base.g.a(this.mmc, this.mmc.getString(R.l.dGC), null, null, this.mmc.getString(R.l.dGB), new com.tencent.mm.ui.base.g.d(this) {
            final /* synthetic */ j mnW;

            {
                this.mnW = r1;
            }

            public final void bN(int i, int i2) {
                switch (i2) {
                    case -1:
                        Bundle bundle = new Bundle();
                        bundle.putLong("fav_local_id", this.mnW.getBundle().getLong("fav_local_id", -1));
                        GWMainProcessTask favUrlTask = new FavUrlTask();
                        favUrlTask.actionType = 4;
                        favUrlTask.lHw = bundle;
                        GameWebViewMainProcessService.b(favUrlTask);
                        if (favUrlTask.fDU) {
                            w.i("MicroMsg.OptionMenuBtnHelp", "del fav web url ok, finish webview ui");
                            this.mnW.mmc.finish();
                            return;
                        }
                        return;
                    default:
                        w.i("MicroMsg.OptionMenuBtnHelp", "do del cancel");
                        return;
                }
            }
        });
    }

    protected final void aAr() {
        String str = null;
        String string = getBundle().getString("geta8key_username");
        String azN = this.mnz.azx().azN();
        Intent intent = new Intent(this.mmc, GameWebViewUI.class);
        intent.putExtra("k_username", string);
        intent.putExtra("k_expose_url", azN);
        intent.putExtra("showShare", false);
        if (bg.mA(azN)) {
            string = null;
        } else {
            string = Uri.parse(azN).getHost();
        }
        if (bg.mA(string) || !string.startsWith("mp.weixin.qq.com")) {
            intent.putExtra("k_expose_current_url", azN);
        } else {
            try {
                string = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{p.encode(azN, ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                w.e("MicroMsg.OptionMenuBtnHelp", e.getMessage());
                string = null;
            }
            if (string != null) {
                str = string;
            }
        }
        if (bg.mA(str)) {
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
        }
        intent.putExtra("rawUrl", str);
        this.mmc.startActivity(intent);
    }

    public static boolean aAs() {
        GWMainProcessTask favUrlTask = new FavUrlTask();
        favUrlTask.actionType = 3;
        GameWebViewMainProcessService.b(favUrlTask);
        return favUrlTask.mlu;
    }

    protected final Bundle getBundle() {
        return this.mnz != null ? this.mnz.uT : new Bundle();
    }
}
