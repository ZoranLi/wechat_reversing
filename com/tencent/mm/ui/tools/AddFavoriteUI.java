package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.m.d;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity {
    String filePath = null;
    private ae handler = new ae(this) {
        final /* synthetic */ AddFavoriteUI wkG;

        {
            this.wkG = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.wkG);
            if (bg.mA(this.wkG.filePath) || (bg.Ql(this.wkG.filePath) && !AddFavoriteUI.Ui(this.wkG.filePath))) {
                w.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
                this.wkG.bZx();
                this.wkG.finish();
                return;
            }
            AddFavoriteUI.h(this.wkG);
        }
    };
    private Intent intent = null;
    private ProgressDialog isv = null;
    Uri uri = null;
    ArrayList<String> wkD = null;
    private ae wkE = new ae(this) {
        final /* synthetic */ AddFavoriteUI wkG;

        {
            this.wkG = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.wkG);
            w.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[]{Boolean.valueOf(AddFavoriteUI.e(this.wkG))});
        }
    };
    private ae wkF = new ae(this) {
        final /* synthetic */ AddFavoriteUI wkG;

        {
            this.wkG = r1;
        }

        public final void handleMessage(Message message) {
            AddFavoriteUI.d(this.wkG);
            AddFavoriteUI.f(this.wkG);
        }
    };

    private class a implements Runnable {
        private Uri apg;
        final /* synthetic */ AddFavoriteUI wkG;
        private b wkH;

        public a(AddFavoriteUI addFavoriteUI, Uri uri, b bVar) {
            this.wkG = addFavoriteUI;
            this.apg = uri;
            this.wkH = bVar;
        }

        public final void run() {
            this.wkG.filePath = AddFavoriteUI.a(this.wkG, this.apg);
            if (bg.mA(this.wkG.filePath) || !new File(this.wkG.filePath).exists()) {
                if (AddFavoriteUI.Uj(this.wkG.getContentResolver().getType(this.apg)) == 8) {
                    this.wkG.filePath = d.a(this.wkG.getContentResolver(), this.apg);
                } else {
                    this.wkG.filePath = d.a(this.wkG.getContentResolver(), this.apg, 1);
                }
            }
            if (this.wkH != null) {
                this.wkH.bZy();
            }
        }
    }

    public interface b {
        void bZy();
    }

    static /* synthetic */ String a(AddFavoriteUI addFavoriteUI, Uri uri) {
        String scheme = uri.getScheme();
        if (bg.mA(scheme)) {
            w.e("MicroMsg.AddFavoriteUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            w.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            w.i("MicroMsg.AddFavoriteUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = addFavoriteUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                w.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                w.e("MicroMsg.AddFavoriteUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((addFavoriteUI.intent != null && addFavoriteUI.intent.getType().equals("text/x-vcalendar")) || p.gRl.gQe == 1)) {
                    return addFavoriteUI.a(uri, query);
                }
                query.close();
                return bg.f(addFavoriteUI, uri);
            }
        } else {
            w.e("MicroMsg.AddFavoriteUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void d(AddFavoriteUI addFavoriteUI) {
        if (addFavoriteUI.isv != null && addFavoriteUI.isv.isShowing()) {
            addFavoriteUI.isv.dismiss();
        }
    }

    static /* synthetic */ boolean e(AddFavoriteUI addFavoriteUI) {
        boolean z = false;
        addFavoriteUI.intent = addFavoriteUI.getIntent();
        if (addFavoriteUI.intent == null) {
            w.e("MicroMsg.AddFavoriteUI", "intent is null");
            return false;
        }
        String i = s.i(addFavoriteUI.intent, "android.intent.extra.TEXT");
        if (i == null || i.length() == 0) {
            w.i("MicroMsg.AddFavoriteUI", "text is null");
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(i));
        wXMediaMessage.description = i;
        Req req = new Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        int type = req.message.getType();
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, 620757000);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!ap.za() || ap.uP()) {
            w.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class), addFavoriteUI.getIntent().addFlags(67108864));
            addFavoriteUI.finish();
        } else {
            com.tencent.mm.sdk.b.b cbVar = new cb();
            String str = e.aR(addFavoriteUI.filePath) + "." + e.aQ(addFavoriteUI.filePath);
            if (type == 1) {
                if (bg.mA(i)) {
                    w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    cbVar.fFA.fFG = R.l.eib;
                } else {
                    w.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[]{i, Integer.valueOf(13)});
                    rv rvVar = new rv();
                    rw rwVar = new rw();
                    rwVar.OD(m.xL());
                    rwVar.OE(m.xL());
                    rwVar.yj(13);
                    rwVar.ep(bg.Nz());
                    rvVar.a(rwVar);
                    cbVar.fFA.desc = i;
                    cbVar.fFA.fFC = rvVar;
                    cbVar.fFA.type = 1;
                    z = true;
                }
                Boolean.valueOf(z);
            } else {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.e.a(cbVar, 13, addFavoriteUI.filePath, str, ""));
            }
            cbVar.fFA.activity = addFavoriteUI;
            cbVar.fFA.fFI = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wkG.finish();
                }
            };
            cbVar.fFA.fFJ = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void azn() {
                }

                public final void onHide() {
                    this.wkG.finish();
                }

                public final void azo() {
                }
            };
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
        }
        return true;
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        w.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int Uj = Uj(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (Uj == -1) {
            w.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        w.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(Uj)});
        if (Uj == 8 && !bg.mA(addFavoriteUI.filePath)) {
            addFavoriteUI.aH(Uj, addFavoriteUI.filePath);
        } else if (s.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ap.za() || ap.uP()) {
            ArrayList arrayList;
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (bg.bV(addFavoriteUI.wkD)) {
                arrayList = new ArrayList(0);
            } else {
                ArrayList arrayList2 = new ArrayList(addFavoriteUI.wkD.size());
                Iterator it = addFavoriteUI.wkD.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Uri.fromFile(new File((String) it.next())));
                }
                arrayList = arrayList2;
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
            addFavoriteUI.finish();
        } else {
            com.tencent.mm.sdk.b.b cbVar = new cb();
            List<String> list = addFavoriteUI.wkD;
            if (list == null || list.isEmpty()) {
                w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                cbVar.fFA.fFG = R.l.eib;
            } else if (list.size() > 9) {
                cbVar.fFA.fFG = R.l.eii;
            } else {
                w.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", new Object[]{list, Integer.valueOf(13)});
                rv rvVar = new rv();
                rw rwVar = new rw();
                for (String str : list) {
                    if (!bg.mA(str)) {
                        rm rmVar = new rm();
                        rmVar.yb(2);
                        rmVar.NZ(str);
                        rmVar.jK(true);
                        rvVar.tzn.add(rmVar);
                    }
                }
                rwVar.OD(m.xL());
                rwVar.OE(m.xL());
                rwVar.yj(13);
                rwVar.ep(bg.Nz());
                rvVar.a(rwVar);
                cbVar.fFA.title = "";
                cbVar.fFA.fFC = rvVar;
                cbVar.fFA.type = 2;
            }
            cbVar.fFA.activity = addFavoriteUI;
            cbVar.fFA.fFI = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wkG.finish();
                }
            };
            cbVar.fFA.fFJ = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void azn() {
                }

                public final void onHide() {
                    this.wkG.finish();
                }

                public final void azo() {
                }
            };
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
        }
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        w.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int Uj = Uj(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (Uj == -1) {
            w.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        w.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(Uj)});
        if ((Uj == 8 || Uj == 4) && !bg.mA(addFavoriteUI.filePath)) {
            addFavoriteUI.aH(Uj, addFavoriteUI.filePath);
        } else if (s.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !ap.za() || ap.uP()) {
            addFavoriteUI.finish();
            addFavoriteUI.bZw();
        } else {
            com.tencent.mm.sdk.b.b cbVar = new cb();
            com.tencent.mm.pluginsdk.model.e.a(cbVar, 13, addFavoriteUI.filePath);
            cbVar.fFA.activity = addFavoriteUI;
            cbVar.fFA.fFI = new OnClickListener(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wkG.finish();
                }
            };
            cbVar.fFA.fFJ = new c(addFavoriteUI) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void azn() {
                }

                public final void onHide() {
                    this.wkG.finish();
                }

                public final void azo() {
                }
            };
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
        }
    }

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        zg(8);
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.pX();
                KC();
                return;
            case 1:
                finish();
                return;
            default:
                w.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        w.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        w.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
    }

    protected void onDestroy() {
        w.i("MicroMsg.AddFavoriteUI", "on Destroy");
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void KC() {
        this.intent = getIntent();
        if (this.intent == null) {
            w.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            bZx();
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle ad = s.ad(this.intent);
        if (bg.mA(action)) {
            w.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            bZx();
            finish();
            return;
        }
        if (ad != null) {
            Parcelable parcelable = ad.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!bg.l(this.uri)) {
                    w.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[]{this.uri});
                    bZx();
                    finish();
                    return;
                }
            } else if (parcelable != null) {
                w.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[]{parcelable});
                bZx();
                finish();
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            w.i("MicroMsg.AddFavoriteUI", "send signal: " + action);
            if (this.uri == null) {
                showDialog();
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ AddFavoriteUI wkG;

                    {
                        this.wkG = r1;
                    }

                    public final void run() {
                        this.wkG.wkE.sendEmptyMessage(0);
                    }
                }, "AddFavoriteUI_dealWithTextHandler");
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this, this.uri, new b(this) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void bZy() {
                    this.wkG.handler.sendEmptyMessage(0);
                }
            }), "AddFavoriteUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && ad != null && ad.containsKey("android.intent.extra.STREAM")) {
            w.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[]{action, getIntent().resolveType(this)});
            if (bg.ap(getIntent().resolveType(this), "").contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                this.wkD = af(ad);
                if (this.wkD == null || this.wkD.size() == 0) {
                    w.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    Ce(1);
                    finish();
                    return;
                }
                showDialog();
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ AddFavoriteUI wkG;

                    {
                        this.wkG = r1;
                    }

                    public final void run() {
                        this.wkG.wkF.sendEmptyMessage(0);
                    }
                }, "AddFavoriteUI_dealWithMultiItemHandler");
                return;
            }
            w.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            Ce(1);
            finish();
        } else {
            w.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            bZx();
            finish();
        }
    }

    private void bZw() {
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", bg.mA(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
    }

    private ArrayList<String> af(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            w.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                w.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!bg.l(uri) || uri.getScheme() == null) {
                    w.e("MicroMsg.AddFavoriteUI", "unaccepted uri: " + uri);
                } else {
                    String f = bg.f(this, uri);
                    if (!bg.mA(f)) {
                        if (bg.Ql(f) && Ui(f)) {
                            w.i("MicroMsg.AddFavoriteUI", "multisend file path: " + f);
                            arrayList.add(f);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        w.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: " + f);
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return null;
            }
        }
        return arrayList.size() > 0 ? arrayList : null;
    }

    private static boolean Ui(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean a = o.a(str, decodeResultLogger);
        if (!a && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            g.oUh.A(12712, KVStatHelper.getKVStatString(str, 5, decodeResultLogger));
        }
        return a;
    }

    private void aH(int i, String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            return;
        }
        int aN = e.aN(str);
        w.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[]{Integer.valueOf(aN)});
        if (aN == 0) {
            w.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, R.l.eis, 1).show();
            finish();
        } else if (aN > 26214400) {
            w.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, R.l.ejH, 1).show();
            finish();
        } else if (!ap.za() || ap.uP()) {
            w.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            bZw();
        } else {
            WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
            wXMediaMessage.title = new File(str).getName();
            if (bg.mA(null)) {
                wXMediaMessage.description = bg.ay((long) aN);
            } else {
                wXMediaMessage.description = null;
            }
            if (aN < 30720) {
                wXMediaMessage.thumbData = e.c(str, 0, -1);
            } else {
                w.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            Req req = new Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, 620757000);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            com.tencent.mm.sdk.b.b cbVar = new cb();
            String str2 = e.aR(str) + "." + e.aQ(str);
            if (i == 4) {
                String str3 = "";
                if (bg.mA(str)) {
                    w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    cbVar.fFA.fFG = R.l.eib;
                } else {
                    w.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[]{str2, str3, str, Integer.valueOf(13)});
                    if (new File(str).length() > ((long) com.tencent.mm.i.b.sD())) {
                        cbVar.fFA.fFG = R.l.ejH;
                    } else {
                        rv rvVar = new rv();
                        rw rwVar = new rw();
                        rm rmVar = new rm();
                        rmVar.NZ(str);
                        rmVar.yb(4);
                        rmVar.NV(e.aQ(str));
                        rmVar.Oa(null);
                        rmVar.ya(0);
                        rmVar.NL(str2);
                        rmVar.NM(str3);
                        rwVar.OD(m.xL());
                        rwVar.OE(m.xL());
                        rwVar.yj(13);
                        rwVar.ep(bg.Nz());
                        rvVar.a(rwVar);
                        rvVar.tzn.add(rmVar);
                        cbVar.fFA.title = rmVar.title;
                        cbVar.fFA.desc = rmVar.title;
                        cbVar.fFA.fFC = rvVar;
                        cbVar.fFA.type = 4;
                    }
                }
            } else {
                com.tencent.mm.pluginsdk.model.e.a(cbVar, 13, str, str2, "");
            }
            cbVar.fFA.activity = this;
            cbVar.fFA.fFI = new OnClickListener(this) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wkG.finish();
                }
            };
            cbVar.fFA.fFJ = new c(this) {
                final /* synthetic */ AddFavoriteUI wkG;

                {
                    this.wkG = r1;
                }

                public final void azn() {
                }

                public final void onHide() {
                    this.wkG.finish();
                }

                public final void azo() {
                }
            };
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
        }
    }

    private String a(Uri uri, Cursor cursor) {
        FileInputStream createInputStream;
        FileOutputStream openFileOutput;
        FileNotFoundException e;
        Throwable e2;
        IOException e3;
        Exception e4;
        FileOutputStream fileOutputStream = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                w.i("MicroMsg.AddFavoriteUI", "vcard file name: " + str);
            }
            cursor.close();
            AssetFileDescriptor openAssetFileDescriptor;
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
                try {
                    createInputStream = openAssetFileDescriptor.createInputStream();
                    try {
                        byte[] bArr = new byte[((int) openAssetFileDescriptor.getDeclaredLength())];
                        if (createInputStream.read(bArr) > 0) {
                            ap.yY();
                            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                String str2 = com.tencent.mm.compatible.util.e.hgu + "share";
                                str = com.tencent.mm.compatible.util.e.hgu + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (e.b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e5) {
                                            w.printErrStackTrace("MicroMsg.AddFavoriteUI", e5, e5.getMessage(), new Object[0]);
                                            return str;
                                        }
                                    }
                                    if (openAssetFileDescriptor == null) {
                                        return str;
                                    }
                                    openAssetFileDescriptor.close();
                                    return str;
                                }
                            }
                            deleteFile(str);
                            openFileOutput = openFileOutput(str, 0);
                            try {
                                openFileOutput.write(bArr);
                                openFileOutput.flush();
                                str = getFilesDir().getPath() + "/" + str;
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e52) {
                                        w.printErrStackTrace("MicroMsg.AddFavoriteUI", e52, e52.getMessage(), new Object[0]);
                                        return str;
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput == null) {
                                    return str;
                                }
                                openFileOutput.close();
                                return str;
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                try {
                                    w.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e22) {
                                            w.printErrStackTrace("MicroMsg.AddFavoriteUI", e22, e22.getMessage(), new Object[0]);
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    if (openFileOutput != null) {
                                        openFileOutput.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    e22 = th;
                                    fileOutputStream = openFileOutput;
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e522) {
                                            w.printErrStackTrace("MicroMsg.AddFavoriteUI", e522, e522.getMessage(), new Object[0]);
                                            throw e22;
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e22;
                                }
                            } catch (IOException e7) {
                                e3 = e7;
                                w.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e222) {
                                        w.printErrStackTrace("MicroMsg.AddFavoriteUI", e222, e222.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            } catch (Exception e8) {
                                e4 = e8;
                                w.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e2222) {
                                        w.printErrStackTrace("MicroMsg.AddFavoriteUI", e2222, e2222.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e22222) {
                                w.printErrStackTrace("MicroMsg.AddFavoriteUI", e22222, e22222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        openFileOutput = null;
                        w.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (IOException e10) {
                        e3 = e10;
                        openFileOutput = null;
                        w.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Exception e11) {
                        e4 = e11;
                        openFileOutput = null;
                        w.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        e22222 = th2;
                        if (createInputStream != null) {
                            createInputStream.close();
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e22222;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    openFileOutput = null;
                    createInputStream = null;
                    w.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (IOException e13) {
                    e3 = e13;
                    openFileOutput = null;
                    createInputStream = null;
                    w.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e4 = e14;
                    openFileOutput = null;
                    createInputStream = null;
                    w.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    e22222 = th3;
                    createInputStream = null;
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e22222;
                }
            } catch (FileNotFoundException e15) {
                e = e15;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                w.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (IOException e16) {
                e3 = e16;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                w.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e3.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Exception e17) {
                e4 = e17;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                w.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Throwable th4) {
                e22222 = th4;
                createInputStream = null;
                openAssetFileDescriptor = null;
                if (createInputStream != null) {
                    createInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22222;
            }
        }
        return null;
    }

    private static int Uj(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            return 2;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return 4;
        }
        w.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
        return 8;
    }

    private void bZx() {
        Ce(0);
        Toast.makeText(this, R.l.eWn, 1).show();
    }

    private void Ce(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, R.l.eWl, 1).show();
                return;
            default:
                Toast.makeText(this, R.l.eWn, 1).show();
                return;
        }
    }

    private void showDialog() {
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ AddFavoriteUI wkG;

            {
                this.wkG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }
}
