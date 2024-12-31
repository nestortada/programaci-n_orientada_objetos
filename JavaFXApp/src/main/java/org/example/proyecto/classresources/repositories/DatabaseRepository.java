package org.example.proyecto.classresources.repositories;

import org.example.proyecto.classresources.persistence.FileManage;

public class DatabaseRepository {
    protected FileManage fileManage;

    public DatabaseRepository(String fileName) {
        this.fileManage = new FileManage(fileName);
    }
}
