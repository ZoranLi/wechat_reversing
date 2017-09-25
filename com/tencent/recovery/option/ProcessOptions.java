package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions {
    public int jbJ;
    public Express wQA;

    public static final class Builder {
        private int jbJ;
        public Express wQA;

        public final Builder cdC() {
            this.jbJ = 10000;
            return this;
        }

        public final ProcessOptions cdD() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.jbJ = this.jbJ;
            processOptions.wQA = this.wQA;
            return processOptions;
        }
    }
}
