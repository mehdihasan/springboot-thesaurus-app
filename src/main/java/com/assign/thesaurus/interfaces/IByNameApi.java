package com.assign.thesaurus.interfaces;

public interface IByNameApi <T extends IWithName> {
    T findByName(final String name);
}
