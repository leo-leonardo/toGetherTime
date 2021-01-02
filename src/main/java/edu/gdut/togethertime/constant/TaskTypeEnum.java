package edu.gdut.togethertime.constant;

public enum TaskTypeEnum {
    ALL("ALL"), WEEKLY("WEEKLY"), TEMP("TEMP");

    private String type;

    TaskTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
