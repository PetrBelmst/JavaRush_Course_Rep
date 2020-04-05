package com.company;

public enum Operation {

    CREATE ("упаковать файлы в архив"),
    ADD ("добавить файл в архив"),
    REMOVE ("удалить файл из архива"),
    EXTRACT ("распаковать архив"),
    CONTENT ("просмотреть содержимое архива"),
    EXIT ("выход");

    private String consequence;

    Operation(String consequence){
        this.consequence = consequence;
    }

    public String getConsequence() {
        return this.consequence;
    }
}