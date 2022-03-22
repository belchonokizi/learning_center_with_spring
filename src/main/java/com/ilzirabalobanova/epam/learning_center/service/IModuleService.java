package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Module;

import java.util.List;

public interface IModuleService {

    List<Module> findAllModulesByProgramId(int programId, String path);

    boolean addModule(Module module, String path);

    boolean deleteModule(int moduleId, String path);
}
