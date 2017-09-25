package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

@a(7)
public class WebViewStubTempUI extends MMActivity implements android.support.v4.app.a.a, MMActivity.a {
    private int sak = 0;
    private boolean sal = false;
    private Dialog sam = null;

    private static final class StartActivityForResultTask implements Parcelable {
        public static final Creator<StartActivityForResultTask> CREATOR = new Creator<StartActivityForResultTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartActivityForResultTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartActivityForResultTask[i];
            }
        };
        int fFR;
        String peA;
        int rYc;
        String sar;
        Intent sas;
        boolean sat;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.peA);
            parcel.writeString(this.sar);
            parcel.writeParcelable(this.sas, i);
            parcel.writeInt(this.fFR);
            parcel.writeByte(this.sat ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.rYc);
        }

        StartActivityForResultTask() {
        }

        StartActivityForResultTask(Parcel parcel) {
            this.peA = parcel.readString();
            this.sar = parcel.readString();
            this.sas = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.fFR = parcel.readInt();
            this.sat = parcel.readByte() != (byte) 0;
            this.rYc = parcel.readInt();
        }
    }

    public static void a(Context context, String str, String str2, Intent intent, int i) {
        Intent intent2 = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        intent2.putExtra("key_action_code", 2);
        Parcelable startActivityForResultTask = new StartActivityForResultTask();
        startActivityForResultTask.peA = str;
        startActivityForResultTask.sar = str2;
        startActivityForResultTask.sas = intent;
        startActivityForResultTask.fFR = 15;
        startActivityForResultTask.sat = false;
        startActivityForResultTask.rYc = i;
        intent2.putExtra("key_activity_result_task", startActivityForResultTask);
        context.startActivity(intent2);
    }

    public static void a(Context context, e eVar, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2) {
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        if (context instanceof Service) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        intent.putExtra("key_action_code", 0);
        intent.putExtra("key_alert_cancelable", false);
        intent.putExtra("key_alert_message", str);
        intent.putExtra("key_alert_title", str2);
        intent.putExtra("key_alert_yes", str3);
        intent.putExtra("key_alert_no", str4);
        intent.putExtra("key_alert_result_receiver", new ResultReceiver(ae.fetchFreeHandler()) {
            protected final void onReceiveResult(int i, Bundle bundle) {
                switch (i) {
                    case 0:
                        onClickListener.onClick(null, 0);
                        return;
                    case 1:
                        onClickListener2.onClick(null, 0);
                        return;
                    default:
                        return;
                }
            }
        });
        d.a(intent.getExtras(), "webview", ".stub.WebViewStubTempUI", eVar, null);
    }

    public static boolean a(Context context, e eVar, String[] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (android.support.v4.content.a.d(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_code", 1);
        bundle.putStringArray("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        bundle.putInt("key_permission_request_code", 116);
        bundle.putInt("key_binder_id", i);
        d.a(bundle, "webview", ".stub.WebViewStubTempUI", eVar, null);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                final ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    return;
                }
                this.sam = g.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new OnClickListener(this) {
                    final /* synthetic */ WebViewStubTempUI saq;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        resultReceiver.send(0, null);
                        this.saq.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ WebViewStubTempUI saq;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        resultReceiver.send(1, null);
                        this.saq.finish();
                    }
                });
                this.sam.setOnCancelListener(new OnCancelListener(this) {
                    final /* synthetic */ WebViewStubTempUI saq;

                    {
                        this.saq = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.saq.finish();
                    }
                });
                return;
            case 1:
                android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.sak = startActivityForResultTask.rYc;
                this.sal = true;
                this.uSV = this;
                com.tencent.mm.bb.d.a(this, startActivityForResultTask.peA, startActivityForResultTask.sar, startActivityForResultTask.sas, startActivityForResultTask.fFR, startActivityForResultTask.sat);
                return;
            default:
                finish();
                return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sam != null) {
            this.sam.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] != 0) {
                    h.wH(intExtra).a(i, 0, null);
                    break;
                } else {
                    h.wH(intExtra).a(i, -1, null);
                    break;
                }
        }
        finish();
    }

    public final void a(int i, int i2, Intent intent) {
        if (this.sal) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g wH = h.wH(this.sak);
            if (wH != null) {
                wH.a(i, i2, intent);
            }
        }
        finish();
    }

    public final int getLayoutId() {
        return -1;
    }
}
