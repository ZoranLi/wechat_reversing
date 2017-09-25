package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.u.ap;

public final class ReportUtil {

    public static class ReportArgs implements Parcelable {
        public static final Creator<ReportArgs> CREATOR = new Creator<ReportArgs>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ReportArgs(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportArgs[i];
            }
        };
        public int errCode;
        public String openId;
        public int ou;
        public String transaction;
        public String uq;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uq);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.transaction);
            parcel.writeString(this.openId);
        }

        public ReportArgs(Parcel parcel) {
            this.uq = parcel.readString();
            this.errCode = parcel.readInt();
            this.transaction = parcel.readString();
            this.openId = parcel.readString();
        }
    }

    public static void a(Context context, ReportArgs reportArgs) {
        if (reportArgs.ou == 1) {
            Resp resp = new Resp();
            resp.transaction = reportArgs.transaction;
            resp.errCode = reportArgs.errCode;
            resp.openId = reportArgs.openId;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.aa(bundle);
            Args args = new Args();
            args.targetPkgName = reportArgs.uq;
            args.bundle = bundle;
            MMessageActV2.send(context, args);
            return;
        }
        SendMessageToWX.Resp resp2 = new SendMessageToWX.Resp();
        resp2.errCode = reportArgs.errCode;
        resp2.transaction = reportArgs.transaction;
        resp2.openId = reportArgs.openId;
        bundle = new Bundle();
        resp2.toBundle(bundle);
        p.aa(bundle);
        args = new Args();
        args.targetPkgName = reportArgs.uq;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
    }

    public static ReportArgs b(Bundle bundle, int i) {
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString(ConstantsAPI.CONTENT);
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = s.i(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                return null;
            }
        }
        c fVar = new f();
        fVar.field_appId = string;
        if (ap.za() && ap.zb()) {
            an.aRr().b(fVar, new String[0]);
        } else {
            fVar.field_packageName = bundle.getString(ConstantsAPI.APP_PACKAGE);
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.uq = fVar.field_packageName;
        reportArgs.errCode = i;
        Req req = new Req();
        req.fromBundle(bundle);
        reportArgs.transaction = req.transaction;
        reportArgs.openId = fVar.field_openId;
        reportArgs.ou = bundle.getInt("_wxapi_command_type");
        return reportArgs;
    }
}
