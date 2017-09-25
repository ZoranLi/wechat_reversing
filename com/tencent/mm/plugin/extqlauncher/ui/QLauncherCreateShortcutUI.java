package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.i.cZX);
        Intent intent = new Intent();
        int q = s.q(new int[]{s.vYN, 64, 16384});
        s.ef(q, 1);
        intent.putExtra("list_attr", q);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.l.dCT));
        intent.putExtra("block_contact", m.xL());
        d.a(this, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[]{Integer.valueOf(i2)});
        if (i2 != -1) {
            finish();
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (ap.zb()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (bg.mA(stringExtra)) {
                            list = null;
                        } else {
                            list = bg.f(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            w.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String xL = m.xL();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    ap.yY();
                                    a Rc = c.wR().Rc((String) list.get(i3));
                                    if (Rc == null || ((int) Rc.gTQ) <= 0) {
                                        w.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        return;
                                    }
                                    String rQ = com.tencent.mm.plugin.base.model.c.rQ((String) list.get(i3));
                                    if (bg.mA(rQ)) {
                                        w.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", com.tencent.mm.plugin.base.model.c.jOR);
                                    contentValues.put("owner_id", com.tencent.mm.plugin.base.model.c.rQ(xL));
                                    contentValues.put("unique_id", rQ);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(com.tencent.mm.plugin.base.model.c.y(Rc)));
                                    contentValues.put("name", n.a(Rc, (String) list.get(i3)));
                                    com.tencent.mm.x.n.Bl();
                                    contentValues.put("icon_path", com.tencent.mm.x.d.r((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", rQ);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.lsd, contentValuesArr);
                                Toast.makeText(this, R.l.egT, 0).show();
                                b.arf().ari();
                                break;
                            } catch (Throwable e) {
                                w.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[]{e.getMessage()});
                                w.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, R.l.egS, 0).show();
                                break;
                            }
                        }
                        w.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    w.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, R.l.egS, 0).show();
                    finish();
                    return;
                }
                break;
        }
        finish();
    }
}
