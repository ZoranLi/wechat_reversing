package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    String filePath = null;
    private ae handler = new ae(this) {
        final /* synthetic */ ShareScreenImgUI wow;

        {
            this.wow = r1;
        }

        public final void handleMessage(Message message) {
            ShareScreenImgUI.a(this.wow);
            if (bg.mA(this.wow.filePath)) {
                w.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                this.wow.bZx();
                this.wow.finish();
                return;
            }
            this.wow.bZS();
        }
    };
    private Intent intent = null;
    private ProgressDialog isv = null;
    Uri uri = null;

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        if (shareScreenImgUI.isv != null && shareScreenImgUI.isv.isShowing()) {
            shareScreenImgUI.isv.dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP("");
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
                w.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void KC() {
        this.intent = getIntent();
        if (this.intent == null) {
            w.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            bZx();
            finish();
            return;
        }
        w.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (bg.mA(action)) {
            w.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            bZx();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            w.i("MicroMsg.ShareScreenImgUI", "send signal: " + action);
            if (this.uri == null || !bg.l(this.uri)) {
                w.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                bZx();
                finish();
                return;
            }
            getString(R.l.dIO);
            this.isv = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ ShareScreenImgUI wow;

                {
                    this.wow = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.filePath = bg.f(this, this.uri);
            if (!bg.mA(this.filePath)) {
                action = this.filePath;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                boolean a = o.a(action, decodeResultLogger);
                if (!a && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(action, 3, decodeResultLogger));
                }
                if (a) {
                    bZS();
                    return;
                }
            }
            w.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            bZx();
            finish();
        } else {
            w.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            bZx();
            finish();
        }
    }

    private void bZS() {
        int i;
        w.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[]{this.filePath});
        Intent intent = getIntent();
        String resolveType = intent.resolveType(this);
        if (resolveType == null || resolveType.length() == 0) {
            w.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            i = -1;
        } else if (resolveType.toLowerCase().contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            i = 0;
        } else {
            w.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
            i = 3;
        }
        if (i == -1) {
            w.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            return;
        }
        if (!s.a(getIntent(), "Intro_Switch", false) && ap.za() && !ap.uP()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", i);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (bg.mA(this.filePath)) {
            bZx();
        } else {
            Intent intent2 = new Intent(this, ShareImgUI.class);
            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent2.addFlags(67108864);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent2);
        }
        finish();
    }

    private void bZx() {
        Toast.makeText(this, R.l.eWn, 1).show();
    }
}
