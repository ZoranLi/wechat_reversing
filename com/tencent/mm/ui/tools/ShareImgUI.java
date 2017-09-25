package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.i.g;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.pluginsdk.m.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements e {
    String filePath = null;
    private ae handler = new ae(this) {
        final /* synthetic */ ShareImgUI wou;

        {
            this.wou = r1;
        }

        public final void handleMessage(Message message) {
            ShareImgUI.b(this.wou);
            if (bg.mA(this.wou.filePath)) {
                w.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                this.wou.Ce(0);
                this.wou.finish();
                return;
            }
            this.wou.bZS();
        }
    };
    private Intent intent = null;
    private ProgressDialog isv = null;
    String text = null;
    Uri uri = null;
    ArrayList<String> wkD = null;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] jPl = new int[com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b.values().length];

        static {
            try {
                jPl[com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b.sIe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private class a implements Runnable {
        private Uri apg;
        final /* synthetic */ ShareImgUI wou;
        private b wov;

        public a(ShareImgUI shareImgUI, Uri uri, b bVar) {
            this.wou = shareImgUI;
            this.apg = uri;
            this.wov = bVar;
        }

        public final void run() {
            this.wou.filePath = ShareImgUI.a(this.wou, this.apg);
            if (bg.mA(this.wou.filePath) || !new File(this.wou.filePath).exists()) {
                if (ShareImgUI.Uj(this.wou.getContentResolver().getType(this.apg)) == 3) {
                    this.wou.filePath = d.a(this.wou.getContentResolver(), this.apg);
                } else {
                    this.wou.filePath = d.a(this.wou.getContentResolver(), this.apg, 1);
                }
            }
            if (this.wov != null) {
                this.wov.bZy();
            }
        }
    }

    public interface b {
        void bZy();
    }

    static /* synthetic */ String a(ShareImgUI shareImgUI, Uri uri) {
        String scheme = uri.getScheme();
        if (bg.mA(scheme)) {
            w.e("MicroMsg.ShareImgUI", "input uri error. %s", new Object[]{uri});
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            w.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else if (scheme.equalsIgnoreCase("content")) {
            w.i("MicroMsg.ShareImgUI", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
            Cursor query = shareImgUI.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                w.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor is null");
                return null;
            } else if (query.getCount() <= 0 || !query.moveToFirst()) {
                query.close();
                w.e("MicroMsg.ShareImgUI", "getFilePath : fail, cursor getCount is 0 or moveToFirst fail");
                return null;
            } else {
                String toLowerCase = uri.toString().toLowerCase();
                if (toLowerCase.startsWith("content://com.android.contacts/contacts/as_vcard") || toLowerCase.startsWith("content://com.android.contacts/contacts/as_multi_vcard") || toLowerCase.startsWith("content://com.mediatek.calendarimporter") || ((shareImgUI.intent != null && shareImgUI.intent.getType().equals("text/x-vcalendar")) || p.gRl.gQe == 1)) {
                    return shareImgUI.a(uri, query);
                }
                query.close();
                return bg.f(shareImgUI, uri);
            }
        } else {
            w.e("MicroMsg.ShareImgUI", "unknown scheme");
            return null;
        }
    }

    static /* synthetic */ void b(ShareImgUI shareImgUI) {
        if (shareImgUI.isv != null && shareImgUI.isv.isShowing()) {
            shareImgUI.isv.dismiss();
        }
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected final boolean aPd() {
        if (ap.za() && !ap.uP()) {
            return false;
        }
        w.w("MicroMsg.ShareImgUI", "not login");
        this.intent = getIntent();
        Pr();
        return true;
    }

    protected final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b bVar, Intent intent) {
        switch (AnonymousClass4.jPl[bVar.ordinal()]) {
            case 1:
                this.intent = intent;
                w.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[]{Integer.valueOf(bg.getInt(g.sV().getValue("SystemShareControlBitset"), 0))});
                if ((bg.getInt(g.sV().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    w.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    return;
                }
                w.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[]{s.i(intent, "android.intent.extra.TEXT")});
                if (bg.mA(s.i(intent, "android.intent.extra.TEXT"))) {
                    Pr();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                ap.vd().a(1200, this);
                ap.vd().a(new ah(format, 15, null), 0);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.eN(this);
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1200, this);
    }

    private void Pr() {
        if (this.intent == null) {
            w.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            Ce(0);
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (bg.mA(action)) {
            w.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            Ce(0);
            finish();
            return;
        }
        this.text = s.i(this.intent, "android.intent.extra.TEXT");
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!bg.l(this.uri)) {
                    w.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                    Ce(0);
                    finish();
                    return;
                }
            }
        }
        String i;
        if (action.equals("android.intent.action.SEND")) {
            w.i("MicroMsg.ShareImgUI", "send signal: " + action);
            if (this.uri == null) {
                boolean z;
                Intent intent = getIntent();
                if (intent == null) {
                    w.e("MicroMsg.ShareImgUI", "intent is null");
                    z = false;
                } else {
                    i = s.i(intent, "android.intent.extra.TEXT");
                    if (i == null || i.length() == 0) {
                        w.i("MicroMsg.ShareImgUI", "text is null");
                        z = false;
                    } else {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(i));
                        wXMediaMessage.description = i;
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        bundle.putInt(ConstantsAPI.SDK_VERSION, 620757000);
                        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(this, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!ap.za() || ap.uP()) {
                            w.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                        } else {
                            startActivity(intent);
                        }
                        z = true;
                    }
                }
                w.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    Ce(0);
                }
                finish();
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this, this.uri, new b(this) {
                final /* synthetic */ ShareImgUI wou;

                {
                    this.wou = r1;
                }

                public final void bZy() {
                    this.wou.handler.sendEmptyMessage(0);
                }
            }), "ShareImgUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            w.i("MicroMsg.ShareImgUI", "send multi: " + action);
            this.wkD = af(extras);
            if (this.wkD == null || this.wkD.size() == 0) {
                w.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                Ce(1);
                finish();
                return;
            }
            Iterator it = this.wkD.iterator();
            while (it.hasNext()) {
                i = (String) it.next();
                if (Ui(i)) {
                    if (o.Pj(i)) {
                    }
                }
                w.i("MicroMsg.ShareImgUI", "%s is not image", new Object[]{i});
                Ce(1);
                finish();
                return;
            }
            i = getIntent().resolveType(this);
            if (i == null || !i.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                w.i("MicroMsg.ShareImgUI", "mime type is no timage, try to set it");
                getIntent().setDataAndType(getIntent().getData(), "image/*");
            }
            bZS();
        } else {
            w.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            Ce(0);
            finish();
        }
    }

    private void bZS() {
        Intent intent = getIntent();
        int Uj = Uj(intent.resolveType(this));
        if (Uj == 0 && o.Pj(this.filePath)) {
            w.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            Uj = 5;
        }
        w.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d, text:%s", new Object[]{this.filePath, Integer.valueOf(Uj), this.text});
        if (Uj == -1) {
            w.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            finish();
        } else if (!bg.mA(this.filePath) && bg.Ql(this.filePath) && !Ui(this.filePath)) {
            w.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            Ce(0);
            finish();
        } else if (Uj == 3 && !bg.mA(this.filePath)) {
            Up(this.filePath);
            finish();
        } else if (this.text == null || Uj != 0 || bg.mA(this.filePath)) {
            if (Uj == 5 && !bg.mA(this.filePath)) {
                if (com.tencent.mm.a.e.aN(this.filePath) > com.tencent.mm.i.b.sC()) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.aN(this.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    bZU();
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(this.filePath, options) != null && options.outHeight > com.tencent.mm.i.b.sB()) || options.outWidth > com.tencent.mm.i.b.sB()) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.aN(this.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    bZU();
                    return;
                }
            }
            if (!s.a(getIntent(), "Intro_Switch", false) && ap.za() && !ap.uP()) {
                intent.setData(this.uri);
                intent.setClass(this, MsgRetransmitUI.class);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864);
                intent.putExtra("Retr_File_Name", this.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", this.wkD);
                intent.putExtra("Retr_Msg_Type", Uj);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                startActivity(intent);
            } else if (!bZT()) {
                Ce(0);
            }
            finish();
        } else {
            Up(this.filePath);
            finish();
        }
    }

    private boolean bZT() {
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (bg.mA(this.filePath)) {
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction()) || bg.bV(this.wkD)) {
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.wkD.size());
            Iterator it = this.wkD.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
        return true;
    }

    private ArrayList<String> af(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            w.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                w.e("MicroMsg.ShareImgUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!bg.l(uri) || uri.getScheme() == null) {
                    w.e("MicroMsg.ShareImgUI", "unaccepted uri: " + uri);
                } else {
                    String f = bg.f(this, uri);
                    if (!bg.mA(f)) {
                        if (bg.Ql(f) && Ui(f)) {
                            w.i("MicroMsg.ShareImgUI", "multisend file path: " + f);
                            arrayList.add(f);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        w.w("MicroMsg.ShareImgUI", "multisend tries to send illegal img: " + f);
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
            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, 3, decodeResultLogger));
        }
        return a;
    }

    private void Up(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
        } else if (bg.Qk(str)) {
            String str2 = "";
            int aN = com.tencent.mm.a.e.aN(str);
            w.i("MicroMsg.ShareImgUI", "filelength: [%d]", new Object[]{Integer.valueOf(aN)});
            if (aN == 0) {
                w.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
            } else if (aN > 10485760) {
                w.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", new Object[]{Integer.valueOf(aN), str});
                Toast.makeText(this, R.l.eWm, 1).show();
            } else {
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
                wXMediaMessage.title = new File(str).getName();
                if (str2.length() > 0) {
                    wXMediaMessage.description = str2;
                } else {
                    wXMediaMessage.description = bg.ay((long) aN);
                }
                if (aN < 30720) {
                    wXMediaMessage.thumbData = com.tencent.mm.a.e.c(str, 0, -1);
                } else {
                    w.i("MicroMsg.ShareImgUI", "thumb data is exceed 30k, ignore");
                }
                Req req = new Req();
                req.transaction = null;
                req.message = wXMediaMessage;
                Bundle bundle = new Bundle();
                req.toBundle(bundle);
                bundle.putInt(ConstantsAPI.SDK_VERSION, 620757000);
                bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                Intent intent = new Intent();
                intent.setClass(this, SelectConversationUI.class);
                intent.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                if (!ap.za() || ap.uP()) {
                    w.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                    MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                    return;
                }
                startActivity(intent);
            }
        } else {
            w.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
        }
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        IOException e2;
        Exception e3;
        FileOutputStream fileOutputStream2 = null;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    w.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", new Object[]{e4.getMessage()});
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                w.i("MicroMsg.ShareImgUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                try {
                    w.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            throw th;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e2 = e8;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                w.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e10) {
                e3 = e10;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                w.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                w.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e11) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            try {
                fileInputStream = openAssetFileDescriptor.createInputStream();
                try {
                    ap.yY();
                    if (c.isSDCardAvailable()) {
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
                        fileOutputStream = new FileOutputStream(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        fileOutputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    fileOutputStream = null;
                    w.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e13) {
                    e2 = e13;
                    fileOutputStream = null;
                    w.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e3 = e14;
                    fileOutputStream = null;
                    w.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    w.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 5120);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e15) {
                            return str;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream == null) {
                        return str;
                    }
                    fileOutputStream.close();
                    return str;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    w.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e17) {
                    e2 = e17;
                    w.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e18) {
                    e3 = e18;
                    w.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    w.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                fileOutputStream = null;
                fileInputStream = null;
                w.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (IOException e20) {
                e2 = e20;
                fileOutputStream = null;
                fileInputStream = null;
                w.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e21) {
                e3 = e21;
                fileOutputStream = null;
                fileInputStream = null;
                w.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                w.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return null;
    }

    private static int Uj(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            return 5;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            return 0;
        }
        if (toLowerCase.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return 1;
        }
        w.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
        return 3;
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

    private void bZU() {
        Toast.makeText(this, R.l.ecw, 1).show();
        finish();
    }

    private void showDialog() {
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ ShareImgUI wou;

            {
                this.wou = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.wou.finish();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ap.vd().b(1200, this);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (i == 0 && i2 == 0) {
            Pr();
        } else {
            finish();
        }
    }
}
