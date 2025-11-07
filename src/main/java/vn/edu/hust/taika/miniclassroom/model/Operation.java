package vn.edu.hust.taika.miniclassroom.model;

import lombok.Getter;

@Getter
public enum Operation {
    CREATE("001"),
    UPDATE("002"),
    DELETE("003"),
    READ("004"),

    ADD_STUDENT("005"),
    VIEW_STUDENTS("006"),
    CREATE_CLASS("007"),
    DELETE_CLASS("008");

    //TODO(add more permission)

    private final String operationCode;

    Operation(String operationCode) {
        this.operationCode = operationCode;
    }
}
