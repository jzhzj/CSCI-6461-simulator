package com.gwu.cs6461.services.romloader;

import org.apache.commons.lang3.StringUtils;

public class RomData {

    private String name;
    private String value;
    private Op op;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {

        if (StringUtils.isEmpty(value)) {
            return StringUtils.join(op.getOp_code(), op.getData());
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Op getOp() {
        return op;
    }

    public void setOp(Op op) {
        this.op = op;
    }


    protected class Op {
        private String op_code;
        private String data;
        private String desc;

        public String getOp_code() {
            return op_code;
        }

        public void setOp_code(String op_code) {
            this.op_code = op_code;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }


    }
}
