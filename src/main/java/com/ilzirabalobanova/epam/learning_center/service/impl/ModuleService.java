package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.IModuleRepository;
import com.ilzirabalobanova.epam.learning_center.service.IModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService implements IModuleService {
    private final Logger logger = LoggerFactory.getLogger(ModuleService.class);
    private final IModuleRepository moduleRepository;

    @Autowired
    public ModuleService(IModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<Module> findAllModulesByProgramId(int programId) {
        return moduleRepository.findAllModulesByProgramId(programId);
    }

    @Override
    public boolean addModule(Module module) {
        boolean result = moduleRepository.addModule(module);
        if (!result) {
            logger.error("Ошибка в добавлении модуля");
        }
        return result;
    }

    @Override
    public boolean deleteModule(int moduleId) {
        boolean result = moduleRepository.deleteModule(moduleId);
        if (!result) {
            logger.error("Ошибка в удалении модуля");
        }
        return result;
    }
}
