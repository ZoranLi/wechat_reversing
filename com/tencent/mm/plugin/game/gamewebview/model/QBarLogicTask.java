package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public class QBarLogicTask extends GWMainProcessTask {
    public static final Creator<QBarLogicTask> CREATOR = new Creator<QBarLogicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QBarLogicTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QBarLogicTask[i];
        }
    };
    private static c gVr = new c<ly>() {
        {
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ly lyVar = (ly) bVar;
            w.d("MicroMsg.QBarLogicTask", "mRecogResultListener");
            if ((lyVar instanceof ly) && (QBarLogicTask.mlH == null || QBarLogicTask.mlH.containsKey(lyVar.fTe.filePath))) {
                if (QBarLogicTask.mlH != null) {
                    QBarLogicTask.mlH.remove(lyVar.fTe.filePath);
                }
                w.d("MicroMsg.QBarLogicTask", "result: " + lyVar.fTe.result);
                Bundle bundle = new Bundle();
                bundle.putInt("mm_to_client_notify_type", 2);
                bundle.putString("file_path", lyVar.fTe.filePath);
                bundle.putString("result", lyVar.fTe.result);
                bundle.putInt("code_type", lyVar.fTe.fFo);
                bundle.putInt("code_version", lyVar.fTe.fFp);
                a.x(bundle);
            }
            return false;
        }
    };
    public static Map<String, Integer> mlH;
    public String fOa;
    public int type;

    public final void PM() {
        String str;
        b lwVar;
        switch (this.type) {
            case 1:
                str = this.fOa;
                if (mlH == null) {
                    mlH = new HashMap();
                    com.tencent.mm.sdk.b.a.urY.b(gVr);
                }
                lwVar = new lw();
                lwVar.fTb.filePath = str;
                com.tencent.mm.sdk.b.a.urY.m(lwVar);
                mlH.put(str, Integer.valueOf(1));
                return;
            case 2:
                str = this.fOa;
                if (mlH == null || !mlH.containsKey(str)) {
                    w.e("MicroMsg.QBarLogicTask", "%s is not recognizing", new Object[]{str});
                    return;
                }
                lwVar = new ak();
                lwVar.fDL.filePath = str;
                com.tencent.mm.sdk.b.a.urY.m(lwVar);
                mlH.remove(str);
                return;
            default:
                return;
        }
    }

    public final void SK() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fOa = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.fOa);
    }

    public QBarLogicTask(Parcel parcel) {
        f(parcel);
    }
}
