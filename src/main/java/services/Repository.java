package services;

import entities.EntityTable;

public interface Repository {
    void add(EntityTable entityTable);
    void delete(long id);
    EntityTable get(long id);
    void update(EntityTable entityTable);
}
