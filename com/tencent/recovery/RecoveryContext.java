package com.tencent.recovery;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class RecoveryContext {
    public ArrayList<RecoveryStatusItem> wQb = new ArrayList();

    protected final void clear() {
        RecoveryLog.i("Recovery.RecoveryContext", "clear", new Object[0]);
        this.wQb.clear();
    }

    protected final void f(SharedPreferences sharedPreferences) {
        if (sharedPreferences.contains("KeyHistoryExceptionTypeList")) {
            String[] split = sharedPreferences.getString("KeyHistoryExceptionTypeList", "").split(";");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
                    if (recoveryStatusItem.UY(str)) {
                        this.wQb.add(recoveryStatusItem);
                    }
                }
            }
        }
        RecoveryLog.i("Recovery.RecoveryContext", "RecoveryContext readFromSp %s", toString());
    }

    protected final void a(Editor editor) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.wQb.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((RecoveryStatusItem) it.next()).cdz());
            stringBuffer.append(";");
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() > 0) {
            editor.putString("KeyHistoryExceptionTypeList", stringBuffer.toString());
        } else {
            editor.remove("KeyHistoryExceptionTypeList");
        }
        RecoveryLog.i("Recovery.RecoveryContext", "RecoveryContext saveToSp %s", toString());
    }

    public final String toString() {
        return this.wQb.toString();
    }
}
