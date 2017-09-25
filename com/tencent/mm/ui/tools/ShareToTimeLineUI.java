package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.m.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements e {
    private Intent intent;
    private ProgressDialog isv = null;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jPl = new int[b.values().length];

        static {
            try {
                jPl[b.sIe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    protected final boolean aPd() {
        if (ap.za() && !ap.uP()) {
            return false;
        }
        w.w("MicroMsg.ShareToTimeLine", "not login");
        bZS();
        return true;
    }

    private void bZS() {
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            bZx();
            finish();
            return;
        }
        String action = intent.getAction();
        Bundle ad = s.ad(intent);
        if (bg.mA(action)) {
            w.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            bZx();
            finish();
            return;
        }
        String i = s.i(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (bg.mA(resolveType)) {
            bZx();
            finish();
        } else if (!resolveType.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            bZx();
            finish();
        } else if (action.equals("android.intent.action.SEND") && ad != null) {
            w.i("MicroMsg.ShareToTimeLine", "send signal: " + action);
            Parcelable parcelable = ad.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (bg.l(uri)) {
                    String f = bg.f(this, uri);
                    if (bg.mA(f)) {
                        action = d.a(getContentResolver(), uri, 2);
                    } else {
                        action = f;
                    }
                    if (bg.mA(action) || !bg.Ql(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            eX(action, i);
                            return;
                        }
                        bZx();
                        finish();
                        return;
                    } else if (Ui(action)) {
                        eX(action, i);
                        return;
                    } else {
                        bZx();
                        finish();
                        return;
                    }
                }
                w.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", new Object[]{uri});
                bZx();
                finish();
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                eX(null, i);
            } else {
                bZx();
                finish();
            }
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && ad != null && ad.containsKey("android.intent.extra.STREAM")) {
            w.i("MicroMsg.ShareToTimeLine", "send multi: " + action);
            ArrayList af = af(ad);
            if (af == null || af.size() == 0) {
                bZx();
                finish();
                return;
            }
            d(af, i);
        } else {
            w.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            bZx();
            finish();
        }
    }

    private static boolean Ui(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean a = o.a(str, decodeResultLogger);
        if (a || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return a;
        }
        g.oUh.A(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
        return a;
    }

    private ArrayList<String> af(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            w.e("MicroMsg.ShareToTimeLine", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) ((Parcelable) it.next());
            if (uri == null || !bg.l(uri) || uri.getScheme() == null) {
                w.e("MicroMsg.ShareToTimeLine", "unaccepted uri: " + uri);
            } else {
                String f = bg.f(this, uri);
                if (!bg.mA(f)) {
                    if (Ui(f)) {
                        w.i("MicroMsg.ShareToTimeLine", "multisend file path: " + f);
                        arrayList.add(f);
                    } else {
                        w.w("MicroMsg.ShareToTimeLine", "not image: " + f);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private void eX(String str, String str2) {
        Intent intent = new Intent();
        if (!bg.mA(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!bg.mA(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (ap.za() && !ap.uP()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            intent.putExtra("Ksnsupload_source", 12);
            com.tencent.mm.bb.d.b(this, "sns", ".ui.En_c4f742e5", intent);
        } else if (bg.mA(str)) {
            bZx();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT), intent);
        }
        finish();
    }

    private void d(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0) {
            finish();
            return;
        }
        if (arrayList.size() > 9) {
            arrayList.subList(9, arrayList.size()).clear();
        }
        if (!ap.za() || ap.uP()) {
            Intent intent = new Intent(this, ShareToTimeLineUI.class);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT), intent);
        } else {
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
            if (!bg.mA(str)) {
                intent2.putExtra("Kdescription", str);
            }
            intent2.putExtra("K_go_to_SnsTimeLineUI", true);
            intent2.putExtra("Ksnsupload_source", 12);
            com.tencent.mm.bb.d.b(this, "sns", ".ui.En_c4f742e5", intent2);
        }
        finish();
    }

    private void bZx() {
        Toast.makeText(this, R.l.eWp, 1).show();
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected final void a(b bVar, Intent intent) {
        switch (AnonymousClass2.jPl[bVar.ordinal()]) {
            case 1:
                this.intent = intent;
                w.i("MicroMsg.ShareToTimeLine", "now permission = %d", new Object[]{Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("SystemShareControlBitset"), 0))});
                if ((bg.getInt(com.tencent.mm.i.g.sV().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    w.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    return;
                }
                w.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", new Object[]{s.i(intent, "android.intent.extra.TEXT")});
                if (bg.mA(s.i(intent, "android.intent.extra.TEXT"))) {
                    bZS();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ ShareToTimeLineUI woy;

                    {
                        this.woy = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.woy.finish();
                    }
                });
                ap.vd().a(1200, this);
                ap.vd().a(new ah(format, 15, null), 0);
                return;
            default:
                finish();
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ap.vd().b(1200, this);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (i == 0 && i2 == 0) {
            bZS();
        } else {
            finish();
        }
    }
}
