package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    public static final SparseArray<a> pey;

    static class a {
        int id;
        String peA;
        boolean peB;
        int pez;
        String uri;
        String username;

        public a(int i, int i2, String str, String str2, String str3) {
            this(i, i2, str, str2, str3, (byte) 0);
        }

        public a(int i, int i2, String str, String str2, String str3, byte b) {
            this.id = i;
            this.pez = i2;
            this.uri = str;
            this.peA = str2;
            this.username = str3;
        }
    }

    static {
        SparseArray sparseArray = new SparseArray();
        pey = sparseArray;
        sparseArray.put(19, new a(19, -1, ".ui.En_424b8e16", "sns", ""));
        pey.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        pey.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        pey.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        pey.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        pey.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
        pey.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        pey.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        pey.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        pey.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        pey.put(23, new a(23, 1, ".ui.chatting.En_5b8fbb1e", "", "qqmail"));
        pey.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
        pey.put(24, new a(24, 8, ".ui.chatting.En_5b8fbb1e", "", "weibo"));
        pey.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        pey.put(28, new a(28, SQLiteGlobal.journalSizeLimit, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        pey.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        pey.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        pey.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
        pey.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        pey.put(38, new a(38, 16, ".ui.chatting.En_5b8fbb1e", "", "medianote"));
        pey.put(39, new a(39, -1, ".ui.chatting.En_5b8fbb1e", "", "filehelper"));
        pey.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        pey.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        pey.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        pey.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        pey.put(43, new a(43, -1, ".ui.chatting.En_5b8fbb1e", "", "gh_43f2581f6fd6"));
        pey.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        pey.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    }

    private static boolean av(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        d.b(context, "profile", ".ui.ContactInfoUI", intent);
        return true;
    }

    public static boolean E(Context context, int i) {
        if (pey.indexOfKey(i) < 0) {
            return false;
        }
        if (i == 30 && (com.tencent.mm.n.a.aI(context) || com.tencent.mm.n.a.aH(context))) {
            return false;
        }
        a aVar = (a) pey.get(i);
        if (aVar.pez != -1 && (m.xW() & aVar.pez) != 0) {
            return av(context, aVar.username);
        }
        if (!bg.mA(aVar.peA)) {
            Intent intent = new Intent();
            if (i == 28) {
                intent.putExtra(Columns.TYPE, 20);
            }
            if (i == 1) {
                intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
            }
            intent.putExtra("animation_pop_in", aVar.peB);
            if (i == 32) {
                g.oUh.i(12065, new Object[]{Integer.valueOf(6)});
            }
            if (i == 6) {
                intent.putExtra("pay_channel", 15);
            }
            if (i == 31) {
                intent.putExtra("game_report_from_scene", 4);
            }
            if (i == 41) {
                intent.putExtra("key_from_scene", 5);
            }
            if (i == 42) {
                intent.putExtra("key_from_scene", 4);
            }
            if (i == 35) {
                intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                MMWizardActivity.z(context, intent);
            } else if (aVar.peA.equals("app")) {
                d.a(context, aVar.uri, intent);
            } else {
                d.b(context, aVar.peA, aVar.uri, intent);
            }
            b.A(context, intent);
            return true;
        } else if (aVar.uri.equals(".ui.chatting.En_5b8fbb1e")) {
            String str = aVar.username;
            ap.yY();
            if (com.tencent.mm.j.a.ez(c.wR().Rc(str).field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Chat_User", str);
                intent2.putExtra("finish_direct", true);
                d.a(context, ".ui.chatting.En_5b8fbb1e", intent2);
            } else {
                av(context, str);
            }
            return true;
        } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
            return av(context, aVar.username);
        } else {
            w.e("MicroMsg.Feature", "Error URI of android feature");
            return false;
        }
    }
}
