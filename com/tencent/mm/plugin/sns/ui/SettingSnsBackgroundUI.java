package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    protected String filePath;
    private SharedPreferences hgx;
    private f isJ;

    public final int ON() {
        return m.pNx;
    }

    public void onCreate(Bundle bundle) {
        w.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.isJ = this.vrv;
        this.hgx = getSharedPreferences(ab.bIX(), 0);
        KC();
    }

    protected void onNewIntent(Intent intent) {
        w.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    }

    public void onResume() {
        super.onResume();
        if (this.isJ != null) {
            this.isJ.notifyDataSetChanged();
        }
    }

    private void b(int i, Intent intent) {
        String str;
        switch (i) {
            case 2:
                w.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = k.b(getApplicationContext(), intent, ae.getAccSnsTmpPath());
                if (this.filePath != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_ImgPath", this.filePath);
                    str = "CropImage_OutputPath";
                    intent2.putExtra(str, ae.getAccSnsTmpPath() + g.n((this.filePath + System.currentTimeMillis()).getBytes()));
                    a.imv.a(this, intent2, 6);
                    return;
                }
                return;
            case 5:
                w.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent != null) {
                    this.filePath = k.b(getApplicationContext(), intent, ae.getAccSnsTmpPath());
                    if (this.filePath != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_ImgPath", this.filePath);
                        a.imv.a(this, intent, intent3, ae.getAccSnsTmpPath(), 6, new com.tencent.mm.ui.tools.a.a(this) {
                            final /* synthetic */ SettingSnsBackgroundUI qxl;

                            {
                                this.qxl = r1;
                            }

                            public final String GP(String str) {
                                return ae.getAccSnsTmpPath() + g.n((this.qxl.filePath + System.currentTimeMillis()).getBytes());
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 6:
                w.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ SettingSnsBackgroundUI qxl;

                    {
                        this.qxl = r1;
                    }

                    public final void run() {
                        a.imw.ow();
                    }
                });
                if (intent != null) {
                    this.filePath = intent.getStringExtra("CropImage_OutputPath");
                    if (this.filePath != null) {
                        w.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                        av beH = ae.beH();
                        String str2 = this.filePath;
                        new LinkedList().add(new h(str2, 2));
                        if (!(beH.ber() == null || beH.ber().equals(""))) {
                            str = am.du(ae.getAccSnsPath(), beH.ber());
                            FileOp.kl(str);
                            FileOp.deleteFile(str + beH.ber() + "bg_");
                            FileOp.p(str2, str + beH.ber() + "bg_");
                            l beO = ae.beO();
                            com.tencent.mm.plugin.sns.storage.k Gk = beO.Gk(beH.ber());
                            Gk.field_bgId = "";
                            beO.c(Gk);
                        }
                        beH.bft();
                        beH.ber();
                        aw awVar = new aw(7);
                        awVar.dy(str2, "");
                        awVar.tk(1);
                        awVar.commit();
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                }
                return;
            default:
                w.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                return;
        }
    }

    protected void onActivityResult(final int i, final int i2, final Intent intent) {
        w.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 == -1) {
            StringBuilder stringBuilder = new StringBuilder("result ok ");
            com.tencent.mm.kernel.h.vJ();
            w.d("MicroMsg.SettingSnsBackgroundUI", stringBuilder.append(com.tencent.mm.kernel.h.vG().uV()).toString());
            if (ae.beu()) {
                new com.tencent.mm.sdk.platformtools.ae(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ SettingSnsBackgroundUI qxl;

                    public final void run() {
                        this.qxl.b(i, intent);
                    }
                }, 2000);
                return;
            }
            w.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
            b(i, intent);
        } else if (i == 2 || i == 5 || i == 6) {
            new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SettingSnsBackgroundUI qxl;

                {
                    this.qxl = r1;
                }

                public final void run() {
                    a.imw.ow();
                }
            });
        }
    }

    protected final void KC() {
        zi(j.pKa);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.isJ.Td("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.hgx.getString("artist_name", "");
            w.d("MicroMsg.SettingSnsBackgroundUI", "artistName" + string);
            snsArtistPreference.qyU = string;
            snsArtistPreference.bjL();
            this.isJ.notifyDataSetChanged();
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingSnsBackgroundUI qxl;

            {
                this.qxl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qxl.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            com.tencent.mm.kernel.h.vJ();
            if (com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                k.a(this, 5, null);
                return true;
            }
            s.eP(this);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            com.tencent.mm.kernel.h.vJ();
            if (com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                w.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.uSU.uTo});
                if (!com.tencent.mm.pluginsdk.i.a.a(this.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                    return false;
                }
                adG();
                return true;
            }
            s.eP(this);
            return false;
        } else if (!str.equals("settings_sns_bg_select_bg")) {
            return false;
        } else {
            startActivity(new Intent(this, ArtistUI.class));
            return true;
        }
    }

    private void adG() {
        if (!k.c(this, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(j.eQD), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            w.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult grantResults[%s] invalid", new Object[]{iArr});
            return;
        }
        w.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(j.eFG), getString(j.eFM), getString(j.evw), getString(j.dGs), false, new OnClickListener(this) {
                        final /* synthetic */ SettingSnsBackgroundUI qxl;

                        {
                            this.qxl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qxl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
