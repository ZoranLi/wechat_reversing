package com.tencent.recovery.config;

import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.util.AttributeUtil;
import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> wQe = new ArrayList();

    public String toString() {
        return this.wQe.toString();
    }

    public final void cX(List<ExpressItem> list) {
        this.wQe.add(list);
    }

    public final boolean cY(List<RecoveryStatusItem> list) {
        for (List<ExpressItem> it : this.wQe) {
            boolean z;
            for (ExpressItem expressItem : it) {
                int i = 0;
                for (RecoveryStatusItem recoveryStatusItem : list) {
                    if (AttributeUtil.ee(expressItem.wQd, recoveryStatusItem.wQd) && AttributeUtil.ee(expressItem.wQf, recoveryStatusItem.wQf) && AttributeUtil.ee(expressItem.wQg, recoveryStatusItem.wQg)) {
                        i++;
                    }
                }
                if (expressItem.count > i) {
                    z = false;
                    continue;
                    break;
                }
            }
            z = true;
            continue;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
