package com.tencent.mm.modelrecovery;

import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService extends AbstractResultService {
    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public final void a(a aVar) {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", new Object[]{aVar});
        CommonOptions fq = OptionFactory.fq(this);
        ArrayList arrayList = new ArrayList();
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.mry = fq.mry;
        recoveryHandleItem.clientVersion = fq.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.arH = "KeyPatchResultTotalCount";
        if (aVar.fHO) {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            recoveryHandleItem.arH = "KeyPatchResultSuccessCount";
        } else {
            RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
            if (aVar.wQl != null) {
                RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", new Object[]{aVar.wQl.getMessage()});
                recoveryHandleItem.arH = String.format("%s[%s]", new Object[]{"KeyPatchResultFailCount", aVar.wQl.getMessage()});
            } else {
                recoveryHandleItem.arH = "KeyPatchResultFailCount";
            }
        }
        arrayList.add(recoveryHandleItem);
        RecoveryLogic.a(this, arrayList, WXRecoveryUploadService.class.getName());
        stopSelf();
    }
}
