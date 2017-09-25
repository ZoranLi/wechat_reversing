package com.tencent.mm.plugin.accountsync.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements e {
    private static Account hRB;
    private a ish = null;
    private Looper isi;

    private class a extends AbstractThreadedSyncAdapter {
        final /* synthetic */ ContactsSyncService isj;
        private Context mContext;

        public a(ContactsSyncService contactsSyncService, Context context) {
            this.isj = contactsSyncService;
            super(context, true);
            this.mContext = context;
            w.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            w.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (ap.zb()) {
                try {
                    Looper.prepare();
                    this.isj.isi = Looper.myLooper();
                    ContactsSyncService.a(this.isj, account);
                    Looper.loop();
                    return;
                } catch (Exception e) {
                    this.isj.OC();
                    w.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    return;
                }
            }
            w.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        }
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService, Account account) {
        hRB = account;
        if (!ap.za() || ap.uP()) {
            contactsSyncService.OC();
            w.e("MicroMsg.ContactsSyncService", "performSync error: no user login");
        } else if (m.Fj()) {
            w.i("MicroMsg.ContactsSyncService", "performSync start");
            if (!com.tencent.mm.modelfriend.a.a(new b(contactsSyncService) {
                final /* synthetic */ ContactsSyncService isj;

                {
                    this.isj = r1;
                }

                public final void bg(boolean z) {
                    w.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", Boolean.valueOf(z));
                    if (z) {
                        ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, this.isj);
                        System.currentTimeMillis();
                        ap.vd().a(new aa(m.Fs(), m.Fr()), 0);
                        return;
                    }
                    this.isj.OC();
                }
            })) {
                contactsSyncService.OC();
                w.i("MicroMsg.ContactsSyncService", "performSync result false");
            }
        } else {
            w.e("MicroMsg.ContactsSyncService", "this user has not agreed to upload address book");
            contactsSyncService.OC();
        }
    }

    public ContactsSyncService() {
        w.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (com.tencent.mm.pluginsdk.i.a.aT(this, "android.permission.READ_CONTACTS")) {
            if (this.ish == null) {
                this.ish = new a(this, getApplicationContext());
            }
            iBinder = this.ish.getSyncAdapterBinder();
        } else {
            w.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        w.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        return iBinder;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX) {
            ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
            w.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            ap.yY();
            long longValue = ((Long) c.vr().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            w.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                ap.yY();
                c.vr().set(327728, Long.valueOf(currentTimeMillis));
                ap.vd().a(32, (e) this);
                aa aaVar = (aa) kVar;
                ap.vd().a(new v(aaVar.hBO, aaVar.hBP), 0);
            } else {
                OC();
                w.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                return;
            }
        }
        if (kVar.getType() == 32) {
            ap.vd().b(32, (e) this);
            w.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelsimple.b(this, hRB), "MMAccountManager_updateLocalContacts").start();
            }
            OC();
        }
    }

    private void OC() {
        if (this.isi != null) {
            this.isi.quit();
        }
    }

    public void onDestroy() {
        w.i("MicroMsg.ContactsSyncService", "contacts sync service destory");
        super.onDestroy();
    }
}
