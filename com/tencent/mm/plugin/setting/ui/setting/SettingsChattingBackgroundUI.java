package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.a;
import com.tencent.mm.ap.b;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI extends MMPreference {
    private f isJ;
    private boolean pkR;
    private String username;

    static /* synthetic */ void bag() {
        b Id = t.Id();
        Cursor a = Id.hnH.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null, 0);
        if (a == null) {
            w.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            return;
        }
        t.Ic();
        if (a.moveToFirst()) {
            a aVar = new a();
            while (!a.isAfterLast()) {
                aVar.b(a);
                com.tencent.mm.loader.stub.b.deleteFile(n.w(aVar.getUsername(), true));
                com.tencent.mm.loader.stub.b.deleteFile(n.w(aVar.getUsername(), false));
                a.moveToNext();
            }
        }
        a.close();
        if (Id.hnH.delete("chattingbginfo", null, null) > 0) {
            Id.doNotify();
        }
    }

    public final int ON() {
        return R.o.fuf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 2);
                    intent2.putExtra("CropImage_bg_vertical", gP(true));
                    intent2.putExtra("CropImage_bg_horizontal", gP(false));
                    i iVar = com.tencent.mm.plugin.setting.a.imv;
                    ap.yY();
                    iVar.a(this, intent, intent2, c.xb(), 4, null);
                    return;
                }
                return;
            case 2:
                Context applicationContext = getApplicationContext();
                ap.yY();
                String b = k.b(applicationContext, intent, c.xb());
                if (b != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 2);
                    intent3.putExtra("CropImage_ImgPath", b);
                    intent3.putExtra("CropImage_bg_vertical", gP(true));
                    intent3.putExtra("CropImage_bg_horizontal", gP(false));
                    com.tencent.mm.plugin.setting.a.imv.a(this, intent3, 4);
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    ap.yY();
                    c.vr().set(66820, Integer.valueOf(-1));
                    g.oUh.i(10198, new Object[]{Integer.valueOf(-1)});
                    w.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[]{Integer.valueOf(-1)});
                    if (!this.pkR) {
                        b Id = t.Id();
                        a jT = Id.jT(this.username);
                        if (jT != null) {
                            jT.hNQ = -1;
                            Id.b(jT);
                            break;
                        }
                        jT = new a();
                        jT.username = this.username;
                        jT.hNQ = -1;
                        Id.a(jT);
                        break;
                    }
                    ap.yY();
                    c.vr().set(12311, Integer.valueOf(-1));
                    t.Ic().gj(1);
                    break;
                }
                break;
        }
        if (!this.pkR) {
            setResult(-1);
            finish();
        }
    }

    protected final void KC() {
        zi(R.l.eSj);
        this.isJ = this.vrv;
        this.pkR = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.pkR) {
            Preference Td = this.isJ.Td("settings_chatting_bg_apply_to_all");
            if (Td != null) {
                this.isJ.c(Td);
            }
        }
        this.username = getIntent().getStringExtra("username");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsChattingBackgroundUI pkS;

            {
                this.pkS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkS.aHf();
                this.pkS.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.pkR);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            k.a(this, 1, null);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            w.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.uSU.uTo});
            if (!com.tencent.mm.pluginsdk.i.a.a(this.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                return false;
            }
            adG();
            return true;
        } else if (!str.equals("settings_chatting_bg_apply_to_all")) {
            return false;
        } else {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eSk), "", new OnClickListener(this) {
                final /* synthetic */ SettingsChattingBackgroundUI pkS;

                {
                    this.pkS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsChattingBackgroundUI.bag();
                }
            }, null);
            return true;
        }
    }

    private void adG() {
        if (!k.c(this, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.eQD), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.SettingsChattingBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ SettingsChattingBackgroundUI pkS;

                        {
                            this.pkS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.pkS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String gP(boolean z) {
        t.Ic();
        if (this.pkR) {
            return n.w("default", z);
        }
        return n.w(this.username, z);
    }
}
