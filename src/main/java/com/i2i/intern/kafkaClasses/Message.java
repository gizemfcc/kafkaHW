package com.i2i.intern.kafkaClasses;

import java.io.Serializable;

public class Message implements Serializable {
    private int operand;
    private String operation;

    public int getOperand() {
        return operand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Message(" + operand + ", " + operation + ")";
    }
}
