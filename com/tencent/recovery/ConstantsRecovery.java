package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery {

    public static final class DefaultCommonOptions {
        public static final CommonOptions wPM;

        static {
            Builder builder = new Builder();
            builder.mry = "";
            builder.clientVersion = "";
            builder.wQq = "";
            builder.wQu = "";
            builder.wQv = "";
            wPM = builder.cdA();
        }
    }

    public static final class DefaultExpress {
        public static final Express wPN = new Express();
        public static final Express wPO = new Express();
        public static final Express wPP = new Express();

        static {
            List arrayList = new ArrayList();
            arrayList.add(new ExpressItem(17, 1114112));
            wPN.cX(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1118208));
            wPO.cX(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1114112));
            wPP.cX(arrayList);
        }
    }

    public static final class DefaultProcessOptions {
        public static final ProcessOptions wPQ;
        public static final ProcessOptions wPR;
        public static final ProcessOptions wPS;

        static {
            ProcessOptions.Builder builder = new ProcessOptions.Builder();
            builder.wQA = DefaultExpress.wPN;
            builder.cdC();
            wPQ = builder.cdD();
            builder = new ProcessOptions.Builder();
            builder.wQA = DefaultExpress.wPO;
            builder.cdC();
            wPR = builder.cdD();
            builder = new ProcessOptions.Builder();
            builder.wQA = DefaultExpress.wPP;
            builder.cdC();
            wPS = builder.cdD();
        }
    }

    public static final class IntentAction {
    }

    public static final class IntentKeys {
    }

    public static final class Message {
    }

    public static final class ProcessStage {
    }

    public static final class ProcessStartFlag {
    }

    public static final class ProcessStatus {
    }

    public static final class ReportType {
    }

    public static final class SpKeys {
    }
}
