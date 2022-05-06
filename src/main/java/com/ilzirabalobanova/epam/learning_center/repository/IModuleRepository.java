package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Module;

import java.util.List;

public interface IModuleRepository {

    List<Module> findAllModulesByProgramId(int programId);

    boolean addModule(Module module);

    boolean deleteModule(int moduleId);

    Module findModuleById(int moduleId);
}
